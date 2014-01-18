package com.tgame.apptherm.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.tgame.apptherm.AppTherm;

public abstract class ATBlock extends BlockContainer {

	protected Class<? extends TileEntity> teClass;

	protected ATBlock(int id) {
		super(id, Material.iron);

		this.setCreativeTab(AppTherm.AppThermTab);
		this.setHardness(2.0F);

	}

	protected abstract Class getTileClass();

	@Override
	public TileEntity createNewTileEntity(World world) {
		try {
			return teClass.newInstance();
		}
		catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("Failed to form "
					+ teClass.getSimpleName() + " for Block");
		}
	}

}
