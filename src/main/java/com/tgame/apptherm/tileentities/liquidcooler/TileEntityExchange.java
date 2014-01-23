package com.tgame.apptherm.tileentities.liquidcooler;

import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import appeng.api.WorldCoord;
import appeng.api.events.GridTileLoadEvent;
import appeng.api.events.GridTileUnloadEvent;
import appeng.api.me.tiles.IGridMachine;
import appeng.api.me.tiles.IGridTileEntity;
import appeng.api.me.util.IGridInterface;

import com.tgame.apptherm.api.tiles.IATCoolantMachine;
import com.tgame.apptherm.libs.multiblocks.multiblock.MultiblockControllerBase;
import com.tgame.apptherm.libs.multiblocks.multiblock.MultiblockTileEntityBase;
import com.tgame.apptherm.multiblocks.LiquidCoolerControllerBase;

public class TileEntityExchange extends MultiblockTileEntityBase implements
		IATCoolantMachine {

	private boolean powerstatus, networkReady;
	private IGridInterface grid;

	public TileEntityExchange() {
		this.powerstatus = false;
		this.networkReady = false;

	}

	public LiquidCoolerControllerBase getController() {
		return (LiquidCoolerControllerBase) getMultiblockController();
	}

	@Override
	public Class<? extends MultiblockControllerBase> getMultiblockControllerType() {
		return LiquidCoolerControllerBase.class;
	}

	@Override
	public boolean isGoodForFrame() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isGoodForSides() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isGoodForTop() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isGoodForBottom() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isGoodForInterior() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void onMachineAssembled(
			MultiblockControllerBase multiblockControllerBase) {
		
	}

	@Override
	public void onMachineBroken() {
		connectToGrid(false);

	}

	@Override
	public void onMachineActivated() {
		connectToGrid(true);

	}

	@Override
	public void onMachineDeactivated() {
		connectToGrid(false);

	}

	private void connectToGrid(boolean flag) {
		if (flag)
			MinecraftForge.EVENT_BUS.post(new GridTileLoadEvent(this, worldObj,
					getLocation()));
		else
			MinecraftForge.EVENT_BUS.post(new GridTileUnloadEvent(this,
					worldObj, getLocation()));
	}
	
	@Override
	public void validate() {
		super.validate();
		connectToGrid(true);
	}
	
	@Override
	public void invalidate() {
		super.invalidate();
		connectToGrid(false);
	}

	@Override
	public MultiblockControllerBase createNewMultiblock() {
		return new LiquidCoolerControllerBase(worldObj);
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
	public void setPowerStatus(boolean hasPower) {
		this.powerstatus = hasPower;

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
		return worldObj;
	}

	@Override
	public float getPowerDrainPerTick() {
		return 0;
	}

	@Override
	public void setNetworkReady(boolean isReady) {
		this.networkReady = isReady;

	}

	@Override
	public boolean isMachineActive() {
		return networkReady && powerstatus;
	}

	@Override
	public float coolPerTick() {
		return 0.1F;
	}

	@Override
	public boolean isActive() {
		return getController().isCooling();
	}

}
