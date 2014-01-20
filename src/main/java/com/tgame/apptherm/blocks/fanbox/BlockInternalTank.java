package com.tgame.apptherm.blocks.fanbox;

import com.tgame.apptherm.AppTherm;
import com.tgame.apptherm.blocks.ATBlock;
import com.tgame.apptherm.blocks.BlockInfo;
import com.tgame.apptherm.tileentities.fanbox.TileEntityInternalTank;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockInternalTank extends ATBlock {
	public BlockInternalTank(int id) {
		super(id, BlockInfo.INTTANK_UNLOCAZLIZED_NAME);
		
	}

	@Override
	public Class getTileClass() {
		return TileEntityInternalTank.class;
	}



}
