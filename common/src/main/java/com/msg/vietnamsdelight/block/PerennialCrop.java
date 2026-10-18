package com.msg.vietnamsdelight.block;

import java.util.function.Supplier;

import org.jetbrains.annotations.Nullable;

import com.msg.vietnamsdelight.registries.loot_table.VDLootContexts;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;

public abstract class PerennialCrop extends CropBlock {

    protected final Supplier<Item> seedItem;
    @Nullable
    protected ResourceKey<LootTable> yields;
    // private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{Block.box(0.0, 0.0, 0.0, 16.0, 2.0, 16.0),
    //                                                                 Block.box(0.0, 0.0, 0.0, 16.0, 3.0, 16.0),
    //                                                                 Block.box(0.0, 0.0, 0.0, 16.0, 4.0, 16.0),
    //                                                                 Block.box(0.0, 0.0, 0.0, 16.0, 5.0, 16.0),
    //                                                                 Block.box(0.0, 0.0, 0.0, 16.0, 6.0, 16.0),
    //                                                                 Block.box(0.0, 0.0, 0.0, 16.0, 7.0, 16.0),
    //                                                                 Block.box(0.0, 0.0, 0.0, 16.0, 8.0, 16.0),
    //                                                                 Block.box(0.0, 0.0, 0.0, 16.0, 9.0, 16.0)};

    public PerennialCrop(Properties properties, Supplier<Item> seedItem) {
        super(properties);
        this.seedItem = seedItem;
    }
    
    @Override 
    public ItemLike getBaseSeedId() {
        return seedItem.get();
    }

    protected BlockState revertToAge(BlockState state, Level level, BlockPos pos) {
        return this.revertToAge(state, level, pos, 5);
    }

    protected BlockState revertToAge(BlockState state, Level level, BlockPos pos, int age) {
        BlockState blockState = state.setValue(AGE, age);
        level.setBlock(pos, blockState, 2);
        return blockState;
    }

    protected ResourceKey<LootTable> getCropYield() {
        if (this.yields == null) {
            ResourceLocation resourceLocation = BuiltInRegistries.BLOCK.getKey(this.asBlock());
            this.yields = ResourceKey.create(Registries.LOOT_TABLE, resourceLocation.withPrefix("crop_yield/"));
        }
        return this.yields;
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        ResourceKey<LootTable> resourceKey = this.getCropYield();
        if (resourceKey == BuiltInLootTables.EMPTY) {
            return InteractionResult.PASS;
        }
        if (!level.isClientSide){   
            LootParams.Builder builder = (new LootParams.Builder((ServerLevel) level))
                                                                                    .withParameter(LootContextParams.ORIGIN, Vec3.atCenterOf(pos))
                                                                                    .withParameter(LootContextParams.TOOL, ItemStack.EMPTY);
            LootParams lootParams = builder.withParameter(LootContextParams.BLOCK_STATE, state).create(VDLootContexts.CROP_YIELD);
            ObjectArrayList<ItemStack> lootTable = level.getServer().reloadableRegistries().getLootTable(resourceKey).getRandomItems(lootParams);
            if (!lootTable.isEmpty()) {
                for (ItemStack i : lootTable) popResource(level, pos, i);
                this.revertToAge(state, level, pos);
            }
        }
        return InteractionResult.sidedSuccess(level.isClientSide);
    }

    // protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
    //     return SHAPE_BY_AGE[this.getAge(state)];
    // }
}
