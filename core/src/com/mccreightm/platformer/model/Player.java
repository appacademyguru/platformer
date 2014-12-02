package com.mccreightm.platformer.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Player {
    public Vector2 position;
    public Texture spriteSheet;

    public Player() {
        //set sprite init position and connect spritesheet
        position = new Vector2(0,0);
        spriteSheet = new Texture(Gdx.files.internal("img/aliens.png"));
    }
}
