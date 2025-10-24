package com.msg.vietnamsdelight;

import com.msg.vietnamsdelight.item.CreativeTabs;
import com.msg.vietnamsdelight.item.VDItems;
import com.msg.vietnamsdelight.platform.FoxRegister;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(Constants.ID)
public class VietnamsDelight {

    public VietnamsDelight(IEventBus eventBus) {

        Common.init();

        FoxRegister.registry(eventBus,FoxRegister.ITEMS, VDItems.ITEMS);
        FoxRegister.registry(eventBus, FoxRegister.CREATIVE_TABS, CreativeTabs.CREATIVE_TABS);
    }
}