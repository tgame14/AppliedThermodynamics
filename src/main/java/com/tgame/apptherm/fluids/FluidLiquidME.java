package com.tgame.apptherm.fluids;

import net.minecraftforge.fluids.Fluid;

import com.tgame.apptherm.blocks.BlockInfo;

public class FluidLiquidME extends Fluid {

	public FluidLiquidME(String fluidName) {
		super(fluidName);
		this.setBlockID(BlockInfo.LIQUID_ME_ID);
		this.setDensity(5000);
		this.setTemperature(372);
		this.setViscosity(15000);
		
	}

	

	
	
	
	

}
