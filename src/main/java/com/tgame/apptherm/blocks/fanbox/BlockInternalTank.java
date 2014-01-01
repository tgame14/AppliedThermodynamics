package com.tgame.apptherm.blocks.fanbox;

import com.tgame.apptherm.AppTherm;
import com.tgame.apptherm.blocks.BlockInfo;
import com.tgame.apptherm.tileentities.fanbox.TileEntityInternalTank;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockInternalTank extends BlockContainer {
	public BlockInternalTank(int id) {
		super(id, Material.iron);
		
		this.setHardness(2.0F);
		this.setCreativeTab(AppTherm.AppThermTab);
		this.setUnlocalizedName(BlockInfo.INTAKE_UNLOCALIZED_NAME);
		
	}

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityInternalTank();
	}

}
