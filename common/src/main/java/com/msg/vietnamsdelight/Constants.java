package com.msg.vietnamsdelight;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public interface Constants {

	String ID = "vietnams_delight_reborn";
	String NAMESPACE = "vietnamsdelight";
	String NAME = "Vietnam's Delight Reborn";
	Logger LOG = LoggerFactory.getLogger(NAME);

	TagKey<Block> SHEARS = TagKey.create(Registries.BLOCK, ResourceLocation.withDefaultNamespace("mineable/shears"));

    static ResourceLocation resourcesLocation(String path){
        return ResourceLocation.fromNamespaceAndPath(NAMESPACE, path);
    }

}