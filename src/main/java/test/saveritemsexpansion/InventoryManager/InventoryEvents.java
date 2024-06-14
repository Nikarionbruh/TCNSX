package test.saveritemsexpansion.InventoryManager;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.inventory.InventoryPickupItemEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.inventory.*;
import test.saveritemsexpansion.ItemStackManager.ItemStacks;

public class InventoryEvents implements Listener {
    @EventHandler
    public void onInvClick(InventoryClickEvent event) {
        if (event.getClickedInventory() == null || event.getCurrentItem() == null) {
            return;
        }

        if (!(event.getClickedInventory().getHolder() instanceof InventoryBuilder)) {
            return;
        }

        event.setCancelled(true);

        Player player = (Player) event.getWhoClicked();
        ItemStack clickedItem = event.getCurrentItem();

        for (ItemStack item : ItemStacks.itemStackList()) {
            if (clickedItem.equals(item)) {
                if (event.isLeftClick()) {
                    player.getInventory().addItem(item);
                    if (clickedItem.equals(ItemStacks.AwakeningTable)) {
                        player.sendMessage("§x§2§B§F§F§3§E§lA§x§2§8§E§8§3§3§lW§x§2§4§D§0§2§8§lA§x§2§1§B§9§1§C§lK§x§1§D§A§1§1§1§lE§x§1§A§8§A§0§6§lN.");
                    }
                    if (clickedItem.equals(ItemStacks.CaptainHat)) {
                        player.sendMessage("§r§x§E§E§F§F§0§0§lS§x§9§5§F§F§5§E§lU§x§3§C§F§F§B§C§lM§x§3§C§F§F§B§C§lM§x§9§5§F§F§5§E§lE§x§E§E§F§F§0§0§lR.");
                    }
                    if (clickedItem.equals(ItemStacks.PirateSpyGlass)) {
                        player.sendMessage("§x§B§7§0§2§F§BD§x§A§F§0§C§F§Bo §x§A§7§1§6§F§Bw§x§9§F§2§0§F§Ch§x§9§6§2§A§F§Ca§x§8§E§3§4§F§Ct §x§8§6§3§E§F§Cy§x§7§E§4§8§F§Co§x§7§6§5§2§F§Cu §x§6§E§5§C§F§Dw§x§6§6§6§6§F§Da§x§5§E§7§0§F§Dn§x§5§5§7§A§F§Dt §x§4§D§8§4§F§D'§x§4§5§8§E§F§Dc§x§3§D§9§8§F§Ea§x§3§5§A§2§F§Eu§x§2§D§A§C§F§Es§x§2§5§B§6§F§Ee §x§1§C§C§0§F§Ea §x§1§4§C§A§F§Fp§x§0§C§D§4§F§Fi§x§0§4§D§E§F§Fr§x§0§5§E§4§F§9a§x§0§E§E§5§E§Et§x§1§8§E§6§E§3e §x§2§2§E§7§D§7i§x§2§B§E§9§C§Cs §x§3§5§E§A§C§1f§x§3§E§E§B§B§5r§x§4§8§E§C§A§Ae§x§5§2§E§E§9§Fe §x§5§B§E§F§9§3Y§x§6§5§F§0§8§8o§x§6§E§F§1§7§Du §x§7§8§F§3§7§1a§x§8§2§F§4§6§6r§x§8§B§F§5§5§Be §x§9§5§F§6§4§Fa §x§9§E§F§8§4§4p§x§A§8§F§9§3§9i§x§B§2§F§A§2§Dr§x§B§B§F§B§2§2a§x§C§5§F§D§1§7t§x§C§E§F§E§0§Be§x§D§8§F§F§0§0!");
                    }
                    if (clickedItem.equals(ItemStacks.WashedAshore)) {
                        player.sendMessage("§b§othe waves...");
                    }
                    player.closeInventory();
                } else if (event.isRightClick()) {
                    player.getInventory().addItem(item);
                }
            }
        }
    }

    @EventHandler
    public void AwakeningTableInvCheck(PlayerSwapHandItemsEvent event){
        Player player = event.getPlayer();
        ItemStack OffHandItem = player.getEquipment().getItemInOffHand();
        if (OffHandItem != null && OffHandItem.equals(ItemStacks.AwakeningTableV)){
            event.setCancelled(true);
        }

    }

    @EventHandler
    public void AwakeningTableVUnmove(InventoryClickEvent event){
        Player player = (Player) event.getWhoClicked();
        ItemStack OffHandItem = player.getEquipment().getItemInOffHand();
        if (OffHandItem != null && OffHandItem.equals(ItemStacks.AwakeningTableV)){
            event.setCancelled(true);
        }

    }


}
