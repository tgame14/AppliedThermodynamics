package com.tgame.apptherm.tileentities.fanbox;

import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import appeng.api.WorldCoord;
import appeng.api.events.GridTileLoadEvent;
import appeng.api.events.GridTileUnloadEvent;
import appeng.api.me.tiles.IGridMachine;
import appeng.api.me.util.IGridInterface;

import com.tgame.apptherm.libs.multiblocks.multiblock.MultiblockControllerBase;
import com.tgame.apptherm.libs.multiblocks.multiblock.MultiblockTileEntityBase;
import com.tgame.apptherm.multiblocks.FanBoxControllerBase;

public class TileEntityMEPort extends MultiblockTileEntityBase implements IGridMachine {

	private boolean powerStatus, networkReady;
	private IGridInterface grid;
	
	public TileEntityMEPort() {
		super();
		
		this.powerStatus = false;
		this.networkReady = false;
		
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
		return new FanBoxControllerBase(this.worldObj);
	}

	@Override
	public WorldCoord getLocation() {
		return new WorldCoord(xCoord, yCoord, zCoord);
	}

	@Override
	public boolean isValid() {
		return true;
	}

	@Override
	public void setPowerStatus(boolean hasPower) {
		this.powerStatus = hasPower;
		
	}

	@Override
	public boolean isPowered() {
		return this.powerStatus;
	}

	@Override
	public IGridInterface getGrid() {
		return this.grid;
	}

	@Override
	public void setGrid(IGridInterface gi) {
		this.grid = gi;
		
	}

	@Override
	public World getWorld() {
		return worldObj;
	}

	@Override
	public float getPowerDrainPerTick() {
		return 0;
	}

	@Override
	public void setNetworkReady(boolean isReady) {
		this.networkReady = isReady;
		
	}

	@Override
	public boolean isMachineActive() {
		if(powerStatus && networkReady)
			return true;
		return false;
	}
	
	@Override
	public void validate() {
		super.validate();
		MinecraftForge.EVENT_BUS.post(new GridTileLoadEvent(this, this.worldObj,
				getLocation()));
	}

	@Override
	public void invalidate() {
		super.invalidate();
		MinecraftForge.EVENT_BUS.post(new GridTileUnloadEvent(this, this.worldObj,
				getLocation()));

	}

}
