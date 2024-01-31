package net.martin.titaniummod.item;

import net.martin.titaniummod.TitaniumMod;
import net.martin.titaniummod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TitaniumMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> TITANIUM_TAB = CREATIVE_MODE_TABS.register("titanium_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.TITANIUM_INGOT.get()))
                    .title(Component.translatable("creativetab.titanium_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        // Items
                        output.accept(ModItems.TITANIUM_INGOT.get());
                        output.accept(ModItems.RAW_TITANIUM.get());

                        // Blocks
                        output.accept(ModBlocks.TITANIUM_ORE.get());
                        output.accept(ModBlocks.TITANIUM_BLOCK.get());

                        // Handheld items
                        output.accept(ModItems.TITANIUM_SWORD.get());
                        output.accept(ModItems.TITANIUM_PICKAXE.get());
                        output.accept(ModItems.TITANIUM_AXE.get());
                        output.accept(ModItems.TITANIUM_SHOVEL.get());
                        output.accept(ModItems.TITANIUM_HOE.get());

                        // Armor items
                        output.accept(ModItems.TITANIUM_HELMET.get());
                        output.accept(ModItems.TITANIUM_CHESTPLATE.get());
                        output.accept(ModItems.TITANIUM_LEGGINGS.get());
                        output.accept(ModItems.TITANIUM_BOOTS.get());
                    })
                    .build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
