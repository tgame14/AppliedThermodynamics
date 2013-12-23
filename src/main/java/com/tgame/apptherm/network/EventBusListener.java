package com.tgame.apptherm.network;

import com.tgame.apptherm.blocks.Blocks;
import com.tgame.apptherm.fluids.Fluids;

import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeSubscribe;

public class EventBusListener {

	public static void init() {
		MinecraftForge.EVENT_BUS.register(new EventBusListener());

	}

	@ForgeSubscribe
	public void postStitch(TextureStitchEvent.Post event) {
		Fluids.fluidME.setIcons(Blocks.fluidME.getBlockTextureFromSide(0),
				Blocks.fluidME.getBlockTextureFromSide(1));
	}

}
