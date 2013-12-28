package com.tgame.apptherm.proxies;

import com.tgame.apptherm.client.renderers.Renderers;
import com.tgame.apptherm.libs.multiblocks.multiblock.MultiblockClientTickHandler;

import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;



public class ProxyClient extends CommonProxy {

	@Override
	public void initSounds() {
		
	}
	
	
	@Override
	public void initRenderers() {
		Renderers.init();
	}
	
	public void initTickHandlers() {
		TickRegistry.registerTickHandler(new MultiblockClientTickHandler(), Side.CLIENT);
	}

}