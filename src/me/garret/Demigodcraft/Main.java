package me.garret.Demigodcraft;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
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

import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;


public class Main extends JavaPlugin implements Listener{



	public ArrayList<Player> cooldownz = new ArrayList<Player>();
	public ArrayList<Player> cooldownp = new ArrayList<Player>();
	public ArrayList<Player> cooldowndb = new ArrayList<Player>();
	public ArrayList<Player> cooldownap = new ArrayList<Player>();
	public List<String> hermer = new ArrayList<String>();
	public List<String> armar = new ArrayList<String>();
	public List<String> zeju = new ArrayList<String>();
	public List<String> hephvul = new ArrayList<String>();
	public List<String> athmen = new ArrayList<String>();
	public List<String> hunt = new ArrayList<String>();
	public List<String> hero = new ArrayList<String>();
	public List<String> divine = new ArrayList<String>(); 
	public List<String> aphven = new ArrayList<String>(); 
	public List<String> godGlow = new ArrayList<String>(); 

	// custom crafting booleans // 
	public boolean customCraft = false;
	public boolean trident = true;
	public boolean spatha = true;
	public boolean pitchfork = true;
	public boolean sunbow = true;
	public boolean moonbow = true;
	public boolean fireworkOnJoin = true;
	public String joinMessage = "%p% joined the game!";
	public String leaveMessage = "%p% left the game!";
	public boolean demiGUI = true;
	public String ZeusRankName = "Zeus";
	public String JupiterRankName = "Jupiter";
	public String PoseidonRankName = "Poseidon";
	public String NeptuneRankName = "Neptune";
	public String HadesRankName = "Hades";
	public String PlutoRankName = "Pluto";

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
		this.fireworkOnJoin = this.getConfig().getBoolean("fireworkOnJoin");
		this.joinMessage = this.getConfig().getString("joinMessage");
		this.leaveMessage = this.getConfig().getString("leaveMessage");

		if (customCraft) {
			// weapon of Poseidon
			if(trident) {
				ItemStack trident = new ItemStack(Material.TRIDENT, 1);
				trident.addEnchantment(Enchantment.DAMAGE_ALL, 3);
				trident.addEnchantment(Enchantment.RIPTIDE, 3);
				trident.addEnchantment(Enchantment.MENDING, 1);
				ItemMeta meta = trident.getItemMeta();
				meta.setUnbreakable(true);
				meta.setDisplayName(ChatColor.AQUA + "Trident " + ChatColor.GRAY + "-" + ChatColor.GREEN + " Charged");
				trident.setItemMeta(meta);

				ShapedRecipe trecipe = new ShapedRecipe(new ItemStack(trident));
				trecipe.shape(" { ", "{{{", "***");
				trecipe.setIngredient('*', Material.DIAMOND);
				trecipe.setIngredient('{', Material.IRON_INGOT);
				getServer().addRecipe(trecipe);
			}
			// weapon of zeus
			if(spatha) {

				ItemStack spatha = new ItemStack(Material.GOLDEN_SWORD, 1);
				spatha.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 4);
				spatha.addEnchantment(Enchantment.FIRE_ASPECT, 1);
				spatha.addEnchantment(Enchantment.MENDING, 1);
				ItemMeta meta2 = spatha.getItemMeta();
				meta2.setDisplayName(ChatColor.GOLD + "Spatha " + ChatColor.GRAY + "-" + ChatColor.GREEN + " Charged");
				spatha.setItemMeta(meta2);

				ShapedRecipe srecipe = new ShapedRecipe(new ItemStack(spatha));
				srecipe.shape(" + ", " # ", " # ");
				srecipe.setIngredient('+', Material.BLAZE_ROD);
				srecipe.setIngredient('#', Material.GOLD_INGOT);
				getServer().addRecipe(srecipe);
			}
			//weapon of hades
			if(pitchfork) {
				ItemStack fork = new ItemStack(Material.DIAMOND_SHOVEL, 1);
				fork.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 5);
				ItemMeta meta3 = fork.getItemMeta();
				meta3.setDisplayName(ChatColor.RED + "Pitchfork");
				fork.setItemMeta(meta3);

