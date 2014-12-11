package com.mccreightm.platformer.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import java.sql.Time;

public class Player {
    public Vector2 position;
    public Animation animation;
    public Spritesheet spriteSheet;

    public int width;
    public int height;

    private float stateTime;

    public Player() {
        //set sprite init position and connect spritesheet
        position = new Vector2(0,4);
        width = 70;
        height = 100;
        spriteSheet = new Spritesheet("img/aliens.png", width, height);//create spriteSheet object
        animation = spriteSheet.createAnimation(45, 46, 0.3f);
        stateTime = 0f; //initialize stateTime


    }
    //draw character on screen
    public void draw(Batch spriteBatch){
        //draw sprite on screen
        spriteBatch.draw(animation.getKeyFrame(stateTime, true), position.x, position.y, 70 * (1/70f), 100 * (1/70f));//animate sprite
    }
    //update characteristics of character
    public void update(float deltaTime){
        stateTime += deltaTime;
        position.y += deltaTime;//direction of sprite movement
    }
}
