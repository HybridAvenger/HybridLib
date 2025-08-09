package com.hybridavenger69.hybridlib;

import com.hybridavenger69.hybridlib.main.BlockRegistry;
import com.hybridavenger69.hybridlib.main.ItemRegistry;
import com.hybridavenger69.hybridlib.main.world.feature.ModConfiguredFeatures;
import com.hybridavenger69.hybridlib.main.world.feature.ModPlacedFeatures;
import com.mojang.logging.LogUtils;

import net.minecraftforge.common.MinecraftForge;

import net.minecraftforge.eventbus.api.IEventBus;


import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;




// The value here should
//match an entry in the META-INF/mods.toml file
@Mod(HybridIDS.MOD_ID)
public class HybridLib {

    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public HybridLib() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

       ItemRegistry.register(modEventBus);
       BlockRegistry.register(modEventBus);


        // Register event handlers


        ModConfiguredFeatures.CONFIGURED_FEATURES.register(modEventBus);
        ModPlacedFeatures.PLACED_FEATURES.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }


    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = HybridIDS.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}

