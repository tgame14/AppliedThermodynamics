package com.tgame.testmod;

import com.tgame.apptherm.libs.multiblocks.multiblock.MultiblockClientTickHandler;
import com.tgame.testmod.client.RendererMultiblockTester;
import com.tgame.testmod.common.TileEntityMultiblockTester;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

public class ClientProxy extends CommonProxy {

	@Override
	public void preInit() {
		super.preInit();
	}
	
	@Override
	public void init() {
		super.init();
		
		// Bind special renderers here
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMultiblockTester.class, new RendererMultiblockTester());
		TickRegistry.registerTickHandler(new MultiblockClientTickHandler(), Side.CLIENT);
		
		FMLLog.info("Tick handler registered on client");
	}
	
}
