package com.tgame.apptherm.multiblocks;

import java.util.HashSet;
import java.util.Set;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

import com.tgame.apptherm.libs.multiblocks.common.CoordTriplet;
import com.tgame.apptherm.libs.multiblocks.multiblock.IMultiblockPart;
import com.tgame.apptherm.libs.multiblocks.multiblock.MultiblockControllerBase;
import com.tgame.apptherm.multiblocks.handlers.LiquidCoolerFluidHandler;

public class LiquidCoolerControllerBase extends MultiblockControllerBase {
	
	protected LiquidCoolerFluidHandler fluidHandler;
	protected Set<CoordTriplet> requiredTiles;
	
	protected LiquidCoolerControllerBase(World world) {
		super(world);
		
		this.requiredTiles = fillSet();
		
	}
	
	protected HashSet<CoordTriplet> fillSet() {
		HashSet<CoordTriplet> hashSet = new HashSet<CoordTriplet>();
		
		
		
		
		return hashSet;
	}

	@Override
	public void onAttachedPartWithMultiblockData(IMultiblockPart part,
			NBTTagCompound data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onBlockAdded(IMultiblockPart newPart) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onBlockRemoved(IMultiblockPart oldPart) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onMachineAssembled() {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		return 27;
	}

	@Override
	protected int getMaximumXSize() {
		// TODO Auto-generated method stub
		return 256;
	}

	@Override
	protected int getMaximumZSize() {
		// TODO Auto-generated method stub
		return 256;
	}

	@Override
	protected int getMaximumYSize() {
		// TODO Auto-generated method stub
		return 256;
	}
	
	@Override
	protected int getMinimumXSize() {
		// TODO Auto-generated method stub
		return super.getMinimumXSize();
	}
	
	@Override
	protected int getMinimumYSize() {
		// TODO Auto-generated method stub
		return super.getMinimumYSize();
	}
	
	@Override
	protected int getMinimumZSize() {
		// TODO Auto-generated method stub
		return super.getMinimumZSize();
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void updateClient() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void writeToNBT(NBTTagCompound data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void readFromNBT(NBTTagCompound data) {
		// TODO Auto-generated method stub
		
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
