package com.msg.registry;

import java.util.LinkedHashSet;
import java.util.function.Supplier;

import com.google.common.collect.Sets;
import com.msg.VietnamsDelightConstants;
import com.msg.item.ModArmorMaterials;
import com.msg.item.NeoForgeModFoodComponents;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.zachsroom.vietnamsdelight.item.ModFoodComponents;
import vectorwing.farmersdelight.common.item.ConsumableItem;
import vectorwing.farmersdelight.common.registry.ModItems;

public class VietnamDelightsItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, VietnamsDelightConstants.NAMESPACE);
    
	public static LinkedHashSet<Supplier<Item>> CREATIVE_TAB_ITEMS = Sets.newLinkedHashSet();

	public static Supplier<Item> register(final String name, final Supplier<Item> supplier) {
		Supplier<Item> block = ITEMS.register(name, supplier);
		CREATIVE_TAB_ITEMS.add(block);
		return block;
	}

    public static final Supplier<Item> RICEFLOUR = register("rice_flour", () -> new Item(ModItems.basicItem()));
    public static final Supplier<Item> BANHMI = register("banh_mi", () -> new ConsumableItem(ModItems.foodItem(ModFoodComponents.BANHMI)));
    public static final Supplier<Item> RICEMIXEDDOUGH = register("rice_mixed_wheat_dough", () -> new ConsumableItem(ModItems.foodItem(ModFoodComponents.RICEMIXEDDOUGH)));
    public static final Supplier<Item> RICEBATTER = register("rice_batter", () -> new ConsumableItem(ModItems.bowlFoodItem(ModFoodComponents.RICEBATTER)));
    public static final Supplier<Item> RICENOODLESHEET = register("rice_noodle_sheet", () -> new ConsumableItem(ModItems.foodItem(ModFoodComponents.RICENOODLESHEET)));
    public static final Supplier<Item> FLATRICENOODLE = register("flat_rice_noodle", () -> new ConsumableItem(ModItems.foodItem(ModFoodComponents.FLATRICENOODLE)));
    public static final Supplier<Item> PHO = register("pho", () -> new ConsumableItem(ModItems.bowlFoodItem(NeoForgeModFoodComponents.PHO)));
    public static final Supplier<Item> BEEFPHO = register("beef_pho", () -> new ConsumableItem(ModItems.bowlFoodItem(NeoForgeModFoodComponents.BEEFPHO)));
    public static final Supplier<Item> CORNSTARCH = register("corn_starch", () -> new Item(ModItems.basicItem()));
    public static final Supplier<Item> CHICKENPHO = register("chicken_pho", () -> new ConsumableItem(ModItems.bowlFoodItem(NeoForgeModFoodComponents.CHICKENPHO)));
    public static final Supplier<Item> NONLA = register("non_la", () -> new ArmorItem(ModArmorMaterials.NONLA, ArmorItem.Type.HELMET, new Item.Properties()));

}
