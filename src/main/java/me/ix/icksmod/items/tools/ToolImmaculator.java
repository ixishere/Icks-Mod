package me.ix.icksmod.items.tools;

import java.util.Set;

import me.ix.icksmod.Main;
import me.ix.icksmod.init.ModItems;
import me.ix.icksmod.utils.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemTool;

public class ToolImmaculator extends Item implements IHasModel {

	public ToolImmaculator(String name, CreativeTabs tab) {
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(tab);
		this.setMaxStackSize(1);
		
		ModItems.ITEMS.add(this);
	}
	
	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}

}
