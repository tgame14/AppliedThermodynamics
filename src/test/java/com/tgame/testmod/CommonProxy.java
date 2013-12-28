package com.tgame.testmod;

import com.tgame.apptherm.lib.multiblocks.multiblock.MultiblockServerTickHandler;

import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

public class CommonProxy {

	public void preInit() {
		
	}
	
	public void init() {
		TestMod.registerTileEntities();
		TickRegistry.registerTickHandler(new MultiblockServerTickHandler(), Side.SERVER);
	}
}
