package com.msg.vietnamsdelight.platform;

import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;

import com.msg.vietnamsdelight.Constants;
import com.msg.vietnamsdelight.multiloader_compat.registers.RegistryHelper;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class FoxRegister{

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, Constants.NAMESPACE);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Constants.NAMESPACE);

    public static <T> void registry(IEventBus eventBus, DeferredRegister<T> register, RegistryHelper<T> helper){
        Map<String, Supplier<T>> suppilers = helper.getSuppiers();
        Set<String> names = suppilers.keySet();
        for (String name : names) helper.getSuppiers().put(name, register.register(name, suppilers.get(name)));
        register.register(eventBus);
    }
}