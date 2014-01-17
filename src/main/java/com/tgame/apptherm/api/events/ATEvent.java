package com.tgame.apptherm.api.events;

import net.minecraft.world.World;
import net.minecraftforge.event.Cancelable;
import appeng.api.events.AEWorldEvent;
import appeng.api.me.tiles.IGridTileEntity;
import appeng.api.networkevents.MENetworkEvent;

/**
 * the Base Event I use. do not subscribe to this.
 */
public abstract class ATEvent extends MENetworkEvent {
	public ATEvent(IGridTileEntity tile) {
		super(tile);
		
	}
	

}
