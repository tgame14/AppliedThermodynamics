package com.tgame.apptherm.tileentities;

import java.util.Random;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import appeng.api.WorldCoord;
import appeng.api.events.GridTileLoadEvent;
import appeng.api.events.GridTileUnloadEvent;
import appeng.api.me.tiles.IGridMachine;
import appeng.api.me.util.IGridInterface;

import com.tgame.apptherm.api.definitions.Items;

public class TileEntityMEExhaust extends TileEntity implements IGridMachine {

	private IGridInterface grid;
	private boolean powerStatus, networkReady;
	private ItemStack gooStack;

	Random gen = new Random();
	private int gooTimer;

	public TileEntityMEExhaust() {
		this.gooTimer = 0;
		this.gooStack = Items.goo.stack(1);

		this.powerStatus = false;
		this.networkReady = false;

	}

	@Override
	public void updateEntity() {
		if (!worldObj.isRemote) {

			double x = 0.5, y = 0.5F, z = 0.5;
			if (gooTimer <= 0 && powerStatus) {
				switch (worldObj.getBlockMetadata(xCoord, yCoord, zCoord)) {

				case 2:
					z = -0.5;

				case 3:
					z = 1.5;
				case 4:
					x = -1.5;
				case 5:
					x = 1.5;

					break;
				}
				worldObj.spawnEntityInWorld(new EntityItem(worldObj,
						xCoord + x, yCoord + y, zCoord + z, gooStack));

				gooTimer = gen.nextInt(1000);
			}
			gooTimer--;
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
