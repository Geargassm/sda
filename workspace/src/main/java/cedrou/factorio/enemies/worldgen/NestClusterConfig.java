package cedrou.factorio.enemies.worldgen;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

public class NestClusterConfig implements FeatureConfiguration {
    public static final Codec<NestClusterConfig> CODEC = RecordCodecBuilder.create(inst ->
            inst.group(Codec.BOOL.fieldOf("is_biter").forGetter(c -> c.isBiter))
                    .apply(inst, NestClusterConfig::new));

    public final boolean isBiter;

    public NestClusterConfig(boolean isBiter) {
        this.isBiter = isBiter;
    }
}
