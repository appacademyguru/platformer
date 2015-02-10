package com.mccreightm.platformer.model;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.mccreightm.platformer.controller.LevelController;

import java.util.HashMap;

public class Sprite {
    public Body physicsBody;
    public Vector2 position;//position of sprite

    public Spritesheet spriteSheet;
    public String currentAnimation;//animation key

    public float width;
    public float height;

    private float stateTime;
    protected HashMap<String, Animation> animations;
    public String direction;

    public Sprite(Vector2 position, int width, int height, String sheetPath){
        //set sprite init position and connect spritesheet
        this.position = position;
        animations = new HashMap<String, Animation>();
        this.width = width * (LevelController.UNIT_SCALE);
        this.height = height * (LevelController.UNIT_SCALE);
        spriteSheet = new Spritesheet(sheetPath, width, height);//create spriteSheet object
        stateTime = 0f; //initialize stateTime
        direction = "right";
    }

    public void draw(Batch spriteBatch){
        //draw sprite on screen
        spriteBatch.draw(animations.get(currentAnimation).getKeyFrame(stateTime, true), position.x, position.y, width, height);//animate sprite
    }
    public void update(float deltaTime){
        stateTime += deltaTime;
    }
}
