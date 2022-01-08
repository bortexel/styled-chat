package ru.bortexel.styledchat;

public final class StyledChat {
    private static StyledChat instance;
    private IStyleConfigProvider styleProvider;

    public StyledChat() {
        this.styleProvider = new DefaultStyleConfigProvider();
    }

    public StyledChat(IStyleConfigProvider styleProvider) {
        this.styleProvider = styleProvider;
    }

    public static StyledChat getInstance() {
        return instance;
    }

    public static void init(IStyleConfigProvider styleProvider) {
        instance = new StyledChat(styleProvider);
    }

    public void setStyleProvider(IStyleConfigProvider styleProvider) {
        this.styleProvider = styleProvider;
    }

    public IStyleConfigProvider getStyleProvider() {
        return styleProvider;
    }
}
