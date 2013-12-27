package com.tgame.apptherm;

import java.util.logging.Logger;

import net.minecraft.creativetab.CreativeTabs;
import appeng.api.Util;

import com.tgame.apptherm.blocks.Blocks;
import com.tgame.apptherm.client.interfaces.GuiHandler;
import com.tgame.apptherm.config.ConfigHandler;
import com.tgame.apptherm.entities.Entities;
import com.tgame.apptherm.events.EventBusListener;
import com.tgame.apptherm.fluids.Fluids;
import com.tgame.apptherm.items.Items;
import com.tgame.apptherm.logic.LogicBase;
import com.tgame.apptherm.network.PacketHandler;
import com.tgame.apptherm.proxies.CommonProxy;
import com.tgame.apptherm.tileentities.TileEntities;
import com.tgame.apptherm.util.AppThermTab;
import com.tgame.apptherm.util.Refference;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid = Refference.ID, name = Refference.NAME, version = Refference.VERSION, dependencies = "required-after:"
		+ Refference.APPLIED_ENERGISTICS)
@NetworkMod(channels = { Refference.CHANNEL }, packetHandler = PacketHandler.class, clientSideRequired = true, serverSideRequired = false)
public class AppTherm {

	@Instance(Refference.ID)
	public static AppTherm instance;

	@SidedProxy(clientSide = "com.tgame.apptherm.proxies.ProxyClient", serverSide = "com.tgame.apptherm.proxies.CommonProxy")
	public static CommonProxy proxy;

	public static final CreativeTabs AppThermTab = new AppThermTab(
			CreativeTabs.getNextID(), Refference.NAME);
	
	// the FML Logger field, Used for debug / Console output to mimic the fml and minecraft one
	public static final Logger log = Logger.getLogger(Refference.NAME);
	
	
	//Instantiates a new mod Singleton, Registers the Logger to inherit fml logger props
	public AppTherm() {
		log.setParent(FMLCommonHandler.instance().getFMLLogger());
		
	}
	
	public AppTherm instance() {
		return this.instance;
	}
	
	
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		ConfigHandler.init(event.getSuggestedConfigurationFile());

		Fluids.init();
		Items.init();
		Blocks.init();
		TileEntities.init();

		proxy.initSounds();
		proxy.initRenderers();

		EventBusListener.init();
	}

	@EventHandler
	public void load(FMLInitializationEvent event) {

		Items.addNames();
		Blocks.addNames();

		// Items.registerRecipes();
		// Blocks.registerRecipes();

		Entities.init();
		new GuiHandler();

		Refference.heatCacheID = Util.getAppEngApi().getGridCacheRegistry()
				.registerGridCache(LogicBase.class);

	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		log.info(Refference.NAME + " Has Loaded Without Crashing!");

	}

}