package com.tgame.apptherm.tileentities.fanbox;

import net.minecraft.world.World;
import appeng.api.WorldCoord;
import appeng.api.me.tiles.IGridTileEntity;
import appeng.api.me.tiles.ITileCable;
import appeng.api.me.util.IGridInterface;

import com.tgame.apptherm.libs.multiblocks.multiblock.MultiblockControllerBase;
import com.tgame.apptherm.libs.multiblocks.multiblock.MultiblockTileEntityBase;
import com.tgame.apptherm.multiblocks.FanBoxControllerBase;

public class TileEntityHeatVent extends MultiblockTileEntityBase {
	
	public TileEntityHeatVent() {
		super();
	}

	@Override
	public Class<? extends MultiblockControllerBase> getMultiblockControllerType() {
		return FanBoxControllerBase.class;
		
	}

	@Override
	public boolean isGoodForFrame() {
		return false;
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
	public void onMachineActivated() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onMachineDeactivated() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MultiblockControllerBase createNewMultiblock() {
		return new FanBoxControllerBase(this.worldObj);
	}
	
}
