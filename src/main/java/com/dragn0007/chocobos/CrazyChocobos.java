package com.dragn0007.chocobos;

import com.dragn0007.chocobos.blocks.CCBlocks;
import com.dragn0007.chocobos.entities.EntityTypes;
import com.dragn0007.chocobos.gui.CCMenuTypes;
import com.dragn0007.chocobos.items.CCItemGroup;
import com.dragn0007.chocobos.items.CCItems;
import com.dragn0007.chocobos.util.ChocobosCommonConfig;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import software.bernie.geckolib.GeckoLib;


@Mod(CrazyChocobos.MODID)
public class CrazyChocobos
{
    public static final String MODID = "chocobos";

    public CrazyChocobos()
    {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        CCItems.register(eventBus);
        CCBlocks.register(eventBus);
        CCItemGroup.register(eventBus);
        EntityTypes.ENTITY_TYPES.register(eventBus);
        CCMenuTypes.register(eventBus);

        GeckoLib.initialize();
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ChocobosCommonConfig.SPEC, "crazy-chocobos-common.toml");

        MinecraftForge.EVENT_BUS.register(this);
    }
}