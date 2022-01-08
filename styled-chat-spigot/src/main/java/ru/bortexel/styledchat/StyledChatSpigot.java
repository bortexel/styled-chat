package ru.bortexel.styledchat;

import org.bukkit.plugin.java.JavaPlugin;

public final class StyledChatSpigot extends JavaPlugin {
    @Override
    public void onEnable() {
        StyledChat.init(new SpigotConfigProvider(this));
    }
}
