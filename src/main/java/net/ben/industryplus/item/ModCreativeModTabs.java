package net.ben.industryplus.item;

import net.ben.industryplus.IndustryPlus;
import net.ben.industryplus.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, IndustryPlus.MOD_ID);


    public static final RegistryObject<CreativeModeTab> INDUSTRY_TAB = CREATIVE_MODE_TABS.register("industry_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.COAL_DUST.get()))
                    .title(Component.translatable("creative.tab.industry_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.COAL_DUST.get());
                        output.accept(ModItems.LIMESTONE_DUST.get());
                        output.accept(ModItems.STEEL_DUST.get());
                        output.accept(ModItems.STEEL_INGOT.get());
                        output.accept(ModItems.COKE.get());
                        output.accept(ModBlocks.LIMESTONE_BLOCK.get());
                        output.accept(ModBlocks.CRUSHER_BLOCK.get());


                    })
                    .build());



    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
