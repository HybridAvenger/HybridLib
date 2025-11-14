package ca.hybridavenger.hybridlib.datagen;

import ca.hybridavenger.hybridlib.HybridLib;
import ca.hybridavenger.hybridlib.block.BlockRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, HybridLib.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(BlockRegistry.EUCLASE_BLOCK.get())
                .add(BlockRegistry.TECH_BLOCK.get())
                .add(BlockRegistry.AETHERIUM_ORE.get())
                .add(BlockRegistry.COMPRESSED_OBSIDIAN.get())
                .add(BlockRegistry.DEEPSLATE_EUCLASE_ORE.get())
                .add(BlockRegistry.EUCLASE_ORE.get())
                .add(BlockRegistry.FUSION_CHAMBER.get())
                //.add(BlockRegistry.FUSION_CHAMBER_POWER.get())
                .add(BlockRegistry.TECH_ORE.get());


        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(BlockRegistry.TECH_ORE.get())
                .add(BlockRegistry.DEEPSLATE_TECH_ORE.get())
                .add(BlockRegistry.EUCLASE_ORE.get())
                .add(BlockRegistry.DEEPSLATE_EUCLASE_ORE.get());


        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(BlockRegistry.COMPRESSED_OBSIDIAN.get())
                .add(BlockRegistry.AETHERIUM_ORE.get());
    }
}