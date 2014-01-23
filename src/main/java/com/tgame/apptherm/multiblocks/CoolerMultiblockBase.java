package com.tgame.apptherm.multiblocks;

import net.minecraft.world.World;

import com.tgame.apptherm.libs.multiblocks.multiblock.MultiblockControllerBase;

public abstract class CoolerMultiblockBase extends MultiblockControllerBase {

	protected boolean coolingStatus;
	
	protected  CoolerMultiblockBase(World world) {
		super(world);
		this.coolingStatus = false;
	}
	
	public boolean isCooling() {
		return this.coolingStatus;
	}
	
	

}
