package net.ben.industryplus;

import com.mojang.logging.LogUtils;
import net.ben.industryplus.block.ModBlocks;
import net.ben.industryplus.block.entity.ModBlockEntities;
import net.ben.industryplus.item.ModCreativeModTabs;
import net.ben.industryplus.item.ModItems;
import net.ben.industryplus.screen.CrusherBlockMenu;
import net.ben.industryplus.screen.CrusherBlockScreen;
import net.ben.industryplus.screen.ModMenuTypes;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(IndustryPlus.MOD_ID)
public class IndustryPlus
{
    public static final String MOD_ID = "industryplus";
    private static final Logger LOGGER = LogUtils.getLogger();

    public IndustryPlus()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModCreativeModTabs.register(modEventBus);
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);

        ModBlockEntities.register(modEventBus);
        ModMenuTypes.register(modEventBus);

    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.COAL_DUST);
            event.accept(ModItems.COKE);
            event.accept(ModItems.LIMESTONE_DUST);
            event.accept(ModItems.STEEL_DUST);
            event.accept(ModItems.STEEL_INGOT);

        }

    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

            MenuScreens.register(ModMenuTypes.CRUSHER_BLOCK_MENU.get(), CrusherBlockScreen::new);

        }
    }
}
