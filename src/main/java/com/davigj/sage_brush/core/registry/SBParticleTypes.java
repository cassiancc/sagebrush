package com.davigj.sage_brush.core.registry;

import com.davigj.sage_brush.client.particle.*;
import com.davigj.sage_brush.core.SageBrush;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

@EventBusSubscriber(modid = SageBrush.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class SBParticleTypes {
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister.create(BuiltInRegistries.PARTICLE_TYPE, SageBrush.MOD_ID);

    public static final Supplier<SimpleParticleType> GLEAM = PARTICLE_TYPES.register("gleam", () -> new SimpleParticleType(true));
    public static final Supplier<SimpleParticleType> FEATHER = PARTICLE_TYPES.register("feather", () -> new SimpleParticleType(true));
    public static final Supplier<SimpleParticleType> PARROT_FEATHER = PARTICLE_TYPES.register("parrot_feather", () -> new SimpleParticleType(true));
    public static final Supplier<SimpleParticleType> BLACK_FEATHER = PARTICLE_TYPES.register("black_feather", () -> new SimpleParticleType(true));
    public static final Supplier<SimpleParticleType> HUMMINGBIRD_FEATHER = PARTICLE_TYPES.register("hummingbird_feather", () -> new SimpleParticleType(true));
    public static final Supplier<SimpleParticleType> ROADRUNNER_FEATHER = PARTICLE_TYPES.register("roadrunner_feather", () -> new SimpleParticleType(true));
    public static final Supplier<SimpleParticleType> EMU_FEATHER = PARTICLE_TYPES.register("emu_feather", () -> new SimpleParticleType(true));
    public static final Supplier<SimpleParticleType> SHOEBILL_FEATHER = PARTICLE_TYPES.register("shoebill_feather", () -> new SimpleParticleType(true));
    public static final Supplier<SimpleParticleType> CHERRY_BLOSSOM = PARTICLE_TYPES.register("cherry_blossom", () -> new SimpleParticleType(true));
    public static final Supplier<SimpleParticleType> SPORE_BLOSSOM = PARTICLE_TYPES.register("spore_blossom", () -> new SimpleParticleType(true));
    public static final Supplier<SimpleParticleType> YELLOW_BLOSSOM = PARTICLE_TYPES.register("yellow_blossom", () -> new SimpleParticleType(true));

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void registerParticleFactories(RegisterParticleProvidersEvent event) {
        event.registerSpriteSet(SBParticleTypes.GLEAM.get(), GleamParticle.Provider::new);
        event.registerSpriteSet(SBParticleTypes.FEATHER.get(), FeatherParticle.Provider::new);
        event.registerSpriteSet(SBParticleTypes.PARROT_FEATHER.get(), FeatherParticle.Provider::new);
        event.registerSpriteSet(SBParticleTypes.BLACK_FEATHER.get(), FeatherParticle.Provider::new);
        event.registerSpriteSet(SBParticleTypes.HUMMINGBIRD_FEATHER.get(), FeatherParticle.Provider::new);
        event.registerSpriteSet(SBParticleTypes.ROADRUNNER_FEATHER.get(), FeatherParticle.Provider::new);
        event.registerSpriteSet(SBParticleTypes.EMU_FEATHER.get(), FeatherParticle.Provider::new);
        event.registerSpriteSet(SBParticleTypes.SHOEBILL_FEATHER.get(), FeatherParticle.Provider::new);
        event.registerSpriteSet(SBParticleTypes.CHERRY_BLOSSOM.get(), ShrunkBlossomParticle.Provider::new);
        event.registerSpriteSet(SBParticleTypes.SPORE_BLOSSOM.get(), BlossomParticle.Provider::new);
        event.registerSpriteSet(SBParticleTypes.YELLOW_BLOSSOM.get(), EnlargedBlossomParticle.Provider::new);
    }
}
