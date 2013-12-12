package apptherm.common.client.renderers;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Renderers {
	
	public static void init() {
		RenderingRegistry.registerBlockHandler(new ATBlockRendererHelper());
	}
}
