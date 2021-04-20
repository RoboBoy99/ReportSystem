package me.RoboBoy99.Reports.commands;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.RoboBoy99.Reports.Report;
import me.RoboBoy99.Reports.data.TicketData;
import me.RoboBoy99.Reports.managers.TicketManager;
import net.md_5.bungee.api.ChatColor;

public class ReportCommand implements CommandExecutor  {
	
    int Number;
	Date TicketDate;
	List<String> whosee = new ArrayList<String>();
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{		
	    if(!cmd.getName().equalsIgnoreCase("Report"))
	        return false;
	    if (!(sender instanceof Player))
	        return false;
	 
	    Player player = (Player) sender;
    
        TicketManager TM = Report.getInstance().TicketManager;
        String Reason = args[1];      
        String targetS;
 	    targetS = args[0];
	    Player target = Bukkit.getPlayer(targetS); 
				 
        if(target != null) {
        	Number++;
            TM.CreateTicket(new TicketData(Number, TicketDate = new Date(), Reason, ChatColor.GREEN + "Waiting", target, player, whosee), Number);
            player.sendMessage(ChatColor.GRAY + "------[" + ChatColor.RED + "Report Info" + ChatColor.GRAY + "]------");
            player.sendMessage(ChatColor.GREEN + "You reported about: " + ChatColor.GOLD + target.getDisplayName());
            player.sendMessage(ChatColor.GREEN + "Reason: " + ChatColor.RED + Reason);
            player.sendMessage(ChatColor.GREEN + "Report Date: " + ChatColor.RED + TicketDate);
            player.sendMessage(ChatColor.GREEN + "Ticket Number: " + ChatColor.AQUA + Number + "#");
            player.sendMessage("");
            player.sendMessage(ChatColor.RED + "#False reporting will result in a punishment!");
            player.sendMessage(ChatColor.GRAY + "------------------------");
	        return true;
        } else {
        	player.sendMessage(ChatColor.RED + "This player is not online");
        	return true;
        }
	}
	
}
	 

	 
