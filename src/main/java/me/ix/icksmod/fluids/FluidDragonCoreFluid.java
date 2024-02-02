package me.ix.icksmod.fluids;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;

public class FluidDragonCoreFluid extends Fluid {

	public FluidDragonCoreFluid(String name, ResourceLocation still, ResourceLocation flow) {
		super(name, still, flow);
		this.setUnlocalizedName(name);
	}
	
}
