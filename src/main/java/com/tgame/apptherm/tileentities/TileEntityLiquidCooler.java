package com.tgame.apptherm.tileentities;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidHandler;
import appeng.api.WorldCoord;
import appeng.api.events.GridTileLoadEvent;
import appeng.api.events.GridTileUnloadEvent;
import appeng.api.me.tiles.IGridMachine;
import appeng.api.me.util.IGridInterface;

import com.tgame.apptherm.fluids.CoolingFluids;
import com.tgame.apptherm.fluids.tanks.FluidTileTank;

public class TileEntityLiquidCooler extends AEActiveCoolants implements
		IFluidHandler, IGridMachine {

	protected FluidTileTank tank = new FluidTileTank(16000);
	private int drainValue;
	private byte timer;

	private boolean powerStatus, networkReady;
	private IGridInterface grid;

	public TileEntityLiquidCooler() {
		this.drainValue = 5;
		this.timer = 21;

		this.powerStatus = false;
		this.networkReady = false;
	}

	@Override
	public void updateEntity() {
		if (this.timer <= 0) {
			this.drain(ForgeDirection.UNKNOWN, this.drainValue, true);
			this.timer = 21;

		}
		this.timer--;

	}

	@Override
	public int fill(ForgeDirection from, FluidStack resource, boolean doFill) {
		String attemptFluidName = resource.getFluid().getName();

		if (resource.isFluidEqual(this.tank.getFluid()))
			return this.tank.fill(resource, doFill);

		for (CoolingFluids dir : CoolingFluids.VALID_FLUIDS)
			if (dir.fluidName.equalsIgnoreCase(attemptFluidName)) {
				this.drainValue = dir.consumePerTick;
				this.setIsActive(true);
				return this.tank.fill(resource, doFill);

			}
		this.setIsActive(true);
		return this.tank.fill(resource, doFill);
	}

	@Override
	public FluidStack drain(ForgeDirection from, FluidStack resource,
			boolean doDrain) {
		if (resource == null || !resource.isFluidEqual(tank.getFluid()))
			return null;

		return this.drain(from, resource.amount, doDrain);
	}

	@Override
	public FluidStack drain(ForgeDirection from, int maxDrain, boolean doDrain) {
		if (this.tank.getFluidAmount() <= maxDrain)
			this.setIsActive(false);

		return this.tank.drain(maxDrain, doDrain);
	}

	@Override
	public boolean canFill(ForgeDirection from, Fluid fluid) {
		return true;
	}

	@Override
	public boolean canDrain(ForgeDirection from, Fluid fluid) {
		return true;
	}

	@Override
	public void readFromNBT(NBTTagCompound tag) {
		this.timer = tag.getByte("secTimer");
		super.readFromNBT(tag);
		tank.writeToNBT(tag);
	}

	@Override
	public void writeToNBT(NBTTagCompound tag) {
		tag.setByte("secTimer", timer);
		super.writeToNBT(tag);
		tank.readFromNBT(tag);
	}

	@Override
	public FluidTankInfo[] getTankInfo(ForgeDirection from) {
		return new FluidTankInfo[] { tank.getInfo() };
	}

	@Override
	public void validate() {
		super.validate();
		MinecraftForge.EVENT_BUS.post(new GridTileLoadEvent(this,
				this.worldObj, getLocation()));
	}

	@Override
	public void invalidate() {
		super.invalidate();
		MinecraftForge.EVENT_BUS.post(new GridTileUnloadEvent(this,
				this.worldObj, getLocation()));
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
	public float getPowerDrainPerTick() {
		return 0;
	}

	@Override
	public void setNetworkReady(boolean isReady) {
		this.networkReady = isReady;

	}

	@Override
	public boolean isMachineActive() {
		if (this.networkReady && this.powerStatus)
			return true;
		return false;

	}

}
