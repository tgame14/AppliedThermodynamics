package com.tgame.apptherm.multiblocks;

import java.util.HashSet;
import java.util.Set;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.tgame.apptherm.libs.multiblocks.common.CoordTriplet;
import com.tgame.apptherm.libs.multiblocks.multiblock.IMultiblockPart;
import com.tgame.apptherm.libs.multiblocks.multiblock.MultiblockControllerBase;
import com.tgame.apptherm.libs.multiblocks.multiblock.MultiblockValidationException;
import com.tgame.apptherm.tileentities.TileEntityHeatVent;
import com.tgame.apptherm.tileentities.TileEntityMEPort;

public class FanBoxController extends MultiblockControllerBase {
	
	public Set<Class> requiredTiles;

	public FanBoxController(World world) {
		super(world);
		
		requiredTiles = fillSet();
	}
	/** Over here Add all tile Classes that are REQUIRED for your multiblock to work
	 * 
	 * 
	 * @return a HashSet<Class> with all required tiles.
	 * 
	 * @author tgame14
	 */
	private HashSet<Class> fillSet() {
		HashSet<Class> hashSet = new HashSet<Class>();
		
		hashSet.add(TileEntityMEPort.class);		
		
		return hashSet;
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
		CoordTriplet min = this.getMinimumCoord();
		CoordTriplet max = this.getMaximumCoord();
		
		if(Math.abs(max.y - min.y) < 2)
			return false;
		
		for(Class clazz : this.requiredTiles) {
			boolean flag = false;
			
			for(CoordTriplet coord : connectedBlocks) {
				TileEntity tile = worldObj.getBlockTileEntity(coord.x, coord.y, coord.z);
				
				if(clazz.isInstance(tile))
					flag = true;
			}
			if(!flag)
				return false;
		}
			
		
		
		return super.isMachineWhole();	
	}
	
	private boolean containsTile(Class clazz) {
		for(CoordTriplet coord : connectedBlocks) {
			TileEntity tile = worldObj.getBlockTileEntity(coord.x, coord.y, coord.z);
			if (clazz.isInstance(tile))
				return true;
		}
		
		
		
		return false;
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
