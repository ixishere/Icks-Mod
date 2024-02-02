package me.ix.icksmod.entity.model.dragon;

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
public class RenderTameDragon extends RenderLiving<EntityTameDragon> {

	public static final ResourceLocation TEXTURE = new ResourceLocation(Bungie.MOD_ID + ":textures/entities/dragon.png");

	public RenderTameDragon(RenderManager manager) 
	{
		super(manager, new ModelTameDragon(NAME_TAG_RANGE), 0.5f);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityTameDragon entity) 
	{
		return TEXTURE;
	}
}
