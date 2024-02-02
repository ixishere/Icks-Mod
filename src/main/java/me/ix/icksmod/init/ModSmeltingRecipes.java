package me.ix.icksmod.init;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModSmeltingRecipes {
	
	public static void init() {
		GameRegistry.addSmelting(ModBlocks.AMETHYST_ORE, new ItemStack(ModItems.AMETHYST_INGOT, 1), 1.5F);
	}
} 