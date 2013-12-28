package com.tgame.apptherm.tileentities;

import com.tgame.apptherm.lib.multiblocks.multiblock.MultiblockControllerBase;
import com.tgame.apptherm.lib.multiblocks.multiblock.MultiblockTileEntityBase;
import com.tgame.apptherm.multiblocks.FanBoxController;

public class TileEntityFanBoxCasing extends MultiblockTileEntityBase {

	@Override
	public Class<? extends MultiblockControllerBase> getMultiblockControllerType() {
		return FanBoxController.class;
	}

	@Override
	public boolean isGoodForFrame() {
		return true;
	}

	@Override
	public boolean isGoodForSides() {
		return false;
	}

	@Override
	public boolean isGoodForTop() {
		return false;
	}

	@Override
	public boolean isGoodForBottom() {
		return false;
	}

	@Override
	public boolean isGoodForInterior() {
		return false;
	}

	@Override
	public void onMachineAssembled(
			MultiblockControllerBase multiblockControllerBase) {
		
		
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
		// TODO Auto-generated method stub
		return null;
	}

}
