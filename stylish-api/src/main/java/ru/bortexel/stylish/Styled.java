package ru.bortexel.stylish;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.JoinConfiguration;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.minimessage.tag.Tag;
import net.kyori.adventure.text.minimessage.tag.resolver.TagResolver;

@SuppressWarnings("unused")
public class Styled {
    private static IStyleConfigProvider config() {
        return Stylish.getInstance().getStyleProvider();
    }

    public static Component message(MessageType type, Component... parts) {
        String style = Stylish.getInstance().getStyleProvider().getMessageWrapper(type);
        return MiniMessage.miniMessage().deserialize(style, TagResolver.builder()
                .tag("message", Tag.inserting(text(parts))).build());
    }

    public static Component text(Component... parts) {
        JoinConfiguration joinConfiguration = JoinConfiguration.builder().separator(Component.text(" ")).build();
        return Component.join(joinConfiguration, parts);
    }

    public static Component intValue(int value) {
        return config().wrapString("integer", "value", "" + value);
    }

    public static Component doubleValue(double value) {
        return config().wrapString("double", "value", "" + value);
    }

    public static Component primaryString(String string) {
        return config().wrapString("primary", "string", string);
    }

    public static Component secondaryString(String string) {
        return config().wrapString("secondary", "string", string);
    }

    public static Component command(String name, String... args) {
        return config().wrapString("command", TagResolver.builder()
                .tag("command", Tag.inserting(Component.text(name)))
                .tag("args", Tag.inserting(Component.text(String.join(" ", args))))
                .build());
    }
}
