package me.ix.icksmod.init;

import java.util.ArrayList;
import java.util.List;

import me.ix.icksmod.Main;
import me.ix.icksmod.blocks.AmethystBlock;
import me.ix.icksmod.blocks.AmethystOre;
import me.ix.icksmod.blocks.BlockBase;
import me.ix.icksmod.blocks.CoreInvicta;
import me.ix.icksmod.blocks.DragonCoreFluid;
import me.ix.icksmod.blocks.IckBlock;
import me.ix.icksmod.items.ItemBase;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class ModBlocks {

	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	public static final Block AMETHYST_BLOCK = new AmethystBlock("amethyst_block", Main.ICKSTAB, Material.IRON);
	public static final Block AMETHYST_ORE = new AmethystOre("amethyst_ore", Main.ICKSTAB, Material.ROCK);
	
	public static final Block ICK_BLOCK = new IckBlock("ick_block", Main.ICKSTAB, Material.IRON);
	public static final Block ICK_ORE = new AmethystOre("ick_ore", Main.ICKSTAB, Material.ROCK);
	
	public static final Block CORE_INVICTA = new CoreInvicta("core_invicta", Main.ICKSTAB, Material.IRON);
	public static final Block DRAGON_CORE_BLOCK = new BlockBase("dragon_core_block", Main.ICKSTAB, Material.IRON);
	
	public static final Block DRAGON_CORE_FLUID = new DragonCoreFluid("dragon_core_fluid", Main.ICKSTAB, ModFluids.DRAGON_CORE_FLUID, Material.WATER);
}
