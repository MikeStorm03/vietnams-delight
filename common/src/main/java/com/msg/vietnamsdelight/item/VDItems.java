package com.msg.vietnamsdelight.item;

import com.msg.vietnamsdelight.Constants;
import com.msg.vietnamsdelight.block.VDBlocks;
import com.msg.vietnamsdelight.multiloader_compat.fd_classes.FD_Items;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.block.Block;
import net.zachsroom.vietnamsdelight.item.ModFoodComponents;

public class VDItems {

    // Mangosteen Kitten's items

    // public static final Item TEST = registryItem("test");

    // // Banh mi
    public static final Item YEAST = basicItem("yeast");

    // // Coffee
    public static final Item ROBUSTA_COFFEE_BEANS = seedItem("robusta_coffee_beans", VDBlocks.ROBUSTA_COFFEE);
    public static final Item ARABICA_COFFEE_BEANS = seedItem("arabica_coffee_beans", VDBlocks.ARABICA_COFFEE);
    public static final Item ROBUSTA_COFFEE_POUCH = basicItem("robusta_coffee_pouch");
    public static final Item ARABICA_COFFEE_POUCH = basicItem("arabica_coffee_pouch");
    public static final Item ROAST_ROBUSTA_COFFEE_BEANS = foodItem("roast_robusta_coffee_beans", FoodComponents.ROAST_COFFEE_BEANS);
    public static final Item ROAST_ARABICA_COFFEE_BEANS = foodItem("roast_arabica_coffee_beans", FoodComponents.ROAST_COFFEE_BEANS);

    // // Condensed Milk
    public static final Item CONDENSED_MILK = drinkItem("condensed_milk", new Item.Properties().stacksTo(16).food(FoodComponents.CONDENSED_MILK));
    public static final Item SWEET_MILK = drinkItem("sweet_milk");


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
                                                                                // Seeds
                                                                                output.accept(ROBUSTA_COFFEE_BEANS);
                                                                                output.accept(ARABICA_COFFEE_BEANS);

                                                                                // Produce Bags
                                                                                output.accept(ROBUSTA_COFFEE_POUCH);
                                                                                output.accept(ARABICA_COFFEE_POUCH);
                                                                                output.accept(VDBlocks.ROBUSTA_BAG);
                                                                                output.accept(VDBlocks.ARABICA_BAG);

                                                                                // Ingredients
                                                                                output.accept(RICEFLOUR);
                                                                                output.accept(CORNSTARCH);
                                                                                output.accept(RICEMIXEDDOUGH);
                                                                                output.accept(RICEBATTER);
                                                                                output.accept(YEAST);
                                                                                // Food
                                                                                output.accept(BANHMI);
                                                                                output.accept(CONDENSED_MILK);
                                                                                output.accept(SWEET_MILK);
                                                                                output.accept(RICENOODLESHEET);
                                                                                output.accept(FLATRICENOODLE);
                                                                                output.accept(PHO);
                                                                                output.accept(BEEFPHO);
                                                                                output.accept(CHICKENPHO);
                                                                                // Non la
                                                                                output.accept(NONLA);
                                                                            })
                                                                            .build()
                                                                        );


    // -----------**§§§**----------- //


    // Registry functions

    private static Item basicItem(String name) {
        return registryItem(name, FD_Items.basicItem());
    }

    private static Item foodItem(String name, FoodProperties properties){
        return registryItem(name, (Item) FD_Items.consumableItem.newInstance(FD_Items.foodItem(properties)));
    }

    private static Item bowlFoodItem(String name, FoodProperties properties){
        return registryItem(name, (Item) FD_Items.consumableItem.newInstance(FD_Items.bowlFoodItem(properties)));
    }

    private static Item drinkItem(String name){
        return Registry.register(BuiltInRegistries.ITEM,
                                ResourceLocation.fromNamespaceAndPath(Constants.NAMESPACE, name),
                                (Item) FD_Items.drinkableItem3.newInstance(FD_Items.drinkItem(), false, true));
    }

    private static Item drinkItem(String name, Properties properties){
        return Registry.register(BuiltInRegistries.ITEM,
                                ResourceLocation.fromNamespaceAndPath(Constants.NAMESPACE, name),
                                (Item) FD_Items.drinkableItem3.newInstance(properties, false, true));
    }

    private static Item seedItem(String name, Block block_crop) {
        return Registry.register(BuiltInRegistries.ITEM,
                                ResourceLocation.fromNamespaceAndPath(Constants.NAMESPACE, name),
                                new ItemNameBlockItem(block_crop, new Properties()));
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