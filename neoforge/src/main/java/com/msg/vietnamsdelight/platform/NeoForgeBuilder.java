package com.msg.vietnamsdelight.platform;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import net.minecraft.core.component.DataComponentMap;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.food.FoodProperties.PossibleEffect;
import net.minecraft.world.item.ItemStack;

import com.msg.vietnamsdelight.Constants;
import com.msg.vietnamsdelight.platform.services.ModBuilders;

public class NeoForgeBuilder implements ModBuilders {

    @Override
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public DataComponentMap dataComponentMapBuilder(Map<DataComponentType<?>, ?> componentMap) {
        DataComponentMap.Builder builder = DataComponentMap.builder();
        for (DataComponentType type : componentMap.keySet()) {
            builder.set(type, componentMap.get(type));
        }
        return builder.build();
    }

    public boolean foodPropertiesMatch(FoodProperties stackProperties, FoodProperties constantProperties){
        if (stackProperties.canAlwaysEat() == constantProperties.canAlwaysEat() &&
            stackProperties.eatSeconds() == constantProperties.eatSeconds() &&
            stackProperties.nutrition() == constantProperties.nutrition() &&
            stackProperties.saturation() == constantProperties.saturation()){

            Optional<ItemStack> stackConvert = stackProperties.usingConvertsTo();
            Optional<ItemStack> constantConvert = constantProperties.usingConvertsTo();
            if (!(stackConvert.isPresent() ^ constantConvert.isPresent())) {

                if (stackConvert.isPresent() && !(stackConvert.get().equals(constantConvert.get()))) return false;

                List<PossibleEffect> stackEffects = new ArrayList<>(stackProperties.effects());
                List<PossibleEffect> constantEffects = constantProperties.effects();
                int effectSize = constantEffects.size();
                if (stackEffects.size() != effectSize) return false;

                for (PossibleEffect possibleEffect : constantEffects)
                    for (int i = 0; i < stackEffects.size(); i++)
                        if (possibleEffect.effect().getEffect().equals(stackEffects.get(i).effect().getEffect()))
                            stackEffects.remove(i);
                if (!stackEffects.isEmpty()) return false;

                return true;
            }
        }
        return false;
    }
}