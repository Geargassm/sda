package cedrou.factorio.enemies.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import cedrou.factorio.enemies.init.FactorioEnemiesModBlocks;

public class PlacenestspittersmediumProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		world.setBlock(BlockPos.containing(x, y, z), FactorioEnemiesModBlocks.NESTSPITTERSMEDIUM.get().defaultBlockState(), 3);
	}
}
