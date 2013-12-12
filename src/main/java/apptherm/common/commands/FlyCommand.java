package apptherm.common.commands;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.util.ChatMessageComponent;

public class FlyCommand extends CommandBase {

	private List aliases;
	
	
	public FlyCommand() {
		this.aliases = new ArrayList();
		this.aliases.add("fly");
	}
	
	@Override
	public int getRequiredPermissionLevel() {
		return 2;
	}
	
	
	@Override
	public String getCommandName() {
		return "fly";
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender) {
		return "fly <true|false>";
	}

	@Override
	public void processCommand(ICommandSender icommandsender, String[] astring) {
		if (astring.length == 0) {
			icommandsender.sendChatToPlayer(ChatMessageComponent.createFromTranslationWithSubstitutions("Invalid Arguments"));
			return;
		}
		//setAllowFlying()
		
		
		
		
	}

}
