
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package cedrou.factorio.enemies.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.renderer.entity.ThrownItemRenderer;

import cedrou.factorio.enemies.client.renderer.SmallwormRenderer;
import cedrou.factorio.enemies.client.renderer.SmallspittersRenderer;
import cedrou.factorio.enemies.client.renderer.SmallbiterRenderer;
import cedrou.factorio.enemies.client.renderer.MediumwormRenderer;
import cedrou.factorio.enemies.client.renderer.MediumspittersRenderer;
import cedrou.factorio.enemies.client.renderer.MediumbiterRenderer;
import cedrou.factorio.enemies.client.renderer.BigwormRenderer;
import cedrou.factorio.enemies.client.renderer.BigspittersRenderer;
import cedrou.factorio.enemies.client.renderer.BigbiterRenderer;
import cedrou.factorio.enemies.client.renderer.BehemothwormRenderer;
import cedrou.factorio.enemies.client.renderer.BehemothspittersRenderer;
import cedrou.factorio.enemies.client.renderer.BehemothbiterRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class FactorioEnemiesModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(FactorioEnemiesModEntities.SMALLSPITTERS.get(), SmallspittersRenderer::new);
		event.registerEntityRenderer(FactorioEnemiesModEntities.MEDIUMSPITTERS.get(), MediumspittersRenderer::new);
		event.registerEntityRenderer(FactorioEnemiesModEntities.BIGSPITTERS.get(), BigspittersRenderer::new);
		event.registerEntityRenderer(FactorioEnemiesModEntities.BEHEMOTHSPITTERS.get(), BehemothspittersRenderer::new);
		event.registerEntityRenderer(FactorioEnemiesModEntities.SMALLBITER.get(), SmallbiterRenderer::new);
		event.registerEntityRenderer(FactorioEnemiesModEntities.MEDIUMBITER.get(), MediumbiterRenderer::new);
		event.registerEntityRenderer(FactorioEnemiesModEntities.BIGBITER.get(), BigbiterRenderer::new);
		event.registerEntityRenderer(FactorioEnemiesModEntities.BEHEMOTHBITER.get(), BehemothbiterRenderer::new);
		event.registerEntityRenderer(FactorioEnemiesModEntities.SMALLWORM.get(), SmallwormRenderer::new);
		event.registerEntityRenderer(FactorioEnemiesModEntities.MEDIUMWORM.get(), MediumwormRenderer::new);
		event.registerEntityRenderer(FactorioEnemiesModEntities.BIGWORM.get(), BigwormRenderer::new);
		event.registerEntityRenderer(FactorioEnemiesModEntities.BEHEMOTHWORM.get(), BehemothwormRenderer::new);
		event.registerEntityRenderer(FactorioEnemiesModEntities.PROJECTILEFACTORIO.get(), ThrownItemRenderer::new);
	}
}
