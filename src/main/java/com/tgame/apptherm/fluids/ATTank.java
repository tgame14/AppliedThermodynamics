package com.tgame.apptherm.fluids;

import com.tgame.apptherm.tileentities.TileEntityLiquidCooler;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;

public class ATTank extends FluidTank {

	public ATTank(int capacity) {
		this(null, capacity);
	}

	public ATTank(FluidStack stack, int capacity) {
		super(stack, capacity);

	}

	public ATTank(Fluid fluid, int amount, int capacity) {
		this(new FluidStack(fluid, amount), capacity);
	}
	
	
	

	@Override
	public FluidTank readFromNBT(NBTTagCompound nbt) {
		if (!nbt.hasKey("Empty")) {
			FluidStack fluid = FluidStack.loadFluidStackFromNBT(nbt);
			setFluid(fluid);
		} else {
			setFluid(null);
		}
		return this;
	}

	public boolean isEmpty() {
		if (this.getFluidAmount() == 0)
			return true;
		return false;
	}
}