package com.tgame.apptherm.client.renderers;

import cpw.mods.fml.client.registry.RenderingRegistry;

public class Renderers {
	
	public static void init() {
		RenderingRegistry.registerBlockHandler(new ATBlockRendererHelper());
	}
}
