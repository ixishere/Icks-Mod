package me.ix.icksmod.init;

import java.util.ArrayList;
import java.util.List;

import me.ix.icksmod.Main;
import me.ix.icksmod.items.DragonCoreArrow;
import me.ix.icksmod.items.DragonCoreBow;
import me.ix.icksmod.items.ItemBase;
import me.ix.icksmod.items.armor.ArmorBase;
import me.ix.icksmod.items.armor.DragonArmorBase;
import me.ix.icksmod.items.food.FoodBase;
import me.ix.icksmod.items.food.FoodEffectBase;
import me.ix.icksmod.items.tools.ToolAxe;
import me.ix.icksmod.items.tools.ToolHoe;
import me.ix.icksmod.items.tools.ToolImmaculator;
import me.ix.icksmod.items.tools.ToolPickaxe;
import me.ix.icksmod.items.tools.ToolSpade;
import me.ix.icksmod.items.tools.ToolSword;
import me.ix.icksmod.utils.Bungie;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.common.util.EnumHelper;

public class ModItems {
	
	public static final List<Item> ITEMS = new ArrayList<Item>();

	/* AMETHYST STUFF ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
	//Materials
	public static final ToolMaterial MATERIAL_AMETHYST = EnumHelper.addToolMaterial("material_amethyst", 3, 1000, 8.0F, 100.0F, 10);
	public static final ArmorMaterial ARMOR_MATERIAL_AMETHYST = EnumHelper.addArmorMaterial("armor_material_amethyst", Bungie.MOD_ID + ":amethyst", 17, new int[] {4, 7, 9, 4}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0.0F);
	//Items
	public static final Item AMETHYST_INGOT = new ItemBase("amethyst_ingot", Main.ICKSTAB);
	//Tools
	public static final ItemSword AMETHYST_SWORD = new ToolSword("amethyst_sword", Main.ICKSTAB, MATERIAL_AMETHYST);
	public static final ItemSpade AMETHYST_SHOVEL = new ToolSpade("amethyst_shovel", Main.ICKSTAB, MATERIAL_AMETHYST);
	public static final ItemPickaxe AMETHYST_PICKAXE = new ToolPickaxe("amethyst_pickaxe", Main.ICKSTAB, MATERIAL_AMETHYST);
	public static final ItemAxe AMETHYST_AXE = new ToolAxe("amethyst_axe", Main.ICKSTAB, MATERIAL_AMETHYST);
	public static final ItemHoe AMETHYST_HOE = new ToolHoe("amethyst_hoe", Main.ICKSTAB, MATERIAL_AMETHYST);
	//Armor
	public static final Item AMETHYST_HELMET = new ArmorBase("amethyst_helmet", Main.ICKSTAB, ARMOR_MATERIAL_AMETHYST, 1, EntityEquipmentSlot.HEAD);
	public static final Item AMETHYST_CHESTPLATE = new ArmorBase("amethyst_chestplate", Main.ICKSTAB, ARMOR_MATERIAL_AMETHYST, 1, EntityEquipmentSlot.CHEST);
	public static final Item AMETHYST_LEGGINGS = new ArmorBase("amethyst_leggings", Main.ICKSTAB, ARMOR_MATERIAL_AMETHYST, 2, EntityEquipmentSlot.LEGS);
	public static final Item AMETHYST_BOOTS = new ArmorBase("amethyst_boots", Main.ICKSTAB, ARMOR_MATERIAL_AMETHYST, 1, EntityEquipmentSlot.FEET);
	//Food
	public static final Item AMETHYST_APPLE = new FoodBase("amethyst_apple", Main.ICKSTAB, 10, 15.0F, false);
	public static final Item AMETHYST_SUPER_APPLE = new FoodEffectBase("amethyst_super_apple", Main.ICKSTAB, 10, 15.0F, false, new PotionEffect(MobEffects.REGENERATION, 5*(60*20), 4, false, true));
	
	/* DRAGON CORE STUFF ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
	//Materials
	public static final ToolMaterial MATERIAL_DRAGON_CORE = EnumHelper.addToolMaterial("material_dragon_core", 3, 1000, 8.0F, 100.0F, 10);
	public static final ArmorMaterial ARMOR_MATERIAL_DRAGON_CORE = EnumHelper.addArmorMaterial("armor_material_dragon_core", Bungie.MOD_ID + ":dragon_core", 18, new int[] {8, 14, 18, 8}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0.0F);
	//Armor
	public static final Item DRAGON_CORE_HELMET = new DragonArmorBase("dragon_core_helmet", Main.ICKSTAB, ARMOR_MATERIAL_DRAGON_CORE, 1, EntityEquipmentSlot.HEAD);
	public static final Item DRAGON_CORE_CHESTPLATE = new DragonArmorBase("dragon_core_chestplate", Main.ICKSTAB, ARMOR_MATERIAL_DRAGON_CORE, 1, EntityEquipmentSlot.CHEST);
	public static final Item DRAGON_CORE_WINGS_CHESTPLATE = new DragonArmorBase("dragon_core_wings_chestplate", Main.ICKSTAB, ARMOR_MATERIAL_DRAGON_CORE, 1, EntityEquipmentSlot.CHEST);
	public static final Item DRAGON_CORE_LEGGINGS = new DragonArmorBase("dragon_core_leggings", Main.ICKSTAB, ARMOR_MATERIAL_DRAGON_CORE, 1, EntityEquipmentSlot.LEGS);
	public static final Item DRAGON_CORE_BOOTS = new DragonArmorBase("dragon_core_boots", Main.ICKSTAB, ARMOR_MATERIAL_DRAGON_CORE, 1, EntityEquipmentSlot.FEET);
	public static final ItemSword DRAGON_CORE_SWORD = new ToolSword("dragon_core_sword", Main.ICKSTAB, MATERIAL_DRAGON_CORE);
	//Items
	public static final Item DRAGON_CORE = new ItemBase("dragon_core", Main.ICKSTAB);
	public static final Item INACTIVE_DRAGON_WINGS = new ItemBase("inactive_dragon_wings", Main.ICKSTAB);
	public static final Item INACTIVE_DRAGON_CORE_WINGS = new ItemBase("inactive_dragon_core_wings", Main.ICKSTAB);
	
	public static final Item DRAGON_CORE_BOW = new DragonCoreBow("dragon_core_bow", Main.ICKSTAB);
	public static final Item DRAGON_CORE_ARROW = new DragonCoreArrow("dragon_core_arrow", Main.ICKSTAB);
	
	public static final Item FLUID_IMMACULATOR = new ToolImmaculator("fluid_immaculator", Main.ICKSTAB);
	
	public static final Item END_STONE_PANEL = new ItemBase("end_stone_panel", Main.ICKSTAB);
	public static final Item DIAMOND_BLOCK_PANEL = new ItemBase("diamond_block_panel", Main.ICKSTAB);
	
}
