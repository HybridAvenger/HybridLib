package ca.hybridavenger.hybridlib.tiers;

import ca.hybridavenger.hybridlib.item.ItemRegistry;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModdedToolTiers {

    public static final Tier TECH = new ForgeTier(750, 2.0f, 1.0F, 15,
            BlockTags.NEEDS_IRON_TOOL, () -> Ingredient.of(ItemRegistry.TECH_INGOT.get()),
            BlockTags.INCORRECT_FOR_IRON_TOOL);

}
