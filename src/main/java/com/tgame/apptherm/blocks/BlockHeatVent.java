package com.tgame.apptherm.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

import com.tgame.apptherm.AppTherm;
import com.tgame.apptherm.tileentities.TileEntityHeatVent;
import com.tgame.apptherm.util.ModInfo;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockHeatVent extends BlockContainer {

	protected BlockHeatVent(int id) {
		super(id, Material.iron);
		
		this.setHardness(2.2F);
		this.setUnlocalizedName(BlockInfo.VENT_UNLOCALIZED_NAME);
		this.setCreativeTab(AppTherm.AppThermTab);
		
	}
	
	@SideOnly(Side.CLIENT)
	private Icon multiblockIcon;
	
	@Override
	public void registerIcons(IconRegister register) {
		this.blockIcon = register.registerIcon(ModInfo.RESOURCE_LOCATION + ":" + BlockInfo.VENT_TEXTURES[0]);
		this.multiblockIcon = register.registerIcon(ModInfo.RESOURCE_LOCATION + ":" + BlockInfo.VENT_TEXTURES[1]);
	}
	
	@Override
	public Icon getIcon(int side, int meta) {
		if (meta != 0)
			return this.multiblockIcon;
		return this.blockIcon;
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public TileEntity createTileEntity(World world, int metadata) {
		return new TileEntityHeatVent();
		
	}
	
	

}
