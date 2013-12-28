package com.tgame.apptherm.fluids;

import net.minecraftforge.fluids.Fluid;

public class FluidMECoolant extends Fluid {

	public FluidMECoolant(String fluidName) {
		super(fluidName);
		
		this.setUnlocalizedName(FluidInfo.COOLANT_UNLOCALIZED_NAME);
		
	}

}
