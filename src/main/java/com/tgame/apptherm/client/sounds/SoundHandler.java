package com.tgame.apptherm.client.sounds;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeSubscribe;

import com.tgame.apptherm.util.Refference;

public class SoundHandler {

	public SoundHandler() {
		MinecraftForge.EVENT_BUS.register(this);

	}

	@ForgeSubscribe
	public void onSound(SoundLoadEvent event) {
		for (Sounds sound : Sounds.values()) 
			this.addSound(event, sound);
		
	}

	private void addSound(SoundLoadEvent event, Sounds sound) {
		event.manager.soundPoolSounds.addSound(Refference.RESOURCE_LOCATION + ":"
				+ sound.name);
	}

	public void playAnySoundAtCoords(String name, double x, double y, double z,
			float volume, float pitch) {
		Minecraft.getMinecraft().sndManager.playSound(Refference.RESOURCE_LOCATION
				+ ":" + name, (float) x, (float) y, (float) z, volume, pitch);

	}

}