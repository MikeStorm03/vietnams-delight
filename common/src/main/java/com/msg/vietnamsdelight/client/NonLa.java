package com.msg.vietnamsdelight.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.msg.vietnamsdelight.Constants;

import net.minecraft.client.model.HumanoidArmorModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;

public class NonLa extends HumanoidArmorModel<LivingEntity> {

	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Constants.NAMESPACE, "non_la"), "main");
	public final ModelPart head;

	public NonLa(ModelPart root) {
		super(root);
		this.head = root.getChild("head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshDefinition = HumanoidModel.createMesh(new CubeDeformation(1.0F), 0.0F);
		PartDefinition partDefinition = meshDefinition.getRoot();

		partDefinition.addOrReplaceChild("head", CubeListBuilder.create()
																.texOffs(0, 51).addBox(-1.0F, -14.0F, -1.0F, 2.0F, 1.0F, 2.0F)
																.texOffs(0, 46).addBox(-2.0F, -13.0F, -2.0F, 4.0F, 1.0F, 4.0F)
																.texOffs(0, 0).addBox(-3.0F, -12.0F, -3.0F, 6.0F, 1.0F, 6.0F)
																.texOffs(32, 0).addBox(-4.0F, -11.0F, -4.0F, 8.0F, 1.0F, 8.0F)
																.texOffs(0, 7).addBox(-5.0F, -10.0F, -5.0F, 10.0F, 1.0F, 10.0F)
																.texOffs(0, 18).addBox(-6.0F, -9.0F, -6.0F, 12.0F, 1.0F, 12.0F)
																.texOffs(0, 31).addBox(-7.0F, -8.0F, -7.0F, 14.0F, 1.0F, 14.0F)
																.texOffs(0, 46).addBox(-8.0F, -7.0F, -8.0F, 16.0F, 1.0F, 16.0F),
												PartPose.offset(0.0F, -5.0F, 0.0F));


		return LayerDefinition.create(meshDefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
		poseStack.pushPose();
        if (this.young){
            poseStack.scale(0.75F, 0.75F, 0.75F);
			poseStack.translate(0.0F, 1.0F, 0.0F);
        }
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
		poseStack.popPose();
	}
}