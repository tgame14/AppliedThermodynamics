package com.tgame.apptherm.fluids;

public enum CoolingFluids {

	WATER(10000, "water"), SEEDOIL(70, "seedoil"), HONEY(80, "honey"), ICE(150, "ice"), SHORTMEAD(
			60, "short.mead"), FUEL(200, "fuel"), CRYOTHEUM(60, "cryotheum"), SEWAGE(
			6000, "sewage"), FLUIDMEAT(100, "meat"), MECoolant(30, "MECoolant");

	public final int consumePerTick;
	public final String fluidName;

	public static final CoolingFluids[] VALID_FLUIDS = { WATER, SEEDOIL, HONEY,
			ICE, SHORTMEAD, FUEL, CRYOTHEUM, SEWAGE };

	/**
	 * Instantiates a new cooling fluids enum.
	 * 
	 * @param consume: the consume per tick of the fluid
	 * @param fluid: the fluid name to access registry
	 */
	private CoolingFluids(int consume, String fluid) {
		this.consumePerTick = consume;
		this.fluidName = fluid;
	}

}
