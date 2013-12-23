package com.tgame.apptherm;

import com.tgame.apptherm.ModInfo.Mods;
import com.tgame.apptherm.blocks.Blocks;
import com.tgame.apptherm.client.interfaces.GuiHandler;
import com.tgame.apptherm.client.renderers.Renderers;
import com.tgame.apptherm.config.ConfigHandler;
import com.tgame.apptherm.config.ConfigInfo;
import com.tgame.apptherm.entities.Entities;
import com.tgame.apptherm.events.EventBusListener;
import com.tgame.apptherm.fluids.Fluids;
import com.tgame.apptherm.items.Items;
import com.tgame.apptherm.logic.LogicBase;
import com.tgame.apptherm.network.PacketHandler;
import com.tgame.apptherm.proxies.CommonProxy;
import com.tgame.apptherm.tileentities.TileEntities;

import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import appeng.api.Util;
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
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@Mod(modid = ModInfo.ID, name = ModInfo.NAME, version = ModInfo.VERSION, dependencies = "required-after:" + Mods.APPLIED_ENERGISTICS)
@NetworkMod(channels = { ModInfo.CHANNEL }, packetHandler = PacketHandler.class, clientSideRequired = true, serverSideRequired = false)
public class AppTherm {

	public static final CreativeTabs AppThermTab = new AppThermTab(
			CreativeTabs.getNextID(), ModInfo.NAME);

	@Instance(ModInfo.ID)
	public static AppTherm instance;

	@SidedProxy(clientSide = "com.tgame.apptherm.proxies.ProxyClient", serverSide = "com.tgame.apptherm.proxies.CommonProxy")
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		ConfigHandler.init(event.getSuggestedConfigurationFile());
		
		Fluids.registerFluids();
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

		Items.registerRecipes();
		Blocks.registerRecipes();
		
		Entities.init();
		new GuiHandler();

		
		ModInfo.heatCacheID = Util.getAppEngApi().getGridCacheRegistry()
				.registerGridCache(LogicBase.class);

	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		FMLLog.info("Applied Thermodynamics loaded");

	}

}