package net.ben.industryplus.datagen;

import net.ben.industryplus.IndustryPlus;
import net.ben.industryplus.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, IndustryPlus.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        //basic block
        blockWithItem(ModBlocks.LIMESTONE_BLOCK);

        //advanced crusher block
        simpleBlockWithItem(ModBlocks.CRUSHER_BLOCK.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/crusher_block")));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));

    }
}
