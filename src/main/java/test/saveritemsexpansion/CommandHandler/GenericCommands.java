package test.saveritemsexpansion.CommandHandler;

import org.bukkit.ChatColor;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import test.saveritemsexpansion.InventoryManager.InventoryBuilder;

import java.util.*;

public class GenericCommands implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player player){
            return onPlayerCommand(sender, cmd, label, args);
        }
        if (sender instanceof ConsoleCommandSender){
            return onConsoleCommand(sender, cmd, label, args);
        }
        return false;
    }
    public static Boolean isHealthCheckerOn = false;
    public boolean onPlayerCommand (CommandSender sender, Command cmd, String label, String[] args){

        Player player = (Player) sender;
        if (cmd.getName().equalsIgnoreCase("ItemSelector")) {
            InventoryBuilder ISG = new InventoryBuilder();
            player.openInventory(ISG.getInventory());
            if (checkCooldown(player)) {
                player.sendMessage(ChatColor.GREEN + "§ooh noar, a hackur!");
            }
        }
        if (cmd.getName().equalsIgnoreCase("CheckABS")){
            Double ABSMAX = player.getAttribute(Attribute.GENERIC_MAX_ABSORPTION).getBaseValue();
            Double ABSCUR = player.getAbsorptionAmount();
            String ABSMAXs = ABSMAX.toString();
            String ABSCURs = ABSCUR.toString();
            player.sendMessage(ChatColor.AQUA + "The max amount of Absorption hearts you can have is '" + ABSMAXs + "'.");
            if (ABSCUR.equals(ABSMAX)){
                player.sendMessage(ChatColor.AQUA + "The current amount of Absorption hearts you can have is Max");
            } else {
                player.sendMessage(ChatColor.AQUA + "The current amount of Absorption hearts you can have is '" + ABSCURs + "'.");
            }
        }
        if (cmd.getName().equalsIgnoreCase("CheckHealth")){
            if (isHealthCheckerOn){
                isHealthCheckerOn = false;
                player.sendMessage(ChatColor.AQUA + "healthchecker has been turned" + ChatColor.RED + " OFF.");
            } else {
                isHealthCheckerOn = true;
                player.sendMessage(ChatColor.AQUA + "healthchecker has been turned" + ChatColor.GREEN + " ON.");
            }
        }
        if (cmd.getName().equalsIgnoreCase("SelfHealth")){
            double health = player.getHealth();
            long Rhealth = Math.round(health);
            long Hearts = Rhealth / 2;
            player.sendMessage(ChatColor.GREEN + "Your Health: " + ChatColor.LIGHT_PURPLE + health + ChatColor.GREEN + " Or " + ChatColor.LIGHT_PURPLE + Hearts + ChatColor.GREEN + " Hearts");
        }

        return true;
    }

    private boolean onConsoleCommand (CommandSender sender, Command cmd, String label, String[] args){

        return true;
    }
    private final Map<UUID, Long> lastCommandExecution = new HashMap<>();
    private static final long COOLDOWN_DURATION = 10 * 60 * 1000; // 10 minutes in milliseco

    private boolean checkCooldown(Player player) {
        UUID playerId = player.getUniqueId();
        long currentTime = System.currentTimeMillis();
        long lastExecutionTime = lastCommandExecution.getOrDefault(playerId, 0L);

        if (currentTime - lastExecutionTime >= COOLDOWN_DURATION) {
            lastCommandExecution.put(playerId, currentTime);
            return true;
        }

        return false;

    }
}