				ShapedRecipe frecipe = new ShapedRecipe(new ItemStack(fork));
				frecipe.shape("*+*", " + ", " + ");
				frecipe.setIngredient('*', Material.DIAMOND);
				frecipe.setIngredient('+', Material.BLAZE_ROD);
				getServer().addRecipe(frecipe);
			}
			//weapon of apollo
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
			//weapon of atemis
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
		final Player cp = (Player) sender;

		if (args.length == 0) {
			if(sender instanceof Player) {
				if (cmd.getName().equalsIgnoreCase("hermes") || cmd.getName().equalsIgnoreCase("mercury")) {
					if (player.hasPermission("demicraft.hermes") || player.hasPermission("demicraft.mercury")) {

						if(!hermer.contains(player.getName())) {

							player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 8000000, 3));
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
							
							player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 8000000, 1));

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
							player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 8000000, 1));

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
							player.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 8000000, 1));
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
				else if(cmd.getName().equalsIgnoreCase("aphrodite") || cmd.getName().equalsIgnoreCase("venus")) {
					if (player.hasPermission("demicraft.aphrodite") || player.hasPermission("demicraft.venus")) {

						if(!aphven.contains(player.getName())) {

							player.sendMessage(ChatColor.GREEN + "You have the resistance of love from Aphrodite/Venus!");
							player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 8000000, 1));
							aphven.add(player.getName());

						} else {

							player.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
							player.sendMessage(ChatColor.GREEN + "You have lost the resistance of love fron Aphrodite/Venus!");

							aphven.remove(player.getName());

						}

					} else {
						noPermission(player);
					}
				}
				else if(cmd.getName().equalsIgnoreCase("godGlow")) {
					if (player.hasPermission("demicraft.godGlow")) {

						if(!godGlow.contains(player.getName())) {

							player.sendMessage(ChatColor.GREEN + "You now radiate power!");
							player.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 8000000, 1));
							godGlow.add(player.getName());

						} else {

							player.removePotionEffect(PotionEffectType.GLOWING);
							player.sendMessage(ChatColor.GREEN + "You have hidden your power!");

							godGlow.remove(player.getName());

						}

					} else {
						noPermission(player);
					}
				}
				else if(cmd.getName().equalsIgnoreCase("hunt")) {
					if (player.hasPermission("demicraft.hunt")) {

						if(!hunt.contains(player.getName())) {

							player.sendMessage(ChatColor.GREEN + "You are temporarily an invisible hunter!");

							player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 800000, 1));
							
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
						if (!cooldowndb.contains(cp)) {
							
							player.setFoodLevel(20);
							player.setSaturation(5);
							player.sendMessage(ChatColor.GREEN  + "You have been fed");
							// Cool down
							cooldowndb.add(cp);
							Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
								public void run(){
									cooldowndb.remove(cp);
								}
							}, 1200);
							
						} else {
							player.sendMessage(ChatColor.RED + "You can only issue this command once every 60 seconds.");
						}
					}
					else {
						noPermission(player);
					}
				}
				else if(cmd.getName().equalsIgnoreCase("apollo")) {
					if(player.hasPermission("demicraft.apollo")) {
						if (!cooldownap.contains(cp)) {

							player.setHealth(20.0);
							player.sendMessage(ChatColor.GREEN  + "You have been healed");
							// Cool down
							cooldownap.add(cp);
							Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
								public void run(){
									cooldownap.remove(cp);
								}
							}, 1200);
							
						} else {
							player.sendMessage(ChatColor.RED + "You can only issue this command once every 60 seconds.");
						}
					}
					else {
						noPermission(player);
					}
				}
				else if(cmd.getName().equalsIgnoreCase("bacchus")) {
					if(player.hasPermission("demicraft.bacchus")) {
						if (!cooldowndb.contains(cp)) {

							player.setFoodLevel(20);
							player.setSaturation(5);
							player.sendMessage(ChatColor.GREEN  + "You have been fed");
							// Cool down
							cooldowndb.add(cp);
							Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
								public void run(){
									cooldowndb.remove(cp);
								}
							}, 1200);
							
						} else {
							player.sendMessage(ChatColor.RED + "You can only issue this command once every 60 seconds.");
						}
					}
					else {
						noPermission(player);
					}
				}
				else if(cmd.getName().equalsIgnoreCase("phoebus")) {
					if(player.hasPermission("demicraft.phoebus")) {
						if (!cooldownap.contains(cp)) {

							player.setHealth(20.0);
							player.sendMessage(ChatColor.GREEN  + "You have been healed");
							// Cool down
							cooldownap.add(cp);
							Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
								public void run(){
									cooldownap.remove(cp);
								}
							}, 1200);
							
						} else {
							player.sendMessage(ChatColor.RED + "You can only issue this command once every 60 seconds.");
						}
					}
					else {
						noPermission(player);
					}
				}
				else if(cmd.getName().equalsIgnoreCase("hero")) {
					if (player.hasPermission("demicraft.hero")) {

						if(!hero.contains(player.getName())) {

							player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 8000000, 1));
							player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 8000000, 1));
							player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 8000000, 1));
							player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 8000000, 1));


							player.sendMessage(ChatColor.GREEN  + "You have the power of a Hero!");
							hero.add(player.getName());

						} else {

							player.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
							player.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
							player.removePotionEffect(PotionEffectType.SPEED);
							player.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);

							player.sendMessage(ChatColor.GREEN + "You have lost your power!");
							hero.remove(player.getName());

						}

					} else {
						noPermission(player);
					}
				}
				else if(cmd.getName().equalsIgnoreCase("divine")) {
					if (player.hasPermission("demicraft.divine")) {

						if(!divine.contains(player.getName())) {

							player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 8000000, 2));
							player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 8000000, 2));
							player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 8000000, 2));
							player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 8000000, 2));
							
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
				else if(cmd.getName().equalsIgnoreCase("demichoose") && demiGUI == true) {
					if (player.hasPermission("demicraft.choose")) {
						openGuiChoose(player);
					} else {
						noPermission(player);
					}
				}
				else if(cmd.getName().equalsIgnoreCase("bless")) {
					if(player.hasPermission("demicraft.bless")) {
						if(player.getInventory().getItemInMainHand().getType() == Material.DIAMOND_SWORD || player.getInventory().getItemInMainHand().getType() == Material.IRON_SWORD || player.getInventory().getItemInMainHand().getType() == Material.GOLDEN_SWORD || player.getInventory().getItemInMainHand().getType() == Material.WOODEN_SWORD || player.getInventory().getItemInMainHand().getType() == Material.STONE_SWORD) {
							player.getInventory().getItemInMainHand().addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 2);
							player.sendMessage(ChatColor.GREEN  + "You have blessed " + player.getInventory().getItemInMainHand().getType());

						}
						else if(player.getInventory().getItemInMainHand().getType() == Material.DIAMOND_HELMET|| player.getInventory().getItemInMainHand().getType() == Material.IRON_HELMET|| player.getInventory().getItemInMainHand().getType() == Material.GOLDEN_HELMET|| player.getInventory().getItemInMainHand().getType() == Material.LEATHER_HELMET) {
							player.getInventory().getItemInMainHand().addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
							player.sendMessage(ChatColor.GREEN  + "You have blessed " + player.getInventory().getItemInMainHand().getType());

						}
						else if(player.getInventory().getItemInMainHand().getType() == Material.DIAMOND_CHESTPLATE|| player.getInventory().getItemInMainHand().getType() == Material.IRON_CHESTPLATE|| player.getInventory().getItemInMainHand().getType() == Material.GOLDEN_CHESTPLATE|| player.getInventory().getItemInMainHand().getType() == Material.LEATHER_CHESTPLATE) {
							player.getInventory().getItemInMainHand().addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
							player.sendMessage(ChatColor.GREEN  + "You have blessed " + player.getInventory().getItemInMainHand().getType());

						}
						else if(player.getInventory().getItemInMainHand().getType() == Material.DIAMOND_LEGGINGS|| player.getInventory().getItemInMainHand().getType() == Material.IRON_LEGGINGS|| player.getInventory().getItemInMainHand().getType() == Material.GOLDEN_LEGGINGS|| player.getInventory().getItemInMainHand().getType() == Material.LEATHER_LEGGINGS) {
							player.getInventory().getItemInMainHand().addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
							player.sendMessage(ChatColor.GREEN  + "You have blessed " + player.getInventory().getItemInMainHand().getType());

						}
						else if(player.getInventory().getItemInMainHand().getType() == Material.DIAMOND_BOOTS|| player.getInventory().getItemInMainHand().getType() == Material.IRON_BOOTS|| player.getInventory().getItemInMainHand().getType() == Material.GOLDEN_BOOTS|| player.getInventory().getItemInMainHand().getType() == Material.LEATHER_BOOTS) {
							player.getInventory().getItemInMainHand().addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
							player.sendMessage(ChatColor.GREEN  + "You have blessed " + player.getInventory().getItemInMainHand().getType());

						}
						else if(player.getInventory().getItemInMainHand().getType() == Material.BOW) {
							player.getInventory().getItemInMainHand().addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 2);
							player.sendMessage(ChatColor.GREEN  + "You have blessed " + player.getInventory().getItemInMainHand().getType());

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
			} 
		}
		else if(args.length == 1) {
				
				Player t = player.getServer().getPlayer(args[0]);
					
					if ((t).isOnline() && sender instanceof Player) {
						if (cmd.getName().equalsIgnoreCase("hermes") || cmd.getName().equalsIgnoreCase("mercury")) {
							if (player.hasPermission("demicraft.give.hermes") || player.hasPermission("demicraft.give.mercury")) {
	
								if(!hermer.contains(t.getName())) {

									t.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 8000000, 3));
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

									t.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 8000000, 1));
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

									t.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 8000000, 3));
									t.sendMessage(ChatColor.GREEN + "You have the ressistance of Hephaestus/Vulcan!");
									getEffect(player, t, cmd);
									t.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 800000, 1));
	
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

									t.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 8000000, 1));
									t.sendMessage(ChatColor.GREEN + "You have the endurance of Athena/Minerva!");
									getEffect(player, t, cmd);
									t.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 800000, 1));
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
						else if(cmd.getName().equalsIgnoreCase("aphrodite") || cmd.getName().equalsIgnoreCase("venus")) {
							if (player.hasPermission("demicraft.give.aphrodite") || player.hasPermission("demicraft.give.venus")) {
	
								if(!aphven.contains(t.getName())) {
	
									t.sendMessage(ChatColor.GREEN + "You have the resistance of love from Aphrodite/Venus!");
									getEffect(player, t, cmd);
									t.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 800000, 1));
									aphven.add(t.getName());
	
								} else {
	
									t.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
									t.sendMessage(ChatColor.GREEN + "You have lost the resistance of love from Aphrodite/Venus!");
									looseEffect(player, t, cmd);
	
									aphven.remove(t.getName());
	
								}
	
							} else {
								noPermission(player);
							}
						}
						else if(cmd.getName().equalsIgnoreCase("godGlow")) {
							if (player.hasPermission("demicraft.give.godGlow")) {
								if(!godGlow.contains(t.getName())) {
	
									t.sendMessage(ChatColor.GREEN + "You now radiate power!");
									getEffect(player, t, cmd);
									t.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 800000, 1));
									godGlow.add(t.getName());
	
								} else {
	
									t.removePotionEffect(PotionEffectType.GLOWING);
									t.sendMessage(ChatColor.GREEN + "You have hidden your power!");
									looseEffect(player, t, cmd);
	
									godGlow.remove(t.getName());
	
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
									t.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 800000, 1));
	
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
								player.setSaturation(5);
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
								player.setSaturation(5);
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
						else if(cmd.getName().equalsIgnoreCase("hero")) {
							if (player.hasPermission("demicraft.give.hero")) {
	
								if(!hero.contains(t.getName())) {
	
									t.sendMessage(ChatColor.GREEN  + "You have the power of a Hero!");
									getEffect(player, t, cmd);
									hero.add(t.getName());
	
								} else {
	
									t.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
									t.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
									t.removePotionEffect(PotionEffectType.SPEED);
									t.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
	
									t.sendMessage(ChatColor.GREEN + "You have lost your power!");
									looseEffect(player, t, cmd);
									hero.remove(t.getName());
	
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
						player.sendMessage(ChatColor.RED + "Player " + t.getName() + " is not online!");
					}
			}
		return false;

	}


	@EventHandler
	public void onPlayerEnterBoat(VehicleEnterEvent e) {
		Boat b = (Boat) e.getVehicle();
		Player p = (Player) e.getEntered();

		if(p.hasPermission("demicraft.poseidon.boat") || p.hasPermission("demicraft.neptune.boat")) {

			b.setMaxSpeed(2.0D);;
			p.getWorld().playSound(p.getLocation(), Sound.ENTITY_ITEM_BREAK, 1, 1);
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
		ItemStack zeusc = new ItemStack(Material.GOLDEN_SWORD, 1);
		zeusc.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 4);
		zeusc.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 1);
		zeusc.addUnsafeEnchantment(Enchantment.MENDING, 1);
		ItemMeta meta = zeusc.getItemMeta();
		meta.setDisplayName(ChatColor.GOLD + "Spatha " + ChatColor.GRAY + "-" + ChatColor.GREEN + " Charged");
		zeusc.setItemMeta(meta);

		ItemStack zeusuc = new ItemStack(Material.GOLDEN_SWORD, 1);
		zeusuc.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 4);
		zeusuc.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 1);
		zeusuc.addUnsafeEnchantment(Enchantment.MENDING, 1);
		ItemMeta meta1 = zeusuc.getItemMeta();
		meta1.setDisplayName(ChatColor.GOLD + "Spatha " + ChatColor.GRAY + "-" + ChatColor.RED + " Uncharged");
		zeusuc.setItemMeta(meta1);



		if(!(e.getAction() == Action.RIGHT_CLICK_AIR) && !(e.getAction() == Action.RIGHT_CLICK_BLOCK)) return;
		if(!(e.getItem().getType() == Material.GOLDEN_SWORD)) return; 

		if(!cooldownz.contains(p)) {
			if(p.getInventory().getItemInMainHand().isSimilar(zeusc)) {

				if(p.hasPermission("demicraft.zeus.smite") || p.hasPermission("demicraft.jupiter.smite")) {

					p.getInventory().getItemInMainHand().setItemMeta(meta1);
					p.getWorld().playEffect(e.getPlayer().getLocation(), Effect.SMOKE, 10);
					e.getPlayer().getWorld().strikeLightning(e.getPlayer().getTargetBlock((Set<Material>) null, 150).getLocation());
					cooldownz.add(p);
					// Cooldown
					Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
						public void run(){
							cooldownz.remove(p);
						}
					}, 100);



				} 
			} else if(p.getInventory().getItemInMainHand().isSimilar(zeusuc)) {

				if(p.hasPermission("demicraft.zeus.smite") || p.hasPermission("demicraft.jupiter.smite")) {
					p.getInventory().getItemInMainHand().setItemMeta(meta);
				} 
			}
		}
	}

	@EventHandler
	public void onConsume(PlayerItemConsumeEvent e) 
	{
		Player p = (Player) e.getPlayer();

		if(e.getItem().getType() == Material.ROTTEN_FLESH) 
		{
			if(p.hasPermission("demicraft.hades.rottenflesh") || p.hasPermission("demicraft.pluto.rottenflesh")) 
			{

				p.removePotionEffect(PotionEffectType.HUNGER);
				p.setSaturation(2);
				p.setFoodLevel(p.getFoodLevel() + 2);
				p.getInventory().getItemInMainHand().setAmount(p.getInventory().getItemInMainHand().getAmount() - 1);
				p.updateInventory();;
				e.setCancelled(true);

			}
		}
	}

	@EventHandler
	public void onPlayerMove(final PlayerMoveEvent event) {

		final Player p = (Player) event.getPlayer();
		if(p.hasPermission("demicraft.poseidon") || p.hasPermission("demicraft.neptune")) {
			p.addPotionEffect(new PotionEffect(PotionEffectType.CONDUIT_POWER, 8000000, 1), true);
		}
	}

	 @EventHandler(priority = EventPriority.HIGHEST)
	 public void NoTarget(EntityTargetEvent event) {
	        if (event.getEntityType().equals(EntityType.BLAZE)
	                        || (event.getEntityType().equals(EntityType.ENDERMAN)
	                        || (event.getEntityType().equals(EntityType.GHAST)
	                        || (event.getEntityType().equals(EntityType.MAGMA_CUBE)
	                        || (event.getEntityType().equals(EntityType.PIG_ZOMBIE)
	                        || (event.getEntityType().equals(EntityType.SKELETON)
	                        || (event.getEntityType().equals(EntityType.ZOMBIE)))))))) {
	        if (event.getTarget() instanceof Player) {
	            	if (event.getTarget().hasPermission("demicraft.hades.notarget") || event.getTarget().hasPermission("demicraft.pluto.notarget"))
	                    event.setCancelled(true);
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

		ItemStack zeusGUI = new ItemStack (Material.GOLDEN_SWORD);
		ItemMeta zeusGUIMeta = zeusGUI.getItemMeta();
		zeusGUIMeta.setDisplayName(ChatColor.GOLD + "Zeus");
		zeusGUI.setItemMeta(zeusGUIMeta);
		
		ItemStack posGUI = new ItemStack (Material.TRIDENT);
		ItemMeta posGUIMeta = posGUI.getItemMeta();
		posGUIMeta.setDisplayName(ChatColor.AQUA + "Poseidon");
		posGUI.setItemMeta(posGUIMeta);
		
		ItemStack hadesGUI = new ItemStack (Material.GOLDEN_SHOVEL);
		ItemMeta hadesGUIMeta = hadesGUI.getItemMeta();
		hadesGUIMeta.setDisplayName(ChatColor.RED + "Hades");
		hadesGUI.setItemMeta(hadesGUIMeta);



		ItemStack Spacer = new ItemStack(Material.PAPER);
		ItemMeta SpacerMeta = Spacer.getItemMeta();
		SpacerMeta.setDisplayName(" ");
		Spacer.setItemMeta(SpacerMeta);

		inv.setItem(0, zeusGUI);
		inv.setItem(1, posGUI);
		inv.setItem(2, hadesGUI);
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

		ItemStack zeusGUI = new ItemStack (Material.GOLDEN_SWORD);
		ItemMeta zeusGUIMeta = zeusGUI.getItemMeta();
		zeusGUIMeta.setDisplayName(ChatColor.GOLD + "Jupiter");
		zeusGUI.setItemMeta(zeusGUIMeta);
		
		ItemStack nepGUI = new ItemStack (Material.TRIDENT);
		ItemMeta nepGUIMeta = nepGUI.getItemMeta();
		nepGUIMeta.setDisplayName(ChatColor.AQUA + "Neptune");
		nepGUI.setItemMeta(nepGUIMeta);
		
		ItemStack plutGUI = new ItemStack (Material.GOLDEN_SHOVEL);
		ItemMeta plutGUIMeta = plutGUI.getItemMeta();
		plutGUIMeta.setDisplayName(ChatColor.RED + "Pluto");
		plutGUI.setItemMeta(plutGUIMeta);



		ItemStack Spacer = new ItemStack(Material.PAPER);
		ItemMeta SpacerMeta = Spacer.getItemMeta();
		SpacerMeta.setDisplayName(" ");
		Spacer.setItemMeta(SpacerMeta);

		inv.setItem(0, zeusGUI);
		inv.setItem(1, nepGUI);
		inv.setItem(2, plutGUI);
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
		
		PermissionUser puser = PermissionsEx.getUser(p);


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
				case GOLDEN_SWORD:
					e.setCancelled(true);
					p.sendMessage(String.format("%sYou have chosen %sZeus%s!", ChatColor.RED, ChatColor.GOLD, ChatColor.RED));
					puser.addGroup(ZeusRankName);
					p.closeInventory();
				case TRIDENT:
					e.setCancelled(true);
					p.sendMessage(String.format("%sYou have chosen %Poseidon%s!", ChatColor.RED, ChatColor.AQUA, ChatColor.RED));
					puser.addGroup(PoseidonRankName);
					p.closeInventory();
					break;
				case GOLDEN_SHOVEL:
					e.setCancelled(true);
					p.sendMessage(String.format("%sYou have chosen %Hades%s!", ChatColor.RED, ChatColor.DARK_RED, ChatColor.RED));
					puser.addGroup(HadesRankName);
					p.closeInventory();
					break;
				default:
					e.setCancelled(true);
					p.closeInventory();
					break;
				}
				return;
			} else if(ChatColor.stripColor(e.getInventory().getName()).equalsIgnoreCase("Roman")) {
				switch(e.getCurrentItem().getType()){
				case GOLDEN_SWORD:
					e.setCancelled(true);
					p.sendMessage(String.format("%sYou have chosen %sJupiter%s!", ChatColor.AQUA, ChatColor.RED, ChatColor.AQUA));
					puser.addGroup(JupiterRankName);
					p.closeInventory();					
					break;
				case TRIDENT:
					e.setCancelled(true);
					p.sendMessage(String.format("%sYou have chosen %Neptune%s!", ChatColor.RED, ChatColor.AQUA, ChatColor.RED));
					puser.addGroup(NeptuneRankName);
					p.closeInventory();
					break;
				case GOLDEN_SHOVEL:
					e.setCancelled(true);
					p.sendMessage(String.format("%sYou have chosen %Pluto%s!", ChatColor.RED, ChatColor.DARK_RED, ChatColor.RED));
					puser.addGroup(PlutoRankName);
					p.closeInventory();
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
		e.setDeathMessage(ChatColor.GOLD + "Player " + ChatColor.GOLD + p.getDisplayName() + ChatColor.GOLD + " was killed by " + ChatColor.GOLD + p.getKiller().getDisplayName() + ChatColor.GOLD + " using " + ChatColor.GOLD + p.getKiller().getInventory().getItemInMainHand().getType().toString().toLowerCase() + ChatColor.GOLD + "!");
	}
    
	public void noPermission(Player player){
		player.sendMessage(ChatColor.RED + "The gods have not granted you permission to preform this command.");
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
