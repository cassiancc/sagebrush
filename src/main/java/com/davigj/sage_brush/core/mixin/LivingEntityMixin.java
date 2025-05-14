package com.davigj.sage_brush.core.mixin;

import com.davigj.sage_brush.core.other.SBEvents;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {
    @Inject(method = "tick", at = @At(value = "HEAD"))
    private void mixin(CallbackInfo ci) {
        SBEvents.entityTick((LivingEntity) (Object)  this);
    }
}
