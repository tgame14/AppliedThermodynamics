package com.tgame.apptherm.integration;

import java.util.ArrayList;
import java.util.List;

import com.tgame.apptherm.AppTherm;
import com.tgame.apptherm.integration.computercraft.OpenPeripherals;

import cpw.mods.fml.common.Loader;

/**
 * A Singleton class to handle all registries and startup of plugin modules.
 * 
 * @author tgame14, Inspired by SlimeKnights.
 * 
 */
public class PluginRegistry {

	private enum Phase {
		PRELAUNCH, PREINIT, INIT, POSTINIT, DONE
	}

	private static PluginRegistry instance;
	private List<IPlugin> plugins = new ArrayList<IPlugin>();
	private Phase state = Phase.PRELAUNCH;

	private PluginRegistry() {

	}

	public static PluginRegistry instance() {
		if (instance == null)
			instance = new PluginRegistry();
		return instance;
	}

	public void registerPlugin(IPlugin plugin) {
		if (Loader.isModLoaded(plugin.getModId())) {
			AppTherm.log.info("Enabling Compat with: " + plugin.getModId());
			plugins.add(plugin);

			// ensures plugin will go through all states even if registered late
			switch (state) {
			case DONE:
			case POSTINIT:
				plugin.preinit();
				plugin.init();
				plugin.postinit();
				break;

			case INIT:
				plugin.preinit();
				plugin.init();
				break;

			case PREINIT:
				plugin.preinit();
				break;
			default:
				break;
			}
		}
	}
	
	public void preInit() {
		state = Phase.PREINIT;
		
		for(IPlugin plugin : plugins)
			plugin.preinit();
	}
	
	public void init() {
		state = Phase.INIT;
		
		for(IPlugin plugin : plugins)
			plugin.init();
	}
	
	public void postInit() {
		state = Phase.POSTINIT;
		
		for(IPlugin plugin : plugins)
			plugin.postinit();
		state = Phase.DONE;
	}
	
	public void registerExisting() {
		registerPlugin(new OpenPeripherals());
	}
	
}
