package com.msg.vietnamsdelight.block;

import com.mojang.serialization.MapCodec;
import com.msg.vietnamsdelight.Constants;
import com.msg.vietnamsdelight.registries.VDItems;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.VoxelShape;

public final class Coffee extends Perennical2BlocksTallCrop {

    public static final MapCodec<Coffee> CODEC = simpleCodec(Coffee::new);
    public static final IntegerProperty AGE = BlockStateProperties.AGE_5;
    private static final VoxelShape[] SHAPE_LOWER = new VoxelShape[]{box(3.0, -1.0, 3.0, 13.0, 10.0, 13.0),
                                                                    box(2.0, -1.0, 2.0, 14.0, 14.0, 14.0),
                                                                    box(2.0, -1.0, 2.0, 14.0, 15.0, 14.0),
                                                                    box(1.0, -1.0, 1.0, 14.0, 16.0, 14.0)};
    private static final VoxelShape[] SHAPE_UPPER = new VoxelShape[]{box(1.0, 0.0, 1.0, 14.0, 5.0, 14.0),
                                                                    box(1.0, 0.0, 1.0, 14.0, 6.0, 14.0),
                                                                    box(1.0, 0.0, 1.0, 14.0, 8.0, 14.0)};

    public Coffee(Properties properties) {
        super(properties, () -> VDItems.COFFEE_BEANS);
    }

    @Override
    protected boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        if (!this.isUpper(state) && level.getBlockState(pos.below()).is(BlockTags.DIRT) && hasSufficientLight(level, pos)) return true;
        return super.canSurvive(state, level, pos);
    }

    // @Override
    // protected boolean mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos) {
    //     Constants.LOG.info("super method return: {}\nis below farmland: {}", super.mayPlaceOn(state, level, pos), state.is(Blocks.FARMLAND));
    //     return super.mayPlaceOn(state, level, pos);
    // }

    @Override
    public int getMaxAge() {
        return 5;
    }

    @Override
    public int ageGrowTaller() {
        return 3;
    }

    @Override
    protected IntegerProperty getAgeProperty() {
        return AGE;
    }

    @Override
    protected void revertToAge(BlockState state, Level level, BlockPos pos) {
        this.revertToAge(state, level, pos, 3);
    }

    @Override
    protected int getBonemealAgeIncrease(Level level) {
        return Mth.nextInt(level.random, 0, 1);
    }

    @Override
    protected void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        if (entity instanceof LivingEntity && entity.getType() != EntityType.BEE) {
            entity.makeStuckInBlock(state, new Vec3(0.8F, 0.75, 0.8F));
        }
    }

    @Override
    protected VoxelShape[] getUpperShapes(){
        return SHAPE_UPPER;
    }

    @Override
    protected VoxelShape[] getLowerShapes(){
        return SHAPE_LOWER;
    }
}