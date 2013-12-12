package apptherm.common.client.interfaces;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import apptherm.common.AppTherm;
import apptherm.common.tileentities.TileEntityCan;
import apptherm.common.tileentities.TileEntityCrate;
import apptherm.common.tileentities.TileEntityHeatMonitor;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;

public class GuiHandler implements IGuiHandler {

	public GuiHandler() {
		NetworkRegistry.instance().registerGuiHandler(AppTherm.instance, this);
	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch (ID) {

		case 0:
			TileEntity te2 = world.getBlockTileEntity(x, y, z);
			if (te2 != null && te2 instanceof TileEntityCrate) {
				return new ContainerCrate(player.inventory, (TileEntityCrate) te2);
			}
			break;
		case 1:
			TileEntity monitorTile = world.getBlockTileEntity(x, y, z);

			if (monitorTile != null && monitorTile instanceof TileEntityHeatMonitor) {
				return new ContainerMonitor(player.inventory, (TileEntityHeatMonitor) monitorTile);
			}
			break;
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch (ID) {

		case 0:
			TileEntity te2 = world.getBlockTileEntity(x, y, z);
			if (te2 != null && te2 instanceof TileEntityCrate) {
				return new GuiCrate(player.inventory, (TileEntityCrate) te2);
			}
			break;
		case 1:
			TileEntity monitorTile = world.getBlockTileEntity(x, y, z);

			if (monitorTile != null && monitorTile instanceof TileEntityHeatMonitor) {
				return new GuiMonitor(player.inventory, (TileEntityHeatMonitor) monitorTile);
			}

		}
		return null;

	}

}
