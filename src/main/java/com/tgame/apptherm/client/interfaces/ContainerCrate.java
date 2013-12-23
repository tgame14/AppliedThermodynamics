package com.tgame.apptherm.client.interfaces;

import com.tgame.apptherm.tileentities.TileEntityCrate;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerCrate extends Container {

	private TileEntityCrate crate;

	public ContainerCrate(InventoryPlayer invPlayer,
			TileEntityCrate crate) {
		this.crate = crate;
		
		for (int x = 0; x < 9; x++) {
			addSlotToContainer(new Slot(invPlayer, x, 8 + 18 * x, 130));
		}
		
		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 9; x++) {
				addSlotToContainer(new Slot(invPlayer, x + y * 9 + 9, 8 + 18 * x, 72 + y * 18));
			}
		}
		
		for(int x = 0; x < 9; x++) {
			addSlotToContainer(new Slot(crate, x, 8 + 18 * x, 17));
		}
		
		
		
	}
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2) {
		return null;
	}

	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		return crate.isUseableByPlayer(entityplayer);
	}
	
	public TileEntityCrate getCrate() {
		return crate;
	}

}
