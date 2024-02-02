package me.ix.icksmod.tabs;

import me.ix.icksmod.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class IcksTab extends CreativeTabs {

	public IcksTab(String label) {
		super("ickstab");
		//this.setBackgroundImageName("")
	}
	
	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(ModItems.AMETHYST_INGOT);
	}
}
