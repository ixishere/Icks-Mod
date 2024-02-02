package me.ix.icksmod.blocks;

import me.ix.icksmod.init.ModBlocks;
import me.ix.icksmod.init.ModItems;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

public class DragonCoreFluid extends BlockFluidClassic {

	public DragonCoreFluid(String name, CreativeTabs tab, Fluid fluid, Material material) {
		super(fluid, material);
		setUnlocalizedName(name);
		setRegistryName(name);
		
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}

	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		return EnumBlockRenderType.MODEL;
	}
	
}
