package com.hybridavenger69.hybridlib.main;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.Tags;

public class ModTiers {

    public static class MTTMTiers {

        public static final Tier TECH = new ForgeTier(
                2,
                700,
                4.5f,
                3,
                350,
                Tags.Blocks.NEEDS_GOLD_TOOL,
                () -> Ingredient.of(ItemRegistry.TECH_INGOT.get()));

        public static final Tier EUCLASE = new ForgeTier(
                3,
                900,
                8f,
                5,
                700,
                Tags.Blocks.NEEDS_GOLD_TOOL,
                () -> Ingredient.of(ItemRegistry.EUCLASE_GEM.get()));

        public static final Tier ICARUS = new ForgeTier(
                4,
                1800,
                10f,
                8,
                1400,

                Tags.Blocks.NEEDS_GOLD_TOOL,
                () -> Ingredient.of(ItemRegistry.NETHER_INGOT.get()));

        public static final Tier ICARUS2 = new ForgeTier(
                4,
                25000,
                12f,
                10,
                2800,
                Tags.Blocks.NEEDS_GOLD_TOOL,
                () -> Ingredient.of(ItemRegistry.DOUBLE_NETHERITE_INGOT.get()));
    }

    public static class WeaponTiers {

        public static final Tier TECH = new ForgeTier(
                2,
                700,
                1.0f,
                5,
                350,
                Tags.Blocks.NEEDS_GOLD_TOOL,
                () -> Ingredient.of(ItemRegistry.TECH_INGOT.get()));

        public static final Tier EUCLASE = new ForgeTier(
                3,
                900,
                1.5f,
                8,
                700,
                Tags.Blocks.NEEDS_GOLD_TOOL,
                () -> Ingredient.of(ItemRegistry.EUCLASE_GEM.get()));

        public static final Tier ICARUS = new ForgeTier(
                4,
                1800,
                2.0f,
                8,
                1400,
                Tags.Blocks.NEEDS_GOLD_TOOL,
                () -> Ingredient.of(ItemRegistry.NETHER_INGOT.get()));


        public static final Tier AETHERIUM = new ForgeTier(
                5,
                7500,
                11.0f,
                6,
                7500,
                Tags.Blocks.NEEDS_GOLD_TOOL,
                () -> Ingredient.of(ItemRegistry.AETHERIUM_GEM.get()));

        public static final Tier ICARUS2 = new ForgeTier(
                4,
                25000,
                2.5f,
                10,
                2800,
                Tags.Blocks.NEEDS_GOLD_TOOL,
                () -> Ingredient.of(ItemRegistry.DOUBLE_NETHERITE_INGOT.get()));
    }

    public static class VanillaTiers {

        public static final Tier WOODEN = new ForgeTier(
                0,
                300,
                2.0f,
                3,
                15,
                Tags.Blocks.NEEDS_GOLD_TOOL,
                () -> Ingredient.of(ItemTags.PLANKS));

        public static final Tier STONE = new ForgeTier(
                1,
                500,
                3.0f,
                4,
                20,
                Tags.Blocks.NEEDS_GOLD_TOOL,
                () -> Ingredient.of(ItemTags.STONE_TOOL_MATERIALS));

        public static final Tier COPPER = new ForgeTier(
                2,
                750,
                4.0f,
                5,
                1400,

                Tags.Blocks.NEEDS_GOLD_TOOL,
                () -> Ingredient.of(ItemRegistry.NETHER_INGOT.get()));

        public static final Tier IRON = new ForgeTier(
                2,
                900,
                4.0f,
                5,
                25,
                Tags.Blocks.NEEDS_GOLD_TOOL,
                () -> Ingredient.of(Items.IRON_INGOT));

        public static final Tier GOLD = new ForgeTier(
                2,
                750,
                20.0f,
                5,
                25,
                Tags.Blocks.NEEDS_GOLD_TOOL,
                () -> Ingredient.of(Items.GOLD_INGOT));


        public static final Tier DIAMOND = new ForgeTier(
                3,
                3000,
                6.0f,
                6,
                2800,
                Tags.Blocks.NEEDS_GOLD_TOOL,
                () -> Ingredient.of(Items.DIAMOND));


        public static final Tier EMERALD = new ForgeTier(
                3,
                4000,
                8.0f,
                5,
                2800,
                Tags.Blocks.NEEDS_GOLD_TOOL,
                () -> Ingredient.of(Items.EMERALD));

        public static final Tier OBSIDIAN = new ForgeTier(
                3,
                4500,
                7,
                5,
                5000,
                Tags.Blocks.NEEDS_GOLD_TOOL,
                () -> Ingredient.of(Blocks.OBSIDIAN)
        );


        public static final Tier NETHERITE = new ForgeTier(
                4,
                5000,
                9.0f,
                5,
                6000,
                Tags.Blocks.NEEDS_GOLD_TOOL,
                () -> Ingredient.of(Items.NETHERITE_INGOT));





    }

    public static class ArmorTiers {
        public static final ArmorMaterial TECH = new ModArmorMaterial(
                "tech",
                500,
                new int[] { 20, 40, 50, 10 },
                300,
                SoundEvents.ARMOR_EQUIP_DIAMOND,
                0.0f,
                0.0f,
                () -> Ingredient.of(ItemRegistry.TECH_INGOT.get()));

        public static final ArmorMaterial EUCLASE = new ModArmorMaterial(
                "euclase",
                1000,
                new int[] { 30, 50, 60, 20 },
                600,
                SoundEvents.ARMOR_EQUIP_DIAMOND,
                0.0f,
                0.0f,
                () -> Ingredient.of(ItemRegistry.EUCLASE_GEM.get()));

        public static final ArmorMaterial ICARUS = new ModArmorMaterial(
                "icarus",
                1500,
                new int[] { 40, 60, 70, 30 },
                1200,
                SoundEvents.ARMOR_EQUIP_DIAMOND,
                0.0f,
                0.0f,
                () -> Ingredient.of(ItemRegistry.NETHER_INGOT.get()));
    }





}
