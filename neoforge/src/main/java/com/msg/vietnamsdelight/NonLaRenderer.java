package com.msg.vietnamsdelight;

import org.jetbrains.annotations.NotNull;

import com.msg.vietnamsdelight.client.NonLa;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;

public class NonLaRenderer implements IClientItemExtensions {

    private final NonLa model = new NonLa(NonLa.createBodyLayer().bakeRoot());

    public NonLaRenderer() {}

    @Override
    public @NotNull NonLa getHumanoidArmorModel(LivingEntity living, ItemStack stack, EquipmentSlot slot, HumanoidModel<?> original) {
        model.crouching = original.crouching;
        model.young = original.young;
        return model;
    }
}