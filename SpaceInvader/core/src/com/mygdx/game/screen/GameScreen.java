package com.mygdx.game.screen;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.camera.OrthoCamera;
import com.mygdx.game.entitity.EntityManager;

public class GameScreen extends Screen  {

    private OrthoCamera camera;
    private EntityManager entityManager;

    @Override
    public void create() {
        camera = new OrthoCamera();
        entityManager = new EntityManager(15);
    }

    @Override
    public void update() {
        camera.update();
        entityManager.update();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(camera.combined);

        sb.begin();
        entityManager.render(sb);
        sb.end();
    }

    @Override
    public void resize(int width, int height) {
        camera.resize();
        System.out.println("resize");

    }

    @Override
    public void dispose() {
        System.out.println("dispose");

    }

    @Override
    public void pause() {
        System.out.println("pause");

    }

    @Override
    public void resume() {
        System.out.println("resume");
    }
}
