package com.msg.vietnamsdelight.registries.loot_table;

import java.util.Set;

import com.google.common.collect.ImmutableSet;
import com.mojang.serialization.MapCodec;
import com.msg.vietnamsdelight.Constants;

import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParam;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemConditionType;

public class GetExplodedCondition implements LootItemCondition {

    private static final GetExplodedCondition INSTANCE = new GetExplodedCondition();
    public static final MapCodec<GetExplodedCondition> CODEC = MapCodec.unit(INSTANCE);

    private GetExplodedCondition() {
    }

    @Override
    public LootItemConditionType getType() {
        return VDLootItemConditions.GET_EXPLODED;
    }

    public Set<LootContextParam<?>> getReferencedContextParams() {
        return ImmutableSet.of(LootContextParams.EXPLOSION_RADIUS);
    }

    @Override
    public boolean test(LootContext context) {
        Float exlosionRadius = context.getParamOrNull(LootContextParams.EXPLOSION_RADIUS);
        // Constants.LOG.info("testing for exlosion. Explosion radius is {}", exlosionRadius);
        return exlosionRadius != null;
    }

    public static LootItemCondition.Builder getExploded() {
        return () -> INSTANCE;
    }
}
