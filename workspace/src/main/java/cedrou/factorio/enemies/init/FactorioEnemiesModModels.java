
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package cedrou.factorio.enemies.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import cedrou.factorio.enemies.client.model.Modelsmallworm;
import cedrou.factorio.enemies.client.model.Modelsmallspitters;
import cedrou.factorio.enemies.client.model.ModelSmallBiter;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class FactorioEnemiesModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(Modelsmallworm.LAYER_LOCATION, Modelsmallworm::createBodyLayer);
		event.registerLayerDefinition(ModelSmallBiter.LAYER_LOCATION, ModelSmallBiter::createBodyLayer);
		event.registerLayerDefinition(Modelsmallspitters.LAYER_LOCATION, Modelsmallspitters::createBodyLayer);
	}
}
