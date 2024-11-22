package com.dragn0007.chocobos.entities;

import com.dragn0007.chocobos.CrazyChocobos;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ChocoboModel extends GeoModel<Chocobo> {

    public enum Variant {
        ABYSSAL_BLUE(new ResourceLocation(CrazyChocobos.MODID, "textures/entity/abyssal_blue.png")),
        ALDGOAT_BROWN(new ResourceLocation(CrazyChocobos.MODID, "textures/entity/aldgoat_brown.png")),
        APPLE_GREEN(new ResourceLocation(CrazyChocobos.MODID, "textures/entity/apple_green.png")),
        ASH_GREY(new ResourceLocation(CrazyChocobos.MODID, "textures/entity/ash_grey.png")),
        BERRY_RED(new ResourceLocation(CrazyChocobos.MODID, "textures/entity/berry_red.png")),
        BLOOD_RED(new ResourceLocation(CrazyChocobos.MODID, "textures/entity/blood_red.png")),
        BONE_WHITE(new ResourceLocation(CrazyChocobos.MODID, "textures/entity/bone_white.png")),
        CELESTE_GREEN(new ResourceLocation(CrazyChocobos.MODID, "textures/entity/celeste_green.png")),
        COEURL_YELLOW(new ResourceLocation(CrazyChocobos.MODID, "textures/entity/coeurl_yellow.png")),
        COLIBRI_PINK(new ResourceLocation(CrazyChocobos.MODID, "textures/entity/colibri_pink.png")),
        CORAL_PINK(new ResourceLocation(CrazyChocobos.MODID, "textures/entity/coral_pink.png")),
        CORK_BROWN(new ResourceLocation(CrazyChocobos.MODID, "textures/entity/cork_brown.png")),
        CORN_YELLOW(new ResourceLocation(CrazyChocobos.MODID, "textures/entity/corn_yellow.png")),
        CORPSE_BLUE(new ResourceLocation(CrazyChocobos.MODID, "textures/entity/corpse_blue.png")),
        CREAM_YELLOW(new ResourceLocation(CrazyChocobos.MODID, "textures/entity/cream_yellow.png")),
        CURRANT_PURPLE(new ResourceLocation(CrazyChocobos.MODID, "textures/entity/currant_purple.png")),
        DALAMUND_RED(new ResourceLocation(CrazyChocobos.MODID, "textures/entity/dalamund_red.png")),
        DARK_GREY(new ResourceLocation(CrazyChocobos.MODID, "textures/entity/dark_grey.png")),
        DEEPWOOD_GREEN(new ResourceLocation(CrazyChocobos.MODID, "textures/entity/deepwood_green.png")),
        DESERT_YELLOW(new ResourceLocation(CrazyChocobos.MODID, "textures/entity/desert_yellow.png")),
        GLOOM_PURPLE(new ResourceLocation(CrazyChocobos.MODID, "textures/entity/gloom_purple.png")),
        GOBBLEBAE_BROWN(new ResourceLocation(CrazyChocobos.MODID, "textures/entity/gobblebae_brown.png")),
        GRAPE_PURPLE(new ResourceLocation(CrazyChocobos.MODID, "textures/entity/grape_purple.png")),
        HONEY_YELLOW(new ResourceLocation(CrazyChocobos.MODID, "textures/entity/honey_yellow.png")),
        ICE_BLUE(new ResourceLocation(CrazyChocobos.MODID, "textures/entity/ice_blue.png")),
        ICY_WHITE(new ResourceLocation(CrazyChocobos.MODID, "textures/entity/icy_white.png")),
        IRIS_PURPLE(new ResourceLocation(CrazyChocobos.MODID, "textures/entity/iris_purple.png")),
        KOBOLD_BROWN(new ResourceLocation(CrazyChocobos.MODID, "textures/entity/kobold_brown.png")),
        LAVENDER_PURPLE(new ResourceLocation(CrazyChocobos.MODID, "textures/entity/lavender_purple.png")),
        LIGHT_BROWN(new ResourceLocation(CrazyChocobos.MODID, "textures/entity/light_brown.png")),
        LILAC_PURPLE(new ResourceLocation(CrazyChocobos.MODID, "textures/entity/lilac_purple.png")),
        LIME_GREEN(new ResourceLocation(CrazyChocobos.MODID, "textures/entity/lime_green.png")),
        LOTUS_PINK(new ResourceLocation(CrazyChocobos.MODID, "textures/entity/lotus_pink.png")),
        MARSH_GREEN(new ResourceLocation(CrazyChocobos.MODID, "textures/entity/marsh_green.png")),
        MEADOW_GREEN(new ResourceLocation(CrazyChocobos.MODID, "textures/entity/meadow_green.png")),
        MIDNIGHT_BLUE(new ResourceLocation(CrazyChocobos.MODID, "textures/entity/midnight_blue.png")),
        ORTHARD_BLUE(new ResourceLocation(CrazyChocobos.MODID, "textures/entity/orthard_blue.png")),
        PEACOCK_BLUE(new ResourceLocation(CrazyChocobos.MODID, "textures/entity/peacock_blue.png")),
        PLUM_PURPLE(new ResourceLocation(CrazyChocobos.MODID, "textures/entity/plum_purple.png")),
        PUMPKIN_ORANGE(new ResourceLocation(CrazyChocobos.MODID, "textures/entity/pumpkin_orange.png")),
        RAPTOR_BLUE(new ResourceLocation(CrazyChocobos.MODID, "textures/entity/raptor_blue.png")),
        REGAL_PURPLE(new ResourceLocation(CrazyChocobos.MODID, "textures/entity/regal_purple.png")),
        ROSE_PINK(new ResourceLocation(CrazyChocobos.MODID, "textures/entity/rose_pink.png")),
        ROYAL_BLUE(new ResourceLocation(CrazyChocobos.MODID, "textures/entity/royal_blue.png")),
        SALMON_PINK(new ResourceLocation(CrazyChocobos.MODID, "textures/entity/salmon_pink.png")),
        SEAFOG_BLUE(new ResourceLocation(CrazyChocobos.MODID, "textures/entity/seafog_blue.png")),
        SHALE_BROWN(new ResourceLocation(CrazyChocobos.MODID, "textures/entity/shale_brown.png")),
        SILVER_GREY(new ResourceLocation(CrazyChocobos.MODID, "textures/entity/silver_grey.png")),
        SKY_BLUE(new ResourceLocation(CrazyChocobos.MODID, "textures/entity/sky_blue.png")),
        SLYPH_GREEN(new ResourceLocation(CrazyChocobos.MODID, "textures/entity/slyph_green.png")),
        SNOW_WHITE(new ResourceLocation(CrazyChocobos.MODID, "textures/entity/snow_white.png")),
        SOOT_BLACK(new ResourceLocation(CrazyChocobos.MODID, "textures/entity/soot_black.png")),
        STORM_BLUE(new ResourceLocation(CrazyChocobos.MODID, "textures/entity/storm_blue.png")),
        SUNSET_ORANGE(new ResourceLocation(CrazyChocobos.MODID, "textures/entity/sunset_orange.png")),
        TURQUOISE_BLUE(new ResourceLocation(CrazyChocobos.MODID, "textures/entity/turquoise_blue.png")),
        UI_BROWN(new ResourceLocation(CrazyChocobos.MODID, "textures/entity/ui_brown.png")),
        VOID_BLACK(new ResourceLocation(CrazyChocobos.MODID, "textures/entity/void_black.png")),
        VOID_BLUE(new ResourceLocation(CrazyChocobos.MODID, "textures/entity/void_blue.png")),
        WINE_RED(new ResourceLocation(CrazyChocobos.MODID, "textures/entity/wine_red.png"));

        public final ResourceLocation resourceLocation;
        Variant(ResourceLocation resourceLocation) {
            this.resourceLocation = resourceLocation;
        }

        public static Variant variantFromOrdinal(int variant) { return Variant.values()[variant % Variant.values().length];
        }
    }

    public static final ResourceLocation ANIMATION = new ResourceLocation(CrazyChocobos.MODID, "animations/chocobo.animation.json");

    public static final ResourceLocation BABY_MODEL = new ResourceLocation(CrazyChocobos.MODID, "geo/chicobo.geo.json");

    @Override
    public ResourceLocation getModelResource(Chocobo object) {
        if(object.isBaby())
            return BABY_MODEL;
        return BreedModel.breedFromOrdinal(object.getBreed()).resourceLocation;
    }

    @Override
    public ResourceLocation getTextureResource(Chocobo object) {
        return object.getTextureResource();
    }

    @Override
    public ResourceLocation getAnimationResource(Chocobo animatable) {
        return ANIMATION;
    }
}

