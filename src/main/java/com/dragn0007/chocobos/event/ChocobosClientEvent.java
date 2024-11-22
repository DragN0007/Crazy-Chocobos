package com.dragn0007.chocobos.event;

import com.dragn0007.chocobos.CrazyChocobos;
import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber(modid = CrazyChocobos.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ChocobosClientEvent {

    public static final KeyMapping SPEED_UP = new KeyMapping("key.chocobos.speed_up", InputConstants.KEY_LCONTROL, "key.chocobos.categories.chocobos");
    public static final KeyMapping SLOW_DOWN = new KeyMapping("key.chocobos.slow_down", InputConstants.KEY_LALT, "key.chocobos.categories.chocobos");

    @SubscribeEvent
    public static void registerKeyBindings(RegisterKeyMappingsEvent event) {
        KeyMapping[] keyMappings = {SPEED_UP, SLOW_DOWN};
        for (KeyMapping keyMapping : keyMappings) {
            event.register(keyMapping);
        }
    }
}