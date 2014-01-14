package com.tgame.apptherm.multiblocks.handlers;

import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.FluidTankInfo;

import com.tgame.apptherm.fluids.Fluids;
import com.tgame.apptherm.fluids.tanks.MultiblockTank;

/**
 * This is the handler for the Fluids in The Advanced Liquid cooler Multiblock.
 * 
 * here for posterity at the moment. Advanced Liquid Cooler is on hold.
 * 
 * @author tgame14
 * 
 */
public class LiquidCoolerFluidHandler {

	protected MultiblockTank tank;
	protected FluidStack meCoolant;
	
	public LiquidCoolerFluidHandler(int countOfTanks, int countOfExchange) {
		this.tank = new MultiblockTank(countOfTanks);
		this.meCoolant = new FluidStack(Fluids.meCoolant, 1 + countOfExchange);
	}

	/**
	 * 
	 * @return boolean a boolean representing on whether or not there is a need
	 *         to save changes to multiblocks
	 */
	public boolean onUpdateServer() {
		
		
		return false;
	}

	public int fill(ForgeDirection from, FluidStack resource, boolean doFill) {
		return 0;
	}

	public FluidStack drain(ForgeDirection from, FluidStack resource,
			boolean doDrain) {
		// TODO Auto-generated method stub
		return null;
	}

	public FluidStack drain(ForgeDirection from, int maxDrain, boolean doDrain) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean canFill(ForgeDirection from, Fluid fluid) {
		FluidStack stack = new FluidStack(Fluids.meCoolant, 1);

		if (stack.isFluidEqual(new FluidStack(fluid, 1)))
			return true;
		return false;

	}

	public boolean canDrain(ForgeDirection from, Fluid fluid) {
		return false;
	}

	public FluidTankInfo[] getTankInfo(ForgeDirection from) {
		return new FluidTankInfo[] { this.tank.getInfo() };
	}
}
