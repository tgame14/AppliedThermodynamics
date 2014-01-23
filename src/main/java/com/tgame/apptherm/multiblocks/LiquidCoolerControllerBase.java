package com.tgame.apptherm.multiblocks;

import java.util.HashSet;
import java.util.Set;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.tgame.apptherm.libs.multiblocks.common.CoordTriplet;
import com.tgame.apptherm.libs.multiblocks.multiblock.IMultiblockPart;
import com.tgame.apptherm.libs.multiblocks.multiblock.MultiblockControllerBase;
import com.tgame.apptherm.multiblocks.handlers.LiquidCoolerFluidHandler;
import com.tgame.apptherm.tileentities.liquidcooler.TileEntityExchange;
import com.tgame.apptherm.tileentities.liquidcooler.TileEntityHeatPort;

public class LiquidCoolerControllerBase extends MultiblockControllerBase {

	protected LiquidCoolerFluidHandler fluidHandler;
	protected boolean isPowered;
	private int countOfInternals;

	protected Set<TileEntityHeatPort> mePorts;

	public LiquidCoolerControllerBase(World world) {
		super(world);

		this.countOfInternals = 0;
		this.mePorts = new HashSet<TileEntityHeatPort>();
	}

	public int getCountOfInternals() {
		return this.countOfInternals;
	}

	protected int countOfClassTypes(Class clazz) {
		int count = 0;

		for (CoordTriplet coord : connectedBlocks)
			if (clazz.isInstance(worldObj.getBlockTileEntity(coord.x, coord.y,
					coord.z)))
				count++;

		return count;

	}

	private boolean isActive() {
		if(fluidHandler.isEmpty())
			return false;
		
		return true;
	}
	

	@Override
	public void onAttachedPartWithMultiblockData(IMultiblockPart part,
			NBTTagCompound data) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void onBlockAdded(IMultiblockPart newPart) {
		CoordTriplet c = newPart.getWorldLocation().copy();
		TileEntity tile = worldObj.getBlockTileEntity(c.x, c.y, c.z);
		if (tile instanceof TileEntityHeatPort)
			mePorts.add((TileEntityHeatPort) tile);
	}

	@Override
	protected void onBlockRemoved(IMultiblockPart oldPart) {
		if (mePorts.contains(oldPart))
			mePorts.remove(oldPart);
	}

	@Override
	protected void onMachineAssembled() {
		this.fluidHandler = new LiquidCoolerFluidHandler(
				countOfClassTypes(TileEntityExchange.class));

		this.countOfInternals = this.calcInternals();

	}

	private int calcInternals() {
		CoordTriplet max = this.getMaximumCoord();
		CoordTriplet min = this.getMinimumCoord();

		int sizeX = Math.abs(max.x - min.x);
		int sizeY = Math.abs(max.y - min.y);
		int sizeZ = Math.abs(max.z - min.z);

		int volInternal = sizeX * sizeY * sizeZ;

		return volInternal;
	}

	@Override
	protected void onMachineRestored() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void onMachinePaused() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void onMachineDisassembled() {
		// TODO Auto-generated method stub

	}
	
	protected void onMachineActivated() {
		for(TileEntityHeatPort tile : mePorts) {
			tile.onMachineActivated();
		}
		this.isPowered = true;
	}
	
	protected void onMachineDeactivated() {
		for(TileEntityHeatPort tile : mePorts) {
			tile.onMachineDeactivated();
		}
		
		this.isPowered = false;
	}
	
	public boolean getPoweredState() {
		return this.isPowered;
	}

	@Override
	protected int getMinimumNumberOfBlocksForAssembledMachine() {
		return 27;
	}

	@Override
	protected int getMaximumXSize() {
		return MultiblockInfo.LiquidCoolerXSize;
	}

	@Override
	protected int getMaximumZSize() {
		return MultiblockInfo.LiquidCoolerZSize;
	}

	@Override
	protected int getMaximumYSize() {
		return MultiblockInfo.LiquidCoolerYSize;
	}

	@Override
	protected int getMinimumXSize() {
		return 3;
	}

	@Override
	protected int getMinimumYSize() {
		return 3;
	}

	@Override
	protected int getMinimumZSize() {
		return 3;
	}

	@Override
	protected void onAssimilate(MultiblockControllerBase assimilated) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void onAssimilated(MultiblockControllerBase assimilator) {
		// TODO Auto-generated method stub

	}

	@Override
	protected boolean updateServer() {
		fluidHandler.onUpdateServer();

		return false;
	}

	@Override
	protected void updateClient() {
		// TODO Auto-generated method stub

	}

	@Override
	public void writeToNBT(NBTTagCompound tag) {
		if (fluidHandler != null)
			fluidHandler.writeToNBT(tag);
	}

	@Override
	public void readFromNBT(NBTTagCompound tag) {
		fluidHandler.readFromNBT(tag);

	}

	@Override
	public void formatDescriptionPacket(NBTTagCompound data) {
		// TODO Auto-generated method stub

	}

	@Override
	public void decodeDescriptionPacket(NBTTagCompound data) {
		// TODO Auto-generated method stub

	}

	@Override
	public void getOrphanData(IMultiblockPart newOrphan, int oldSize,
			int newSize, NBTTagCompound dataContainer) {
		// TODO Auto-generated method stub

	}

}
