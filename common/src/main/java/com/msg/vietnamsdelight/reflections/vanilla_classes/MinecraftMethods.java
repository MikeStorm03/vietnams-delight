package com.msg.vietnamsdelight.reflections.vanilla_classes;

import com.msg.vietnamsdelight.reflections.ModClass;
import com.msg.vietnamsdelight.reflections.ModClass.ModMethod;
import com.msg.vietnamsdelight.platform.Services;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class MinecraftMethods {
    private static final ModClass cropClass = new ModClass("net.minecraft.world.level.block.CropBlock");
    private static ModMethod getGrowthSpeedMethod(){
        Class<?> firstArg;
        String argClassName = "";
        try {
            switch (Services.PLATFORM.getPlatformName()) {
                case "Fabric":
                    argClassName = "net.minecraft.world.level.block.Block";
                    break;
                case "NeoForge":
                    argClassName = "net.minecraft.world.level.block.state.BlockState";
                    break;
            }
            firstArg = Class.forName(argClassName);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Cannot find " + argClassName + " class", e);
        }
        return cropClass.new ModMethod("getGrowthSpeed", firstArg, BlockGetter.class, BlockPos.class);
    }
    public static float getGrowthSpeed(Block block, BlockState state, BlockGetter level, BlockPos pos) {
        return (float) getGrowthSpeedMethod().get(Services.PLATFORM.getPlatformName() == "Fabric" ? block : state, level, pos);
    }
}
