package com.ffierce.usefulplugins;

import org.bukkit.plugin.java.JavaPlugin;

public class UsefulPlugins extends JavaPlugin {

    @Override
    public void onEnable() {
        this.getCommand("install").setExecutor(new InstallCommandExecutor(this));
        this.getCommand("plist").setExecutor(new PluginListCommandExecutor());
        this.getCommand("pinfo").setExecutor(new PluginInfoCommandExecutor(this));
    }

    @Override
    public void onDisable() {
    }
}
