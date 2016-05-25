package ml.dpgames.plantvssky.gameobjects;

import com.badlogic.gdx.Gdx;

import ml.dpgames.plantvssky.Maths;

/**
 * Created by Brandon Dyer on 5/25/16.
 */
public class Plant {

    public float x;

    public Plant(float x) {
        this.x = x;
    }

    public void update(float delta) {
        float xTo = Maths.clamp(Gdx.input.getAccelerometerX(), -4, 4);
        x = Maths.lerp(x, xTo, 0.1f, delta);
    }

}
