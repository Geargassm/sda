package cedrou.factorio.enemies.block;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;

import cedrou.factorio.enemies.entity.BehemothbiterEntity;
import cedrou.factorio.enemies.entity.BehemothspittersEntity;
import cedrou.factorio.enemies.entity.BigbiterEntity;
import cedrou.factorio.enemies.entity.BigspittersEntity;
import cedrou.factorio.enemies.entity.MediumbiterEntity;
import cedrou.factorio.enemies.entity.MediumspittersEntity;
import cedrou.factorio.enemies.entity.SmallbiterEntity;
import cedrou.factorio.enemies.entity.SmallspittersEntity;
import cedrou.factorio.enemies.init.FactorioEnemiesModBlockEntities;
import cedrou.factorio.enemies.init.FactorioEnemiesModEntities;

public class NestBlockEntity extends BlockEntity {
    private int tier;
    private boolean isBiter;
    private int spawnTimer = 0;
    private boolean aggroed = false;
    private int aggroTimer = 0;

    private static final int TERRITORY_RADIUS = 64;
    private static final int MAX_MOBS = 10;
    private static final int NORMAL_SPAWN_INTERVAL = 100;
    private static final int AGGRO_SPAWN_INTERVAL = 20;
    private static final int AGGRO_DURATION = 1200;

    public NestBlockEntity(BlockPos pos, BlockState state, int tier, boolean isBiter) {
        super(FactorioEnemiesModBlockEntities.NEST_BLOCK_ENTITY.get(), pos, state);
        this.tier = tier;
        this.isBiter = isBiter;
    }

    public NestBlockEntity(BlockPos pos, BlockState state) {
        this(pos, state, 0, true);
    }

    public void aggro() {
        this.aggroed = true;
        this.aggroTimer = 0;
        this.setChanged();
    }

    public static void serverTick(Level level, BlockPos pos, BlockState state, NestBlockEntity be) {
        if (be.aggroed) {
            be.aggroTimer++;
            if (be.aggroTimer >= AGGRO_DURATION) {
                be.aggroed = false;
                be.aggroTimer = 0;
                be.setChanged();
            }
        }

        int interval = be.aggroed ? AGGRO_SPAWN_INTERVAL : NORMAL_SPAWN_INTERVAL;
        be.spawnTimer++;
        if (be.spawnTimer < interval) return;
        be.spawnTimer = 0;

        Player nearestPlayer = level.getNearestPlayer(
                pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, TERRITORY_RADIUS, false);

        if (nearestPlayer != null && !be.aggroed) {
            be.aggroed = true;
            be.aggroTimer = 0;
        }

        if (nearestPlayer == null) return;

        be.spawnMobs((ServerLevel) level, pos);
        be.setChanged();
    }

    private void spawnMobs(ServerLevel level, BlockPos pos) {
        AABB searchBox = new AABB(
                pos.getX() - TERRITORY_RADIUS, pos.getY() - TERRITORY_RADIUS, pos.getZ() - TERRITORY_RADIUS,
                pos.getX() + TERRITORY_RADIUS, pos.getY() + TERRITORY_RADIUS, pos.getZ() + TERRITORY_RADIUS);

        int mobCount;
        if (isBiter) {
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
        EntityType<?> entityType = isBiter
                ? getBiterTypeForTier(tier, random)
                : getSpitterTypeForTier(tier, random);

        double spawnX = pos.getX() + 0.5 + (random.nextFloat() * 6f - 3f);
        double spawnY = pos.getY() + 1;
        double spawnZ = pos.getZ() + 0.5 + (random.nextFloat() * 6f - 3f);

        entityType.spawn(level, BlockPos.containing(spawnX, spawnY, spawnZ), MobSpawnType.MOB_SUMMONED);
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

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.putInt("Tier", tier);
        tag.putBoolean("IsBiter", isBiter);
        tag.putInt("SpawnTimer", spawnTimer);
        tag.putBoolean("Aggroed", aggroed);
        tag.putInt("AggroTimer", aggroTimer);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        tier = tag.getInt("Tier");
        isBiter = tag.getBoolean("IsBiter");
        spawnTimer = tag.getInt("SpawnTimer");
        aggroed = tag.getBoolean("Aggroed");
        aggroTimer = tag.getInt("AggroTimer");
    }
}
