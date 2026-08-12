package com.msg.vietnamsdelight.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import com.msg.vietnamsdelight.registries.VDItems;

import net.minecraft.client.Minecraft;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

@Mixin(Mob.class)
public class MobMixin {

    private static DifficultyInstance difficultyInstance;

    @Inject(method = "isSunBurnTick()Z",
            at = @At("HEAD"),
            cancellable = true)
    private void injectIsSunBurnTick(CallbackInfoReturnable<Boolean> cir) {
        if(((Mob)(Object)this).getItemBySlot(EquipmentSlot.HEAD).is(VDItems.NONLA)) cir.setReturnValue(true);
    }
    @Inject(method = "Lnet/minecraft/world/entity/Mob;populateDefaultEquipmentSlots(Lnet/minecraft/util/RandomSource;Lnet/minecraft/world/DifficultyInstance;)V",
            at = @At(value = "TAIL"),
            locals = LocalCapture.CAPTURE_FAILHARD)
    private void captureDifficulty(RandomSource randomSource, DifficultyInstance difficulty_instance, CallbackInfo ci) {
        difficultyInstance = difficulty_instance;
    }

    @Inject(method = "getEquipmentForSlot(Lnet/minecraft/world/entity/EquipmentSlot;I)Lnet/minecraft/world/item/Item;",
            at = @At("HEAD"),
            cancellable = true)
    private static void onGetEquipmentForSlot(EquipmentSlot slot, int chance, CallbackInfoReturnable<Item> cir) {
        Level level = Minecraft.getInstance().level;
        if (slot.equals(EquipmentSlot.HEAD)) {
            RandomSource random = level.getRandom();
            if (random.nextFloat() < 0.15F * difficultyInstance.getSpecialMultiplier()
                && random.nextFloat() < 0.095F) {
                cir.setReturnValue(VDItems.NONLA);
            }
        }
    }
}
