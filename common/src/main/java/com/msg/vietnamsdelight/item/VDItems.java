package com.msg.vietnamsdelight.item;

import java.util.function.Supplier;

import com.msg.vietnamsdelight.Common;
import com.msg.vietnamsdelight.multiloader_compat.fd_classes.FD_Items;
import com.msg.vietnamsdelight.multiloader_compat.registers.RegistryHelper;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.zachsroom.vietnamsdelight.item.ModFoodComponents;

public class VDItems {
    
    public static final RegistryHelper<Item> ITEMS = Common.registryHelper();

    // Mangosteen Kitten's Items

    // public static final Supplier<Item> TEST = ITEMS.register("test", () -> new Item(FD_Items.basicItem()));


    // Zach's room 's items

    // Flour
    public static final Supplier<Item> RICEFLOUR = ITEMS.register("rice_flour", () -> new Item(FD_Items.basicItem()));
    public static final Supplier<Item> CORNSTARCH = ITEMS.register("corn_starch", () -> new Item(FD_Items.basicItem()));
    public static final Supplier<Item> RICEMIXEDDOUGH = ITEMS.register("rice_mixed_wheat_dough", () -> (Item) FD_Items.consumableItem.newInstance(FD_Items.foodItem(ModFoodComponents.RICEMIXEDDOUGH)));
    public static final Supplier<Item> RICEBATTER = ITEMS.register("rice_batter", () -> (Item) FD_Items.consumableItem.newInstance(FD_Items.bowlFoodItem(ModFoodComponents.RICEBATTER)));

    // Banh mi
    public static final Supplier<Item> BANHMI = ITEMS.register("banh_mi", () -> (Item) FD_Items.consumableItem.newInstance(FD_Items.foodItem(ModFoodComponents.BANHMI)));

    // Rice Noodles
    public static final Supplier<Item> RICENOODLESHEET = ITEMS.register("rice_noodle_sheet", () -> (Item) FD_Items.consumableItem.newInstance(FD_Items.foodItem(ModFoodComponents.RICENOODLESHEET)));
    public static final Supplier<Item> FLATRICENOODLE = ITEMS.register("flat_rice_noodle", () -> (Item) FD_Items.consumableItem.newInstance(FD_Items.foodItem(ModFoodComponents.FLATRICENOODLE)));

    // Pho
    public static final Supplier<Item> PHO = ITEMS.register("pho", () -> (Item) FD_Items.consumableItem.newInstance(FD_Items.bowlFoodItem(ModFoodComponents.PHO)));
    public static final Supplier<Item> BEEFPHO = ITEMS.register("beef_pho", () -> (Item) FD_Items.consumableItem.newInstance(FD_Items.bowlFoodItem(ModFoodComponents.BEEFPHO)));
    public static final Supplier<Item> CHICKENPHO = ITEMS.register("chicken_pho", () -> (Item) FD_Items.consumableItem.newInstance(FD_Items.bowlFoodItem(ModFoodComponents.CHICKENPHO)));

    // Non la
    public static final Supplier<Item> NONLA = ITEMS.register("non_la", () -> new ArmorItem(ModArmorMaterials.NONLA, ArmorItem.Type.HELMET, new Item.Properties()));

}
