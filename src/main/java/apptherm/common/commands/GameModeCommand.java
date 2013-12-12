package apptherm.common.commands;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.world.EnumGameType;

public class GameModeCommand extends CommandBase implements ICommand {

	private List aliases;

	public GameModeCommand() {
		this.aliases = new ArrayList();
		this.aliases.add("gm");
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getRequiredPermissionLevel() {
		return 2;
	}

	@Override
	public String getCommandName() {
		return "gm";
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender) {
		return "gm <0, 1, 2, s, c, a>";
	}

	@Override
	public List getCommandAliases() {
		return this.aliases;
	}

	@Override
	public void processCommand(ICommandSender icommandsender, String[] astring) {
		if (astring.length == 0) {
			return;
		}
		EnumGameType par1EnumGameType;

		if (astring[0] == "0" || astring[0] == "s") {
			icommandsender
					.sendChatToPlayer(ChatMessageComponent
							.createFromTranslationWithSubstitutions("Setting Gamemode To Survival"));
			//EntityPlayer.setGameType();
		}

		else if (astring[0] == "1" || astring[0] == "c") {
			icommandsender
					.sendChatToPlayer(ChatMessageComponent
							.createFromTranslationWithSubstitutions("Setting Gamemode To Creative"));
		}

		else if (astring[0] == "2" || astring[0] == "a") {
			icommandsender
					.sendChatToPlayer(ChatMessageComponent
							.createFromTranslationWithSubstitutions("Setting Gamemode To adventure"));

		}
	}

	@Override
	public boolean canCommandSenderUseCommand(ICommandSender icommandsender) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List addTabCompletionOptions(ICommandSender icommandsender,
			String[] astring) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isUsernameIndex(String[] astring, int i) {
		// TODO Auto-generated method stub
		return false;
	}

}
