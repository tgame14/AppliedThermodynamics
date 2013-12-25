package com.tgame.apptherm.tileentities;

import com.tgame.apptherm.fluids.ATTank;
import com.tgame.apptherm.fluids.CoolingFluids;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidHandler;

public class TileEntityLiquidCooler extends AEActiveCoolants implements
		IFluidHandler {

	protected ATTank tank = new ATTank(16000);
	private int drainValue;
	private byte timer;

	public TileEntityLiquidCooler() {
		this.drainValue = 5;
		this.timer = 21;
	}

	@Override
	public void updateEntity() {
		if(this.timer <= 0) {
			this.drain(ForgeDirection.UNKNOWN, this.drainValue, true);
			this.timer = 21;
			
		}
		this.timer--;
		
	}

	@Override
	public int fill(ForgeDirection from, FluidStack resource, boolean doFill) {
		String attemptFluidName = resource.getFluid().getName();

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
		if (this.tank.getFluidAmount() == maxDrain)
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

}
