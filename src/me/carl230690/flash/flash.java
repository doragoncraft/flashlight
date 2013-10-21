package me.carl230690.flash;

import java.util.logging.Logger;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class flash extends JavaPlugin {
	
    public final Logger logger = Logger.getLogger("Minecraft");
	public static flash plugin;

  public void onEnable()
  {
	    PluginDescriptionFile pdfFile = this.getDescription();
	    this.logger.info(pdfFile.getName() + " Version " + pdfFile.getVersion() + " Has Been Enabled!");
  }

  public void onDisable()
  {
	    PluginDescriptionFile pdfFile = this.getDescription();
	    this.logger.info(pdfFile.getName() + " Has Been Disabled!");
  }

  public boolean onCommand(CommandSender sender, Command cmd, String Label, String[] args) {
    Player p = (Player)sender;
    if ((!p.hasPermission("flash.on")) || (!p.isOp())) {
      p.sendMessage(ChatColor.RED + "You need permission to do that!");
    }
    if ((p.hasPermission("flash.on")) || (p.isOp())) {
      cmd.getName().equalsIgnoreCase("flashon");

      if (!p.hasPotionEffect(PotionEffectType.NIGHT_VISION))
      {
        p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 2000000, 2, true));

        p.sendMessage(ChatColor.GREEN + "Flashlight on!");
      }

      if ((!p.hasPermission("flash.off")) || (!p.isOp())) {
        p.sendMessage(ChatColor.RED + "You need permission to do that!");
      }
      if ((cmd.getName().equalsIgnoreCase("flashoff")) && (
        ((p.hasPermission("flashlight.off")) || (!p.isOp())) || 
        (p.hasPotionEffect(PotionEffectType.NIGHT_VISION))))
      {
        p.removePotionEffect(PotionEffectType.NIGHT_VISION);

        p.sendMessage(ChatColor.RED + "Flashlight off!");
      }

    }

    return true;
  }
}