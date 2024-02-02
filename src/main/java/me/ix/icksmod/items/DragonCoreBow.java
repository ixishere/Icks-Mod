package me.ix.icksmod.items;

import me.ix.icksmod.Main;
import me.ix.icksmod.init.ModItems;
import me.ix.icksmod.utils.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;

public class DragonCoreBow extends ItemBow implements IHasModel {

	public DragonCoreBow(String name, CreativeTabs tab) {		
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(tab);
		setMaxDamage(800);
		setMaxStackSize(1);
		
		ModItems.ITEMS.add(this);
	}

	@Override
	public int getItemEnchantability() 
	{
		return 10;
	}

	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
	
	@Override
	protected boolean isArrow(ItemStack stack) 
	{
		if(stack.getItem() == ModItems.DRAGON_CORE_ARROW)
		{
			return true;
		}
		return false;
	}
}
