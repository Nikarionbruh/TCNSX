package test.saveritemsexpansion.ItemStackManager;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.*;

import static org.bukkit.Bukkit.getLogger;

public class ItemStacks {
    public static ItemStack AwakeningTable;
    public static ItemStack AwakeningTableV;
    public static ItemStack CaptainHat;
    public static ItemStack PirateSpyGlass;
    public static ItemStack WashedAshore;
    public static ItemStack TestItem;
    public static ItemStack ChaosHammer;
    public static ItemStack SaverStaff;
    public static ItemStack SaverStaffFire;
    public static ItemStack SaverStaffWater;
    public static ItemStack SaverStaffEarth;
    public static ItemStack SaverStaffAir;
    public static ItemStack StockExchange;

    public static void init() {
        createAwakeningTable();
        createCaptainHat();
        createPirateSpyGlass();
        createWashedAshore();
        createTestItem();
        createChaosHammer();
        createSaverStaff();
        createStockExchange();
    }

    private static void createTestItem(){
        ItemStack item = new ItemStack(Material.ALLIUM);
        ItemMeta meta = item.getItemMeta();
        if (meta != null){
            meta.setDisplayName("Test Item");
        }

        List<String> loreTable = getLoreTestItem();

        meta.setLore(loreTable);

        meta.setCustomModelData(11);
        item.setItemMeta(meta);
        TestItem = item;
    }

    private static void createChaosHammer(){
        ItemStack item = new ItemStack(Material.BRICK, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§x§A§A§0§0§F§F☣ §x§A§A§0§0§F§FC§x§9§9§0§0§E§6H§x§8§9§0§0§C§DA§x§7§8§0§0§B§3O§x§6§7§0§0§9§AS §x§0§8§8§A§1§4H§x§0§F§A§1§1§0A§x§1§5§B§9§0§DM§x§1§C§D§0§0§9M§x§2§2§E§8§0§6E§x§2§9§F§F§0§2R §x§2§9§F§F§0§2☮");

        List<String> loreHammah = getLoreHammah();
        meta.setLore(loreHammah);

        meta.setUnbreakable(true);

        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);

        meta.setCustomModelData(31736);
        item.setItemMeta(meta);
        ChaosHammer = item;

    }

    private static void createAwakeningTable() {
        ItemStack item = new ItemStack(Material.BRICK, 1);
        ItemMeta meta = item.getItemMeta();
        if (meta != null) {
            try {
                meta.setDisplayName("§f✦♢ §x§2§B§F§F§3§E§lA§x§2§8§F§0§4§D§lW§x§2§4§E§1§5§C§lA§x§2§1§D§2§6§B§lK§x§1§E§C§3§7§9§lE§x§1§A§B§4§8§8§lN§x§1§7§A§5§9§7§lI§x§1§4§9§5§A§6§lN§x§1§1§8§6§B§5§lG §x§0§D§7§7§C§4§lT§x§0§A§6§8§D§2§lA§x§0§7§5§9§E§1§lB§x§0§3§4§A§F§0§lL§x§0§0§3§B§F§F§lE §f♢✦");
            } catch (Exception e) {
                getLogger().severe("An error occurred while setting display name:");
                e.printStackTrace();
                return;
            }

            List<String> loreTable = getLoreTable();

            meta.setLore(loreTable);

            meta.addEnchant(Enchantment.PROTECTION_FALL, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

            meta.setCustomModelData(2101);
            item.setItemMeta(meta);
            AwakeningTable = item;

            //yellow variant
            ItemStack itemV = AwakeningTable.clone();
            ItemMeta metaV = itemV.getItemMeta();

            metaV.setCustomModelData(2102);
            itemV.setItemMeta(metaV);

            AwakeningTableV = itemV;
        }
    }
    private static void createCaptainHat() {
        ItemStack item = new ItemStack(Material.RABBIT_HIDE, 1);
        ItemMeta meta = item.getItemMeta();
        if (meta != null) {
            try {
                meta.setDisplayName("§x§0§0§f§b§f§8\uD83C\uDF0A C§x§0§0§e§7§f§9a§x§0§0§d§4§f§ap§x§0§0§c§0§f§at§x§0§0§a§c§f§ba§x§0§0§9§9§f§ci§x§0§0§8§5§f§dn §x§0§0§7§1§f§dH§x§0§0§5§e§f§ea§x§0§0§4§a§f§ft \uD83C\uDF0A");
            } catch (Exception e) {
                getLogger().severe("An error occurred while setting display name:");
                e.printStackTrace();
                return; // No need to continue if setting display name fails
            }
            List<String> loreCaptainHat = getLoreCaptainHat();

            meta.setLore(loreCaptainHat);

            meta.addEnchant(Enchantment.OXYGEN, 5, false);
            meta.setUnbreakable(true);

            meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);

            meta.setCustomModelData(1101);
            item.setItemMeta(meta);
            CaptainHat = item;
        } else {
            getLogger().severe("An error occurred while creating item meta: ItemMeta is null");


        }
    }
    private static void createPirateSpyGlass() {
        ItemStack item = new ItemStack(Material.SPYGLASS , 1);
        ItemMeta meta = item.getItemMeta();
        if (meta != null) {
            try {
                meta.setDisplayName("§x§F§B§3§9§9§4\uD83D\uDC19 §x§B§7§0§2§F§B\uD83D\uDC41 §x§A§8§0§7§F§BK§x§9§9§0§C§F§CR§x§8§9§1§0§F§CA§x§7§A§1§5§F§CK§x§6§B§1§A§F§DE§x§5§C§1§F§F§DN§x§4§C§2§3§F§D'§x§3§D§2§8§F§ES §x§2§E§2§D§F§EE§x§1§F§3§2§F§EY§x§0§F§3§6§F§FE §x§0§0§3§B§F§F\uD83D\uDC41  §x§F§B§3§9§9§4\uD83D\uDC19");
            } catch (Exception e) {
                getLogger().severe("An error occurred while setting display name:");
                e.printStackTrace();
                return; // No need to continue if setting display name fails
            }

            List<String> loreTable = getLorePirateSpyGlass();

            meta.setLore(loreTable);

            meta.setCustomModelData(1201);
            item.setItemMeta(meta);
            PirateSpyGlass = item;
        } else {
            getLogger().severe("An error occurred while creating item meta: ItemMeta is null");
        }
    }

