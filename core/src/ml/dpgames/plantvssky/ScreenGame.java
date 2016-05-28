package ml.dpgames.plantvssky;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import ml.dpgames.plantvssky.levels.Level;

/**
 * Created by Brandon Dyer on 5/25/16.
 */
public class ScreenGame implements Screen {

    private final Level level;

    public SpriteBatch batch;

    public ScreenGame(Level level) {
        this.level = level;
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
    }

    @Override
    public void render(float delta) {
        if (!level.isComplete()) {
            level.render(batch, delta);
        } else {
            if (ScreenLevelSelect.level < level.getId()) {
                ScreenLevelSelect.level = level.getId();
            }
            MyGdxGame.setTheScreen(new ScreenLevelSelect());
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
