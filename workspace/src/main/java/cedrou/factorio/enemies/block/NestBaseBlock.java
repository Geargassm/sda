package cedrou.factorio.enemies.block;

import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import cedrou.factorio.enemies.NestProgressData;
import cedrou.factorio.enemies.init.FactorioEnemiesModBlockEntities;
import cedrou.factorio.enemies.init.FactorioEnemiesModBlocks;

import javax.annotation.Nullable;

public abstract class NestBaseBlock extends BaseEntityBlock implements SimpleWaterloggedBlock {
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    protected NestBaseBlock() {
        super(BlockBehaviour.Properties.of()
                .sound(new ForgeSoundType(0.4f, 1.0f,
                        () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("factorio_enemies:spawner-destruction-2")),
                        () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("factorio_enemies:spawner-vie")),
                        () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("factorio_enemies:spawner-vie")),
                        () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("factorio_enemies:spawner-destruction-2")),
                        () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("factorio_enemies:spawner-destruction-2"))))
                .strength(3f, 5f)
                .noOcclusion()
                .isRedstoneConductor((bs, br, bp) -> false));
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(WATERLOGGED, false));
    }

    protected abstract int getTier();
    protected abstract boolean isBiter();

    // Shared tier→block mapping used by NestBlockEntity and NestClusterFeature
    public static Block forTierAndType(int tier, boolean isBiter) {
        if (isBiter) {
            return switch (tier) {
                case 1 -> FactorioEnemiesModBlocks.NESTBITERSMALLMEDIUM.get();
                case 2 -> FactorioEnemiesModBlocks.NESTBITERMEDIUM.get();
                case 3 -> FactorioEnemiesModBlocks.NESTBITERMEDIUMBIG.get();
                case 4 -> FactorioEnemiesModBlocks.NESTBITERBIG.get();
                case 5 -> FactorioEnemiesModBlocks.NESTBITERBIGBEHEMOTH.get();
                case 6 -> FactorioEnemiesModBlocks.NESTBITERBEHEMOTH.get();
                default -> FactorioEnemiesModBlocks.NESTBITER.get();
            };
        } else {
            return switch (tier) {
                case 1 -> FactorioEnemiesModBlocks.NESTSPITTERSSMALLSMEDIUM.get();
                case 2 -> FactorioEnemiesModBlocks.NESTSPITTERSMEDIUM.get();
                case 3 -> FactorioEnemiesModBlocks.NESTSPITTERSMEDIUMBIG.get();
                case 4 -> FactorioEnemiesModBlocks.NESTSPITTERSBIG.get();
                case 5 -> FactorioEnemiesModBlocks.NESTSPITTERSBIGBEHEMOTH.get();
                case 6 -> FactorioEnemiesModBlocks.NESTSPITTERSBEHEMOTH.get();
                default -> FactorioEnemiesModBlocks.NESTSPITTERS_SMALLS.get();
            };
        }
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new NestBlockEntity(pos, state, getTier(), isBiter());
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        if (level.isClientSide()) return null;
        return createTickerHelper(type, FactorioEnemiesModBlockEntities.NEST_BLOCK_ENTITY.get(), NestBlockEntity::serverTick);
    }

    @Override
    public void attack(BlockState state, Level level, BlockPos pos, Player player) {
        if (!level.isClientSide() && level.getBlockEntity(pos) instanceof NestBlockEntity be) {
            be.aggro();
            int dmg = (int) Math.max(1, player.getAttributeValue(Attributes.ATTACK_DAMAGE));
            if (be.damage(dmg) && level instanceof ServerLevel sl) {
                NestProgressData.get(sl).incrementKills();
                level.destroyBlock(pos, false);
            }
        }
    }

    @Override
    public void playerWillDestroy(Level level, BlockPos pos, BlockState state, Player player) {
        if (level instanceof ServerLevel sl) {
            NestProgressData.get(sl).incrementKills();
        }
        super.playerWillDestroy(level, pos, state, player);
    }

    @Override
    public boolean skipRendering(BlockState state, BlockState adjacentBlockState, Direction side) {
        return adjacentBlockState.getBlock() == this || super.skipRendering(state, adjacentBlockState, side);
    }

    @Override
    public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
        return state.getFluidState().isEmpty();
    }

    @Override
    public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
        return 0;
    }

    @Override
    public VoxelShape getVisualShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return Shapes.empty();
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(FACING, WATERLOGGED);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        boolean flag = context.getLevel().getFluidState(context.getClickedPos()).getType() == Fluids.WATER;
        return super.getStateForPlacement(context).setValue(FACING, context.getHorizontalDirection().getOpposite()).setValue(WATERLOGGED, flag);
    }

    public BlockState rotate(BlockState state, Rotation rot) {
        return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
    }

    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    @Override
    public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor world, BlockPos currentPos, BlockPos facingPos) {
        if (state.getValue(WATERLOGGED)) {
            world.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(world));
        }
        return super.updateShape(state, facing, facingState, world, currentPos, facingPos);
    }
}
