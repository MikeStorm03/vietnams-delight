package com.msg.vietnamsdelight.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;

@Mixin(BushBlock.class)
public interface BushBlockInvoker {
    @Invoker("mayPlaceOn")
    boolean modid$mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos);

}
