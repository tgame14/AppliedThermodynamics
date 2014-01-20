package com.tgame.apptherm.logic;

import java.util.HashMap;
import java.util.Map;

import com.google.common.collect.Multimap;

import appeng.api.TileRef;
import appeng.api.exceptions.AppEngTileMissingException;
import appeng.api.me.util.IGridInterface;

import com.tgame.apptherm.tileentities.TileEntityLiquidCooler;
import com.tgame.apptherm.tileentities.TileEntitySimpleFan;
import com.tgame.apptherm.tileentities.liquidcooler.TileEntityHeatPort;

/**
 * The Class LogicCool, Does all the logic regarding different coolants.
 * 
 * coolants are split into two types, Active and Passive.
 * 
 * if a coolant is passive, it is always effective and working.
 * 
 * if its active, it has a active and non active state.
 * 
 * @author tgame14
 */
public class LogicCool {

	/** The grid. */
	private IGridInterface grid;

	/** The liquid Coolers count. */
	private int liquiCount;

	/** The air intakes count. */
	private int intakeCount;

	/** The total cooling value of all coolants. */
	private double coolingValue;

	/** The instance of LogicCalc from LogicBase. */
	private LogicCalc calc;
	
	private AdvancedCoolerHandler advCoolerHandler;

	/**
	 * Instantiates a new logic cool.
	 * 
	 * @param gi
	 *            the grid
	 * @param logicCalc
	 *            the logicCalc - instance of LogicCalc to give access to some
	 *            calculation methods.
	 */
	protected LogicCool(IGridInterface gi, LogicCalc logicCalc) {
		this.grid = gi;
		this.calc = logicCalc;

		this.coolingValue = 0;
		this.intakeCount = 0;
		this.liquiCount = 0;
		
		this.advCoolerHandler = new AdvancedCoolerHandler(grid);		

	}

	/**
	 * Refreshes the counts of entire coolants, should be called on whenever one
	 * of the coolant's state has changed or the network has been reset.
	 */
	protected void refreshCoolants() {
		refreshLiquiCount();
		intakeCount = calc.calcAmountOfTiles(TileEntitySimpleFan.class);
		
		advCoolerHandler = new AdvancedCoolerHandler(grid);
	}

	public void refreshLiquiCount() {
		liquiCount = calc
				.calcAmountOfActiveCoolants(TileEntityLiquidCooler.class);
	}

	/**
	 * this is where the math is done for calculation of coolants. it is based
	 * on mathematical equations that are the base for sets and such, Deeper
	 * explanation of the math behind it can be supplied from
	 * 
	 * See {@linktourl http://en.wikipedia.org/wiki/Geometric_progression}
	 * 
	 * @param int Amount of Active Coolants
	 * @param float percent decrease per machine (has to be < 1 )
	 * 
	 * @return float cooling value of coolant
	 */
	private double calcCoolantValue(int activeCoolants, float decrPercent,
			float firstDeminish) {
		if (activeCoolants < 1) {
			return 0;
		}
		float firstValue = firstDeminish;

		double totalCoolant = (firstValue * (1 - Math.pow(decrPercent,
				activeCoolants + 1))) / (1 - decrPercent);

		return totalCoolant;

	}

	protected double calcTotalCoolant() {
		double intakeCoolant = calcCoolantValue(intakeCount, 0.5F, 0.05F);
		double liquidCoolant = calcCoolantValue(liquiCount, 0.9F, 0.1F);
		
		double advCooler = this.advCoolerHandler.getTotalCooling() * 0.15F;

		this.coolingValue = intakeCoolant + liquidCoolant + advCooler;
		return coolingValue;

	}

	/**
	 * Gets the liquid coolers count.
	 * 
	 * @return the liquid coolers count
	 */
	protected int getLiquiCount() {
		return liquiCount;
	}

	/**
	 * Gets the air intakes count.
	 * 
	 * @return the air intakes count
	 */
	protected int getIntakeCount() {
		return intakeCount;
	}
	

}
