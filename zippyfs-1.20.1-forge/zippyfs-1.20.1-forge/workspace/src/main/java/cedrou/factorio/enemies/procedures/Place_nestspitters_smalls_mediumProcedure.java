package cedrou.factorio.enemies.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import cedrou.factorio.enemies.init.FactorioEnemiesModBlocks;

public class Place_nestspitters_smalls_mediumProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		world.setBlock(BlockPos.containing(x, y, z), FactorioEnemiesModBlocks.NESTSPITTERSSMALLSMEDIUM.get().defaultBlockState(), 3);
	}
}
