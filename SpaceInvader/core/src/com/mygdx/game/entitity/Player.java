package com.mygdx.game.entitity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.SpaceInvader;
import com.mygdx.game.TextureManager;
import com.mygdx.game.camera.OrthoCamera;

/**
 * Created by lavacake on 3/26/2015.
 */
public class Player extends Entity {

    private final EntityManager entityManager;
    private final OrthoCamera camera;
    private long lastFire;

    public Player(Vector2 pos, Vector2 direction, EntityManager entityManager, OrthoCamera camera) {
        super(TextureManager.PLAYER, pos, direction);
        this.entityManager = entityManager;
        this.camera = camera;
    }

    @Override
    public void update() {
        pos.add(direction);

        int direction = 0;

        if (Gdx.input.isTouched()) {
            Vector2 touch = camera.unprojectCoordinates(Gdx.input.getX(), Gdx.input.getY());
            if (touch.x > SpaceInvader.WIDTH / 2) {
                direction = 2;
            } else if (touch.x < SpaceInvader.WIDTH / 2) {
                direction = 1;
            } else if (touch.y < SpaceInvader.HEIGHT / 2) {
                direction = 4;
            } else if (touch.y > SpaceInvader.HEIGHT / 2) {
                direction = 2;
            } else {
                setDirection(0, 0);

            }
        }

        if (Gdx.input.isKeyPressed(Input.Keys.W) || direction == 3) {
            setDirection(0, 300);
        } else if (Gdx.input.isKeyPressed(Input.Keys.A) || direction == 1) {
            setDirection(-300, 0);
        } else if (Gdx.input.isKeyPressed(Input.Keys.S) || direction == 4) {
            setDirection(0, -300);
        } else if (Gdx.input.isKeyPressed(Input.Keys.D) || direction == 2) {
            setDirection(300, 0);
        } else {
            setDirection(0, 0);
        }


        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
            if (System.currentTimeMillis() - lastFire >= 250) {
                entityManager.addEntity(new Missile(pos.cpy().add(44, TextureManager.PLAYER.getHeight())));
                lastFire = System.currentTimeMillis();
            }
        }
    }

}
