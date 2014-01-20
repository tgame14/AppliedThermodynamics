package com.tgame.apptherm.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.tgame.apptherm.AppTherm;

public abstract class ATBlock extends BlockContainer {

	protected Class<? extends TileEntity> teClass;

	public ATBlock(int id, String unlocalized) {
		super(id, Material.iron);

		this.setCreativeTab(AppTherm.AppThermTab);
		this.setHardness(2.0F);
		this.setUnlocalizedName("appliedthermodynamics." + unlocalized);
		
		this.teClass = getTileClass();

	}

	/** 
	 * set your Tile Entity class here
	 * 
	 * Be sure to get the class instance, not the object itself.
	 * 
	 * @exception No parameters or your block will crash when placed and throw a Runtime Exception.
	 * 
	 */ 
	public abstract Class getTileClass();

	@Override
	public TileEntity createNewTileEntity(World world) {
		try {
			return teClass.newInstance();
		}
		
		catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("Failed to form "
					+ teClass.getSimpleName() + " for " + this.getClass().getSimpleName());
		}
	}

}
