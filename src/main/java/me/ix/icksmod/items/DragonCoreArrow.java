package me.ix.icksmod.items;

import me.ix.icksmod.Main;
import me.ix.icksmod.entity.entity.EntityDragonCoreArrow;
import me.ix.icksmod.init.ModItems;
import me.ix.icksmod.utils.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.ItemArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class DragonCoreArrow extends ItemArrow implements IHasModel {

	public DragonCoreArrow(String name, CreativeTabs tab) {		
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(tab);
		setMaxDamage(800);
		setMaxStackSize(1);
		
		ModItems.ITEMS.add(this);
	}

	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
	
	@Override
	public EntityArrow createArrow(World worldIn, ItemStack stack, EntityLivingBase shooter) 
	{
		EntityDragonCoreArrow entitydragoncorearrow = new EntityDragonCoreArrow(worldIn, shooter);
		return entitydragoncorearrow;
	}
	
}
