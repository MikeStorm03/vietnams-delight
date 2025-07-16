package com.msg;

import com.msg.registry.VietnamDelightsItems;
import com.msg.registry.VietnamsDelightCreativeTabs;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(VietnamsDelightConstants.ID)
public class VietnamsDelight {

    public VietnamsDelight(IEventBus eventBus) {

        VietnamsDelightCommon.init();

        VietnamDelightsItems.ITEMS.register(eventBus);
        VietnamsDelightCreativeTabs.CREATIVE_TABS.register(eventBus);

    }
}