package com.tgame.apptherm.multiblocks;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

import com.tgame.apptherm.AppTherm;
import com.tgame.apptherm.libs.multiblocks.multiblock.IMultiblockPart;
import com.tgame.apptherm.libs.multiblocks.multiblock.MultiblockControllerBase;
import com.tgame.apptherm.libs.multiblocks.multiblock.MultiblockValidationException;

public class FanBoxController extends MultiblockControllerBase {

	public FanBoxController(World world) {
		super(world);
		
		System.out.println("new Controller");
	}

	@Override
	public void onAttachedPartWithMultiblockData(IMultiblockPart part,
			NBTTagCompound data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onBlockAdded(IMultiblockPart newPart) {
		System.out.println("block Added");
		
	}

	@Override
	protected void onBlockRemoved(IMultiblockPart oldPart) {
		System.out.println("Block Removed");
		
	}
	
	@Override
	protected boolean isMachineWhole() throws MultiblockValidationException {
		return super.isMachineWhole();
		
	}

	@Override
	protected void onMachineAssembled() {
		System.out.println("Assembled");
		
	}

	@Override
	protected void onMachineRestored() {
		System.out.println("Restored");
		
	}

	@Override
	protected void onMachinePaused() {
		System.out.println("Paused");
		
	}

	@Override
	protected void onMachineDisassembled() {
		System.out.println("Disassembled");
		
	}

	@Override
	protected int getMinimumNumberOfBlocksForAssembledMachine() {
		return 27;
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
		return false;
	}

	@Override
	protected void updateClient() {
		
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
