package net.zachsroom.vietnamsdelight.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;
import vectorwing.farmersdelight.common.registry.ModEffects;

public class FabricModFoodComponents {
   public static final FoodProperties PHO = (new FoodProperties.Builder())
                                                                        .nutrition(10)
                                                                        .saturationModifier(0.75F)
                                                                        .effect(new MobEffectInstance(ModEffects.COMFORT, 3600, 0), 1.0F)
                                                                        .build();
   public static final FoodProperties BEEFPHO = (new FoodProperties.Builder())
                                                                        .nutrition(15)
                                                                        .saturationModifier(0.75F)
                                                                        .effect(new MobEffectInstance(ModEffects.NOURISHMENT, 6000, 0), 1.0F)
                                                                        .build();
   public static final FoodProperties CHICKENPHO = (new FoodProperties.Builder())
                                                                        .nutrition(12)
                                                                        .saturationModifier(0.75F)
                                                                        .effect(new MobEffectInstance(ModEffects.COMFORT, 6000, 0), 1.0F)
                                                                        .build();
}