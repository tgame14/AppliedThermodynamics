package com.tgame.apptherm.tileentities.fanbox;

import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import appeng.api.WorldCoord;
import appeng.api.config.ItemFlow;
import appeng.api.events.GridTileLoadEvent;
import appeng.api.events.GridTileUnloadEvent;
import appeng.api.me.tiles.IGridMachine;
import appeng.api.me.tiles.IGridTileEntity;
import appeng.api.me.tiles.IMEPowerStorage;
import appeng.api.me.util.IGridInterface;
import appeng.api.networkevents.MENetworkPowerStorage;
import appeng.api.networkevents.MENetworkPowerStorage.PowerEventType;

import com.tgame.apptherm.libs.multiblocks.multiblock.MultiblockControllerBase;
import com.tgame.apptherm.libs.multiblocks.multiblock.MultiblockTileEntityBase;
import com.tgame.apptherm.multiblocks.FanBoxControllerBase;

import cpw.mods.fml.common.registry.GameRegistry;

public class TileEntityMEPort extends MultiblockTileEntityBase implements
		IGridTileEntity, IMEPowerStorage {

	private boolean powerStatus, networkReady;
	private IGridInterface grid;
	private FanBoxControllerBase controller;
	private double maxEnergy, energy;

	public TileEntityMEPort() {
		super();

		this.powerStatus = false;
		this.networkReady = false;
		this.maxEnergy = 10000;
		this.energy = 0.0;

	}

	@Override
	public Class<? extends MultiblockControllerBase> getMultiblockControllerType() {
		return FanBoxControllerBase.class;
	}

	@Override
	public boolean isGoodForFrame() {
		return false;
	}

	@Override
	public boolean isGoodForSides() {
		return true;
	}

	@Override
	public boolean isGoodForTop() {
		return true;
	}

	@Override
	public boolean isGoodForBottom() {
		return true;
	}

	@Override
	public boolean isGoodForInterior() {
		return false;
	}

	@Override
	public void onMachineAssembled(
			MultiblockControllerBase multiblockControllerBase) {
		this.controller = (FanBoxControllerBase) multiblockControllerBase;

	}

	@Override
	public void onMachineBroken() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onMachineActivated() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onMachineDeactivated() {
		// TODO Auto-generated method stub

	}

	@Override
	public MultiblockControllerBase createNewMultiblock() {
		return new FanBoxControllerBase(this.worldObj);
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
		this.powerStatus = hasPower;

	}

	@Override
	public boolean isPowered() {
		return this.powerStatus;
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
	public void validate() {
		super.validate();
		MinecraftForge.EVENT_BUS.post(new GridTileLoadEvent(this,
				this.worldObj, getLocation()));
	}

	@Override
	public void invalidate() {
		super.invalidate();
		MinecraftForge.EVENT_BUS.post(new GridTileUnloadEvent(this,
				this.worldObj, getLocation()));
	}

	@Override
	public boolean useMEEnergy(float use, String for_what) {
		if (energy > use) {
			energy -= use;
			return true;
		}

		energy = 0;
		return false;
	}

	@Override
	public double addMEPower(double amt) {
		if (getGrid() == null) {
			return amt;
		}
		boolean wasEmpty = energy < 0.001D;

		energy += amt;
		if (energy > getMEMaxPower()) {
			double overheadPower = energy - getMEMaxPower();
			energy = getMEMaxPower();
			return overheadPower;
		}

		if (wasEmpty && energy > 0.001D) {
			grid.postEvent(new MENetworkPowerStorage(this,
					PowerEventType.PROVIDE_POWER));
		}

		return 0.0D;
	}

	@Override
	public double getMEMaxPower() {
		return this.maxEnergy;
	}

	@Override
	public double getMECurrentPower() {
		return this.energy;
	}

	@Override
	public boolean isPublicPowerStorage() {
		return true;
	}

	@Override
	public ItemFlow getPowerFlow() {
		return ItemFlow.WRITE;
	}

	@Override
	public double drainMEPower(double amt) {
		if (getGrid() == null) {
			return 0.0D;
		}
		boolean wasFull = energy >= maxEnergy;

		energy -= amt;
		if (energy < 0.0D) {
			amt += energy;
			energy = 0.0D;
		}

		if (energy < maxEnergy && wasFull) {
			getGrid()
					.postEvent(
							new MENetworkPowerStorage(
									this,
									MENetworkPowerStorage.PowerEventType.REQUEST_POWER));
		}
		return amt;
	}

}
