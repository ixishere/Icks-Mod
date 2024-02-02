package me.ix.icksmod.cosmetics.wings;

import me.ix.icksmod.init.ModItems;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelElytra;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EnumPlayerModelParts;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderWings implements LayerRenderer<EntityLivingBase>
{

    private static final ResourceLocation TEXTURE_ELYTRA = new ResourceLocation("im:textures/cosmetics/wings.png");

    protected final RenderLivingBase<?> renderPlayer;

    private final ModelWings modelWings = new ModelWings();

    public RenderWings(RenderLivingBase<?> p_i47185_1_)
    {
        this.renderPlayer = p_i47185_1_;
    }

    public void doRenderLayer(EntityLivingBase entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale)
    {
    	ItemStack itemstack = entitylivingbaseIn.getItemStackFromSlot(EntityEquipmentSlot.CHEST);
        if (itemstack.getItem() == ModItems.DRAGON_CORE_WINGS_CHESTPLATE) {
    	
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            GlStateManager.enableBlend();
            GlStateManager.blendFunc(GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);

            if (entitylivingbaseIn instanceof AbstractClientPlayer)
            {
                AbstractClientPlayer abstractclientplayer = (AbstractClientPlayer)entitylivingbaseIn;

                this.renderPlayer.bindTexture(TEXTURE_ELYTRA);
            }

            GlStateManager.pushMatrix();
            GlStateManager.translate(0.0F, 0.0F, 0.125F);
            this.modelWings.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entitylivingbaseIn);
            this.modelWings.render(entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);


            GlStateManager.disableBlend();
            GlStateManager.popMatrix();
        }
    }
    
    public boolean shouldCombineTextures()
    {
        return false;
    }
}