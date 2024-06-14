package test.saveritemsexpansion.GenericGeneral;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import test.saveritemsexpansion.SaverItemsExpansion;

import javax.swing.*;

public class AbilityRunnable extends BukkitRunnable {
    private final CannonballAbility cannonballAbility;

    public AbilityRunnable(CannonballAbility cannonballAbility) {
        this.cannonballAbility = cannonballAbility;

        runTaskTimer(SaverItemsExpansion.getProvidingPlugin(SaverItemsExpansion.class), 0, 1);
    }

    @Override
    public void run() {
        Bukkit.getLogger().info("Loading.");
        if (cannonballAbility.isLoading()){
            int loadTicks = cannonballAbility.getLoadTicks();
            loadTicks++;
            cannonballAbility.setLoadTicks(loadTicks);
            if (cannonballAbility.getLoadTicks() >= cannonballAbility.getMaxLoadTicks()){
                cannonballAbility.executeAction();
                cancel();
            }
        } else  {
            Bukkit.getLogger().info("Canceled.");
            cancel();
        }
    }

    @Override
    public void cancel() {
        super.cancel();
    }

}
