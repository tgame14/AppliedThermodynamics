package apptherm.common.proxies;

import apptherm.common.client.renderers.Renderers;



public class ProxyClient extends CommonProxy {

	@Override
	public void initSounds() {
		
	}
	
	
	@Override
	public void initRenderers() {
		Renderers.init();
	}

}