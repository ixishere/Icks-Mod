package me.ix.icksmod.entity.render;

import me.ix.icksmod.entity.entity.EntityWulick;
import me.ix.icksmod.entity.model.ModelWulick;
import me.ix.icksmod.utils.Bungie;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderWulick extends RenderLiving<EntityWulick> {

	public static final ResourceLocation TEXTURE = new ResourceLocation(Bungie.MOD_ID + ":textures/entities/wulick.png");

	public RenderWulick(RenderManager manager) 
	{
		super(manager, new ModelWulick(), 0.2f);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityWulick entity) 
	{
		return TEXTURE;
	}
}
