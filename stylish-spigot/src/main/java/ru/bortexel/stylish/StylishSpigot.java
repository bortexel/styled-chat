package ru.bortexel.stylish;

import org.bukkit.plugin.java.JavaPlugin;

public final class StylishSpigot extends JavaPlugin {
    @Override
    public void onEnable() {
        Stylish.init(new SpigotConfigProvider(this));
    }
}
