package com.mygdx.game.entitity;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.SpaceInvader;
import com.mygdx.game.TextureManager;

/**
 * Created by lavacake on 3/26/2015.
 */
public class Enemy extends Entity {
    public Enemy(Vector2 pos, Vector2 direction) {
        super(TextureManager.ENEMY, pos, direction);
    }

    @Override
    public void update() {
        pos.add(direction);
        if(pos.y <= -TextureManager.ENEMY.getHeight()) {
            float x = MathUtils.random(0, SpaceInvader.WIDTH - TextureManager.ENEMY.getWidth());
            pos.set(x, SpaceInvader.HEIGHT);
        }
    }
}