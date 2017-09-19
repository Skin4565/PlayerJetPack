package jetpack;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import Commands.CommandsListerner;

import Events.Handlers;



public class Main extends JavaPlugin implements Listener{
	
	public static JavaPlugin plugin;

	
	
	public void onEnable(){
    	plugin = this;

		
		getCommand("jetpack").setExecutor(new CommandsListerner());

		
		saveDefaultConfig();
		
		
        Bukkit.getServer().getPluginManager().registerEvents(new Handlers(), this);

		
		
		
		
		
		
		
		
		
		
	}
	
	
	public static Main getPlugin()
	  {
	    return (Main)getPlugin(Main.class);
	  }
	
	

	
	
	
	
	
	
	
	

}
