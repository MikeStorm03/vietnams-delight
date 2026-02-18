package com.msg.vietnamsdelight;

import com.msg.vietnamsdelight.item.VDItems;

import net.fabricmc.api.ModInitializer;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import vectorwing.farmersdelight.common.item.DrinkableItem;
import vectorwing.farmersdelight.common.registry.ModItems;
import vectorwing.farmersdelight.common.registry.ModBlocks;

public class VietnamsDelight implements ModInitializer {
    
    @Override
    public void onInitialize() {
        Common.init();
        VDItems.init();
    }
}