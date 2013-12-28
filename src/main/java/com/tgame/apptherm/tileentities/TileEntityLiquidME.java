package com.tgame.apptherm.tileentities;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.MinecraftForge;
import appeng.api.WorldCoord;
import appeng.api.events.GridTileLoadEvent;
import appeng.api.events.GridTileUnloadEvent;
import appeng.api.me.tiles.IGridTileEntity;
import appeng.api.me.util.IGridInterface;

import com.tgame.apptherm.blocks.BlockInfo;

public class TileEntityLiquidME extends TileEntity implements IGridTileEntity {

	private boolean powerStatus = true;
	private IGridInterface grid;
	private int spreadTimer;
	private int solidTimer;
	private boolean ticked;

	public TileEntityLiquidME() {
		spreadTimer = 1200;
		solidTimer = 12000;
		ticked = false;

	}

	@Override
	public void updateEntity() {
		if (!worldObj.isRemote) {
			if (!ticked) {
				solidTimer = (int) (12000 * getBiomeCustomTemp());
				ticked = true;
			}
			checkSpread();
			solidify();
		}
	}

	private double getBiomeCustomTemp() {
		final double temp = worldObj.getBiomeGenForCoords(xCoord, zCoord)
				.getIntTemperature() / 65536.0;
		if (temp < 0.11)
			return 0.11;
		return temp;
	}

	private void solidify() {
		if (solidTimer == 0 && worldObj.getBlockMetadata(xCoord, yCoord, zCoord) == 0) {
			worldObj.setBlock(xCoord, yCoord, zCoord, BlockInfo.JELLO_ID);
		}
		solidTimer--;

	}

	private void checkSpread() {
		if (spreadTimer == 0) {
			for (ForgeDirection dir : ForgeDirection.VALID_DIRECTIONS) {
				final int x = xCoord + dir.offsetX;
				final int y = yCoord + dir.offsetY;
				final int z = zCoord + dir.offsetZ;
				final TileEntity te = worldObj.getBlockTileEntity(x, y, z);

				if (te != null && te instanceof IGridTileEntity
						&& !(te instanceof TileEntityLiquidME) && te instanceof TileEntityMEExhaust) {
					this.worldObj.setBlock(x, y, z, BlockInfo.LIQUID_ME_ID, 0,
							3);
				}
			}
			spreadTimer = 1200;
		}
		spreadTimer--;
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
		powerStatus = hasPower;

	}

	@Override
	public boolean isPowered() {
		return powerStatus;

	}

	@Override
	public IGridInterface getGrid() {
		return grid;

	}

	@Override
	public void setGrid(IGridInterface gi) {
		grid = gi;

	}

	@Override
	public World getWorld() {
		return worldObj;

	}

	@Override
	public void validate() {
		super.validate();
		MinecraftForge.EVENT_BUS.post(new GridTileLoadEvent(this, worldObj,
				getLocation()));
	}

	@Override
	public void invalidate() {
		super.invalidate();
		MinecraftForge.EVENT_BUS.post(new GridTileUnloadEvent(this, worldObj,
				getLocation()));

	}

	@Override
	public void writeToNBT(NBTTagCompound tag) {
		super.writeToNBT(tag);

		tag.setShort("spreadTimer", (short) spreadTimer);
		tag.setInteger("solidTimer", solidTimer);
		tag.setBoolean("isTicked", ticked);

	}

	@Override
	public void readFromNBT(NBTTagCompound tag) {
		super.readFromNBT(tag);

		spreadTimer = tag.getShort("spreadTimer");
		solidTimer = tag.getInteger("solidTimer");
		ticked = tag.getBoolean("isTicked");

	}

}