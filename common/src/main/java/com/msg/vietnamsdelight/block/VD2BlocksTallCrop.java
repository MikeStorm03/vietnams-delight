package com.msg.vietnamsdelight.block;

import java.util.function.Supplier;

import com.msg.vietnamsdelight.reflections.vanilla_classes.MinecraftMethods;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Axis;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.LevelEvent;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public abstract class VD2BlocksTallCrop extends CropBlock {

    public static final EnumProperty<DoubleBlockHalf> HALF = BlockStateProperties.DOUBLE_BLOCK_HALF;
    protected final Supplier<Item> seedItem;
    private static final VoxelShape[] SHAPE_LOWER = new VoxelShape[]{box(0.0, 0.0, 0.0, 16.0, 2.0, 16.0),
                                                                    box(0.0, 0.0, 0.0, 16.0, 8.0, 16.0),
                                                                    box(0.0, 0.0, 0.0, 16.0, 14.0, 16.0),
                                                                    box(0.0, 0.0, 0.0, 16.0, 16.0, 16.0)};
    private static final VoxelShape[] SHAPE_UPPER = new VoxelShape[]{box(0.0, 0.0, 0.0, 16.0, 4.0, 16.0),
                                                                    box(0.0, 0.0, 0.0, 16.0, 10.0, 16.0),
                                                                    box(0.0, 0.0, 0.0, 16.0, 16.0, 16.0),
                                                                    box(0.0, 0.0, 0.0, 16.0, 16.0, 16.0)};

    public VD2BlocksTallCrop(Properties properties, Supplier<Item> seedItem) {
        super(properties);
        this.seedItem = seedItem;
        this.registerDefaultState(this.stateDefinition.any().setValue(HALF, DoubleBlockHalf.LOWER));
    }

    @Override
    protected BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor level, BlockPos pos, BlockPos neighborPos) {
        if (!state.canSurvive(level, pos)) return Blocks.AIR.defaultBlockState();
        if (direction.getAxis() == Axis.Y) {
            if (this.isUpper(state)) {
                if (direction == Direction.DOWN && this.getAge(neighborState) != this.getAge(state))
                    return this.getAge(neighborState) >= this.ageGrowTaller() ? this.getStateForAge(this.getAge(neighborState), DoubleBlockHalf.UPPER) : Blocks.AIR.defaultBlockState();
            } else if (direction == Direction.UP && (this.getAge(state) >= this.ageGrowTaller() && this.getAge(neighborState) != this.getAge(state)))
                return this.getStateForAge(this.getAge(neighborState), DoubleBlockHalf.LOWER);
        }
        return state;
    }

    @Override
    public BlockState playerWillDestroy(Level level, BlockPos pos, BlockState state, Player player) {
        if (!level.isClientSide) {
            if (this.getAge(state) >= this.ageGrowTaller()) preventDropFromLowerPart(level, pos, state, player);
        }
        // DoorBlock

        return super.playerWillDestroy(level, pos, state, player);
    }

    protected static void preventDropFromLowerPart(Level level, BlockPos pos, BlockState state, Player player) {
        if (state.getValue(HALF) == DoubleBlockHalf.UPPER) {
            BlockPos blockpos = pos.below();
            BlockState blockstate = level.getBlockState(blockpos);
            if (blockstate.is(state.getBlock()) && blockstate.getValue(HALF) == DoubleBlockHalf.LOWER) {
                level.setBlock(blockpos,
                            blockstate.getFluidState().is(Fluids.WATER) ? Blocks.WATER.defaultBlockState() : Blocks.AIR.defaultBlockState(),
                            UPDATE_SUPPRESS_DROPS | UPDATE_CLIENTS);
                level.levelEvent(player, LevelEvent.PARTICLES_DESTROY_BLOCK, blockpos, Block.getId(blockstate));
            }
        }
    }

    @Override 
    public ItemLike getBaseSeedId() {
        return seedItem.get();
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos) {
        return super.mayPlaceOn(state, level, pos);
    }

    public void growCrops(Level level, BlockPos pos, BlockState state, int nextAge) {
        int currentAge = this.getAge(state);
        nextAge = currentAge + nextAge;
        nextAge = nextAge > this.getMaxAge() ? this.getMaxAge() : nextAge;

        if (currentAge < this.ageGrowTaller()) {
            BlockState aboveBlock = level.getBlockState(pos.above());
            if (nextAge >= this.ageGrowTaller()) {
            // If there is a block above, it will grow into the age before it grow taller
                if (aboveBlock.isAir()) {
                    level.setBlock(pos, this.getStateForAge(nextAge, DoubleBlockHalf.LOWER), UPDATE_CLIENTS);
                    level.setBlock(pos.above(), this.getStateForAge(nextAge, DoubleBlockHalf.UPPER), UPDATE_CLIENTS);
                } else level.setBlock(pos, this.getStateForAge(this.ageGrowTaller()-1, DoubleBlockHalf.LOWER), UPDATE_CLIENTS);
            }
            else level.setBlock(pos, this.getStateForAge(nextAge), UPDATE_CLIENTS);
        } else if (currentAge < this.getMaxAge()) {
            if (this.isUpper(state)) {
                level.setBlock(pos.below(), this.getStateForAge(nextAge, DoubleBlockHalf.LOWER), UPDATE_CLIENTS);
                level.setBlock(pos, this.getStateForAge(nextAge, DoubleBlockHalf.UPPER), UPDATE_CLIENTS);
            } else {
                level.setBlock(pos, this.getStateForAge(nextAge, DoubleBlockHalf.LOWER), UPDATE_CLIENTS);
                level.setBlock(pos.above(), this.getStateForAge(nextAge, DoubleBlockHalf.UPPER), UPDATE_CLIENTS);
            }
        }
    }

    @Override
    protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (level.getRawBrightness(pos, 0) >= 9) {
            int i = this.getAge(state);
            if (i < this.getMaxAge()) {
                float f = MinecraftMethods.getGrowthSpeed(this, state, level, pos);
                if (random.nextInt((int)(25.0F / f) + 1) == 0) {
                    this.growCrops(level, pos, state, 1);
                }
            }
        }
    }

    @Override
    public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
        this.growCrops(level, pos, state, this.getBonemealAgeIncrease(level));
    }

    @Override
    protected boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        if (this.isUpper(state)) return level.getBlockState(pos.below()).is(this) && this.getAge(state) >= this.ageGrowTaller();
        return ((this.getAge(state) < this.ageGrowTaller() || level.getBlockState(pos.above()).is(this)) && super.canSurvive(state, level, pos));
    }

    public boolean isUpper(BlockState state) {
        return state.getValue(HALF).equals(DoubleBlockHalf.UPPER);
    }

    public int ageGrowTaller() {
        return 3;
    }

    public BlockState getStateForAge(int age, DoubleBlockHalf half) {
        return this.defaultBlockState().setValue(this.getAgeProperty(), age).setValue(HALF, half);
    }

    protected VoxelShape[] getUpperShapes(){
        return SHAPE_UPPER;
    }

    protected VoxelShape[] getLowerShapes(){
        return SHAPE_LOWER;
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        int ageGrowTaller = this.ageGrowTaller();
        int textureArray;
        if (this.isUpper(state)) {
            textureArray = this.getAge(state) - ageGrowTaller;
            if (textureArray < 0) textureArray = 0;
        } else {
            textureArray = this.getAge(state);
            if (textureArray > ageGrowTaller) textureArray = ageGrowTaller;
        }
        return this.isUpper(state) ? this.getUpperShapes()[textureArray] : this.getLowerShapes()[textureArray];
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{this.getAgeProperty(), HALF});
    }
}