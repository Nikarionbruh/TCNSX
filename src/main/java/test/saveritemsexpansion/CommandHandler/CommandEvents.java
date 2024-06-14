package test.saveritemsexpansion.CommandHandler;

import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;
import test.saveritemsexpansion.ItemStackManager.ItemStacks;

public class CommandEvents implements Listener {

    @EventHandler
    public void logUUID(PlayerInteractEntityEvent event){
        Player player = event.getPlayer();
        Entity entity = event.getRightClicked();
        ItemStack itemInHand = player.getEquipment().getItemInMainHand();
        Boolean isNotNull = itemInHand != null;
        if (!event.isCancelled()){
            if (GenericCommands.isHealthCheckerOn){
                if (isNotNull && itemInHand.equals(ItemStacks.TestItem) ){
                    LivingEntity livingEntity = (LivingEntity) entity;
                    double Health = livingEntity.getHealth();
                    long Rhealth = Math.round(Health);
                    long Hearts = Rhealth / 2;
                    player.sendMessage(ChatColor.GREEN + "Entity Health: " + ChatColor.LIGHT_PURPLE + Health + ChatColor.GREEN + " Or " + ChatColor.LIGHT_PURPLE + Hearts + ChatColor.GREEN + " Hearts");
                    event.setCancelled(true);
                }
            }
        }

    }
}
