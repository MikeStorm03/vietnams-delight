package com.msg.vietnamsdelight;

import com.mojang.blaze3d.vertex.PoseStack;
import com.msg.vietnamsdelight.client.models.NonLa;

import net.fabricmc.fabric.api.client.rendering.v1.ArmorRenderer;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

public class NonLaRenderer implements ArmorRenderer{

    private final NonLa model;

    public NonLaRenderer() {
        this.model = new NonLa(NonLa.createBodyLayer().bakeRoot());
    }

    @Override
    public void render(PoseStack matrices,
                       MultiBufferSource vertexConsumers,
                       ItemStack stack,
                       LivingEntity entity,
                       EquipmentSlot slot,
                       int light,
                       HumanoidModel<LivingEntity> contextModel) {

        model.setAllVisible(false);
        if (slot.equals(EquipmentSlot.HEAD)) {

            model.head.visible = true;
            model.head.copyFrom(contextModel.head);
            matrices.pushPose();

            if (entity.isBaby()){
                matrices.scale(0.85F, 0.85F, 0.85F);
                matrices.translate(0.0F, 0.85F, 0.0F);
            } else {
                matrices.scale(1.2F, 1.2F, 1.2F);
                if (entity.isShiftKeyDown()) matrices.translate(0.0F, -0.05F, 0.0F);
            }
    
            ArmorRenderer.renderPart(matrices, vertexConsumers, light, stack, model, ResourceLocation.fromNamespaceAndPath(Constants.NAMESPACE, "textures/models/armor/non_la.png"));

            matrices.popPose();
        }
    }
}