package ca.hybridavenger.hybridlib.datagen;

import ca.hybridavenger.hybridlib.HybridLib;


import ca.hybridavenger.hybridlib.block.BlockRegistry;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, HybridLib.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(BlockRegistry.TECH_BLOCK);
        blockWithItem(BlockRegistry.EUCLASE_ORE);
        blockWithItem(BlockRegistry.AETHERIUM_ORE);
        blockWithItem(BlockRegistry.TECH_ORE);
        blockWithItem(BlockRegistry.DEEPSLATE_EUCLASE_ORE);
        blockWithItem(BlockRegistry.DEEPSLATE_TECH_ORE);
        blockWithItem(BlockRegistry.COMPRESSED_OBSIDIAN);
        blockWithItem(BlockRegistry.FUSION_CHAMBER);
        blockWithItem(BlockRegistry.FUSION_CHAMBER_POWER);
        blockWithItem(BlockRegistry.EUCLASE_BLOCK);
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}