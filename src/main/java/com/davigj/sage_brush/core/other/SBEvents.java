package com.davigj.sage_brush.core.other;

import com.davigj.sage_brush.core.SageBrush;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.animal.Turtle;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.event.tick.EntityTickEvent;

import java.util.function.Supplier;

import static com.davigj.sage_brush.core.other.tags.SBEntityTypeTags.FEATHERED;
import static com.davigj.sage_brush.core.other.tags.SBEntityTypeTags.WORSE_FEATHERED;

@EventBusSubscriber(modid = SageBrush.MOD_ID)
public class SBEvents {
    @SubscribeEvent
    public static void brushPets(PlayerInteractEvent.EntityInteract event) {
        if (event.getEntity().getItemInHand(event.getHand()).is(Items.BRUSH) && event.getTarget() instanceof TamableAnimal tamable && tamable.isOwnedBy(event.getEntity())) {
            event.setCanceled(true);
            event.setCancellationResult(InteractionResult.CONSUME);
            event.getEntity().startUsingItem(event.getHand());
        }
    }

    @SubscribeEvent
    public static void entityTick(EntityTickEvent.Post event) {
        Entity entity = event.getEntity();
        if (entity instanceof LivingEntity target) {

            if (target.getType().is(FEATHERED)) {
                countDown(target, SageBrush.FEATHER_TIMER);
            } else if (target.getType().is(WORSE_FEATHERED)) {
                countDown(target, SageBrush.WORSE_FEATHER_TIMER);
            }
            if (target instanceof Turtle) {
                countDown(target, SageBrush.SCUTE_TIMER);
            }
        }
    }

    private static void countDown(LivingEntity entity, Supplier<AttachmentType<Integer>> timerData) {
        int timer = entity.getData(timerData);
        if (timer > 0) {
            entity.setData(timerData, timer - 1);
        }
    }


}