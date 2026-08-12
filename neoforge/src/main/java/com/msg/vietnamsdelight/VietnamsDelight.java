package com.msg.vietnamsdelight;

import com.msg.vietnamsdelight.registries.VDBrewings;
import com.msg.vietnamsdelight.registries.VDCraftingRecipeType;
import com.msg.vietnamsdelight.registries.VDItems;

import net.minecraft.core.Registry;

// import me.emafire003.dev.custombrewrecipes.CustomBrewRecipeRegister;

import net.minecraft.core.registries.BuiltInRegistries;
// import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.RegisterEvent;

@Mod(Constants.ID)
@EventBusSubscriber(modid = Constants.ID)
public class VietnamsDelight {

    public VietnamsDelight() {
        Common.init();
    }

    @SubscribeEvent
    public static void registerSetup(RegisterEvent event) {
        Registry<?> registry = event.getRegistry();
        if (registry.equals(BuiltInRegistries.ITEM)) VDBrewings.registerCustomBrewRecipe();
        if (registry.equals(BuiltInRegistries.RECIPE_SERIALIZER)) VDCraftingRecipeType.init();
    }

}