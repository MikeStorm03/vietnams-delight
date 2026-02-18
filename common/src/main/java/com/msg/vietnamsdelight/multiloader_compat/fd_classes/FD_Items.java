package com.msg.vietnamsdelight.multiloader_compat.fd_classes;

import java.util.function.Supplier;

import com.msg.vietnamsdelight.multiloader_compat.ModClass;
import com.msg.vietnamsdelight.multiloader_compat.ModClass.ModConstructor;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class FD_Items {

    private static final ModClass classModItems = new ModClass("vectorwing.farmersdelight.common.registry.ModItems");
    private static final ModClass classConsumableItem = new ModClass("vectorwing.farmersdelight.common.item.ConsumableItem");
    private static final ModClass classDrinkableItem = new ModClass("vectorwing.farmersdelight.common.item.DrinkableItem");
    public static final ModConstructor drinkableItem1 = classDrinkableItem.new ModConstructor(Item.Properties.class);
    public static final ModConstructor drinkableItem2 = classDrinkableItem.new ModConstructor(Item.Properties.class, boolean.class);
    public static final ModConstructor drinkableItem3 = classDrinkableItem.new ModConstructor(Item.Properties.class, boolean.class, boolean.class);
    public static final ModConstructor consumableItem = classConsumableItem.new ModConstructor(Item.Properties.class);

    @SuppressWarnings("unchecked")
    public static final Item STRAW = ((Supplier<Item>) classModItems.getField("STRAW")).get();

    public static Item.Properties basicItem(){
        return (Item.Properties) ((classModItems.new ModMethod("basicItem")).get());
    }

    public static Item.Properties foodItem(FoodProperties foodProperties){
        return (Item.Properties) ((classModItems.new ModMethod("foodItem", FoodProperties.class)).get(foodProperties));
    }

    public static Item.Properties bowlFoodItem(FoodProperties foodProperties){
        return (Item.Properties) ((classModItems.new ModMethod("bowlFoodItem", FoodProperties.class)).get(foodProperties));
    }

    public static Item.Properties drinkItem(){
        return (Item.Properties) ((classModItems.new ModMethod("drinkItem")).get());
    }
}