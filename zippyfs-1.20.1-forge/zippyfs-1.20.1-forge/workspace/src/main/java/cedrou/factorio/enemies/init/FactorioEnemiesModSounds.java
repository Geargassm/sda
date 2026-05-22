
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package cedrou.factorio.enemies.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import cedrou.factorio.enemies.FactorioEnemiesMod;

public class FactorioEnemiesModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, FactorioEnemiesMod.MODID);
	public static final RegistryObject<SoundEvent> BITTER_VIE = REGISTRY.register("bitter-vie", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("factorio_enemies", "bitter-vie")));
	public static final RegistryObject<SoundEvent> SPITER_ATACK = REGISTRY.register("spiter-atack", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("factorio_enemies", "spiter-atack")));
	public static final RegistryObject<SoundEvent> PROJECTILE = REGISTRY.register("projectile", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("factorio_enemies", "projectile")));
	public static final RegistryObject<SoundEvent> SPAWNER_DESTRUCTION = REGISTRY.register("spawner-destruction", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("factorio_enemies", "spawner-destruction")));
	public static final RegistryObject<SoundEvent> SPAWNER_DESTRUCTION_2 = REGISTRY.register("spawner-destruction-2", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("factorio_enemies", "spawner-destruction-2")));
	public static final RegistryObject<SoundEvent> WORM_VIE = REGISTRY.register("worm-vie", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("factorio_enemies", "worm-vie")));
	public static final RegistryObject<SoundEvent> WORM_SMALL_DEATH = REGISTRY.register("worm-small-death", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("factorio_enemies", "worm-small-death")));
	public static final RegistryObject<SoundEvent> WORM_ATACK = REGISTRY.register("worm-atack", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("factorio_enemies", "worm-atack")));
	public static final RegistryObject<SoundEvent> SPITTER_DEATH = REGISTRY.register("spitter-death", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("factorio_enemies", "spitter-death")));
	public static final RegistryObject<SoundEvent> WORM_DEATH = REGISTRY.register("worm-death", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("factorio_enemies", "worm-death")));
	public static final RegistryObject<SoundEvent> BITER_DEATH = REGISTRY.register("biter-death", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("factorio_enemies", "biter-death")));
	public static final RegistryObject<SoundEvent> SPAWNER_VIE = REGISTRY.register("spawner-vie", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("factorio_enemies", "spawner-vie")));
	public static final RegistryObject<SoundEvent> BITER_ATACK = REGISTRY.register("biter-atack", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("factorio_enemies", "biter-atack")));
}
