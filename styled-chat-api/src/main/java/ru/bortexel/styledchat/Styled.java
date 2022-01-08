package ru.bortexel.styledchat;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.JoinConfiguration;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.minimessage.Template;

public class Styled {
    private static IStyleConfigProvider config() {
        return StyledChat.getInstance().getStyleProvider();
    }

    public static Component message(MessageType type, Component... parts) {
        String style = StyledChat.getInstance().getStyleProvider().getMessageWrapper(type);
        Template template = Template.of("message", text(parts));
        return MiniMessage.get().parse(style, template);
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
        Template nameTemplate = Template.of("command", name);
        Template argsTemplate = Template.of("args", String.join(" ", args));
        return config().wrapString("command", nameTemplate, argsTemplate);
    }
}
