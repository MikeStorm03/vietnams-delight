package com.msg.vietnamsdelight.platform;

import java.util.Map;

import com.msg.vietnamsdelight.platform.services.ModBuilders;

import net.minecraft.core.component.DataComponentMap;
import net.minecraft.core.component.DataComponentType;

public class FabricBuilder implements ModBuilders{

    @Override
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public DataComponentMap dataComponentMapBuilder(Map<DataComponentType<?>, ?> componentMap) {
        DataComponentMap.Builder builder = DataComponentMap.builder();
        for (DataComponentType type : componentMap.keySet()) {
            builder.set(type, componentMap.get(type));
        }
        return builder.build();
    }
    
}
