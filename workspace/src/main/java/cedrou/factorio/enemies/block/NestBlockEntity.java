package cedrou.factorio.enemies.block;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import cedrou.factorio.enemies.NestProgressData;
import cedrou.factorio.enemies.entity.NestEntity;
import cedrou.factorio.enemies.init.FactorioEnemiesModBlockEntities;
import cedrou.factorio.enemies.init.FactorioEnemiesModEntities;

public class NestBlockEntity extends BlockEntity {
    private int tier;
    private boolean isBiter;
    private int spawnTimer = 0;
    private boolean aggroed = false;
    private int aggroTimer = 0;
    private boolean hasSpawnedWorm = false;
    private int currentHealth = -1;

    public NestBlockEntity(BlockPos pos, BlockState state, int tier, boolean isBiter) {
        super(FactorioEnemiesModBlockEntities.NEST_BLOCK_ENTITY.get(), pos, state);
        this.tier = tier;
        this.isBiter = isBiter;
    }

    public NestBlockEntity(BlockPos pos, BlockState state) {
        this(pos, state, 0, true);
    }

    public int getTier() { return tier; }
    public boolean isBiter() { return isBiter; }

    public int maxHealth() {
        return 50 + tier * 50; // tier 0=50, tier 6=350
    }

    public boolean damage(int amount) {
        if (currentHealth <= 0) currentHealth = maxHealth();
        currentHealth -= amount;
        setChanged();
        return currentHealth <= 0;
    }

    public int getCurrentHealth() { return currentHealth; }

    public void aggro() {
        this.aggroed = true;
        this.aggroTimer = 0;
        this.setChanged();
    }

    public static void serverTick(Level level, BlockPos pos, BlockState state, NestBlockEntity be) {
        if (!(level instanceof ServerLevel sl)) return;
        if (level.getNearestPlayer(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, 64, false) == null) return;
        NestEntity entity = FactorioEnemiesModEntities.NEST_ENTITY.get().create(sl);
        if (entity == null) return;
        int phase = NestProgressData.get(sl).getPhase();
        entity.init(phase, be.isBiter);
        entity.setPos(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5);
        sl.addFreshEntity(entity);
        level.setBlock(pos, net.minecraft.world.level.block.Blocks.AIR.defaultBlockState(), 3);
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.putInt("Tier", tier);
        tag.putBoolean("IsBiter", isBiter);
        tag.putInt("SpawnTimer", spawnTimer);
        tag.putBoolean("Aggroed", aggroed);
        tag.putInt("AggroTimer", aggroTimer);
        tag.putBoolean("HasSpawnedWorm", hasSpawnedWorm);
        tag.putInt("CurrentHealth", currentHealth);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        tier = tag.getInt("Tier");
        isBiter = tag.getBoolean("IsBiter");
        spawnTimer = tag.getInt("SpawnTimer");
        aggroed = tag.getBoolean("Aggroed");
        aggroTimer = tag.getInt("AggroTimer");
        hasSpawnedWorm = tag.getBoolean("HasSpawnedWorm");
        currentHealth = tag.getInt("CurrentHealth");
    }
}
