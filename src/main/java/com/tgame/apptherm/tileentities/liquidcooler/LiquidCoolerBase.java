package com.tgame.apptherm.tileentities.liquidcooler;

import com.tgame.apptherm.libs.multiblocks.multiblock.MultiblockControllerBase;
import com.tgame.apptherm.libs.multiblocks.multiblock.MultiblockTileEntityBase;
import com.tgame.apptherm.multiblocks.LiquidCoolerControllerBase;

public abstract class LiquidCoolerBase extends MultiblockTileEntityBase {

	@Override
	public Class<? extends MultiblockControllerBase> getMultiblockControllerType() {
		return LiquidCoolerControllerBase.class;
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
		return new LiquidCoolerControllerBase(this.worldObj);
	}

}
