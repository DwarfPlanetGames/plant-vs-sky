package ml.dpgames.plantvssky.levels;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Brandon Dyer on 5/25/16.
 */
public interface Level {

    void render(SpriteBatch batch, float delta);
    float getProgress();
    boolean isComplete();

}
