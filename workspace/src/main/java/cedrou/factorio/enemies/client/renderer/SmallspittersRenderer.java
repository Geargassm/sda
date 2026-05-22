
package cedrou.factorio.enemies.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.HierarchicalModel;

import cedrou.factorio.enemies.entity.SmallspittersEntity;
import cedrou.factorio.enemies.client.model.animations.SmallBiterAnimation;
import cedrou.factorio.enemies.client.model.Modelsmallspitters;

public class SmallspittersRenderer extends MobRenderer<SmallspittersEntity, Modelsmallspitters<SmallspittersEntity>> {
	public SmallspittersRenderer(EntityRendererProvider.Context context) {
		super(context, new AnimatedModel(context.bakeLayer(Modelsmallspitters.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(SmallspittersEntity entity) {
		return new ResourceLocation("factorio_enemies:textures/entities/texture.png");
	}

	private static final class AnimatedModel extends Modelsmallspitters<SmallspittersEntity> {
		private final ModelPart root;
		private final HierarchicalModel animator = new HierarchicalModel<SmallspittersEntity>() {
			@Override
			public ModelPart root() {
				return root;
			}

			@Override
			public void setupAnim(SmallspittersEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
				this.root().getAllParts().forEach(ModelPart::resetPose);
				this.animateWalk(SmallBiterAnimation.walk, limbSwing, limbSwingAmount, 1f, 1f);
				this.animate(entity.animationState1, SmallBiterAnimation.idle, ageInTicks, 1f);
				this.animate(entity.animationState2, SmallBiterAnimation.attack, ageInTicks, 1f);
			}
		};

		public AnimatedModel(ModelPart root) {
			super(root);
			this.root = root;
		}

		@Override
		public void setupAnim(SmallspittersEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
			animator.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
			super.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		}
	}
}
