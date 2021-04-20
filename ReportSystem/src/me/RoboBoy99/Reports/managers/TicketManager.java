package me.RoboBoy99.Reports.managers;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nullable;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import me.RoboBoy99.Reports.data.TicketData;
import net.md_5.bungee.api.ChatColor;

public class TicketManager {

	public Map<Integer, TicketData> Ticket;
	
	public TicketManager() {
		Ticket = new HashMap<>();
	}
	
	public void CreateTicket(TicketData TD, int number) 
	{
		Ticket.put(number, TD);
		SendMessageToStaff(number);
	}
	
	
	public void SendMessageToStaff(int number) {
		
		for(Player Staff : Bukkit.getOnlinePlayers()) {
			if(Staff.hasPermission("Report.See")) {
				Staff.sendMessage(ChatColor.GRAY + "--------" + ChatColor.GOLD + "New Report!" + ChatColor.GRAY + "--------");
				Staff.sendMessage(ChatColor.GREEN + "Report made by: " + ChatColor.GREEN + Ticket.get(number).GetReported());
				Staff.sendMessage(ChatColor.GREEN + "Reported Player: " + ChatColor.BLUE + Ticket.get(number).GetAcused());
				Staff.sendMessage(ChatColor.GREEN + "Reason for report: " + ChatColor.RED + Ticket.get(number).GetReason()); 
				Staff.sendMessage(ChatColor.GREEN + "Report Date: " + ChatColor.RED + Ticket.get(number).GetDate());
				Staff.sendMessage(ChatColor.GREEN + "Ticket Number: " + ChatColor.AQUA + Ticket.get(number).GetTicketNumber() + "#");
				
			}
		}
	}
	
	public void GetInfo(int number, Player player) {		
		player.sendMessage(ChatColor.GRAY + "--------" + ChatColor.GOLD + "Viewing Report " + ChatColor.AQUA + Ticket.get(number).GetTicketNumber() + "#" + ChatColor.GRAY + "--------");
		player.sendMessage(ChatColor.GREEN + "Report made by: " + ChatColor.GREEN + Ticket.get(number).GetReported());
		player.sendMessage(ChatColor.GREEN + "Reported Player: " + ChatColor.BLUE + Ticket.get(number).GetAcused());
		player.sendMessage(ChatColor.GREEN + "Reason for report: " + ChatColor.RED + Ticket.get(number).GetReason()); 
		player.sendMessage(ChatColor.GREEN + "Report Date: " + ChatColor.RED + Ticket.get(number).GetDate());
		player.sendMessage(ChatColor.GREEN + "Ticket Number: " + ChatColor.AQUA + Ticket.get(number).GetTicketNumber() + "#");
		if(Ticket.get(number).GetWhoseeList().contains(player.getName() + ",")) {
			player.sendMessage(ChatColor.GREEN + "Status: " + ChatColor.GREEN + "Read by " + "(" + Ticket.get(number).GetWhoseeList() + ")");
		} else {
			Ticket.get(number).GetWhoseeList().add(player.getName() + ",");
			player.sendMessage(ChatColor.GREEN + "Status: " + ChatColor.GREEN + "Read by " + "(" + Ticket.get(number).GetWhoseeList() + ")");
		}
	}
	
	public boolean exist(String number) {
		return Ticket.containsKey(Integer.parseInt(number));
	}
	
	@Nullable
	public TicketData get(String Name) {
		if (!exist(Name))
			return null;

		return Ticket.get(Integer.parseInt(Name));
	}
	
}
