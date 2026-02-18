package com.msg.vietnamsdelight.multiloader_compat.fd_classes;

import com.msg.vietnamsdelight.multiloader_compat.ModClass;

import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;

@SuppressWarnings("unchecked")
public abstract class FD_Effects {
    private static ModClass clazz = new ModClass("vectorwing.farmersdelight.common.registry.ModEffects");

    public static final Holder<MobEffect> COMFORT = (Holder<MobEffect>) clazz.getField("COMFORT");
    public static final Holder<MobEffect> NOURISHMENT = (Holder<MobEffect>) clazz.getField("NOURISHMENT");
}