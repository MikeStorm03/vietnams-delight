package com.msg.registry;

import java.util.function.Supplier;

import com.msg.VietnamsDelightConstants;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredRegister;

public class VietnamsDelightCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, VietnamsDelightConstants.NAMESPACE);

	public static final Supplier<CreativeModeTab> TAB_FARMERS_DELIGHT = CREATIVE_TABS.register(VietnamsDelightConstants.NAMESPACE,
			() -> CreativeModeTab.builder()
					.title(Component.translatable("itemgroup.VD_GROUP"))
					.icon(() -> new ItemStack(VietnamDelightsItems.BANHMI.get()))
					.displayItems((parameters, output) -> VietnamDelightsItems.CREATIVE_TAB_ITEMS.forEach((item) -> output.accept(item.get())))
					.build());
}