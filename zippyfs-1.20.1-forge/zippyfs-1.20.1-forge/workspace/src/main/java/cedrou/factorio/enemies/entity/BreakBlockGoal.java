package cedrou.factorio.enemies.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;
import java.util.EnumSet;

public class BreakBlockGoal extends Goal {
    private final PathfinderMob mob;
    @Nullable private BlockPos targetBlock;
    private int breakProgress;
    private int lastSentProgress = -1;

    public BreakBlockGoal(PathfinderMob mob) {
        this.mob = mob;
        this.setFlags(EnumSet.of(Flag.MOVE));
    }

    @Override
    public boolean canUse() {
        if (!mob.horizontalCollision) return false;
        if (mob.getTarget() == null) return false;
        targetBlock = findBlockingBlock();
        if (targetBlock != null) {
            breakProgress = 0;
            lastSentProgress = -1;
        }
        return targetBlock != null;
    }

    @Override
    public boolean canContinueToUse() {
        if (targetBlock == null || mob.getTarget() == null) return false;
        BlockState state = mob.level().getBlockState(targetBlock);
        return isBreakable(state, mob.level(), targetBlock);
    }

    @Override
    public void stop() {
        if (targetBlock != null && mob.level() instanceof ServerLevel sl) {
            sl.destroyBlockProgress(mob.getId(), targetBlock, -1);
        }
        targetBlock = null;
        breakProgress = 0;
        lastSentProgress = -1;
    }

    @Override
    public void tick() {
        if (targetBlock == null) return;
        Level level = mob.level();
        BlockState state = level.getBlockState(targetBlock);

        if (!isBreakable(state, level, targetBlock)) {
            stop();
            return;
        }

        float hardness = state.getDestroySpeed(level, targetBlock);
        int totalTicks = Math.max(20, (int) (hardness * 25));

        breakProgress++;

        if (breakProgress % 20 == 0) {
            mob.swing(InteractionHand.MAIN_HAND);
        }

        if (breakProgress % 4 == 0 && level instanceof ServerLevel sl) {
            int visual = Math.min(9, (breakProgress * 10) / totalTicks);
            if (visual != lastSentProgress) {
                lastSentProgress = visual;
                sl.destroyBlockProgress(mob.getId(), targetBlock, visual);
            }
        }

        if (breakProgress >= totalTicks) {
            level.destroyBlock(targetBlock, true, mob);
            stop();
        }
    }

    @Nullable
    private BlockPos findBlockingBlock() {
        LivingEntity target = mob.getTarget();
        if (target == null) return null;

        Level level = mob.level();
        double dx = target.getX() - mob.getX();
        double dz = target.getZ() - mob.getZ();
        double dist = Math.sqrt(dx * dx + dz * dz);
        if (dist < 0.5) return null;

        double nx = dx / dist;
        double nz = dz / dist;

        for (int dy = 0; dy <= 1; dy++) {
            BlockPos pos = BlockPos.containing(mob.getX() + nx, mob.getY() + dy, mob.getZ() + nz);
            BlockState state = level.getBlockState(pos);
            if (isBreakable(state, level, pos)) {
                return pos;
            }
        }
        return null;
    }

    private static boolean isBreakable(BlockState state, Level level, BlockPos pos) {
        if (state.isAir()) return false;
        float hardness = state.getDestroySpeed(level, pos);
        // skip indestructible (hardness < 0) and extremely hard blocks (obsidian+ territory)
        return hardness >= 0 && hardness < 50f;
    }
}
