package me.ix.icksmod;

import me.ix.icksmod.init.ModEntity;
import me.ix.icksmod.init.ModFluids;
import me.ix.icksmod.utils.Bungie;
import me.ix.icksmod.init.ModItems;
import me.ix.icksmod.init.ModSmeltingRecipes;
import me.ix.icksmod.proxy.CommonProxy;
import me.ix.icksmod.tabs.IcksTab;
import me.ix.icksmod.utils.handlers.KeybindHandler;
import me.ix.icksmod.utils.handlers.RenderHandler;
import me.ix.icksmod.world.ModWorldGen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.entity.RenderEntity;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.RenderLivingBase;

@Mod(modid = Bungie.MOD_ID, name = Bungie.NAME, version = Bungie.VERSION)
public class Main {
	
	@Instance
	public static Main instance;
	
	@SidedProxy(clientSide = Bungie.CLIENT_PROXY_CLASS, serverSide = Bungie.COMMON_PROXY_CLASS)
	public static CommonProxy proxy;
	
	public static final CreativeTabs ICKSTAB = new IcksTab("Icks Mod");
	
	static {
		FluidRegistry.enableUniversalBucket();
	}
	
	@EventHandler
	public static void PreInit(FMLPreInitializationEvent event) {
		ModFluids.registerFluids(); // NEEDS TO BE AT THE TOP
		RenderHandler.registerCustomMeshesAndStates(); //
		ModEntity.registerEntities();
		GameRegistry.registerWorldGenerator(new ModWorldGen(), 3);
		me.ix.icksmod.utils.handlers.EventHandler.registerEvents();
	}
	
	@EventHandler
	public static void init(FMLInitializationEvent event) {
		ModSmeltingRecipes.init();
	}
	
	@EventHandler
	public static void Postinit(FMLPostInitializationEvent event) {
	}
	
	@SideOnly(Side.CLIENT)
	@EventHandler
	public static void PreInitClient(FMLPreInitializationEvent event) {
		RenderHandler.registerEntityRenders();
		KeybindHandler.registerKeybinds();
	}
	
	@SideOnly(Side.CLIENT)
	@EventHandler
	public static void initClient(FMLInitializationEvent event) {
		RenderHandler.registerLayers();
	}
	
	@SideOnly(Side.CLIENT)
	@EventHandler
	public static void PostinitClient(FMLPostInitializationEvent event) {
	}
}
