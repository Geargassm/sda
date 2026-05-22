package cedrou.factorio.enemies.worldgen;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerLevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import cedrou.factorio.enemies.entity.NestbiterMobEntity;
import cedrou.factorio.enemies.entity.NestspittersMobEntity;
import cedrou.factorio.enemies.init.FactorioEnemiesModEntities;

public class NestClusterFeature extends Feature<NoneFeatureConfiguration> {
    public NestClusterFeature(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> ctx) {
        WorldGenLevel level = ctx.level();
        if (!(level instanceof ServerLevelAccessor sla)) return false;
        ServerLevel serverLevel = sla.getLevel();

        BlockPos origin = ctx.origin();
        RandomSource random = ctx.random();

        double dist = Math.sqrt((double) origin.getX() * origin.getX() + (double) origin.getZ() * origin.getZ());
        int tier = (int) Math.min(6, dist / 500.0);

        int count = 3 + random.nextInt(3);

        for (int i = 0; i < count; i++) {
            int dx = random.nextInt(21) - 10;
            int dz = random.nextInt(21) - 10;
            BlockPos candidate = origin.offset(dx, 0, dz);

            candidate = findSurface(level, candidate);
            if (candidate == null) continue;

            boolean isBiter = random.nextFloat() < 0.6f;

            if (isBiter) {
                NestbiterMobEntity nest = (NestbiterMobEntity) FactorioEnemiesModEntities.NESTBITER_MOB.get().create(serverLevel);
                if (nest == null) continue;
                nest.setTier(tier);
                nest.setPos(candidate.getX() + 0.5, candidate.getY(), candidate.getZ() + 0.5);
                nest.finalizeSpawn(level, serverLevel.getCurrentDifficultyAt(candidate), MobSpawnType.WORLD_GENERATION, null, null);
                serverLevel.addFreshEntityWithPassengers(nest);
            } else {
                NestspittersMobEntity nest = (NestspittersMobEntity) FactorioEnemiesModEntities.NESTSPITTERS_MOB.get().create(serverLevel);
                if (nest == null) continue;
                nest.setTier(tier);
                nest.setPos(candidate.getX() + 0.5, candidate.getY(), candidate.getZ() + 0.5);
                nest.finalizeSpawn(level, serverLevel.getCurrentDifficultyAt(candidate), MobSpawnType.WORLD_GENERATION, null, null);
                serverLevel.addFreshEntityWithPassengers(nest);
            }
        }
        return true;
    }

    private BlockPos findSurface(WorldGenLevel level, BlockPos start) {
        BlockPos pos = start.atY(level.getHeight(net.minecraft.world.level.levelgen.Heightmap.Types.WORLD_SURFACE_WG, start.getX(), start.getZ()));
        if (pos.getY() <= level.getMinBuildHeight()) return null;
        if (!level.getBlockState(pos.below()).isSolid()) return null;
        return pos;
    }
}
