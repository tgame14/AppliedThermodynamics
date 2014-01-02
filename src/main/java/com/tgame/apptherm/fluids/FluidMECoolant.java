package com.tgame.apptherm.fluids;

import com.tgame.apptherm.blocks.BlockInfo;

import net.minecraftforge.fluids.Fluid;

public class FluidMECoolant extends Fluid {

	public FluidMECoolant() {
		super("MECoolant");
		
		this.setUnlocalizedName(FluidInfo.COOLANT_UNLOCALIZED_NAME);
		this.setViscosity(5000);
		this.setTemperature(60);
		this.setBlockID(BlockInfo.COOLANT_ID);
		
	}

}
