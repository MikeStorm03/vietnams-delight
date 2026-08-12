package com.msg.vietnamsdelight.platform.farmers_delight;

import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;

public class FoxEffects implements FD_Effects {

    @Override
    public Holder<MobEffect> getComfortEffect() {
        return vectorwing.farmersdelight.common.registry.ModEffects.COMFORT;
    }

    @Override
    public Holder<MobEffect> getNourishmentEffect() {
        return vectorwing.farmersdelight.common.registry.ModEffects.NOURISHMENT;
    }
}
