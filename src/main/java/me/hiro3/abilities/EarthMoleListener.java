package me.hiro3.abilities;

import com.projectkorra.projectkorra.BendingPlayer;
import com.projectkorra.projectkorra.ability.CoreAbility;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;

public class EarthMoleListener implements Listener {

	@EventHandler
	public void onSneak(PlayerToggleSneakEvent event) {
		Player player = event.getPlayer();
		BendingPlayer bPlayer = BendingPlayer.getBendingPlayer(player);

		if (event.isCancelled() || bPlayer == null) {
			return;
		}

		if (bPlayer.getBoundAbilityName().equalsIgnoreCase(null)) {
			return;
		}

		if (player.isSneaking())
			return;
		
		if (bPlayer.getBoundAbilityName().equalsIgnoreCase("EarthMole")) {
			if (CoreAbility.getAbility(player, EarthMole.class) == null) {
				new EarthMole(player);
			}
		}

	}
	
}