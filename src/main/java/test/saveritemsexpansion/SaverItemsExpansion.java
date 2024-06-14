package test.saveritemsexpansion;

import org.bukkit.plugin.java.JavaPlugin;
import test.saveritemsexpansion.CommandHandler.CommandEvents;
import test.saveritemsexpansion.CommandHandler.GenericCommands;
import test.saveritemsexpansion.InventoryManager.InventoryEvents;
import test.saveritemsexpansion.ItemStackManager.ItemEvents;
import test.saveritemsexpansion.ItemStackManager.ItemStacks;


public final class SaverItemsExpansion extends JavaPlugin {


    @Override
    public void onEnable() {
        // Plugin startup logic
        ItemStacks.init();
        getCommand("ItemSelector").setExecutor(new GenericCommands());
        getCommand("CheckABS").setExecutor(new GenericCommands());
        getCommand("CheckHealth").setExecutor(new GenericCommands());
        getCommand("SelfHealth").setExecutor(new GenericCommands());

        getServer().getPluginManager().registerEvents(new CommandEvents(), this);
        getServer().getPluginManager().registerEvents(new InventoryEvents(), this);
        getServer().getPluginManager().registerEvents(new ItemEvents(), this);



    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
