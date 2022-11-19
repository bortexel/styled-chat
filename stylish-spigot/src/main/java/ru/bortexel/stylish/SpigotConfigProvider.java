package ru.bortexel.stylish;

import org.bukkit.configuration.file.FileConfiguration;
import org.jetbrains.annotations.NotNull;

import java.util.Locale;
import java.util.Optional;

public class SpigotConfigProvider implements IStyleConfigProvider {
    private final StylishSpigot plugin;

    public SpigotConfigProvider(StylishSpigot plugin) {
        this.plugin = plugin;
    }

    @Override
    public @NotNull String getMessageWrapper(@NotNull MessageType type) {
        return this.getConfig().getString("messages." + type.name().toLowerCase(Locale.ROOT), "<message>");
    }

    @Override
    public Optional<String> getStyleByName(String styleName) {
        return Optional.ofNullable(this.getConfig().getString("styles." + styleName));
    }

    public FileConfiguration getConfig() {
        return this.plugin.getConfig();
    }
}
