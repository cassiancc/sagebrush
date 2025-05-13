package com.davigj.sage_brush.core;

import com.davigj.sage_brush.core.registry.SBParticleTypes;
import com.mojang.serialization.Codec;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.function.Supplier;

@Mod(SageBrush.MOD_ID)
public class SageBrush {
    // TODO: docile tags, gleaming entities, IW sand, horsies and donkeys, offended animals, Sully's tortoises
    // TODO later: arts and crafts paintbrushes, domestication innovation pets, example mixin
    // TODO huge stretch goal: block particle jsons, entity particle jsons, entity resource jsons
    // TODO uncertain: brushes getting "gummed up" by things like cobwebs?...
    public static final String MOD_ID = "sage_brush";


    // Create the DeferredRegister for attachment types
    private static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES = DeferredRegister.create(NeoForgeRegistries.ATTACHMENT_TYPES, MOD_ID);
    public static final Supplier<AttachmentType<Integer>> FEATHER_TIMER = ATTACHMENT_TYPES.register(
            "feather_timer", () -> AttachmentType.builder(() -> 0).serialize(Codec.INT).build()
    );
    public static final Supplier<AttachmentType<Integer>> WORSE_FEATHER_TIMER = ATTACHMENT_TYPES.register(
            "worse_feather_timer", () -> AttachmentType.builder(() -> 0).serialize(Codec.INT).build()
    );
    public static final Supplier<AttachmentType<Integer>> SCUTE_TIMER = ATTACHMENT_TYPES.register(
            "scute_timer", () -> AttachmentType.builder(() -> 0).serialize(Codec.INT).build()
    );

    public SageBrush(IEventBus bus, ModContainer container) {
        ATTACHMENT_TYPES.register(bus);
        SBParticleTypes.PARTICLE_TYPES.register(bus);

        bus.addListener(this::commonSetup);
        bus.addListener(this::clientSetup);
        bus.addListener(this::dataSetup);
        container.registerConfig(ModConfig.Type.COMMON, SBConfig.COMMON_SPEC);
        container.registerConfig(ModConfig.Type.CLIENT, SBConfig.CLIENT_SPEC);
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {

        });
    }

    private void clientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {

        });
    }

    private void dataSetup(GatherDataEvent event) {

    }
}