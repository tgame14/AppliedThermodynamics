package com.tgame.apptherm.fluids;

import com.tgame.apptherm.blocks.BlockInfo;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Fluids {

	public static Fluid fluidME;
	public static Fluid meCoolant;

	public static void init() {

		fluidME = new FluidLiquidME("fluidME");
		FluidRegistry.registerFluid(fluidME);
		
		meCoolant = new FluidMECoolant("MECoolant");
		FluidRegistry.registerFluid(meCoolant);

	}

	public static void addNames() {
		LanguageRegistry.addName(fluidME, BlockInfo.LIQUID_ME_NAME);
		LanguageRegistry.addName(meCoolant, BlockInfo.COOLANT_NAME);

	}

}
