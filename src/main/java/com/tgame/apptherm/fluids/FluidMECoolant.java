package com.tgame.apptherm.fluids;

import com.tgame.apptherm.blocks.BlockInfo;

import net.minecraftforge.fluids.Fluid;

public class FluidMECoolant extends Fluid {

	public FluidMECoolant(String fluidID) {
		super(fluidID);
		
		this.setViscosity(5000);
		this.setTemperature(60);
		this.setBlockID(BlockInfo.COOLANT_ID);
		
	}

}
