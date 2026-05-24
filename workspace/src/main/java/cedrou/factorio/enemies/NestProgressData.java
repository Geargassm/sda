package cedrou.factorio.enemies;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.saveddata.SavedData;

import cedrou.factorio.enemies.FactorioEnemiesConfig;
import cedrou.factorio.enemies.block.NestBaseBlock;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class NestProgressData extends SavedData {
    private static final String ID = "factorio_enemies_nest_progress";

    public static final long RESPAWN_DELAY_TICKS = 72000L;

    private int killCount = 0;
    private final Set<Long> playerPlacedBlocks = new HashSet<>();
    private final List<RespawnEntry> respawnQueue = new ArrayList<>();

    // -------------------------------------------------------------------------
    // Inner class for respawn entries
    // -------------------------------------------------------------------------
    public static class RespawnEntry {
        public final BlockPos pos;
        public final int tier;
        public final boolean isBiter;
        public final long respawnAt;

        public RespawnEntry(BlockPos pos, int tier, boolean isBiter, long respawnAt) {
            this.pos = pos;
            this.tier = tier;
            this.isBiter = isBiter;
            this.respawnAt = respawnAt;
        }
    }

    // -------------------------------------------------------------------------
    // Kill tracking
    // -------------------------------------------------------------------------
    public void incrementKills(ServerLevel level) {
        int oldPhase = getPhase();
        killCount++;
        int newPhase = getPhase();
        setDirty();
        if (newPhase != oldPhase) {
            grantPhaseAdvancement(level, newPhase);
        }
    }

    public int getKillCount() {
        return killCount;
    }

    public int getPhase() {
        java.util.List<? extends Integer> thresholds = FactorioEnemiesConfig.EVO_THRESHOLDS.get();
        for (int i = thresholds.size() - 1; i >= 0; i--) {
            if (killCount >= thresholds.get(i)) return i + 1;
        }
        return 0;
    }

    // -------------------------------------------------------------------------
    // Phase advancement grant
    // -------------------------------------------------------------------------
    private void grantPhaseAdvancement(ServerLevel level, int phase) {
        ResourceLocation advRL = new ResourceLocation("factorio_enemies", "phase_" + phase);
        for (net.minecraft.server.level.ServerPlayer player : level.getServer().getPlayerList().getPlayers()) {
            net.minecraft.advancements.Advancement adv = level.getServer().getAdvancements().getAdvancement(advRL);
            if (adv == null) continue;
            net.minecraft.advancements.AdvancementProgress progress = player.getAdvancements().getOrStartProgress(adv);
            if (!progress.isDone()) {
                for (String criterion : progress.getRemainingCriteria()) {
                    player.getAdvancements().award(adv, criterion);
                }
            }
        }
    }

    // -------------------------------------------------------------------------
    // Player-placed block tracking
    // -------------------------------------------------------------------------
    public void addPlayerBlock(BlockPos pos) {
        playerPlacedBlocks.add(pos.asLong());
        setDirty();
    }

    public void removePlayerBlock(BlockPos pos) {
        playerPlacedBlocks.remove(pos.asLong());
        setDirty();
    }

    public boolean isPlayerBlock(BlockPos pos) {
        return playerPlacedBlocks.contains(pos.asLong());
    }

    public boolean hasPlayerBlocksNear(BlockPos center, int radius) {
        for (long packed : playerPlacedBlocks) {
            BlockPos stored = BlockPos.of(packed);
            if (Math.abs(stored.getX() - center.getX()) <= radius
                    && Math.abs(stored.getZ() - center.getZ()) <= radius) {
                return true;
            }
        }
        return false;
    }

    // -------------------------------------------------------------------------
    // Respawn queue
    // -------------------------------------------------------------------------
    public void scheduleRespawn(BlockPos pos, int tier, boolean isBiter, long currentGameTime) {
        respawnQueue.add(new RespawnEntry(pos, tier, isBiter, currentGameTime + RESPAWN_DELAY_TICKS));
        setDirty();
    }

    public void tickRespawns(ServerLevel level) {
        boolean changed = false;
        Iterator<RespawnEntry> it = respawnQueue.iterator();
        while (it.hasNext()) {
            RespawnEntry entry = it.next();
            if (level.getGameTime() < entry.respawnAt) continue;

            // Ready to respawn
            it.remove();
            changed = true;

            // Skip if player blocks are nearby
            if (hasPlayerBlocksNear(entry.pos, 32)) continue;

            // Skip if chunk not loaded
            if (!level.isLoaded(entry.pos)) continue;

            // Skip if block at pos is not air
            if (!level.getBlockState(entry.pos).isAir()) continue;

            // Skip if block below is not solid
            if (!level.getBlockState(entry.pos.below()).isSolid()) continue;

            // Place the nest block
            BlockState state = NestBaseBlock.forTierAndType(entry.tier, entry.isBiter).defaultBlockState();
            level.setBlock(entry.pos, state, 3);
        }
        if (changed) {
            setDirty();
        }
    }

    // -------------------------------------------------------------------------
    // SavedData boilerplate
    // -------------------------------------------------------------------------
    public static NestProgressData get(ServerLevel level) {
        return level.getServer().overworld().getDataStorage()
                .computeIfAbsent(NestProgressData::load, NestProgressData::new, ID);
    }

    public static NestProgressData load(CompoundTag tag) {
        NestProgressData data = new NestProgressData();
        data.killCount = tag.getInt("KillCount");

        // Load player-placed blocks
        if (tag.contains("PlayerBlocks", Tag.TAG_LONG_ARRAY)) {
            for (long packed : tag.getLongArray("PlayerBlocks")) {
                data.playerPlacedBlocks.add(packed);
            }
        }

        // Load respawn queue
        if (tag.contains("RespawnQueue", Tag.TAG_LIST)) {
            ListTag list = tag.getList("RespawnQueue", Tag.TAG_COMPOUND);
            for (int i = 0; i < list.size(); i++) {
                CompoundTag entry = list.getCompound(i);
                BlockPos pos = new BlockPos(entry.getInt("X"), entry.getInt("Y"), entry.getInt("Z"));
                int tier = entry.getInt("Tier");
                boolean isBiter = entry.getBoolean("IsBiter");
                long respawnAt = entry.getLong("RespawnAt");
                data.respawnQueue.add(new RespawnEntry(pos, tier, isBiter, respawnAt));
            }
        }

        return data;
    }

    @Override
    public CompoundTag save(CompoundTag tag) {
        tag.putInt("KillCount", killCount);

        // Save player-placed blocks
        long[] blocksArray = new long[playerPlacedBlocks.size()];
        int idx = 0;
        for (long packed : playerPlacedBlocks) {
            blocksArray[idx++] = packed;
        }
        tag.putLongArray("PlayerBlocks", blocksArray);

        // Save respawn queue
        ListTag listTag = new ListTag();
        for (RespawnEntry entry : respawnQueue) {
            CompoundTag entryTag = new CompoundTag();
            entryTag.putInt("X", entry.pos.getX());
            entryTag.putInt("Y", entry.pos.getY());
            entryTag.putInt("Z", entry.pos.getZ());
            entryTag.putInt("Tier", entry.tier);
            entryTag.putBoolean("IsBiter", entry.isBiter);
            entryTag.putLong("RespawnAt", entry.respawnAt);
            listTag.add(entryTag);
        }
        tag.put("RespawnQueue", listTag);

        return tag;
    }
}
