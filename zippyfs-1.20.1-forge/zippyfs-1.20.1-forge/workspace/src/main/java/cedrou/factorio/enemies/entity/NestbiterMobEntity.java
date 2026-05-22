
package cedrou.factorio.enemies.entity;

import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.sounds.SoundEvent;

import cedrou.factorio.enemies.init.FactorioEnemiesModEntities;

import java.util.List;

public class NestbiterMobEntity extends Monster {

    private static final EntityDataAccessor<Integer> TIER =
            SynchedEntityData.defineId(NestbiterMobEntity.class, EntityDataSerializers.INT);

    private static final int TERRITORY_RADIUS = 64;
    private static final int MAX_BITERS = 10;
    private static final int NORMAL_SPAWN_INTERVAL = 100;
    private static final int AGGRO_SPAWN_INTERVAL = 20;
    private static final int AGGRO_DURATION = 1200;

    private int spawnTimer = 0;
    private boolean aggroed = false;
    private int aggroTimer = 0;

    public NestbiterMobEntity(PlayMessages.SpawnEntity packet, Level world) {
        this(FactorioEnemiesModEntities.NESTBITER_MOB.get(), world);
    }

    public NestbiterMobEntity(EntityType<NestbiterMobEntity> type, Level world) {
        super(type, world);
        setMaxUpStep(0f);
        xpReward = 0;
        setNoAi(false);
        setPersistenceRequired();
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(TIER, 0);
    }

    public int getTier() {
        return this.entityData.get(TIER);
    }

