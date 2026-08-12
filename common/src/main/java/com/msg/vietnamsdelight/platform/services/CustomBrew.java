package com.msg.vietnamsdelight.platform.services;

import org.jetbrains.annotations.Nullable;

import net.minecraft.core.component.DataComponentMap;
import net.minecraft.world.item.Item;

public interface CustomBrew {

    void registerCustomRecipe(Item input, Item ingredient, Item output);

    void registerCustomRecipeWithComponents(Item input, Item ingredient, Item output, @Nullable DataComponentMap input_components, @Nullable DataComponentMap ingredient_components, @Nullable DataComponentMap output_components);
}
