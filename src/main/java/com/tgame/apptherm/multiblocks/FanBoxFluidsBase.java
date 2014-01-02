package com.tgame.apptherm.multiblocks;

import java.util.Set;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidHandler;

import com.tgame.apptherm.fluids.FluidTileTank;
import com.tgame.apptherm.fluids.CoolingFluids;
import com.tgame.apptherm.libs.multiblocks.common.CoordTriplet;

public class FanBoxFluidsBase {

	private FluidTileTank tank;

	public FanBoxFluidsBase(Set<CoordTriplet> setOfInternalTanks) {
		this.tank = new FluidTileTank(setOfInternalTanks.size() * 8000);

	}

	public int fill(ForgeDirection from, FluidStack resource, boolean doFill) {
		String attemptFluidName = resource.getFluid().getName();

		if (resource.isFluidEqual(this.tank.getFluid()))
			return this.tank.fill(resource, doFill);

		return this.tank.fill(resource, doFill);
	}

	public FluidStack drain(ForgeDirection from, FluidStack resource,
			boolean doDrain) {
		if (resource == null || !resource.isFluidEqual(tank.getFluid()))
			return null;

		return this.drain(from, resource.amount, doDrain);
	}

	public FluidStack drain(ForgeDirection from, int maxDrain, boolean doDrain) {
		return this.tank.drain(maxDrain, doDrain);
	}

	public boolean canFill(ForgeDirection from, Fluid fluid) {
		return true;
	}

	public boolean canDrain(ForgeDirection from, Fluid fluid) {
		return true;
	}

	public FluidTankInfo[] getTankInfo(ForgeDirection from) {
		return new FluidTankInfo[] { tank.getInfo() };
	}

	public void writeToNBT(NBTTagCompound tag) {
		this.tank.readFromNBT(tag);

	}

	public void readFromNBT(NBTTagCompound tag) {
		this.tank.writeToNBT(tag);
	}

}
