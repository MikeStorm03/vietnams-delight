package com.msg.vietnamsdelight.registries.loot_table;

import com.mojang.serialization.MapCodec;
import com.msg.vietnamsdelight.Constants;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemConditionType;

public interface VDLootItemConditions {

    LootItemConditionType GET_EXPLODED = register("get_exploded", GetExplodedCondition.CODEC);

    private static LootItemConditionType register(String name, MapCodec<? extends LootItemCondition> codec) {
        return Registry.register(BuiltInRegistries.LOOT_CONDITION_TYPE, Constants.resourcesLocation(name), new LootItemConditionType(codec));
    }

    static void init(){}    
}
