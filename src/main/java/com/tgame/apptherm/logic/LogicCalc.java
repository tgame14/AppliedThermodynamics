package com.tgame.apptherm.logic;

import java.util.List;

import appeng.api.TileRef;
import appeng.api.exceptions.AppEngTileMissingException;
import appeng.api.me.tiles.ICellContainer;
import appeng.api.me.tiles.IGridMachine;
import appeng.api.me.util.IGridInterface;

import com.tgame.apptherm.tileentities.TileEntityLiquidCooler;

/**
 * @author tgame14
 * 
 */
public class LogicCalc {

	private IGridInterface grid;
	private List<TileRef<IGridMachine>> machineList;

	protected LogicCalc(IGridInterface gi) {
		grid = gi;
		machineList = grid.getMachines();

	}

	protected void refreshProperties(IGridInterface gi) {
		grid = gi;
		machineList = grid.getMachines();
	}

	protected float calcRawHeat() {
		float raw = (grid.getPowerUsageAvg() / 2) / 100;
		return raw;
	}

	protected int calcAmountOfMachine(TileRef tile) {
		int count = 0;
		Object te = null;
		try {
			te = tile.getTile();

		}
		catch (AppEngTileMissingException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < machineList.size(); i++) {
			if (machineList.get(i) == tile) {
				count++;
			}

		}
		return count;
	}

	protected int calcAmountOfTiles(Class clazz) {
		int count = 0;

		Object tile = null;

		for (int i = 0; i < machineList.size(); i++) {
			try {
				tile = machineList.get(i).getTile();
			}
			catch (AppEngTileMissingException e) {
				e.printStackTrace();
			}
			if (clazz.isInstance(tile))
				count++;
		}

		return count;

	}
	
	protected int calcAmountOfLiquiCoolants() {
		int count = 0;
		
		Object tile = null;
		TileEntityLiquidCooler telc;
		
		for(int i = 0; i < machineList.size(); i++) {
			try {
				tile = machineList.get(i).getTile();
			}
			catch (AppEngTileMissingException e) {
				e.printStackTrace();
			}
			
			if(tile instanceof TileEntityLiquidCooler) {
				telc = (TileEntityLiquidCooler) tile;
				
				if(telc.getIsActive())
					count++;
			}
		}
		
		return count;
	}

	protected float calcFinalHeat(double rawHeat, double coolant) {

		return (float) (rawHeat - coolant);
	}

	protected boolean isBareBones() {

		for (int i = 0; i < machineList.size(); i++) {
			if (!(isSafeFromMelt(machineList.get(i)))) {
				return false;
			}
		}
		return true;
	}

	protected boolean isSafeFromMelt(TileRef tile) {
		Object te = null;

		try {
			te = tile.getTile();
		}
		catch (AppEngTileMissingException e) {
			e.printStackTrace();
		}

		if (te instanceof ICellContainer || te == grid.getController()) {
			return true;
		}
		return false;
	}

	protected float calcHeatIntake(double finalHeatValue) {
		return (float) (finalHeatValue * grid.getPowerUsageAvg());

	}

}
