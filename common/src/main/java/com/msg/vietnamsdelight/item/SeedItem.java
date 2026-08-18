package com.msg.vietnamsdelight.item;

import com.msg.vietnamsdelight.mixin.BushBlockInvoker;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;

public class SeedItem extends ItemNameBlockItem {

    public SeedItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    protected boolean canPlace(BlockPlaceContext context, BlockState state) {
        Player player = context.getPlayer();
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        CollisionContext collisionContext = player == null ? CollisionContext.empty() : CollisionContext.of(player);
        return (!this.mustSurvive() || ((BushBlockInvoker)(BushBlock)state.getBlock()).modid$mayPlaceOn(level.getBlockState(pos.below()), level, pos)) && level.isUnobstructed(state, pos, collisionContext);
    }
    
}
