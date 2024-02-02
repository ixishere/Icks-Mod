package me.ix.icksmod.blocks;

import java.util.Random;

import me.ix.icksmod.utils.IHasModel;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class IckOre extends BlockBase {

	public IckOre(String name, CreativeTabs tab, Material material) {
		super(name, tab, material);
		
		setSoundType(SoundType.METAL);
		setHardness(5.0F);
		setResistance(15.0F);
		setHarvestLevel("pickaxe", 2);
	}
	
	/*
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return //itemhere;
		
	}
	
	@Override
	public int quantityDropped(Random rand){
		int max = 5;
		int min = 1;
		
		return rand.nextInt(max) + min;
	}
	*/
	
}
