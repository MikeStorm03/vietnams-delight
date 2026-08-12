package com.msg.vietnamsdelight.registries.loot_table;

import java.util.List;
import java.util.Optional;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.ComponentSerialization;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootContext.EntityTarget;
import net.minecraft.world.level.storage.loot.functions.LootItemConditionalFunction;
import net.minecraft.world.level.storage.loot.functions.LootItemFunctionType;
import net.minecraft.world.level.storage.loot.functions.SetNameFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;

public class SetBlockStateFunction extends LootItemConditionalFunction {
    // public static final MapCodec<SetBlockStateFunction> CODEC = RecordCodecBuilder.mapCodec((instance) -> commonFields(instance).and(instance.group(ComponentSerialization.CODEC.optionalFieldOf("set_block_state")
    // .forGetter((setBlockStateFunction) -> setBlockStateFunction.blockState), EntityTarget.CODEC.optionalFieldOf("entity").forGetter((setNameFunction) -> setNameFunction.resolutionContext), SetNameFunction.Target.CODEC.optionalFieldOf("target", SetNameFunction.Target.CUSTOM_NAME).forGetter((setNameFunction) -> setNameFunction.target))).apply(instance, SetBlockStateFunction::new));
    private final BlockState blockState;
    private final BlockPos blockPos;

    protected SetBlockStateFunction(List<LootItemCondition> predicates, BlockState blockState, BlockPos blockPos) {
        super(predicates);
        this.blockState = blockState;
        this.blockPos = blockPos;
    }

    @Override
    public LootItemFunctionType<? extends LootItemConditionalFunction> getType() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getType'");
    }

    @Override
    protected ItemStack run(ItemStack stack, LootContext context) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'run'");
    }
    
}
