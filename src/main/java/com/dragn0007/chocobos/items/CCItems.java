package com.dragn0007.chocobos.items;

import com.dragn0007.chocobos.CrazyChocobos;
import com.dragn0007.chocobos.entities.EntityTypes;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class CCItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, CrazyChocobos.MODID);

    //Eggs
    public static final RegistryObject<Item> CHOCOBO_SPAWN_EGG = ITEMS.register("chocobo_spawn_egg",
            () -> new ForgeSpawnEggItem(EntityTypes.CHOCOBO_ENTITY, 0xeec058, 0xc69e43, new Item.Properties().stacksTo(64)));

    public static final RegistryObject<Item> CHOCOBO_EGG = ITEMS.register("chocobo_egg",
            () -> new ChocoboEggItem((new Item.Properties()).stacksTo(1)));

    public static final RegistryObject<Item> NETHERITE_CHOCOBO_ARMOR = ITEMS.register("netherite_chocobo_armor",
            () -> new ChocoboArmorItem(15, (new Item.Properties()).stacksTo(1)));
    public static final RegistryObject<Item> DIAMOND_CHOCOBO_ARMOR = ITEMS.register("diamond_chocobo_armor",
            () -> new ChocoboArmorItem(11, (new Item.Properties()).stacksTo(1)));
    public static final RegistryObject<Item> GOLD_CHOCOBO_ARMOR = ITEMS.register("gold_chocobo_armor",
            () -> new ChocoboArmorItem(7, (new Item.Properties()).stacksTo(1)));
    public static final RegistryObject<Item> IRON_CHOCOBO_ARMOR = ITEMS.register("iron_chocobo_armor",
            () -> new ChocoboArmorItem(5, (new Item.Properties()).stacksTo(1)));
    public static final RegistryObject<Item> LEATHER_CHOCOBO_ARMOR = ITEMS.register("leather_chocobo_armor",
            () -> new ChocoboArmorItem(3, (new Item.Properties()).stacksTo(1)));


    //Food/ Items
    public static final RegistryObject<Item> CHOCOBO = ITEMS.register("chocobo",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationMod(1).build())));
    public static final RegistryObject<Item> COOKED_CHOCOBO = ITEMS.register("cooked_chocobo",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(8).saturationMod(1).build())));


    //Mod Item Tab Icon (UNOBTAINABLE)
    public static final RegistryObject<Item> CHOCOBO_ICON = ITEMS.register("chocobo_icon",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}