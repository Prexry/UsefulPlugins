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
                String pluginName = args[0].toLowerCase();
                switch (pluginName) {
                    case "essentialsx":
                        sender.sendMessage("EssentialsX provides the core functionality you'd expect from any Minecraft server kit, such as warp signs, spawn and home commands, and more.");
                        break;
                    case "essentialsxchat":
                        sender.sendMessage("EssentialsX Chat is a fun and unique part of EssentialsX that allows you to customize the chat formatting on your server.");
                        break;
                    case "essentialsspawn":
                        sender.sendMessage("EssentialsX Spawn is a simple plugin that allows players to spawn back to your server's spawn point.");
                        break;
                    case "essentialsdiscord":
                        sender.sendMessage("EssentialsX Discord is a bridge between Minecraft and Discord, allowing you to send messages from Minecraft to Discord and vice versa.");
                        break;
                    case "vault":
                        sender.sendMessage("Vault is a permissions, chat, & economy API to give plugins easy hooks into these systems without needing to hook or depend on each individual plugin themselves.");
                        break;
                    case "luckperms":
                        sender.sendMessage("LuckPerms is an advanced permissions plugin that allows you to manage permissions for your Minecraft server.");
                        break;
                    case "tab":
                        sender.sendMessage("TAB is a plugin that helps you customize your server's player list.");
                        break;
                    case "chestcommands":
                        sender.sendMessage("ChestCommands is a plugin that allows you to create custom GUI windows that execute commands.");
                        break;
                    default:
                        sender.sendMessage("That plugin is not recognized.");
                }
            } else {
                sender.sendMessage("Please provide a plugin name.");
            }
            return true;
        }
        return false;
    }
}
