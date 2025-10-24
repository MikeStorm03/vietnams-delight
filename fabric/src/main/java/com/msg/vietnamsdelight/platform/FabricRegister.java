package com.msg.vietnamsdelight.platform;

import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;

import com.msg.vietnamsdelight.multiloader_compat.registers.RegistryHelper;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;

public class FabricRegister{

    public static <T> void registry(RegistryHelper<T> helper, Registry<T> registry) {
        Map<String, Supplier<T>> suppilers = helper.getSuppiers();
        Set<String> names = suppilers.keySet();
        for (String name : names) {
            T obj = suppilers.get(name).get();
            Registry.register(registry,
                                ResourceLocation.fromNamespaceAndPath(helper.namespace(), name),
                                obj
                            );
            helper.getSuppiers().put(name, () -> obj);
        }
    }
}
