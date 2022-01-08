package ru.bortexel.styledchat;

import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class DefaultStyleConfigProvider implements IStyleConfigProvider {
    @Override
    public @NotNull String getMessageWrapper(MessageType type) {
        return switch (type) {
            case SUCCESS -> "<green> <pre><message></pre>";
            case WARNING -> "<yellow> <pre><message></pre>";
            case ERROR -> "<red> <pre><message></pre>";
            default -> "<pre><message></pre>";
        };
    }

    @Override
    public Optional<String> getStyleByName(String styleName) {
        return Optional.empty();
    }
}
