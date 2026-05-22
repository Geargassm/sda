package cedrou.factorio.enemies.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import cedrou.factorio.enemies.block.NestBlockEntity;

public class NestBlockEntityRenderer implements BlockEntityRenderer<NestBlockEntity> {
    public NestBlockEntityRenderer(BlockEntityRendererProvider.Context ctx) {}

    @Override
    public void render(NestBlockEntity be, float partialTick, PoseStack ps, MultiBufferSource buf, int packedLight, int packedOverlay) {
        Level level = be.getLevel();
        if (level == null) return;

        BlockState state = level.getBlockState(be.getBlockPos());

        ps.pushPose();
        // Translate so the 1.5× model is centered on the block
        ps.translate(-0.25, 0, -0.25);
        ps.scale(1.5f, 1.5f, 1.5f);
        Minecraft.getInstance().getBlockRenderer().renderSingleBlock(
                state, ps, buf, packedLight, OverlayTexture.NO_OVERLAY);
        ps.popPose();
    }
}
