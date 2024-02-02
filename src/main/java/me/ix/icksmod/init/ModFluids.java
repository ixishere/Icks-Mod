package me.ix.icksmod.init;

import me.ix.icksmod.fluids.FluidDragonCoreFluid;
import me.ix.icksmod.utils.Bungie;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class ModFluids {

	public static final Fluid DRAGON_CORE_FLUID = new FluidDragonCoreFluid("dragon_core_fluid", 
			new ResourceLocation(Bungie.MOD_ID + ":blocks/dragon_core_fluid_still"), 
			new ResourceLocation(Bungie.MOD_ID + ":blocks/dragon_core_fluid_flow"));
	
	public static void registerFluids() {
		registerFluid(DRAGON_CORE_FLUID);
	}

	public static void registerFluid(Fluid fluid) {
		FluidRegistry.registerFluid(fluid);
		FluidRegistry.addBucketForFluid(fluid);
	}
}
