package ca.hybridavenger.hybridlib.recipe;


import ca.hybridavenger.hybridlib.HybridLib;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, HybridLib.MOD_ID);
    public static final DeferredRegister<RecipeType<?>> TYPES =
            DeferredRegister.create(ForgeRegistries.RECIPE_TYPES, HybridLib.MOD_ID);

    public static final RegistryObject<RecipeSerializer<FusionChamberRecipe>> FUSION_CHAMBER_SERIALIZER =
            SERIALIZERS.register("fusion_chamber", FusionChamberRecipe.Serializer::new);
    public static final RegistryObject<RecipeType<FusionChamberRecipe>> FUSION_CHAMBER_TYPE =
            TYPES.register("fusion_chamber", () -> new RecipeType<FusionChamberRecipe>() {
                @Override
                public String toString() {
                    return "fusion_chamber";
                }
            });


    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
        TYPES.register(eventBus);
    }
}
