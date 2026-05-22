
package cedrou.factorio.enemies.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.HierarchicalModel;

import com.mojang.blaze3d.vertex.PoseStack;

import cedrou.factorio.enemies.entity.BigspittersEntity;
import cedrou.factorio.enemies.client.model.animations.SmallBiterAnimation;
import cedrou.factorio.enemies.client.model.Modelsmallspitters;

public class BigspittersRenderer extends MobRenderer<BigspittersEntity, Modelsmallspitters<BigspittersEntity>> {
	public BigspittersRenderer(EntityRendererProvider.Context context) {
		super(context, new AnimatedModel(context.bakeLayer(Modelsmallspitters.LAYER_LOCATION)), 0.5f);
	}

	@Override
	protected void scale(BigspittersEntity entity, PoseStack poseStack, float f) {
		poseStack.scale(4f, 4f, 4f);
	}

	@Override
	public ResourceLocation getTextureLocation(BigspittersEntity entity) {
		return new ResourceLocation("factorio_enemies:textures/entities/bigspitters.png");
	}

	private static final class AnimatedModel extends Modelsmallspitters<BigspittersEntity> {
		private final ModelPart root;
		private final HierarchicalModel animator = new HierarchicalModel<BigspittersEntity>() {
			@Override
			public ModelPart root() {
				return root;
			}

			@Override
			public void setupAnim(BigspittersEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
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
		public void setupAnim(BigspittersEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
			animator.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
			super.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		}
	}
}
