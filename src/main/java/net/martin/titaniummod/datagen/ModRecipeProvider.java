package net.martin.titaniummod.datagen;

import net.martin.titaniummod.TitaniumMod;
import net.martin.titaniummod.block.ModBlocks;
import net.martin.titaniummod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> TITANIUM_SMELTABLES = List.of(
            ModItems.RAW_TITANIUM.get()
    );

    public ModRecipeProvider(PackOutput pOutput) { super(pOutput); }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        // Smelting/Blasting recipes
        oreSmelting(pWriter, TITANIUM_SMELTABLES, RecipeCategory.MISC, ModItems.TITANIUM_INGOT.get(), 0.25f, 200, "titanium");
        oreBlasting(pWriter, TITANIUM_SMELTABLES, RecipeCategory.MISC, ModItems.TITANIUM_INGOT.get(), 0.25f, 100, "titanium");

        // Shaped recipes
        // Block recipes
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.TITANIUM_BLOCK.get())
                .pattern("TTT")
                .pattern("TTT")
                .pattern("TTT")
                .define('T', ModItems.TITANIUM_INGOT.get())
                .unlockedBy(getHasName(ModItems.TITANIUM_INGOT.get()), has(ModItems.TITANIUM_INGOT.get()))
                .save(pWriter);

        // Tool recipes
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.TITANIUM_SWORD.get())
                .pattern(" T ")
                .pattern(" T ")
                .pattern(" S ")
                .define('T', ModItems.TITANIUM_INGOT.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModItems.TITANIUM_INGOT.get()), has(ModItems.TITANIUM_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.TITANIUM_PICKAXE.get())
                .pattern("TTT")
                .pattern(" S ")
                .pattern(" S ")
                .define('T', ModItems.TITANIUM_INGOT.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModItems.TITANIUM_INGOT.get()), has(ModItems.TITANIUM_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.TITANIUM_AXE.get())
                .pattern("TT ")
                .pattern("TS ")
                .pattern(" S ")
                .define('T', ModItems.TITANIUM_INGOT.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModItems.TITANIUM_INGOT.get()), has(ModItems.TITANIUM_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.TITANIUM_SHOVEL.get())
                .pattern(" T ")
                .pattern(" S ")
                .pattern(" S ")
                .define('T', ModItems.TITANIUM_INGOT.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModItems.TITANIUM_INGOT.get()), has(ModItems.TITANIUM_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.TITANIUM_HOE.get())
                .pattern("TT ")
                .pattern(" S ")
                .pattern(" S ")
                .define('T', ModItems.TITANIUM_INGOT.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModItems.TITANIUM_INGOT.get()), has(ModItems.TITANIUM_INGOT.get()))
                .save(pWriter);

        // Armor recipes
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.TITANIUM_HELMET.get())
                .pattern("TTT")
                .pattern("T T")
                .pattern("   ")
                .define('T', ModItems.TITANIUM_INGOT.get())
                .unlockedBy(getHasName(ModItems.TITANIUM_INGOT.get()), has(ModItems.TITANIUM_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.TITANIUM_CHESTPLATE.get())
                .pattern("T T")
                .pattern("TTT")
                .pattern("TTT")
                .define('T', ModItems.TITANIUM_INGOT.get())
                .unlockedBy(getHasName(ModItems.TITANIUM_INGOT.get()), has(ModItems.TITANIUM_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.TITANIUM_LEGGINGS.get())
                .pattern("TTT")
                .pattern("T T")
                .pattern("T T")
                .define('T', ModItems.TITANIUM_INGOT.get())
                .unlockedBy(getHasName(ModItems.TITANIUM_INGOT.get()), has(ModItems.TITANIUM_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.TITANIUM_BOOTS.get())
                .pattern("   ")
                .pattern("T T")
                .pattern("T T")
                .define('T', ModItems.TITANIUM_INGOT.get())
                .unlockedBy(getHasName(ModItems.TITANIUM_INGOT.get()), has(ModItems.TITANIUM_INGOT.get()))
                .save(pWriter);

        // Shapeless recipes
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.TITANIUM_INGOT.get(), 9)
                .requires(ModBlocks.TITANIUM_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.TITANIUM_BLOCK.get()), has(ModBlocks.TITANIUM_BLOCK.get()))
                .save(pWriter);
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        Iterator var9 = pIngredients.iterator();

        while(var9.hasNext()) {
            ItemLike itemlike = (ItemLike)var9.next();
            SimpleCookingRecipeBuilder.generic(Ingredient.of(new ItemLike[]{itemlike}), pCategory, pResult,
                            pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer, TitaniumMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }
}
