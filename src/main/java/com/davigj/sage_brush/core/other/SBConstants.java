package com.davigj.sage_brush.core.other;

import com.davigj.sage_brush.core.registry.SBParticleTypes;
import com.github.alexthe666.alexsmobs.client.particle.AMParticleRegistry;
import com.github.alexthe666.alexsmobs.entity.EntityEmu;
import com.github.alexthe666.alexsmobs.entity.EntityRoadrunner;
import com.github.alexthe666.alexsmobs.item.AMItemRegistry;
import com.teamabnormals.atmospheric.core.registry.AtmosphericBlocks;
import com.uraneptus.sullysmod.common.entities.Tortoise;
import com.uraneptus.sullysmod.core.registry.SMItems;
import net.mehvahdjukaar.supplementaries.reg.ModRegistry;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.fml.ModList;

import static com.teamabnormals.atmospheric.common.block.AloeVeraTallBlock.AGE;

public class SBConstants {
    public static final Item emuFeather;
    public static final Item roadrunnerFeather;
    public static final Item tortoiseScute;
    public static final ParticleOptions sunbirdParticle;

    public static boolean isEmu(Entity entity) {
        return false;
//        return entity instanceof EntityEmu;
    }
    public static boolean isHummingbird(Entity entity) {
        return false;
//        return entity instanceof EntityHummingbird;
    }
    public static boolean isSunbird(Entity entity) {
        return false;
//        return entity instanceof EntitySunbird;
    }
    public static boolean isRoadrunner(Entity entity) {
        return false;
//        return entity instanceof EntityRoadrunner;
    }
    public static boolean isShoebill(Entity entity) {
        return false;
//        return entity instanceof EntityShoebill;
    }

    public static boolean isFeatherBlock(BlockState state) {
        return state.is(ModRegistry.FEATHER_BLOCK.get());
    }

    public static boolean isYellowBlossom(BlockState state) {
        return (state.is(AtmosphericBlocks.TALL_ALOE_VERA.get()) && state.getValue(AGE) > 5 && state.getValue(DoublePlantBlock.HALF) == DoubleBlockHalf.UPPER)
                || state.is(AtmosphericBlocks.FLOWERING_MORADO_LEAVES.get());
    }

    static {
        // Alex's Mobs currently is not planning to move to 1.21.1.
        emuFeather = Items.FEATHER;
        roadrunnerFeather = Items.FEATHER;
        tortoiseScute = Items.SCUTE;
        sunbirdParticle = SBParticleTypes.FEATHER.get();
    }
}
