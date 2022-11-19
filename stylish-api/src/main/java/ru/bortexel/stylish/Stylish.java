package ru.bortexel.stylish;

public final class Stylish {
    private static Stylish instance;
    private IStyleConfigProvider styleProvider;

    public Stylish() {
        this.styleProvider = new DefaultStyleConfigProvider();
    }

    public Stylish(IStyleConfigProvider styleProvider) {
        this.styleProvider = styleProvider;
    }

    public static Stylish getInstance() {
        return instance;
    }

    public static void init(IStyleConfigProvider styleProvider) {
        instance = new Stylish(styleProvider);
    }

    public void setStyleProvider(IStyleConfigProvider styleProvider) {
        this.styleProvider = styleProvider;
    }

    public IStyleConfigProvider getStyleProvider() {
        return styleProvider;
    }
}
