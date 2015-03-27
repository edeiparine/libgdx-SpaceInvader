package com.mygdx.game.entitity;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.SpaceInvader;
import com.mygdx.game.TextureManager;

/**
 * Created by lavacake on 3/26/2015.
 */
public class EntityManager {

    private final Array<Entity> entities = new Array<Entity>();
    private Player player;

    public EntityManager(int amount) {
        player = new Player(new Vector2(230, 10),new Vector2(0,0));
        for(int i = 0; i < amount; i++) {
            float x = MathUtils.random(0, SpaceInvader.WIDTH - TextureManager.ENEMY.getWidth());
            float y = MathUtils.random(SpaceInvader.HEIGHT ,SpaceInvader.HEIGHT * 3);
            float speed = MathUtils.random(2, 5);
            addEntity(new Enemy(new Vector2(x,y),new Vector2(0, -speed)));

        }
    }

    public void update() {
        for (Entity e: entities) {
            e.update();
        }

        player.update();
    }

    public void render(SpriteBatch sb) {
        for (Entity e : entities) {
            e.render(sb);
        }

        player.render(sb);
    }

    public void addEntity(Entity entity) {
        entities.add(entity);
    }
}
