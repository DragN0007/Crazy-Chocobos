package com.dragn0007.chocobos.world;

import com.dragn0007.chocobos.CrazyChocobos;
import com.dragn0007.chocobos.entities.*;
import com.dragn0007.chocobos.util.ChocobosCommonConfig;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.horse.Donkey;
import net.minecraft.world.entity.animal.horse.Horse;
import net.minecraft.world.entity.animal.horse.Mule;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CrazyChocobos.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class SpawnReplacer {

    @SubscribeEvent
    public static void onSpawn(EntityJoinLevelEvent event) {

        //Horse
        if (ChocobosCommonConfig.REPLACE_HORSES.get() && event.getEntity() instanceof Horse) {
            Horse vanillaHorse = (Horse) event.getEntity();

            if (event.getLevel().isClientSide) {
                return;
            }

            Chocobo chocobo = EntityTypes.CHOCOBO_ENTITY.get().create(event.getLevel());
            if (chocobo != null) {
                chocobo.copyPosition(vanillaHorse);

                chocobo.setCustomName(vanillaHorse.getCustomName());
                chocobo.setOwnerUUID(vanillaHorse.getOwnerUUID());
                chocobo.setAge(vanillaHorse.getAge());
                chocobo.getAttribute(Attributes.MAX_HEALTH).setBaseValue(chocobo.generateRandomMaxHealth());
                chocobo.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(chocobo.generateRandomSpeed());
                chocobo.getAttribute(Attributes.JUMP_STRENGTH).setBaseValue(chocobo.generateRandomJumpStrength());

                int randomVariant = event.getLevel().getRandom().nextInt(ChocoboModel.Variant.values().length);
                chocobo.setVariant(randomVariant);

                int randomOverlayVariant = event.getLevel().getRandom().nextInt(ChocoboMarkingLayer.Overlay.values().length);
                chocobo.setOverlayVariant(randomOverlayVariant);

                int randomBreed = event.getLevel().getRandom().nextInt(BreedModel.values().length);
                chocobo.setBreed(randomBreed);

                if (event.getLevel().isClientSide) {
                    vanillaHorse.remove(Entity.RemovalReason.DISCARDED);
                }

                event.getLevel().addFreshEntity(chocobo);
                vanillaHorse.remove(Entity.RemovalReason.DISCARDED);

                event.setCanceled(true);
            }
        }

        //Donkey
        if (ChocobosCommonConfig.REPLACE_HORSES.get() && event.getEntity() instanceof Donkey) {
            Donkey vanillaDonkey = (Donkey) event.getEntity();

            if (event.getLevel().isClientSide) {
                return;
            }

            Chocobo chocobo = EntityTypes.CHOCOBO_ENTITY.get().create(event.getLevel());
            if (chocobo != null) {
                chocobo.copyPosition(vanillaDonkey);

                chocobo.setCustomName(vanillaDonkey.getCustomName());
                chocobo.setOwnerUUID(vanillaDonkey.getOwnerUUID());
                chocobo.setAge(vanillaDonkey.getAge());
                chocobo.getAttribute(Attributes.MAX_HEALTH).setBaseValue(chocobo.generateRandomMaxHealth());
                chocobo.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(chocobo.generateRandomSpeed());
                chocobo.getAttribute(Attributes.JUMP_STRENGTH).setBaseValue(chocobo.generateRandomJumpStrength());

                int randomVariant = event.getLevel().getRandom().nextInt(ChocoboModel.Variant.values().length);
                chocobo.setVariant(randomVariant);

                int randomOverlayVariant = event.getLevel().getRandom().nextInt(ChocoboMarkingLayer.Overlay.values().length);
                chocobo.setOverlayVariant(randomOverlayVariant);

                int randomBreed = event.getLevel().getRandom().nextInt(BreedModel.values().length);
                chocobo.setBreed(randomBreed);

                if (event.getLevel().isClientSide) {
                    vanillaDonkey.remove(Entity.RemovalReason.DISCARDED);
                }

                event.getLevel().addFreshEntity(chocobo);
                vanillaDonkey.remove(Entity.RemovalReason.DISCARDED);

                event.setCanceled(true);
            }
        }

        //Mule
        if (ChocobosCommonConfig.REPLACE_HORSES.get() && event.getEntity() instanceof Mule) {
            Mule vanillaMule = (Mule) event.getEntity();

            if (event.getLevel().isClientSide) {
                return;
            }

            Chocobo chocobo = EntityTypes.CHOCOBO_ENTITY.get().create(event.getLevel());
            if (chocobo != null) {
                chocobo.copyPosition(vanillaMule);

                chocobo.setCustomName(vanillaMule.getCustomName());
                chocobo.setOwnerUUID(vanillaMule.getOwnerUUID());
                chocobo.setAge(vanillaMule.getAge());
                chocobo.getAttribute(Attributes.MAX_HEALTH).setBaseValue(chocobo.generateRandomMaxHealth());
                chocobo.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(chocobo.generateRandomSpeed());
                chocobo.getAttribute(Attributes.JUMP_STRENGTH).setBaseValue(chocobo.generateRandomJumpStrength());

                int randomVariant = event.getLevel().getRandom().nextInt(ChocoboModel.Variant.values().length);
                chocobo.setVariant(randomVariant);

                int randomOverlayVariant = event.getLevel().getRandom().nextInt(ChocoboMarkingLayer.Overlay.values().length);
                chocobo.setOverlayVariant(randomOverlayVariant);

                int randomBreed = event.getLevel().getRandom().nextInt(BreedModel.values().length);
                chocobo.setBreed(randomBreed);

                if (event.getLevel().isClientSide) {
                    vanillaMule.remove(Entity.RemovalReason.DISCARDED);
                }

                event.getLevel().addFreshEntity(chocobo);
                vanillaMule.remove(Entity.RemovalReason.DISCARDED);

                event.setCanceled(true);
            }
        }

    }

}