
package cedrou.factorio.enemies.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.HierarchicalModel;

import com.mojang.blaze3d.vertex.PoseStack;

import cedrou.factorio.enemies.entity.MediumbiterEntity;
import cedrou.factorio.enemies.client.model.animations.SmallBiterAnimation;
import cedrou.factorio.enemies.client.model.ModelSmallBiter;

public class MediumbiterRenderer extends MobRenderer<MediumbiterEntity, ModelSmallBiter<MediumbiterEntity>> {
	public MediumbiterRenderer(EntityRendererProvider.Context context) {
		super(context, new AnimatedModel(context.bakeLayer(ModelSmallBiter.LAYER_LOCATION)), 0.5f);
	}

	@Override
	protected void scale(MediumbiterEntity entity, PoseStack poseStack, float f) {
		poseStack.scale(2.5f, 2.5f, 2.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(MediumbiterEntity entity) {
		return new ResourceLocation("factorio_enemies:textures/entities/mediumspitters.png");
	}

	private static final class AnimatedModel extends ModelSmallBiter<MediumbiterEntity> {
		private final ModelPart root;
		private final HierarchicalModel animator = new HierarchicalModel<MediumbiterEntity>() {
			@Override
			public ModelPart root() {
				return root;
			}

			@Override
			public void setupAnim(MediumbiterEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
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
		public void setupAnim(MediumbiterEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
			animator.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
			super.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		}
	}
}
