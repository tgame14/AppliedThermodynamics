package com.tgame.testmod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;

import com.tgame.apptherm.libs.multiblocks.multiblock.MultiblockEventHandler;
import com.tgame.testmod.common.BlockMultiblockTester;
import com.tgame.testmod.common.ItemBlockMultiblockTester;
import com.tgame.testmod.common.TileEntityMultiblockTester;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerAboutToStartEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = TestMod.CHANNEL, name = TestMod.NAME, version=TestMod.VERSION, dependencies="", acceptedMinecraftVersions="[1.5.1,)")
public class TestMod {
	public static final String CHANNEL = "TestMod";
	public static final String NAME = "Beef's Testing Mod";
	public static final String VERSION = "1.0";

	public static final String RESOURCE_PATH = "/assets/test/";
	public static final String TEXTURE_DIRECTORY = RESOURCE_PATH;

	public static final CreativeTabs TAB = new CreativeTabTest(CreativeTabs.getNextID(), CHANNEL);
	public static final String TEXTURE_NAME_PREFIX = "test:";
	
	@Instance("TestMod")
	public static TestMod instance;
	
	@SidedProxy(clientSide="com.tgame.testmod.ClientProxy", serverSide= "com.tgame.testmod.CommonProxy")
	public static CommonProxy proxy;

	private static boolean INITIALIZED = false;

	public static Block blockMultiblockTester;
	
	private MultiblockEventHandler multiblockEventHandler;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent evt) {
		proxy.preInit();
		
		// Register blocks
		if(blockMultiblockTester == null) {
			blockMultiblockTester = new BlockMultiblockTester(4000, Material.iron);
			GameRegistry.registerBlock(blockMultiblockTester, ItemBlockMultiblockTester.class, "MultiblockTester");
		}
	}
	
	@EventHandler
	public void load(FMLInitializationEvent evt) {
		proxy.init();
		
		
	}

	@EventHandler
	public void registerServer(FMLServerAboutToStartEvent evt) {
		multiblockEventHandler = new MultiblockEventHandler();
		MinecraftForge.EVENT_BUS.register(multiblockEventHandler);
	}
	
	public static void registerTileEntities() {
		GameRegistry.registerTileEntity(TileEntityMultiblockTester.class, "BeefTestMultiblockTester");
	}
}
