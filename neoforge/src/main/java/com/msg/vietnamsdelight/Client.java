package com.msg.vietnamsdelight;

import com.msg.vietnamsdelight.item.VDItems;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;

@Mod(value = Constants.ID, dist = Dist.CLIENT)
@EventBusSubscriber(modid = Constants.ID, value = Dist.CLIENT)
public class Client {

    @SubscribeEvent
    public static void onRegisterClientExtensions(RegisterClientExtensionsEvent event) {
        event.registerItem(new NonLaRenderer(), VDItems.NONLA);
    }
}
