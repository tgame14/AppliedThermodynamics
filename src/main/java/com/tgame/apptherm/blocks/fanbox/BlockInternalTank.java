package com.tgame.apptherm.blocks.fanbox;

import com.tgame.apptherm.AppTherm;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockInternalTank extends BlockContainer {
	public BlockInternalTank(int id) {
		super(id, Material.iron);
		
		this.setHardness(2.0F);
		this.setCreativeTab(AppTherm.AppThermTab);
		this.setUnlocalizedName("");
		
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		// TODO Auto-generated method stub
		return null;
	}

}
