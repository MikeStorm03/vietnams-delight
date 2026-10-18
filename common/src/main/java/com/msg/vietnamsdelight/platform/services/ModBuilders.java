package com.msg.vietnamsdelight.platform.services;

import java.util.Map;

import net.minecraft.core.component.DataComponentMap;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.world.food.FoodProperties;

public interface ModBuilders {
    DataComponentMap dataComponentMapBuilder(Map<DataComponentType<?>, ?> componentMap);
    boolean foodPropertiesMatch(FoodProperties stackProperties, FoodProperties constantProperties);
}
