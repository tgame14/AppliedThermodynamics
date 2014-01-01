package com.tgame.apptherm.tileentities.fanbox;

import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidHandler;

import com.tgame.apptherm.fluids.ATTank;
import com.tgame.apptherm.libs.multiblocks.multiblock.MultiblockControllerBase;
import com.tgame.apptherm.libs.multiblocks.multiblock.MultiblockTileEntityBase;
import com.tgame.apptherm.multiblocks.FanBoxControllerBase;

public class TileEntityFluidPort extends MultiblockTileEntityBase implements IFluidHandler {
	
	private FanBoxControllerBase controller;
	
	public TileEntityFluidPort() {
		
	}
	
	
	
	
	@Override
	public int fill(ForgeDirection from, FluidStack resource, boolean doFill) {
		return this.controller.fill(from, resource, doFill);
	}

	@Override
	public FluidStack drain(ForgeDirection from, FluidStack resource,
			boolean doDrain) {
		return this.controller.drain(from, resource, doDrain);
	}

	@Override
	public FluidStack drain(ForgeDirection from, int maxDrain, boolean doDrain) {
		return this.controller.drain(from, maxDrain, doDrain);
	}

	@Override
	public boolean canFill(ForgeDirection from, Fluid fluid) {
		return this.controller.canFill(from, fluid);
	}

	@Override
	public boolean canDrain(ForgeDirection from, Fluid fluid) {
		return this.controller.canDrain(from, fluid);
	}

	@Override
	public FluidTankInfo[] getTankInfo(ForgeDirection from) {
		return this.controller.getTankInfo(from);
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

}
