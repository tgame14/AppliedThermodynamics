package com.tgame.apptherm.network;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import com.tgame.apptherm.ModInfo;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.ChunkCoordinates;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.network.Player;

public class PacketDistributer {

	public static void sendButtonPacket(byte id) {
		ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
		DataOutputStream dataStream = new DataOutputStream(byteStream);

		try {
			dataStream.writeByte((byte) 0);
			dataStream.writeByte(id);

			PacketDispatcher.sendPacketToServer(PacketDispatcher.getPacket(ModInfo.CHANNEL, byteStream.toByteArray()));
		}
		catch (IOException ex) {
			System.err.append("Failed to send button click packet");
			ex.printStackTrace();
		}
	}

	public static void sendEffectPacket(byte id, int x, int y, int z, int dimID) {

		ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
		DataOutputStream dataStream = new DataOutputStream(byteStream);

		try {
			dataStream.writeByte((byte) 1);
			dataStream.writeByte(id);
			dataStream.writeInt(x);
			dataStream.writeInt(y);
			dataStream.writeInt(z);

			PacketDispatcher.sendPacketToAllAround(x, y, z, 100, dimID,
					PacketDispatcher.getPacket(ModInfo.CHANNEL, byteStream.toByteArray()));

		}
		catch (IOException ex) {
			System.err.append("Failed To Send Heat Effect Packet");
			ex.printStackTrace();
		}
	}

	public static void sendHeatItemData(byte textId, double heatValue, EntityPlayer player, double poweruptake) {
		ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
		DataOutputStream dataStream = new DataOutputStream(byteStream);

		try {
			dataStream.writeByte((byte) 2);
			dataStream.writeByte(textId);
			dataStream.writeFloat((float) heatValue);
			dataStream.writeFloat((float) poweruptake);

			PacketDispatcher.sendPacketToPlayer(PacketDispatcher.getPacket(ModInfo.CHANNEL, byteStream.toByteArray()),
					(Player) player);

		}
		catch (IOException ex) {
			System.err.append("Failed to Send Heat Recorder Packet");
			ex.printStackTrace();
		}
	}

	public static void sendHeatDataToGui(float heatValue, int x, int y, int z, int dimId) {
		ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
		DataOutputStream dataStream = new DataOutputStream(byteStream);

		try {
			dataStream.writeByte((byte) 3);
			dataStream.writeFloat(heatValue);

			PacketDispatcher.sendPacketToAllAround(x, y, z, 10, dimId,
					PacketDispatcher.getPacket(ModInfo.CHANNEL, byteStream.toByteArray()));
		}
		catch (IOException ex) {
			System.err.append("Failed to Send Heat Data to Monitor Gui");
			ex.printStackTrace();
		}
	}

}
