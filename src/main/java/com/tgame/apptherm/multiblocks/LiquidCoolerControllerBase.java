package com.tgame.apptherm.multiblocks;

import java.util.HashSet;
import java.util.Set;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

import com.tgame.apptherm.libs.multiblocks.common.CoordTriplet;
import com.tgame.apptherm.libs.multiblocks.multiblock.IMultiblockPart;
import com.tgame.apptherm.libs.multiblocks.multiblock.MultiblockControllerBase;
import com.tgame.apptherm.multiblocks.handlers.LiquidCoolerFluidHandler;
import com.tgame.apptherm.tileentities.liquidcooler.TileEntityExchange;

public class LiquidCoolerControllerBase extends MultiblockControllerBase {

	protected LiquidCoolerFluidHandler fluidHandler;
	protected boolean isConnected;
	private int countOfInternals;

	public LiquidCoolerControllerBase(World world) {
		super(world);
		this.countOfInternals = 0;
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

	@Override
	public void onAttachedPartWithMultiblockData(IMultiblockPart part,
			NBTTagCompound data) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void onBlockAdded(IMultiblockPart newPart) {
		System.out.println("blockAdded: ");
	}

	@Override
	protected void onBlockRemoved(IMultiblockPart oldPart) {

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
