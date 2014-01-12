package com.tgame.apptherm;

import java.util.logging.Logger;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
import appeng.api.Util;

import com.tgame.apptherm.blocks.Blocks;
import com.tgame.apptherm.client.interfaces.GuiHandler;
import com.tgame.apptherm.config.ConfigHandler;
import com.tgame.apptherm.entities.Entities;
import com.tgame.apptherm.events.EventBusListener;
import com.tgame.apptherm.fluids.Fluids;
import com.tgame.apptherm.items.Items;
import com.tgame.apptherm.libs.multiblocks.multiblock.MultiblockEventHandler;
import com.tgame.apptherm.logic.LogicBase;
import com.tgame.apptherm.network.PacketHandler;
import com.tgame.apptherm.proxies.CommonProxy;
import com.tgame.apptherm.tileentities.TileEntities;
import com.tgame.apptherm.util.AppThermTab;
import com.tgame.apptherm.util.Recipes;
import com.tgame.apptherm.util.ModInfo;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerAboutToStartEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid = ModInfo.ID, name = ModInfo.NAME, version = ModInfo.VERSION, dependencies = "required-after:"
		+ ModInfo.APPLIED_ENERGISTICS)
@NetworkMod(channels = { ModInfo.CHANNEL }, packetHandler = PacketHandler.class, clientSideRequired = true, serverSideRequired = false)
public class AppTherm {

	@Instance(ModInfo.ID)
	public static AppTherm instance;

	@SidedProxy(clientSide = "com.tgame.apptherm.proxies.ProxyClient", serverSide = "com.tgame.apptherm.proxies.CommonProxy")
	public static CommonProxy proxy;

	public static final CreativeTabs AppThermTab = new AppThermTab(
			CreativeTabs.getNextID(), ModInfo.NAME);

	// the FML Logger field, Used for debug / Console output to mimic the fml
	// and minecraft one
	public static final Logger log = Logger.getLogger(ModInfo.ID);

	// Instantiates a new mod Singleton, Registers the Logger to inherit fml
	// logger props
	public AppTherm() {
		this.log.setParent(FMLCommonHandler.instance().getFMLLogger());

	}

	public AppTherm instance() {
		return this.instance;
	}

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		this.log.info("Preinit Loading up");
		
		this.log.info("Starting to Load Configs");
		ConfigHandler.init(event.getSuggestedConfigurationFile());
		
		this.log.fine("Loading Tick Handlers");
		proxy.initTickHandlers();

		
		this.log.fine("Loading Fluids");
		Fluids.init();
		this.log.fine("Loading Items");
		Items.init();
		this.log.fine("Loading Blocks");
		Blocks.init();

		this.log.fine("Loading Sounds");
		proxy.initSounds();
		
		
		this.log.fine("Loading Renderers");
		proxy.initRenderers();

		this.log.fine("Registering Event Bus");
		EventBusListener.init();
		
		
		this.log.finest("preinit for AT Over");
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		this.log.info("Init Loading Up");

		/*this.log.fine("Adding localized Names for Items And Blocks");
		Items.addNames();
		Blocks.addNames();*/
		
		this.log.fine("Initializing TileEntities");
		TileEntities.init();
		this.log.fine("Initializing Recipes");
		Recipes.init();

		this.log.fine("Initializing Entities");
		Entities.init();
		this.log.fine("Initializing Gui Handler");
		new GuiHandler();
		
		this.log.finer("Registering IGridCache For ae, (the handler of heat)");
		ModInfo.heatCacheID = Util.getAppEngApi().getGridCacheRegistry()
				.registerGridCache(LogicBase.class);
		
		this.log.info("Finished Loading init");

	}

	@EventHandler
	public void serverAboutToStart(FMLServerAboutToStartEvent event) {
		this.log.fine("Server About to start, Registering server side handlers");
		MinecraftForge.EVENT_BUS.register(new MultiblockEventHandler());
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		this.log.info(ModInfo.NAME + " Has Loaded Without Crashing! (yet)");
		this.log.finest("End Of AT Loading entirely.");

	}

}