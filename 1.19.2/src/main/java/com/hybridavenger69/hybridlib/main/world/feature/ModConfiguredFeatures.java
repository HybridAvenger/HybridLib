package com.hybridavenger69.hybridlib.main.world.feature;

import com.google.common.base.Suppliers;
import com.hybridavenger69.hybridlib.HybridIDS;
import com.hybridavenger69.hybridlib.HybridLib;
import com.hybridavenger69.hybridlib.main.BlockRegistry;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.function.Supplier;

public class ModConfiguredFeatures {
    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES =
            DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, HybridIDS.MOD_ID);

    //ORE
    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_TECH_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, BlockRegistry.TECH_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, BlockRegistry.DEEPSLATE_TECH_ORE.get().defaultBlockState())));



    public static final Supplier<List<OreConfiguration.TargetBlockState>> END_AETHERIUM_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(new BlockMatchTest(Blocks.END_STONE), BlockRegistry.AETHERIUM_ORE.get().defaultBlockState())));



    //END ORe
    public static final RegistryObject<ConfiguredFeature<?, ?>> END_AETHERIUM_ORE = CONFIGURED_FEATURES.register("end_aetherium_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(END_AETHERIUM_ORES.get(), 9)));


    public static final RegistryObject<ConfiguredFeature<?, ?>> TECH_ORE = CONFIGURED_FEATURES.register("tech_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(OVERWORLD_TECH_ORES.get(), 7)));




    public static void register(IEventBus eventBus) {
        CONFIGURED_FEATURES.register(eventBus);
    }

}