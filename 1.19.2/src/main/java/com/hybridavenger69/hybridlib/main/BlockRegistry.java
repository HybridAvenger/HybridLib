package com.hybridavenger69.hybridlib.main;



import com.hybridavenger69.hybridlib.HybridIDS;
import com.hybridavenger69.hybridlib.HybridLib;
import net.minecraft.world.item.*;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;



import java.util.function.Supplier;
public class BlockRegistry {

    public static final DeferredRegister<Block> BLOCKS
            = DeferredRegister.create(ForgeRegistries.BLOCKS, HybridIDS.MOD_ID);

    //Block

    public static final RegistryObject<Block> NETHER_STAR_BLOCK = registerBlock("nether_star_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops()), MtGroup.MT_GROUP);

    //Ores
    public static final RegistryObject<Block> DEEPSLATE_TECH_ORE = registerBlock("deepslate_tech_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(4.5f).requiresCorrectToolForDrops()), MtGroup.MT_GROUP);

    public static final RegistryObject<Block> TECH_ORE = registerBlock("tech_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(4.5f).requiresCorrectToolForDrops()), MtGroup.MT_GROUP);



    public static final RegistryObject<Block> COMPRESSED_OBSIDIAN = registerBlock("compressed_obsidian",
            () -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL)
                    .strength(18.5f, 1200f).requiresCorrectToolForDrops()), MtGroup.MT_GROUP);

    public static final RegistryObject<Block> AETHERIUM_ORE = registerBlock("aetherium_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(5.5f).requiresCorrectToolForDrops()), MtGroup.MT_GROUP);



    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab) {
        return ItemRegistry.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}