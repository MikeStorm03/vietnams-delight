package com.msg.vietnamsdelight;

import com.msg.vietnamsdelight.registries.VDBlocks;
import com.msg.vietnamsdelight.registries.VDItems;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ArmorRenderer;
import net.minecraft.client.renderer.RenderType;

public class Client implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderType.cutout(), VDBlocks.COFFEE);
        ArmorRenderer.register(new NonLaRenderer(), VDItems.NONLA);
    }
}