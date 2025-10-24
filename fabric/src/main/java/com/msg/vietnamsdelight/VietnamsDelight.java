package com.msg.vietnamsdelight;

import com.msg.vietnamsdelight.item.CreativeTabs;
import com.msg.vietnamsdelight.item.VDItems;
import com.msg.vietnamsdelight.platform.FabricRegister;

import net.fabricmc.api.ModInitializer;
import net.minecraft.core.registries.BuiltInRegistries;

public class VietnamsDelight implements ModInitializer {
    
    @Override
    public void onInitialize() {
        Common.init();
        FabricRegister.registry(VDItems.ITEMS, BuiltInRegistries.ITEM);
        FabricRegister.registry(CreativeTabs.CREATIVE_TABS, BuiltInRegistries.CREATIVE_MODE_TAB);
    }
}