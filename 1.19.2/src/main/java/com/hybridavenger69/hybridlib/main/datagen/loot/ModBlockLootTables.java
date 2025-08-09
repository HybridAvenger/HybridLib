package com.hybridavenger69.hybridlib.main.datagen.loot;

import com.hybridavenger69.hybridlib.main.BlockRegistry;
import com.hybridavenger69.hybridlib.main.ItemRegistry;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockLootTables extends BlockLoot {

    @Override
    protected void addTables(){


        this.add(BlockRegistry.DEEPSLATE_TECH_ORE.get(),
                (block) -> createOreDrop(BlockRegistry.DEEPSLATE_TECH_ORE.get(), ItemRegistry.RAW_TECH.get()));

        this.add(BlockRegistry.TECH_ORE.get(),
                (block) -> createOreDrop(BlockRegistry.TECH_ORE.get(), ItemRegistry.RAW_TECH.get()));

        this.add(BlockRegistry.AETHERIUM_ORE.get(),
                (block) -> createOreDrop(BlockRegistry.AETHERIUM_ORE.get(), ItemRegistry.AETHERIUM_GEM.get()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return BlockRegistry.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }


}
