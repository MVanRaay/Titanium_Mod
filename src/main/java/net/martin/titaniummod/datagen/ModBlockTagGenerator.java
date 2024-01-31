package net.martin.titaniummod.datagen;

import net.martin.titaniummod.TitaniumMod;
import net.martin.titaniummod.block.ModBlocks;
import net.martin.titaniummod.util.ModTags;
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
        super(output, lookupProvider, TitaniumMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(BlockTags.MINEABLE_WITH_AXE)
        ;

        this.tag(BlockTags.MINEABLE_WITH_SHOVEL)
        ;

        this.tag(BlockTags.MINEABLE_WITH_HOE)
        ;

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(
                        ModBlocks.TITANIUM_ORE.get(),
                        ModBlocks.TITANIUM_BLOCK.get()
                )
        ;

        this.tag(BlockTags.NEEDS_STONE_TOOL)
        ;

        this.tag(BlockTags.NEEDS_IRON_TOOL)
        ;

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(
                        ModBlocks.TITANIUM_ORE.get()
                );

        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL)
        ;

        this.tag(ModTags.Blocks.NEEDS_TITANIUM_TOOL)
                .add(
                        ModBlocks.TITANIUM_BLOCK.get()
                );
    }
}
