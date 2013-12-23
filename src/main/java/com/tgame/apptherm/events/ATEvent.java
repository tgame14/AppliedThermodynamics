package com.tgame.apptherm.events;

import net.minecraft.world.World;
import net.minecraftforge.event.Cancelable;
import appeng.api.events.AEWorldEvent;

@Cancelable
public class ATEvent extends AEWorldEvent{

	public ATEvent(World world) {
		super(world);
	
	}

}
