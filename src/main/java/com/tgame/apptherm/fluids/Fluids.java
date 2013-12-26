package com.tgame.apptherm.fluids;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Fluids {

	public static Fluid fluidME;

	public static void init() {

		fluidME = new FluidLiquidME("fluidME");
		FluidRegistry.registerFluid(fluidME);

	}

	public static void addNames() {
		LanguageRegistry.addName(fluidME, "Liquid ME");

	}

}
