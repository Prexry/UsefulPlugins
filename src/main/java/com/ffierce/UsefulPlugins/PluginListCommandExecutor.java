package com.ffierce.usefulplugins;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class PluginListCommandExecutor implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage("1. EssentialsX\n2. EssentialsXChat\n3. EssentialsXSpawn\n4. EssentialsDiscord\n5. Vault\n6. LuckPerms\n7. TAB\n8. ChestCommands");
        return true;
    }
}
