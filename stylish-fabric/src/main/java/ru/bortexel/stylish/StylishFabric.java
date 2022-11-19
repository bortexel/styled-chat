package ru.bortexel.stylish;

import net.fabricmc.api.DedicatedServerModInitializer;
import net.fabricmc.loader.api.FabricLoader;

import java.io.File;
import java.io.IOException;

public final class StylishFabric implements DedicatedServerModInitializer {
    @Override
    public void onInitializeServer() {
        try {
            File configFile = FabricLoader.getInstance().getConfigDir().resolve("stylish.properties").toFile();
            if (configFile.exists()) Stylish.init(new FabricConfigProvider(configFile));
            else Stylish.init(new DefaultStyleConfigProvider());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
