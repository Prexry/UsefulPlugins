package com.ffierce.usefulplugins;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.Map;

public class InstallCommandExecutor implements CommandExecutor {

    private final UsefulPlugins plugin;
    private final Map<String, String> plugins = new HashMap<>();

    public InstallCommandExecutor(UsefulPlugins plugin) {
        this.plugin = plugin;
        plugins.put("ChestCommands", "https://github.com/FFierce/UsefulPlugins/blob/main/plugins/ChestCommands.jar?raw=true");
        plugins.put("EssentialsX", "https://github.com/FFierce/UsefulPlugins/blob/main/plugins/EssentialsX-2.19.7.jar?raw=true");
        plugins.put("EssentialsXChat", "https://github.com/FFierce/UsefulPlugins/blob/main/plugins/EssentialsXChat-2.19.7.jar?raw=true");
        plugins.put("EssentialsXDiscord", "https://github.com/FFierce/UsefulPlugins/blob/main/plugins/EssentialsXDiscord-2.19.7.jar?raw=true");
        plugins.put("EssentialsXSpawn", "https://github.com/FFierce/UsefulPlugins/blob/main/plugins/EssentialsXSpawn-2.19.7.jar?raw=true");
        plugins.put("LuckPerms", "https://github.com/FFierce/UsefulPlugins/blob/main/plugins/LuckPerms-Bukkit-5.4.79.jar?raw=true");
        plugins.put("TAB", "https://github.com/FFierce/UsefulPlugins/blob/main/plugins/TAB v3.3.2.jar?raw=true");
        plugins.put("Vault", "https://github.com/FFierce/UsefulPlugins/blob/main/plugins/Vault.jar?raw=true");
        plugins.put("WorldEdit", "https://github.com/FFierce/UsefulPlugins/blob/main/plugins/worldedit-bukkit-7.2.14.jar?raw=true");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length > 0) {
            String pluginName = args[0];
            String pluginUrl = null;
            for (Map.Entry<String, String> entry : plugins.entrySet()) {
                if (entry.getKey().equalsIgnoreCase(pluginName)) {
                    pluginUrl = entry.getValue();
                    break;
                }
            }
            if (pluginUrl != null) {
                try {
                    downloadPlugin(pluginUrl, pluginName + ".jar");
                    sender.sendMessage("The plugin " + pluginName + " has been installed. Please restart your server.");
                } catch (Exception e) {
                    sender.sendMessage("Failed to install the plugin. Check the server console for more details.");
                    e.printStackTrace();
                }
            } else {
                sender.sendMessage("Invalid plugin name. Use /plist to get a list of available plugins.");
            }
        } else {
            sender.sendMessage("You must specify a plugin to install. Use /plist to get a list of available plugins.");
        }
        return true;
    }

private void downloadPlugin(String url, String fileName) throws IOException {
    URL pluginUrl = new URL(url);
    Path pluginPath = Paths.get(plugin.getDataFolder().getParentFile().getAbsolutePath(), fileName);
    try (BufferedInputStream in = new BufferedInputStream(pluginUrl.openStream());
         FileOutputStream fileOutputStream = new FileOutputStream(String.valueOf(pluginPath))) {
        byte dataBuffer[] = new byte[1024];
        int bytesRead;
        while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
            fileOutputStream.write(dataBuffer, 0, bytesRead);
        }
    } catch (IOException e) {
        // handle exception
        e.printStackTrace();
    }
}
}