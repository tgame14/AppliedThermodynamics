package com.tgame.apptherm.integration.computercraft;

import openperipheral.api.OpenPeripheralAPI;

import com.tgame.apptherm.integration.IPlugin;
import com.tgame.apptherm.integration.Mods;

public class OpenPeripherals implements IPlugin {

	@Override
	public void preinit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		OpenPeripheralAPI.register(new AdapterNetworked());
		
	}

	@Override
	public void postinit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getModId() {
		return Mods.OPENPERIPHERAL;
	}

}
