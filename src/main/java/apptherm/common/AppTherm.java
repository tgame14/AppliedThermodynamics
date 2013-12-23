package apptherm.common;

import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import appeng.api.Util;
import apptherm.common.blocks.Blocks;
import apptherm.common.client.interfaces.GuiHandler;
import apptherm.common.client.renderers.Renderers;
import apptherm.common.config.ConfigHandler;
import apptherm.common.config.ConfigInfo;
import apptherm.common.entities.Entities;
import apptherm.common.events.EventBusListener;
import apptherm.common.fluids.Fluids;
import apptherm.common.items.Items;
import apptherm.common.logic.LogicBase;
import apptherm.common.network.PacketHandler;
import apptherm.common.proxies.CommonProxy;
import apptherm.common.tileentities.TileEntities;
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

@Mod(modid = ModInfo.ID, name = ModInfo.NAME, version = ModInfo.VERSION, dependencies = "required-after:AppliedEnergistics")
@NetworkMod(channels = { ModInfo.CHANNEL }, packetHandler = PacketHandler.class, clientSideRequired = true, serverSideRequired = false)
public class AppTherm {

	public static final CreativeTabs AppThermTab = new AppThermTab(
			CreativeTabs.getNextID(), ModInfo.NAME);

	@Instance(ModInfo.ID)
	public static AppTherm instance;

	@SidedProxy(clientSide = "apptherm.common.proxies.ProxyClient", serverSide = "apptherm.common.proxies.CommonProxy")
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