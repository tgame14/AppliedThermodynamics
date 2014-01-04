package com.tgame.apptherm.fluids.tanks;

import com.tgame.apptherm.tileentities.fanbox.TileEntityFluidPort;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;

public class FluidTileTank extends FluidTank {

	public FluidTileTank(int capacity) {
		this(null, capacity);
	}

	public FluidTileTank(FluidStack stack, int capacity) {
		super(stack, capacity);

	}

	public FluidTileTank(Fluid fluid, int amount, int capacity) {
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