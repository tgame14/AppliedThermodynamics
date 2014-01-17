package com.tgame.apptherm.tileentities;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public abstract class AEActiveCoolants extends TileEntity {

	protected boolean isActive;
	
	public AEActiveCoolants() {
		isActive = false;
		
	}
	
	public boolean getIsActive() {
		return this.isActive;
	}
	
	public void setIsActive(boolean state) {
		this.isActive = state;
		
	}
	
	@Override
	public void writeToNBT(NBTTagCompound tag) {
		tag.setBoolean("activeState", this.isActive);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound tag) {
		this.isActive = tag.getBoolean("activeState");
	}
	
}
