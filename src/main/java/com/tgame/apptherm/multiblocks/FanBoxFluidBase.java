package com.tgame.apptherm.multiblocks;

import java.util.Set;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidHandler;

import com.tgame.apptherm.fluids.FanBoxTank;
import com.tgame.apptherm.fluids.FluidTileTank;
import com.tgame.apptherm.fluids.CoolingFluids;
import com.tgame.apptherm.fluids.Fluids;
import com.tgame.apptherm.libs.multiblocks.common.CoordTriplet;

/**
 * This class handles all fluids going into and out of the Fan Box.
 * It should be considered as a meta-tile for all blocks in the Multiblock Structure.
 * Any new tile that handles fluids Should refer to this class for Handling.
 * 
 * @author tgame14
 *
 */
public class FanBoxFluidBase {

	private FanBoxTank tank;
	private FanBoxTank extTank;
	private FluidStack meCoolant;

	public FanBoxFluidBase(Set<CoordTriplet> setOfInternalTanks) {
		this.tank = new FanBoxTank(setOfInternalTanks.size() * 6000);
		this.extTank = new FanBoxTank(setOfInternalTanks.size() * 2000);
		
		this.meCoolant = new FluidStack(Fluids.meCoolant, 1);
	}
	
	public boolean onUpdateFluidHandler() {		
		if (!tank.isEmpty()) {
			this.tank.drain(4, true);
			this.extTank.fill(this.meCoolant, true);
		}
			
		
		
		return false;
	}

	public int fill(ForgeDirection from, FluidStack resource, boolean doFill) {
		String attemptFluidName = resource.getFluid().getName();

		if (resource.isFluidEqual(this.tank.getFluid()))
			return this.tank.fill(resource, doFill);

		return this.tank.fill(resource, doFill);
	}

	public FluidStack drain(ForgeDirection from, FluidStack resource,
			boolean doDrain) {
		if (resource == null || !resource.isFluidEqual(this.extTank.getFluid()))
			return null;

		return this.drain(from, resource.amount, doDrain);
	}

	public FluidStack drain(ForgeDirection from, int maxDrain, boolean doDrain) {
		return this.extTank.drain(maxDrain, doDrain);
	}

	public boolean canFill(ForgeDirection from, Fluid fluid) {
		return true;
	}

	public boolean canDrain(ForgeDirection from, Fluid fluid) {
		return true;
	}

	public FluidTankInfo[] getTankInfo(ForgeDirection from) {
		return new FluidTankInfo[] { tank.getInfo(), extTank.getInfo() };
	}

	public void writeToNBT(NBTTagCompound tag) {
		this.tank.readFromNBT(tag);
		this.extTank.readFromNBT(tag);

	}

	public void readFromNBT(NBTTagCompound tag) {
		this.tank.writeToNBT(tag);
		this.extTank.writeToNBT(tag);
	}

}
