package test.saveritemsexpansion.ItemStackManager;

import org.bukkit.*;
import org.bukkit.attribute.Attribute;
import org.bukkit.block.Block;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import java.util.*;

public class ItemEvents implements Listener {

    @EventHandler
    public void RCWear(PlayerInteractEvent event){
        Player player = event.getPlayer();
        ItemStack itemInHand = player.getEquipment().getItemInMainHand();
        Action action = event.getAction();
        Action rightClickAir = Action.RIGHT_CLICK_AIR;
        Action rightClickBlock = Action.RIGHT_CLICK_BLOCK;
        boolean isRightClick = (action == rightClickAir) || (action == rightClickBlock);
        boolean isNotNull = itemInHand != null && itemInHand.getType() != Material.AIR;

        for (ItemStack item : ItemStacks.itemStackWearable()) {
            if (item.isSimilar(itemInHand) && isNotNull) {
                if (isRightClick) {
                    ItemStack helmet = player.getEquipment().getHelmet();
                    ItemStack si = itemInHand.clone();
                    si.setAmount(1);
                    if (itemInHand.getAmount() > 1) {
                        itemInHand.setAmount(itemInHand.getAmount() - 1);

                        player.getEquipment().setItem(EquipmentSlot.HEAD, si);
                        if (helmet != null){
                            player.getInventory().addItem(helmet);
                        }
                    } else {
                        player.getEquipment().setItemInMainHand(helmet);
                        player.getEquipment().setItem(EquipmentSlot.HEAD, si);
                    }
                    event.setCancelled(true);
                    break;
                }
            }
        }


    }

//chaos hammer
    @EventHandler
    public void ChaosHammerEffect(EntityDamageByEntityEvent event){
        if (event.getDamager() instanceof Player player){
            Bukkit.getLogger().info("Hit");
            Entity entity = event.getEntity();
            ItemStack item = player.getEquipment().getItemInMainHand();
            if (item.equals(ItemStacks.ChaosHammer)){
                Bukkit.getLogger().info("Chaos Hammer");
                if (checkCooldownChaosHammer(player)){
                    Bukkit.getLogger().info("Applying effects...");
                    applyRandomPotionEffect(entity);
                }
            }
        }
    }

//awakening table
    @EventHandler
    public void AwakeningTableAbility(PlayerRespawnEvent event) {
        Player player = event.getPlayer();
        ItemStack OffHandItem = player.getEquipment().getItemInOffHand();
        if (OffHandItem != null && OffHandItem.equals(ItemStacks.AwakeningTable)) {
            player.getAttribute(Attribute.GENERIC_MAX_ABSORPTION).setBaseValue(20.0);
            if (checkCooldownAT(player)){
                player.setAbsorptionAmount(20);
                ItemMeta meta = OffHandItem.getItemMeta();
                meta.setCustomModelData(2102);
                OffHandItem.setItemMeta(meta);
            }
        } else {
            player.getAttribute(Attribute.GENERIC_MAX_ABSORPTION).setBaseValue(0.0);
        }


    }

    @EventHandler
    public void AwakeningChecker(EntityDamageEvent event){
        if (event.getEntity() instanceof Player player){
            ItemStack OffHandItem = player.getEquipment().getItemInOffHand();
            if (OffHandItem != null && OffHandItem.equals(ItemStacks.AwakeningTableV)) {
                if (player.getAbsorptionAmount() <= 0.5){
                    ItemMeta meta = OffHandItem.getItemMeta();
                    meta.setCustomModelData(2101);
                    OffHandItem.setItemMeta(meta);
                }
            }
        }
    }

//Captain's hat
    //On Punch
    @EventHandler
    public void onCaptainHatPunchAbility(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player player){
            Entity entity = event.getEntity();
            ItemStack itemInHand = player.getInventory().getItemInMainHand();
            ItemStack wornHelmet = player.getEquipment().getHelmet();

            if (wornHelmet != null && wornHelmet.equals(ItemStacks.CaptainHat)) {
                if (itemInHand == null || itemInHand.getType().isAir()) {
                    generateCHPParticles(entity);
                }
            }
        }

    }
    //On crouch
    @EventHandler
    public void onCaptainHatCrouchAbility(PlayerToggleSneakEvent event) {
        Player player = event.getPlayer();
        ItemStack wornHelmet = player.getEquipment().getHelmet();
        Boolean Sneak = player.isSneaking();
        if (wornHelmet != null && wornHelmet.equals(ItemStacks.CaptainHat)) {
            if (!(Sneak)) {
                generateCHSParticles(player);
            }
        }

    }

