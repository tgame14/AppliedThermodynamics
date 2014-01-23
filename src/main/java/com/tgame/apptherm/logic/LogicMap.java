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
	protected Map<Integer, Integer> multiblockMap;

	public LogicMap() {
		this.coordMap = new HashMap<DimentionalCoord, IATCoolantMachine>();
		this.multiblockMap = new HashMap<Integer, Integer>();
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
		// TODO Auto-generated method stub

	}

	@Override
	public void onUpdateTick(IGridInterface grid) {
		// TODO Auto-generated method stub

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
	
}
