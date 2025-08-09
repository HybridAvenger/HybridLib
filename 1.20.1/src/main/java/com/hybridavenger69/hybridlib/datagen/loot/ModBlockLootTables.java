package com.hybridavenger69.hybridlib.datagen.loot;


import com.hybridavenger69.hybridlib.registry.BlockRegistry;
import com.hybridavenger69.hybridlib.registry.ItemRegistry;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;


import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {

    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(BlockRegistry.NETHER_STAR_BLOCK.get());



        this.add(BlockRegistry.TECH_ORE.get(),
                block -> createOreDrop(BlockRegistry.TECH_ORE.get(), ItemRegistry.RAW_TECH.get()));
        this.add(BlockRegistry.DEEPSLATE_TECH_ORE.get(),
                block -> createOreDrop(BlockRegistry.DEEPSLATE_TECH_ORE.get(), ItemRegistry.RAW_TECH.get()));


    }


    @Override
    protected Iterable<Block> getKnownBlocks() {
        return BlockRegistry.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
