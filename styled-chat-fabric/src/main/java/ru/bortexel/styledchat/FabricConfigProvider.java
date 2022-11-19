package ru.bortexel.styledchat;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.Optional;
import java.util.Properties;

public class FabricConfigProvider implements IStyleConfigProvider {
    private final Properties properties = new Properties();

    public FabricConfigProvider(File file) throws IOException {
        if (!file.exists()) return;
        FileInputStream inputStream = new FileInputStream(file);
        properties.load(inputStream);
    }

    protected Properties getProperties() {
        return properties;
    }

    @Override
    public @NotNull String getMessageWrapper(MessageType type) {
        return this.getProperties().getProperty("messages." + type.name().toLowerCase(Locale.ROOT), "<message>");
    }

    @Override
    public Optional<String> getStyleByName(String styleName) {
        return Optional.ofNullable(this.getProperties().getProperty("styles." + styleName));
    }
}
