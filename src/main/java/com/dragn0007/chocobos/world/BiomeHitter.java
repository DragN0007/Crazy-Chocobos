package com.dragn0007.chocobos.world;

import com.dragn0007.chocobos.CrazyChocobos;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;

public class BiomeHitter {
    public static final ResourceKey<BiomeModifier> ADD_CHOCOBO_NEST = registerKey("add_chocobo_nest");

    public static void bootstrap(BootstapContext<BiomeModifier> context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

         context.register(ADD_CHOCOBO_NEST, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                 biomes.getOrThrow(Tags.Biomes.IS_SPARSE),
                 HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.CHOCOBO_NEST_PLACED)),
                 GenerationStep.Decoration.SURFACE_STRUCTURES));
    }

    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(CrazyChocobos.MODID, name));
    }
}