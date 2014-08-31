package com.gdx.limbo.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.gdx.limbo.LimboGame;

public class DesktopLauncher {
    public static void main (String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.title = "Limbo";
        config.width = 408;
        config.height = 272;
        new LwjglApplication(new LimboGame(), config);
    }
}