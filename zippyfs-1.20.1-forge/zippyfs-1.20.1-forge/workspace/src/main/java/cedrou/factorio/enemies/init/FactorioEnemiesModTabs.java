
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package cedrou.factorio.enemies.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import cedrou.factorio.enemies.FactorioEnemiesMod;

public class FactorioEnemiesModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, FactorioEnemiesMod.MODID);
	public static final RegistryObject<CreativeModeTab> FACTORIOENEMIESTAB = REGISTRY.register("factorioenemiestab",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.factorio_enemies.factorioenemiestab")).icon(() -> new ItemStack(Blocks.TURTLE_EGG)).displayItems((parameters, tabData) -> {
				tabData.accept(FactorioEnemiesModItems.SMALLSPITTERS_SPAWN_EGG.get());
				tabData.accept(FactorioEnemiesModItems.MEDIUMSPITTERS_SPAWN_EGG.get());
				tabData.accept(FactorioEnemiesModItems.BIGSPITTERS_SPAWN_EGG.get());
				tabData.accept(FactorioEnemiesModItems.BEHEMOTHSPITTERS_SPAWN_EGG.get());
				tabData.accept(FactorioEnemiesModItems.SMALLBITER_SPAWN_EGG.get());
				tabData.accept(FactorioEnemiesModItems.MEDIUMBITER_SPAWN_EGG.get());
				tabData.accept(FactorioEnemiesModItems.BIGBITER_SPAWN_EGG.get());
				tabData.accept(FactorioEnemiesModItems.BEHEMOTHBITER_SPAWN_EGG.get());
				tabData.accept(FactorioEnemiesModBlocks.NESTSPITTERS_SMALLS.get().asItem());
				tabData.accept(FactorioEnemiesModBlocks.NESTBITER.get().asItem());
				tabData.accept(FactorioEnemiesModItems.SMALLWORM_SPAWN_EGG.get());
				tabData.accept(FactorioEnemiesModItems.MEDIUMWORM_SPAWN_EGG.get());
				tabData.accept(FactorioEnemiesModItems.BIGWORM_SPAWN_EGG.get());
				tabData.accept(FactorioEnemiesModItems.BEHEMOTHWORM_SPAWN_EGG.get());
				tabData.accept(FactorioEnemiesModBlocks.NESTSPITTERSSMALLSMEDIUM.get().asItem());
				tabData.accept(FactorioEnemiesModBlocks.NESTSPITTERSMEDIUM.get().asItem());
				tabData.accept(FactorioEnemiesModBlocks.NESTSPITTERSMEDIUMBIG.get().asItem());
				tabData.accept(FactorioEnemiesModBlocks.NESTSPITTERSBIG.get().asItem());
				tabData.accept(FactorioEnemiesModBlocks.NESTSPITTERSBIGBEHEMOTH.get().asItem());
				tabData.accept(FactorioEnemiesModBlocks.NESTSPITTERSBEHEMOTH.get().asItem());
				tabData.accept(FactorioEnemiesModBlocks.NESTBITERSMALLMEDIUM.get().asItem());
				tabData.accept(FactorioEnemiesModBlocks.NESTBITERMEDIUM.get().asItem());
				tabData.accept(FactorioEnemiesModBlocks.NESTBITERMEDIUMBIG.get().asItem());
				tabData.accept(FactorioEnemiesModBlocks.NESTBITERBIG.get().asItem());
				tabData.accept(FactorioEnemiesModBlocks.NESTBITERBIGBEHEMOTH.get().asItem());
				tabData.accept(FactorioEnemiesModBlocks.NESTBITERBEHEMOTH.get().asItem());
			}).build());
}
