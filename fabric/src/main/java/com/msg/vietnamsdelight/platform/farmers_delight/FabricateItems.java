package com.msg.vietnamsdelight.platform.farmers_delight;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;
import vectorwing.farmersdelight.common.item.ConsumableItem;
import vectorwing.farmersdelight.common.item.DrinkableItem;
import vectorwing.farmersdelight.common.registry.ModItems;

public class FabricateItems implements FD_Items {

    @Override
    public Item getStrawItem() {
        return ModItems.STRAW.get();
    }

    @Override
    public Item getMilkBottleItem() {
        return ModItems.MILK_BOTTLE.get();
    }

    @Override
    public Properties basicItem() {
        return ModItems.basicItem();
    }

    @Override
    public Properties foodItem(FoodProperties foodProperties) {
        return ModItems.foodItem(foodProperties);
    }

    @Override
    public Properties bowlFoodItem(FoodProperties foodProperties) {
        return ModItems.bowlFoodItem(foodProperties);
    }

    @Override
    public Properties drinkItem() {
        return ModItems.drinkItem();
    }

    @Override
    public Item DrinkableItem(Properties properties) {
        return new DrinkableItem(properties);
    }

    @Override
    public Item DrinkableItem(Properties properties, boolean hasFoodEffectTooltip) {
        return new DrinkableItem(properties, hasFoodEffectTooltip);
    }

    @Override
    public Item DrinkableItem(Properties properties, boolean hasFoodEffectTooltip, boolean hasCustomTooltip) {
        return new DrinkableItem(properties, hasFoodEffectTooltip, hasCustomTooltip);
    }

    @Override
    public Item ConsumableItem(Properties properties) {
        return new ConsumableItem(properties);
    }
    
}
