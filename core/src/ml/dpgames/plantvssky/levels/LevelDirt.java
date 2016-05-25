package ml.dpgames.plantvssky.levels;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import ml.dpgames.plantvssky.gameobjects.Plant;

/**
 * Created by Brandon Dyer on 5/25/16.
 */
public class LevelDirt implements Level {

    private float time;
    private final float timeTarget = 40;

    private Plant plant;

    public LevelDirt() {
        time = 0;
        plant = new Plant(0);
    }

    @Override
    public void render(SpriteBatch batch, float delta) {
        time += delta;
    }

    @Override
    public float getProgress() {
        return time / timeTarget;
    }

    @Override
    public boolean isComplete() {
        return time > timeTarget;
    }
}
