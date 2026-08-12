package com.msg.vietnamsdelight.crafting_recipe_types;

import com.msg.vietnamsdelight.item.VDFoodComponents;
import com.msg.vietnamsdelight.platform.Services;
import com.msg.vietnamsdelight.registries.VDCraftingRecipeType;
import com.msg.vietnamsdelight.registries.VDItems;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.core.NonNullList;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.CraftingInput;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.Level;

public class CoffeeDrinkRecipe extends CustomRecipe{

    public CoffeeDrinkRecipe(CraftingBookCategory category) {
        super(category);
    }

    @Override
    public ItemStack assemble(CraftingInput input, Provider registries) {
        ItemStack stack = new ItemStack(VDItems.COFFEE_CUP);

        if (input.size() == 2) {
            stack.set(DataComponents.ITEM_NAME, Component.translatable("item.vietnamsdelight.coffee.bac_xiu"));
            stack.set(DataComponents.FOOD, VDFoodComponents.BAC_XIU);
        } else for(int i = 0; i < 3; ++i) {

            ItemStack itemStack = input.getItem(i);
            if (!itemStack.isEmpty()) {
                if (itemStack.is(Items.MILK_BUCKET) ||
                    itemStack.is(Services.FD_ITEMS.getMilkBottleItem())) {
                            stack.set(DataComponents.ITEM_NAME, Component.translatable("item.vietnamsdelight.coffee.milk_coffee"));
                            stack.set(DataComponents.FOOD, VDFoodComponents.MILK_COFFEE);
                            stack.setCount(2);
                        }
                else if (itemStack.is(Items.EGG) ||
                        itemStack.is(Items.HONEY_BOTTLE)){
                    stack.set(DataComponents.ITEM_NAME, Component.translatable("item.vietnamsdelight.coffee.egg_coffee"));
                    stack.set(DataComponents.FOOD, VDFoodComponents.EGG_COFFEE);
                }
            }
        }
        return stack;
    }

    @Override
    public NonNullList<ItemStack> getRemainingItems(CraftingInput input) {
        NonNullList<ItemStack> nonNullList = NonNullList.withSize(input.size(), ItemStack.EMPTY);

        for(int i = 0; i < nonNullList.size(); ++i) {
            Item item = input.getItem(i).getItem();
            if (item.hasCraftingRemainingItem() && item != VDItems.COFFEE_CUP) {
                nonNullList.set(i, new ItemStack(item.getCraftingRemainingItem()));
            }
        }

        return nonNullList;
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return (width >= 1 && height >= 2) || (width >= 2 && height >= 1);
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return VDCraftingRecipeType.COFFEE_DRINKS_RECIPE;
    }

    @Override
    public boolean matches(CraftingInput input, Level level) {

        int size = input.size();
        boolean hasBlackCoffee1 = false;
        boolean hasBlackCoffee2 = false;
        boolean hasMilk = false;
        boolean hasCondensedMilk = false;
        boolean hasEgg = false;
        boolean hasHoney = false;

        for(int i = 0; i < size; ++i) {
            ItemStack itemStack = input.getItem(i);
            if (!itemStack.isEmpty()) {
                if (itemStack.is(VDItems.COFFEE_CUP) &&
                    itemStack.has(DataComponents.FOOD) &&
                    itemStack.get(DataComponents.FOOD).equals(VDFoodComponents.BLACK_COFFEE)){
                        if (hasBlackCoffee1 && hasBlackCoffee2) return false;
                        else if (hasBlackCoffee1) hasBlackCoffee2 = true;
                        else hasBlackCoffee1 = true;}
                else if (itemStack.is(Items.MILK_BUCKET) ||
                        itemStack.is(Services.FD_ITEMS.getMilkBottleItem()))
                            if (hasMilk) return false;
                            else hasMilk = true;
                else if (itemStack.is(VDItems.CONDENSED_MILK))
                        if (hasCondensedMilk) return false;
                        else hasCondensedMilk = true;
                else if (itemStack.is(Items.EGG))
                        if (hasEgg) return false;
                        else hasEgg = true;
                else if (itemStack.is(Items.HONEY_BOTTLE))
                        if (hasHoney) return false;
                        else hasHoney = true;
                else return false;
            }
        }

        return hasBlackCoffee1 &&
                (hasMilk && hasBlackCoffee2 && !hasEgg && !hasHoney) ^
                (hasCondensedMilk && !hasBlackCoffee2 && !hasMilk && !hasEgg && !hasHoney) ^
                (hasEgg && hasHoney && !hasBlackCoffee2 && !hasMilk);
    }
}