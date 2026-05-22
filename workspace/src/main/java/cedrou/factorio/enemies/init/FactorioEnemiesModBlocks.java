
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package cedrou.factorio.enemies.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import cedrou.factorio.enemies.block.NestspitterssmallsmediumBlock;
import cedrou.factorio.enemies.block.NestspittersmediumbigBlock;
import cedrou.factorio.enemies.block.NestspittersmediumBlock;
import cedrou.factorio.enemies.block.NestspittersbigbehemothBlock;
import cedrou.factorio.enemies.block.NestspittersbigBlock;
import cedrou.factorio.enemies.block.NestspittersbehemothBlock;
import cedrou.factorio.enemies.block.NestspittersBlock;
import cedrou.factorio.enemies.block.NestbitersmallmediumBlock;
import cedrou.factorio.enemies.block.NestbitermediumbigBlock;
import cedrou.factorio.enemies.block.NestbitermediumBlock;
import cedrou.factorio.enemies.block.NestbiterbigbehemothBlock;
import cedrou.factorio.enemies.block.NestbiterbigBlock;
import cedrou.factorio.enemies.block.NestbiterbehemothBlock;
import cedrou.factorio.enemies.block.NestbiterBlock;
import cedrou.factorio.enemies.FactorioEnemiesMod;

public class FactorioEnemiesModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, FactorioEnemiesMod.MODID);
	public static final RegistryObject<Block> NESTSPITTERS_SMALLS = REGISTRY.register("nestspitters_smalls", () -> new NestspittersBlock());
	public static final RegistryObject<Block> NESTBITER = REGISTRY.register("nestbiter", () -> new NestbiterBlock());
	public static final RegistryObject<Block> NESTSPITTERSSMALLSMEDIUM = REGISTRY.register("nestspitterssmallsmedium", () -> new NestspitterssmallsmediumBlock());
	public static final RegistryObject<Block> NESTSPITTERSMEDIUM = REGISTRY.register("nestspittersmedium", () -> new NestspittersmediumBlock());
	public static final RegistryObject<Block> NESTSPITTERSMEDIUMBIG = REGISTRY.register("nestspittersmediumbig", () -> new NestspittersmediumbigBlock());
	public static final RegistryObject<Block> NESTSPITTERSBIG = REGISTRY.register("nestspittersbig", () -> new NestspittersbigBlock());
	public static final RegistryObject<Block> NESTSPITTERSBIGBEHEMOTH = REGISTRY.register("nestspittersbigbehemoth", () -> new NestspittersbigbehemothBlock());
	public static final RegistryObject<Block> NESTSPITTERSBEHEMOTH = REGISTRY.register("nestspittersbehemoth", () -> new NestspittersbehemothBlock());
	public static final RegistryObject<Block> NESTBITERSMALLMEDIUM = REGISTRY.register("nestbitersmallmedium", () -> new NestbitersmallmediumBlock());
	public static final RegistryObject<Block> NESTBITERMEDIUM = REGISTRY.register("nestbitermedium", () -> new NestbitermediumBlock());
	public static final RegistryObject<Block> NESTBITERMEDIUMBIG = REGISTRY.register("nestbitermediumbig", () -> new NestbitermediumbigBlock());
	public static final RegistryObject<Block> NESTBITERBIG = REGISTRY.register("nestbiterbig", () -> new NestbiterbigBlock());
	public static final RegistryObject<Block> NESTBITERBIGBEHEMOTH = REGISTRY.register("nestbiterbigbehemoth", () -> new NestbiterbigbehemothBlock());
	public static final RegistryObject<Block> NESTBITERBEHEMOTH = REGISTRY.register("nestbiterbehemoth", () -> new NestbiterbehemothBlock());
	// Start of user code block custom blocks
	// End of user code block custom blocks
}
