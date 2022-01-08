package ru.bortexel.styledchat;

import net.kyori.adventure.text.Component;

public interface IStyledComponent {
    Component wrapString(String string);
    String getStyleKey();
}
