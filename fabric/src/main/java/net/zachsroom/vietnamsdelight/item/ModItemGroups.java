package net.zachsroom.vietnamsdelight.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModItemGroups {
    public static final CreativeModeTab VD_GROUP = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
                                                                    ResourceLocation.parse("vietnamsdelight"),
                                                                    FabricItemGroup.builder().title(Component.translatable("itemgroup.VD_GROUP"))
                                                                                            .icon(() -> new ItemStack(ModItems.BANHMI))
                                                                                            .displayItems((displayContext, entries) -> {
                                                                                                entries.accept(ModItems.RICEFLOUR);
                                                                                                entries.accept(ModItems.CORNSTARCH);
                                                                                                entries.accept(ModItems.RICEMIXEDDOUGH);
                                                                                                entries.accept(ModItems.RICEBATTER);
                                                                                                entries.accept(ModItems.BANHMI);
                                                                                                entries.accept(ModItems.RICENOODLESHEET);
                                                                                                entries.accept(ModItems.FLATRICENOODLE);
                                                                                                entries.accept(ModItems.PHO);
                                                                                                entries.accept(ModItems.CHICKENPHO);
                                                                                                entries.accept(ModItems.BEEFPHO);
                                                                                                entries.accept(ModItems.NONLA);
                                                                                            }).build());

    public static void registerItemGroups() {}
}
