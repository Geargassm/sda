package cedrou.factorio.enemies;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.context.CommandContext;

import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;

import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = FactorioEnemiesMod.MODID)
public class FactorioEnemiesCommands {

    @SubscribeEvent
    public static void onRegisterCommands(RegisterCommandsEvent event) {
        CommandDispatcher<CommandSourceStack> dispatcher = event.getDispatcher();

        dispatcher.register(
            Commands.literal("factorioenemies")
                .requires(src -> src.hasPermission(2))
                .then(Commands.literal("phase")
                    .then(Commands.literal("get")
                        .executes(FactorioEnemiesCommands::getPhase))
                    .then(Commands.literal("set")
                        .then(Commands.argument("phase", IntegerArgumentType.integer(0, 6))
                            .executes(ctx -> setPhase(ctx, IntegerArgumentType.getInteger(ctx, "phase"))))))
                .then(Commands.literal("kills")
                    .then(Commands.literal("get")
                        .executes(FactorioEnemiesCommands::getKills))
                    .then(Commands.literal("set")
                        .then(Commands.argument("count", IntegerArgumentType.integer(0))
                            .executes(ctx -> setKills(ctx, IntegerArgumentType.getInteger(ctx, "count"))))))
        );
    }

    private static int getPhase(CommandContext<CommandSourceStack> ctx) {
        ServerLevel level = ctx.getSource().getLevel();
        NestProgressData data = NestProgressData.get(level);
        int phase = data.getPhase();
        int kills = data.getKillCount();
        ctx.getSource().sendSuccess(() -> Component.literal("Phase: " + phase + "  |  Kills: " + kills), false);
        return phase;
    }

    private static int getKills(CommandContext<CommandSourceStack> ctx) {
        ServerLevel level = ctx.getSource().getLevel();
        NestProgressData data = NestProgressData.get(level);
        int kills = data.getKillCount();
        int phase = data.getPhase();
        ctx.getSource().sendSuccess(() -> Component.literal("Kills: " + kills + "  |  Phase: " + phase), false);
        return kills;
    }

    private static int setPhase(CommandContext<CommandSourceStack> ctx, int phase) {
        ServerLevel level = ctx.getSource().getLevel();
        NestProgressData data = NestProgressData.get(level);
        int killCount = killsForPhase(phase);
        data.setKillCount(killCount, level);
        ctx.getSource().sendSuccess(() -> Component.literal("Set phase to " + phase + " (kills: " + killCount + ")"), true);
        return phase;
    }

    private static int setKills(CommandContext<CommandSourceStack> ctx, int count) {
        ServerLevel level = ctx.getSource().getLevel();
        NestProgressData data = NestProgressData.get(level);
        data.setKillCount(count, level);
        int phase = data.getPhase();
        ctx.getSource().sendSuccess(() -> Component.literal("Set kills to " + count + "  |  Phase: " + phase), true);
        return count;
    }

    private static int killsForPhase(int phase) {
        if (phase == 0) return 0;
        List<? extends Integer> thresholds = FactorioEnemiesConfig.EVO_THRESHOLDS.get();
        int idx = phase - 1;
        return idx < thresholds.size() ? thresholds.get(idx) : 0;
    }
}
