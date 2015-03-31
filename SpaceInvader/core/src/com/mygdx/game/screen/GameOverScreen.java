package com.mygdx.game.screen;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.SpaceInvader;
import com.mygdx.game.TextureManager;
import com.mygdx.game.camera.OrthoCamera;

/**
 * Created by lavacake on 3/29/2015.
 */
public class GameOverScreen extends Screen {

    private OrthoCamera camera;
    private Texture texture;

    public GameOverScreen(boolean won) {
        if (won)
            texture = TextureManager.GAME_WON;
        else
            texture = TextureManager.GAME_OVER;
    }

    @Override
    public void create() {
        camera = new OrthoCamera();
        camera.resize();
    }

    @Override
    public void update() {
        camera.update();

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(camera.combined);
        sb.begin();
        sb.draw(texture, SpaceInvader.WIDTH / 2 - texture.getWidth() / 2, SpaceInvader.HEIGHT / 2 - texture.getHeight() / 2);
        sb.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void dispose() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }
}
