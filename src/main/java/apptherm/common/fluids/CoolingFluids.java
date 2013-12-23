package apptherm.common.fluids;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

public enum CoolingFluids {

	/** The water. */
	WATER(500, "water"),
	/** The seedoil. */
	SEEDOIL(3, "seedoil"),
	/** The honey. */
	HONEY(2, "honey"),
	/** The ice. */
	ICE(3, "ice"),
	/** The shortmead. */
	SHORTMEAD(1, "short.mead"),
	/** The fuel. */
	FUEL(3, "fuel");

	/** The consume per tick. */
	public final int consumePerTick;

	/** The fluid name. */
	public final String fluidName;

	public static final CoolingFluids[] VALID_FLUIDS = { WATER, SEEDOIL, HONEY,
			ICE, SHORTMEAD, FUEL };

	/**
	 * Instantiates a new cooling fluids.
	 * 
	 * @param consume
	 *            the consume
	 * @param fluid
	 *            the fluid
	 */
	private CoolingFluids(int consume, String fluid) {
		this.consumePerTick = consume;
		this.fluidName = fluid;
	}

}
