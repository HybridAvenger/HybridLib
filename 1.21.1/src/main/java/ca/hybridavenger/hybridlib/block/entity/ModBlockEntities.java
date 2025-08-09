package ca.hybridavenger.hybridlib.block.entity;

import ca.hybridavenger.hybridlib.HybridLib;
import ca.hybridavenger.hybridlib.block.BlockRegistry;
import ca.hybridavenger.hybridlib.block.entity.custom.FusionChamberBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, HybridLib.MOD_ID);



    public static final RegistryObject<BlockEntityType<FusionChamberBlockEntity>> FUSION_CHAMBER_BE =
            BLOCK_ENTITIES.register("growth_chamber_be", () -> BlockEntityType.Builder.of(
                    FusionChamberBlockEntity::new, BlockRegistry.FUSION_CHAMBER.get()).build(null));



    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
