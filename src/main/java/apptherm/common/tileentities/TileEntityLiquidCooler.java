package apptherm.common.tileentities;

import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidHandler;
import apptherm.common.logic.CoolingFluids;

public class TileEntityLiquidCooler extends AEActiveCoolants implements IFluidHandler {

	protected FluidTank tank = new FluidTank(16000);
	private int drainValue;
	private FluidStack prevFluid;

	public TileEntityLiquidCooler() {
		drainValue = 2;
	}

	@Override
	public void updateEntity() {
		if (!worldObj.isRemote && isMachineActive()) {

			if (tank.drain(drainValue, true) == null) {
				setIsActive(false);
			}
			else {
				setIsActive(true);
			}

			System.out.println(isActive);
			System.out.println(drainValue);
		}
	}

	@Override
	public int fill(ForgeDirection from, FluidStack resource, boolean doFill) {
		if (resource == null || (tank.getFluid() != null && resource.fluidID != tank.getFluid().fluidID))
			return 0;

		FluidStack coldfluid = null;
		int fluidDrain = 0;

		for (CoolingFluids dir : CoolingFluids.VALID_FLUIDS) {
			coldfluid = FluidRegistry.getFluidStack(dir.fluidName, resource.amount);

			if (coldfluid == null)
				return 0;

			if (resource.isFluidEqual(coldfluid)) {
				coldfluid = resource;
				fluidDrain = dir.consumePerTick;
			}
			coldfluid = resource;
		}
		coldfluid = resource;

		if (prevFluid != null && !resource.isFluidEqual(prevFluid))
			drainValue = fluidDrain;

		prevFluid = resource;
		return tank.fill(resource, doFill);
	}

	@Override
	public FluidStack drain(ForgeDirection from, FluidStack resource, boolean doDrain) {
		if (tank.getFluid() == null)
			return null;

		return tank.drain(resource.amount, doDrain);
	}

	@Override
	public FluidStack drain(ForgeDirection from, int maxDrain, boolean doDrain) {
		if (tank.getFluid() == null)
			return null;

		return drain(from, new FluidStack(tank.getFluid(), maxDrain), doDrain);
	}

	@Override
	public boolean canFill(ForgeDirection from, Fluid fluid) {
		return tank.getFluid() == null || tank.getFluid().getFluid() == fluid;
	}

	@Override
	public boolean canDrain(ForgeDirection from, Fluid fluid) {
		return tank.getFluid() == null || tank.getFluid().getFluid() == fluid;
	}

	@Override
	public FluidTankInfo[] getTankInfo(ForgeDirection from) {
		return new FluidTankInfo[] { tank.getInfo() };
	}
}