    public void setTier(int tier) {
        this.entityData.set(TIER, tier);
    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<Player>(this, Player.class, false, true) {
            @Override
            public boolean canUse() {
                Player nearest = NestbiterMobEntity.this.level().getNearestPlayer(
                        NestbiterMobEntity.this.getX(), NestbiterMobEntity.this.getY(), NestbiterMobEntity.this.getZ(),
                        TERRITORY_RADIUS, false);
                return nearest != null && super.canUse();
            }
        });
    }

    @Override
    public MobType getMobType() {
        return MobType.UNDEFINED;
    }

    @Override
    public boolean removeWhenFarAway(double distanceToClosestPlayer) {
        return false;
    }

    @Override
    public SoundEvent getAmbientSound() {
        return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("factorio_enemies:spawner-vie"));
    }

    @Override
    public SoundEvent getHurtSound(DamageSource ds) {
        return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("factorio_enemies:spawner-destruction-2"));
    }

    @Override
    public SoundEvent getDeathSound() {
        return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("factorio_enemies:spawner-destruction"));
    }

    @Override
    public float getSoundVolume() {
        return 0.4f;
    }

    @Override
    public boolean hurt(DamageSource damagesource, float amount) {
        boolean result = super.hurt(damagesource, amount);
        if (result) {
            aggro();
            alertNearbyNests(damagesource.getEntity());
        }
        return result;
    }

    public void aggro() {
        aggroed = true;
        aggroTimer = 0;
    }

    public void alertNearbyNests(Entity attacker) {
        AABB searchBox = new AABB(
                this.getX() - TERRITORY_RADIUS, this.getY() - TERRITORY_RADIUS, this.getZ() - TERRITORY_RADIUS,
                this.getX() + TERRITORY_RADIUS, this.getY() + TERRITORY_RADIUS, this.getZ() + TERRITORY_RADIUS);

        List<NestbiterMobEntity> biterNests = this.level().getEntitiesOfClass(NestbiterMobEntity.class, searchBox,
                e -> e != this);
        for (NestbiterMobEntity nest : biterNests) {
            nest.aggro();
        }

        List<NestspittersMobEntity> spitterNests = this.level().getEntitiesOfClass(NestspittersMobEntity.class, searchBox,
                e -> true);
        for (NestspittersMobEntity nest : spitterNests) {
            nest.aggro();
        }
    }

    @Override
    public void tick() {
        super.tick();
        if (!this.level().isClientSide()) {
            Player nearestPlayer = this.level().getNearestPlayer(
                    this.getX(), this.getY(), this.getZ(), TERRITORY_RADIUS, false);

            if (nearestPlayer != null && this.getTarget() == null) {
                this.setTarget(nearestPlayer);
            }

            if (nearestPlayer != null && !aggroed) {
                aggro();
            }

            if (aggroed) {
                aggroTimer++;
                if (aggroTimer >= AGGRO_DURATION) {
                    aggroed = false;
                    aggroTimer = 0;
                }
            }

            spawnTimer++;
            int interval = aggroed ? AGGRO_SPAWN_INTERVAL : NORMAL_SPAWN_INTERVAL;
            if (spawnTimer >= interval) {
                spawnTimer = 0;
                if (nearestPlayer != null) {
                    spawnBiters();
                }
            }
        }
    }

    private void spawnBiters() {
        if (!(this.level() instanceof ServerLevel serverLevel)) return;

        AABB searchBox = new AABB(
                this.getX() - TERRITORY_RADIUS, this.getY() - TERRITORY_RADIUS, this.getZ() - TERRITORY_RADIUS,
                this.getX() + TERRITORY_RADIUS, this.getY() + TERRITORY_RADIUS, this.getZ() + TERRITORY_RADIUS);

        int biterCount = serverLevel.getEntitiesOfClass(SmallbiterEntity.class, searchBox).size()
                + serverLevel.getEntitiesOfClass(MediumbiterEntity.class, searchBox).size()
                + serverLevel.getEntitiesOfClass(BigbiterEntity.class, searchBox).size()
                + serverLevel.getEntitiesOfClass(BehemothbiterEntity.class, searchBox).size();

        if (biterCount >= MAX_BITERS) return;

        RandomSource random = serverLevel.getRandom();
        int tier = getTier();
        EntityType<?> entityType = getBiterTypeForTier(tier, random);

        double spawnX = this.getX() + (random.nextFloat() * 6f - 3f);
        double spawnY = this.getY() + 1;
        double spawnZ = this.getZ() + (random.nextFloat() * 6f - 3f);

        BlockPos blockPos = BlockPos.containing(spawnX, spawnY, spawnZ);
        entityType.spawn(serverLevel, blockPos, MobSpawnType.MOB_SUMMONED);
    }

    private EntityType<?> getBiterTypeForTier(int tier, RandomSource random) {
        return switch (tier) {
            case 1 -> random.nextBoolean()
                    ? FactorioEnemiesModEntities.SMALLBITER.get()
                    : FactorioEnemiesModEntities.MEDIUMBITER.get();
            case 2 -> FactorioEnemiesModEntities.MEDIUMBITER.get();
            case 3 -> random.nextBoolean()
                    ? FactorioEnemiesModEntities.MEDIUMBITER.get()
                    : FactorioEnemiesModEntities.BIGBITER.get();
            case 4 -> FactorioEnemiesModEntities.BIGBITER.get();
            case 5 -> random.nextBoolean()
                    ? FactorioEnemiesModEntities.BIGBITER.get()
                    : FactorioEnemiesModEntities.BEHEMOTHBITER.get();
            case 6 -> FactorioEnemiesModEntities.BEHEMOTHBITER.get();
            default -> FactorioEnemiesModEntities.SMALLBITER.get();
        };
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putInt("NestTier", getTier());
        tag.putBoolean("Aggroed", aggroed);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        setTier(tag.getInt("NestTier"));
        aggroed = tag.getBoolean("Aggroed");
    }

    public static void init() {
    }

    public static AttributeSupplier.Builder createAttributes() {
        AttributeSupplier.Builder builder = Mob.createMobAttributes();
        builder = builder.add(Attributes.MAX_HEALTH, 50);
        builder = builder.add(Attributes.MOVEMENT_SPEED, 0.0);
        builder = builder.add(Attributes.ARMOR, 2);
        builder = builder.add(Attributes.FOLLOW_RANGE, 64);
        return builder;
    }
}