//Kraken's eye
    //RightClick Shift ability
    @EventHandler
    public void onKrakenCannonball(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack HandItem = player.getEquipment().getItemInMainHand();
        Action action = event.getAction();
        Action RCA = Action.RIGHT_CLICK_AIR;
        Action RCB = Action.RIGHT_CLICK_BLOCK;
        Boolean isRightClick =(action == RCA) || (action == RCB);
        if (HandItem != null && HandItem.equals(ItemStacks.PirateSpyGlass)){
            if (player.isSneaking() && isRightClick) {
                if (checkCooldownCannonBall(player)){
                    getTestPRG(player);
                }
            }
        }


    }
    //Aiming ability
    @EventHandler
    public void onKrakenStare(PlayerInteractEvent event){
        Player player = event.getPlayer();
        ItemStack HandItem = player.getEquipment().getItemInMainHand();
        Action action = event.getAction();
        Action RCA = Action.RIGHT_CLICK_AIR;
        Action RCB = Action.RIGHT_CLICK_BLOCK;
        boolean isRightClick =(action == RCA) || (action == RCB);
        if (isRightClick && HandItem.equals(ItemStacks.PirateSpyGlass)){
            for (Entity entity : player.getNearbyEntities(100, 100, 100)) {
                if (isLookingAtEntity(player, entity)){
                    applyGlow(entity);
                }

            }
        }
    }

//Washed Ashore
    //Ability when attacking
    @EventHandler
    public void OnShoreAttack(EntityDamageByEntityEvent event){
        if (event.getDamager() instanceof Player player){
            Entity entity = event.getEntity();
            Inventory inventory = player.getInventory();

            if(inventory.contains(ItemStacks.WashedAshore) && player.isInWater()){
                inflictSlow(entity);
            }
        }

    }
    //Ability when getting out of water
    @EventHandler
    public void OnShoreSpeed(PlayerMoveEvent event){
        Player player = event.getPlayer();
        Inventory inventory = player.getInventory();
        Location from = event.getFrom();
        Location to = event.getTo();
        if (inventory.contains(ItemStacks.WashedAshore)){
            if (!isWater(from.getBlock()) && isWater(to.getBlock())){
            }

            if(isWater(from.getBlock()) && !isWater(to.getBlock())){
                PotionEffect speed = player.getPotionEffect(PotionEffectType.SPEED);
                if (!(player.getActivePotionEffects().contains(speed))){
                    giveSpeed(player);
                }


            }
        }
    }
    //to finish, right click ability for Washed Ashore
    @EventHandler
    public void OnShoreUse(PlayerInteractEvent event){
        Player player = event.getPlayer();
        ItemStack ItemInHand = player.getEquipment().getItemInMainHand();
        Action action = event.getAction();
        Action RCA = Action.RIGHT_CLICK_AIR;
        Action RCB = Action.RIGHT_CLICK_BLOCK;
        Boolean isRightClick =(action == RCA) || (action == RCB);
        Boolean isNotNull = ItemInHand != null;
        Boolean isCustomItem = ItemInHand.equals(ItemStacks.WashedAshore);
        if (isNotNull && isCustomItem){
            if (isRightClick) {
            }
        }

    }
//Saver Staff
    //Swapping ability
    @EventHandler
    public void onStaffRightClick(PlayerInteractEvent event){
        Player player = event.getPlayer();
        ItemStack ItemInHand = player.getEquipment().getItemInMainHand();
        Action action = event.getAction();
        Action RCA = Action.RIGHT_CLICK_AIR;
        Action RCB = Action.RIGHT_CLICK_BLOCK;
        Boolean isRightClick =(action == RCA) || (action == RCB);
        Boolean isNotNull = ItemInHand != null;
        Bukkit.getLogger().info("Interaction Test");
        for (ItemStack item : ItemStacks.SaverStaffs()) {
            Bukkit.getLogger().info("list check");
            Boolean isCustomItem = ItemInHand.equals(item);
            if (isNotNull && isCustomItem){
                Bukkit.getLogger().info("Its one of the staffs");
                if (isRightClick) {
                    Bukkit.getLogger().info("You're right clicking");
                    ItemMeta meta = ItemInHand.getItemMeta();
                   if (ItemInHand.equals(ItemStacks.SaverStaff)){
                       Bukkit.getLogger().info("Getting a random staff");
                       Long randomNumber = Math.round(Math.random()* 3) + 1;
                       switch (randomNumber.intValue()) {
                           case 1:
                               meta.setCustomModelData(2210);
                               ItemInHand.setItemMeta(meta);
                               break;
                           case 2:
                               meta.setCustomModelData(2220);
                               ItemInHand.setItemMeta(meta);
                               break;
                           case 3:
                               meta.setCustomModelData(2230);
                               ItemInHand.setItemMeta(meta);
                               break;
                           case 4:
                               meta.setCustomModelData(2240);
                               ItemInHand.setItemMeta(meta);
                               break;
                           default:
                               meta.setCustomModelData(2201);
                               ItemInHand.setItemMeta(meta);
                               break;
                       }
                   } else if (ItemInHand.equals(ItemStacks.SaverStaffFire)) {
                       meta.setCustomModelData(2220);
                       ItemInHand.setItemMeta(meta);
                   } else if (ItemInHand.equals(ItemStacks.SaverStaffWater)) {
                       meta.setCustomModelData(2230);
                       ItemInHand.setItemMeta(meta);
                   } else if (ItemInHand.equals(ItemStacks.SaverStaffEarth)) {
                       meta.setCustomModelData(2240);
                       ItemInHand.setItemMeta(meta);
                   } else if (ItemInHand.equals(ItemStacks.SaverStaffAir)) {
                       meta.setCustomModelData(2210);
                       ItemInHand.setItemMeta(meta);
                   }
                }
            }
        }


    }

