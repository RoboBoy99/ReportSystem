package me.RoboBoy99.Reports.commands;


import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.RoboBoy99.Reports.Report;
import me.RoboBoy99.Reports.managers.TicketManager;
import net.md_5.bungee.api.ChatColor;

public class TicketCommand implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{		
	    if(!cmd.getName().equalsIgnoreCase("Ticket"))
	        return false;
	    if (!(sender instanceof Player))
	        return false;
	 
	    Player player = (Player) sender;
    
        TicketManager TM = Report.getInstance().TicketManager;
        String TicketNumber = args[1];      
        if(args.length == 0) {
            
        }
        
        if(args[0].equalsIgnoreCase("View")) {
            if(TM.exist(TicketNumber)){ 
            	TM.GetInfo(Integer.parseInt(TicketNumber), player);
    	        return true;
            } else {
            	player.sendMessage(ChatColor.RED + "You dont have a ticket with this number");
            	return true;
            }
        }
      //  String targetS;
 	   // targetS = args[0];
	   // Player target = Bukkit.getPlayer(targetS); 
		return false;
	}
}
