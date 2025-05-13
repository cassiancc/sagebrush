package com.davigj.sage_brush.core;

import net.neoforged.neoforge.common.ModConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public class SBConfig {
    public static class Common {
        public final ModConfigSpec.ConfigValue<Boolean> regen;
        public final ModConfigSpec.ConfigValue<Boolean> brushSnag;
        public final ModConfigSpec.ConfigValue<Boolean> brushSnagMockDamage;
        public final ModConfigSpec.ConfigValue<Boolean> pandaSneeze;
        public final ModConfigSpec.ConfigValue<Boolean> weakAndSick;
        public final ModConfigSpec.ConfigValue<Boolean> lazyAndPlayful;
        public final ModConfigSpec.ConfigValue<Double> pandaSnagChance;
        public final ModConfigSpec.ConfigValue<Double> featherSnagChance;
        public final ModConfigSpec.ConfigValue<Boolean> featheredMolt;
        public final ModConfigSpec.ConfigValue<Integer> moltTimer;
        public final ModConfigSpec.ConfigValue<Integer> worseMoltTimer;
        public final ModConfigSpec.ConfigValue<Boolean> removable;
        public final ModConfigSpec.ConfigValue<Boolean> scutesSpawnSet;
        public final ModConfigSpec.ConfigValue<Boolean> scute;
        public final ModConfigSpec.ConfigValue<Integer> scuteTimer;
        public final ModConfigSpec.ConfigValue<Integer> scuteBabyDrops;
        public final ModConfigSpec.ConfigValue<Boolean> torScute;
        public final ModConfigSpec.ConfigValue<Integer> torScuteTimer;
        public final ModConfigSpec.ConfigValue<Integer> torScuteBabyDrops;

        Common (ModConfigSpec.Builder builder) {
            builder.push("common");
            builder.push("entity_interactions");
            regen = builder.comment("Pets periodically get Regeneration when brushed").translation("sage_brush.configuration.regen").define("Pet regen", false);
            builder.push("pandas");
            pandaSneeze = builder.comment("Pandas periodically sneeze when brushed").translation("sage_brush.configuration.pandas.sneeze").define("Pandas sneeze", true);
            weakAndSick = builder.comment("Only weak or baby pandas sneeze when brushed").translation("sage_brush.configuration.weak_and_sick").define("Weak or babies sneeze", true);
            lazyAndPlayful = builder.comment("Lazy and playful pandas are not provoked by being forced to sneeze").translation("sage_brush.configuration.lazy_and_playful").define("Lazy and playful pandas stay docile", true);
            builder.pop();
            builder.push("feather_drops");
            featheredMolt = builder.comment("Mobs in the feathered tag periodically drop feather items when brushed").define("Feathered molt", true);
            moltTimer = builder.comment("Feather molt cooldown, in ticks. Defaults to ~4 feathers a day").define("Molt timer", 6000);
            worseMoltTimer = builder.comment("Feather molt cooldown for worse_feathered mobs, in ticks. Defaults to ~2 feathers a day").define("Molt timer", 12000);
            builder.pop();
            builder.push("scute_drops");
            scute = builder.comment("Adult turtles periodically drop scutes when brushed").translation("sage_brush.configuration.turtle_scute_drops").define("Turtles shed scutes", true);
            scuteTimer = builder.comment("Scute shed cooldown, in ticks. Defaults to ~1 scute every two days.").translation("sage_brush.configuration.scute_drops").define("Scute timer", 48000);
            scuteBabyDrops = builder.comment("Number of scutes dropped by baby turtles when grown, to compensate for brushing adults").translation("sage_brush.configuration.scute_baby_drops").define("Baby turtle scute drops", 3);
            armadillos = builder.comment("Add a cooldown to brushing Armadillos").translation("sage_brush.configuration.armadillos").define("Replace Armadillo interaction", true);
            scutesSpawnSet = builder.comment("Scute shedders spawn with scute timers that are still ticking down").define("Scute timer spawn set", true);
            torScute = builder.comment("Adult tortoises from Sully's Mod periodically drop tortoise scutes when brushed").define("Tortoises shed scutes", true);
            torScuteTimer = builder.comment("Tortoise scute shed cooldown, in ticks. Defaults to ~1 scute every two days.").define("Tortoise scute timer", 48000);
            torScuteBabyDrops = builder.comment("Number of scutes dropped by baby tortoises when grown, to compensate for brushing adults").define("Baby tortoise scute drops", 3);
            builder.pop();
            builder.push("brush_snags");
            brushSnag = builder.comment("Brushes occasionally provoke mobs that have no resources to shed, causing them to attack or panic").translation("sage_brush.configuration.brush_snags").define("Brushes snag", false);
            brushSnagMockDamage = builder.comment("Brushes deal fake (zero) damage upon snagging").define("Brush snag deals mock damage", false);
            pandaSnagChance = builder.comment("Panda snag chance").translation("sage_brush.configuration.panda_snag_chance").define("Panda snag chance", 0.05);
            featherSnagChance = builder.comment("Feathered mobs snag chance").translation("sage_brush.configuration.feather_snag_chance").define("Feathered snag chance", 0.15);
            builder.pop();
            builder.pop();
            builder.push("block_interactions");
            removable = builder.comment("Brushes destroy blocks in the removable tag").translation("sage_brush.configuration.removable").define("Removable", true);
            builder.pop();
            builder.pop();
        }
    }

    public static class Client {
        public final ModConfigSpec.ConfigValue<Boolean> reducedParticles;
        public final ModConfigSpec.ConfigValue<Boolean> gleamingParticles;
        public final ModConfigSpec.ConfigValue<Boolean> purePolish;
        public final ModConfigSpec.ConfigValue<Boolean> petHearts;
        public final ModConfigSpec.ConfigValue<Boolean> molt;
        public final ModConfigSpec.ConfigValue<Boolean> gleam;
        public final ModConfigSpec.ConfigValue<Boolean> specializedParticles;

        public Client(ModConfigSpec.Builder builder) {
            builder.push("client");
            builder.push("entity_interactions");
            petHearts = builder.comment("Pets periodically emit hearts when brushed").translation("sage_brush.configuration.pet_hearts").define("Pet hearts", true);
            molt = builder.comment("Feathered mobs periodically molt feathers when brushed").translation("sage_brush.configuration.molt").define("Molting", true);
            gleam = builder.comment("Overbrushed animals gleam. A more domestic alternative to brush snags").translation("sage_brush.configuration.gleaming_mobs").define("Gleaming mobs", true);
            builder.pop();
            builder.push("block_interactions");
            specializedParticles = builder.comment("Dust particle behaviors for brushes are altered at all").translation("sage_brush.configuration.specialized_particles").define("Specialized particles", true);
            reducedParticles = builder.comment("Certain blocks emit fewer particles when brushed").translation("sage_brush.configuration.reduced_dust").define("Reduced dust", true);
            gleamingParticles = builder.comment("Certain blocks emit gleam particles when brushed").translation("sage_brush.configuration.gleaming_blocks").define("Gleaming blocks", true);
            purePolish = builder.comment("Gleaming blocks do not emit dust particles when brushed").translation("sage_brush.configuration.pure_polish").define("Pure polish", false);
            builder.pop();
            builder.pop();
        }
    }

    static final ModConfigSpec COMMON_SPEC;
    public static final SBConfig.Common COMMON;

    public static final ModConfigSpec CLIENT_SPEC;
    public static final Client CLIENT;

    static {
        final Pair<Common, ModConfigSpec> specPair = new ModConfigSpec.Builder().configure(SBConfig.Common::new);
        COMMON_SPEC = specPair.getRight();
        COMMON = specPair.getLeft();

        Pair<Client, ModConfigSpec> clientSpecPair = new ModConfigSpec.Builder().configure(Client::new);
        CLIENT_SPEC = clientSpecPair.getRight();
        CLIENT = clientSpecPair.getLeft();
    }
}
