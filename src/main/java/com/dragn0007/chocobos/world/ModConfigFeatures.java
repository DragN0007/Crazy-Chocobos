package com.dragn0007.chocobos.world;


import com.dragn0007.chocobos.CrazyChocobos;
import com.dragn0007.chocobos.blocks.CCBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public class ModConfigFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> CHOCOBO_NEST = registerKey("chocobo_nest");


    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {

        register(context, CHOCOBO_NEST, Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(CCBlocks.CHOCOBO_NEST.get())));
        
    }
    
    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(CrazyChocobos.MODID, name));
    }
    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}


