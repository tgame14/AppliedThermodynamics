package com.tgame.apptherm.tileentities;

import net.minecraft.world.World;
import appeng.api.WorldCoord;
import appeng.api.me.tiles.IGridTileEntity;
import appeng.api.me.tiles.ITileCable;
import appeng.api.me.util.IGridInterface;

import com.tgame.apptherm.libs.multiblocks.multiblock.MultiblockControllerBase;
import com.tgame.apptherm.libs.multiblocks.multiblock.MultiblockTileEntityBase;
import com.tgame.apptherm.multiblocks.FanBoxController;

public class TileEntityHeatVent extends MultiblockTileEntityBase {
	
	public TileEntityHeatVent() {
		
	}

	@Override
	public Class<? extends MultiblockControllerBase> getMultiblockControllerType() {
		return FanBoxController.class;
		
	}

	@Override
	public boolean isGoodForFrame() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isGoodForSides() {
		return true;
	}

	@Override
	public boolean isGoodForTop() {
		return true;
	}

	@Override
	public boolean isGoodForBottom() {
		return true;
	}

	@Override
	public boolean isGoodForInterior() {	
		return true;
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
		return new FanBoxController(this.worldObj);
	}
	
}
