package ml.dpgames.plantvssky.levels;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.HashMap;
import java.util.Random;

import ml.dpgames.plantvssky.Maths;
import ml.dpgames.plantvssky.MyGdxGame;
import ml.dpgames.plantvssky.ScreenTitle;
import ml.dpgames.plantvssky.gameobjects.Plant;

/**
 * Created by Brandon Dyer on 5/25/16.
 */
public class LevelDirt implements Level {

    private float time;
    private final float timeTarget = 40;
    private float backTime = 0;

    public static final Texture texBackground = new Texture("level-dirt-back.png");
    public static final Texture texVignette = new Texture("vignette.png");
    public static final Texture texRock = new Texture("level-dirt-block-rock.png");
    public static final Texture texDirt = new Texture("level-dirt-block-dirt.png");

    public static final int blockScale = 4;

    public static final Random random = new Random();

    private Plant plant;

    public LevelDirt() {
        time = 0;
        plant = new Plant(0);
    }

    @Override
    public void render(SpriteBatch batch, float delta) {
        if (backTime <= 0) {
            time += delta;
        } else {
            time -= delta * 2;
            backTime -= delta * 2;
        }
        plant.update(delta);
        OrthographicCamera camera = MyGdxGame.camera;
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        {
            float yBack = -camera.viewportHeight / 2 - (time * 5) % camera.viewportHeight;
            batch.draw(texBackground, -camera.viewportWidth / 2, yBack, camera.viewportWidth, camera.viewportHeight);
            batch.draw(texBackground, -camera.viewportWidth / 2, yBack + camera.viewportHeight, camera.viewportWidth, camera.viewportHeight);
            for (int y = (int) (time * 7) * blockScale; y < (time * 7) * blockScale + camera.viewportHeight * blockScale; y++) {
                boolean[] blocks = getLayer(y).blocks;
                for (int x = 0; x < blocks.length; x++) {
                    boolean rock = !(x > 0 && x < blocks.length - 1 && (!blocks[x-1] || !blocks[x+1]));
                    if (blocks[x]) {

                        batch.draw(rock ? texRock : texDirt, (float) x / blockScale - camera.viewportWidth / 2, (float) y / blockScale - camera.viewportHeight / 2-time*7, 1f / blockScale, 1f / blockScale);
                    }
                }
            }
            batch.draw(ScreenTitle.texCredits, plant.x - 0.5f, -4, 1, 1);
            batch.draw(texVignette, -camera.viewportWidth / 2, -camera.viewportHeight / 2, camera.viewportWidth, camera.viewportHeight);
        }
        batch.end();
    }

    public void die() {
        backTime = 5f;
    }

    @Override
    public float getProgress() {
        return time / timeTarget;
    }

    @Override
    public boolean isComplete() {
        return time > timeTarget;
    }

    @Override
    public int getId() {
        return 0;
    }

    private class Layer {
        public boolean[] blocks;
        public int center;

        public Layer(boolean[] blocks, int center) {
            this.blocks = blocks;
            this.center = center;
        }
    }

    private HashMap<Integer, Layer> layers = new HashMap<Integer, Layer>();

    private Layer getLayer(int i) {
        if (i == 0) {
            return new Layer(new boolean[(int) (MyGdxGame.camera.viewportWidth * blockScale)], 5);
        }
        if (layers.containsKey(i)) {
            return layers.get(i);
        } else {
            Layer layer = generate(getLayer(i - 1));
            layers.put(i, layer);
            return layer;
        }
    }

    private Layer generate(Layer last) {
        int room = 5;
        boolean[] blocks = new boolean[last.blocks.length];
        int center = (int) Maths.clamp(last.center + random.nextInt(3) - 1, room + 1, blocks.length - room - 1);
        for (int i = 0; i < blocks.length; i++) {
            if (i < center - room || i > center + room) {
                blocks[i] = (last.blocks[i] && random.nextInt(6) != 0) || random.nextInt(6) == 0;
                if (i > 0 && blocks[i - 1])
                    blocks[i] = random.nextBoolean();
            }
        }
        return new Layer(blocks, center);
    }
}
