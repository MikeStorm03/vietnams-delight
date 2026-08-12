package com.msg.vietnamsdelight.registries.loot_table;

import java.util.function.Consumer;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.msg.vietnamsdelight.Constants;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.functions.LootItemFunctions;
import net.minecraft.world.level.storage.loot.parameters.LootContextParam;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;

public class VDLootContexts {

    private static final BiMap<ResourceLocation, LootContextParamSet> REGISTRY = HashBiMap.create();
    public static final LootContextParamSet CROP_YIELD = register("crop_yield", (builder) -> builder.required(LootContextParams.BLOCK_STATE).required(LootContextParams.ORIGIN).required(LootContextParams.TOOL).optional(LootContextParams.THIS_ENTITY));

    private static LootContextParamSet register(String registryName, Consumer<LootContextParamSet.Builder> builderConsumer) {
        LootContextParamSet.Builder builder = new LootContextParamSet.Builder();
        builderConsumer.accept(builder);
        LootContextParamSet lootContextParamSet = builder.build();
        ResourceLocation resourceLocation = Constants.resourcesLocation(registryName);
        LootContextParamSet lootContextParamSet2 = REGISTRY.put(resourceLocation, lootContextParamSet);
        if (lootContextParamSet2 != null) {
            throw new IllegalStateException("Loot table parameter set " + String.valueOf(resourceLocation) + " is already registered");
        } else {
            return lootContextParamSet;
        }
    }

    public static void init(){}
}
