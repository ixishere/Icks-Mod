package me.ix.icksmod.init;

import me.ix.icksmod.Main;
import me.ix.icksmod.entity.entity.EntityDragonCoreArrow;
import me.ix.icksmod.entity.entity.EntityHunter;
import me.ix.icksmod.entity.entity.EntityWulick;
import me.ix.icksmod.entity.model.dragon.EntityTameDragon;
import me.ix.icksmod.utils.Bungie;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class ModEntity {
	
	public static void registerEntities() {
		registerEntity("wulick", EntityWulick.class, Bungie.ENTITY_WULICK, 50, 5177460, 5242740);
		registerEntity("hunter", EntityHunter.class, Bungie.ENTITY_HUNTER, 50, 0, 16777215);
		registerEntity("tame_dragon", EntityTameDragon.class, Bungie.ENTITY_TAME_DRAGON, 50, 0, 16777215);
		
		registerArrow("dragon_core_arrow", EntityDragonCoreArrow.class, Bungie.ENTITY_DRAGON_CORE_ARROW);
	}
	
	private static void registerEntity(String name, Class<? extends Entity> entity, int id, int range, int color1, int color2)
	{
		EntityRegistry.registerModEntity(new ResourceLocation(Bungie.MOD_ID + ":" + name), entity, name, id, Main.instance, range, 1, true, color1, color2);
	}
	
	private static void registerArrow(String name, Class<? extends Entity> entity, int id) {
		EntityRegistry.registerModEntity(new ResourceLocation(Bungie.MOD_ID + ":" + name), entity, name, id, Main.instance, 64, 20, true);
	}
}
