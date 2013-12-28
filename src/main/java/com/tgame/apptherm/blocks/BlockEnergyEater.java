package com.tgame.apptherm.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.tgame.apptherm.AppTherm;
import com.tgame.apptherm.tileentities.TileEntityEater;

public class BlockEnergyEater extends BlockContainer {
	
	protected BlockEnergyEater(int id) {
		super(id, Material.iron);
		
		this.setCreativeTab(AppTherm.AppThermTab);
		this.setHardness(2.0F);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityEater();
	}

}
