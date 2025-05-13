package com.davigj.sage_brush.core.mixin;

import com.davigj.sage_brush.core.SBConfig;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.animal.armadillo.Armadillo;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Armadillo.class)
public class ArmadilloMixin {
    @Inject(method = "mobInteract", at = @At("HEAD"), cancellable = true)
    private void brushEntity(Player player, InteractionHand hand, CallbackInfoReturnable<InteractionResult> cir) {
        if (SBConfig.COMMON.armadillos.get())
            cir.setReturnValue(InteractionResult.PASS);
    }
}
