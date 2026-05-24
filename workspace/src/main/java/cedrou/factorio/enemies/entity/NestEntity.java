package cedrou.factorio.enemies.entity;

import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;

import cedrou.factorio.enemies.NestProgressData;
import cedrou.factorio.enemies.init.FactorioEnemiesModEntities;

public class NestEntity extends Mob {
    private static final EntityDataAccessor<Integer> TIER =
            SynchedEntityData.defineId(NestEntity.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Boolean> IS_BITER =
            SynchedEntityData.defineId(NestEntity.class, EntityDataSerializers.BOOLEAN);

    private int spawnTimer = 0;
    private boolean aggroed = false;
    private int aggroTimer = 0;
    private boolean hasSpawnedWorm = false;

    private static final int TERRITORY_RADIUS = 64;
    private static final int MAX_MOBS = 5;
    private static final int NORMAL_SPAWN_INTERVAL = 100;
    private static final int AGGRO_SPAWN_INTERVAL = 20;
    private static final int AGGRO_DURATION = 1200;

    public NestEntity(PlayMessages.SpawnEntity packet, Level world) {
        this(FactorioEnemiesModEntities.NEST_ENTITY.get(), world);
    }

    public NestEntity(EntityType<NestEntity> type, Level world) {
        super(type, world);
        this.setPersistenceRequired();
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(TIER, 0);
        this.entityData.define(IS_BITER, true);
    }

    public void init(int tier, boolean isBiter) {
        this.entityData.set(TIER, tier);
        this.entityData.set(IS_BITER, isBiter);
        double maxHealth = 50 + tier * 50;
        this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(maxHealth);
        this.setHealth((float) maxHealth);
    }

    public int getTier() {
        return this.entityData.get(TIER);
    }

    public boolean isBiter() {
        return this.entityData.get(IS_BITER);
    }

    public static AttributeSupplier.Builder createAttributes() {
        AttributeSupplier.Builder builder = Mob.createMobAttributes();
        builder = builder.add(Attributes.MAX_HEALTH, 100);
        builder = builder.add(Attributes.MOVEMENT_SPEED, 0);
        builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 1.0);
        builder = builder.add(Attributes.FOLLOW_RANGE, 0);
        return builder;
    }

    @Override
    protected void registerGoals() {
        // No movement goals — nests are stationary
    }

    @Override
    public boolean isPushable() {
        return false;
    }

    @Override
    public boolean isNoGravity() {
        return false;
    }

    @Override
    public void aiStep() {
        // Don't move
        super.aiStep();
    }

    @Override
    public void tick() {
        super.tick();

        if (this.level().isClientSide()) return;
        if (!(this.level() instanceof ServerLevel sl)) return;
        if (sl.getDifficulty() == Difficulty.PEACEFUL) return;

        // Aggro timer
        if (aggroed) {
            aggroTimer++;
            if (aggroTimer >= AGGRO_DURATION) {
                aggroed = false;
                aggroTimer = 0;
            }
        }

        // Each nest spawns exactly one worm on first activation
        if (!hasSpawnedWorm) {
            hasSpawnedWorm = true;
            EntityType<?> wormType = getWormTypeForTier(getTier());
            RandomSource random = sl.getRandom();
            double wormX = this.getX() + (random.nextFloat() * 10f - 5f);
            double wormZ = this.getZ() + (random.nextFloat() * 10f - 5f);
            wormType.spawn(sl, BlockPos.containing(wormX, this.getY() + 1, wormZ), MobSpawnType.MOB_SUMMONED);
        }

        // Player detection every 10 ticks so re-aggro is near-instant
        if (this.tickCount % 10 == 0) {
            Player nearby = this.level().getNearestPlayer(
                    this.getX(), this.getY(), this.getZ(), TERRITORY_RADIUS, false);
            if (nearby != null && !aggroed) {
                aggroed = true;
                aggroTimer = 0;
                spawnTimer = AGGRO_SPAWN_INTERVAL; // fire immediately on next cycle
            }
        }

        // Spawn timer
        int interval = aggroed ? AGGRO_SPAWN_INTERVAL : NORMAL_SPAWN_INTERVAL;
        spawnTimer++;
        if (spawnTimer < interval) return;
        spawnTimer = 0;

        // Check phase upgrade
        int globalPhase = NestProgressData.get(sl).getPhase();
        if (globalPhase > getTier()) {
            init(globalPhase, isBiter());
            return;
        }

        Player nearestPlayer = this.level().getNearestPlayer(
                this.getX(), this.getY(), this.getZ(), TERRITORY_RADIUS, false);
        if (nearestPlayer == null) return;

        spawnMobs(sl);
    }

    @Override
    public void actuallyHurt(DamageSource source, float amount) {
        super.actuallyHurt(source, amount);
        aggroed = true;
        aggroTimer = 0;
    }

