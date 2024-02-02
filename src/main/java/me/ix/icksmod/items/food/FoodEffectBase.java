package me.ix.icksmod.items.food;

import me.ix.icksmod.Main;
import me.ix.icksmod.init.ModItems;
import me.ix.icksmod.utils.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class FoodEffectBase extends FoodBase implements IHasModel {

	PotionEffect effect;
	
	public FoodEffectBase(String name, CreativeTabs tab, int amount, float saturation, boolean isWolfFood, PotionEffect effect) {
		super(name, tab, amount, saturation, isWolfFood);
		
		setAlwaysEdible();
		
		this.effect = effect;
		
	}
	
	@Override
	protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
		if(!worldIn.isRemote) {
			player.addPotionEffect(new PotionEffect(effect.getPotion(), effect.getDuration(), effect.getAmplifier(), effect.getIsAmbient(), effect.doesShowParticles()));
		}
	}
	
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack stack) {
		return true;
		
	}
	
}
