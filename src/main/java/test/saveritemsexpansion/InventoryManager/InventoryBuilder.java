package test.saveritemsexpansion.InventoryManager;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import test.saveritemsexpansion.ItemStackManager.ItemStacks;

import java.util.List;

public class InventoryBuilder implements InventoryHolder {

    private final Inventory IS;
    private final Inventory ChatColorGui;

    public InventoryBuilder() {
        IS = Bukkit.createInventory(this, 54, "Item Selector");
        ChatColorGui = Bukkit.createInventory(this, 27, "ChatColorGUI");
        InvInit();
    }

    private void InvInit() {
        InventoryItemSelector();
        InventoryChatColorGui();
    }

    private void InventoryItemSelector(){
        List<ItemStack> itemsToAdd = ItemStacks.itemStackList();

        for (ItemStack item : itemsToAdd) {
            IS.setItem(IS.firstEmpty(), item);
        }
    }
    private void InventoryChatColorGui(){
    }

    @Override
    public Inventory getInventory() {
        return IS;
    }
}
