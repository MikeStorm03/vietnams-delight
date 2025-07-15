package net.zachsroom.vietnamsdelight.item;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.zachsroom.vietnamsdelight.VietnamsDelight;
import vectorwing.farmersdelight.common.item.DrinkableItem;

public class ModItems {
    public static final Item RICEFLOUR = registerItem("rice_flour", new Item(new Item.Properties()));
    public static final Item BANHMI =  registerItem("banh_mi", new Item(new Item.Properties().food(ModFoodComponents.BANHMI)));
    public static final Item RICEMIXEDDOUGH = registerItem("rice_mixed_wheat_dough", new Item(new Item.Properties().food(ModFoodComponents.RICEMIXEDDOUGH)));
    public static final Item RICEBATTER = registerItem("rice_batter", new DrinkableItem(new Item.Properties().food(ModFoodComponents.RICEBATTER).craftRemainder(Items.BOWL).stacksTo(16), false, false));
    public static final Item RICENOODLESHEET = registerItem("rice_noodle_sheet", new Item(new Item.Properties().food(ModFoodComponents.RICENOODLESHEET)));
    public static final Item FLATRICENOODLE = registerItem("flat_rice_noodle", new Item(new Item.Properties().food(ModFoodComponents.FLATRICENOODLE)));
    public static final Item PHO = registerItem("pho", new DrinkableItem(new Item.Properties().food(FabricModFoodComponents.PHO).craftRemainder(Items.BOWL).stacksTo(16), true, false));
    public static final Item BEEFPHO =  registerItem("beef_pho", new DrinkableItem(new Item.Properties().food(FabricModFoodComponents.BEEFPHO).craftRemainder(Items.BOWL).stacksTo(16), true, false));
    public static final Item CORNSTARCH = registerItem("corn_starch", new DrinkableItem(new Item.Properties()));
    public static final Item CHICKENPHO = registerItem("chicken_pho", new DrinkableItem(new Item.Properties().food(FabricModFoodComponents.CHICKENPHO).stacksTo(16), true, false));
    public static final Item NONLA = registerItem("non_la", new ArmorItem(ModArmorMaterials.NONLA, ArmorItem.Type.HELMET, new Item.Properties()));

    private static Item registerItem(String name, Item item){
        return Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(VietnamsDelight.MOD_ID, name), item);
    }

    public static void registerItem(){}
}