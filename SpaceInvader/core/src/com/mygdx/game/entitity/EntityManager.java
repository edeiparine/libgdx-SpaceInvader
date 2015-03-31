package com.mygdx.game.entitity;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.SpaceInvader;
import com.mygdx.game.TextureManager;
import com.mygdx.game.camera.OrthoCamera;
import com.mygdx.game.screen.GameOverScreen;
import com.mygdx.game.screen.ScreenManager;

public class EntityManager {

    private final Array<Entity> entities = new Array<Entity>();
    private Player player;

    public EntityManager(OrthoCamera camera) {

        player = new Player(new Vector2(230, 10), new Vector2(0, 0), this, camera);

        boolean spawnEnemies = true;
        boolean respawnEnemies = false;

        int numberOfEnemies = 0;
        while (spawnEnemies) {
            float x = MathUtils.random(0, SpaceInvader.WIDTH - TextureManager.ENEMY.getWidth());
            float y = MathUtils.random(SpaceInvader.HEIGHT, SpaceInvader.HEIGHT * 3);
            float speed = MathUtils.random(2, 5);
            addEntity(new Enemy(new Vector2(x, y), new Vector2(0, -speed)));

            numberOfEnemies++;
            if (numberOfEnemies == 1) {
//            for (int i = 0; i < spawnEnemies; i++) {
                System.out.println(numberOfEnemies + " number of total enemies spawned");
                spawnEnemies = false;
            }
        }
    }

    public void update() {
        for (Entity e : entities) {
            e.update();
        }

        for (Missile m : getMissile()) {
            if (m.checkEnd()) {
                entities.removeValue(m, false);
            }
        }

        player.update();
        checkCollisions();
    }

    public void render(SpriteBatch sb) {
        for (Entity e : entities) {
            e.render(sb);
        }
        player.render(sb);
    }

    private void checkCollisions() {
        for (Enemy e : getEnemies()) {
            for (Missile m : getMissile()) {
                if (e.getBounds().overlaps(m.getBounds())) {
                    entities.removeValue(e, false);
                    entities.removeValue(m, false);
                    if (gameOver()) {
                        ScreenManager.setScreen(new GameOverScreen(true));
                    }
                }
            }
            if (e.getBounds().overlaps(player.getBounds())) {
                ScreenManager.setScreen(new GameOverScreen(false));
            }
        }
    }

    public void addEntity(Entity entity) {
        entities.add(entity);
    }

    private Array<Enemy> getEnemies() {
        Array<Enemy> ret = new Array<Enemy>();
        for (Entity e : entities) {
            if (e instanceof Enemy) {
                ret.add((Enemy) e);
            }
        }
        return ret;
    }

    public boolean gameOver() {
        return getEnemies().size <= 0;
    }

    private Array<Missile> getMissile() {
        Array<Missile> ret = new Array<Missile>();
        for (Entity e : entities) {
            if (e instanceof Missile) {
                ret.add((Missile) e);
            }
        }
        return ret;
    }
}