//Stock Exchange
    @EventHandler
    public void onStockRightClick(InventoryEvent event){
        Inventory inventory = event.getInventory();
        Player player = (Player) inventory.getHolder();

        if(inventory.contains(ItemStacks.StockExchange)){
            Long randomNumber = Math.round(Math.random()* 5) + 1;

            switch (randomNumber.intValue()){
                case 1:
                    player.
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
            }

        }
    }



    private final Map<UUID, Long> lastCommandExecution = new HashMap<>();
    private static final long COOLDOWN_DURATIONAW = 30 * 1000;


    private boolean checkCooldownAT(Player player) {
        UUID playerId = player.getUniqueId();
        long currentTime = System.currentTimeMillis();
        long lastExecutionTime = lastCommandExecution.getOrDefault(playerId, 0L);

        if (currentTime - lastExecutionTime >= COOLDOWN_DURATIONAW) {
            lastCommandExecution.put(playerId, currentTime);
            return true;
        }

        return false;

    }

    private static final long COOLDOWN_DURATIONCB = 10 * 1000;
    private boolean checkCooldownCannonBall(Player player) {
        UUID playerId = player.getUniqueId();
        long currentTime = System.currentTimeMillis();
        long lastExecutionTime = lastCommandExecution.getOrDefault(playerId, 0L);

        if (currentTime - lastExecutionTime >= COOLDOWN_DURATIONCB) {
            lastCommandExecution.put(playerId, currentTime);
            return true;
        }

        return false;

    }

    private static final long COOLDOWN_DURATIONCH = 500;
    private boolean checkCooldownChaosHammer(Player player) {
        UUID playerId = player.getUniqueId();
        long currentTime = System.currentTimeMillis();
        long lastExecutionTime = lastCommandExecution.getOrDefault(playerId, 0L);

        if (currentTime - lastExecutionTime >= COOLDOWN_DURATIONCH) {
            lastCommandExecution.put(playerId, currentTime);
            return true;
        }

        return false;

    }

    @EventHandler
    public void StopCustomItemPlacement(PlayerInteractEvent event) {
        if (isCustomItem(event.getItem())) {
            event.setCancelled(true);

        }
    }

    private boolean isCustomItem(ItemStack item) {
        return item != null && item.isSimilar(ItemStacks.AwakeningTable);
    }

    public void generateCHPParticles(Entity entity) {
        Location location = entity.getLocation().add(0,1,0);
        World world = entity.getWorld();

        world.spawnParticle(Particle.WATER_SPLASH, location, 125, 0.2,0.1,0.2);
    }

    public void generateCHSParticles(Player player) {
        Location location = player.getLocation();
        World world = player.getWorld();

        world.spawnParticle(Particle.WATER_SPLASH, location, 300, 0.4,0.1,0.4);
    }

    public void inflictSlow(Entity entity){
        PotionEffect slow = (new PotionEffect(PotionEffectType.SLOW, 5 * 20, 1));
        LivingEntity El = (LivingEntity) entity;
        El.addPotionEffect(slow);
    }

    public void giveSpeed (Player player){
        PotionEffect speed = (new PotionEffect(PotionEffectType.SPEED, 5 * 20, 2));
        player.addPotionEffect(speed);
    }

    public void applyGlow(Entity entity){
        if (entity instanceof LivingEntity El){
            El.setGlowing(true);

        }
    }

    public void removeGlow(Entity entity){
        if (entity instanceof LivingEntity El){
            El.setGlowing(false);

        }
    }

    private boolean isWater(Block block) {
        return block.getType() == Material.WATER || block.getType() == Material.WATER_CAULDRON;
    }

    private boolean isLookingAtEntity(Player player, Entity entity) {
        Vector playerDirection = player.getEyeLocation().getDirection();
        Vector entityDirection = entity.getLocation().toVector().subtract(player.getEyeLocation().toVector());
        playerDirection.normalize();
        entityDirection.normalize();
        double dotProduct = playerDirection.dot(entityDirection);
        double thresholdAngle = Math.cos(Math.toRadians(25));
        return dotProduct >= thresholdAngle;
    }


    private void getTestPRG(Player player) {
        float yaw = player.getEyeLocation().getYaw();
        float pitch = player.getEyeLocation().getPitch();

        double yawRadians = Math.toRadians(-yaw);
        double pitchRadians = Math.toRadians(-pitch);

        double x = Math.sin(yawRadians) * Math.cos(pitchRadians);
        double y = Math.sin(pitchRadians);
        double z = Math.cos(yawRadians) * Math.cos(pitchRadians);

        Vector velocity = new Vector(x, y, z);

        Arrow arrow = player.launchProjectile(Arrow.class);
        arrow.setVelocity(velocity.normalize().multiply(4));
        arrow.setColor(Color.BLACK);
        arrow.setPickupStatus(AbstractArrow.PickupStatus.DISALLOWED);
        arrow.setDamage(10);
    }


    private String getPrimaryDirection(double yaw) {
        if (yaw < 0) {
            yaw += 360;
        }
        if (yaw >= 315 || yaw < 45) {
            return "South";
        } else if (yaw >= 45 && yaw < 135) {
            return "West";
        } else if (yaw >= 135 && yaw < 225) {
            return "North";
        } else if (yaw >= 225 && yaw < 315) {
            return "East";
        } else {
            return "Unknown";
        }
    }

    @EventHandler
    public void removeGlow(PlayerDeathEvent event){
        if (event.getEntity() instanceof Player){
            Player player = (Player) event.getEntity();
            if (player.isGlowing()){
                removeGlow(player);
            }
        }
    }

    private void applyRandomPotionEffect(Entity entity) {
        List<PotionEffectType> effectList = effectList();
        Bukkit.getLogger().info("Checking List...");
        if (!effectList.isEmpty()) {
            Bukkit.getLogger().info("applying...");
            PotionEffectType randomEffect = effectList.get(new Random().nextInt(effectList.size()));
            LivingEntity EL = (LivingEntity) entity;
            if (!(EL.hasPotionEffect(randomEffect))){
                Bukkit.getLogger().info("Applied");
                EL.addPotionEffect((new PotionEffect(randomEffect, 20 * 30, 0)));
            }
        }
    }

    public static List<PotionEffectType> effectList(){
        List<PotionEffectType> Effect = new ArrayList<>();
        Effect.add(PotionEffectType.INCREASE_DAMAGE);
        Effect.add(PotionEffectType.SPEED);
        Effect.add(PotionEffectType.JUMP);
        Effect.add(PotionEffectType.REGENERATION);
        Effect.add(PotionEffectType.FIRE_RESISTANCE);
        Effect.add(PotionEffectType.INVISIBILITY);
        Effect.add(PotionEffectType.DAMAGE_RESISTANCE);
        Effect.add(PotionEffectType.POISON);
        Effect.add(PotionEffectType.WEAKNESS);
        Effect.add(PotionEffectType.SLOW);
        Effect.add(PotionEffectType.WITHER);
        Effect.add(PotionEffectType.CONFUSION);
        Effect.add(PotionEffectType.BLINDNESS);
        Effect.add(PotionEffectType.DARKNESS);
        return Effect;
    }

    public static List<PotionEffectType> EffectsWithPowerAmplification(){
        List<PotionEffectType> Effect = new ArrayList<>();
        Effect.add(PotionEffectType.INCREASE_DAMAGE);
        Effect.add(PotionEffectType.SPEED);
        Effect.add(PotionEffectType.JUMP);
        Effect.add(PotionEffectType.REGENERATION);
        Effect.add(PotionEffectType.DAMAGE_RESISTANCE);
        Effect.add(PotionEffectType.POISON);
        Effect.add(PotionEffectType.WEAKNESS);
        Effect.add(PotionEffectType.SLOW);
        Effect.add(PotionEffectType.WITHER);
        return Effect;
    }

    public static List<PotionEffectType> EffectsWithTimeAmplification(){
        List<PotionEffectType> Effect = new ArrayList<>();
        Effect.add(PotionEffectType.FIRE_RESISTANCE);
        Effect.add(PotionEffectType.INVISIBILITY);
        Effect.add(PotionEffectType.CONFUSION);
        Effect.add(PotionEffectType.BLINDNESS);
        Effect.add(PotionEffectType.DARKNESS);
        return Effect;
    }


}


