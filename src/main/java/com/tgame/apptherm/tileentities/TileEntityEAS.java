package com.tgame.apptherm.tileentities;

import net.minecraftforge.event.ForgeSubscribe;

import com.tgame.apptherm.api.events.ATOverHeatEvent;

public class TileEntityEAS extends AEBaseMachine {
	public TileEntityEAS() {
		
	}
	
	@ForgeSubscribe
	public void onOverHeat(ATOverHeatEvent event) {
		
		switch (event.stageID) {
		case 1:
			
			break;
		case 2:
			
			break;
		case 3:
			
			break;
			
		}
		
	}
	
	
}