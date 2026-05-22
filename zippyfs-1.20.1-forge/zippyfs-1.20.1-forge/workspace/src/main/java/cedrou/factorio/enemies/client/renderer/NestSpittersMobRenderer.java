package cedrou.factorio.enemies.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.BlockState;
import cedrou.factorio.enemies.entity.NestspittersMobEntity;
import cedrou.factorio.enemies.init.FactorioEnemiesModBlocks;

public class NestSpittersMobRenderer extends EntityRenderer<NestspittersMobEntity> {
    public NestSpittersMobRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(NestspittersMobEntity e) {
        return new ResourceLocation("factorio_enemies:textures/entities/nestspitters.png");
    }

    @Override
    public void render(NestspittersMobEntity entity, float yaw, float pt, PoseStack ps, MultiBufferSource buf, int light) {
        ps.pushPose();
        ps.translate(-0.5D, 0.0D, -0.5D);
        BlockState state = switch (entity.getTier()) {
            case 1 -> FactorioEnemiesModBlocks.NESTSPITTERSSMALLSMEDIUM.get().defaultBlockState();
            case 2 -> FactorioEnemiesModBlocks.NESTSPITTERSMEDIUM.get().defaultBlockState();
            case 3 -> FactorioEnemiesModBlocks.NESTSPITTERSMEDIUMBIG.get().defaultBlockState();
            case 4 -> FactorioEnemiesModBlocks.NESTSPITTERSBIG.get().defaultBlockState();
            case 5 -> FactorioEnemiesModBlocks.NESTSPITTERSBIGBEHEMOTH.get().defaultBlockState();
            case 6 -> FactorioEnemiesModBlocks.NESTSPITTERSBEHEMOTH.get().defaultBlockState();
            default -> FactorioEnemiesModBlocks.NESTSPITTERS_SMALLS.get().defaultBlockState();
        };
        Minecraft.getInstance().getBlockRenderer().renderSingleBlock(state, ps, buf, light, OverlayTexture.NO_OVERLAY);
        ps.popPose();
        super.render(entity, yaw, pt, ps, buf, light);
    }
}
