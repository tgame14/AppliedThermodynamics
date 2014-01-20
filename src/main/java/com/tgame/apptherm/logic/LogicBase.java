package com.tgame.apptherm.logic;

import net.minecraft.nbt.NBTTagCompound;
import appeng.api.me.util.IGridCache;
import appeng.api.me.util.IGridInterface;

/**
 * The Class LogicBase.
 * 
 * @author tgame14
 */
public class LogicBase implements IGridCache {

	/** The ticked boolean, used to do stuff in the first tick of creation. */
	private boolean ticked;

	/** The effects Object. */
	private HeatEffects effects;

	/** The calculation logic Object. */
	protected LogicCalc calc;

	/** The cool logic Object. */
	protected LogicCool coolLogic;

	private double totalCoolant;

	/** The final heat after all calculations. */
	private double finalHeat;

	/**
	 * Instantiates a new logic base instance (an new Logic Grid).
	 */
	public LogicBase() {
		ticked = false;

		finalHeat = 0;
		totalCoolant = 0;

	}

	public double getFinalHeat() {
		return finalHeat;
	}

	public double getTotalCoolingValue() {
		return totalCoolant;
	}

	@Override
	public void onUpdateTick(IGridInterface grid) {
		// KEEP NOTICE, THIS WILL BE MOVED TO CONSTRUCTOR IN AE2
		if (!ticked && grid != null) {

			calc = new LogicCalc(grid);
			effects = new HeatEffects(grid, calc);
			coolLogic = new LogicCool(grid, calc);

			totalCoolant = coolLogic.calcTotalCoolant();

			ticked = true;
		}

		if (ticked) {
			finalHeat = calc.calcFinalHeat(calc.calcRawHeat(),
					coolLogic.calcTotalCoolant());

			effects.OnOverHeat(finalHeat);
		}
		
	}

	/**
	 * Every time the network is reset this is called. Maintaining of counts and
	 * lists and grids are done here.
	 * 
	 */
	@Override
	public void reset(IGridInterface grid) {
		if (calc != null)
			calc.refreshProperties(grid);

		if (coolLogic != null) {
			coolLogic.refreshCoolants();
			totalCoolant = coolLogic.calcTotalCoolant();
		}

		if (effects != null)
			effects.refreshHeatEffects(grid, calc);

	}

	@Override
	public String getCacheName() {
		return "MadHeatPoweredBandit";
	}

	@Override
	public NBTTagCompound savetoNBTData() {
		NBTTagCompound tag = new NBTTagCompound();

		tag.setDouble("heatFinalPercent", finalHeat);
		tag.setDouble("totalCoolant", totalCoolant);

		return tag;
	}

	@Override
	public void loadfromNBTData(NBTTagCompound data) {
		finalHeat = data.getDouble("heatFinalPercent");
		totalCoolant = data.getDouble("totalCoolant");

	}

}
