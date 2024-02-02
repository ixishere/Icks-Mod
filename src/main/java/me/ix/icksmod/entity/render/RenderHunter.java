package me.ix.icksmod.entity.render;

import me.ix.icksmod.cosmetics.wings.RenderWings;
import me.ix.icksmod.entity.entity.EntityHunter;
import me.ix.icksmod.entity.model.ModelHunter;
import me.ix.icksmod.utils.Bungie;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderHunter extends RenderLiving<EntityHunter> {

	public static final ResourceLocation TEXTURE = new ResourceLocation(Bungie.MOD_ID + ":textures/entities/hunter.png");

	public RenderHunter(RenderManager manager) 
	{
		super(manager, new ModelHunter(), 0.5f);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityHunter entity) 
	{
		return TEXTURE;
	}
}
