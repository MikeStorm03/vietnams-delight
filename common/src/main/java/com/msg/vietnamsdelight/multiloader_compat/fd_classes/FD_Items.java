package com.msg.vietnamsdelight.multiloader_compat.fd_classes;

import java.util.function.Supplier;

import com.msg.vietnamsdelight.multiloader_compat.fd_classes.FDClass.FDConstructor;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

@SuppressWarnings("unchecked")
public class FD_Items {

    private static final FDClass classModItems = new FDClass("vectorwing.farmersdelight.common.registry.ModItems");
    private static final FDClass classConsumableItem = new FDClass("vectorwing.farmersdelight.common.item.ConsumableItem");
    public static final FDConstructor consumableItem = classConsumableItem.new FDConstructor(Item.Properties.class);

    public static final Item STRAW = ((Supplier<Item>) classModItems.getField("STRAW")).get();

    public static Item.Properties basicItem(){
        return (Item.Properties) ((classModItems.new FDMethod("basicItem")).get());
    }

    public static Item.Properties foodItem(FoodProperties foodProperties){
        return (Item.Properties) ((classModItems.new FDMethod("foodItem", FoodProperties.class)).get(foodProperties));
    }

    public static Item.Properties bowlFoodItem(FoodProperties foodProperties){
        return (Item.Properties) ((classModItems.new FDMethod("bowlFoodItem", FoodProperties.class)).get(foodProperties));
    }
}