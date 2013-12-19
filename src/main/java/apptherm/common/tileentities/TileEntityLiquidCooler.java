package apptherm.common.tileentities;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidHandler;
import apptherm.common.fluids.ATTank;
import apptherm.common.fluids.CoolingFluids;

public class TileEntityLiquidCooler extends AEActiveCoolants implements
		IFluidHandler {

	protected ATTank tank = new ATTank(16000);
	private int drainValue;

	public TileEntityLiquidCooler() {
		this.drainValue = 2;

	}
	
	@Override
	public void updateEntity() {
		if(!worldObj.isRemote) {
			if(!this.tank.isEmpty()) {
				this.drain(ForgeDirection.UP, this.drainValue, true);
				
				
				
				
			}
		}		
		
	}

	@Override
	public int fill(ForgeDirection from, FluidStack resource, boolean doFill) {
		if (this.tank.isEmpty()) {
			String attemptFluidName = resource.getFluid().getName();

			for (CoolingFluids dir : CoolingFluids.VALID_FLUIDS)
				if (dir.fluidName.equalsIgnoreCase(attemptFluidName)) {
					this.drainValue = dir.consumePerTick;
					return this.tank.fill(resource, doFill);
				}

		} else {
			return 0;
		}
		
		return this.tank.fill(resource, doFill);
	}

	@Override
	public FluidStack drain(ForgeDirection from, FluidStack resource,
			boolean doDrain) {
		if (resource == null || !resource.isFluidEqual(tank.getFluid())) {
			return null;
		}

		return this.drain(from, resource.amount, doDrain);
	}

	@Override
	public FluidStack drain(ForgeDirection from, int maxDrain, boolean doDrain) {
		return this.tank.drain(maxDrain, doDrain);
	}

	@Override
	public boolean canFill(ForgeDirection from, Fluid fluid) {
		return true;
	}

	@Override
	public boolean canDrain(ForgeDirection from, Fluid fluid) {
		return true;
	}

	@Override
	public void readFromNBT(NBTTagCompound tag) {
		super.readFromNBT(tag);
		tank.writeToNBT(tag);
	}

	@Override
	public void writeToNBT(NBTTagCompound tag) {
		super.writeToNBT(tag);
		tank.readFromNBT(tag);
	}

	@Override
	public FluidTankInfo[] getTankInfo(ForgeDirection from) {
		return new FluidTankInfo[] { tank.getInfo() };
	}

}
