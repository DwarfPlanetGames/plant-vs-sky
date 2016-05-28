package ml.dpgames.plantvssky.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

import ml.dpgames.plantvssky.Maths;
import ml.dpgames.plantvssky.MyGdxGame;

/**
 * Created by Brandon Dyer on 5/25/16.
 */
public class Plant {

    public float x;
    public float y = 0;

    public Plant(float x) {
        this.x = x;
    }

    public void update(float delta) {
        float xTo;
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            xTo = MyGdxGame.getX(MyGdxGame.camera);
        } else {
            xTo = Maths.clamp(Gdx.input.getAccelerometerX(), -4, 4);
        }
        x = Maths.lerp(x, xTo, 0.01f, delta);
    }

}
