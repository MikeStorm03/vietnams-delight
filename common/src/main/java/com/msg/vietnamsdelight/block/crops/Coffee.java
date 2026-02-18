package com.msg.vietnamsdelight.block.crops;

import java.util.function.Supplier;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.gameevent.GameEvent.Context;
import net.minecraft.world.phys.BlockHitResult;

public class Coffee extends VD2BlocksTallCrop {

    public Coffee(Properties properties, Supplier<Item> seedItem) {
        super(properties, seedItem);
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        return !this.isMaxAge(state) && stack.is(Items.BONE_MEAL) ? ItemInteractionResult.SKIP_DEFAULT_BLOCK_INTERACTION : super.useItemOn(stack, state, level, pos, player, hand, hitResult);
    }

    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if (this.isMaxAge(state)) {
            popResource(level, pos, new ItemStack(this.getBaseSeedId(), 3 + level.random.nextInt(3)));
            level.playSound(null, pos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + level.random.nextFloat() * 0.4F);
            BlockState blockState = state.setValue(AGE, 5);
            level.setBlock(pos, blockState, 2);
            if (this.isUpper(blockState)) level.setBlock(pos.below(), blockState.setValue(UPPER, false), 2);
            else level.setBlock(pos.above(), blockState.setValue(UPPER, true), 2);
            level.gameEvent(GameEvent.BLOCK_CHANGE, pos, Context.of(player, blockState));
            return InteractionResult.sidedSuccess(level.isClientSide);
        } else {
            return super.useWithoutItem(state, level, pos, player, hitResult);
        }
    }
}