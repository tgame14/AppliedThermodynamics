package com.tgame.apptherm.network;

import com.sun.org.apache.bcel.internal.generic.InstructionConstants.Clinit;
import com.tgame.apptherm.config.ConfigInfo;

import net.minecraft.network.INetworkManager;
import net.minecraft.network.NetLoginHandler;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet1Login;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.util.EnumChatFormatting;
import cpw.mods.fml.common.network.IConnectionHandler;
import cpw.mods.fml.common.network.Player;

public class ATConnectionHandler implements IConnectionHandler {

	@Override
	public void playerLoggedIn(Player player, NetHandler netHandler,
			INetworkManager manager) {
		// TODO Auto-generated method stub

	}

	@Override
	public String connectionReceived(NetLoginHandler netHandler,
			INetworkManager manager) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void connectionOpened(NetHandler netClientHandler, String server,
			int port, INetworkManager manager) {
		// TODO Auto-generated method stub

	}

	@Override
	public void connectionOpened(NetHandler netClientHandler,
			MinecraftServer server, INetworkManager manager) {
		// TODO Auto-generated method stub

	}

	@Override
	public void connectionClosed(INetworkManager manager) {
		// TODO Auto-generated method stub

	}

	@Override
	public void clientLoggedIn(NetHandler clientHandler,
			INetworkManager manager, Packet1Login login) {
		clientHandler
				.getPlayer()
				.sendChatToPlayer(
						new ChatMessageComponent()
								.createFromText(EnumChatFormatting.DARK_GRAY
										+ ""
										+ EnumChatFormatting.BOLD
										+ "Currently using version @VERSION@ of Applied Thermodynamics"));
		if (!ConfigInfo.ENABLE_HEAT)
			clientHandler
					.getPlayer()
					.sendChatToPlayer(
							new ChatMessageComponent()
									.createFromText(EnumChatFormatting.DARK_RED
											+ ""
											+ EnumChatFormatting.BOLD
											+ "Heat is disabled. the mod will not operate as intended, To fix this go into the Configuration file and change enable_heat"));

	}

}
