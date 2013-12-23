package com.tgame.apptherm.proxies;

import com.tgame.apptherm.client.renderers.Renderers;



public class ProxyClient extends CommonProxy {

	@Override
	public void initSounds() {
		
	}
	
	
	@Override
	public void initRenderers() {
		Renderers.init();
	}

}