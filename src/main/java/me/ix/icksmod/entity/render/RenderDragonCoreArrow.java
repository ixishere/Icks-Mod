package me.ix.icksmod.entity.render;

import me.ix.icksmod.entity.entity.EntityDragonCoreArrow;
import me.ix.icksmod.utils.Bungie;
import net.minecraft.client.renderer.entity.RenderArrow;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderDragonCoreArrow extends RenderArrow<EntityDragonCoreArrow>{
	
	public RenderDragonCoreArrow(RenderManager manager) 
	{
		super(manager);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityDragonCoreArrow entity) 
	{
		return new ResourceLocation(Bungie.MOD_ID + ":textures/entities/dragon_core_arrow.png");
	}
	
}
