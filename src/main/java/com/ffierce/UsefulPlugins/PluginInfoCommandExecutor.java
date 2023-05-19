package com.ffierce.usefulplugins;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class PluginInfoCommandExecutor implements CommandExecutor {
    private final UsefulPlugins plugin;

    public PluginInfoCommandExecutor(UsefulPlugins plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("pinfo")) {
            if (args.length > 0) {
                String pluginName = args[0];
                switch(pluginName.toLowerCase()){
                    case "vault":
                        sender.sendMessage("Vault is a permissions, chat, & economy API to give plugins easy hooks into these systems without needing to hook or depend on each individual plugin themselves.");
                        break;
                    case "luckperms":
                        sender.sendMessage("LuckPerms is a permissions plugin that includes extensive features, allowing for a high degree of configurability and customization.");
                        break;
                    case "tab":
                        sender.sendMessage("TAB is a feature-filled plugin that offers customizable player list, header/footer/clock in tab list and more.");
                        break;
                    case "chestcommands":
                        sender.sendMessage("ChestCommands is a plugin that lets you create interactive menus.");
                        break;
                    case "essentialsx":
                        sender.sendMessage("EssentialsX provides several useful tools and features for servers, including player kits, teleports, spawn setting, and more.");
                        break;
                    case "essentialsxchat":
                        sender.sendMessage("EssentialsX Chat is a feature-rich chat formatting plugin for EssentialsX.");
                        break;
                    case "essentialsxdiscord":
                        sender.sendMessage("EssentialsX Discord is a bridge between your server and Discord, synchronizing chat between both platforms.");
                        break;
                    case "essentialsxspawn":
                        sender.sendMessage("EssentialsX Spawn allows you to set and control spawn points in your server.");
                        break;
                    case "worldedit":
                        sender.sendMessage("WorldEdit is an in-game map editor with over 100 functions that makes building and fixing really fast in game.");
                        break;
                    default:
                        sender.sendMessage("Plugin not found.");
                        break;
                }
            } else {
                sender.sendMessage("Please provide a plugin name.");
            }
            return true;
        }
        return false;
    }
}
