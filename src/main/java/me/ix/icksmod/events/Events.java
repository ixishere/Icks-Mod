package me.ix.icksmod.events;

import java.util.List;
import java.util.Random;

import org.omg.PortableServer.POAManagerPackage.State;

import me.ix.icksmod.entity.entity.EntityHunter;
import me.ix.icksmod.gui.client.GuiConfig;
import me.ix.icksmod.init.ModBlocks;
import me.ix.icksmod.init.ModEntity;
import me.ix.icksmod.init.ModItems;
import me.ix.icksmod.init.ModSmeltingRecipes;
import me.ix.icksmod.proxy.ClientProxy;
import me.ix.icksmod.utils.handlers.KeybindHandler;
import me.ix.icksmod.utils.handlers.RenderHandler;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickBlock;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.WorldTickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Events {

	/*
	@SubscribeEvent
	public void exampleEvent(HarvestDropsEvent event) {
		World world = event.getWorld();
		BlockPos pos = event.getPos();
		IBlockState state = event.getState();
		Block block = state.getBlock();
		
		double x = pos.getX(); 
		double y = pos.getY();
		double z = pos.getZ();
		
		if(block.equals(ModBlocks.AMETHYST_BLOCK)) {
			world.setBlockState(pos, ModBlocks.AMETHYST_BLOCK.getDefaultState());
			event.getDrops().clear();
			
			for(int i = 0; i < world.getEntitiesWithinAABBExcludingEntity(null, null).size(); i++) {
				System.out.println(world.loadedEntityList.get(i));
			}
		}
	}
	*/
	
	
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event) {
		if(KeybindHandler.menuCosmetic.isKeyDown()){
			Minecraft.getMinecraft().displayGuiScreen(new GuiConfig());
        }
    }
	 
	@SideOnly(Side.CLIENT)
	 @SubscribeEvent
	 public void onLivingUpdate(LivingUpdateEvent event) {
			if (event.getEntity() instanceof EntityPlayer){
				EntityPlayer player = (EntityPlayer) event.getEntity();
			
				if(player.isCreative()) {
					player.capabilities.allowFlying = true;
				}else if(player.inventory.armorItemInSlot(2).getItem() != null) {
						if(player.inventory.armorItemInSlot(2).getItem() == ModItems.DRAGON_CORE_WINGS_CHESTPLATE) {
							player.capabilities.allowFlying = true;
						} else {
							player.capabilities.allowFlying = false;
							player.capabilities.isFlying = false;
						}
					}
			}
	}

	@SubscribeEvent
	public void rightClickImmaculation(RightClickBlock event) {
		if (event.getItemStack().getItem() == ModItems.FLUID_IMMACULATOR) {
			if (event.getWorld().getBlockState(event.getPos()).getBlock() == ModBlocks.DRAGON_CORE_BLOCK) {
				event.getWorld().destroyBlock(event.getPos(), false);
				event.getWorld().createExplosion(event.getEntity(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), 2, false);
				event.getWorld().setBlockState(event.getPos(), ModBlocks.DRAGON_CORE_FLUID.getDefaultState());
			}
		}
	}
	
	@SubscribeEvent
	public void rightClickInvicta(RightClickBlock event) {
		int amountOfDragonBlocks = 0;
		int amountOfDragonFluid = 0;
		BlockPos fluidLocation = null;
		
		for (EnumFacing direction: EnumFacing.VALUES) {
			BlockPos neighbourPos = event.getPos().offset(direction);
			IBlockState neighbourState = event.getWorld().getBlockState(neighbourPos);
			Block neighbourBlock = neighbourState.getBlock();

			if (neighbourBlock == ModBlocks.DRAGON_CORE_BLOCK) amountOfDragonBlocks++;
			if (neighbourBlock == ModBlocks.DRAGON_CORE_FLUID) {
				amountOfDragonFluid++;
				
				fluidLocation = neighbourPos;
			}
			
			if (event.getWorld().getBlockState(event.getPos()).getBlock() == ModBlocks.CORE_INVICTA && amountOfDragonBlocks == 4 && amountOfDragonFluid == 1) {
				AxisAlignedBB scaninsidefluid = new AxisAlignedBB(fluidLocation.getX()-1, fluidLocation.getY()-1, fluidLocation.getZ()-1, fluidLocation.getX()+1, fluidLocation.getY()+1, fluidLocation.getZ()+1);
			    List<EntityItem> entities = event.getWorld().getEntitiesWithinAABB(EntityItem.class, scaninsidefluid);
				
				if(foundCoreWingsRecipe(entities)) {
			    	event.getWorld().addWeatherEffect(new EntityLightningBolt(event.getWorld(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), true));
			    	EntityItem itemtospawn= new EntityItem(event.getWorld(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), new ItemStack(ModItems.INACTIVE_DRAGON_CORE_WINGS, 1, 0));
					itemtospawn.setLocationAndAngles(event.getPos().getX(), event.getPos().getY() + 50, event.getPos().getZ(), 0.0F, 0.0F);
					event.getWorld().spawnEntity(itemtospawn);
				}
				if(foundWingsChestplateRecipe(entities)) {
			    	event.getWorld().addWeatherEffect(new EntityLightningBolt(event.getWorld(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), true));
			    	EntityItem itemtospawn= new EntityItem(event.getWorld(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), new ItemStack(ModItems.DRAGON_CORE_WINGS_CHESTPLATE, 1, 0));
					itemtospawn.setLocationAndAngles(event.getPos().getX(), event.getPos().getY() + 50, event.getPos().getZ(), 0.0F, 0.0F);
					event.getWorld().spawnEntity(itemtospawn);
				}
			}
		}
	}
	
	public boolean foundWingsChestplateRecipe(List<EntityItem> list) {
        boolean foundCoreWings = false;
        boolean foundCoreChestplate = false;
        int amountofItems = 0;
        for (EntityItem entityItem : list) {
            if(ItemStack.areItemsEqual(entityItem.getItem(), new ItemStack(ModItems.INACTIVE_DRAGON_CORE_WINGS))) {
            	foundCoreWings = true;
            	amountofItems = amountofItems + 1;
            }
            if(ItemStack.areItemStacksEqual(entityItem.getItem(), new ItemStack(ModItems.DRAGON_CORE_CHESTPLATE))) {
            	foundCoreChestplate = true;
            	amountofItems = amountofItems + 1;
            }
            if(foundCoreWings && foundCoreChestplate) {
            	for (EntityItem items : list) {
            		items.setDead();
            	}
            } 
        }
        return foundCoreWings && foundCoreChestplate;
    }
	
	public boolean foundCoreWingsRecipe(List<EntityItem> list) {
        boolean foundDragWings = false;
        boolean foundDragCore = false;
        int amountofItems = 0;
        for (EntityItem entityItem : list) {
            if(ItemStack.areItemsEqual(entityItem.getItem(), new ItemStack(ModItems.DRAGON_CORE))) {
            	foundDragCore = true;
            	amountofItems = amountofItems + 1;
            }
            if(ItemStack.areItemStacksEqual(entityItem.getItem(), new ItemStack(ModItems.INACTIVE_DRAGON_WINGS))) {
            	foundDragWings = true;
            	amountofItems = amountofItems + 1;
            }
            if(foundDragWings && foundDragCore) {
            	for (EntityItem items : list) {
            		items.setDead();
            	}
            } 
        }
        return foundDragWings && foundDragCore;
    }
	
	@SubscribeEvent
	public void onLivingDropsEvent(LivingDropsEvent event) {
		Entity entity = event.getEntity();
		World world = entity.getEntityWorld();
		BlockPos pos = entity.getPosition();
		
		if(entity instanceof EntityDragon){
			event.getEntityLiving().entityDropItem(new ItemStack(ModItems.DRAGON_CORE), 0.0f);
			event.getEntityLiving().entityDropItem(new ItemStack(ModItems.INACTIVE_DRAGON_WINGS), 0.0f);
		}
	}	
	 
	 @SubscribeEvent
		public void onEntityDeath(LivingDeathEvent event) {
		 
		 World world = event.getEntity().world;
		 BlockPos pos = event.getEntity().getPosition();
		 double x = pos.getX();
		 double y = pos.getY();
		 double z = pos.getZ();
		 
		 if(event.getEntity() instanceof EntityHunter) {
		 }
	 }
}
