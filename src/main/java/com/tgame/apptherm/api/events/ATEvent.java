package com.tgame.apptherm.api.events;

import net.minecraft.world.World;
import net.minecraftforge.event.Cancelable;
import appeng.api.events.AEWorldEvent;

// TODO: Auto-generated Javadoc
/**
 * The Class ATEvent.
 */
@Cancelable
public class ATEvent extends AEWorldEvent{

	/**
	 * Instantiates a new aT event.
	 *
	 * @param world the world
	 */
	public ATEvent(World world) {
		super(world);
	
	}

}
