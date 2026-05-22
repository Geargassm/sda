package cedrou.factorio.enemies.init;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import net.minecraft.world.level.block.entity.BlockEntityType;

import cedrou.factorio.enemies.FactorioEnemiesMod;
import cedrou.factorio.enemies.block.NestBlockEntity;

public class FactorioEnemiesModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> REGISTRY =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, FactorioEnemiesMod.MODID);

    public static final RegistryObject<BlockEntityType<NestBlockEntity>> NEST_BLOCK_ENTITY =
            REGISTRY.register("nest_block_entity", () ->
                    BlockEntityType.Builder.<NestBlockEntity>of(NestBlockEntity::new,
                            FactorioEnemiesModBlocks.NESTBITER.get(),
                            FactorioEnemiesModBlocks.NESTBITERSMALLMEDIUM.get(),
                            FactorioEnemiesModBlocks.NESTBITERMEDIUM.get(),
                            FactorioEnemiesModBlocks.NESTBITERMEDIUMBIG.get(),
                            FactorioEnemiesModBlocks.NESTBITERBIG.get(),
                            FactorioEnemiesModBlocks.NESTBITERBIGBEHEMOTH.get(),
                            FactorioEnemiesModBlocks.NESTBITERBEHEMOTH.get(),
                            FactorioEnemiesModBlocks.NESTSPITTERS_SMALLS.get(),
                            FactorioEnemiesModBlocks.NESTSPITTERSSMALLSMEDIUM.get(),
                            FactorioEnemiesModBlocks.NESTSPITTERSMEDIUM.get(),
                            FactorioEnemiesModBlocks.NESTSPITTERSMEDIUMBIG.get(),
                            FactorioEnemiesModBlocks.NESTSPITTERSBIG.get(),
                            FactorioEnemiesModBlocks.NESTSPITTERSBIGBEHEMOTH.get(),
                            FactorioEnemiesModBlocks.NESTSPITTERSBEHEMOTH.get()
                    ).build(null));
}