    private static void createWashedAshore() {
        ItemStack item = new ItemStack(Material.HEART_OF_THE_SEA, 1);
        ItemMeta meta = item.getItemMeta();
        if (meta != null) {
            try {
                meta.setDisplayName("§x§0§0§C§B§F§B§o≈ §x§0§0§C§B§F§B§oW§x§1§4§D§0§E§4§oa§x§2§7§D§4§C§D§os§x§3§B§D§9§B§7§oh§x§4§F§D§E§A§0§oe§x§6§2§E§3§8§9§od §x§7§6§E§7§7§2§oA§x§8§9§E§C§5§B§os§x§9§D§F§1§4§4§oh§x§B§1§F§6§2§E§oo§x§C§4§F§A§1§7§or§x§D§8§F§F§0§0§oe ≈");
            } catch (Exception e) {
                getLogger().severe("An error occurred while setting display name:");
                e.printStackTrace();
                return; // No need to continue if setting display name fails
            }
            List<String> loreTable = getLoreWashedAshore();
            meta.setLore(loreTable);

            meta.setCustomModelData(1301);
            item.setItemMeta(meta);
            WashedAshore = item;
        }
    }

    private static void createSaverStaff(){
        ItemStack item = new ItemStack(Material.BRICK, 1);
        ItemMeta meta = item.getItemMeta();
        if (meta != null) {
            try {
                meta.setDisplayName("§x§0§7§9§7§F§B§l★§x§3§D§6§5§F§C§l☆ §x§0§7§9§7§F§BS§x§1§9§8§6§F§Ba§x§2§B§7§5§F§Cv§x§3§D§6§5§F§Ce§x§4§F§5§4§F§Dr §x§6§2§4§3§F§DS§x§7§4§3§2§F§Et§x§8§6§2§2§F§Ea§x§9§8§1§1§F§Ff§x§A§A§0§0§F§Ff §7(none) §x§7§4§3§2§F§E§l☆§x§A§A§0§0§F§F§l★");
            } catch (Exception e) {
                getLogger().severe("An error occurred while setting display name:");
                e.printStackTrace();
                return;
            }

            List<String> loreNullStaff = getLoreNullStaff();

            meta.setLore(loreNullStaff);

            meta.setCustomModelData(2201);
            item.setItemMeta(meta);
            SaverStaff = item;

            ItemStack StaffF = SaverStaff.clone();
            ItemStack StaffW = SaverStaff.clone();
            ItemStack StaffE = SaverStaff.clone();
            ItemStack StaffA = SaverStaff.clone();

            ItemMeta MetaF = StaffF.getItemMeta();
            ItemMeta MetaW = StaffW.getItemMeta();
            ItemMeta MetaE = StaffE.getItemMeta();
            ItemMeta MetaA = StaffA.getItemMeta();

            //Fire staff variant
            MetaF.setCustomModelData(2210);

            List<String> loreFireStaff = getLoreFireStaff();

            MetaF.setLore(loreFireStaff);

            StaffF.setItemMeta(MetaF);

            //Water staff variant
            MetaW.setCustomModelData(2220);

            List<String> loreWaterStaff = getLoreWaterStaff();

            MetaW.setLore(loreWaterStaff);

            StaffW.setItemMeta(MetaW);

            //Earth staff variant
            MetaE.setCustomModelData(2230);

            List<String> loreEarthStaff = getLoreEarthStaff();

            MetaE.setLore(loreEarthStaff);

            StaffE.setItemMeta(MetaE);

            //Air staff variant
            MetaA.setCustomModelData(2240);

            List<String> loreAirStaff = getLoreAirStaff();

            MetaA.setLore(loreAirStaff);

            StaffA.setItemMeta(MetaA);

            SaverStaffFire = StaffF;
            SaverStaffWater = StaffW;
            SaverStaffEarth = StaffE;
            SaverStaffAir = StaffA;


        }
    }

