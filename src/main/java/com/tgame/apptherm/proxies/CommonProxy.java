package com.tgame.apptherm.proxies;

import com.tgame.apptherm.libs.multiblocks.multiblock.MultiblockServerTickHandler;

import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;


public class CommonProxy {

	public void initSounds() {
		
	}
	
	public void initRenderers() {
		
	}
	
	public void initTickHandlers() {
		TickRegistry.registerTickHandler(new MultiblockServerTickHandler(), Side.SERVER);
	}
}