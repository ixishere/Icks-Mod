package me.ix.icksmod.utils.handlers;

import me.ix.icksmod.cosmetics.wings.RenderWings;
import me.ix.icksmod.entity.entity.EntityDragonCoreArrow;
import me.ix.icksmod.entity.entity.EntityHunter;
import me.ix.icksmod.entity.entity.EntityWulick;
import me.ix.icksmod.entity.model.dragon.EntityTameDragon;
import me.ix.icksmod.entity.model.dragon.RenderTameDragon;
import me.ix.icksmod.entity.render.RenderDragonCoreArrow;
import me.ix.icksmod.entity.render.RenderHunter;
import me.ix.icksmod.entity.render.RenderWulick;
import me.ix.icksmod.init.ModBlocks;
import me.ix.icksmod.init.ModFluids;
import me.ix.icksmod.utils.Bungie;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


@SideOnly(Side.CLIENT)
public class RenderHandler {

	public static void registerCustomMeshesAndStates() {
		ModelLoader.setCustomMeshDefinition(Item.getItemFromBlock(ModBlocks.DRAGON_CORE_FLUID), new ItemMeshDefinition() {
			@Override
			public ModelResourceLocation getModelLocation(ItemStack stack) {
				return new ModelResourceLocation(Bungie.MOD_ID + ":dragon_core_fluid", "fluid");
			}
		});
		
		ModelLoader.setCustomStateMapper(ModBlocks.DRAGON_CORE_FLUID, new StateMapperBase() {
			@Override
			protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
				return new ModelResourceLocation(Bungie.MOD_ID + ":dragon_core_fluid", "fluid");
			}
		});
	}
	
	public static void registerEntityRenders() {
		
		AbstractClientPlayer player;

		RenderingRegistry.registerEntityRenderingHandler(EntityWulick.class, new IRenderFactory<EntityWulick>() {
			@Override
			public Render<? super EntityWulick> createRenderFor(RenderManager manager) 
			{
				return new RenderWulick(manager);
			}
			
		});
		
		RenderingRegistry.registerEntityRenderingHandler(EntityTameDragon.class, new IRenderFactory<EntityTameDragon>() {
			@Override
			public Render<? super EntityTameDragon> createRenderFor(RenderManager manager) 
			{
				return new RenderTameDragon(manager);
			}
			
		});
		
		RenderingRegistry.registerEntityRenderingHandler(EntityHunter.class, new IRenderFactory<EntityHunter>() {
			@Override
			public Render<? super EntityHunter> createRenderFor(RenderManager manager) 
			{
				return new RenderHunter(manager);
			}
		});
	
		RenderingRegistry.registerEntityRenderingHandler(EntityDragonCoreArrow.class, new IRenderFactory<EntityDragonCoreArrow>() {
			@Override
			public Render<? super EntityDragonCoreArrow> createRenderFor(RenderManager manager) 
			{
				return new RenderDragonCoreArrow(manager);
			}
		});
	}
	
	public static void registerLayers() {
		RenderLivingBase defaultrender = Minecraft.getMinecraft().getRenderManager().getSkinMap().get("default");
		defaultrender.addLayer(new RenderWings(defaultrender));
		
		RenderLivingBase slimrender = Minecraft.getMinecraft().getRenderManager().getSkinMap().get("slim");
		slimrender.addLayer(new RenderWings(slimrender));
	}
}
