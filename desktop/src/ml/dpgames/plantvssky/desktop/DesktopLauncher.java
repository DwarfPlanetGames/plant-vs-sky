package ml.dpgames.plantvssky.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import ml.dpgames.plantvssky.MyGdxGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		int scale = 4;
		config.width = 1440 / scale;
		config.height = 2560 / scale;
        config.resizable = false;
		new LwjglApplication(new MyGdxGame(), config);
	}
}
