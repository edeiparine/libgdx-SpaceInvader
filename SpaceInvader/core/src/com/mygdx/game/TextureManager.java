package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

/**
 * Created by lavacake on 3/26/2015.
 */
public class TextureManager {
    public static Texture PLAYER = new Texture(Gdx.files.internal("player.png"));
    public static Texture ENEMY = new Texture(Gdx.files.internal("meteor.png"));
    public static Texture MISSILE = new Texture(Gdx.files.internal("missile.png"));
}
