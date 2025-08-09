package ca.hybridavenger.hybridlib.datagen;

import ca.hybridavenger.hybridlib.HybridLib;
import ca.hybridavenger.hybridlib.block.BlockRegistry;
import ca.hybridavenger.hybridlib.item.ItemRegistry;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

public class FrenchLanguageProvider extends LanguageProvider {

    public FrenchLanguageProvider(PackOutput output, String locale) {
        super(output, HybridLib.MOD_ID, locale);
    }

    @Override
    protected void addTranslations() {
        //Items
        add(ItemRegistry.AETHERIUM_GEM.get(), "Gemme d'étherium");
        add(ItemRegistry.RAW_TECH.get(), "Technologie brute");
        add(ItemRegistry.TECH_INGOT.get(), "Lingot technologique");
        add(ItemRegistry.EUCLASE_GEM.get(), "Gemme d'Euclase");
        add(ItemRegistry.AETHERIUM_GEM_FRAGMENT.get(), "Fragment de gemme d'étherium");
        add(ItemRegistry.DOUBLE_NETHERITE_INGOT.get(), "Lingot de Netherite double");
        add(ItemRegistry.NETHER_INGOT.get(), "Lingot du Néant");

        //Blocks
        add(BlockRegistry.AETHERIUM_ORE.get(), "Minerai d'étherium");
        add(BlockRegistry.TECH_BLOCK.get(), "Bloc de technologie");
        add(BlockRegistry.COMPRESSED_OBSIDIAN.get(), "Obsidienne compressée");
        add(BlockRegistry.DEEPSLATE_TECH_ORE.get(), "Minerai technologique Deepslate");
        add(BlockRegistry.DEEPSLATE_EUCLASE_ORE.get(), "Minerai d'euclase d'ardoise profonde");
        add(BlockRegistry.TECH_ORE.get(), "Minerai technologique");
        add(BlockRegistry.EUCLASE_ORE.get(), "Minerai d'euclase");
        add(BlockRegistry.EUCLASE_BLOCK.get(), "Bloc d'Euclase");
        //add(BlockRegistry.FUSION_CHAMBER.get(), "Chambre de fusion");

        add("creativetab.hybridlib.hybridtab", "Mod de bibliothèque hybride");

    }
}