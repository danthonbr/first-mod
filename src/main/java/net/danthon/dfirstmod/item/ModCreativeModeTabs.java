package net.danthon.dfirstmod.item;

import net.danthon.dfirstmod.DFirstMod;
import net.danthon.dfirstmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, DFirstMod.MODID);

    public static final Supplier<CreativeModeTab> D_FIRST_MOD_TAB_1 = CREATIVE_MODE_TAB.register("d_first_mod_tab_1",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.COBALT_INGOT.get()))
                    .title(Component.translatable("creativetab.dfirstmod.tab1"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.COBALT_INGOT);
                        output.accept(ModItems.RAW_COBALT);

                    })
                    .build());

    public static final Supplier<CreativeModeTab> D_FIRST_MOD_TAB_2 = CREATIVE_MODE_TAB.register("d_first_mod_tab_2",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.COBALT_BLOCK.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(DFirstMod.MODID, "d_first_mod_tab_1"))
                    .title(Component.translatable("creativetab.dfirstmod.tab2"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModBlocks.COBALT_BLOCK);
                        output.accept(ModBlocks.COBALT_ORE);
                        output.accept(ModBlocks.RAW_COBALT_BLOCK);
                        output.accept(ModBlocks.DEEPSLATE_COBALT_ORE);

                    })
                    .build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
