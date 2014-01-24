package com.tgame.apptherm.logic;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.nbt.NBTTagCompound;
import appeng.api.DimentionalCoord;
import appeng.api.TileRef;
import appeng.api.exceptions.AppEngTileMissingException;
import appeng.api.me.tiles.IGridMachine;
import appeng.api.me.util.IGridCache;
import appeng.api.me.util.IGridInterface;

import com.tgame.apptherm.api.tiles.IATCoolantMachine;

/**
 * A IGridCache that maps out all machines that are coolants This allows for
 * better implementation not requiring Edits to IGridCaches
 * 
 * 
 * @author tgame14
 * 
 */
public class LogicMap implements IGridCache {

	protected Map<DimentionalCoord, IATCoolantMachine> coordMap;
	private boolean ticked;

	public LogicMap() {
		this.coordMap = new HashMap<DimentionalCoord, IATCoolantMachine>();
		this.ticked = false;
	}

	private void mapGrid(IGridInterface grid) {

		for (TileRef<IGridMachine> mach : grid.getMachines()) {
			IATCoolantMachine candidate;
			try {
				IGridMachine tile = mach.getTile();

				if (tile instanceof IATCoolantMachine) {
					candidate = (IATCoolantMachine) mach;
					coordMap.put(mach.getCoord(), candidate);

				}

			} catch (AppEngTileMissingException e) {

				e.printStackTrace();
			}

		}

	}

	@Override
	public void reset(IGridInterface grid) {
		
	}

	@Override
	public void onUpdateTick(IGridInterface grid) {
		if (!ticked) {
			mapGrid(grid);
			this.ticked = true;
		}

	}

	@Override
	public String getCacheName() {
		return "mapperForAT";
	}

	@Override
	public NBTTagCompound savetoNBTData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void loadfromNBTData(NBTTagCompound data) {
		// TODO Auto-generated method stub

	}
	
	public double sumCooling() {
		double sum = 0;
		
		for(IATCoolantMachine mach : coordMap.values()) {
			sum += mach.coolPerTick();
		}
		
		return sum;
	}
	
	public Map<DimentionalCoord, IATCoolantMachine> getCoolingMap() {
		return this.coordMap;
	}
	
}
