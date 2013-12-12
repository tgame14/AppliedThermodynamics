package apptherm.common.fluids;

import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;
import apptherm.common.tileentities.TileEntityLiquidCooler;

public class ATTank extends FluidTank {

	protected TileEntityLiquidCooler telc = null;	

	public ATTank(int capacity,  TileEntityLiquidCooler te) {
		this(null, capacity, te);
	}

	public ATTank(FluidStack stack, int capacity,  TileEntityLiquidCooler te) {		
		super(stack, capacity);
		
		telc = te;
		
	}

	public ATTank(Fluid fluid, int amount, int capacity, TileEntityLiquidCooler te) {
		this(new FluidStack(fluid, amount), capacity, te);

	}
	
	@Override
	public int fill(FluidStack resource, boolean doFill) {
		if(resource.amount > 0 && doFill) {
			telc.setIsActive(true);
		}
		
		return super.fill(resource, doFill);
		
	}
	
	@Override
	public FluidStack drain(int maxDrain, boolean doDrain) {
		if(maxDrain == this.capacity && doDrain) {
			telc.setIsActive(false);
		}
		
		return super.drain(maxDrain, doDrain);
	}
	


}