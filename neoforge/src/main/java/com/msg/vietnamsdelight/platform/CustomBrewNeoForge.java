package com.msg.vietnamsdelight.platform;

import org.jetbrains.annotations.Nullable;

import com.msg.vietnamsdelight.platform.services.CustomBrew;

import me.emafire003.dev.custombrewrecipes.CustomBrewRecipeRegister;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.world.item.Item;

public class CustomBrewNeoForge implements CustomBrew {

    @Override
    public void registerCustomRecipe(Item input, Item ingredient, Item output) {
        CustomBrewRecipeRegister.registerCustomRecipe(input, ingredient, output);
    }

    @Override
    public void registerCustomRecipeWithComponents(Item input, Item ingredient, Item output,
            @Nullable DataComponentMap input_components, @Nullable DataComponentMap ingredient_components,
            @Nullable DataComponentMap output_components) {
        CustomBrewRecipeRegister.registerCustomRecipeWithComponents(input, ingredient, output, input_components, ingredient_components, output_components);
    }
    
}
