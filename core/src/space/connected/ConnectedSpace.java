package space.connected;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ConnectedSpace extends ApplicationAdapter {

	SpriteBatch batch;
    Animation player;
    float cumulativeTime = 0;
    int px = 120;
    int py = 120;

	@Override
	public void create () {
		batch = new SpriteBatch();
        player = SpriteSheet.SHIP_VARIANT_1.getAnim(16);
        player.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
	}

	@Override
	public void render() {
        float delta = 1;
        if (Gdx.graphics.getFramesPerSecond() != 0)
            delta = (float) Game.FPS/Gdx.graphics.getFramesPerSecond();
        cumulativeTime += delta*2;

		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();

        batch.draw(player.getKeyFrame(cumulativeTime), px, py, 25 * 4, 30 * 4);

        batch.end();
	}
}