    @Override
    public void die(DamageSource source) {
        super.die(source);
        if (level() instanceof ServerLevel sl) {
            NestProgressData data = NestProgressData.get(sl);
            data.incrementKills(sl);
            data.scheduleRespawn(blockPosition(), getTier(), isBiter(), sl.getGameTime());
        }
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putInt("Tier", getTier());
        tag.putBoolean("IsBiter", isBiter());
        tag.putInt("SpawnTimer", spawnTimer);
        tag.putBoolean("Aggroed", aggroed);
        tag.putInt("AggroTimer", aggroTimer);
        tag.putBoolean("HasSpawnedWorm", hasSpawnedWorm);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        spawnTimer = tag.getInt("SpawnTimer");
        aggroed = tag.getBoolean("Aggroed");
        aggroTimer = tag.getInt("AggroTimer");
        hasSpawnedWorm = tag.getBoolean("HasSpawnedWorm");
        init(tag.getInt("Tier"), tag.getBoolean("IsBiter"));
    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    @Override
    public MobType getMobType() {
        return MobType.UNDEFINED;
    }

    private void spawnMobs(ServerLevel level) {
        AABB searchBox = new AABB(
                this.getX() - TERRITORY_RADIUS, this.getY() - TERRITORY_RADIUS, this.getZ() - TERRITORY_RADIUS,
                this.getX() + TERRITORY_RADIUS, this.getY() + TERRITORY_RADIUS, this.getZ() + TERRITORY_RADIUS);

        int mobCount;
        if (isBiter()) {
            mobCount = level.getEntitiesOfClass(SmallbiterEntity.class, searchBox).size()
                    + level.getEntitiesOfClass(MediumbiterEntity.class, searchBox).size()
                    + level.getEntitiesOfClass(BigbiterEntity.class, searchBox).size()
                    + level.getEntitiesOfClass(BehemothbiterEntity.class, searchBox).size();
        } else {
            mobCount = level.getEntitiesOfClass(SmallspittersEntity.class, searchBox).size()
                    + level.getEntitiesOfClass(MediumspittersEntity.class, searchBox).size()
                    + level.getEntitiesOfClass(BigspittersEntity.class, searchBox).size()
                    + level.getEntitiesOfClass(BehemothspittersEntity.class, searchBox).size();
        }

        if (mobCount >= MAX_MOBS) return;

        RandomSource random = level.getRandom();
        EntityType<?> entityType = isBiter()
                ? getBiterTypeForTier(getTier(), random)
                : getSpitterTypeForTier(getTier(), random);

        double spawnX = this.getX() + (random.nextFloat() * 6f - 3f);
        double spawnY = this.getY() + 1;
        double spawnZ = this.getZ() + (random.nextFloat() * 6f - 3f);

        entityType.spawn(level, BlockPos.containing(spawnX, spawnY, spawnZ), MobSpawnType.MOB_SUMMONED);
    }

    private static EntityType<?> getWormTypeForTier(int tier) {
        return switch (tier) {
            case 2, 3 -> FactorioEnemiesModEntities.MEDIUMWORM.get();
            case 4, 5 -> FactorioEnemiesModEntities.BIGWORM.get();
            case 6    -> FactorioEnemiesModEntities.BEHEMOTHWORM.get();
            default   -> FactorioEnemiesModEntities.SMALLWORM.get();
        };
    }

    private static EntityType<?> getBiterTypeForTier(int tier, RandomSource random) {
        return switch (tier) {
            case 1 -> random.nextBoolean() ? FactorioEnemiesModEntities.SMALLBITER.get() : FactorioEnemiesModEntities.MEDIUMBITER.get();
            case 2 -> FactorioEnemiesModEntities.MEDIUMBITER.get();
            case 3 -> random.nextBoolean() ? FactorioEnemiesModEntities.MEDIUMBITER.get() : FactorioEnemiesModEntities.BIGBITER.get();
            case 4 -> FactorioEnemiesModEntities.BIGBITER.get();
            case 5 -> random.nextBoolean() ? FactorioEnemiesModEntities.BIGBITER.get() : FactorioEnemiesModEntities.BEHEMOTHBITER.get();
            case 6 -> FactorioEnemiesModEntities.BEHEMOTHBITER.get();
            default -> FactorioEnemiesModEntities.SMALLBITER.get();
        };
    }

    private static EntityType<?> getSpitterTypeForTier(int tier, RandomSource random) {
        return switch (tier) {
            case 1 -> random.nextBoolean() ? FactorioEnemiesModEntities.SMALLSPITTERS.get() : FactorioEnemiesModEntities.MEDIUMSPITTERS.get();
            case 2 -> FactorioEnemiesModEntities.MEDIUMSPITTERS.get();
            case 3 -> random.nextBoolean() ? FactorioEnemiesModEntities.MEDIUMSPITTERS.get() : FactorioEnemiesModEntities.BIGSPITTERS.get();
            case 4 -> FactorioEnemiesModEntities.BIGSPITTERS.get();
            case 5 -> random.nextBoolean() ? FactorioEnemiesModEntities.BIGSPITTERS.get() : FactorioEnemiesModEntities.BEHEMOTHSPITTERS.get();
            case 6 -> FactorioEnemiesModEntities.BEHEMOTHSPITTERS.get();
            default -> FactorioEnemiesModEntities.SMALLSPITTERS.get();
        };
    }
}
