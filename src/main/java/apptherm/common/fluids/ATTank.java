package apptherm.common.fluids;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;
import apptherm.common.tileentities.TileEntityLiquidCooler;

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
	public int fill(FluidStack resource, boolean doFill) {
		if(doFill && this.getFluid() == null) {
			if(this.tile instanceof TileEntityLiquidCooler) {
				
			}
		}
		
		
		
		
		return super.fill(resource, doFill);
	}
}