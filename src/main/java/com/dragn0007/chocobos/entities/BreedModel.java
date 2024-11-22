package com.dragn0007.chocobos.entities;

import com.dragn0007.chocobos.CrazyChocobos;
import net.minecraft.resources.ResourceLocation;

public enum BreedModel {
    DESTRIER(new ResourceLocation(CrazyChocobos.MODID, "geo/chocobo_destrier.geo.json")),
    ROUNSEY(new ResourceLocation(CrazyChocobos.MODID, "geo/chocobo_rounsey.geo.json")),
    KENNEL(new ResourceLocation(CrazyChocobos.MODID, "geo/chocobo_kennel.geo.json"));

    public final ResourceLocation resourceLocation;

    BreedModel(ResourceLocation resourceLocation) {
        this.resourceLocation = resourceLocation;
    }

    public static BreedModel breedFromOrdinal(int ordinal) {
        return BreedModel.values()[ordinal % BreedModel.values().length];
    }

}

