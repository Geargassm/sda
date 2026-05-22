
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package cedrou.factorio.enemies.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import cedrou.factorio.enemies.entity.SmallwormEntity;
import cedrou.factorio.enemies.entity.SmallspittersEntity;
import cedrou.factorio.enemies.entity.SmallbiterEntity;
import cedrou.factorio.enemies.entity.ProjectilefactorioEntity;
import cedrou.factorio.enemies.entity.MediumwormEntity;
import cedrou.factorio.enemies.entity.MediumspittersEntity;
import cedrou.factorio.enemies.entity.MediumbiterEntity;
import cedrou.factorio.enemies.entity.BigwormEntity;
import cedrou.factorio.enemies.entity.BigspittersEntity;
import cedrou.factorio.enemies.entity.BigbiterEntity;
import cedrou.factorio.enemies.entity.BehemothwormEntity;
import cedrou.factorio.enemies.entity.BehemothspittersEntity;
import cedrou.factorio.enemies.entity.BehemothbiterEntity;
import cedrou.factorio.enemies.FactorioEnemiesMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class FactorioEnemiesModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, FactorioEnemiesMod.MODID);
	public static final RegistryObject<EntityType<SmallspittersEntity>> SMALLSPITTERS = register("smallspitters",
			EntityType.Builder.<SmallspittersEntity>of(SmallspittersEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(256).setUpdateInterval(3).setCustomClientFactory(SmallspittersEntity::new)

					.sized(0.6f, 0.4f));
	public static final RegistryObject<EntityType<MediumspittersEntity>> MEDIUMSPITTERS = register("mediumspitters",
			EntityType.Builder.<MediumspittersEntity>of(MediumspittersEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(256).setUpdateInterval(3).setCustomClientFactory(MediumspittersEntity::new)

					.sized(0.6f, 0.4f));
	public static final RegistryObject<EntityType<BigspittersEntity>> BIGSPITTERS = register("bigspitters",
			EntityType.Builder.<BigspittersEntity>of(BigspittersEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(256).setUpdateInterval(3).setCustomClientFactory(BigspittersEntity::new)

					.sized(0.6f, 0.4f));
	public static final RegistryObject<EntityType<BehemothspittersEntity>> BEHEMOTHSPITTERS = register("behemothspitters",
			EntityType.Builder.<BehemothspittersEntity>of(BehemothspittersEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(256).setUpdateInterval(3).setCustomClientFactory(BehemothspittersEntity::new)

					.sized(0.6f, 0.4f));
	public static final RegistryObject<EntityType<SmallbiterEntity>> SMALLBITER = register("smallbiter",
			EntityType.Builder.<SmallbiterEntity>of(SmallbiterEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(256).setUpdateInterval(3).setCustomClientFactory(SmallbiterEntity::new)

					.sized(0.6f, 0.4f));
	public static final RegistryObject<EntityType<MediumbiterEntity>> MEDIUMBITER = register("mediumbiter",
			EntityType.Builder.<MediumbiterEntity>of(MediumbiterEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(256).setUpdateInterval(3).setCustomClientFactory(MediumbiterEntity::new)

					.sized(0.6f, 0.4f));
	public static final RegistryObject<EntityType<BigbiterEntity>> BIGBITER = register("bigbiter",
			EntityType.Builder.<BigbiterEntity>of(BigbiterEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(256).setUpdateInterval(3).setCustomClientFactory(BigbiterEntity::new)

					.sized(0.6f, 0.4f));
	public static final RegistryObject<EntityType<BehemothbiterEntity>> BEHEMOTHBITER = register("behemothbiter",
			EntityType.Builder.<BehemothbiterEntity>of(BehemothbiterEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(256).setUpdateInterval(3).setCustomClientFactory(BehemothbiterEntity::new)

					.sized(0.6f, 0.4f));
	public static final RegistryObject<EntityType<SmallwormEntity>> SMALLWORM = register("smallworm", EntityType.Builder.<SmallwormEntity>of(SmallwormEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(256)
			.setUpdateInterval(3).setCustomClientFactory(SmallwormEntity::new).fireImmune().sized(0.6f, 0.6f));
	public static final RegistryObject<EntityType<MediumwormEntity>> MEDIUMWORM = register("mediumworm", EntityType.Builder.<MediumwormEntity>of(MediumwormEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(256)
			.setUpdateInterval(3).setCustomClientFactory(MediumwormEntity::new).fireImmune().sized(0.6f, 0.6f));
	public static final RegistryObject<EntityType<BigwormEntity>> BIGWORM = register("bigworm",
			EntityType.Builder.<BigwormEntity>of(BigwormEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(256).setUpdateInterval(3).setCustomClientFactory(BigwormEntity::new).fireImmune().sized(0.6f, 0.6f));
	public static final RegistryObject<EntityType<BehemothwormEntity>> BEHEMOTHWORM = register("behemothworm", EntityType.Builder.<BehemothwormEntity>of(BehemothwormEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(256).setUpdateInterval(3).setCustomClientFactory(BehemothwormEntity::new).fireImmune().sized(0.6f, 0.6f));
	public static final RegistryObject<EntityType<ProjectilefactorioEntity>> PROJECTILEFACTORIO = register("projectilefactorio", EntityType.Builder.<ProjectilefactorioEntity>of(ProjectilefactorioEntity::new, MobCategory.MISC)
			.setCustomClientFactory(ProjectilefactorioEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));

	// Start of user code block custom entities
	// End of user code block custom entities
	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			SmallspittersEntity.init();
			MediumspittersEntity.init();
			BigspittersEntity.init();
			BehemothspittersEntity.init();
			SmallbiterEntity.init();
			MediumbiterEntity.init();
			BigbiterEntity.init();
			BehemothbiterEntity.init();
			SmallwormEntity.init();
			MediumwormEntity.init();
			BigwormEntity.init();
			BehemothwormEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(SMALLSPITTERS.get(), SmallspittersEntity.createAttributes().build());
		event.put(MEDIUMSPITTERS.get(), MediumspittersEntity.createAttributes().build());
		event.put(BIGSPITTERS.get(), BigspittersEntity.createAttributes().build());
		event.put(BEHEMOTHSPITTERS.get(), BehemothspittersEntity.createAttributes().build());
		event.put(SMALLBITER.get(), SmallbiterEntity.createAttributes().build());
		event.put(MEDIUMBITER.get(), MediumbiterEntity.createAttributes().build());
		event.put(BIGBITER.get(), BigbiterEntity.createAttributes().build());
		event.put(BEHEMOTHBITER.get(), BehemothbiterEntity.createAttributes().build());
		event.put(SMALLWORM.get(), SmallwormEntity.createAttributes().build());
		event.put(MEDIUMWORM.get(), MediumwormEntity.createAttributes().build());
		event.put(BIGWORM.get(), BigwormEntity.createAttributes().build());
		event.put(BEHEMOTHWORM.get(), BehemothwormEntity.createAttributes().build());
	}
}
