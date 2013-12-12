package apptherm.common.logic;

import net.minecraft.tileentity.TileEntity;
import appeng.api.TileRef;
import appeng.api.me.util.IGridInterface;
import apptherm.common.tileentities.TileEntityAirIntake;
import apptherm.common.tileentities.TileEntityLiquidCooler;

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

	private TileEntityLiquidCooler TileLiquidCooler;

	private TileEntityAirIntake TileAirIntake;

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
		grid = gi;
		calc = logicCalc;

		TileLiquidCooler = new TileEntityLiquidCooler();
		TileAirIntake = new TileEntityAirIntake();

	}

	/**
	 * Refreshes the counts of entire coolants, should be called on whenever one
	 * of the coolant's state has changed or the network has been reset.
	 */
	protected void refreshCoolants() {
		refreshLiquiCount();
		intakeCount = calc.calcAmountOfTiles(TileAirIntake.getClass());
	}
	
	public void refreshLiquiCount() {
		liquiCount = calc.calcAmountOfLiquiCoolants();
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
	private double calcCoolantValue(int activeCoolants, float decrPercent, float firstDeminish) {
		if (activeCoolants < 1) {
			return 0;
		}
		float firstValue = calc.calcRawHeat() * firstDeminish;

		double totalCoolant = (firstValue * (1 - Math.pow(decrPercent, activeCoolants))) / (1 - decrPercent);

		return totalCoolant;

	}

	protected double calcTotalCoolant() {
		double intakeCoolant = calcCoolantValue(intakeCount, 0.6F, 0.05F);
		double liquidCoolant = calcCoolantValue(liquiCount, 0.9F, 0.1F);

		coolingValue = intakeCoolant + liquidCoolant;
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
