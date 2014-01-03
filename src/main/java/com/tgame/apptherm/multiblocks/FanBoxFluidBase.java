package com.tgame.apptherm.multiblocks;

import java.util.Set;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTankInfo;

import com.tgame.apptherm.fluids.FanBoxTank;
import com.tgame.apptherm.fluids.Fluids;
import com.tgame.apptherm.libs.multiblocks.common.CoordTriplet;

/**
 * This class handles all fluids going into and out of the Fan Box. It should be
 * considered as a meta-tile Fluid Handler for all blocks in the Multiblock Structure. Any new
 * tile that handles fluids Should refer to this class for Handling through the Controller.
 * 
 * @author tgame14
 * 
 */
public class FanBoxFluidBase {

	protected FanBoxTank tank;
	protected FanBoxTank extTank;
	protected FluidStack meCoolant;

	public FanBoxFluidBase(Set<CoordTriplet> setOfInternalTanks) {
		this.tank = new FanBoxTank(setOfInternalTanks.size() * 6000);
		this.extTank = new FanBoxTank(setOfInternalTanks.size() * 2000);

		this.meCoolant = new FluidStack(Fluids.meCoolant, 1);
	}

	public boolean onUpdateServerTick() {
		if (!tank.isEmpty()) {
			this.tank.drain(4, true);
			this.extTank.fill(this.meCoolant, true);
			return true;
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

	public NBTTagCompound writeToNBT(NBTTagCompound tag) {		
		
		NBTTagCompound mainTank = new NBTTagCompound("fluidHandlerMain");
		NBTTagCompound extTank = new NBTTagCompound("fluidHandlerExt");
		
		this.tank.writeToNBT(mainTank);
		this.extTank.writeToNBT(extTank);
		
		tag.setCompoundTag(mainTank.getName(), mainTank);
		tag.setCompoundTag(extTank.getName(), extTank);
		
		return tag;
	}
	
	public void readFromNBT(NBTTagCompound tag) {
		NBTTagCompound mainTank = tag.getCompoundTag("fluidHandlerMain");
		NBTTagCompound extTank = tag.getCompoundTag("fluidHandlerExt");
		
		this.tank.readFromNBT(mainTank);
		this.extTank.readFromNBT(extTank);
	}

}
