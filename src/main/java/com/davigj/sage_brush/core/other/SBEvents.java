package com.davigj.sage_brush.core.other;

import com.davigj.sage_brush.core.SBConfig;
import com.davigj.sage_brush.core.SageBrush;
import dev.architectury.event.EventResult;
import net.fabricmc.fabric.api.attachment.v1.AttachmentType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.animal.Turtle;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

import static com.davigj.sage_brush.core.other.tags.SBEntityTypeTags.FEATHERED;
import static com.davigj.sage_brush.core.other.tags.SBEntityTypeTags.WORSE_FEATHERED;

public class SBEvents {
    public static EventResult brushPets(Player player, Entity entity, InteractionHand interactionHand) {
        if (player.getItemInHand(interactionHand).is(Items.BRUSH) && entity instanceof TamableAnimal tamable && tamable.isOwnedBy(player)) {
            player.startUsingItem(interactionHand);
            return EventResult.interruptDefault();
        }
        return EventResult.pass();
    }

    public static EventResult spawnTurts(Entity entity, Level level) {
        if (entity instanceof LivingEntity living) {
            if ((living instanceof Turtle && SBConfig.COMMON.scute.get()) ||
                    (SBConfig.COMMON.torScute.get() && (FabricLoader.getInstance().isModLoaded("sullysmod") && SBConstants.isTortoise(living)))) {
                entity.setAttached(SageBrush.SCUTE_TIMER, living.getRandom().nextInt(SBConfig.COMMON.scuteTimer.get()));
            }
        }
        return EventResult.pass();
    }

    public static void entityTick(LivingEntity target) {
        if (target.getType().is(FEATHERED)) {
            countDown(target, SageBrush.FEATHER_TIMER);
        } else if (target.getType().is(WORSE_FEATHERED)) {
            countDown(target, SageBrush.WORSE_FEATHER_TIMER);
        }
        if ((target instanceof Turtle && SBConfig.COMMON.scute.get()) ||
                (FabricLoader.getInstance().isModLoaded("sullysmod") && SBConstants.isTortoise(target) && SBConfig.COMMON.torScute.get())) {
            countDown(target, SageBrush.SCUTE_TIMER);
        }
    }

    private static void countDown(LivingEntity entity, AttachmentType<Integer> timerData) {
        int timer = entity.getAttachedOrElse(timerData, 0);
        if (timer > 0) {
            entity.setAttached(timerData, timer - 1);
        }
    }
}