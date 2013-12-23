package com.tgame.apptherm.events;

import net.minecraft.world.World;

public class ATOverHeatEvent extends ATEvent{

	
	
	public final double heatValue;
	public final int stageID;
	
	public ATOverHeatEvent(World world, double heatValue, int stageID) {
		super(world);
		
		this.heatValue = heatValue;
		this.stageID = stageID;
	}

}
