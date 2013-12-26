package com.tgame.apptherm.tileentities;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import appeng.api.WorldCoord;
import appeng.api.events.GridTileLoadEvent;
import appeng.api.events.GridTileUnloadEvent;
import appeng.api.me.tiles.IGridMachine;
import appeng.api.me.util.IGridInterface;

public abstract class AEBaseMachine extends TileEntity implements IGridMachine {

	protected boolean powerStatus;
	protected boolean networkReady;
	protected IGridInterface grid;

	public AEBaseMachine() {
		this.powerStatus = false;
		this.networkReady = false;
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
		return this.worldObj;

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
		if(this.networkReady && this.powerStatus)
			return true;
		return false;
		
	}
	
	@Override
	public void writeToNBT(NBTTagCompound tag) {
		tag.setBoolean("powerstatus", this.powerStatus);
		tag.setBoolean("networkReady", this.networkReady);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound tag) {
		this.powerStatus = tag.getBoolean("powerstatus");
		this.networkReady = tag.getBoolean("networkReady");
	}

}
