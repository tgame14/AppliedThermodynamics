package com.tgame.apptherm.blocks.liquidcooler;

import com.tgame.apptherm.blocks.BlockInfo;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockCoolerCasing extends BlockContainer {
	public BlockCoolerCasing(int id) {
		super(id, Material.iron);
		
		this.setUnlocalizedName("appliedthermodynamics." + BlockInfo.COOLANT_UNLOCALIZED_NAME);
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		// TODO Auto-generated method stub
		return null;
	}

}
