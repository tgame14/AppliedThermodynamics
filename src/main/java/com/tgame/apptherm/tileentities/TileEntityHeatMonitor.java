package com.tgame.apptherm.tileentities;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import appeng.api.WorldCoord;
import appeng.api.events.GridTileLoadEvent;
import appeng.api.events.GridTileUnloadEvent;
import appeng.api.me.tiles.IGridMachine;
import appeng.api.me.util.IGridInterface;

public class TileEntityHeatMonitor extends TileEntity implements IInventory,
		IGridMachine {

	private boolean ticked, powerStatus, networkReady;
	private IGridInterface grid;
	private int ObservingGuiCount;

	private int tickTimer;

	private ItemStack[] items;

	public TileEntityHeatMonitor() {
		ticked = false;
		tickTimer = 10;

		items = new ItemStack[9];

	}

	@Override
	public void updateEntity() {

	}

	@Override
	public int getSizeInventory() {
		return items.length;
	}

	@Override
	public ItemStack getStackInSlot(int i) {
		return items[i];
	}

	@Override
	public ItemStack decrStackSize(int i, int count) {
		ItemStack is = getStackInSlot(i);
		if (is != null) {
			if (is.stackSize <= count) {
				setInventorySlotContents(i, null);
			}
			else {
				is = is.splitStack(count);
				onInventoryChanged();
			}
		}

		return is;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int i) {
		ItemStack is = getStackInSlot(i);
		setInventorySlotContents(i, null);
		return is;
	}

	@Override
	public void setInventorySlotContents(int i, ItemStack itemstack) {
		items[i] = itemstack;

		if (itemstack != null && itemstack.stackSize > getInventoryStackLimit()) {
			itemstack.stackSize = getInventoryStackLimit();
		}
	}

	@Override
	public String getInvName() {
		return "MEHeatMonitor";
	}

	@Override
	public boolean isInvNameLocalized() {
		return true;
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer entityplayer) {
		return entityplayer.getDistanceSq(xCoord + 0.5, yCoord + 0.5,
				zCoord + 0.5) <= 64;
	}

	@Override
	public void openChest() {
		// TODO Auto-generated method stub

	}

	@Override
	public void closeChest() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		// if want to whitelist a specific item only, do here.
		return false;
	}

	@Override
	public void writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);

		NBTTagList items = new NBTTagList();

		for (int i = 0; i < getSizeInventory(); i++) {
			ItemStack stack = getStackInSlot(i);

			if (stack != null) {
				NBTTagCompound item = new NBTTagCompound();
				item.setByte("Slot", (byte) i);
				stack.writeToNBT(item);
				items.appendTag(item);
			}
		}

		compound.setTag("ItemHandler", items);
	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);

		NBTTagList items = compound.getTagList("ItemHandler");

		for (int i = 0; i < items.tagCount(); i++) {
			NBTTagCompound item = (NBTTagCompound) items.tagAt(i);
			int slot = item.getByte("Slot");

			if (slot >= 0 && slot < getSizeInventory()) {
				setInventorySlotContents(slot,
						ItemStack.loadItemStackFromNBT(item));
			}
		}
	}

	@Override
	public void validate() {
		super.validate();
		MinecraftForge.EVENT_BUS.post(new GridTileLoadEvent(this,
				this.worldObj, getLocation()));
	}

	@Override
	public void invalidate() {
		super.invalidate();
		MinecraftForge.EVENT_BUS.post(new GridTileUnloadEvent(this,
				this.worldObj, getLocation()));
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
		this.powerStatus = hasPower;

	}

	@Override
	public boolean isPowered() {
		return this.powerStatus;

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
	public World getWorld() {
		return this.worldObj;

	}

	@Override
	public float getPowerDrainPerTick() {
		return 0;
	}

	@Override
	public void setNetworkReady(boolean isReady) {
		this.networkReady = isReady;

	}

	@Override
	public boolean isMachineActive() {
		if (this.networkReady && this.powerStatus)
			return true;
		return false;

	}

}
