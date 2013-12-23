package com.tgame.apptherm.tileentities;

import com.tgame.apptherm.events.ATOverHeatEvent;

import net.minecraft.world.World;
import net.minecraftforge.event.ForgeSubscribe;
import appeng.api.WorldCoord;
import appeng.api.me.tiles.IGridMachine;
import appeng.api.me.util.IGridInterface;

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