package com.msg.vietnamsdelight;

import com.msg.vietnamsdelight.registries.VDBrewings;
import com.msg.vietnamsdelight.registries.VDCraftingRecipeType;
import com.msg.vietnamsdelight.registries.loot_table.VDLootContexts;
import com.msg.vietnamsdelight.registries.loot_table.VDLootTables;

import net.fabricmc.api.ModInitializer;

public class VietnamsDelight implements ModInitializer {
    
    @Override
    public void onInitialize() {
        Common.init();
        VDCraftingRecipeType.init();
        VDLootContexts.init();
        VDLootTables.init();
        VDBrewings.registerCustomBrewRecipe();
    }
}