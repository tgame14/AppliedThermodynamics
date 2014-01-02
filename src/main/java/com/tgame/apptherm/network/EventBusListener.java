package com.tgame.apptherm.network;

import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeSubscribe;

import com.tgame.apptherm.blocks.Blocks;
import com.tgame.apptherm.fluids.Fluids;

public class EventBusListener {

	public static void init() {
		MinecraftForge.EVENT_BUS.register(new EventBusListener());

	}

	@ForgeSubscribe
	public void postStitch(TextureStitchEvent.Post event) {
		Fluids.fluidME.setIcons(Blocks.fluidME.getBlockTextureFromSide(0),
				Blocks.fluidME.getBlockTextureFromSide(1));

		Fluids.meCoolant.setIcons(Blocks.meCoolant.getBlockTextureFromSide(0),
				Blocks.meCoolant.getBlockTextureFromSide(1));
	}

}
