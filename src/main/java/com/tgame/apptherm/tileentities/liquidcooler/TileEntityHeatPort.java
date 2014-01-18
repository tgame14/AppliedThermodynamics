package com.tgame.apptherm.tileentities.liquidcooler;

import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import appeng.api.WorldCoord;
import appeng.api.events.GridTileLoadEvent;
import appeng.api.events.GridTileUnloadEvent;
import appeng.api.me.tiles.IGridMachine;
import appeng.api.me.tiles.IGridTileEntity;
import appeng.api.me.util.IGridInterface;

import com.tgame.apptherm.libs.multiblocks.multiblock.MultiblockControllerBase;
import com.tgame.apptherm.libs.multiblocks.multiblock.MultiblockTileEntityBase;
import com.tgame.apptherm.multiblocks.LiquidCoolerControllerBase;

public class TileEntityHeatPort extends MultiblockTileEntityBase implements IGridMachine {

	private boolean powerstatus, networkready;
	private IGridInterface grid;
	
	
	public TileEntityHeatPort() {
		super();
		
		this.powerstatus = false;
		this.networkready = false;
	}
	
	public LiquidCoolerControllerBase getController() {
		return (LiquidCoolerControllerBase) getMultiblockController();
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
	public float getPowerDrainPerTick() {
		return 0;
	}


	@Override
	public void setNetworkReady(boolean isReady) {
		this.networkready = isReady;
		
	}


	@Override
	public boolean isMachineActive() {
		return powerstatus && networkready;
	}

	@Override
	public World getWorld() {
		return this.worldObj;
	}

	@Override
	public Class<? extends MultiblockControllerBase> getMultiblockControllerType() {
		return LiquidCoolerControllerBase.class;
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
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isGoodForInterior() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onMachineAssembled(
			MultiblockControllerBase multiblockControllerBase) {
		System.out.println("portAssembled");
	}

	@Override
	public void onMachineBroken() {
		
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
		return new LiquidCoolerControllerBase(worldObj);
	}
	
	@Override
	public void validate() {
		super.validate();
		MinecraftForge.EVENT_BUS.post(new GridTileLoadEvent(this, worldObj, getLocation()));
	}
	
	@Override
	public void invalidate() {
		super.invalidate();
		MinecraftForge.EVENT_BUS.post(new GridTileUnloadEvent(this, worldObj, getLocation()));
	}

}
