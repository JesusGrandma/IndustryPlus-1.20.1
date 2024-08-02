package net.ben.industryplus.datagen;

import net.ben.industryplus.IndustryPlus;
import net.ben.industryplus.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, IndustryPlus.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.LIMESTONE_BLOCK.get());


        this.tag(BlockTags.NEEDS_IRON_TOOL);

        this.tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.LIMESTONE_BLOCK.get());


        this.tag(BlockTags.NEEDS_DIAMOND_TOOL);

        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL);


        //this.tag(BlockTags.FENCES).add(ModBlocks.AZURITE_FENCE.get());
        //this.tag(BlockTags.FENCE_GATES).add(ModBlocks.AZURITE_FENCE_GATE.get());
        //this.tag(BlockTags.WALLS).add(ModBlocks.AZURITE_WALL.get());

    }
}