package net.martin.titaniummod.item;

import net.martin.titaniummod.TitaniumMod;
import net.martin.titaniummod.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {
    public static final Tier TITANIUM = TierSortingRegistry.registerTier(
            new ForgeTier(5, 1500, 5f, 4f, 25,
                    ModTags.Blocks.NEEDS_TITANIUM_TOOL, () -> Ingredient.of(ModItems.TITANIUM_INGOT.get())),
            new ResourceLocation(TitaniumMod.MOD_ID, "titanium"), List.of(Tiers.NETHERITE), List.of());
}
