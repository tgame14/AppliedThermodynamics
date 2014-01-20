package com.tgame.apptherm.multiblocks;

import java.util.HashSet;
import java.util.Set;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTankInfo;

import com.tgame.apptherm.AppTherm;
import com.tgame.apptherm.libs.multiblocks.common.CoordTriplet;
import com.tgame.apptherm.libs.multiblocks.multiblock.IMultiblockPart;
import com.tgame.apptherm.libs.multiblocks.multiblock.MultiblockControllerBase;
import com.tgame.apptherm.libs.multiblocks.multiblock.MultiblockValidationException;
import com.tgame.apptherm.multiblocks.handlers.FanBoxFluidHandler;
import com.tgame.apptherm.tileentities.fanbox.TileEntityFluidPort;
import com.tgame.apptherm.tileentities.fanbox.TileEntityInternalTank;
import com.tgame.apptherm.tileentities.fanbox.TileEntityMEPort;
import com.tgame.apptherm.tileentities.fanbox.TileEntityReactionChamber;

public class FanBoxControllerBase extends MultiblockControllerBase {

	protected Set<Class> requiredTiles;
	protected Set<CoordTriplet> setOfInternalTanks;
	protected Set<CoordTriplet> setOfReactionChamber;
	protected boolean isPowered;

	private FanBoxFluidHandler fluidHandler;

	public FanBoxControllerBase(World world) {
		super(world);

		this.requiredTiles = fillSet();
		this.isPowered = false;

	}

	/**
	 * 
	 * A Separate constructor used for the spatial transfer from Applied
	 * Energistics, DO NOT USE.
	 * 
	 * @param World
	 *            world
	 * @param nbttagCompound
	 *            tag
	 * 
	 * @author tgame14
	 */

	public FanBoxControllerBase(World world, NBTTagCompound tag) {
		super(world);

		this.requiredTiles = fillSet();

		writeToNBT(tag);
	}

	public void setPoweredStatus(boolean powerstatus) {
		this.isPowered = powerstatus;
	}

	public Set<CoordTriplet> getSetOfInternalTanks() {
		return this.setOfInternalTanks;
	}

	public Set<CoordTriplet> getSetOfReactionChambers() {
		return this.setOfReactionChamber;
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
		if (!checkForRequiredTiles())
			return false;

		this.setOfInternalTanks = calcAmountOfClass(TileEntityInternalTank.class);
		this.setOfReactionChamber = calcAmountOfClass(TileEntityReactionChamber.class);

		return super.isMachineWhole();
	}

	/**
	 * a method that checks the height of the multiblock and returns whether or
	 * not its valid for the minimal parameter given to it
	 * 
	 * @param int the minimum height of the controller
	 * @return whether or not it is valid
	 * 
	 * @author tgame14
	 */
	protected boolean getMinimumHeight(int minimalHeight) {
		CoordTriplet min = this.getMinimumCoord();
		CoordTriplet max = this.getMaximumCoord();

		if (Math.abs(max.y - min.y) < (minimalHeight - 1))
			return false;
		return true;
	}

	protected boolean checkForRequiredTiles() {
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

	/**
	 * grabs all Instances of @param Class clazz, Wraps them in a
	 * HashSet<CoordTriplet> and returns that.
	 * 
	 * @param Class
	 *            clazz of the instance of the tile in multiblock
	 * @return the hash set Containing the CoordTriplet of all internal Tanks
	 * 
	 * @author tgame14
	 */

	private HashSet<CoordTriplet> calcAmountOfClass(Class clazz) {
		HashSet<CoordTriplet> hashSet = new HashSet<CoordTriplet>();

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

		this.fluidHandler = new FanBoxFluidHandler(this.setOfInternalTanks,
				this.setOfReactionChamber);

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
		return MultiblockInfo.FanBoxXSize;
	}

	@Override
	protected int getMaximumZSize() {
		return MultiblockInfo.FanBoxZSize;
	}

	@Override
	protected int getMaximumYSize() {
		return MultiblockInfo.FanBoxYSize;
	}

	/* Allows to set minimal Sizes now. removes getMinimalHeight(). */

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

	}

	@Override
	protected void onAssimilated(MultiblockControllerBase assimilator) {

	}

	@Override
	protected boolean updateServer() {
		if (this.fluidHandler == null) {
			AppTherm.log
					.warning("Fluid Handler is null For Controller at %d, %d, %d"
							+ referenceCoord);
			this.fluidHandler = new FanBoxFluidHandler(setOfInternalTanks,
					setOfReactionChamber);
			return false;
		}

		if (this.isPowered)
			return this.fluidHandler.onUpdateServerTick();

		return false;
	}

	@Override
	protected void updateClient() {

	}

	@Override
	public void writeToNBT(NBTTagCompound tag) {
		if (this.fluidHandler != null)
			this.fluidHandler.writeToNBT(tag);

		if (this.setOfInternalTanks != null)
			tag.setInteger("intTankSize", this.setOfInternalTanks.size());
		if (this.setOfReactionChamber != null)
			tag.setInteger("reactSize", this.setOfReactionChamber.size());
	}

	@Override
	public void readFromNBT(NBTTagCompound tag) {
		if (this.fluidHandler == null)
			this.fluidHandler = new FanBoxFluidHandler(
					tag.getInteger("intTankSize"), tag.getInteger("reactSize"));

		this.fluidHandler.readFromNBT(tag);
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

	/* Links to FanBoxFluidHandler to handle fluids. Merely a connection. */

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
