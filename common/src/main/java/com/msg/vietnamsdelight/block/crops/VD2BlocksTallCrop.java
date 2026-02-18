package com.msg.vietnamsdelight.block.crops;

import java.util.function.Supplier;

import com.msg.vietnamsdelight.multiloader_compat.vanilla_classes.MinecraftMethods;
import com.msg.vietnamsdelight.platform.Services;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Axis;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class VD2BlocksTallCrop extends CropBlock {
    public static final BooleanProperty UPPER = BooleanProperty.create("upper");
    protected final Supplier<Item> seedItem;
    private static final VoxelShape[] SHAPE_UNDER = new VoxelShape[]{Block.box(0.0, 0.0, 0.0, 16.0, 2.0, 16.0),
                                                                    Block.box(0.0, 0.0, 0.0, 16.0, 8.0, 16.0),
                                                                    Block.box(0.0, 0.0, 0.0, 16.0, 14.0, 16.0),
                                                                    Block.box(0.0, 0.0, 0.0, 16.0, 16.0, 16.0)};
    private static final VoxelShape[] SHAPE_UPPER = new VoxelShape[]{Block.box(0.0, 0.0, 0.0, 16.0, 4.0, 16.0),
                                                                    Block.box(0.0, 0.0, 0.0, 16.0, 10.0, 16.0),
                                                                    Block.box(0.0, 0.0, 0.0, 16.0, 16.0, 16.0),
                                                                    Block.box(0.0, 0.0, 0.0, 16.0, 16.0, 16.0)};

    public VD2BlocksTallCrop(Properties properties, Supplier<Item> seedItem) {
        super(properties);
        this.seedItem = seedItem;
        this.registerDefaultState((BlockState)(this.stateDefinition.any()).setValue(this.getAgeProperty(), 0).setValue(UPPER, false));
    }

    @Override
    protected BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor level, BlockPos pos, BlockPos neighborPos) {
        if (!state.canSurvive(level, pos)) return Blocks.AIR.defaultBlockState();
        if (direction.getAxis() == Axis.Y) {
            if (this.isUpper(state)) {
                if (direction == Direction.DOWN && this.getAge(neighborState) != this.getAge(state))
                    return this.getAge(neighborState) >= this.ageGrowTaller() ? this.setAge(state, this.getAge(neighborState)) : Blocks.AIR.defaultBlockState();
            } else if (direction == Direction.UP && (this.getAge(state) >= this.ageGrowTaller() && this.getAge(neighborState) != this.getAge(state)))
                return this.setAge(state, this.getAge(neighborState));
        }
        return state;
    }
    
    @Override 
    protected ItemLike getBaseSeedId() {
        return seedItem.get();
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos) {
        return super.mayPlaceOn(state, level, pos);
    }

    public void growCrops(Level level, BlockPos pos, BlockState state, int nextAge) {
        int currentAge = this.getAge(state);
        nextAge = currentAge + nextAge;
        nextAge = nextAge > 7 ? 7 : nextAge;

        if (currentAge < this.ageGrowTaller()) {
            BlockState aboveBlock = level.getBlockState(pos.above());
            if (nextAge >= this.ageGrowTaller()) {
                if (aboveBlock.isAir()) {
                    level.setBlock(pos, this.getStateForAge(nextAge), 2);
                    level.setBlock(pos.above(),
                                    this.defaultBlockState().setValue(this.getAgeProperty(), nextAge)
                                                            .setValue(UPPER, true),
                                    2);
                } else  level.setBlock(pos, this.getStateForAge(2), 2);
            }
            else level.setBlock(pos, this.getStateForAge(nextAge), 2);
        } else if (currentAge < this.getMaxAge()) {
            if (this.isUpper(state)) {
                level.setBlock(pos,
                                this.defaultBlockState().setValue(this.getAgeProperty(), nextAge)
                                                        .setValue(UPPER, true),
                                2);
                level.setBlock(pos.below(), this.getStateForAge(nextAge), 2);
            } else {
                level.setBlock(pos.above(),
                                this.defaultBlockState().setValue(this.getAgeProperty(), nextAge)
                                                        .setValue(UPPER, true),
                                2);
                level.setBlock(pos, this.getStateForAge(nextAge), 2);
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
        else {
            return ((this.getAge(state) < this.ageGrowTaller() || level.getBlockState(pos.above()).is(this)) && super.canSurvive(state, level, pos));
        }
    }

    public boolean isUpper(BlockState state) {
        return state.getValue(UPPER);
    }

    public int ageGrowTaller() {
        return 3;
    }

    public BlockState setAge(BlockState state, int age) {
        return this.isUpper(state) ? this.defaultBlockState().setValue(this.getAgeProperty(), age).setValue(UPPER, true) : this.defaultBlockState().setValue(this.getAgeProperty(), age);
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        int textureArray = this.isUpper(state) ? this.getAge(state) - 3  : this.getAge(state);
        if (textureArray < 0) textureArray = 0;
        else if (textureArray > 3) textureArray = 3;
        return this.isUpper(state) ? SHAPE_UPPER[textureArray] : SHAPE_UNDER[textureArray];
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{AGE, UPPER});
    }
}