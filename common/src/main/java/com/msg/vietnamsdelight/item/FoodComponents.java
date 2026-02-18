package com.msg.vietnamsdelight.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class FoodComponents {
    public static final FoodProperties CONDENSED_MILK = (new FoodProperties.Builder())
                                                                        .nutrition(1)
                                                                        .saturationModifier(10)
                                                                        .build();
    public static final FoodProperties ROAST_COFFEE_BEANS = (new FoodProperties.Builder())
                                                                        .nutrition(1)
                                                                        .saturationModifier(1)
                                                                        .effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 2), 1.0F)
                                                                        .build();
}
