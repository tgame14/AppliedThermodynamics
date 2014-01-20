package com.tgame.apptherm.blocks.networked;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.tgame.apptherm.AppTherm;
import com.tgame.apptherm.blocks.ATBlock;
import com.tgame.apptherm.blocks.BlockInfo;
import com.tgame.apptherm.tileentities.TileEntityEater;

public class BlockEnergyEater extends ATBlock {
	
	public BlockEnergyEater(int id) {
		super(id, BlockInfo.EATER_UNLOCALIZED_NAME);

	}

	@Override
	public Class getTileClass() {
		return TileEntityEater.class;
	}


}
