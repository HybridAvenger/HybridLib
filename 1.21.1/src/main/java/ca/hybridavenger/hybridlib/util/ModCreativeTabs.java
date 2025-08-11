package ca.hybridavenger.hybridlib.util;

import ca.hybridavenger.hybridlib.HybridLib;
import ca.hybridavenger.hybridlib.block.BlockRegistry;
import ca.hybridavenger.hybridlib.item.ItemRegistry;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, HybridLib.MOD_ID);

    public static final Supplier<CreativeModeTab> HYBRID_TAB = CREATIVE_MODE_TAB.register("hybrid_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ItemRegistry.NETHER_INGOT.get()))
                    .title(Component.translatable("creativetab.hybridlib.hybridtab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ItemRegistry.RAW_TECH.get());
                        output.accept(ItemRegistry.NETHER_INGOT.get());
                        output.accept(ItemRegistry.EUCLASE_GEM.get());
                        output.accept(ItemRegistry.TECH_INGOT.get());
                        output.accept(ItemRegistry.DOUBLE_NETHERITE_INGOT.get());
                        output.accept(ItemRegistry.AETHERIUM_GEM.get());
                        output.accept(ItemRegistry.AETHERIUM_GEM_FRAGMENT.get());

                        output.accept(BlockRegistry.AETHERIUM_ORE.get());
                        output.accept(BlockRegistry.TECH_ORE.get());
                        output.accept(BlockRegistry.TECH_BLOCK.get());
                        output.accept(BlockRegistry.EUCLASE_BLOCK.get());
                        output.accept(BlockRegistry.EUCLASE_ORE.get());
                        output.accept(BlockRegistry.DEEPSLATE_EUCLASE_ORE.get());
                        output.accept(BlockRegistry.DEEPSLATE_TECH_ORE.get());
                        output.accept(BlockRegistry.COMPRESSED_OBSIDIAN.get());
                        output.accept(BlockRegistry.FUSION_CHAMBER.get());



                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }

}