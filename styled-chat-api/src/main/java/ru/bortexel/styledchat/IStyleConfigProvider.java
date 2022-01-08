package ru.bortexel.styledchat;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.JoinConfiguration;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.minimessage.Template;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface IStyleConfigProvider {
    @NotNull String getMessageWrapper(MessageType type);
    Optional<String> getStyleByName(String styleName);

    default @NotNull Component wrapString(String styleName, String key, String string) {
        return wrapString(styleName, Template.of(key, string));
    }

    default @NotNull Component wrapString(String styleName, Template... templates) {
        Optional<String> wrapperOptional = this.getStyleByName(styleName);
        return wrapperOptional
                .map(wrapper -> MiniMessage.get().parse(wrapper, templates))
                .orElseGet(() -> destructTemplates(templates));
    }

    static Component destructTemplates(Template... templates) {
        List<Component> parts = new ArrayList<>();
        for (Template template : templates) {
            if (template instanceof Template.StringTemplate stringTemplate) {
                parts.add(Component.text(stringTemplate.value()));
            } else if (template instanceof Template.ComponentTemplate componentTemplate) {
                parts.add(componentTemplate.value());
            }
        }

        JoinConfiguration joinConfiguration = JoinConfiguration.builder().separator(Component.text(" ")).build();
        return Component.join(joinConfiguration, parts);
    }
}
