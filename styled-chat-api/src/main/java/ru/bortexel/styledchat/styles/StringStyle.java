package ru.bortexel.styledchat.styles;

import net.kyori.adventure.text.Component;
import ru.bortexel.styledchat.IStyledComponent;

public class StringStyle implements IStyledComponent {
    @Override
    public Component wrapString(String string) {
        return Component.text(string);
    }

    @Override
    public String getStyleKey() {
        return "string";
    }
}
