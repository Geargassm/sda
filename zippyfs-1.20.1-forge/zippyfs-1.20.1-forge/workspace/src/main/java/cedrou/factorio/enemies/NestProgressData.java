package cedrou.factorio.enemies;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.saveddata.SavedData;

public class NestProgressData extends SavedData {
    private static final String ID = "factorio_enemies_nest_progress";
    private static final int[] PHASE_THRESHOLDS = {0, 5, 15, 30, 50, 75, 100};

    private int killCount = 0;

    public void incrementKills() {
        killCount++;
        setDirty();
    }

    public int getKillCount() {
        return killCount;
    }

    public int getPhase() {
        for (int i = PHASE_THRESHOLDS.length - 1; i >= 0; i--) {
            if (killCount >= PHASE_THRESHOLDS[i]) return i;
        }
        return 0;
    }

    public static NestProgressData get(ServerLevel level) {
        return level.getServer().overworld().getDataStorage()
                .computeIfAbsent(NestProgressData::load, NestProgressData::new, ID);
    }

    public static NestProgressData load(CompoundTag tag) {
        NestProgressData data = new NestProgressData();
        data.killCount = tag.getInt("KillCount");
        return data;
    }

    @Override
    public CompoundTag save(CompoundTag tag) {
        tag.putInt("KillCount", killCount);
        return tag;
    }
}
