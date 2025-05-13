package com.davigj.sage_brush.core.other.tags;

import com.davigj.sage_brush.core.SageBrush;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;

public class SBEntityTypeTags {
    public static final TagKey<EntityType<?>> FEATHERED = entityTypeTag("feathered");
    public static final TagKey<EntityType<?>> WORSE_FEATHERED = entityTypeTag("worse_feathered");
    public static final TagKey<EntityType<?>> DOCILE = entityTypeTag("docile");
    public static final TagKey<EntityType<?>> COSMETIC_BLACK_FEATHERS = entityTypeTag("cosmetic_black_feathers");
    public static final TagKey<EntityType<?>> COSMETIC_FEATHERED = entityTypeTag("cosmetic_feathered");

    private static TagKey<EntityType<?>> entityTypeTag(String name) {
        return TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath(SageBrush.MOD_ID, name));
    }
}
