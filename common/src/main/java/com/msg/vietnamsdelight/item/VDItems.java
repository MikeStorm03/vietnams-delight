package com.msg.vietnamsdelight.item;

import com.msg.vietnamsdelight.Common;
import com.msg.vietnamsdelight.Constants;
import com.msg.vietnamsdelight.multiloader_compat.fd_classes.FD_Items;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item.Properties;
import net.zachsroom.vietnamsdelight.item.ModFoodComponents;

public class VDItems {

    // Mangosteen Kitten's Items

    // public static final Item TEST = registryItem("test");


    // -----------**§§§**----------- //


    // Zach's room 's items

    // // Flour
    public static final Item RICEFLOUR = basicItem("rice_flour");
    public static final Item CORNSTARCH = basicItem("corn_starch");
    public static final Item RICEMIXEDDOUGH = foodItem("rice_mixed_wheat_dough", ModFoodComponents.RICEMIXEDDOUGH);
    public static final Item RICEBATTER = bowlFoodItem("rice_batter", ModFoodComponents.RICEBATTER);

    // // Banh mi
    public static final Item BANHMI = foodItem("banh_mi", ModFoodComponents.BANHMI); // LATER SHOULD RENAME IT TO SHORT BAGUETTE! I M P O R T A N T !!!

    // // Rice Noodles
    public static final Item RICENOODLESHEET = foodItem("rice_noodle_sheet", ModFoodComponents.RICENOODLESHEET);
    public static final Item FLATRICENOODLE = foodItem("flat_rice_noodle", ModFoodComponents.FLATRICENOODLE);

    // // Pho
    public static final Item PHO = bowlFoodItem("pho", ModFoodComponents.PHO);
    public static final Item BEEFPHO = bowlFoodItem("beef_pho", ModFoodComponents.BEEFPHO);
    public static final Item CHICKENPHO = bowlFoodItem("chicken_pho", ModFoodComponents.CHICKENPHO);

    // // Non la
    public static final Item NONLA = registryItem("non_la", new NonLaItem());


    // -----------**§§§**----------- //


    // // Creative Tab

    public static final CreativeModeTab CREATIVE_TAB = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
                                                                        ResourceLocation.fromNamespaceAndPath(Constants.NAMESPACE, "itemgroup.vd_group"),
                                                                        CreativeModeTab.builder(CreativeModeTab.Row.TOP, 0)
                                                                            .title(Component.translatable("itemgroup.VD_GROUP"))
                                                                            .icon(() -> new ItemStack(VDItems.BANHMI))
                                                                            .displayItems((parameters, output) -> {
                                                                                output.accept(RICEFLOUR);
                                                                                output.accept(CORNSTARCH);
                                                                                output.accept(RICEMIXEDDOUGH);
                                                                                output.accept(RICEBATTER);
                                                                                output.accept(BANHMI);
                                                                                output.accept(RICENOODLESHEET);
                                                                                output.accept(FLATRICENOODLE);
                                                                                output.accept(PHO);
                                                                                output.accept(BEEFPHO);
                                                                                output.accept(CHICKENPHO);
                                                                                output.accept(NONLA);
                                                                            })
                                                                            .build()
                                                                    );

    private static Item basicItem(String name) {
        return registryItem(name, FD_Items.basicItem());
    }

    private static Item foodItem(String name, FoodProperties properties){
        return registryItem(name, (Item) FD_Items.consumableItem.newInstance(FD_Items.foodItem(properties)));
    }

    private static Item bowlFoodItem(String name, FoodProperties properties){
        return registryItem(name, (Item) FD_Items.consumableItem.newInstance(FD_Items.bowlFoodItem(properties)));
    }

    private static Item registryItem(String name, Properties properties) {
        return Registry.register(BuiltInRegistries.ITEM,
                                ResourceLocation.fromNamespaceAndPath(Constants.NAMESPACE, name),
                                new Item(properties));
    }

    private static Item registryItem(String name, Item item) {
        return Registry.register(BuiltInRegistries.ITEM,
                                ResourceLocation.fromNamespaceAndPath(Constants.NAMESPACE, name),
                                item);
    }

    public static void init() {}

}
