package com.tgame.testmod.common;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

import com.tgame.apptherm.multiblocklib.multiblock.BlockMultiblockBase;
import com.tgame.testmod.TestMod;

public class BlockMultiblockTester extends BlockMultiblockBase {

	public Icon icon;
	
	public BlockMultiblockTester(int par1, Material par2Material) {
		super(par1, par2Material);
		this.setCreativeTab(TestMod.TAB);
		this.setUnlocalizedName("mbTester");
		this.setHardness(1f);
	}

	@Override
	public Icon getIcon(int side, int metadata) {
		return icon;
	}
	
	@Override
	public void registerIcons(IconRegister iconRegister) {
		this.icon = iconRegister.registerIcon(TestMod.TEXTURE_NAME_PREFIX + getUnlocalizedName());
	}
	
	@Override
	public TileEntity createNewTileEntity(World world) {
		return null;
	}
	
	@Override
	public TileEntity createTileEntity(World world, int metadata) {
		return new TileEntityMultiblockTester();
	}
	
/*	@Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) {
		if(player.isSneaking()) {
			return false;
		}
		
		TileEntity te = world.getBlockTileEntity(x, y, z);
		if(te != null && te instanceof TileEntityMultiblockTester) {
			((TileEntityMultiblockTester)te).changeColor();
			return true;
		}
		
		return false;
	}*/
	
	@Override
	public boolean renderAsNormalBlock() {
		return true;
	}
	
	@Override
	public boolean isOpaqueCube() {
		return true;
	}
	
}
