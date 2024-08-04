package net.ben.industryplus.datagen;

import net.ben.industryplus.IndustryPlus;
import net.ben.industryplus.block.ModBlocks;
import net.ben.industryplus.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, IndustryPlus.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.COAL_DUST.get());
        basicItem(ModItems.COKE.get());
        basicItem(ModItems.LIMESTONE_DUST.get());
        basicItem(ModItems.STEEL_DUST.get());
        basicItem(ModItems.STEEL_INGOT.get());

    }


    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(IndustryPlus.MOD_ID,"item/" + item.getId()));
    }
}