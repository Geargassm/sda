
package cedrou.factorio.enemies.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.HierarchicalModel;

import cedrou.factorio.enemies.entity.SmallwormEntity;
import cedrou.factorio.enemies.client.model.animations.smallwormAnimation;
import cedrou.factorio.enemies.client.model.Modelsmallworm;

public class SmallwormRenderer extends MobRenderer<SmallwormEntity, Modelsmallworm<SmallwormEntity>> {
	public SmallwormRenderer(EntityRendererProvider.Context context) {
		super(context, new AnimatedModel(context.bakeLayer(Modelsmallworm.LAYER_LOCATION)), 0.6f);
	}

	@Override
	public ResourceLocation getTextureLocation(SmallwormEntity entity) {
		return new ResourceLocation("factorio_enemies:textures/entities/texture.png");
	}

	private static final class AnimatedModel extends Modelsmallworm<SmallwormEntity> {
		private final ModelPart root;
		private final HierarchicalModel animator = new HierarchicalModel<SmallwormEntity>() {
			@Override
			public ModelPart root() {
				return root;
			}

			@Override
			public void setupAnim(SmallwormEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
				this.root().getAllParts().forEach(ModelPart::resetPose);
				this.animate(entity.animationState0, smallwormAnimation.spawn, ageInTicks, 1f);
				this.animate(entity.animationState1, smallwormAnimation.idle, ageInTicks, 1f);
				this.animate(entity.animationState2, smallwormAnimation.attack, ageInTicks, 1f);
			}
		};

		public AnimatedModel(ModelPart root) {
			super(root);
			this.root = root;
		}

		@Override
		public void setupAnim(SmallwormEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
			animator.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
			super.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		}
	}
}
