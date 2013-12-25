package com.tgame.apptherm.fluids;

public enum CoolingFluids {

	WATER(500, "water"), SEEDOIL(3, "seedoil"), HONEY(2.5, "honey"), ICE(3, "ice"), SHORTMEAD(
			1, "short.mead"), FUEL(3, "fuel"), CRYOTHEUM(1, "cryotheum"), SEWAGE(
			600, "sewage"), FLUIDMEAT(0.3, "meat");

	public final double consumePerTick;
	public final String fluidName;

	public static final CoolingFluids[] VALID_FLUIDS = { WATER, SEEDOIL, HONEY,
			ICE, SHORTMEAD, FUEL, CRYOTHEUM, SEWAGE };

	/**
	 * Instantiates a new cooling fluids.
	 * 
	 * @param consume      the consume per tick of the fluid
	 * @param fluid
	 *            the fluid name to access registry
	 */
	private CoolingFluids(double consume, String fluid) {
		this.consumePerTick = consume;
		this.fluidName = fluid;
	}

}
