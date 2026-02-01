package com.msg.vietnamsdelight;

import java.util.function.Supplier;

import com.msg.vietnamsdelight.item.CreativeTabs;
import com.msg.vietnamsdelight.item.VDItems;
import com.msg.vietnamsdelight.multiloader_compat.fd_classes.FD_Items;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.RegisterEvent;

@Mod(Constants.ID)
@EventBusSubscriber(modid = Constants.ID)
public class VietnamsDelight {
    public static Item TEST;

    public VietnamsDelight() {

        Common.init();

    }

    @SubscribeEvent
    static void registerSetup(RegisterEvent event) {
        if (event.getRegistry().equals(BuiltInRegistries.ITEM)) {
            VDItems.init();
        }
    }
}