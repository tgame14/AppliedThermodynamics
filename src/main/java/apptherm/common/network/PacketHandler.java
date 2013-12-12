package apptherm.common.network;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import apptherm.common.client.interfaces.ContainerCrate;
import apptherm.common.client.interfaces.ContainerMonitor;
import apptherm.common.client.interfaces.GuiMonitor;
import apptherm.common.items.ItemHeatRecorder;
import apptherm.common.logic.HeatEffects;
import apptherm.common.tileentities.TileEntityCrate;
import apptherm.common.tileentities.TileEntityHeatMonitor;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;

import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;

public class PacketHandler implements IPacketHandler {

	@Override
	public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player) {
		ByteArrayDataInput reader = ByteStreams.newDataInput(packet.data);

		EntityPlayer entityPlayer = (EntityPlayer) player;

		byte packetId = reader.readByte();

		switch (packetId) {

		case 0:

			byte buttonId = reader.readByte();
			Container container = entityPlayer.openContainer;
			if (container != null && container instanceof ContainerCrate) {
				TileEntityCrate crate = ((ContainerCrate) container).getCrate();
				crate.receiveButtonEvent(buttonId);
			}

			break;

		case 1:
			byte effectId = reader.readByte();
			int x = reader.readInt();
			int y = reader.readInt();
			int z = reader.readInt();

			HeatEffects.receiveEntityFXPacket(effectId, x, y, z);
			break;

		case 2:
			byte textId = reader.readByte();
			double heatValue = reader.readFloat();
			double powerintake = reader.readFloat();

			ItemHeatRecorder.receiveHeatDataPacket(entityPlayer, heatValue, textId, powerintake);
			break;
			
		case 3:
			float heatData = reader.readFloat();
			
			GuiScreen screen = Minecraft.getMinecraft().currentScreen;
			
			if(screen != null && screen instanceof GuiMonitor) {
				GuiMonitor monitor = (GuiMonitor) screen;
				monitor.receiveHeatDataPacket(heatData);
			}
			
			break;
		
		}
		
		

	}

}
