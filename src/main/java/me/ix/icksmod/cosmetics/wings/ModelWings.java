package me.ix.icksmod.cosmetics.wings;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelWings extends ModelBase
{
    private Minecraft mc;
    private ModelRenderer wing;
    private ModelRenderer wingTip;
    private boolean playerUsesFullHeight;

    public ModelWings() {
    	this.mc = Minecraft.getMinecraft();
        this.setTextureOffset("wing.bone", 0, 0);
        this.setTextureOffset("wing.skin", -10, 8);
        this.setTextureOffset("wingtip.bone", 0, 5);
        this.setTextureOffset("wingtip.skin", -10, 18);
        (this.wing = new ModelRenderer(this, "wing")).setTextureSize(30, 30);
        this.wing.setRotationPoint(-2.0F, 0.0F, 0.0F);
        this.wing.addBox("bone", -10.0F, -1.0F, -1.0F, 10, 2, 2);
        this.wing.addBox("skin", -10.0F, 0.0F, 0.5F, 10, 0, 10);
        (this.wingTip = new ModelRenderer(this, "wingtip")).setTextureSize(30, 30);
        this.wingTip.setRotationPoint(-10.0F, 0.0F, 0.0F);
        this.wingTip.addBox("bone", -10.0F, -0.5F, -0.5F, 10, 1, 1);
        this.wingTip.addBox("skin", -10.0F, 0.0F, 0.5F, 10, 0, 10);
        this.wing.addChild(this.wingTip);
    }

    @Override
    public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
    	
    	
            double rotate = 0; 
            this.interpolate(entityIn.prevRotationYaw, entityIn.getRotationYawHead(), mc.getRenderPartialTicks());

            scale = 1F;
            
            GlStateManager.pushMatrix();


            GlStateManager.scale(-scale, -scale, scale);
            GlStateManager.rotate((float) (180.0F + rotate), 0.0F, 0.F, 20F);

            float scaledPlayerHeight = (float) (1.85F / scale);

            float scaledHeight = (float) ((this.playerUsesFullHeight ? 1.45 : 1.25) / scale);

            // Moves the wings to the top of the player's head then backward slightly (away from the centre).
            GlStateManager.translate(0.0F, 0.15F, 0.0F);
            GlStateManager.translate(0.0F, 0.0F, 0.05F / scale);

            if (entityIn.isSneaking()) {
                GlStateManager.translate(0.0F, 0.125 / scale, 0.0F);
            }

            GlStateManager.color(1.0F, 1.0F, 1.0F);

            for (int j = 0; j < 2; ++j) {
                GL11.glEnable(2884);
                float f11 = System.currentTimeMillis() % 1000L / 1000.0f * 3.1415927f * 2.0F;
                this.wing.rotateAngleX = (float) Math.toRadians(-80.0) - (float) Math.cos(f11) * 0.2F;
                this.wing.rotateAngleY = (float) Math.toRadians(20.0) + (float) Math.sin(f11) * 0.4F;
                this.wing.rotateAngleZ = (float) Math.toRadians(20.0);
                this.wingTip.rotateAngleZ = -(float) (Math.sin(f11 + 2.0F) + 0.5) * 0.75F;
                this.wing.render(0.0625F);
                GlStateManager.scale(-1.0F, 1.0F, 1.0F);
                if (j == 0) {
                    GL11.glCullFace(1028);
                }
            }
            GL11.glCullFace(1029);
            GL11.glDisable(2884);
            GL11.glPopMatrix();
        }

        public float interpolate(float yaw1, float yaw2, final float percent) {
            float f = (yaw1 + (yaw2 - yaw1) * percent) % 360.0F;
            if (f < 0.0F) {
                f += 360.0F;
            }
            return f;
        }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
