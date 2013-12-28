package com.tgame.apptherm.tileentities;

import appeng.api.me.tiles.IGridTileEntity;
import appeng.api.me.tiles.ITileCable;

import com.tgame.apptherm.lib.multiblocks.multiblock.MultiblockControllerBase;
import com.tgame.apptherm.lib.multiblocks.multiblock.MultiblockTileEntityBase;
import com.tgame.apptherm.multiblocks.FanBoxController;

public class TileEntityHeatVent extends MultiblockTileEntityBase implements IGridTileEntity {
	
	public TileEntityHeatVent() {
		
	}

	@Override
	public Class<? extends MultiblockControllerBase> getMultiblockControllerType() {
		return FanBoxController.class;
		
	}

	@Override
	public boolean isGoodForFrame() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isGoodForSides() {
		return true;
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
		return new FanBoxController(this.worldObj);
	}

}
