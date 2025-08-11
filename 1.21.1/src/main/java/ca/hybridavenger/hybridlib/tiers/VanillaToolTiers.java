package ca.hybridavenger.hybridlib.tiers;

import ca.hybridavenger.hybridlib.block.BlockRegistry;

import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

import net.minecraftforge.common.ForgeTier;

public class VanillaToolTiers {

    public static final Tier WOOD = new ForgeTier(750, 2.0f, 1.0F, 15,
            BlockTags.NEEDS_STONE_TOOL, () -> Ingredient.of(ItemTags.LOGS),
            BlockTags.INCORRECT_FOR_WOODEN_TOOL);

    public static Tier STONE = new ForgeTier(1250, 4.0f, 1.0f, 15,
            BlockTags.NEEDS_STONE_TOOL, () -> Ingredient.of(ItemTags.STONE_TOOL_MATERIALS),
            BlockTags.INCORRECT_FOR_STONE_TOOL);

    public static Tier COPPER = new ForgeTier(1500, 4.5f, 1.5f, 15,
            BlockTags.NEEDS_STONE_TOOL, () -> Ingredient.of(Items.COPPER_INGOT),
            BlockTags.INCORRECT_FOR_IRON_TOOL);

    public static Tier IRON = new ForgeTier(2500, 6.0f, 2.0f, 14,
            BlockTags.NEEDS_IRON_TOOL, () -> Ingredient.of(Items.IRON_INGOT),
            BlockTags.INCORRECT_FOR_IRON_TOOL);

    public static Tier GOLD = new ForgeTier(1000, 15f, 0.0f, 22,
            BlockTags.NEEDS_STONE_TOOL, () -> Ingredient.of(Items.GOLD_INGOT),
            BlockTags.INCORRECT_FOR_GOLD_TOOL);

    public static Tier DIAMOND = new ForgeTier(5000, 8.0f, 3.0f, 10,
            BlockTags.NEEDS_DIAMOND_TOOL, () -> Ingredient.of(Items.DIAMOND),
            BlockTags.INCORRECT_FOR_DIAMOND_TOOL);

    public static Tier EMERALD = new ForgeTier(6000, 6.0f, 5.0f, 13,
            BlockTags.NEEDS_DIAMOND_TOOL, () -> Ingredient.of(Items.EMERALD),
            BlockTags.INCORRECT_FOR_DIAMOND_TOOL);

    public static Tier OBSIDIAN = new ForgeTier(8000, 7.0f, 5.0f, 14,
            BlockTags.NEEDS_DIAMOND_TOOL, () -> Ingredient.of(BlockRegistry.COMPRESSED_OBSIDIAN.get()),
            BlockTags.INCORRECT_FOR_DIAMOND_TOOL);

    public static Tier NETHERITE = new ForgeTier(10000, 9.0f, 5.0f, 17,
            BlockTags.NEEDS_STONE_TOOL, () -> Ingredient.of(Items.COPPER_INGOT),
            BlockTags.INCORRECT_FOR_IRON_TOOL);





}
