package com.davigj.sage_brush.core;

import com.davigj.sage_brush.core.other.SBEvents;
import com.davigj.sage_brush.core.registry.SBParticleTypes;
import com.mojang.serialization.Codec;
import dev.architectury.event.events.common.EntityEvent;
import dev.architectury.event.events.common.InteractionEvent;
import fuzs.forgeconfigapiport.fabric.api.neoforge.v4.NeoForgeConfigRegistry;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.attachment.v1.AttachmentRegistry;
import net.fabricmc.fabric.api.attachment.v1.AttachmentType;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.fml.config.ModConfig;

public class SageBrush implements ModInitializer {
    // TODO: docile tags, gleaming entities, IW sand, horsies and donkeys, offended animals, Sully's tortoises
    // TODO later: arts and crafts paintbrushes, domestication innovation pets, example mixin
    // TODO huge stretch goal: block particle jsons, entity particle jsons, entity resource jsons
    // TODO uncertain: brushes getting "gummed up" by things like cobwebs?...
    public static final String MOD_ID = "sage_brush";


    // Create the DeferredRegister for attachment types
    public static final AttachmentType<Integer> FEATHER_TIMER = AttachmentRegistry.createPersistent(
            ResourceLocation.fromNamespaceAndPath(MOD_ID, "feather_timer"), Codec.INT
    );
    public static final AttachmentType<Integer> WORSE_FEATHER_TIMER = AttachmentRegistry.createPersistent(
            ResourceLocation.fromNamespaceAndPath(MOD_ID, "worse_feather_timer"), Codec.INT
    );
    public static final AttachmentType<Integer> SCUTE_TIMER = AttachmentRegistry.createPersistent(
             ResourceLocation.fromNamespaceAndPath(MOD_ID, "scute_timer"), Codec.INT
    );


    @Override
    public void onInitialize() {
        SBParticleTypes.PARTICLE_TYPES.register();
        InteractionEvent.INTERACT_ENTITY.register(SBEvents::brushPets);
        EntityEvent.ADD.register(SBEvents::spawnTurts);

        NeoForgeConfigRegistry.INSTANCE.register(MOD_ID, ModConfig.Type.COMMON, SBConfig.COMMON_SPEC);
        NeoForgeConfigRegistry.INSTANCE.register(MOD_ID,ModConfig.Type.CLIENT, SBConfig.CLIENT_SPEC);
    }
}