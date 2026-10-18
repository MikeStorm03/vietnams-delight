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
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;

public abstract class Perennical2BlocksTallCrop extends VD2BlocksTallCrop {

    protected final Supplier<Item> seedItem;
    @Nullable
    protected ResourceKey<LootTable> yields;

    public Perennical2BlocksTallCrop(Properties properties, Supplier<Item> seedItem) {
        super(properties, seedItem);
        this.seedItem = seedItem;
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        return !this.isMaxAge(state) && stack.is(Items.BONE_MEAL) ? ItemInteractionResult.SKIP_DEFAULT_BLOCK_INTERACTION : super.useItemOn(stack, state, level, pos, player, hand, hitResult);
    }

    protected void revertToAge(BlockState state, Level level, BlockPos pos) {
        this.revertToAge(state, level, pos, 5);
    }

    protected void revertToAge(BlockState state, Level level, BlockPos pos, int age) {
        if (this.isUpper(state)) {
            if (this.ageGrowTaller() < age){
                level.setBlock(pos, Blocks.AIR.defaultBlockState(), UPDATE_SUPPRESS_DROPS | UPDATE_CLIENTS);
                level.setBlock(pos.below(), this.getStateForAge(age, DoubleBlockHalf.LOWER), UPDATE_CLIENTS);
            } else {
                level.setBlock(pos.below(), this.getStateForAge(age, DoubleBlockHalf.LOWER), UPDATE_CLIENTS);
                level.setBlock(pos, this.getStateForAge(age, DoubleBlockHalf.UPPER), UPDATE_CLIENTS);
            }
        }
        else {
            if (this.ageGrowTaller() < age){
                level.setBlock(pos.above(), Blocks.AIR.defaultBlockState(), UPDATE_SUPPRESS_DROPS | UPDATE_CLIENTS);
                level.setBlock(pos, this.getStateForAge(age, DoubleBlockHalf.LOWER), UPDATE_CLIENTS);
            }
            else {
                level.setBlock(pos, this.getStateForAge(age, DoubleBlockHalf.LOWER), UPDATE_CLIENTS);
                level.setBlock(pos.above(), this.getStateForAge(age, DoubleBlockHalf.UPPER), UPDATE_CLIENTS);
            }
        }
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
                                                                                    .withParameter(LootContextParams.TOOL, ItemStack.EMPTY)
                                                                                    .withParameter(LootContextParams.BLOCK_STATE, state);
            LootParams lootParams = builder.create(VDLootContexts.CROP_YIELD);
            ObjectArrayList<ItemStack> itemStacks = level.getServer().reloadableRegistries().getLootTable(resourceKey).getRandomItems(lootParams);
            if (!itemStacks.isEmpty()) {
                for (ItemStack i : itemStacks) popResource(level, pos, i);
                this.revertToAge(state, level, pos);
            }
        }
        return InteractionResult.sidedSuccess(level.isClientSide);
    }
}