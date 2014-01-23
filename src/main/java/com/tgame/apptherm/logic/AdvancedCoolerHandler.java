package com.tgame.apptherm.logic;

import java.util.HashMap;
import java.util.Map;

import appeng.api.TileRef;
import appeng.api.me.util.IGridInterface;

import com.tgame.apptherm.multiblocks.LiquidCoolerControllerBase;
import com.tgame.apptherm.tileentities.liquidcooler.TileEntityHeatPort;

public class AdvancedCoolerHandler {

	private IGridInterface grid;
	private Map<Integer, Integer> advCoolMap;

	protected AdvancedCoolerHandler(IGridInterface grid) {
		this.grid = grid;
		this.advCoolMap = mapAdvCoolers();

	}

	protected Map<Integer, Integer> getadvCoolMap() {
		return this.advCoolMap;
	}

	protected int getTotalCooling() {
		int count = 0;

		for (Integer value : advCoolMap.values()) {
			count += value;
		}

		return count;
	}

	protected HashMap<Integer, Integer> mapAdvCoolers() {

		Class clazz = TileEntityHeatPort.class;

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (TileRef tile : grid.getMachines()) {
			try {
				if (clazz.isInstance(tile.getTile())) {
					TileEntityHeatPort telc = (TileEntityHeatPort) tile
							.getTile();
					LiquidCoolerControllerBase liq = telc.getController();

					if (liq != null && liq.isAssembled()) {
						if(!map.containsKey(liq.hashCode()))
						map.put(liq.hashCode(), liq.getCountOfInternals());
					}
				}

			}

			catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		return map;
	}

}
