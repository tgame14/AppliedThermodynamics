package com.tgame.apptherm.tileentities.fanbox;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidHandler;

import com.tgame.apptherm.fluids.tanks.FluidTileTank;
import com.tgame.apptherm.libs.multiblocks.multiblock.MultiblockControllerBase;
import com.tgame.apptherm.libs.multiblocks.multiblock.MultiblockTileEntityBase;
import com.tgame.apptherm.multiblocks.FanBoxControllerBase;

public class TileEntityFluidPort extends MultiblockTileEntityBase implements
		IFluidHandler {

	private FanBoxControllerBase controller;

	public TileEntityFluidPort() {
		super();
	}

	@Override
	public int fill(ForgeDirection from, FluidStack resource, boolean doFill) {
		if (this.controller != null)
			return this.controller.fill(from, resource, doFill);
		return 0;
	}

	@Override
	public FluidStack drain(ForgeDirection from, FluidStack resource,
			boolean doDrain) {
		if (this.controller != null)
			return this.controller.drain(from, resource, doDrain);
		return null;
	}

	@Override
	public FluidStack drain(ForgeDirection from, int maxDrain, boolean doDrain) {
		if (this.controller != null)
			return this.controller.drain(from, maxDrain, doDrain);
		return null;
	}

	@Override
	public boolean canFill(ForgeDirection from, Fluid fluid) {
		if (this.controller != null)
			return this.controller.canFill(from, fluid);
		return true;
	}

	@Override
	public boolean canDrain(ForgeDirection from, Fluid fluid) {
		if (this.controller != null)
			return this.controller.canDrain(from, fluid);
		return true;
	}

	@Override
	public FluidTankInfo[] getTankInfo(ForgeDirection from) {
		if (this.controller != null)
			return this.controller.getTankInfo(from);
		return null;
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
		this.controller = (FanBoxControllerBase) multiblockControllerBase;

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
		return new FanBoxControllerBase(worldObj);
	}

	@Override
	public void writeToNBT(NBTTagCompound tag) {
		super.writeToNBT(tag);
	}

	@Override
	public void readFromNBT(NBTTagCompound tag) {
		super.readFromNBT(tag);
	}

}