    private static void createStockExchange(){
        ItemStack item = new ItemStack(Material.BRICK);
        ItemMeta meta = item.getItemMeta();
        if (meta != null){
            meta.setDisplayName("§x§D§C§3§2§3§2§l\uD83D\uDCC9 §x§D§3§3§C§3§2§lT§x§C§9§4§6§3§2§lh§x§C§0§5§0§3§2§le §x§B§6§5§A§3§2§lS§x§A§D§6§4§3§2§lt§x§A§3§6§E§3§2§lo§x§9§A§7§8§3§2§lc§x§9§0§8§2§3§2§lk §x§8§7§8§C§3§2§lE§x§7§D§9§6§3§2§lx§x§7§4§A§0§3§2§lc§x§6§A§A§A§3§2§lh§x§6§1§B§4§3§2§la§x§5§7§B§E§3§2§ln§x§4§E§C§8§3§2§lg§x§4§4§D§2§3§2§le §x§3§B§D§C§3§2§l\uD83D\uDCC8");
        }

        List<String> loreTable = getLoreStockEX();

        meta.setLore(loreTable);

        meta.setCustomModelData(2301);
        item.setItemMeta(meta);
        StockExchange = item;
    }

    private static List<String> getLoreHammah(){
        List<String> lore = new ArrayList<>();
        lore.add("");
        lore.add("§7~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
        lore.add("");
        lore.add("§7| §fEmbrace the chaos. §x§1§1§6§E§0§1C§x§1§D§B§7§0§2H§x§2§9§F§F§0§2A§x§1§D§B§7§0§2O§x§1§1§6§E§0§1S. §x§1§1§6§E§0§1§lC§x§1§8§9§7§0§1§lH§x§1§F§C§1§0§2§lA§x§2§6§E§A§0§2§lO§x§2§6§E§A§0§2§lS§x§1§F§C§1§0§2§l!§x§1§8§9§7§0§1§l!§x§1§1§6§E§0§1§l!");
        lore.add("");
        lore.add("§7| §cAttack §fto §edeal §beffects.");
        lore.add("§7| §bWhat effects? §x§A§A§0§0§F§FW§x§9§D§1§A§E§6h§x§9§0§3§3§C§Co §x§8§3§4§D§B§3k§x§7§6§6§6§9§An§x§6§A§8§0§8§1o§x§5§D§9§9§6§7w§x§5§0§B§3§4§Es§x§4§3§C§C§3§5.§x§3§6§E§6§1§B.§x§2§9§F§F§0§2.");
        lore.add("");
        lore.add("§7 ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
        lore.add("");
        lore.add("§fCRATE:  §x§A§A§0§0§F§F§kC§x§9§C§1§C§E§3§kH§x§8§D§3§9§C§7§kA§x§7§F§5§5§A§B§kO§x§7§1§7§1§8§F§kS §x§6§2§8§E§7§2§kC§x§5§4§A§A§5§6§kR§x§4§6§C§6§3§A§kA§x§3§7§E§3§1§E§kT§x§2§9§F§F§0§2§kE ");
        return lore;
    }
    private static List<String> getLoreNullStaff(){
        List<String> lore = new ArrayList<>();
        lore.add("");
        lore.add("§7~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
        lore.add("");
        lore.add("§7| §5A staff forged in the abyss, ready to be awakened.");
        lore.add("");
        lore.add("§7| §bRight click §fto cicle to the §onext §relement,");
        lore.add("§7| §bShift Right click to &fcicle to §othe §rprevious.");
        lore.add("§7 ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
        lore.add("");
        lore.add("§fCRATE: §x§2§B§F§F§3§E§lF§x§2§6§E§9§5§3§lR§x§2§1§D§3§6§9§lE§x§1§D§B§E§7§E§lS§x§1§8§A§8§9§4§lH §x§1§3§9§2§A§9§lS§x§0§E§7§C§B§F§lT§x§0§A§6§7§D§4§lA§x§0§5§5§1§E§A§lR§x§0§0§3§B§F§F§lT");
        return lore;
    }

    private static List<String> getLoreFireStaff(){
        List<String> lore = new ArrayList<>();
        lore.add("");
        lore.add("§7~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
        lore.add("");
        lore.add("§7| §cA staff awakened in the hottest of lava pits!");
        lore.add("");
        lore.add("§7| §bLeft Click §fto shoot a §x§F§B§8§0§1§4F§x§F§C§8§7§1§4i§x§F§C§8§F§1§4r§x§F§D§9§6§1§4e §x§F§D§9§D§1§4b§x§F§E§A§4§1§3a§x§F§E§A§C§1§3l§x§F§F§B§3§1§3l§x§F§F§B§A§1§3!");
        lore.add("");
        lore.add("§7| §bRight click §fto cicle to the §onext §relement,");
        lore.add("§7| §bShift Right click to &fcicle to §othe §rprevious.");
        lore.add("§7 ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
        lore.add("");
        lore.add("§fCRATE: §x§2§B§F§F§3§E§lF§x§2§6§E§9§5§3§lR§x§2§1§D§3§6§9§lE§x§1§D§B§E§7§E§lS§x§1§8§A§8§9§4§lH §x§1§3§9§2§A§9§lS§x§0§E§7§C§B§F§lT§x§0§A§6§7§D§4§lA§x§0§5§5§1§E§A§lR§x§0§0§3§B§F§F§lT");
        return lore;
    }
    private static List<String> getLoreWaterStaff(){
        List<String> lore = new ArrayList<>();
        lore.add("");
        lore.add("§7~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
        lore.add("");
        lore.add("§7| §5A staff awakened in the deepest of oceans!");
        lore.add("");
        lore.add("§7| §bLeft Click §f");
        lore.add("");
        lore.add("§7| §bRight click §fto cicle to the §onext §relement,");
        lore.add("§7| §bShift Right click to &fcicle to §othe §rprevious.");
        lore.add("§7 ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
        lore.add("");
        lore.add("§fCRATE: §x§2§B§F§F§3§E§lF§x§2§6§E§9§5§3§lR§x§2§1§D§3§6§9§lE§x§1§D§B§E§7§E§lS§x§1§8§A§8§9§4§lH §x§1§3§9§2§A§9§lS§x§0§E§7§C§B§F§lT§x§0§A§6§7§D§4§lA§x§0§5§5§1§E§A§lR§x§0§0§3§B§F§F§lT");
        return lore;
    }
    private static List<String> getLoreEarthStaff(){
        List<String> lore = new ArrayList<>();
        lore.add("");
        lore.add("§7~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
        lore.add("");
        lore.add("§7| §x§B§3§6§B§0§7A staff awakened in the tallest of mountains!");
        lore.add("");
        lore.add("§7| §bLeft Click §f");
        lore.add("");
        lore.add("§7| §bRight click §fto cicle to the §onext §relement,");
        lore.add("§7| §bShift Right click to &fcicle to §othe §rprevious.");
        lore.add("§7 ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
        lore.add("");
        lore.add("§fCRATE: §x§2§B§F§F§3§E§lF§x§2§6§E§9§5§3§lR§x§2§1§D§3§6§9§lE§x§1§D§B§E§7§E§lS§x§1§8§A§8§9§4§lH §x§1§3§9§2§A§9§lS§x§0§E§7§C§B§F§lT§x§0§A§6§7§D§4§lA§x§0§5§5§1§E§A§lR§x§0§0§3§B§F§F§lT");
        return lore;
    }
    private static List<String> getLoreAirStaff(){
        List<String> lore = new ArrayList<>();
        lore.add("");
        lore.add("§7~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
        lore.add("");
        lore.add("§7| §7A staff awakened in the softest of clouds!");
        lore.add("");
        lore.add("§7| §bLeft Click §f");
        lore.add("");
        lore.add("§7| §bRight click §fto cicle to the §onext §relement,");
        lore.add("§7| §bShift Right click to &fcicle to §othe §rprevious.");
        lore.add("§7 ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
        lore.add("");
        lore.add("§fCRATE: §x§2§B§F§F§3§E§lF§x§2§6§E§9§5§3§lR§x§2§1§D§3§6§9§lE§x§1§D§B§E§7§E§lS§x§1§8§A§8§9§4§lH §x§1§3§9§2§A§9§lS§x§0§E§7§C§B§F§lT§x§0§A§6§7§D§4§lA§x§0§5§5§1§E§A§lR§x§0§0§3§B§F§F§lT");
        return lore;
    }
    private static List<String> getLoreTable(){
        List<String> lore = new ArrayList<>();
        lore.add("");
        lore.add("§7~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
        lore.add("");
        lore.add("§7| §x§2§B§F§F§3§E§lA§x§2§8§E§8§3§3§lW§x§2§4§D§0§2§8§lA§x§2§1§B§9§1§C§lK§x§1§D§A§1§1§1§lE§x§1§A§8§A§0§6§lN. §x§0§0§1§A§7§2§lB§x§0§0§1§E§8§4§lE§x§0§0§2§2§9§5§lC§x§0§0§2§6§A§7§lO§x§0§0§2§B§B§9§lM§x§0§0§2§F§C§A§lE §x§0§0§3§3§D§C§lN§x§0§0§3§7§E§D§lE§x§0§0§3§B§F§F§lW.");
        lore.add("");
        lore.add("§7| §fAfter §bRespawning§f, gain §eABSORPTION hearts!");
        lore.add("§7| §8§owhich last forever until you lose them.");
        lore.add("");
        lore.add("§7| §4§lWARNING! You cannot remove the awakened item!");
        lore.add("");
        lore.add("§7 ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
        lore.add("");
        lore.add("§fCRATE: §x§2§B§F§F§3§E§lF§x§2§6§E§9§5§3§lR§x§2§1§D§3§6§9§lE§x§1§D§B§E§7§E§lS§x§1§8§A§8§9§4§lH §x§1§3§9§2§A§9§lS§x§0§E§7§C§B§F§lT§x§0§A§6§7§D§4§lA§x§0§5§5§1§E§A§lR§x§0§0§3§B§F§F§lT");
        return lore;
    }
    private static List<String> getLoreCaptainHat(){
        List<String> lore = new ArrayList<>();
        lore.add("");
        lore.add("§7~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
        lore.add("");
        lore.add("§7| §e§oWooo! §r§x§E§E§F§F§0§0§lS§x§9§5§F§F§5§E§lU§x§3§C§F§F§B§C§lM§x§3§C§F§F§B§C§lM§x§9§5§F§F§5§E§lE§x§E§E§F§F§0§0§lR.");
        lore.add("");
        lore.add("§7| §bSplash §fyour enemies by §chitting §fthem!");
        lore.add("§7| §eCrouch §fto §bsplash §fall around!");
        lore.add("");
        lore.add("§7 ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
        lore.add("");
        lore.add("§fCRATE: §x§E§E§F§F§0§0S§x§A§4§F§F§4§EE§x§5§A§F§F§9§DA§x§1§0§F§F§E§BS§x§5§A§F§F§9§DI§x§A§4§F§F§4§ED§x§E§E§F§F§0§0E");
        return lore;
    }
    private static List<String> getLorePirateSpyGlass(){
        List<String> lore = new ArrayList<>();
        lore.add("");
        lore.add("§7~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
        lore.add("");
        lore.add("§7| §4§oYARRR! ");
        lore.add("");
        lore.add("§7| §bLook §fat yer enemies to make em §4fear ye.");
        lore.add("§7| §bSneak §fand §bRight Click §fto shoot a cannonball!");
        lore.add("");
        lore.add("§7 ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
        lore.add("");
        lore.add("§fCRATE: §x§E§E§F§F§0§0S§x§A§4§F§F§4§EE§x§5§A§F§F§9§DA§x§1§0§F§F§E§BS§x§5§A§F§F§9§DI§x§A§4§F§F§4§ED§x§E§E§F§F§0§0E");
        return lore;
    }
    private static List<String> getLoreWashedAshore(){
        List<String> lore = new ArrayList<>();
        lore.add("");
        lore.add("§7~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
        lore.add("");
        lore.add("§7| §b§oYou listen to the waves. ");
        lore.add("");
        lore.add("§7| §bRight Click §fto Shoot a §1wave§f to knock enemies back.");
        lore.add("");
        lore.add("§7| §cAttack §fa player while in §1water §fto §7slow them.");
        lore.add("§7| §fGet out of §1water §fto get §e§ofaster.");
        lore.add("");
        lore.add("§7 ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
        lore.add("");
        lore.add("§fCRATE: §x§E§E§F§F§0§0S§x§A§4§F§F§4§EE§x§5§A§F§F§9§DA§x§1§0§F§F§E§BS§x§5§A§F§F§9§DI§x§A§4§F§F§4§ED§x§E§E§F§F§0§0E");
        return lore;
    }

    private static List<String> getLoreTestItem(){
        List<String> lore = new ArrayList<>();
        lore.add("this is a debug item");
        lore.add("Use this to check various things ");
        lore.add("when the right commands are used.");
        return lore;
    }

    private static List<String> getLoreStockEX(){
        List<String> lore = new ArrayList<>();
        lore.add("");
        lore.add("§7~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
        lore.add("§7| gme? more like ez money");
        lore.add("");
        lore.add("§7| §fRandomly recieve §x§3§b§d§c§3§2Regeneration§f or §x§d§c§3§2§3§2Poison.");
        lore.add("§7~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
        lore.add("");
        lore.add("§fCRATE: §x§2§B§F§F§3§E§lF§x§2§6§E§9§5§3§lR§x§2§1§D§3§6§9§lE§x§1§D§B§E§7§E§lS§x§1§8§A§8§9§4§lH §x§1§3§9§2§A§9§lS§x§0§E§7§C§B§F§lT§x§0§A§6§7§D§4§lA§x§0§5§5§1§E§A§lR§x§0§0§3§B§F§F§lT");
        return lore;
    }

    public static double getPlayerBaseAttackDamage() {
        Player player = Bukkit.getServer().getOnlinePlayers().stream().findFirst().orElse(null);
        if (player != null) {
            // If there is an online player, return their base attack damage
            return player.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).getBaseValue();
        } else {
            // If no players are online, return a default value or handle the situation as needed
            return 0.0; // Default value
        }
    }
    public static double getPlayerBaseAttackSpeed() {
        Player player = Bukkit.getServer().getOnlinePlayers().stream().findFirst().orElse(null);
        if (player != null) {
            // If there is an online player, return their base attack damage
            return player.getAttribute(Attribute.GENERIC_ATTACK_SPEED).getBaseValue();
        } else {
            // If no players are online, return a default value or handle the situation as needed
            return 0.0; // Default value
        }
    }
    public static List<ItemStack> itemStackList(){
        List<ItemStack> CustomItems = new ArrayList<>();
        CustomItems.add(CaptainHat);
        CustomItems.add(PirateSpyGlass);
        CustomItems.add(WashedAshore);
        CustomItems.add(AwakeningTable);
        CustomItems.add(TestItem);
        CustomItems.add(ChaosHammer);
        CustomItems.add(SaverStaff);
        CustomItems.add(StockExchange);
        return CustomItems;
    }

    public static List<ItemStack> SaverStaffs(){
        List<ItemStack> CustomItems = new ArrayList<>();
        CustomItems.add(SaverStaff);
        CustomItems.add(SaverStaffFire);
        CustomItems.add(SaverStaffWater);
        CustomItems.add(SaverStaffEarth);
        CustomItems.add(SaverStaffAir);
        return CustomItems;
    }

    public static List<ItemStack> itemStackWearable(){
        List<ItemStack> CustomItems = new ArrayList<>();
        CustomItems.add(CaptainHat);
        return CustomItems;
    }


}
