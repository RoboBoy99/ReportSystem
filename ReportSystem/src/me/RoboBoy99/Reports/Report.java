package me.RoboBoy99.Reports;

import org.bukkit.plugin.java.JavaPlugin;

import me.RoboBoy99.Reports.commands.ReportCommand;
import me.RoboBoy99.Reports.commands.TicketCommand;
import me.RoboBoy99.Reports.managers.PlayerManager;
import me.RoboBoy99.Reports.managers.TicketManager;


public class Report extends JavaPlugin
{
	private static Report INSTANCE;
	public static Report getInstance() {
		return INSTANCE;
	}
	
	public PlayerManager PlayerManager;
	public TicketManager TicketManager;

	@Override
	public void onEnable() {
		INSTANCE = this;
		PlayerManager = new PlayerManager();
		TicketManager = new TicketManager();
		getCommand("Report").setExecutor(new ReportCommand());
		getCommand("Ticket").setExecutor(new TicketCommand());
	}
	
	public void onDisable() {
		
	}
}
