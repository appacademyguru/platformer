package com.mccreightm.platformer.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import java.sql.Time;
import java.util.HashMap;

public class Player {
    public Vector2 position;
    public Spritesheet spriteSheet;

    public int width;
    public int height;

    private float stateTime;
    private HashMap<String, Animation> animations;

    public Player() {
        //set sprite init position and connect spritesheet
        position = new Vector2(14,4);
        animations = new HashMap<String, Animation>();
        width = 70;
        height = 100;
        spriteSheet = new Spritesheet("img/aliens.png", width, height);//create spriteSheet object
        animations.put("walkRight", spriteSheet.createAnimation(53, 54, 0.3f));
        animations.put("walkLeft", spriteSheet.flipAnimation(animations.get("walkRight"), true, false));
        animations.put("swimRight", spriteSheet.createAnimation(51, 52, 0.3f));
        animations.put("swimLeft", spriteSheet.flipAnimation(animations.get("swimRight"), true, false));
        animations.put("jumpRight", spriteSheet.createAnimation(48, 49, 0.3f));
        animations.put("jumpLeft", spriteSheet.flipAnimation(animations.get("jumpRight"), true, false));
        animations.put("stand", spriteSheet.createAnimation(44, 44, 0.3f));
        animations.put("climb", spriteSheet.createAnimation(45, 46, 0.3f));
        animations.put("duck", spriteSheet.createAnimation(47, 47, 0.3f));
        stateTime = 0f; //initialize stateTime
    }
    //draw character on screen
    public void draw(Batch spriteBatch){
        //draw sprite on screen
        spriteBatch.draw(animations.get("duck").getKeyFrame(stateTime, true), position.x, position.y, 70 * (1/70f), 100 * (1/70f));//animate sprite
    }
    //update characteristics of character
    public void update(float deltaTime){
        stateTime += deltaTime;
        position.x += deltaTime;//direction of sprite movement
    }
}
