package com.dragn0007.chocobos.event;

import com.dragn0007.chocobos.CrazyChocobos;
import com.dragn0007.chocobos.util.CCNetwork;
import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CrazyChocobos.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ForgeClientEvents {
    @SubscribeEvent
    public static void onKeyPressEvent(InputEvent.Key event) {
        Player player = Minecraft.getInstance().player;
        if (player == null) return;

        if (event.getAction() == InputConstants.RELEASE && event.getKey() == ChocobosClientEvent.SPEED_UP.getKey().getValue()) {
            CCNetwork.INSTANCE.sendToServer(new CCNetwork.HandleHorseSpeedRequest(1));
        }

        if (event.getAction() == InputConstants.RELEASE && event.getKey() == ChocobosClientEvent.SLOW_DOWN.getKey().getValue()) {
            CCNetwork.INSTANCE.sendToServer(new CCNetwork.HandleHorseSpeedRequest(-1));
        }
    }
}