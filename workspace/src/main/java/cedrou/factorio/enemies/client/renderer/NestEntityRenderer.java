package cedrou.factorio.enemies.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.BlockState;

import cedrou.factorio.enemies.block.NestBaseBlock;
import cedrou.factorio.enemies.entity.NestEntity;

public class NestEntityRenderer extends EntityRenderer<NestEntity> {
    public NestEntityRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.shadowRadius = 0.5f;
    }

    @Override
    public void render(NestEntity entity, float yaw, float partial, PoseStack ps, MultiBufferSource buffer, int packedLight) {
        ps.pushPose();
        ps.translate(-0.75, 0, -0.75);
        ps.scale(2.5f, 2.5f, 2.5f);
        BlockState blockState = NestBaseBlock.forTierAndType(entity.getTier(), entity.isBiter()).defaultBlockState();
        Minecraft.getInstance().getBlockRenderer().renderSingleBlock(blockState, ps, buffer, packedLight, OverlayTexture.NO_OVERLAY);
        ps.popPose();
        super.render(entity, yaw, partial, ps, buffer, packedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(NestEntity entity) {
        return new ResourceLocation("minecraft", "textures/block/stone.png");
    }
}
