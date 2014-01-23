package com.tgame.apptherm.logic;

import java.util.HashMap;
import java.util.Map;

import com.google.common.collect.Multimap;
import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory.Woodstox;
import com.tgame.apptherm.api.tiles.IATCoolantMachine;

import net.minecraft.nbt.NBTTagCompound;
import appeng.api.DimentionalCoord;
import appeng.api.TileRef;
import appeng.api.WorldCoord;
import appeng.api.exceptions.AppEngTileMissingException;
import appeng.api.me.tiles.IGridMachine;
import appeng.api.me.util.IGridCache;
import appeng.api.me.util.IGridInterface;

public class LogicMap implements IGridCache {
	
	protected Map<DimentionalCoord, IATCoolantMachine> coordMap;
	
	private Map<DimentionalCoord, IATCoolantMachine> mapGrid(IGridInterface grid) {
		HashMap<DimentionalCoord, IATCoolantMachine> hashMap = new HashMap<DimentionalCoord, IATCoolantMachine>();
		
		for(TileRef<IGridMachine> mach : grid.getMachines()) {
			IATCoolantMachine candidate;
			try {
				if(mach.getTile() instanceof IATCoolantMachine) {
					candidate = (IATCoolantMachine) mach;
					if(!candidate.isMultiblock()) {
						hashMap.put(mach.getCoord(), candidate);
					}
						
				}
				
				
			} catch (AppEngTileMissingException e) {
				
				e.printStackTrace();
			}
			
			
		}
		
		return hashMap;
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
