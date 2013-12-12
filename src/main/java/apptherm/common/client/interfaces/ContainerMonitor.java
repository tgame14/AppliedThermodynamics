package apptherm.common.client.interfaces;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import apptherm.common.ModInfo;
import apptherm.common.logic.LogicBase;
import apptherm.common.network.PacketDistributer;
import apptherm.common.tileentities.TileEntityHeatMonitor;

public class ContainerMonitor extends Container {

	protected TileEntityHeatMonitor tile;
	protected float heatvalue;

	@Override
	public void detectAndSendChanges() {
		super.detectAndSendChanges();
		LogicBase logic = (LogicBase) tile.getGrid().getCacheByID(
				ModInfo.heatCacheID);
		heatvalue = (float) logic.getFinalHeat();

		PacketDistributer.sendHeatDataToGui(heatvalue, tile.xCoord,
				tile.yCoord, tile.zCoord, tile.worldObj.provider.dimensionId);

	}

	public ContainerMonitor(InventoryPlayer invPlayer, TileEntityHeatMonitor te) {
		tile = te;
		heatvalue = 0;

		for (int j = 0; j < 9; j++) {
			addSlotToContainer(new Slot(invPlayer, j, 8 + 18 * j, 130));
		}

		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 9; x++) {
				addSlotToContainer(new Slot(invPlayer, x + y * 9 + 9,
						8 + 18 * x, 72 + y * 18));
			}
		}

	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2) {
		return null;
	}

	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		return tile.isUseableByPlayer(entityplayer);
	}

	public TileEntityHeatMonitor getMonitor() {
		return tile;
	}

	public void setHeatValue(float heat) {
		heatvalue = heat;
	}

}
