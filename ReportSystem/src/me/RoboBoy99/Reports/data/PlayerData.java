package me.RoboBoy99.Reports.data;

import java.util.Date;
import java.util.UUID;

public class PlayerData 
{
	UUID playerUUID;
	int BanAmount;
	int Warning;
	
	Date banData = new Date();
	
	boolean BeenBanbefore;
	boolean Ismuted;

	public UUID GetPlayer() {
		return playerUUID;
		
	}
	public int GetBanAmount() {
		return BanAmount;
		
	}
	
	public int GetWarningAmount() {
		return Warning;
		
	}
	
	public boolean BeenBanbefore() {
		return BeenBanbefore;
		
	}
	
	public boolean Ismuted() {
		return Ismuted;
	}
	
	public Date BanData() {
		return banData;
		
	}
}
