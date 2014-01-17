package com.tgame.apptherm.blocks;

import com.tgame.apptherm.AppTherm;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class ATBlock extends BlockContainer {

	protected Class teClass;
	
	protected ATBlock(int id) {
		super(id, Material.iron);
		
		this.setCreativeTab(AppTherm.AppThermTab);
		this.setHardness(2.0F);
		
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		// TODO Auto-generated method stub
		return null;
	}

}
