package com.msg.vietnamsdelight.registries.loot_table;

import java.util.function.BiFunction;

import com.mojang.serialization.MapCodec;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.functions.LootItemFunction;
import net.minecraft.world.level.storage.loot.functions.LootItemFunctionType;

public class VDLootItemFunctions {
    
    // private static <T extends LootItemFunction> LootItemFunctionType<T> register(String name, MapCodec<T> codec) {
    //     return (LootItemFunctionType)Registry.register(BuiltInRegistries.LOOT_FUNCTION_TYPE, ResourceLocation.withDefaultNamespace(name), new LootItemFunctionType(codec));
    // }

    // public static BiFunction<ItemStack, LootContext, ItemStack> compose(List<? extends BiFunction<ItemStack, LootContext, ItemStack>> functions) {
    //     List<BiFunction<ItemStack, LootContext, ItemStack>> list = List.copyOf(functions);
    //     BiFunction var10000;
    //     switch (list.size()) {
    //         case 0:
    //             var10000 = IDENTITY;
    //             break;
    //         case 1:
    //             var10000 = (BiFunction)list.get(0);
    //             break;
    //         case 2:
    //             BiFunction<ItemStack, LootContext, ItemStack> biFunction = (BiFunction)list.get(0);
    //             BiFunction<ItemStack, LootContext, ItemStack> biFunction2 = (BiFunction)list.get(1);
    //             var10000 = (itemStack, lootContext) -> (ItemStack)biFunction2.apply((ItemStack)biFunction.apply(itemStack, lootContext), lootContext);
    //             break;
    //         default:
    //             var10000 = (itemStack, lootContext) -> {
    //             for(BiFunction<ItemStack, LootContext, ItemStack> biFunction : list) {
    //                 itemStack = (ItemStack)biFunction.apply(itemStack, lootContext);
    //             }

    //             return itemStack;
    //             };
    //     }

    //     return var10000;
    // }
}
