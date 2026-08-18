package com.msg.vietnamsdelight.registries;

import com.msg.vietnamsdelight.Constants;
import com.msg.vietnamsdelight.block.Coffee;
import com.msg.vietnamsdelight.block.SimpleHorizontalDirectionalBlock;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

public interface VDBlocks {

    // Blocks
    // static Block TEST = registryBlock("test");

    // // Crops
    // static Block STICKY_RICE = registryBlock("sticky_rice", new)
    static Block COFFEE = registryWithoutBlockItem("coffee",
                            new Coffee(Properties.of().mapColor(MapColor.PLANT).strength(0.2F).noCollission().sound(SoundType.CROP).pushReaction(PushReaction.DESTROY)));

    // // Produce Bags
    static Block COFFEE_BOX  = registryBlock("coffee_box",
                            new SimpleHorizontalDirectionalBlock(Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOL).ignitedByLava()));


    // -----------**§§§**----------- //


    // Registries

    // // Plant Blocks

    // // General Blocks
    private static Block registryBlock(String name){
        return registryBlock(name, new Block(Properties.of()), new Item.Properties());
    }

    private static Block registryBlock(String name, Block block) {
        return registryBlock(name, block, new Item.Properties());
    }

    private static Block registryBlock(String name, Block block, Item.Properties properties) {
        Registry.register(BuiltInRegistries.ITEM,
                        Constants.resourcesLocation(name),
                        new BlockItem(block, properties));
        return registryWithoutBlockItem(name, block);
    }

    private static Block registryWithoutBlockItem(String name, Block block) {
        return Registry.register(BuiltInRegistries.BLOCK,
                                Constants.resourcesLocation(name),
                                block);
    }

}