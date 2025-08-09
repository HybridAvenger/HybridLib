package ca.hybridavenger.hybridlib.datagen;

import ca.hybridavenger.hybridlib.HybridLib;
import ca.hybridavenger.hybridlib.item.ItemRegistry;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, HybridLib.MOD_ID, existingFileHelper);
    }


    @Override
    protected void registerModels() {
        basicItem(ItemRegistry.EUCLASE_GEM.get());
        basicItem(ItemRegistry.RAW_TECH.get());
        basicItem(ItemRegistry.AETHERIUM_GEM_FRAGMENT.get());
        basicItem(ItemRegistry.DOUBLE_NETHERITE_INGOT.get());
        basicItem(ItemRegistry.AETHERIUM_GEM.get());
        basicItem(ItemRegistry.NETHER_INGOT.get());
        basicItem(ItemRegistry.TECH_INGOT.get());
    }
}
