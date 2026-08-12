package com.msg.vietnamsdelight;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.minecraft.resources.ResourceLocation;

public interface Constants {

	String ID = "vietnams_delight_reborn";
	String NAMESPACE = "vietnamsdelight";
	String NAME = "Vietnam's Delight Reborn";
	Logger LOG = LoggerFactory.getLogger(NAME);

    static ResourceLocation resourcesLocation(String path){
        return ResourceLocation.fromNamespaceAndPath(NAMESPACE, path);
    }

}