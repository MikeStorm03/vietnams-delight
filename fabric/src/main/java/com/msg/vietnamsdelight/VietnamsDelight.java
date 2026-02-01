package com.msg.vietnamsdelight;

import com.msg.vietnamsdelight.item.VDItems;

import net.fabricmc.api.ModInitializer;

public class VietnamsDelight implements ModInitializer {
    
    @Override
    public void onInitialize() {
        Common.init();
        VDItems.init();
    }
}