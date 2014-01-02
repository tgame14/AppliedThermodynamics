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
import com.tgame.apptherm.libs.multiblocks.multiblock.MultiblockValidationException;
import com.tgame.apptherm.tileentities.fanbox.TileEntityFluidPort;
import com.tgame.apptherm.tileentities.fanbox.TileEntityInternalTank;
import com.tgame.apptherm.tileentities.fanbox.TileEntityMEPort;

public class FanBoxControllerBase extends MultiblockControllerBase {

	protected Set<Class> requiredTiles;
	protected Set<CoordTriplet> setOfInternalTanks;

	private FanBoxFluidsBase fluidHandler;

	public FanBoxControllerBase(World world) {
		super(world);

		this.requiredTiles = fillSet();

	}

	/**
	 * 
	 * A Separate constructor used for the spatial transfer from Applied
	 * Energistics, DO NOT USE.
	 * 
	 * @param world
	 * @param tag
	 * 
	 * @author tgame14
	 */

	public FanBoxControllerBase(World world, NBTTagCompound tag) {
		super(world);

		this.requiredTiles = fillSet();

		writeToNBT(tag);
	}

	public Set<CoordTriplet> getCountOfInternalTanks() {
		return this.setOfInternalTanks;
	}

	/**
	 * Over here Add all tile Classes that are REQUIRED for your multiblock to
	 * work
	 * 
	 * 
	 * @return a HashSet<Class> with all required tiles.
	 * 
	 * @author tgame14
	 */
	private HashSet<Class> fillSet() {
		HashSet<Class> hashSet = new HashSet<Class>();

		hashSet.add(TileEntityMEPort.class);
		hashSet.add(TileEntityFluidPort.class);
		// hashSet.add(TileEntityInternalTank.class);

		return hashSet;
	}

	@Override
	public void onAttachedPartWithMultiblockData(IMultiblockPart part,
			NBTTagCompound data) {

	}

	@Override
	protected void onBlockAdded(IMultiblockPart newPart) {
		// System.out.println("block Added");

	}

	@Override
	protected void onBlockRemoved(IMultiblockPart oldPart) {
		// System.out.println("Block Removed");

	}

	@Override
	protected boolean isMachineWhole() throws MultiblockValidationException {
		CoordTriplet min = this.getMinimumCoord();
		CoordTriplet max = this.getMaximumCoord();

		if (Math.abs(max.y - min.y) < 2)
			return false;

		if (!checkForRequiredTiles())
			return false;

		this.setOfInternalTanks = calcInternalTanks();

		return super.isMachineWhole();
	}

	private boolean checkForRequiredTiles() {
		for (Class clazz : requiredTiles) {
			boolean flag = false;

			for (CoordTriplet coord : connectedBlocks) {
				TileEntity tile = worldObj.getBlockTileEntity(coord.x, coord.y,
						coord.z);

				if (clazz.isInstance(tile))
					flag = true;
			}
			if (!flag)
				return false;
		}
		return true;
	}

	private HashSet<CoordTriplet> calcInternalTanks() {
		HashSet<CoordTriplet> hashSet = new HashSet<CoordTriplet>();
		Class clazz = TileEntityInternalTank.class;

		for (CoordTriplet coord : connectedBlocks) {
			TileEntity tile = worldObj.getBlockTileEntity(coord.x, coord.y,
					coord.z);

			if (clazz.isInstance(tile))
				hashSet.add(new CoordTriplet(coord.x, coord.y, coord.z));
		}
		return hashSet;
	}

	@Override
	protected void onMachineAssembled() {
		// System.out.println("Assembled");

		this.fluidHandler = new FanBoxFluidsBase(this.setOfInternalTanks);

	}

	@Override
	protected void onMachineRestored() {
		// System.out.println("Restored");

	}

	@Override
	protected void onMachinePaused() {
		// System.out.println("Paused");

	}

	@Override
	protected void onMachineDisassembled() {
		// System.out.println("Disassembled");

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

	}

	@Override
	protected void onAssimilated(MultiblockControllerBase assimilator) {

	}

	@Override
	protected boolean updateServer() {

		return false;
	}

	@Override
	protected void updateClient() {

	}

	@Override
	public void writeToNBT(NBTTagCompound tag) {
		this.fluidHandler.readFromNBT(tag);

	}

	@Override
	public void readFromNBT(NBTTagCompound tag) {
		this.fluidHandler.writeToNBT(tag);

	}

	@Override
	public void formatDescriptionPacket(NBTTagCompound data) {

	}

	@Override
	public void decodeDescriptionPacket(NBTTagCompound data) {

	}

	@Override
	public void getOrphanData(IMultiblockPart newOrphan, int oldSize,
			int newSize, NBTTagCompound dataContainer) {

	}

	/**
	 * Channels methods called on Tiles to the FluidHandler in FanBoxFluidsBase;
	 * 
	 * 
	 */
	public int fill(ForgeDirection from, FluidStack resource, boolean doFill) {
		return this.fluidHandler.fill(from, resource, doFill);
	}

	public FluidStack drain(ForgeDirection from, FluidStack resource,
			boolean doDrain) {
		return this.fluidHandler.drain(from, resource, doDrain);
	}

	public FluidStack drain(ForgeDirection from, int maxDrain, boolean doDrain) {
		return this.fluidHandler.drain(from, maxDrain, doDrain);
	}

	public boolean canFill(ForgeDirection from, Fluid fluid) {
		return this.fluidHandler.canFill(from, fluid);
	}

	public boolean canDrain(ForgeDirection from, Fluid fluid) {
		return this.fluidHandler.canDrain(from, fluid);
	}

	public FluidTankInfo[] getTankInfo(ForgeDirection from) {
		return this.fluidHandler.getTankInfo(from);
	}

}
