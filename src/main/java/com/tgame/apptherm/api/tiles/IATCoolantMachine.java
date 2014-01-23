package com.tgame.apptherm.api.tiles;

import appeng.api.me.tiles.IGridMachine;

/**
 * The Interface IATCoolantMachine.
 * 
 * you must be a IGridMachine in order to cool!
 */
public interface IATCoolantMachine extends IGridMachine {
	
	/**
	 * 
	 * @return the cooling Percentage of heat per machine,
	 * For Example, return 0.1F to decrease 10% heat per machine
	 * 
	 */
	public float coolPerTick();
	
	/**
	 * you may edit and manage the active state of your machines
	 * when inactive, it will not cool. when active it will.
	 * 
	 * if you want it to always cool, return true. just don't be stupid and always return false.
	 * @return active State
	 */
	public boolean isActive();
	

}
