package com.tgame.apptherm.multiblocks.handlers;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.FluidTankInfo;

import com.tgame.apptherm.blocks.BlockInfo;
import com.tgame.apptherm.fluids.FluidMECoolant;
import com.tgame.apptherm.fluids.Fluids;
import com.tgame.apptherm.fluids.tanks.MultiblockTank;

/**
 * This is the handler for the Fluids in The Advanced Liquid cooler Multiblock.
 * 
 * A simple handler to drain while machine is active, and fill when filled
 * 
 * @author tgame14
 * 
 */
public class LiquidCoolerFluidHandler {

	protected MultiblockTank tank;
	protected FluidStack meCoolant;

	public LiquidCoolerFluidHandler(int countOfExchange) {
		this.tank = new MultiblockTank(16000);
		this.meCoolant = new FluidStack(Fluids.meCoolant, 10 + (countOfExchange * 5));
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

	public boolean canDrain(ForgeDirection from, Fluid fluid) {
		return true;
	}

	public boolean canFill(ForgeDirection from, Fluid fluid) {
		if(fluid != null && fluid.getID() == this.meCoolant.fluidID)
			return true;
		return false;
	}

	public FluidTankInfo[] getTankInfo(ForgeDirection from) {
		return new FluidTankInfo[] { this.tank.getInfo() };
	}
	
	public NBTTagCompound writeToNBT(NBTTagCompound tag) {
		return this.tank.writeToNBT(tag);
	}
	
	public void readFromNBT(NBTTagCompound tag) {
		this.tank = this.tank.readFromNBT(tag);
	}
	
	public boolean isEmpty() {
		return this.tank.isEmpty();
	}
}
