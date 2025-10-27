package com.msg.vietnamsdelight;

import com.mojang.blaze3d.vertex.PoseStack;
import com.msg.vietnamsdelight.client.NonLa;
import com.msg.vietnamsdelight.item.NonLaItem;

import net.fabricmc.fabric.api.client.rendering.v1.ArmorRenderer;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

public class NonLaRenderer implements ArmorRenderer{

    private final NonLa model;

    public NonLaRenderer() {
        this.model = new NonLa(NonLa.createBodyLayer().bakeRoot());
    }

    @Override
    public void render(PoseStack matrices, MultiBufferSource vertexConsumers, ItemStack stack, LivingEntity entity, EquipmentSlot slot, int light, HumanoidModel<LivingEntity> contextModel) {

        model.setAllVisible(false);
        if (slot.equals(EquipmentSlot.HEAD)) {

            model.head.visible = true;
            model.head.copyFrom(contextModel.head);

            model.young = contextModel.young;
            model.crouching = contextModel.crouching;
    
            ArmorRenderer.renderPart(matrices, vertexConsumers, light, stack, model, NonLaItem.textureLocation);

        }
    }
}