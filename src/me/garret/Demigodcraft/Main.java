package me.garret.Demigodcraft;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Effect;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Boat;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.vehicle.VehicleEnterEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;


public class Main extends JavaPlugin implements Listener{



	public ArrayList<Player> cooldownz = new ArrayList<Player>();
	public ArrayList<Player> cooldownp = new ArrayList<Player>();
	public List<String> hermer = new ArrayList<String>();
	public List<String> armar = new ArrayList<String>();
	public List<String> zeju = new ArrayList<String>();
	public List<String> hephvul = new ArrayList<String>();
	public List<String> athmen = new ArrayList<String>();
	public List<String> hunt = new ArrayList<String>();
	public List<String> titan = new ArrayList<String>();
	public List<String> divine = new ArrayList<String>(); 

	// custom crafting booleans // 
	public boolean customCraft = false;
	public boolean trident = true;
	public boolean spatha = true;
	public boolean pitchfork = true;
	public boolean sunbow = true;
	public boolean moonbow = true;
	public boolean spear = true;
	public boolean forgeHammer = true;
	public boolean cadusus = true;
	public boolean thyrsus = true;
	public boolean venustas = true;
	public boolean prudentia = true;
	public boolean panflute = true;
	public boolean emeraldHelmet = true;
	public boolean emeraldChestplate = true;
	public boolean emeraldLeggings = true;
	public boolean emeraldBoots = true;
	public boolean emeraldSword = true;
	public boolean saddle = true;
	public boolean fireworkOnJoin = true;
	public String joinMessage = "%p% joined the game!";
	public String leaveMessage = "%p% left the game!";

	@Override
	public void onEnable() {
		getLogger().info("Plugin Enabled");

		this.saveDefaultConfig();
		this.customCraft = this.getConfig().getBoolean("customCrafting");
		this.trident = this.getConfig().getBoolean("trident");
		this.spatha = this.getConfig().getBoolean("spatha");
		this.pitchfork = this.getConfig().getBoolean("pitchfork");
		this.sunbow = this.getConfig().getBoolean("sunBow");
		this.moonbow = this.getConfig().getBoolean("moonBow");
		this.spear = this.getConfig().getBoolean("spear");
		this.forgeHammer = this.getConfig().getBoolean("forgeHammer");
		this.cadusus = this.getConfig().getBoolean("cadusus");
		this.thyrsus = this.getConfig().getBoolean("thyrsus");
		this.venustas = this.getConfig().getBoolean("venustas");
		this.prudentia = this.getConfig().getBoolean("prudentia");
		this.panflute = this.getConfig().getBoolean("panflute");
		this.emeraldHelmet = this.getConfig().getBoolean("emeraldHelmet");
		this.emeraldChestplate = this.getConfig().getBoolean("emeraldChestplate");
		this.emeraldLeggings = this.getConfig().getBoolean("emeraldLeggings");
		this.emeraldBoots = this.getConfig().getBoolean("emeraldBoots");
		this.emeraldSword = this.getConfig().getBoolean("emeraldSword");
		this.saddle = this.getConfig().getBoolean("saddle");
		this.fireworkOnJoin = this.getConfig().getBoolean("fireworkOnJoin");
		this.joinMessage = this.getConfig().getString("joinMessage");
		this.leaveMessage = this.getConfig().getString("leaveMessage");

		if (customCraft) {
			if(trident) {
				ItemStack trident = new ItemStack(Material.DIAMOND_HOE, 1);
				trident.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 4);
				ItemMeta meta = trident.getItemMeta();
				meta.setDisplayName(ChatColor.AQUA + "Trident" + ChatColor.GRAY + "-" + ChatColor.GREEN + " Charged");
				trident.setItemMeta(meta);

				ShapedRecipe trecipe = new ShapedRecipe(new ItemStack(trident));
				trecipe.shape("*$*", " $ ", " $ ");
				trecipe.setIngredient('*', Material.DIAMOND);
				trecipe.setIngredient('$', Material.STICK);
				getServer().addRecipe(trecipe);
			}

			if(spatha) {

				ItemStack spatha = new ItemStack(Material.BLAZE_ROD, 1);
				spatha.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 4);
				ItemMeta meta2 = spatha.getItemMeta();
				meta2.setDisplayName(ChatColor.GOLD + "Spatha " + ChatColor.GRAY + "-" + ChatColor.GREEN + " Charged");
				spatha.setItemMeta(meta2);

				ShapedRecipe srecipe = new ShapedRecipe(new ItemStack(spatha));
				srecipe.shape("+  ", " + ", "  +");
				srecipe.setIngredient('+', Material.BLAZE_ROD);
				getServer().addRecipe(srecipe);
			}

			if(pitchfork) {
				ItemStack fork = new ItemStack(Material.DIAMOND_SPADE, 1);
				fork.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 4);
				ItemMeta meta3 = fork.getItemMeta();
				meta3.setDisplayName(ChatColor.RED + "Pitchfork");
				fork.setItemMeta(meta3);

