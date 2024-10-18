package io.bombdigger.lwjgl3;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import io.bombdigger.Main;

public class Lwjgl3Launcher {
    public static void main(String[] args) {

			String osName = System.getProperty("os.name").toLowerCase();

			if (osName.contains("windows"))
				System.setProperty("java.io.tmpdir", System.getenv("ProgramData") + "/libGDX-temp");

        createApplication();
    }

    private static Lwjgl3Application createApplication() {

        return new Lwjgl3Application(new Main(), getDefaultConfiguration());
    }

    private static Lwjgl3ApplicationConfiguration getDefaultConfiguration() {
			
        Lwjgl3ApplicationConfiguration configuration = new Lwjgl3ApplicationConfiguration();
        configuration.setTitle("BombDigger");
        configuration.useVsync(false);
        configuration.setForegroundFPS(Lwjgl3ApplicationConfiguration.getDisplayMode().refreshRate + 1);
        configuration.setWindowedMode(1920, 1080);
				configuration.setDecorated(false);
        configuration.setWindowIcon("libgdx128.png", "libgdx64.png", "libgdx32.png", "libgdx16.png");
        return configuration;
    }
}