package com.msg.vietnamsdelight.registries.loot_table;

import com.msg.vietnamsdelight.Constants;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.LootTable;

public interface VDLootTables {

    static ResourceKey<LootTable> CROP_YIELD = register("crop_yield");

    private static ResourceKey<LootTable> register(String name) {
        try {
            return ResourceKey.create(Registries.LOOT_TABLE, Constants.resourcesLocation(name));
        } catch (Exception e) {
            throw new IllegalArgumentException(name + " is already a registered built-in loot table");
        }
    }
}
