package com.tgame.apptherm.fluids;

import net.minecraftforge.fluids.FluidEvent;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidTank;

public class FanBoxTank implements IFluidTank {

	protected FluidStack fluid;
	protected int capacity;

	public boolean isEmpty() {
		if (this.fluid == null || this.fluid.amount == 0)
			return true;
		return false;
	}

	@Override
	public FluidStack getFluid() {
		return this.fluid;
	}

	@Override
	public int getFluidAmount() {
		return this.fluid.amount;
	}

	@Override
	public int getCapacity() {
		return this.capacity;
	}

	@Override
	public FluidTankInfo getInfo() {
		return new FluidTankInfo(this);
	}

	@Override
	public int fill(FluidStack resource, boolean doFill) {
		if (resource == null) {
			return 0;
		}

		if (!doFill) {

			if (this.fluid == null) {
				return Math.min(this.capacity, resource.amount);
			}

			if (!this.fluid.isFluidEqual(resource)) {
				return 0;
			}

			return Math.min(this.capacity - this.fluid.amount, resource.amount);
		}

		if (this.fluid == null) {
			this.fluid = new FluidStack(resource, Math.min(capacity,
					resource.amount));

			return this.fluid.amount;
		}

		if (!this.fluid.isFluidEqual(resource)) {
			return 0;
		}

		int filled = this.capacity - this.fluid.amount;

		if (resource.amount < filled) {
			this.fluid.amount += resource.amount;
			filled = resource.amount;
		} else {
			this.fluid.amount = this.capacity;
		}

		return filled;
	}

	@Override
	public FluidStack drain(int maxDrain, boolean doDrain) {
		if (this.fluid == null) {
			return null;
		}

		int drained = maxDrain;
		if (this.fluid.amount < drained) {
			drained = this.fluid.amount;
		}

		FluidStack stack = new FluidStack(this.fluid, drained);
		if (doDrain) {
			this.fluid.amount -= drained;
			if (this.fluid.amount <= 0) {
				this.fluid = null;
			}

		}
		return stack;
	}

}
