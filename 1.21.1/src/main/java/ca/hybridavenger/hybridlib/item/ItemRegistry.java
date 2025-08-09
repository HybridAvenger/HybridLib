package ca.hybridavenger.hybridlib.item;

import ca.hybridavenger.hybridlib.HybridLib;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;




public class ItemRegistry {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, HybridLib.MOD_ID);

    //Ingots and Gems
    public static final RegistryObject<Item> TECH_INGOT = ITEMS.register("tech_ingot",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> EUCLASE_GEM = ITEMS.register("euclase_gem",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> NETHER_INGOT = ITEMS.register("nether_ingot",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> AETHERIUM_GEM = ITEMS.register("aetherium_gem",
            () -> new Item(new Item.Properties()));


    //Raw
    public static final RegistryObject<Item> RAW_TECH = ITEMS.register("raw_tech",
            () -> new Item(new Item.Properties()));


    //Others
    public static final RegistryObject<Item> DOUBLE_NETHERITE_INGOT = ITEMS.register("double_netherite_ingot",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> AETHERIUM_GEM_FRAGMENT = ITEMS.register("aetherium_gem_fragment",
            () -> new Item(new Item.Properties()));




    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}