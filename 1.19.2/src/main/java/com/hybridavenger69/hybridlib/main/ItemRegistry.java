package com.hybridavenger69.hybridlib.main;

import com.hybridavenger69.hybridlib.HybridIDS;
import com.hybridavenger69.hybridlib.HybridLib;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class    ItemRegistry {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, HybridIDS.MOD_ID);

    public static final RegistryObject<Item> NETHER_INGOT = ITEMS.register("nether_ingot",
            () -> new Item(new Item.Properties().tab(MtGroup.MT_GROUP)));

    public static final RegistryObject<Item> TECH_INGOT = ITEMS.register("tech_ingot",
            () -> new Item(new Item.Properties().tab(MtGroup.MT_GROUP)));

    public static final RegistryObject<Item> RAW_TECH = ITEMS.register("raw_tech",
            () -> new Item(new Item.Properties().tab(MtGroup.MT_GROUP)));

    public static final RegistryObject<Item> EUCLASE_GEM = ITEMS.register("euclase_gem",
            () -> new Item (new Item.Properties().tab(MtGroup.MT_GROUP)));

    public static final RegistryObject<Item> AETHERIUM_GEM = ITEMS.register("aetherium_gem",
            () -> new Item (new Item.Properties().tab(MtGroup.MT_GROUP)));

    public static final RegistryObject<Item> DOUBLE_NETHERITE_INGOT = ITEMS.register("double_netherite_ingot",
            () -> new Item(new Item.Properties().tab(MtGroup.MT_GROUP)));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
