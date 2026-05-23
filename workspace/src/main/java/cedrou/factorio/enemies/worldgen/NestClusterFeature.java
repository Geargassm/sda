package cedrou.factorio.enemies.worldgen;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import cedrou.factorio.enemies.block.NestBaseBlock;

public class NestClusterFeature extends Feature<NoneFeatureConfiguration> {
    private final boolean isBiter;

    public NestClusterFeature(Codec<NoneFeatureConfiguration> codec, boolean isBiter) {
        super(codec);
        this.isBiter = isBiter;
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> ctx) {
        WorldGenLevel level = ctx.level();
        BlockPos origin = ctx.origin();
        RandomSource random = ctx.random();

        int count = 5 + random.nextInt(4);

        for (int i = 0; i < count; i++) {
            int dx = random.nextInt(11) - 5;
            int dz = random.nextInt(11) - 5;
            BlockPos candidate = origin.offset(dx, 0, dz);

            candidate = findSurface(level, candidate);
            if (candidate == null) continue;

            Direction facing = Direction.from2DDataValue(random.nextInt(4));
            BlockState nestState = NestBaseBlock.forTierAndType(0, isBiter)
                    .defaultBlockState()
                    .setValue(NestBaseBlock.FACING, facing)
                    .setValue(NestBaseBlock.WATERLOGGED, false);

            level.setBlock(candidate, nestState, 3);
        }
        return true;
    }

    private static BlockPos findSurface(WorldGenLevel level, BlockPos start) {
        BlockPos pos = start.atY(level.getHeight(net.minecraft.world.level.levelgen.Heightmap.Types.WORLD_SURFACE_WG, start.getX(), start.getZ()));
        if (pos.getY() <= level.getMinBuildHeight()) return null;
        if (!level.getBlockState(pos.below()).isSolid()) return null;
        return pos;
    }
}
