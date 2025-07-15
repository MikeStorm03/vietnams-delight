package net.zachsroom.vietnamsdelight.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodComponents {
    public static final FoodProperties RICEMIXEDDOUGH = (new FoodProperties.Builder())
                                                                        .nutrition(1)
                                                                        .saturationModifier(1)
                                                                        .effect(new MobEffectInstance(MobEffects.HUNGER, 600), 0.3F)
                                                                        .build();
   public static final FoodProperties BANHMI =  (new FoodProperties.Builder())
                                                                        .nutrition(3)
                                                                        .saturationModifier(1.3333334F)
                                                                        .build();
   public static final FoodProperties RICEBATTER = (new FoodProperties.Builder())
                                                                        .nutrition(2)
                                                                        .saturationModifier(0.8F)
                                                                        .saturationModifier(1)
                                                                        .effect(new MobEffectInstance(MobEffects.HUNGER, 600), 0.3F)
                                                                        .build();
   public static final FoodProperties RICENOODLESHEET = (new FoodProperties.Builder())
                                                                        .nutrition(4)
                                                                        .saturationModifier(0.25F)
                                                                        .build();
   public static final FoodProperties FLATRICENOODLE = (new FoodProperties.Builder())
                                                                        .nutrition(3)
                                                                        .saturationModifier(0.3333334F)
                                                                        .fast()
                                                                        .build();
}
