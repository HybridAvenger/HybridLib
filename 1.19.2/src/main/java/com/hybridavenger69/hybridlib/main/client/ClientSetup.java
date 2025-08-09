package com.hybridavenger69.hybridlib.main.client;

import com.hybridavenger69.hybridlib.HybridIDS;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber(modid = HybridIDS.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientSetup {

    // List to store energy items from other mods
    private static final List<RegistryObject<Item>> ENERGY_ITEMS = new ArrayList<>();

    // Initialize client-side setup
    public static void init(FMLClientSetupEvent event) {
        // Client-side initialization (if needed)
    }

    // Register item colors
    @SubscribeEvent
    public static void onItemColorHandler(RegisterColorHandlersEvent.Item event) {
        // Register the energy tool's color handler for all registered energy items
        ENERGY_ITEMS.forEach(item -> event.register(new EnergyToolColorHandler(), item.get()));
    }

    // Custom color handler for the energy tool
    private static class EnergyToolColorHandler implements ItemColor {
        @Override
        public int getColor(ItemStack stack, int tintIndex) {
            if (tintIndex == 0) { // Only apply to the first tint index (the energy bar)
                return stack.getCapability(net.minecraftforge.common.capabilities.ForgeCapabilities.ENERGY)
                        .map(energy -> {
                            float ratio = (float) energy.getEnergyStored() / energy.getMaxEnergyStored();
                            return (int) (0xFF * (1 - ratio)) << 16 | (int) (0xFF * ratio) << 8;
                        })
                        .orElse(0x00FF00); // Default green color
            }
            return 0xFFFFFF; // White for other tint indices
        }
    }

    // API Method: Register an energy item for color handling
    public static void registerEnergyItem(RegistryObject<Item> item) {
        ENERGY_ITEMS.add(item);
    }
}