package ml.dpgames.plantvssky;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by Brandon Dyer on 5/25/16.
 */
public class ScreenTitle implements Screen {

    private SpriteBatch batch;

    @Override
    public void show() {
        batch = new SpriteBatch();
    }

    @Override
    public void render(float delta) {
        OrthographicCamera camera = MyGdxGame.camera;
        batch.setProjectionMatrix(camera.combined);

        Rectangle rectPlay = new Rectangle(-1, 0, 2, 1);
        Rectangle rectCredits = new Rectangle(-1, -1, 2, 1);

        float inputX = MyGdxGame.getX(camera);
        float inputY = MyGdxGame.getY(camera);

        if (rectPlay.contains(inputX, inputY)) {
            System.out.println("GOTO LEVEL SELECTION SCREEN");
            // TODO: Create game screen
        }

        if (rectCredits.contains(inputX, inputY)) {
            System.out.println("GOTO CREDITS SCREEN");
            // TODO: Create credits screen
        }

        batch.begin();
        {

        }
        batch.end();
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
