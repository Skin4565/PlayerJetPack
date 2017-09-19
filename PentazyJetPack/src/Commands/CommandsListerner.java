package Commands;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import jetpack.Main;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;





public class CommandsListerner implements CommandExecutor{

	
	
	
	
	
	
	
	
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	  {
	    if ((sender instanceof Player))
	    {
	 
	    	
	    	Player p = ((Player) sender).getPlayer();
	    	
	    	int combustivel = getAmountOf(Material.COAL, 0, p.getInventory());
	    	
	    	
	    	TextComponent message = new TextComponent( "ATIVAR" );
	    	message.setColor( ChatColor.GREEN );
	    	message.setBold( true );
	    	
	
	    	message.setClickEvent( new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/jetpack ativar"));

	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	TextComponent desativar = new TextComponent( "CANCELAR" );
	    	desativar.setColor( ChatColor.RED );
	    	desativar.setBold( true );
	
	    	desativar.setClickEvent( new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/jetpack cancelar"));



	    	
	    	
	    	
	    	
		 
	      if (cmd.getName().equalsIgnoreCase("jetpack"))
	      {
	         if (!(sender instanceof Player)) {
	              sender.sendMessage("This command can only be run by a player.");
	              return true;
	           }
	         
	         if (args.length == 0) {
           	  sender.sendMessage("§7§m-------------------------------");
           	  sender.sendMessage("");
           	  sender.sendMessage("§e§lATIVAR A JETPACK?");
           	  sender.sendMessage("");
           	  p.spigot().sendMessage( message );
           	  p.spigot().sendMessage( desativar );
           	  sender.sendMessage("");
           	  sender.sendMessage("§7§m-------------------------------");

	         }
	         
	         
	         if(args.length == 1){
	        	 if (args[0].equalsIgnoreCase("ativar")) {
	        	 if(p.hasPermission("jetpack.allow")){
           	  
					
			        p.sendMessage("§cVocê já esta com a JetPack ativada!");
				
           		
	        }else{
	        	Inventory motor = Bukkit.getServer().createInventory(p, 54, "§0Motor");
				
				p.openInventory(motor);
	        }
	        
	        	 }
           	if (args[0].equalsIgnoreCase("cancelar")) {
				p.sendMessage(Main.getPlugin().getConfig().getString("JETPACK.CANCELAR-MENSAGEM").replace("&", "§"));

           	}
           	
           	if (args[0].equalsIgnoreCase("reload")) {
				p.sendMessage("§aConfig recaregada xD!");
				Main.getPlugin().reloadConfig();

           	}
		
	              
           	  
           	  
          
           	  
           	  
           	  
	         }
           	  
           	  
           	  
           	  
           	  
           	  
           	  
           	  
           	  
	              	              
	      }
	   
	
	  }
		return false;
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
	
	
	
	
	
	
	
	
	
	
	
	


