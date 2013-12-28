package com.tgame.apptherm.multiblocks;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

import com.tgame.apptherm.lib.multiblocks.multiblock.IMultiblockPart;
import com.tgame.apptherm.lib.multiblocks.multiblock.MultiblockControllerBase;

public class FanBoxController extends MultiblockControllerBase {

	public FanBoxController(World world) {
		super(world);
		
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
		return 0;
	}

	@Override
	protected int getMaximumXSize() {
		return 9;
	}

	@Override
	protected int getMaximumZSize() {
		return 9;
	}

	@Override
	protected int getMaximumYSize() {
		return 9;
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
