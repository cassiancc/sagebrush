package com.davigj.sage_brush.core.registry;

import com.davigj.sage_brush.client.particle.*;
import com.davigj.sage_brush.core.SageBrush;
import dev.architectury.registry.registries.DeferredRegister;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;

import java.util.function.Supplier;

public class SBParticleTypes {
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister.create(SageBrush.MOD_ID, Registries.PARTICLE_TYPE);

    public static final Supplier<SimpleParticleType> GLEAM = PARTICLE_TYPES.register("gleam", () -> FabricParticleTypes.simple(true));
    public static final Supplier<SimpleParticleType> FEATHER = PARTICLE_TYPES.register("feather", () -> FabricParticleTypes.simple(true));
    public static final Supplier<SimpleParticleType> PARROT_FEATHER = PARTICLE_TYPES.register("parrot_feather", () -> FabricParticleTypes.simple(true));
    public static final Supplier<SimpleParticleType> BLACK_FEATHER = PARTICLE_TYPES.register("black_feather", () -> FabricParticleTypes.simple(true));
    public static final Supplier<SimpleParticleType> HUMMINGBIRD_FEATHER = PARTICLE_TYPES.register("hummingbird_feather", () -> FabricParticleTypes.simple(true));
    public static final Supplier<SimpleParticleType> ROADRUNNER_FEATHER = PARTICLE_TYPES.register("roadrunner_feather", () -> FabricParticleTypes.simple(true));
    public static final Supplier<SimpleParticleType> EMU_FEATHER = PARTICLE_TYPES.register("emu_feather", () -> FabricParticleTypes.simple(true));
    public static final Supplier<SimpleParticleType> SHOEBILL_FEATHER = PARTICLE_TYPES.register("shoebill_feather", () -> FabricParticleTypes.simple(true));
    public static final Supplier<SimpleParticleType> CHERRY_BLOSSOM = PARTICLE_TYPES.register("cherry_blossom", () -> FabricParticleTypes.simple(true));
    public static final Supplier<SimpleParticleType> SPORE_BLOSSOM = PARTICLE_TYPES.register("spore_blossom", () -> FabricParticleTypes.simple(true));
    public static final Supplier<SimpleParticleType> YELLOW_BLOSSOM = PARTICLE_TYPES.register("yellow_blossom", () -> FabricParticleTypes.simple(true));

    public static void registerParticleFactories() {
        var event = ParticleFactoryRegistry.getInstance();
        event.register(SBParticleTypes.GLEAM.get(), GleamParticle.Provider::new);
        event.register(SBParticleTypes.FEATHER.get(), FeatherParticle.Provider::new);
        event.register(SBParticleTypes.PARROT_FEATHER.get(), FeatherParticle.Provider::new);
        event.register(SBParticleTypes.BLACK_FEATHER.get(), FeatherParticle.Provider::new);
        event.register(SBParticleTypes.HUMMINGBIRD_FEATHER.get(), FeatherParticle.Provider::new);
        event.register(SBParticleTypes.ROADRUNNER_FEATHER.get(), FeatherParticle.Provider::new);
        event.register(SBParticleTypes.EMU_FEATHER.get(), FeatherParticle.Provider::new);
        event.register(SBParticleTypes.SHOEBILL_FEATHER.get(), FeatherParticle.Provider::new);
        event.register(SBParticleTypes.CHERRY_BLOSSOM.get(), ShrunkBlossomParticle.Provider::new);
        event.register(SBParticleTypes.SPORE_BLOSSOM.get(), BlossomParticle.Provider::new);
        event.register(SBParticleTypes.YELLOW_BLOSSOM.get(), EnlargedBlossomParticle.Provider::new);
    }
}
