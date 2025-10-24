package com.msg.vietnamsdelight.item;

import java.util.function.Supplier;

import com.msg.vietnamsdelight.Common;
import com.msg.vietnamsdelight.multiloader_compat.registers.RegistryHelper;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class CreativeTabs {

    public static final RegistryHelper<CreativeModeTab> CREATIVE_TABS = Common.registryHelper();

    public static final Supplier<CreativeModeTab> CREATIVE_TAB = CREATIVE_TABS.register("itemgroup.vd_group", () ->
                    CreativeModeTab.builder(CreativeModeTab.Row.TOP, 0)
                        .title(Component.translatable("itemgroup.VD_GROUP"))
                        .icon(() -> new ItemStack(VDItems.BANHMI.get()))
                        .displayItems((parameters, output) -> {
                            for (Supplier<Item> entry : VDItems.ITEMS.getSuppiers().values()) {
                                output.accept(entry.get());
                            }
                        })
                        .build()
                );


}
