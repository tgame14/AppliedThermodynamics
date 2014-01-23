package com.tgame.apptherm.multiblocks;

import java.util.HashSet;
import java.util.Set;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTankInfo;

import com.tgame.apptherm.libs.multiblocks.common.CoordTriplet;
import com.tgame.apptherm.libs.multiblocks.multiblock.IMultiblockPart;
import com.tgame.apptherm.libs.multiblocks.multiblock.MultiblockControllerBase;
import com.tgame.apptherm.multiblocks.handlers.LiquidCoolerFluidHandler;
import com.tgame.apptherm.tileentities.liquidcooler.TileEntityExchange;
import com.tgame.apptherm.tileentities.liquidcooler.TileEntityHeatPort;

public class LiquidCoolerControllerBase extends CoolerMultiblockBase {

	protected LiquidCoolerFluidHandler fluidHandler;
	private int countOfInternals;

	protected Set<TileEntityHeatPort> mePorts;

	public LiquidCoolerControllerBase(World world) {
		super(world);

		this.countOfInternals = 0;
		this.mePorts = new HashSet<TileEntityHeatPort>();
		this.fluidHandler = null;
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
		for (TileEntityHeatPort tile : mePorts) {
			tile.onMachineActivated();
		}
		this.coolingStatus = true;
	}

	protected void onMachineDeactivated() {
		for (TileEntityHeatPort tile : mePorts) {
			tile.onMachineDeactivated();
		}

		this.coolingStatus = false;
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
		super.writeToNBT(tag);
		if (fluidHandler != null)
			fluidHandler.writeToNBT(tag);
	}

	@Override
	public void readFromNBT(NBTTagCompound tag) {
		super.readFromNBT(tag);
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

	/* Fluid Handler path */

	public int fill(ForgeDirection from, FluidStack resource, boolean doFill) {
		if (fluidHandler != null)
			return this.fluidHandler.fill(from, resource, doFill);
		return 0;
	}

	public FluidStack drain(ForgeDirection from, FluidStack resource,
			boolean doDrain) {
		if (fluidHandler != null)
			return this.fluidHandler.drain(from, resource, doDrain);
		return null;
	}

	public FluidStack drain(ForgeDirection from, int maxDrain, boolean doDrain) {
		if (fluidHandler != null)
			return this.fluidHandler.drain(from, maxDrain, doDrain);
		return null;
	}

	public boolean canFill(ForgeDirection from, Fluid fluid) {
		if (fluidHandler != null)
			return this.fluidHandler.canFill(from, fluid);
		return false;
	}

	public boolean canDrain(ForgeDirection from, Fluid fluid) {
		if (fluidHandler != null)
			return this.fluidHandler.canDrain(from, fluid);
		return false;
	}

	public FluidTankInfo[] getTankInfo(ForgeDirection from) {
		if (fluidHandler != null)
			return this.fluidHandler.getTankInfo(from);
		return null;
	}

}
