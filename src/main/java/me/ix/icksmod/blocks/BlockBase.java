package me.ix.icksmod.blocks;

import me.ix.icksmod.Main;
import me.ix.icksmod.init.ModBlocks;
import me.ix.icksmod.init.ModItems;
import me.ix.icksmod.utils.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockBase extends Block implements IHasModel {

	public BlockBase(String name, CreativeTabs tab, Material material) {
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(tab);
		
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}

	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
}
