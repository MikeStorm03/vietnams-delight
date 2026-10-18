package com.msg.vietnamsdelight.registries;

import com.msg.vietnamsdelight.crafting_recipe_types.CoffeeDrinkRecipe;

import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SimpleCraftingRecipeSerializer;

public interface VDCraftingRecipeType {
    RecipeSerializer<CoffeeDrinkRecipe> COFFEE_DRINKS_RECIPE = RecipeSerializer.register("crafting_special_coffee_drinks", new SimpleCraftingRecipeSerializer<>(CoffeeDrinkRecipe::new));

    static void init(){};
}
