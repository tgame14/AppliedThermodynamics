package com.tgame.apptherm.api.events;

import appeng.api.me.tiles.IGridTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.event.Cancelable;

// TODO: Auto-generated Javadoc
/**
 * The Class ATOverHeatEvent.
 * 
 * This Class Adds the Over Heat Event, it is posted Whenever the ME Network
 * Overheats.
 * 
 * the Event is called at 3 different States of overheat, 15% (stageID , 60% and 90% (at
 * 90% the network starts to melt)
 * 
 * You May only post this Event if you use a stageID of > 3, For the less
 * understanding of us, Anything more than the number 3, like, 4, 5, 6... and so on.
 * 
 */

@Cancelable
public class ATOverHeatEvent extends ATEvent {

	/** The heat value. */
	public final double heatValue;

	/** The stage id. */
	public final int stageID;

	/**
	 * Instantiates a new over heat event.
	 * 
	 * @param  tileEntity is Irellivent, a weird addition to AE that will be removed in AE2
	 * 
	 * @param heatValue
	 *            the heat value
	 * @param stageID
	 *            the stage id
	 */
	public ATOverHeatEvent(TileEntity tileEntity, double heatValue, int stageID) {
		super((IGridTileEntity) tileEntity);

		this.heatValue = heatValue;
		this.stageID = stageID;
	}

}
