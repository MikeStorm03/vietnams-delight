package com.msg.vietnamsdelight.block;

import java.util.function.Supplier;

import com.msg.vietnamsdelight.Constants;
import com.msg.vietnamsdelight.block.crops.Coffee;
import com.msg.vietnamsdelight.item.VDItems;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

public class VDBlocks {

    // Blocks
    // public static final Block TEST = registryBlock("test");

    // // Crops
    // public static final Block STICKY_RICE = registryBlock("sticky_rice", new)
    public static final Block ROBUSTA_COFFEE = coffeePlantBlock("robusta_coffee", () -> VDItems.ROBUSTA_COFFEE_BEANS);
    public static final Block ARABICA_COFFEE = coffeePlantBlock("arabica_coffee", () -> VDItems.ARABICA_COFFEE_BEANS);

    // // Produce Bags
    public static final Block ROBUSTA_BAG = registryBlock("robusta_coffee_bag");
    public static final Block ARABICA_BAG = registryBlock("arabica_coffee_bag");


    // -----------**§§§**----------- //


    // Registries

    // // Plant Blocks
    private static Block coffeePlantBlock(String name, Supplier<Item> seedItem){
        return registryWithoutBlockItem(name,
                            new Coffee(Properties.of().mapColor(MapColor.PLANT).strength(0.1F).noCollission().sound(SoundType.CROP).pushReaction(PushReaction.DESTROY), seedItem));
    }

    // // General Blocks
    private static Block registryBlock(String name){
        return registryBlock(name, new Block(Properties.of()), new Item.Properties());
    }

    private static Block registryBlock(String name, Block block) {
        return registryBlock(name, block, new Item.Properties());
    }

    private static Block registryBlock(String name, Block block, Item.Properties properties) {
        Registry.register(BuiltInRegistries.ITEM,
                            ResourceLocation.fromNamespaceAndPath(Constants.NAMESPACE, name),
                            new BlockItem(block, properties));
        return Registry.register(BuiltInRegistries.BLOCK,
                                ResourceLocation.fromNamespaceAndPath(Constants.NAMESPACE, name),
                                block);
    }

    private static Block registryWithoutBlockItem(String name, Block block) {
        return Registry.register(BuiltInRegistries.BLOCK,
                                ResourceLocation.fromNamespaceAndPath(Constants.NAMESPACE, name),
                                block);
    }

}