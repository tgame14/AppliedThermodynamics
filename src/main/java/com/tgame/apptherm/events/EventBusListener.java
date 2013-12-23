package com.tgame.apptherm.events;

import com.tgame.apptherm.blocks.Blocks;
import com.tgame.apptherm.fluids.Fluids;
import com.tgame.apptherm.tileentities.TileEntityLiquidCooler;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeSubscribe;

public class EventBusListener {

	public static void init() {
		MinecraftForge.EVENT_BUS.register(new EventBusListener());
		MinecraftForge.EVENT_BUS.register(new TileEntityLiquidCooler());
	}
	
	@ForgeSubscribe
	@SideOnly(Side.CLIENT)
	public void postStitch(TextureStitchEvent.Post event) {
		Fluids.fluidME.setIcons(Blocks.fluidME.getBlockTextureFromSide(0),
				Blocks.fluidME.getBlockTextureFromSide(1));

	}
	
	
	
}
