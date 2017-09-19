package Events;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import com.connorlinfoot.titleapi.TitleAPI;

import ActionBar.ActionBar;
import jetpack.Main;



public class Handlers implements Listener{
	
	
	@EventHandler
	
	public void process(PlayerCommandPreprocessEvent e){
		Player p = e.getPlayer();
		
		
		if(e.getMessage().equalsIgnoreCase("/reload")){
			
			for(Player pn : Bukkit.getOnlinePlayers()){
         	
         	Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + pn.getName() + " remove jetpack.allow");
         	}		
			}	
		}		
	
	
	@EventHandler
	
	public void quit(PlayerQuitEvent e){
		Player p = e.getPlayer();
		
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " remove jetpack.allow");
         				
	}
			
		

	@EventHandler
	
	public void inventoryClose(InventoryCloseEvent e){
		
		Player p = (Player) e.getPlayer();
		

		if (e.getInventory().getName().equalsIgnoreCase("§0Motor")) {
			if(getAmountOf(Material.COAL, 0, e.getInventory()) > 0) {

			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add jetpack.allow");
			
			p.sendMessage(Main.getPlugin().getConfig().getString("JETPACK.ATIVAR-MENSAGEM").replace("&", "§").replace("{combustivel}", "" + getAmountOf(Material.COAL, 0, e.getInventory())));

			new BukkitRunnable() {
				
				int tempo = getAmountOf(Material.COAL, 0, e.getInventory());
				public void run() {
					--tempo;
					if(tempo > 0) {
						p.setAllowFlight(true);
						ActionBar.sendActionBarMessage(p, Main.getPlugin().getConfig().getString("ActionBar-Format-Time").replace("&", "§").replace("{tempo}", "" + tempo) + "");
						
						
					}

					
					else if(tempo == 0) {
						cancel();
						p.setAllowFlight(false);
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " remove jetpack.allow");


					}
				}
			}.runTaskTimer(Main.getPlugin(), 0L, 20L);
			
			
			
			
			
			
			
		}else if(getAmountOf(Material.COAL, 0, e.getInventory()) == 0) {
			p.sendMessage(Main.getPlugin().getConfig().getString("JETPACK.FECHOU-O-MOTOR-SEM-CARREGAR").replace("&", "§").replace("{combustivel}", "" + getAmountOf(Material.COAL, 0, e.getInventory())));

		}
		}
		
		
		
		
		
		
		
		
	}
			
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	public int getAmountOf(Material item, int data, Inventory inventory) {
		int i = 0;
		for (ItemStack is : inventory.getContents()) {
			if (is != null) {
				if (is.getType() == item && is.getData().getData() == data) {
					i += is.getAmount();
				}
			}
		}
		return i;
	
	}
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
