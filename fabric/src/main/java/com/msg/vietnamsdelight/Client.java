package com.msg.vietnamsdelight;

import com.msg.vietnamsdelight.item.VDItems;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.ArmorRenderer;

public class Client implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ArmorRenderer.register(new NonLaRenderer(), VDItems.NONLA.get());
    }
}