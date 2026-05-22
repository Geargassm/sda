
package cedrou.factorio.enemies.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.HierarchicalModel;

import com.mojang.blaze3d.vertex.PoseStack;

import cedrou.factorio.enemies.entity.BehemothwormEntity;
import cedrou.factorio.enemies.client.model.animations.smallwormAnimation;
import cedrou.factorio.enemies.client.model.Modelsmallworm;

public class BehemothwormRenderer extends MobRenderer<BehemothwormEntity, Modelsmallworm<BehemothwormEntity>> {
	public BehemothwormRenderer(EntityRendererProvider.Context context) {
		super(context, new AnimatedModel(context.bakeLayer(Modelsmallworm.LAYER_LOCATION)), 0.6f);
	}

	@Override
	protected void scale(BehemothwormEntity entity, PoseStack poseStack, float f) {
		poseStack.scale(6f, 6f, 6f);
	}

	@Override
	public ResourceLocation getTextureLocation(BehemothwormEntity entity) {
		return new ResourceLocation("factorio_enemies:textures/entities/behemothspitters.png");
	}

	private static final class AnimatedModel extends Modelsmallworm<BehemothwormEntity> {
		private final ModelPart root;
		private final HierarchicalModel animator = new HierarchicalModel<BehemothwormEntity>() {
			@Override
			public ModelPart root() {
				return root;
			}

			@Override
			public void setupAnim(BehemothwormEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
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
		public void setupAnim(BehemothwormEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
			animator.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
			super.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		}
	}
}
