package com.msg.item;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import com.msg.VietnamsDelightConstants;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorItem.Type;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;

import vectorwing.farmersdelight.common.registry.ModItems;

public class ModArmorMaterials {
    public static final Holder<ArmorMaterial> NONLA = Registry.registerForHolder(BuiltInRegistries.ARMOR_MATERIAL,
                                                                                ResourceLocation.fromNamespaceAndPath(VietnamsDelightConstants.NAMESPACE, "non_la"),
                                                                                new ArmorMaterial(new EnumMap<>(Map.of(
                                                                                    Type.BOOTS, 1,
                                                                                    Type.LEGGINGS, 2,
                                                                                    Type.CHESTPLATE, 2,
                                                                                    Type.HELMET, 1,
                                                                                    Type.BODY, 2
                                                                                )),
                                                                                10,
                                                                                SoundEvents.ARMOR_EQUIP_LEATHER,
                                                                                () -> Ingredient.of(new ItemLike[]{(ItemLike) ModItems.STRAW}),
                                                                                List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(VietnamsDelightConstants.NAMESPACE, "non_la"))),
                                                                                0,
                                                                                0));
}
