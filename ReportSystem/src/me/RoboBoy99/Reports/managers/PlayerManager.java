package me.RoboBoy99.Reports.managers;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.entity.Player;

import me.RoboBoy99.Reports.data.PlayerData;
import net.md_5.bungee.api.ChatColor;

public class PlayerManager {

	public Map<UUID, PlayerData> PD;
	
	public PlayerManager(){
		PD = new HashMap<>();
	}
	
	public void GetWarning(UUID player, Player sender) {
		if(PD.get(player) != null) {
			sender.sendMessage("Warning" + PD.get(player).GetWarningAmount());
		} else {
			sender.sendMessage(ChatColor.DARK_RED + "Player Info can't be found");
		}
	}
}
