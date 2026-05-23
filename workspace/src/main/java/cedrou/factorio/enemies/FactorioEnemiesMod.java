package cedrou.factorio.enemies;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import net.minecraftforge.network.simple.SimpleChannel;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.util.thread.SidedThreadGroups;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.level.levelgen.feature.Feature;
import cedrou.factorio.enemies.worldgen.NestClusterConfig;

import com.mojang.serialization.Codec;

import java.util.function.Supplier;
import java.util.function.Function;
import java.util.function.BiConsumer;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.List;
import java.util.Collection;
import java.util.ArrayList;
import java.util.AbstractMap;

import cedrou.factorio.enemies.init.FactorioEnemiesModTabs;
import cedrou.factorio.enemies.init.FactorioEnemiesModSounds;
import cedrou.factorio.enemies.init.FactorioEnemiesModItems;
import cedrou.factorio.enemies.init.FactorioEnemiesModEntities;
import cedrou.factorio.enemies.init.FactorioEnemiesModBlockEntities;
import cedrou.factorio.enemies.init.FactorioEnemiesModBlocks;
import cedrou.factorio.enemies.worldgen.NestClusterFeature;

@Mod("factorio_enemies")
public class FactorioEnemiesMod {
	public static final Logger LOGGER = LogManager.getLogger(FactorioEnemiesMod.class);
	public static final String MODID = "factorio_enemies";

	public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(Registries.FEATURE, MODID);
	public static final RegistryObject<Feature<NestClusterConfig>> NEST_CLUSTER_FEATURE =
			FEATURES.register("nest_cluster", () -> new NestClusterFeature(NestClusterConfig.CODEC));

	public FactorioEnemiesMod() {
		// Start of user code block mod constructor
		// End of user code block mod constructor
		MinecraftForge.EVENT_BUS.register(this);
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		FactorioEnemiesModSounds.REGISTRY.register(bus);
		FactorioEnemiesModBlocks.REGISTRY.register(bus);

		FactorioEnemiesModItems.REGISTRY.register(bus);
		FactorioEnemiesModEntities.REGISTRY.register(bus);
		FactorioEnemiesModBlockEntities.REGISTRY.register(bus);

		FactorioEnemiesModTabs.REGISTRY.register(bus);
		FEATURES.register(bus);
		bus.addListener(FactorioEnemiesMod::setupSpawnRestrictions);

		// Start of user code block mod init
		// End of user code block mod init
	}

	private static void setupSpawnRestrictions(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			// Biters, spitters, and worms only spawn from nests — block all natural spawning
			var never = (SpawnPlacements.SpawnPredicate<?>) (type, level, spawnType, pos, random) -> false;
			SpawnPlacements.register(FactorioEnemiesModEntities.SMALLBITER.get(),    SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (SpawnPlacements.SpawnPredicate) never);
			SpawnPlacements.register(FactorioEnemiesModEntities.MEDIUMBITER.get(),   SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (SpawnPlacements.SpawnPredicate) never);
			SpawnPlacements.register(FactorioEnemiesModEntities.BIGBITER.get(),      SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (SpawnPlacements.SpawnPredicate) never);
			SpawnPlacements.register(FactorioEnemiesModEntities.BEHEMOTHBITER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (SpawnPlacements.SpawnPredicate) never);
			SpawnPlacements.register(FactorioEnemiesModEntities.SMALLSPITTERS.get(),    SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (SpawnPlacements.SpawnPredicate) never);
			SpawnPlacements.register(FactorioEnemiesModEntities.MEDIUMSPITTERS.get(),   SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (SpawnPlacements.SpawnPredicate) never);
			SpawnPlacements.register(FactorioEnemiesModEntities.BIGSPITTERS.get(),      SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (SpawnPlacements.SpawnPredicate) never);
			SpawnPlacements.register(FactorioEnemiesModEntities.BEHEMOTHSPITTERS.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (SpawnPlacements.SpawnPredicate) never);
			SpawnPlacements.register(FactorioEnemiesModEntities.SMALLWORM.get(),    SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (SpawnPlacements.SpawnPredicate) never);
			SpawnPlacements.register(FactorioEnemiesModEntities.MEDIUMWORM.get(),   SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (SpawnPlacements.SpawnPredicate) never);
			SpawnPlacements.register(FactorioEnemiesModEntities.BIGWORM.get(),      SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (SpawnPlacements.SpawnPredicate) never);
			SpawnPlacements.register(FactorioEnemiesModEntities.BEHEMOTHWORM.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (SpawnPlacements.SpawnPredicate) never);
			SpawnPlacements.register(FactorioEnemiesModEntities.NEST_ENTITY.get(),  SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (SpawnPlacements.SpawnPredicate) never);
		});
	}

	// Start of user code block mod methods
	// End of user code block mod methods
	private static final String PROTOCOL_VERSION = "1";
	public static final SimpleChannel PACKET_HANDLER = NetworkRegistry.newSimpleChannel(new ResourceLocation(MODID, MODID), () -> PROTOCOL_VERSION, PROTOCOL_VERSION::equals, PROTOCOL_VERSION::equals);
	private static int messageID = 0;

	public static <T> void addNetworkMessage(Class<T> messageType, BiConsumer<T, FriendlyByteBuf> encoder, Function<FriendlyByteBuf, T> decoder, BiConsumer<T, Supplier<NetworkEvent.Context>> messageConsumer) {
		PACKET_HANDLER.registerMessage(messageID, messageType, encoder, decoder, messageConsumer);
		messageID++;
	}

	private static final Collection<AbstractMap.SimpleEntry<Runnable, Integer>> workQueue = new ConcurrentLinkedQueue<>();

	public static void queueServerWork(int tick, Runnable action) {
		if (Thread.currentThread().getThreadGroup() == SidedThreadGroups.SERVER)
			workQueue.add(new AbstractMap.SimpleEntry<>(action, tick));
	}

	@SubscribeEvent
	public void tick(TickEvent.ServerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			List<AbstractMap.SimpleEntry<Runnable, Integer>> actions = new ArrayList<>();
			workQueue.forEach(work -> {
				work.setValue(work.getValue() - 1);
				if (work.getValue() == 0)
					actions.add(work);
			});
			actions.forEach(e -> e.getKey().run());
			workQueue.removeAll(actions);
		}
	}
}
