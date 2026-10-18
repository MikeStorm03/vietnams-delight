package net.zachsroom.vietnamsdelight.item;

import com.msg.vietnamsdelight.platform.Services;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public interface ModFoodComponents {
    FoodProperties RICEMIXEDDOUGH = (new FoodProperties.Builder())
                                                            .nutrition(1)
                                                            .saturationModifier(1)
                                                            .effect(new MobEffectInstance(MobEffects.HUNGER, 600), 0.3F)
                                                            .build();
    FoodProperties BANHMI =  (new FoodProperties.Builder())
                                                            .nutrition(3)
                                                            .saturationModifier(1.3333334F)
                                                            .build();
    FoodProperties RICEBATTER = (new FoodProperties.Builder())
                                                            .nutrition(2)
                                                            .saturationModifier(0.8F)
                                                            .saturationModifier(1)
                                                            .effect(new MobEffectInstance(MobEffects.HUNGER, 600), 0.3F)
                                                            .build();
    FoodProperties RICENOODLESHEET = (new FoodProperties.Builder())
                                                            .nutrition(4)
                                                            .saturationModifier(0.25F)
                                                            .build();
    FoodProperties FLATRICENOODLE = (new FoodProperties.Builder())
                                                            .nutrition(3)
                                                            .saturationModifier(0.3333334F)
                                                            .fast()
                                                            .build();
    FoodProperties PHO = (new FoodProperties.Builder())
                                                            .nutrition(10)
                                                            .saturationModifier(0.75F)
                                                            .effect(new MobEffectInstance(Services.FD_EFFECTS.getComfortEffect(), 3600, 0), 1.0F)
                                                            .build();
    FoodProperties BEEFPHO = (new FoodProperties.Builder())
                                                            .nutrition(15)
                                                            .saturationModifier(0.75F)
                                                            .effect(new MobEffectInstance(Services.FD_EFFECTS.getNourishmentEffect(), 6000, 0), 1.0F)
                                                            .build();
    FoodProperties CHICKENPHO = (new FoodProperties.Builder())
                                                            .nutrition(12)
                                                            .saturationModifier(0.75F)
                                                            .effect(new MobEffectInstance(Services.FD_EFFECTS.getComfortEffect(), 6000, 0), 1.0F)
                                                            .build();
}
