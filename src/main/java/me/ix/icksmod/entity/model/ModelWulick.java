package me.ix.icksmod.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelWulick extends ModelBase {
    public ModelRenderer shape1;
    public ModelRenderer shape1_1;
    public ModelRenderer shape1_2;
    public ModelRenderer shape1_3;
    public ModelRenderer shape5;
    public ModelRenderer shape5_1;

    public ModelWulick() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.shape1_1 = new ModelRenderer(this, 8, 0);
        this.shape1_1.setRotationPoint(-5.0F, 13.5F, 5.0F);
        this.shape1_1.addBox(0.0F, 0.0F, 0.0F, 2, 10, 2, 0.0F);
        this.shape5_1 = new ModelRenderer(this, 0, 0);
        this.shape5_1.setRotationPoint(-6.9F, 12.6F, -10.0F);
        this.shape5_1.addBox(0.0F, 0.0F, 0.0F, 15, 3, 20, 0.0F);
        this.shape1 = new ModelRenderer(this, 0, 0);
        this.shape1.setRotationPoint(3.0F, 13.5F, 5.0F);
        this.shape1.addBox(0.0F, 0.0F, 0.0F, 2, 10, 2, 0.0F);
        this.shape1_2 = new ModelRenderer(this, 16, 0);
        this.shape1_2.setRotationPoint(4.0F, 13.5F, -7.0F);
        this.shape1_2.addBox(0.0F, 0.0F, 0.0F, 2, 10, 2, 0.0F);
        this.shape1_3 = new ModelRenderer(this, 24, 0);
        this.shape1_3.setRotationPoint(-6.0F, 13.5F, -7.0F);
        this.shape1_3.addBox(0.0F, 0.0F, 0.0F, 2, 10, 2, 0.0F);
        this.shape5 = new ModelRenderer(this, 32, 0);
        this.shape5.setRotationPoint(-3.4F, 9.6F, 8.0F);
        this.shape5.addBox(0.0F, 0.0F, 0.0F, 8, 5, 7, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.shape1_1.render(f5);
        this.shape5_1.render(f5);
        this.shape1.render(f5);
        this.shape1_2.render(f5);
        this.shape1_3.render(f5);
        this.shape5.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
    	model.rotateAngleX = x;
    	model.rotateAngleY = y;
    	model.rotateAngleZ = z;
    }
    
    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) 
    {
    	this.shape1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f + (float)Math.PI) * 1.4f * limbSwingAmount;
        this.shape1_1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f + (float)Math.PI) * 1.4f * limbSwingAmount;
        this.shape1_2.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f) * 1.4f * limbSwingAmount; 
        this.shape1_3.rotateAngleX = MathHelper.cos(limbSwing * 0.6662f) * 1.4f * limbSwingAmount;
    }
}
