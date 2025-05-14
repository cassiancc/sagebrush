package com.davigj.sage_brush.core;

import com.davigj.sage_brush.core.registry.SBParticleTypes;
import net.fabricmc.api.ClientModInitializer;

public class SageBrushClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        SBParticleTypes.registerParticleFactories();
    }
}
