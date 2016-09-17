package com.iteamcn.NeedMoreQuestion;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor{

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("nmq")){
			sender.sendMessage("/nmq reload ÖØÔØÅäÖÃÎÄ¼ş");
		}
		return true;
	}
	
}
