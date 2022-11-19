package ru.bortexel.styledchat;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.minimessage.tag.Tag;
import net.kyori.adventure.text.minimessage.tag.resolver.TagResolver;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public interface IStyleConfigProvider {
    @NotNull String getMessageWrapper(MessageType type);
    Optional<String> getStyleByName(String styleName);

    default @NotNull Component wrapString(String styleName, String key, String value) {
        return wrapString(styleName, TagResolver.builder().tag(key, Tag.inserting(Component.text(value))).build());
    }

    default @NotNull Component wrapString(String styleName, TagResolver tagResolver) {
        Optional<String> wrapperOptional = this.getStyleByName(styleName);
        return wrapperOptional
                .map(wrapper -> MiniMessage.miniMessage().deserialize(wrapper, tagResolver))
                .orElseGet(() -> Component.text("<unknown>"));
    }
}
