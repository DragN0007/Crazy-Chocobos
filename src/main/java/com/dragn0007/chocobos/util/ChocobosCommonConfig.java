package com.dragn0007.chocobos.util;

import net.minecraftforge.common.ForgeConfigSpec;

public class ChocobosCommonConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.BooleanValue REPLACE_HORSES;
    public static final ForgeConfigSpec.ConfigValue<Integer> NEST_FREQUENCY;

    static {
        BUILDER.push("Crazy Chocobos!");

        REPLACE_HORSES = BUILDER.comment("Should horses, mules and donkeys be replaced by Chocobos?")
                .define("Replace Horses", false);

        NEST_FREQUENCY = BUILDER.comment("How often nests should spawn on average. (The lower the number, the higher the spawn rate). Default is 10 (Uncommon).")
                .define("Chocobo Nest Frequency", 10);

        SPEC = BUILDER.build();
    }
}
