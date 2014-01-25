package com.tgame.apptherm.logic;

import appeng.api.me.util.IGridInterface;

import com.tgame.apptherm.tileentities.TileEntityLiquidCooler;
import com.tgame.apptherm.tileentities.TileEntitySimpleFan;

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

	/** The total cooling value of all coolants. */
	private double coolingValue;

	/** The instance of LogicCalc from LogicBase. */
	private LogicCalc calc;
	
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
	@Deprecated
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
		LogicMap map = (LogicMap) grid.getCacheByID(LogicInfo.mapCacheID);
		double value = map.sumCooling();

		this.coolingValue = value;
		return coolingValue;

	}	

}
