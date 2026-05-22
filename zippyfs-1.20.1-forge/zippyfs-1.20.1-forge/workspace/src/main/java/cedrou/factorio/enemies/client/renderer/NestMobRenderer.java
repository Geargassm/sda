package cedrou.factorio.enemies.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.BlockState;
import cedrou.factorio.enemies.entity.NestbiterMobEntity;
import cedrou.factorio.enemies.init.FactorioEnemiesModBlocks;

public class NestMobRenderer extends EntityRenderer<NestbiterMobEntity> {
    public NestMobRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(NestbiterMobEntity e) {
        return new ResourceLocation("factorio_enemies:textures/entities/nestbiter.png");
    }

    @Override
    public void render(NestbiterMobEntity entity, float yaw, float pt, PoseStack ps, MultiBufferSource buf, int light) {
        ps.pushPose();
        ps.translate(-0.5D, 0.0D, -0.5D);
        BlockState state = switch (entity.getTier()) {
            case 1 -> FactorioEnemiesModBlocks.NESTBITERSMALLMEDIUM.get().defaultBlockState();
            case 2 -> FactorioEnemiesModBlocks.NESTBITERMEDIUM.get().defaultBlockState();
            case 3 -> FactorioEnemiesModBlocks.NESTBITERMEDIUMBIG.get().defaultBlockState();
            case 4 -> FactorioEnemiesModBlocks.NESTBITERBIG.get().defaultBlockState();
            case 5 -> FactorioEnemiesModBlocks.NESTBITERBIGBEHEMOTH.get().defaultBlockState();
            case 6 -> FactorioEnemiesModBlocks.NESTBITERBEHEMOTH.get().defaultBlockState();
            default -> FactorioEnemiesModBlocks.NESTBITER.get().defaultBlockState();
        };
        Minecraft.getInstance().getBlockRenderer().renderSingleBlock(state, ps, buf, light, OverlayTexture.NO_OVERLAY);
        ps.popPose();
        super.render(entity, yaw, pt, ps, buf, light);
    }
}
