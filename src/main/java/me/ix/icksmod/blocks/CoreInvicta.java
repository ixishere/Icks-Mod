package me.ix.icksmod.blocks;

import java.util.List;

import me.ix.icksmod.Main;
import me.ix.icksmod.gui.client.GuiConfig;
import me.ix.icksmod.init.ModBlocks;
import me.ix.icksmod.init.ModItems;
import me.ix.icksmod.utils.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAnvil;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class CoreInvicta extends Block implements IHasModel {

	public static final AxisAlignedBB CORE_INVICTA = new AxisAlignedBB(0.1875D, 0.0D, 0.25D, 0.8125D, 0.5D, 0.75D);
	
	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	{
		this.setDefaultState(blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
	}
	
	public CoreInvicta(String name, CreativeTabs tab, Material material) {
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(tab);
		
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        return true;
    }
    
	@Override
	public IBlockState getStateFromMeta(int meta) {
		EnumFacing facing = EnumFacing.getFront(meta);
		
		if(facing.getAxis() == EnumFacing.Axis.Y) {
			facing = EnumFacing.NORTH;
		}
		
		return getDefaultState().withProperty(FACING, facing);
	}
	
	@Override
	public int getMetaFromState(IBlockState state) {
		return((EnumFacing)state.getValue(FACING)).getIndex();
	}
	
	@Override
	public BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] {FACING});
	}
	
	private boolean canBlockStay(World worldIn, BlockPos pos)
	{
		return worldIn.getBlockState(pos.down()).isSideSolid(worldIn, pos, EnumFacing.UP);
	}
	
	@Override
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
		return super.canPlaceBlockAt(worldIn, pos) ? this.canBlockStay(worldIn, pos) : false;
	}
	
	@Override
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
		if(!this.canBlockStay(worldIn, pos))
		{
			worldIn.setBlockToAir(pos);
			InventoryHelper.spawnItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ModBlocks.CORE_INVICTA));
		}
	}
	
	@Override
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.CUTOUT;
	}
	
	@Override
	public boolean isFullBlock(IBlockState state) {
		return false;
	}
	
	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return CORE_INVICTA;
	}
	
	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
}
