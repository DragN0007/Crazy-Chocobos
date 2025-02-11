package com.dragn0007.chocobos.util;

import net.minecraftforge.common.ForgeConfigSpec;

public class ChocobosCommonConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.BooleanValue REPLACE_HORSES;

    static {
        BUILDER.push("Crazy Chocobos!");

        REPLACE_HORSES = BUILDER.comment("Should horses, mules and donkeys be replaced by Chocobos?")
                .define("Replace Horses", false);

        SPEC = BUILDER.build();
    }
}
