package com.msg.vietnamsdelight.item;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import com.msg.vietnamsdelight.Constants;
import com.msg.vietnamsdelight.multiloader_compat.fd_classes.FD_Items;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorItem.Type;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;

public class VDArmorMaterials {
    public static final Holder<ArmorMaterial> NONLA = Registry.registerForHolder(BuiltInRegistries.ARMOR_MATERIAL,
                                                                                ResourceLocation.fromNamespaceAndPath(Constants.NAMESPACE, "non_la"),
                                                                                new ArmorMaterial(new EnumMap<>(Map.of(
                                                                                    // Type.BOOTS, 1,
                                                                                    // Type.LEGGINGS, 2,
                                                                                    // Type.CHESTPLATE, 2,
                                                                                    Type.HELMET, 1,
                                                                                    Type.BODY, 1
                                                                                )),
                                                                                10,
                                                                                SoundEvents.ARMOR_EQUIP_LEATHER,
                                                                                () -> Ingredient.of(new ItemLike[]{(ItemLike) FD_Items.STRAW}),
                                                                                List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(Constants.NAMESPACE, "non_la"))),
                                                                                0,
                                                                                0));
}
