package com.mygdx.game.entitity;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.SpaceInvader;
import com.mygdx.game.TextureManager;

/**
 * Created by lavacake on 3/27/2015.
 */
public class Missile extends Entity {
    public Missile(Vector2 pos) {
        super(TextureManager.MISSILE, pos, new Vector2(0, 5));
    }

    @Override
    public void update() {
        pos.add(direction);
    }

    public boolean checkEnd() {
        return pos.y >= SpaceInvader.HEIGHT;
    }
}
