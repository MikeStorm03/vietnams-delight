package com.msg.vietnamsdelight.item;

import org.jetbrains.annotations.Nullable;

import com.msg.vietnamsdelight.Constants;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class NonLaItem extends ArmorItem {

    public static final ResourceLocation textureLocation = ResourceLocation.fromNamespaceAndPath(Constants.NAMESPACE, "textures/models/armor/non_la.png");

    public NonLaItem() {
        super(VDArmorMaterials.NONLA, ArmorItem.Type.HELMET, new Item.Properties());
    }

    public @Nullable ResourceLocation getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, ArmorMaterial.Layer layer, boolean inner) {
        return textureLocation;
    }
}
