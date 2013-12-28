package com.tgame.apptherm.api.events;

import net.minecraft.world.World;
import net.minecraftforge.event.Cancelable;
import appeng.api.events.AEWorldEvent;
import appeng.api.me.tiles.IGridTileEntity;
import appeng.api.networkevents.MENetworkEvent;

/**
 * the Base Event i use. do not subscribe to this.
 */
@Cancelable
public class ATEvent extends MENetworkEvent {
	public ATEvent(IGridTileEntity tile) {
		super(tile);
		
	}
	

}
