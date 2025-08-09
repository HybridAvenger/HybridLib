package ca.hybridavenger.hybridlib.screen;


import ca.hybridavenger.hybridlib.HybridLib;
import ca.hybridavenger.hybridlib.screen.custom.FusionChamberMenu;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(Registries.MENU, HybridLib.MOD_ID);



    public static final RegistryObject<MenuType<FusionChamberMenu>> FUSION_CHAMBER_MENU =
            MENUS.register("fusion_chamber_menu", () -> IForgeMenuType.create(FusionChamberMenu::new));


    public static void register(IEventBus eventBus) {
        MENUS.register(eventBus);
    }
}
