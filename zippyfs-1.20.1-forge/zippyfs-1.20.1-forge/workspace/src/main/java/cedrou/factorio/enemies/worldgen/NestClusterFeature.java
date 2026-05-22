package cedrou.factorio.enemies.worldgen;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

import cedrou.factorio.enemies.block.NestBaseBlock;
import cedrou.factorio.enemies.init.FactorioEnemiesModBlocks;

public class NestClusterFeature extends Feature<NoneFeatureConfiguration> {
    public NestClusterFeature(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> ctx) {
        WorldGenLevel level = ctx.level();
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
            Block nestBlock = getNestBlock(tier, isBiter);
            Direction facing = Direction.from2DDataValue(random.nextInt(4));
            BlockState nestState = nestBlock.defaultBlockState()
                    .setValue(NestBaseBlock.FACING, facing)
                    .setValue(NestBaseBlock.WATERLOGGED, false);

            level.setBlock(candidate, nestState, 3);
        }
        return true;
    }

    private static Block getNestBlock(int tier, boolean isBiter) {
        if (isBiter) {
            return switch (tier) {
                case 1 -> FactorioEnemiesModBlocks.NESTBITERSMALLMEDIUM.get();
                case 2 -> FactorioEnemiesModBlocks.NESTBITERMEDIUM.get();
                case 3 -> FactorioEnemiesModBlocks.NESTBITERMEDIUMBIG.get();
                case 4 -> FactorioEnemiesModBlocks.NESTBITERBIG.get();
                case 5 -> FactorioEnemiesModBlocks.NESTBITERBIGBEHEMOTH.get();
                case 6 -> FactorioEnemiesModBlocks.NESTBITERBEHEMOTH.get();
                default -> FactorioEnemiesModBlocks.NESTBITER.get();
            };
        } else {
            return switch (tier) {
                case 1 -> FactorioEnemiesModBlocks.NESTSPITTERSSMALLSMEDIUM.get();
                case 2 -> FactorioEnemiesModBlocks.NESTSPITTERSMEDIUM.get();
                case 3 -> FactorioEnemiesModBlocks.NESTSPITTERSMEDIUMBIG.get();
                case 4 -> FactorioEnemiesModBlocks.NESTSPITTERSBIG.get();
                case 5 -> FactorioEnemiesModBlocks.NESTSPITTERSBIGBEHEMOTH.get();
                case 6 -> FactorioEnemiesModBlocks.NESTSPITTERSBEHEMOTH.get();
                default -> FactorioEnemiesModBlocks.NESTSPITTERS_SMALLS.get();
            };
        }
    }

    private static BlockPos findSurface(WorldGenLevel level, BlockPos start) {
        BlockPos pos = start.atY(level.getHeight(net.minecraft.world.level.levelgen.Heightmap.Types.WORLD_SURFACE_WG, start.getX(), start.getZ()));
        if (pos.getY() <= level.getMinBuildHeight()) return null;
        if (!level.getBlockState(pos.below()).isSolid()) return null;
        return pos;
    }
}
