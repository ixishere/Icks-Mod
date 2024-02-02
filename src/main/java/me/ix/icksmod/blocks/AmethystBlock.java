package me.ix.icksmod.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class AmethystBlock extends BlockBase {

	public AmethystBlock(String name, CreativeTabs tab, Material material) {
		super(name, tab, material);
		
		setSoundType(SoundType.METAL);
		setHardness(5.0F);
		setResistance(30.0F);
		setHarvestLevel("pickaxe", 2);
		setLightLevel(0.0F);
		//setLightOpacity(0);
		//setBlockUnbreakable();
	}

}
