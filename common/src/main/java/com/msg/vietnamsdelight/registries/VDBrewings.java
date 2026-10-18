package com.msg.vietnamsdelight.registries;

import java.util.Map;

import com.msg.vietnamsdelight.item.VDFoodComponents;
import com.msg.vietnamsdelight.platform.Services;

import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.component.CustomModelData;

public class VDBrewings {

    public static void registerCustomBrewRecipe(){
        Services.CUSTOM_BREWING_RECIPE.registerCustomRecipeWithComponents(
                VDItems.CERAMIC_CUP,
                VDItems.ROAST_COFFEE_BEANS,
                VDItems.COFFEE_CUP,
                null,
                null,
                Services.BUILDERS.dataComponentMapBuilder(Map.of(
                        DataComponents.ITEM_NAME, Component.translatable("item.vietnamsdelight.coffee.black_coffee"),
                        DataComponents.FOOD, VDFoodComponents.BLACK_COFFEE,
                        DataComponents.CUSTOM_MODEL_DATA, new CustomModelData(1)))
        );
    }
}
