package com.tgame.apptherm.integration;

/**
 * A Simple interface to create new plugins to the mod.
 * 
 * implement this on integration classes to support AT
 * and as a soft dependency
 * 
 * 
 * @author tgame14, inspired by the SlimeKnights
 *
 */
public interface IPlugin {
	
	/** Called during preinit of main mod */
	public void preinit();
	
	/** Called during init of main mod */
	public void init();
	
	/** Called during postinit of main mod */
	public void postinit();
	
	/** the ModId of the original mod */
	public String getModId();

}
