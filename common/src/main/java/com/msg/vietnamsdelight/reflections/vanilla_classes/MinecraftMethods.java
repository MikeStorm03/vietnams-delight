package com.msg.vietnamsdelight.reflections.vanilla_classes;

import com.msg.vietnamsdelight.reflections.ModClass;
import com.msg.vietnamsdelight.reflections.ModClass.ModMethod;
import com.msg.vietnamsdelight.platform.Services;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class MinecraftMethods {
    private static final ModClass cropClass = new ModClass(Services.PLATFORM.isDevelopmentEnvironment() || Services.PLATFORM.getPlatformName() == "NeoForge" ? 
                                                            "net.minecraft.world.level.block.CropBlock" : "net.minecraft.class_2302");
    private static ModMethod getGrowthSpeedMethod(){
        Class<?> firstArg;
        String argClassName = "";
        try {
            switch (Services.PLATFORM.getPlatformName()) {
                case "Fabric":
                    argClassName = Services.PLATFORM.isDevelopmentEnvironment() ? "net.minecraft.world.level.block.Block" : "net.minecraft.class_2248";
                    break;
                case "NeoForge":
                    argClassName = "net.minecraft.world.level.block.state.BlockState";
                    break;
            }
            firstArg = Class.forName(argClassName);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Cannot find " + argClassName + " class", e);
        }
        return cropClass.new ModMethod(Services.PLATFORM.isDevelopmentEnvironment() || Services.PLATFORM.getPlatformName() == "NeoForge" ?
                                        "getGrowthSpeed" : "method_9830",
                                        firstArg, BlockGetter.class, BlockPos.class);
    }
    public static float getGrowthSpeed(Block block, BlockState state, BlockGetter level, BlockPos pos) {
        return (float) getGrowthSpeedMethod().get(Services.PLATFORM.getPlatformName() == "Fabric" ? block : state, level, pos);
    }
}