				ShapedRecipe frecipe = new ShapedRecipe(new ItemStack(fork));
				frecipe.shape("*+*", " + ", " + ");
				frecipe.setIngredient('*', Material.DIAMOND);
				frecipe.setIngredient('+', Material.BLAZE_ROD);
				getServer().addRecipe(frecipe);
			}

			if(sunbow) {
				ItemStack sunb = new ItemStack(Material.BOW, 1);
				sunb.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 4);
				ItemMeta meta4 = sunb.getItemMeta();
				meta4.setDisplayName(ChatColor.GOLD + "Sun Bow");
				sunb.setItemMeta(meta4);

				ShapedRecipe sunrecipe = new ShapedRecipe(new ItemStack(sunb));
				sunrecipe.shape(" +-", "+=-", " +-");
				sunrecipe.setIngredient('=', Material.GOLD_INGOT);
				sunrecipe.setIngredient('-', Material.STRING);
				sunrecipe.setIngredient('+', Material.BLAZE_ROD);
				getServer().addRecipe(sunrecipe);
			}

			if(moonbow) {
				ItemStack moonb = new ItemStack(Material.BOW, 1);
				moonb.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 4);
				ItemMeta meta5 = moonb.getItemMeta();
				meta5.setDisplayName(ChatColor.BLUE + "Moon Bow");
				moonb.setItemMeta(meta5);

				ShapedRecipe moonrecipe = new ShapedRecipe(new ItemStack(moonb));
				moonrecipe.shape(" +-", "+*-", " +-");
				moonrecipe.setIngredient('*', Material.DIAMOND);
				moonrecipe.setIngredient('-', Material.STRING);
				moonrecipe.setIngredient('+', Material.BLAZE_ROD);
				getServer().addRecipe(moonrecipe);
			}

			if(spear) {
				ItemStack spear = new ItemStack(Material.STICK, 1);
				spear.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 4);
				ItemMeta meta6 = spear.getItemMeta();
				meta6.setDisplayName(ChatColor.YELLOW + "Spear");
				spear.setItemMeta(meta6);

				ShapedRecipe sprecipe = new ShapedRecipe(new ItemStack(spear));
				sprecipe.shape("  *", " $ ", "$  ");
				sprecipe.setIngredient('*', Material.DIAMOND);
				sprecipe.setIngredient('$', Material.STICK);
				getServer().addRecipe(sprecipe);
			}

			if(forgeHammer) {
				ItemStack fhammer = new ItemStack(Material.DIAMOND_AXE, 1);
				fhammer.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 4);
				ItemMeta meta7 = fhammer.getItemMeta();
				meta7.setDisplayName(ChatColor.RED + "Forge Hammer");
				fhammer.setItemMeta(meta7);

				ShapedRecipe fhrecipe = new ShapedRecipe(new ItemStack(fhammer));
				fhrecipe.shape(" **", " +*", " + ");
				fhrecipe.setIngredient('*', Material.DIAMOND);
				fhrecipe.setIngredient('+', Material.BLAZE_ROD);
				getServer().addRecipe(fhrecipe);
			}

			if(cadusus) {
				ItemStack cadus = new ItemStack(Material.BLAZE_ROD, 1);
				cadus.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 4);
				ItemMeta meta8 = cadus.getItemMeta();
				meta8.setDisplayName(ChatColor.YELLOW + "Cadusus");
				cadus.setItemMeta(meta8);

				ShapedRecipe cadrecipe = new ShapedRecipe(new ItemStack(cadus));
				cadrecipe.shape("  *", " + ", "+  ");
				cadrecipe.setIngredient('*', Material.DIAMOND);
				cadrecipe.setIngredient('+', Material.BLAZE_ROD);
				getServer().addRecipe(cadrecipe);
			}

			if(thyrsus) {
				ItemStack thyrsus = new ItemStack(Material.STICK, 1);
				thyrsus.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 4);
				ItemMeta meta9 = thyrsus.getItemMeta();
				meta9.setDisplayName(ChatColor.YELLOW + "Thyrsus");
				thyrsus.setItemMeta(meta9);

				ShapedRecipe thyrecipe = new ShapedRecipe(new ItemStack(thyrsus));
				thyrecipe.shape("  ^", " + ", "+  ");
				thyrecipe.setIngredient('^', Material.CARROT_ITEM);
				thyrecipe.setIngredient('+', Material.BLAZE_ROD);
				getServer().addRecipe(thyrecipe);
			}

			if(venustas) {
				ItemStack Venustas = new ItemStack(Material.DIAMOND_SWORD, 1);
				Venustas.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 4);
				ItemMeta meta10 = Venustas.getItemMeta();
				meta10.setDisplayName(ChatColor.DARK_PURPLE + "Venustas");
				Venustas.setItemMeta(meta10);

				ShapedRecipe venrecipe = new ShapedRecipe(new ItemStack(Venustas));
				venrecipe.shape(" * ", " * ", " + ");
				venrecipe.setIngredient('*', Material.DIAMOND);
				venrecipe.setIngredient('+', Material.BLAZE_ROD);
				getServer().addRecipe(venrecipe);
			}

			if(prudentia) {
				ItemStack Prudentia = new ItemStack(Material.IRON_SWORD, 1);
				Prudentia.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 5);
				Prudentia.addUnsafeEnchantment(Enchantment.DURABILITY, 4);
				ItemMeta meta11 = Prudentia.getItemMeta();
				meta11.setDisplayName(ChatColor.DARK_PURPLE + "Prudentia");
				Prudentia.setItemMeta(meta11);

				ShapedRecipe prurecipe = new ShapedRecipe(new ItemStack(Prudentia));
				prurecipe.shape(" @ ", " # ", " + ");
				prurecipe.setIngredient('@', Material.IRON_INGOT);
				prurecipe.setIngredient('#', Material.GOLD_INGOT);
				prurecipe.setIngredient('+', Material.BLAZE_ROD);
				getServer().addRecipe(prurecipe);
			}

			if(panflute) {
				ItemStack Panflute = new ItemStack(Material.STICK, 1);
				Panflute.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 5);
				Panflute.addUnsafeEnchantment(Enchantment.DURABILITY, 4);
				ItemMeta meta12 = Panflute.getItemMeta();
				meta12.setDisplayName(ChatColor.GREEN + "Panflute");
				Panflute.setItemMeta(meta12);

				ShapedRecipe panrecipe = new ShapedRecipe(new ItemStack(Panflute));
				panrecipe.shape(" s ", " m ", " s ");
				panrecipe.setIngredient('s', Material.STICK);
				panrecipe.setIngredient('m', Material.NOTE_BLOCK);
				getServer().addRecipe(panrecipe);
			}

			if(emeraldChestplate) {
				ItemStack ec = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
				ec.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 6);
				ItemMeta meta13 = ec.getItemMeta();
				meta13.setDisplayName(ChatColor.GREEN + "Emerald Chestplate");
				ec.setItemMeta(meta13);

				ShapedRecipe ecrecipe = new ShapedRecipe(new ItemStack(ec));
				ecrecipe.shape("e e", "eee", "eee");
				ecrecipe.setIngredient('e', Material.EMERALD);
				getServer().addRecipe(ecrecipe);
			}

			if(emeraldLeggings) {
				ItemStack el = new ItemStack(Material.DIAMOND_LEGGINGS, 1);
				el.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 6);
				ItemMeta meta14 = el.getItemMeta();
				meta14.setDisplayName(ChatColor.GREEN + "Emerald Legginigs");
				el.setItemMeta(meta14);

				ShapedRecipe elrecipe = new ShapedRecipe(new ItemStack(el));
				elrecipe.shape("eee", "e e", "e e");
				elrecipe.setIngredient('e', Material.EMERALD);
				getServer().addRecipe(elrecipe);
			}

			if(emeraldBoots) {
				ItemStack eb = new ItemStack(Material.DIAMOND_BOOTS, 1);
				eb.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 6);
				ItemMeta meta15 = eb.getItemMeta();
				meta15.setDisplayName(ChatColor.GREEN + "Emerald Boots");
				eb.setItemMeta(meta15);

				ShapedRecipe ebrecipe = new ShapedRecipe(new ItemStack(eb));
				ebrecipe.shape("   ", "e e", "e e");
				ebrecipe.setIngredient('e', Material.EMERALD);
				getServer().addRecipe(ebrecipe);
			}

			if(emeraldHelmet) {
				ItemStack eh = new ItemStack(Material.DIAMOND_HELMET, 1);
				eh.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 6);
				ItemMeta meta16 = eh.getItemMeta();
				meta16.setDisplayName(ChatColor.GREEN + "Emerald Helmet");
				eh.setItemMeta(meta16);

				ShapedRecipe ehrecipe = new ShapedRecipe(new ItemStack(eh));
				ehrecipe.shape("eee", "e e", "   ");
				ehrecipe.setIngredient('e', Material.EMERALD);
				getServer().addRecipe(ehrecipe);
			}

			if(emeraldSword) {
				ItemStack es = new ItemStack(Material.DIAMOND_SWORD, 1);
				es.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 7);
				ItemMeta meta18 = es.getItemMeta();
				meta18.setDisplayName(ChatColor.GREEN + "Emerald Sword");
				es.setItemMeta(meta18);

				ShapedRecipe esrecipe = new ShapedRecipe(new ItemStack(es));
				esrecipe.shape(" e ", " e ", " s ");
				esrecipe.setIngredient('e', Material.EMERALD);
				esrecipe.setIngredient('s', Material.STICK);
				getServer().addRecipe(esrecipe);
			}

			if(saddle) {
				ShapedRecipe saddle = new ShapedRecipe(new ItemStack(Material.SADDLE));
				saddle.shape(new String[]{"lll","~ ~","   "}).setIngredient('l', Material.LEATHER).setIngredient('~', Material.STRING);
				Bukkit.getServer().addRecipe(saddle);
			}
		}


		Bukkit.getServer().getPluginManager().registerEvents(this, this);
	}

	@Override
	public void onDisable() {
		getLogger().info("Plugin Disabled");

		getServer().clearRecipes();
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) { 
		Player player = (Player) sender;

		if (args.length == 0) {
			if(sender instanceof Player) {
				if (cmd.getName().equalsIgnoreCase("hermes") || cmd.getName().equalsIgnoreCase("mercury")) {
					if (player.hasPermission("demicraft.hermes") || player.hasPermission("demicraft.mercury")) {

						if(!hermer.contains(player.getName())) {

							player.sendMessage(ChatColor.GREEN + "You have the speed of Hermes/Mercury!");

							hermer.add(player.getName());

						} else {

							player.removePotionEffect(PotionEffectType.SPEED);
							player.sendMessage(ChatColor.GREEN + "You have lost the speed of Hermes/Mercury!");

							hermer.remove(player.getName());

						}

					} else {
						noPermission(player);
					}
				}
				else if(cmd.getName().equalsIgnoreCase("ares") || cmd.getName().equalsIgnoreCase("mars")) {
					if (player.hasPermission("demicraft.ares") || player.hasPermission("demicraft.mars")) {

						if(!armar.contains(player.getName())) {

							player.sendMessage(ChatColor.GREEN + "You have the strength of Ares!");

							armar.add(player.getName());

						} else {

							player.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
							player.sendMessage(ChatColor.GREEN + "You have lost the strength of Ares/Mars!");

							armar.remove(player.getName());

						}

					} else {
						noPermission(player);
					}
				}
				else if(cmd.getName().equalsIgnoreCase("zeus") || cmd.getName().equalsIgnoreCase("jupiter")) {
					if (player.hasPermission("demicraft.zeus") || player.hasPermission("demicraft.jupiter")) {

						if(!zeju.contains(player.getName())) {
							player.setAllowFlight(true);
							player.setFlying(true);
							player.sendMessage(ChatColor.GREEN  + "You have the power of flight");

							zeju.add(player.getName());

						} else {

							player.setAllowFlight(false);
							player.setFlying(false);
							player.sendMessage(ChatColor.GREEN + "You have lost the power of flight");

							zeju.remove(player.getName());

						}

					} else {
						noPermission(player);
					}
				}
				else if(cmd.getName().equalsIgnoreCase("hephaestus") || cmd.getName().equalsIgnoreCase("vulcan")) {
					if (player.hasPermission("demicraft.hephaestus") || player.hasPermission("demicraft.vulcan")) {

						if(!hephvul.contains(player.getName())) {

							player.sendMessage(ChatColor.GREEN + "You have the ressistance of Hephaestus/Vulcan!");

							hephvul.add(player.getName());

						} else {

							player.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
							player.sendMessage(ChatColor.GREEN + "You have lost the ressistance of Hephaestus/Vulcan!");

							hephvul.remove(player.getName());
						}

					} else {
						noPermission(player);
					}
				}
				else if(cmd.getName().equalsIgnoreCase("athena") || cmd.getName().equalsIgnoreCase("minerva")) {
					if (player.hasPermission("demicraft.athena") || player.hasPermission("demicraft.minerva")) {

						if(!athmen.contains(player.getName())) {

							player.sendMessage(ChatColor.GREEN + "You have the endurance of Athena/Minerva!");
							player.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 1200, 1));
							athmen.add(player.getName());

						} else {

							player.removePotionEffect(PotionEffectType.ABSORPTION);
							player.sendMessage(ChatColor.GREEN + "You have lost the endurance of Athena/Minerva!");

							athmen.remove(player.getName());

						}

					} else {
						noPermission(player);
					}
				}
				else if(cmd.getName().equalsIgnoreCase("hunt")) {
					if (player.hasPermission("demicraft.hunt")) {

						if(!hunt.contains(player.getName())) {

							player.sendMessage(ChatColor.GREEN + "You temperarily an invisible hunter!");

							hunt.add(player.getName());

						} else {

							player.removePotionEffect(PotionEffectType.INVISIBILITY);
							player.sendMessage(ChatColor.GREEN + "You have lost the invisibility!");

							hunt.remove(player.getName());

						}

					} else {
						noPermission(player);
					}
				}
				else if(cmd.getName().equalsIgnoreCase("dionysus")) {
					if(player.hasPermission("demicraft.dionysus")) {
						player.setFoodLevel(20);
						player.sendMessage(ChatColor.GREEN  + "You have been fed");
					}
					else {
						noPermission(player);
					}
				}
				else if(cmd.getName().equalsIgnoreCase("apollo")) {
					if(player.hasPermission("demicraft.apollo")) {
						player.setHealth(20.0);
						player.sendMessage(ChatColor.GREEN  + "You have been healed");
					}
					else {
						noPermission(player);
					}
				}
				else if(cmd.getName().equalsIgnoreCase("bacchus")) {
					if(player.hasPermission("demicraft.bacchus")) {
						player.setFoodLevel(20);
						player.sendMessage(ChatColor.GREEN  + "You have been fed");
					}
					else {
						noPermission(player);
					}
				}
				else if(cmd.getName().equalsIgnoreCase("phoebus")) {
					if(player.hasPermission("demicraft.phoebus")) {
						player.setHealth(20.0);
						player.sendMessage(ChatColor.GREEN  + "You have been healed");
					}
					else {
						noPermission(player);
					}
				}
				else if(cmd.getName().equalsIgnoreCase("titan")) {
					if (player.hasPermission("demicraft.titan")) {

						if(!titan.contains(player.getName())) {

							player.sendMessage(ChatColor.GREEN  + "You have the power of a Titan!");
							titan.add(player.getName());

						} else {

							player.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
							player.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
							player.removePotionEffect(PotionEffectType.SPEED);
							player.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);

							player.sendMessage(ChatColor.GREEN + "You have lost your power!");
							titan.remove(player.getName());

						}

					} else {
						noPermission(player);
					}
				}
				else if(cmd.getName().equalsIgnoreCase("divine")) {
					if (player.hasPermission("demicraft.divine")) {

						if(!divine.contains(player.getName())) {

							player.sendMessage(ChatColor.GREEN  + "You have the power of a God!");
							divine.add(player.getName());

						} else {

							player.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
							player.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
							player.removePotionEffect(PotionEffectType.SPEED);
							player.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);

							player.sendMessage(ChatColor.GREEN + "You have lost your power!");

							divine.remove(player.getName());

						}

					} else {
						noPermission(player);
					}
				}
				else if(cmd.getName().equalsIgnoreCase("demihelp")) {
					if (player.hasPermission("demicraft.help")) {
						openGuiChoose(player);
					} else {
						noPermission(player);
					}
				}
				else if(cmd.getName().equalsIgnoreCase("bless")) {
					if(player.hasPermission("demicraft.bless")) {
						if(player.getItemInHand().getType() == Material.DIAMOND_SWORD || player.getItemInHand().getType() == Material.IRON_SWORD || player.getItemInHand().getType() == Material.GOLD_SWORD || player.getItemInHand().getType() == Material.WOOD_SWORD || player.getItemInHand().getType() == Material.STONE_SWORD) {
							player.getItemInHand().addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 2);
							player.sendMessage(ChatColor.GREEN  + "You have blessed " + player.getItemInHand().getType());

						}
						else if(player.getItemInHand().getType() == Material.DIAMOND_HELMET|| player.getItemInHand().getType() == Material.IRON_HELMET|| player.getItemInHand().getType() == Material.GOLD_HELMET|| player.getItemInHand().getType() == Material.LEATHER_HELMET) {
							player.getItemInHand().addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
							player.sendMessage(ChatColor.GREEN  + "You have blessed " + player.getItemInHand().getType());

						}
						else if(player.getItemInHand().getType() == Material.DIAMOND_CHESTPLATE|| player.getItemInHand().getType() == Material.IRON_CHESTPLATE|| player.getItemInHand().getType() == Material.GOLD_CHESTPLATE|| player.getItemInHand().getType() == Material.LEATHER_CHESTPLATE) {
							player.getItemInHand().addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
							player.sendMessage(ChatColor.GREEN  + "You have blessed " + player.getItemInHand().getType());

						}
						else if(player.getItemInHand().getType() == Material.DIAMOND_LEGGINGS|| player.getItemInHand().getType() == Material.IRON_LEGGINGS|| player.getItemInHand().getType() == Material.GOLD_LEGGINGS|| player.getItemInHand().getType() == Material.LEATHER_LEGGINGS) {
							player.getItemInHand().addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
							player.sendMessage(ChatColor.GREEN  + "You have blessed " + player.getItemInHand().getType());

						}
						else if(player.getItemInHand().getType() == Material.DIAMOND_BOOTS|| player.getItemInHand().getType() == Material.IRON_BOOTS|| player.getItemInHand().getType() == Material.GOLD_BOOTS|| player.getItemInHand().getType() == Material.LEATHER_BOOTS) {
							player.getItemInHand().addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
							player.sendMessage(ChatColor.GREEN  + "You have blessed " + player.getItemInHand().getType());

						}
						else if(player.getItemInHand().getType() == Material.BOW) {
							player.getItemInHand().addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 2);
							player.sendMessage(ChatColor.GREEN  + "You have blessed " + player.getItemInHand().getType());

						}
						else {
							player.sendMessage(ChatColor.RED + "Item can not be enchanted!");
						}
					}
					else {
						noPermission(player);
					}
				}
				else if(cmd.getName().equalsIgnoreCase("checkpoint")) {
					if(player.hasPermission("demicraft.checkpoint")) {
						if(args.length != 0) {
							player.sendMessage(ChatColor.RED + "usage: /checkpoint");
						} else {
							player.setCompassTarget(player.getLocation());
							player.sendMessage(ChatColor.GREEN + "You have set your compass location to your current position!");
						}
					} else {
						noPermission(player);
					}
				}
			} else if(args.length == 1) {

				Player t = getServer().getPlayer(args[0]);
				if(t.isOnline()){
					if (cmd.getName().equalsIgnoreCase("hermes") || cmd.getName().equalsIgnoreCase("mercury")) {
						if (player.hasPermission("demicraft.give.hermes") || player.hasPermission("demicraft.give.mercury")) {

							if(!hermer.contains(t.getName())) {

								t.sendMessage(ChatColor.GREEN + "You have the speed of Hermes/Mercury!");
								getEffect(player, t, cmd);

								hermer.add(t.getName());

							} else {

								t.removePotionEffect(PotionEffectType.SPEED);
								t.sendMessage(ChatColor.GREEN + "You have lost the speed of Hermes/Mercury!");
								looseEffect(player, t, cmd);

								hermer.remove(t.getName());

							}

						} else {
							noPermission(player);
						}
					}
					else if(cmd.getName().equalsIgnoreCase("ares") || cmd.getName().equalsIgnoreCase("mars")) {
						if (player.hasPermission("demicraft.give.ares") || player.hasPermission("demicraft.give.mars")) {

							if(!armar.contains(t.getName())) {

								t.sendMessage(ChatColor.GREEN + "You have the strength of Ares!");
								getEffect(player, t, cmd);

								armar.add(t.getName());

							} else {

								t.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
								t.sendMessage(ChatColor.GREEN + "You have lost the strength of Ares/Mars!");
								looseEffect(player, t, cmd);

								armar.remove(t.getName());

							}

						} else {
							noPermission(player);
						}
					}
					else if(cmd.getName().equalsIgnoreCase("zeus") || cmd.getName().equalsIgnoreCase("jupiter")) {
						if (player.hasPermission("demicraft.give.zeus") || player.hasPermission("demicraft.give.jupiter")) {

							if(!zeju.contains(t.getName())) {
								t.setAllowFlight(true);
								t.setFlying(true);
								t.sendMessage(ChatColor.GREEN  + "You have the power of flight");
								getEffect(player, t, cmd);

								zeju.add(t.getName());

							} else {

								t.setAllowFlight(false);
								t.setFlying(false);
								t.sendMessage(ChatColor.GREEN + "You have lost the power of flight");
								looseEffect(player, t, cmd);

								zeju.remove(t.getName());

							}

						} else {
							noPermission(player);
						}
					}
					else if(cmd.getName().equalsIgnoreCase("hephaestus") || cmd.getName().equalsIgnoreCase("vulcan")) {
						if (player.hasPermission("demicraft.give.hephaestus") || player.hasPermission("demicraft.give.vulcan")) {

							if(!hephvul.contains(t.getName())) {

								t.sendMessage(ChatColor.GREEN + "You have the ressistance of Hephaestus/Vulcan!");
								getEffect(player, t, cmd);

								hephvul.add(t.getName());

							} else {

								t.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
								t.sendMessage(ChatColor.GREEN + "You have lost the ressistance of Hephaestus/Vulcan!");
								looseEffect(player, t, cmd);

								hephvul.remove(t.getName());
							}

						} else {
							noPermission(player);
						}
					}
					else if(cmd.getName().equalsIgnoreCase("athena") || cmd.getName().equalsIgnoreCase("minerva")) {
						if (player.hasPermission("demicraft.give.athena") || player.hasPermission("demicraft.give.minerva")) {

							if(!athmen.contains(t.getName())) {

								t.sendMessage(ChatColor.GREEN + "You have the endurance of Athena/Minerva!");
								getEffect(player, t, cmd);
								t.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 1200, 1));
								athmen.add(t.getName());

							} else {

								t.removePotionEffect(PotionEffectType.ABSORPTION);
								t.sendMessage(ChatColor.GREEN + "You have lost the endurance of Athena/Minerva!");
								looseEffect(player, t, cmd);

								athmen.remove(t.getName());

							}

						} else {
							noPermission(player);
						}
					}
					else if(cmd.getName().equalsIgnoreCase("hunt")) {
						if (player.hasPermission("demicraft.give.hunt")) {

							if(!hunt.contains(t.getName())) {

								t.sendMessage(ChatColor.GREEN + "You temperarily an invisible hunter!");
								getEffect(player, t, cmd);

								hunt.add(t.getName());

							} else {

								t.removePotionEffect(PotionEffectType.INVISIBILITY);
								t.sendMessage(ChatColor.GREEN + "You have lost the invisibility!");
								looseEffect(player, t, cmd);

								hunt.remove(t.getName());

							}

						} else {
							noPermission(player);
						}
					}
					else if(cmd.getName().equalsIgnoreCase("dionysus")) {
						if(player.hasPermission("demicraft.give.dionysus")) {
							t.setFoodLevel(20);
							t.sendMessage(ChatColor.GREEN  + "You have been fed");
							getEffect(player, t, cmd);
						}
						else {
							noPermission(t);
						}
					}
					else if(cmd.getName().equalsIgnoreCase("apollo")) {
						if(player.hasPermission("demicraft.give.apollo")) {
							t.setHealth(20.0);
							t.sendMessage(ChatColor.GREEN  + "You have been healed");
							getEffect(player, t, cmd);
						}
						else {
							noPermission(player);
						}
					}
					else if(cmd.getName().equalsIgnoreCase("bacchus")) {
						if(player.hasPermission("demicraft.give.bacchus")) {
							t.setFoodLevel(20);
							t.sendMessage(ChatColor.GREEN  + "You have been fed");
							getEffect(player, t, cmd);
						}
						else {
							noPermission(player);
						}
					}
					else if(cmd.getName().equalsIgnoreCase("phoebus")) {
						if(player.hasPermission("demicraft.give.phoebus")) {
							t.setHealth(20.0);
							t.sendMessage(ChatColor.GREEN  + "You have been healed");
							getEffect(player, t, cmd);
						}
						else {
							noPermission(player);
						}
					}
					else if(cmd.getName().equalsIgnoreCase("titan")) {
						if (player.hasPermission("demicraft.give.titan")) {

							if(!titan.contains(t.getName())) {

								t.sendMessage(ChatColor.GREEN  + "You have the power of a Titan!");
								getEffect(player, t, cmd);
								titan.add(t.getName());

							} else {

								t.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
								t.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
								t.removePotionEffect(PotionEffectType.SPEED);
								t.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);

								t.sendMessage(ChatColor.GREEN + "You have lost your power!");
								looseEffect(player, t, cmd);
								titan.remove(t.getName());

							}

						} else {
							noPermission(player);
						}
					}
					else if(cmd.getName().equalsIgnoreCase("divine")) {
						if (player.hasPermission("demicraft.give.divine")) {

							if(!divine.contains(t.getName())) {

								t.sendMessage(ChatColor.GREEN  + "You have the power of a God!");
								getEffect(player, t, cmd);
								divine.add(t.getName());

							} else {

								t.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
								t.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
								t.removePotionEffect(PotionEffectType.SPEED);
								t.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);

								t.sendMessage(ChatColor.GREEN + "You have lost your power!");
								looseEffect(player, t, cmd);

								divine.remove(t.getName());

							}

						} else {
							noPermission(player);
						}
					}
				} else {
					player.sendMessage(ChatColor.RED + "Player is not online!");
				}
			}
		}
		return false;

	}


	@EventHandler
	public void onPlayerEnterBoat(VehicleEnterEvent e) {
		Boat b = (Boat) e.getVehicle();
		Player p = (Player) e.getEntered();

		if(p.hasPermission("demicraft.posnep.boat")) {

			b.setMaxSpeed(0.9D);
			p.getWorld().playSound(p.getLocation(), Sound.ITEM_BREAK, 1, 1);
		} else {

			e.setCancelled(true);
			World world = (World) e.getVehicle().getWorld();
			Location ls = (Location) e.getVehicle().getLocation();
			world.strikeLightningEffect(ls);
			p.setHealth(10.0);
			b.remove();

		}

	}

	@EventHandler
	public void onPlayerInteract(final PlayerInteractEvent e) {
		final Player p = (Player) e.getPlayer();


		//zeus
		ItemStack zeusc = new ItemStack(Material.BLAZE_ROD, 1);
		zeusc.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 4);
		ItemMeta meta = zeusc.getItemMeta();
		meta.setDisplayName(ChatColor.GOLD + "Spatha " + ChatColor.GRAY + "-" + ChatColor.GREEN + " Charged");
		zeusc.setItemMeta(meta);

		ItemStack zeusuc = new ItemStack(Material.BLAZE_ROD, 1);
		zeusuc.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 4);
		ItemMeta meta1 = zeusuc.getItemMeta();
		meta1.setDisplayName(ChatColor.GOLD + "Spatha " + ChatColor.GRAY + "-" + ChatColor.RED + " Uncharged");
		zeusuc.setItemMeta(meta1);


		//poseidon
		ItemStack posc = new ItemStack(Material.DIAMOND_HOE, 1);
		posc.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 4);
		ItemMeta metapos = posc.getItemMeta();
		metapos.setDisplayName(ChatColor.AQUA + "Trident" + ChatColor.GRAY + "-" + ChatColor.GREEN + " Charged");
		posc.setItemMeta(metapos);

		ItemStack posuc = new ItemStack(Material.DIAMOND_HOE, 1);
		posuc.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 4);
		ItemMeta metapos1 = posuc.getItemMeta();
		metapos1.setDisplayName(ChatColor.AQUA + "Trident" + ChatColor.GRAY + "-" + ChatColor.RED + " Uncharged");
		posuc.setItemMeta(metapos1);


		if(!(e.getAction() == Action.RIGHT_CLICK_AIR) && !(e.getAction() == Action.RIGHT_CLICK_BLOCK)) return;
		if(!(e.getItem().getType() == Material.BLAZE_ROD) && !(e.getItem().getType() == Material.DIAMOND_HOE)) return; 

		if(!cooldownz.contains(p)) {
			if(p.getItemInHand().isSimilar(zeusc)) {

				if(p.hasPermission("demicraft.zeus.smite") || p.hasPermission("demicraft.jupiter.smite")) {

					p.getItemInHand().setItemMeta(meta1);
					p.getWorld().playEffect(e.getPlayer().getLocation(), Effect.SMOKE, 10);
					e.getPlayer().getWorld().strikeLightning((e.getPlayer().getTargetBlock(null, 100).getLocation()));
					cooldownz.add(p);
					// Cooldown
					Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
						public void run(){
							cooldownz.remove(p);
						}
					}, 100);



				} 
			} else if(p.getItemInHand().isSimilar(zeusuc)) {

				if(p.hasPermission("demicraft.zeus.smite") || p.hasPermission("demicraft.jupiter.smite")) {
					p.getItemInHand().setItemMeta(meta);
				} 
			}
		}
		if(!cooldownp.contains(p)) {
			if(p.getItemInHand().isSimilar(posc)) {

				if(p.hasPermission("demicraft.poseidon.shoot") || p.hasPermission("demicraft.neptune.shoot")) {

					p.getItemInHand().setItemMeta(metapos1);
					p.getWorld().playEffect(e.getPlayer().getLocation(), Effect.SMOKE, 10);
					Snowball s = e.getPlayer().launchProjectile(Snowball.class);		
					cooldownp.add(p);
					// Cooldown
					Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
						public void run(){
							cooldownp.remove(p);
						}
					}, 50);



				} 
			} else if(p.getItemInHand().isSimilar(posuc)) {

				if(p.hasPermission("demicraft.poseidon.shoot") || p.hasPermission("demicraft.neptune.shoot")) {
					p.getItemInHand().setItemMeta(metapos);
				} 
			}
		}
	}

	/*@EventHandler public void onProjectileHit(ProjectileHitEvent e) {

		Projectile projectile = (Projectile) e.getEntity();
		Entity possibleTarget = projectile.;
		Player target = (Player) e.getEntity();

		if(possibleTarget == null || !(possibleTarget instanceof Player))
			return;

		if (projectile instanceof Snowball) {
			target.damage(2D);
		}
	}*/

	@EventHandler
	public void onConsume(PlayerItemConsumeEvent e) {
		Player p = (Player) e.getPlayer();

		if(e.getItem().getType() == Material.ROTTEN_FLESH) {
			if(p.hasPermission("demicraft.hades") || p.hasPermission("demicraft.pluto")) {

				e.setCancelled(true);
				p.removePotionEffect(PotionEffectType.HUNGER);
				p.setSaturation(p.getSaturation() + 2);
				p.setFoodLevel(p.getFoodLevel() + 2);
				if(p.getItemInHand().getAmount() == 1) {
					e.getItem().setAmount(0);
				} else {
					p.getItemInHand().setAmount(p.getItemInHand().getAmount() - 1);
				}

			} else {

				p.playSound(p.getLocation(), Sound.BAT_DEATH, 1, 1);

			}
		} else {

		}
	}

	@EventHandler
	public void onPlayerMove(final PlayerMoveEvent event) {

		final Player p = (Player) event.getPlayer();

		if(hermer.toString().contains(p.getName())) {
			if(!p.getActivePotionEffects().contains(PotionEffectType.SPEED)) {

				p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 8000000, 2));

			} else {}
		}

		if(armar.toString().contains(p.getName())) {
			if(!p.getActivePotionEffects().contains(PotionEffectType.INCREASE_DAMAGE)) {

				p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 8000000, 2));

			} else {}
		}

		if(hephvul.toString().contains(p.getName())) {
			if(!p.getActivePotionEffects().contains(PotionEffectType.FIRE_RESISTANCE)) {

				p.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 8000000, 2));

			} else {}
		}

		if(hunt.toString().contains(p.getName())) {
			if(!p.getActivePotionEffects().contains(PotionEffectType.INVISIBILITY)) {

				p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 8000000, 1));

			} else {}
		}

		if(titan.toString().contains(p.getName())) {

			if(!p.getActivePotionEffects().contains(PotionEffectType.FIRE_RESISTANCE)) {

				p.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 8000000, 2));

			} 
			if(!p.getActivePotionEffects().contains(PotionEffectType.INCREASE_DAMAGE)) {

				p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 8000000, 2));

			}
			if(!p.getActivePotionEffects().contains(PotionEffectType.SPEED)) {

				p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 8000000, 3));

			}
			if(!p.getActivePotionEffects().contains(PotionEffectType.DAMAGE_RESISTANCE)) {

				p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 8000000, 2));

			}

		} else {}

		if(divine.toString().contains(p.getName())) {

			if(!p.getActivePotionEffects().contains(PotionEffectType.FIRE_RESISTANCE)) {

				p.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 8000000, 2));

			} 
			if(!p.getActivePotionEffects().contains(PotionEffectType.INCREASE_DAMAGE)) {

				p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 8000000, 3));

			}
			if(!p.getActivePotionEffects().contains(PotionEffectType.SPEED)) {

				p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 8000000, 4));

			}
			if(!p.getActivePotionEffects().contains(PotionEffectType.DAMAGE_RESISTANCE)) {

				p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 8000000, 3));

			}

		}


		if (event.getTo().getBlock().isLiquid()) {
			if(p.hasPermission("demicraft.poseidon") || p.hasPermission("demicraft.neptune")) {

				int mair = p.getMaximumAir();
				p.setRemainingAir(mair);
				p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 500, 1));

			}

		} else {
			if(p.hasPermission("demicraft.poseidon") || p.hasPermission("demicraft.neptune")) {
				p.removePotionEffect(PotionEffectType.NIGHT_VISION);
			}
		}
	}



	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e){

		String var = e.getPlayer().getName();
		String joinMessages = joinMessage.replaceAll("p%", var);

		if(!e.getPlayer().hasPermission("demicraft.silentJoin")) {
			e.setJoinMessage(ChatColor.YELLOW + joinMessages);
		}

		if(fireworkOnJoin) {
			Firework f = (Firework) e.getPlayer().getWorld().spawn(e.getPlayer().getLocation(), Firework.class);
			FireworkMeta fm = f.getFireworkMeta();
			fm.addEffect(FireworkEffect.builder()
					.flicker(false)
					.trail(true)
					.with(Type.BALL)
					.with(Type.BALL_LARGE)
					.with(Type.STAR)
					.withColor(Color.YELLOW)
					.withColor(Color.ORANGE)
					.withFade(Color.RED)
					.withFade(Color.PURPLE)
					.build());
			fm.setPower(2);
			f.setFireworkMeta(fm);

		}
	}

	@EventHandler
	public void onPlayerLeave(PlayerQuitEvent e){
		Player p = (Player) e.getPlayer();

		String var = p.getName();
		String leaveMessages = leaveMessage.replaceAll("p%", var);

		if(!e.getPlayer().hasPermission("demicraft.silentLeave")) {
			e.setQuitMessage(ChatColor.YELLOW + leaveMessages);
		}
	}

	//////////////
	// OPEN GUI //
	//////////////
	public void openGuiChoose(Player p) {
		Inventory inv = Bukkit.createInventory(null, 9, ChatColor.AQUA + "Demigod Craft");

		ItemStack Greek = new ItemStack (Material.GOLD_BLOCK);
		ItemMeta greekMeta = Greek.getItemMeta();

		ItemStack Roman = new ItemStack(Material.REDSTONE_BLOCK);
		ItemMeta RomanMeta = Roman.getItemMeta();

		ItemStack Spacer = new ItemStack(Material.PAPER);
		ItemMeta SpacerMeta = Spacer.getItemMeta();

		greekMeta.setDisplayName(ChatColor.GOLD + "Greek");
		Greek.setItemMeta(greekMeta);

		RomanMeta.setDisplayName(ChatColor.RED + "Roman");
		Roman.setItemMeta(RomanMeta);

		SpacerMeta.setDisplayName(" ");
		Spacer.setItemMeta(SpacerMeta);

		inv.setItem(0, Greek);
		inv.setItem(1, Spacer);
		inv.setItem(2, Spacer);
		inv.setItem(3, Spacer);
		inv.setItem(4, Spacer);
		inv.setItem(5, Spacer);
		inv.setItem(6, Spacer);
		inv.setItem(7, Spacer);
		inv.setItem(8, Roman);

		p.openInventory(inv);

	}

	public void openGuiGreek(Player p) {
		Inventory inv = Bukkit.createInventory(null, 9, ChatColor.AQUA + "Greek");

		ItemStack zeusGUI = new ItemStack (Material.BLAZE_ROD);
		ItemMeta zeusGUIMeta = zeusGUI.getItemMeta();
		zeusGUIMeta.setDisplayName(ChatColor.GOLD + "Zeus");
		zeusGUI.setItemMeta(zeusGUIMeta);



		ItemStack Spacer = new ItemStack(Material.PAPER);
		ItemMeta SpacerMeta = Spacer.getItemMeta();
		SpacerMeta.setDisplayName(" ");
		Spacer.setItemMeta(SpacerMeta);

		inv.setItem(0, zeusGUI);
		inv.setItem(1, Spacer);
		inv.setItem(2, Spacer);
		inv.setItem(3, Spacer);
		inv.setItem(4, Spacer);
		inv.setItem(5, Spacer);
		inv.setItem(6, Spacer);
		inv.setItem(7, Spacer);
		inv.setItem(8, Spacer);

		p.openInventory(inv);

	}

	public void openGuiRoman(Player p) {
		Inventory inv = Bukkit.createInventory(null, 9, ChatColor.AQUA + "Roman");

		ItemStack zeusGUI = new ItemStack (Material.BLAZE_ROD);
		ItemMeta zeusGUIMeta = zeusGUI.getItemMeta();
		zeusGUIMeta.setDisplayName(ChatColor.GOLD + "Jupiter");
		zeusGUI.setItemMeta(zeusGUIMeta);



		ItemStack Spacer = new ItemStack(Material.PAPER);
		ItemMeta SpacerMeta = Spacer.getItemMeta();
		SpacerMeta.setDisplayName(" ");
		Spacer.setItemMeta(SpacerMeta);

		inv.setItem(0, zeusGUI);
		inv.setItem(1, Spacer);
		inv.setItem(2, Spacer);
		inv.setItem(3, Spacer);
		inv.setItem(4, Spacer);
		inv.setItem(5, Spacer);
		inv.setItem(6, Spacer);
		inv.setItem(7, Spacer);
		inv.setItem(8, Spacer);

		p.openInventory(inv);

	}

	////////////////////////
	// Check Item Clicked //
	////////////////////////
	@EventHandler
	public void onInventoryEvent(InventoryClickEvent e) {

		Player p =(Player) e.getWhoClicked();
		String chest = ChatColor.stripColor(e.getInventory().getName());


		if(e.getCurrentItem()==null || e.getCurrentItem().getType()==Material.AIR || !e.getCurrentItem().hasItemMeta()) {
			return;

		}

		if(chest.equalsIgnoreCase("Demigod Craft") || chest.equalsIgnoreCase("Greek") || chest.equalsIgnoreCase("Roman")) {
			if(ChatColor.stripColor(e.getInventory().getName()).equalsIgnoreCase("Demigod Craft")) {
				switch(e.getCurrentItem().getType()){
				case GOLD_BLOCK:
					e.setCancelled(true);
					p.closeInventory();
					openGuiGreek(p);
					break;
				case REDSTONE_BLOCK:
					e.setCancelled(true);
					p.closeInventory();
					openGuiRoman(p);
					break;
				default:
					e.setCancelled(true);
					break;
				}
				return;
			} else if(ChatColor.stripColor(e.getInventory().getName()).equalsIgnoreCase("Greek")) {
				switch(e.getCurrentItem().getType()){
				case BLAZE_ROD:
					e.setCancelled(true);
					p.sendMessage(String.format("%sYou have chosen %sZeus%s!", ChatColor.AQUA, ChatColor.RED, ChatColor.AQUA));
					break;
				default:
					e.setCancelled(true);
					p.closeInventory();
					break;
				}
				return;
			} else if(ChatColor.stripColor(e.getInventory().getName()).equalsIgnoreCase("Roman")) {
				switch(e.getCurrentItem().getType()){
				case BLAZE_ROD:
					e.setCancelled(true);
					p.sendMessage(String.format("%sYou have chosen %sJupiter%s!", ChatColor.AQUA, ChatColor.RED, ChatColor.AQUA));
					break;
				default:
					e.setCancelled(true);
					p.closeInventory();
					break;
				}
				return;
			}
		} else {
			return;
		}

	}



	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent e) {
		Player p = (Player) e.getEntity();
		e.setDeathMessage(ChatColor.GOLD + "Player " + ChatColor.GOLD + p.getDisplayName() + ChatColor.GOLD + " was killed by " + ChatColor.GOLD + p.getKiller().getDisplayName() + ChatColor.GOLD + " using " + ChatColor.GOLD + p.getKiller().getItemInHand().getType().toString().toLowerCase() + ChatColor.GOLD + "!");
	}

	public void noPermission(Player player){
		player.sendMessage(ChatColor.RED + "Error: No Permission");
	}

	public void getEffect(Player p, Player t, Command cmd) {
		p.sendMessage(ChatColor.GREEN + t.getDisplayName() + ChatColor.AQUA + " has been given the effect " + ChatColor.GREEN + cmd.getName() + ChatColor.AQUA + "!");
	}

	public void looseEffect(Player p, Player t, Command cmd) {
		p.sendMessage(ChatColor.GREEN + t.getDisplayName() + ChatColor.AQUA + " has lost the effect " + ChatColor.GREEN + cmd.getName() + ChatColor.AQUA + "!");
	}
	
	public boolean isInWater(Player p) {
		if(p.getLocation().getBlock().getType() == Material.WATER){
			return true;
		} else {
			return false;
		}
		
		
	}
}
