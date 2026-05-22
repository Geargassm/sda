package cedrou.factorio.enemies.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import cedrou.factorio.enemies.init.FactorioEnemiesModBlocks;

public class PlacenestspittersbigProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		world.setBlock(BlockPos.containing(x, y, z), FactorioEnemiesModBlocks.NESTSPITTERSBIG.get().defaultBlockState(), 3);
	}
}
