package com.mygdx.game.entitity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.TextureManager;

/**
 * Created by lavacake on 3/26/2015.
 */
public class Player extends Entity {

    public Player(Vector2 pos, Vector2 direction) {
        super(TextureManager.PLAYER, pos, direction);
    }

    @Override
    public void update() {
        pos.add(direction);

        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            setDirection(0, 300);
        } else if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            setDirection(-300, 0);
        } else if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            setDirection(0, -300);
        } else if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            setDirection(300, 0);
        } else {
            setDirection(0, 0);
        }

    }
}
