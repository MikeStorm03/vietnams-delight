package net.zachsroom.vietnamsdelight;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.fabricmc.api.ModInitializer;
import net.zachsroom.vietnamsdelight.item.ModItemGroups;
import net.zachsroom.vietnamsdelight.item.ModItems;

public class VietnamsDelight implements ModInitializer {

    public static final String MOD_ID = "vietnamsdelight";
   public static final Logger LOGGER = LoggerFactory.getLogger("vietnamsdelight");

    @Override
    public void onInitialize() {
        ModItems.registerItem();
        ModItemGroups.registerItemGroups();
    }
    
}
