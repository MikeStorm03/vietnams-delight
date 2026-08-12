package com.msg.vietnamsdelight.platform.farmers_delight;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;

public interface FD_Items {

    // Items
    Item getStrawItem();
    Item getMilkBottleItem();

    // Functions
    Properties basicItem();

    Properties foodItem(FoodProperties foodProperties);
    Properties bowlFoodItem(FoodProperties foodProperties);

    Properties drinkItem();

    // Contructors
    Item DrinkableItem(Properties properties);
    Item DrinkableItem(Properties properties, boolean hasFoodEffectTooltip);
    Item DrinkableItem(Properties properties, boolean hasFoodEffectTooltip, boolean hasCustomTooltip);

    Item ConsumableItem(Properties properties);

}
