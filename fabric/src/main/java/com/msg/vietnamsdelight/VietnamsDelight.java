package com.msg.vietnamsdelight;

import com.msg.vietnamsdelight.registries.VDBrewings;
import com.msg.vietnamsdelight.registries.VDCraftingRecipeType;
import com.msg.vietnamsdelight.registries.VDItems;
import com.msg.vietnamsdelight.registries.loot_table.VDLootItemConditions;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;

public class VietnamsDelight implements ModInitializer {
    
    @Override
    public void onInitialize() {
        Common.init();
        VDCraftingRecipeType.init();
        VDLootItemConditions.init();
        VDBrewings.registerCustomBrewRecipe();
        registryComposting();
    }

    private void registryComposting(){
        CompostingChanceRegistry.INSTANCE.add(VDItems.COFFEE_BEANS, 0.3F);
        CompostingChanceRegistry.INSTANCE.add(VDItems.ROAST_COFFEE_BEANS, 0.1F);
    }
}