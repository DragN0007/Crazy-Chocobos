package com.dragn0007.chocobos.event;

import com.dragn0007.chocobos.CrazyChocobos;
import com.dragn0007.chocobos.entities.Chocobo;
import com.dragn0007.chocobos.entities.ChocoboRender;
import com.dragn0007.chocobos.entities.EntityTypes;
import com.dragn0007.chocobos.gui.CCMenuTypes;
import com.dragn0007.chocobos.gui.ChocoboScreen;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;


@Mod.EventBusSubscriber(modid = CrazyChocobos.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ChocobosEvent {

    @SubscribeEvent
    public static void entityAttrbiuteCreationEvent(EntityAttributeCreationEvent event) {
        event.put(EntityTypes.CHOCOBO_ENTITY.get(), Chocobo.createBaseChocoboAttributes().build());
    }

    @SubscribeEvent
    public static void clientSetupEvent(FMLClientSetupEvent event) {
        EntityRenderers.register(EntityTypes.CHOCOBO_ENTITY.get(), ChocoboRender::new);

        MenuScreens.register(CCMenuTypes.CHOCOBO_MENU.get(), ChocoboScreen::new);
    }
}