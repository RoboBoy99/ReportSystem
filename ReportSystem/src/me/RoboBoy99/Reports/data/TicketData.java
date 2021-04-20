package me.RoboBoy99.Reports.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bukkit.entity.Player;

public class TicketData {

	
	Player acused;
	Player PlayerReporter;
	
	String reason;
	String status;	
	
	Date TicketData;
	
	int TicketNumber;
	
	List<String> WhoseeTheTicket = new ArrayList<String>();
	
	public TicketData(int TicketNumber, Date date, String reason, String status, Player acused, Player Reporter, List<String> WhoSeeTheTicket) {
		this.acused = acused;
		this.PlayerReporter = Reporter;
		this.TicketData =  date;
		this.TicketNumber = TicketNumber;
		this.reason = reason;
		this.status = status;;
		this.WhoseeTheTicket = WhoSeeTheTicket;
	}
	
	public List<String> GetWhoseeList(){
		return WhoseeTheTicket;
	}
	
	public int GetTicketNumber() {
		return TicketNumber;
		
	}
	
	public String GetReported() {
		return PlayerReporter.getName();
	}
	
	public String GetAcused() {
		return acused.getName();
	}
	
	
	public String Getstatus() {
		return status;
		
	}
	
	public String GetReason() {
		return reason;
		
	}
	
	public Date GetDate() {
		return TicketData;
	}
}
