package com.dragn0007.chocobos.world;

import com.dragn0007.chocobos.CrazyChocobos;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class ModPlacedFeatures {

    public static final ResourceKey<PlacedFeature> CHOCOBO_NEST_PLACED = registerKey("chocobo_nest_placed");


    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);


        register(context, CHOCOBO_NEST_PLACED, configuredFeatures.getOrThrow(ModConfigFeatures.CHOCOBO_NEST),
                List.of(RarityFilter.onAverageOnceEvery(10),
                        InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));

    }

        private static ResourceKey<PlacedFeature> registerKey (String name){
            return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(CrazyChocobos.MODID, name));
        }
        private static void register
        (BootstapContext < PlacedFeature > context, ResourceKey < PlacedFeature > key, Holder < ConfiguredFeature < ?, ?>>
        configuration,
                List < PlacementModifier > modifiers){
            context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
        }
}
