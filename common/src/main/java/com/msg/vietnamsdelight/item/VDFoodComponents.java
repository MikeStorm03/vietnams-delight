package com.msg.vietnamsdelight.item;

import com.msg.vietnamsdelight.platform.Services;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public interface VDFoodComponents {
    FoodProperties CONDENSED_MILK =     (new FoodProperties.Builder())
                                                            .nutrition(2)
                                                            .saturationModifier(10)
                                                            .build();
    FoodProperties ROAST_COFFEE_BEANS = (new FoodProperties.Builder())
                                                            .nutrition(1)
                                                            .saturationModifier(1)
                                                            .fast()
                                                            .effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 20), 0.01F)
                                                            .build();
    FoodProperties BLACK_COFFEE =       (new FoodProperties.Builder())
                                                            .effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 1), 1.0F)
                                                            .effect(new MobEffectInstance(MobEffects.HUNGER, 400), 0.8F)
                                                            .build();
    FoodProperties MILK_COFFEE =        (new FoodProperties.Builder())
                                                            .effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200), 1.0F)
                                                            .build();
    FoodProperties BAC_XIU =            (new FoodProperties.Builder())
                                                            .saturationModifier(2)
                                                            .effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200), 1.0F)
                                                            .effect(new MobEffectInstance(Services.FD_EFFECTS.getNourishmentEffect(), 120), 1.F)
                                                            .build();
    FoodProperties EGG_COFFEE =         (new FoodProperties.Builder())
                                                            .nutrition(1)
                                                            .effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 300), 1.0F)
                                                            .build();
}
