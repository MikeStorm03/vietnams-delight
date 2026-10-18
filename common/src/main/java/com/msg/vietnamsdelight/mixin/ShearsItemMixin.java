package com.msg.vietnamsdelight.mixin;

import java.util.ArrayList;
import java.util.List;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.msg.vietnamsdelight.Constants;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShearsItem;
import net.minecraft.world.item.component.Tool.Rule;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

@Mixin(ShearsItem.class)
public class ShearsItemMixin {

    @ModifyArg(method = "Lnet/minecraft/world/item/ShearsItem;createToolProperties()Lnet/minecraft/world/item/component/Tool;",
                at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/component/Tool;<init>(Ljava/util/List;FI)V"),
                index = 0)
    private static List<Rule> addToolProperties(List<Rule> list){
        List<Rule> newList = new ArrayList<Rule>(list);
        newList.add(Rule.overrideSpeed(Constants.SHEARS, 5.0F));
        return newList;
    }

    @Inject(method = "Lnet/minecraft/world/item/ShearsItem;mineBlock(Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/level/Level;Lnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/entity/LivingEntity;)Z",
            at = @At("RETURN"), cancellable = true)
    private void injectMineBlock(ItemStack stack, Level level, BlockState state, BlockPos pos, LivingEntity miningEntity, CallbackInfoReturnable<Boolean> cir) {
        if (state.is(Constants.SHEARS)) cir.setReturnValue(true);
    }
}
