package com.msg.vietnamsdelight.registries;

import java.util.Map;

import com.msg.vietnamsdelight.Constants;
import com.msg.vietnamsdelight.item.VDFoodComponents;
import com.msg.vietnamsdelight.platform.Services;
import com.msg.vietnamsdelight.item.NonLaItem;
import com.msg.vietnamsdelight.item.SeedItem;

import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BottleItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.block.Block;
import net.zachsroom.vietnamsdelight.item.ModFoodComponents;

public interface VDItems {

    // Mangosteen Kitten's items

    // Item TEST = registryItem("test");

    // // Cup
    Item CLAY_CUP = basicItem("clay_cup");
    Item CERAMIC_CUP = registryItem("ceramic_cup", new BottleItem(new Item.Properties()));

    // // Banh mi
    // Item YEAST = basicItem("yeast");

    // // Coffee
    Item COFFEE_BEANS = seedItem("coffee_beans", VDBlocks.COFFEE);
    Item COFFEE_PACK = basicItem("coffee_pack");
    Item ROAST_COFFEE_BEANS = foodItem("roasted_coffee_beans", VDFoodComponents.ROAST_COFFEE_BEANS);
    Item COFFEE_CUP = drinkItem("coffee_cup", new Properties().craftRemainder(CERAMIC_CUP).stacksTo(16).food(VDFoodComponents.DRINKS));

    // // Condensed Milk
    Item CONDENSED_MILK = drinkItem("condensed_milk", new Properties().craftRemainder(Items.GLASS_BOTTLE).stacksTo(16).food(VDFoodComponents.CONDENSED_MILK));


    // -----------**§§§**----------- //


    // Zach's room 's items

    // // Flour
    Item RICEFLOUR = basicItem("rice_flour");
    Item CORNSTARCH = basicItem("corn_starch");
    Item RICEMIXEDDOUGH = foodItem("rice_mixed_wheat_dough", ModFoodComponents.RICEMIXEDDOUGH);
    Item RICEBATTER = bowlFoodItem("rice_batter", ModFoodComponents.RICEBATTER);

    // // Banh mi
    Item BANHMI = foodItem("banh_mi", ModFoodComponents.BANHMI); // LATER SHOULD RENAME IT TO SHORT BAGUETTE! I M P O R T A N T !!!

    // // Rice Noodles
    Item RICENOODLESHEET = foodItem("rice_noodle_sheet", ModFoodComponents.RICENOODLESHEET);
    Item FLATRICENOODLE = foodItem("flat_rice_noodle", ModFoodComponents.FLATRICENOODLE);

    // // Pho
    Item PHO = bowlFoodItem("pho", ModFoodComponents.PHO);
    Item BEEFPHO = bowlFoodItem("beef_pho", ModFoodComponents.BEEFPHO);
    Item CHICKENPHO = bowlFoodItem("chicken_pho", ModFoodComponents.CHICKENPHO);

    // // Non la
    Item NONLA = registryItem("non_la", new NonLaItem());


    // -----------**§§§**----------- //


    // // Creative Tab

    CreativeModeTab CREATIVE_TAB = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
                                                                        Constants.resourcesLocation("itemgroup.vd_group"),
                                                                        CreativeModeTab.builder(CreativeModeTab.Row.TOP, 0)
                                                                            .title(Component.translatable("itemgroup.vietnamsdelight"))
                                                                            .icon(() -> new ItemStack(VDItems.BANHMI))
                                                                            .displayItems((parameters, output) -> {
                                                                                // Seeds
                                                                                output.accept(COFFEE_BEANS);

                                                                                // Produce Bags
                                                                                output.accept(COFFEE_PACK);
                                                                                output.accept(VDBlocks.COFFEE_BOX );

                                                                                // Ingredients
                                                                                output.accept(RICEFLOUR);
                                                                                output.accept(CORNSTARCH);
                                                                                output.accept(RICEMIXEDDOUGH);
                                                                                output.accept(RICEBATTER);
                                                                                // output.accept(YEAST);
                                                                                output.accept(ROAST_COFFEE_BEANS);

                                                                                // Food
                                                                                output.accept(BANHMI);
                                                                                output.accept(CONDENSED_MILK);
                                                                                output.accept(RICENOODLESHEET);
                                                                                output.accept(FLATRICENOODLE);
                                                                                output.accept(PHO);
                                                                                output.accept(BEEFPHO);
                                                                                output.accept(CHICKENPHO);

                                                                                output.accept(createItemStack(COFFEE_CUP, Services.BUILDERS.dataComponentMapBuilder(Map.of(
                                                                                                DataComponents.ITEM_NAME, Component.translatable("item.vietnamsdelight.coffee.black_coffee"),
                                                                                                DataComponents.FOOD, VDFoodComponents.BLACK_COFFEE
                                                                                ))));
                                                                                output.accept(createItemStack(COFFEE_CUP, Services.BUILDERS.dataComponentMapBuilder(Map.of(
                                                                                                DataComponents.ITEM_NAME, Component.translatable("item.vietnamsdelight.coffee.milk_coffee"),
                                                                                                DataComponents.FOOD, VDFoodComponents.MILK_COFFEE
                                                                                ))));
                                                                                output.accept(createItemStack(COFFEE_CUP, Services.BUILDERS.dataComponentMapBuilder(Map.of(
                                                                                                DataComponents.ITEM_NAME, Component.translatable("item.vietnamsdelight.coffee.bac_xiu"),
                                                                                                DataComponents.FOOD, VDFoodComponents.BAC_XIU
                                                                                ))));
                                                                                output.accept(createItemStack(COFFEE_CUP, Services.BUILDERS.dataComponentMapBuilder(Map.of(
                                                                                                DataComponents.ITEM_NAME, Component.translatable("item.vietnamsdelight.coffee.egg_coffee"),
                                                                                                DataComponents.FOOD, VDFoodComponents.EGG_COFFEE
                                                                                ))));

                                                                                // Container
                                                                                output.accept(CLAY_CUP);
                                                                                output.accept(CERAMIC_CUP);

                                                                                // Non la
                                                                                output.accept(NONLA);
                                                                            })
                                                                            .build()
                                                                        );

    // Creative Tabs Item Stack
    private static <T> ItemStack createItemStack(Item item, DataComponentMap dataComponentMap) {
        ItemStack stack = new ItemStack(item);
        stack.applyComponents(dataComponentMap);
        return stack;
    }

    // -----------**§§§**----------- //


    // Registry functions

    private static Item basicItem(String name) {
        return registryItem(name, Services.FD_ITEMS.basicItem());
    }

    private static Item foodItem(String name, FoodProperties properties){
        return registryItem(name, Services.FD_ITEMS.ConsumableItem(Services.FD_ITEMS.foodItem(properties)));
    }

    private static Item bowlFoodItem(String name, FoodProperties properties){
        return registryItem(name, Services.FD_ITEMS.ConsumableItem(Services.FD_ITEMS.bowlFoodItem(properties)));
    }

    private static Item drinkItem(String name){
        return drinkItem(name, Services.FD_ITEMS.drinkItem());
    }

    private static Item drinkItem(String name, Properties properties){
        return registryItem(name, Services.FD_ITEMS.DrinkableItem(properties, false, true));
    }

    private static Item seedItem(String name, Block block_crop) {
        return registryItem(name, new SeedItem(block_crop, new Properties()));
    }

    private static Item registryItem(String name, Properties properties) {
        return registryItem(name, new Item(properties));
    }

    private static Item registryItem(String name, Item item) {
        return Registry.register(BuiltInRegistries.ITEM,
                                Constants.resourcesLocation(name),
                                item);
    }

}