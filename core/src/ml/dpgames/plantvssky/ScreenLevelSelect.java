package ml.dpgames.plantvssky;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import ml.dpgames.plantvssky.levels.Level;
import ml.dpgames.plantvssky.levels.LevelDirt;

/**
 * Created by Brandon Dyer on 5/25/16.
 */
public class ScreenLevelSelect implements Screen {

    public static Texture texBackground = new Texture("levelselect-background.png");
    public static int level = 0;

    private SpriteBatch batch;

    @Override
    public void show() {
        batch = new SpriteBatch();
    }

    @Override
    public void render(float delta) {
        OrthographicCamera camera = MyGdxGame.camera;
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        {
            batch.draw(texBackground, -camera.viewportWidth / 2, -camera.viewportHeight / 2, camera.viewportWidth, camera.viewportHeight);
        }
        batch.end();
        // TODO: Replace with real level selection
        if (Gdx.input.justTouched()) {
            MyGdxGame.setTheScreen(new ScreenGame(getLevel(level)));
        }
    }

    public static Level getLevel(int level) {
        switch (level) {
            case 0:
                return new LevelDirt();
            default:
                return new LevelDirt();
        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
