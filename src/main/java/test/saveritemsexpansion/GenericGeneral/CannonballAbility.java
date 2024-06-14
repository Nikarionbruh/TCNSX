package test.saveritemsexpansion.GenericGeneral;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import test.saveritemsexpansion.SaverItemsExpansion;

public class CannonballAbility {
    private Player player;
    private boolean loading;
    private int loadTicks;
    private final int maxLoadTicks;
    private boolean ignoreTask = false;

    public CannonballAbility(Player player, int maxChargeTicks) {
        this.player = player;
        this.maxLoadTicks = maxChargeTicks;
    }

    public void startLoading() {
        Bukkit.getLogger().info("Started 'startLoading'");
        BukkitRunnable task = new AbilityRunnable(this);
        if (!loading) {
            Bukkit.getLogger().info("Rendering 'loading' true");
            loading = true;
            Bukkit.getLogger().info("setting loadTicks to 0");
            loadTicks = 0;
            Bukkit.getLogger().info("checking 'plugin'");
            if (!DoesIgnoreTask()) {
                Bukkit.getLogger().info("correctly called new instance of AbilityRunnable");
                task.runTaskTimer(SaverItemsExpansion.getProvidingPlugin(SaverItemsExpansion.class), 0, 1);
                setIgnoreTask(true);
            } else {
                Bukkit.getLogger().info("task canceled");
                task.cancel();
                setIgnoreTask(false);
            }

        }
    }

    public void stopLoading() {
        loading = false;
    }

    public void executeAction() {
        player.sendMessage("Cannonball loaded executed!");
    }

    public boolean isLoading() {
        return loading;
    }

    public int getLoadTicks() {
        return loadTicks;
    }

    public void setLoadTicks(int loadTicks) {
        this.loadTicks = loadTicks;
    }

    public int getMaxLoadTicks() {
        return maxLoadTicks;
    }

    public Player getPlayer() {
        return player;
    }
    public void setIgnoreTask(boolean value) {
        ignoreTask = value;
    }

    public boolean DoesIgnoreTask(){
        return ignoreTask;
    }


}
