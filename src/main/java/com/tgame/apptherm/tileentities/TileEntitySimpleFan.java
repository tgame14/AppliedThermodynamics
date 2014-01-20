package com.tgame.apptherm.tileentities;

import com.tgame.apptherm.blocks.networked.BlockAirIntake;
import com.tgame.apptherm.util.ModInfo;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import appeng.api.WorldCoord;
import appeng.api.events.GridTileLoadEvent;
import appeng.api.events.GridTileUnloadEvent;
import appeng.api.me.tiles.IGridMachine;
import appeng.api.me.util.IGridInterface;

public class TileEntitySimpleFan extends TileEntity implements IGridMachine {

	private boolean powerstatus, networkstatus;
	private IGridInterface grid;
	
	public TileEntitySimpleFan() {
		this.powerstatus = false;
		this.networkstatus = false;
	}

	@Override
	public void setPowerStatus(boolean hasPower) {
		this.powerstatus = hasPower;
	}

	@Override
	public void validate() {
		super.validate();
		MinecraftForge.EVENT_BUS.post(new GridTileLoadEvent(this, worldObj,
				getLocation()));
	}

	@Override
	public void invalidate() {
		super.invalidate();
		MinecraftForge.EVENT_BUS.post(new GridTileUnloadEvent(this, worldObj,
				getLocation()));

	}

	@Override
	public float getPowerDrainPerTick() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public WorldCoord getLocation() {
		return new WorldCoord(xCoord, yCoord, zCoord);
	}

	@Override
	public boolean isValid() {
		return true;
	}

	@Override
	public boolean isPowered() {		
		return this.powerstatus;
	}

	@Override
	public IGridInterface getGrid() {
		return this.grid;
	}

	@Override
	public void setGrid(IGridInterface gi) {
		this.grid = gi;
		
	}

	@Override
	public World getWorld() {
		return this.worldObj;
	}

	@Override
	public void setNetworkReady(boolean isReady) {
		this.networkstatus = isReady;
		
	}

	@Override
	public boolean isMachineActive() {
		return powerstatus && networkstatus;
	}

}