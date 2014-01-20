package com.tgame.apptherm.tileentities.liquidcooler;

import com.tgame.apptherm.libs.multiblocks.multiblock.MultiblockControllerBase;
import com.tgame.apptherm.libs.multiblocks.multiblock.MultiblockTileEntityBase;
import com.tgame.apptherm.multiblocks.LiquidCoolerControllerBase;

public class TileEntityLiquidCoolingCasing extends MultiblockTileEntityBase {

	@Override
	public boolean isGoodForFrame() {
		return true;
	}

	@Override
	public boolean isGoodForSides() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isGoodForTop() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isGoodForBottom() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isGoodForInterior() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onMachineAssembled(
			MultiblockControllerBase multiblockControllerBase) {

		worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, 1, 3);
	}

	@Override
	public void onMachineBroken() {
		worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, 0, 3);
	}

	@Override
	public Class<? extends MultiblockControllerBase> getMultiblockControllerType() {
		return LiquidCoolerControllerBase.class;
	}

	@Override
	public void onMachineActivated() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onMachineDeactivated() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MultiblockControllerBase createNewMultiblock() {
		return new LiquidCoolerControllerBase(worldObj);
	}

}
