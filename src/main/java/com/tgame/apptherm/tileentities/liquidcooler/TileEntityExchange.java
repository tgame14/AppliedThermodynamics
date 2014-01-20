package com.tgame.apptherm.tileentities.liquidcooler;

import com.tgame.apptherm.libs.multiblocks.multiblock.MultiblockControllerBase;
import com.tgame.apptherm.libs.multiblocks.multiblock.MultiblockTileEntityBase;
import com.tgame.apptherm.multiblocks.LiquidCoolerControllerBase;

public class TileEntityExchange extends MultiblockTileEntityBase {

	@Override
	public Class<? extends MultiblockControllerBase> getMultiblockControllerType() {
		return LiquidCoolerControllerBase.class;
	}

	@Override
	public boolean isGoodForFrame() {
		// TODO Auto-generated method stub
		return false;
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
		return true;
	}

	@Override
	public void onMachineAssembled(
			MultiblockControllerBase multiblockControllerBase) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onMachineBroken() {
		// TODO Auto-generated method stub

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
