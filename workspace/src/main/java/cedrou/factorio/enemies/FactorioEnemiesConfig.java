package cedrou.factorio.enemies;

import net.minecraftforge.common.ForgeConfigSpec;

import java.util.Arrays;
import java.util.List;

public class FactorioEnemiesConfig {

    public static final ForgeConfigSpec SPEC;

    /** 1-in-N chance per chunk that a nest cluster generates. Lower = more frequent. */
    public static final ForgeConfigSpec.IntValue CLUSTER_RARITY;

    /** Minimum number of nest blocks placed per cluster. */
    public static final ForgeConfigSpec.IntValue CLUSTER_MIN_NESTS;

    /** Extra nests randomly added on top of the minimum (0 to this value inclusive). */
    public static final ForgeConfigSpec.IntValue CLUSTER_NEST_VARIANCE;

    /**
     * Kill counts needed to advance to each evolution phase.
     * Six values for phases 1–6; phase 0 is the default starting phase.
     */
    public static final ForgeConfigSpec.ConfigValue<List<? extends Integer>> EVO_THRESHOLDS;

    static {
        ForgeConfigSpec.Builder b = new ForgeConfigSpec.Builder();

        b.comment("Nest cluster world generation settings").push("worldgen");

        CLUSTER_RARITY = b
                .comment("1-in-N chance per chunk that a nest cluster spawns. Lower = more clusters.")
                .defineInRange("clusterRarity", 135, 1, 10000);

        CLUSTER_MIN_NESTS = b
                .comment("Minimum number of nest blocks placed per cluster.")
                .defineInRange("clusterMinNests", 7, 1, 64);

        CLUSTER_NEST_VARIANCE = b
                .comment("Random extra nests added per cluster (uniform 0..variance).")
                .defineInRange("clusterNestVariance", 4, 0, 64);

        b.pop();

        b.comment("Evolution / phase progression settings").push("evolution");

        EVO_THRESHOLDS = b
                .comment("Nest kills required to reach each phase (6 entries for phases 1–6).")
                .defineList("phaseThresholds",
                        Arrays.asList(45, 105, 180, 300, 450, 630),
                        o -> o instanceof Integer && (Integer) o >= 0);

        b.pop();

        SPEC = b.build();
    }
}
