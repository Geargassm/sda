
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package cedrou.factorio.enemies.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.ForgeSpawnEggItem;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import cedrou.factorio.enemies.FactorioEnemiesMod;

public class FactorioEnemiesModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, FactorioEnemiesMod.MODID);
	public static final RegistryObject<Item> SMALLSPITTERS_SPAWN_EGG = REGISTRY.register("smallspitters_spawn_egg", () -> new ForgeSpawnEggItem(FactorioEnemiesModEntities.SMALLSPITTERS, -3368704, -10079488, new Item.Properties()));
	public static final RegistryObject<Item> MEDIUMSPITTERS_SPAWN_EGG = REGISTRY.register("mediumspitters_spawn_egg", () -> new ForgeSpawnEggItem(FactorioEnemiesModEntities.MEDIUMSPITTERS, -6750208, -10079488, new Item.Properties()));
	public static final RegistryObject<Item> BIGSPITTERS_SPAWN_EGG = REGISTRY.register("bigspitters_spawn_egg", () -> new ForgeSpawnEggItem(FactorioEnemiesModEntities.BIGSPITTERS, -16750951, -10079488, new Item.Properties()));
	public static final RegistryObject<Item> BEHEMOTHSPITTERS_SPAWN_EGG = REGISTRY.register("behemothspitters_spawn_egg", () -> new ForgeSpawnEggItem(FactorioEnemiesModEntities.BEHEMOTHSPITTERS, -10066432, -10079488, new Item.Properties()));
	public static final RegistryObject<Item> SMALLBITER_SPAWN_EGG = REGISTRY.register("smallbiter_spawn_egg", () -> new ForgeSpawnEggItem(FactorioEnemiesModEntities.SMALLBITER, -3368704, -10079488, new Item.Properties()));
	public static final RegistryObject<Item> MEDIUMBITER_SPAWN_EGG = REGISTRY.register("mediumbiter_spawn_egg", () -> new ForgeSpawnEggItem(FactorioEnemiesModEntities.MEDIUMBITER, -6750208, -10079488, new Item.Properties()));
	public static final RegistryObject<Item> BIGBITER_SPAWN_EGG = REGISTRY.register("bigbiter_spawn_egg", () -> new ForgeSpawnEggItem(FactorioEnemiesModEntities.BIGBITER, -16750951, -10079488, new Item.Properties()));
	public static final RegistryObject<Item> BEHEMOTHBITER_SPAWN_EGG = REGISTRY.register("behemothbiter_spawn_egg", () -> new ForgeSpawnEggItem(FactorioEnemiesModEntities.BEHEMOTHBITER, -10066432, -10079488, new Item.Properties()));
	public static final RegistryObject<Item> NESTSPITTERS_SMALLS = block(FactorioEnemiesModBlocks.NESTSPITTERS_SMALLS);
	public static final RegistryObject<Item> NESTBITER = block(FactorioEnemiesModBlocks.NESTBITER);
	public static final RegistryObject<Item> SMALLWORM_SPAWN_EGG = REGISTRY.register("smallworm_spawn_egg", () -> new ForgeSpawnEggItem(FactorioEnemiesModEntities.SMALLWORM, -3368704, -10079488, new Item.Properties()));
	public static final RegistryObject<Item> MEDIUMWORM_SPAWN_EGG = REGISTRY.register("mediumworm_spawn_egg", () -> new ForgeSpawnEggItem(FactorioEnemiesModEntities.MEDIUMWORM, -6750208, -10079488, new Item.Properties()));
	public static final RegistryObject<Item> BIGWORM_SPAWN_EGG = REGISTRY.register("bigworm_spawn_egg", () -> new ForgeSpawnEggItem(FactorioEnemiesModEntities.BIGWORM, -16750951, -10079488, new Item.Properties()));
	public static final RegistryObject<Item> BEHEMOTHWORM_SPAWN_EGG = REGISTRY.register("behemothworm_spawn_egg", () -> new ForgeSpawnEggItem(FactorioEnemiesModEntities.BEHEMOTHWORM, -10066432, -10079488, new Item.Properties()));
	public static final RegistryObject<Item> NESTSPITTERSSMALLSMEDIUM = block(FactorioEnemiesModBlocks.NESTSPITTERSSMALLSMEDIUM);
	public static final RegistryObject<Item> NESTSPITTERSMEDIUM = block(FactorioEnemiesModBlocks.NESTSPITTERSMEDIUM);
	public static final RegistryObject<Item> NESTSPITTERSMEDIUMBIG = block(FactorioEnemiesModBlocks.NESTSPITTERSMEDIUMBIG);
	public static final RegistryObject<Item> NESTSPITTERSBIG = block(FactorioEnemiesModBlocks.NESTSPITTERSBIG);
	public static final RegistryObject<Item> NESTSPITTERSBIGBEHEMOTH = block(FactorioEnemiesModBlocks.NESTSPITTERSBIGBEHEMOTH);
	public static final RegistryObject<Item> NESTSPITTERSBEHEMOTH = block(FactorioEnemiesModBlocks.NESTSPITTERSBEHEMOTH);
	public static final RegistryObject<Item> NESTBITERSMALLMEDIUM = block(FactorioEnemiesModBlocks.NESTBITERSMALLMEDIUM);
	public static final RegistryObject<Item> NESTBITERMEDIUM = block(FactorioEnemiesModBlocks.NESTBITERMEDIUM);
	public static final RegistryObject<Item> NESTBITERMEDIUMBIG = block(FactorioEnemiesModBlocks.NESTBITERMEDIUMBIG);
	public static final RegistryObject<Item> NESTBITERBIG = block(FactorioEnemiesModBlocks.NESTBITERBIG);
	public static final RegistryObject<Item> NESTBITERBIGBEHEMOTH = block(FactorioEnemiesModBlocks.NESTBITERBIGBEHEMOTH);
	public static final RegistryObject<Item> NESTBITERBEHEMOTH = block(FactorioEnemiesModBlocks.NESTBITERBEHEMOTH);

	public static final RegistryObject<Item> NESTBITER_MOB_SPAWN_EGG = REGISTRY.register("nestbiter_mob_spawn_egg",
			() -> new ForgeSpawnEggItem(FactorioEnemiesModEntities.NESTBITER_MOB, 0x8B4513, 0xFF4500, new Item.Properties()));
	public static final RegistryObject<Item> NESTSPITTERS_MOB_SPAWN_EGG = REGISTRY.register("nestspitters_mob_spawn_egg",
			() -> new ForgeSpawnEggItem(FactorioEnemiesModEntities.NESTSPITTERS_MOB, 0x556B2F, 0xFFD700, new Item.Properties()));

	// Start of user code block custom items
	// End of user code block custom items
	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
