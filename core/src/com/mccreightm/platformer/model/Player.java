package com.mccreightm.platformer.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.mccreightm.platformer.controller.LevelController;
import com.mccreightm.platformer.view.GameScreen;

import java.sql.Time;
import java.util.HashMap;

public class Player {
    public Vector2 position;
    public Spritesheet spriteSheet;
    public String currentAnimation;//animation key

    public float width;
    public float height;

    private float stateTime;
    private HashMap<String, Animation> animations;

    public Player(int width, int height) {
        //set sprite init position and connect spritesheet
        position = new Vector2(3,4);
        animations = new HashMap<String, Animation>();
        this.width = width * (LevelController.UNIT_SCALE);
        this.height = height * (LevelController.UNIT_SCALE);
        spriteSheet = new Spritesheet("img/aliens.png", width, height);//create spriteSheet object

        animations.put("walkRight", spriteSheet.createAnimation(53, 54, 0.3f));
        animations.put("walkLeft", spriteSheet.flipAnimation(animations.get("walkRight"), true, false));
        animations.put("swimRight", spriteSheet.createAnimation(51, 52, 0.3f));
        animations.put("swimLeft", spriteSheet.flipAnimation(animations.get("swimRight"), true, false));
        animations.put("jumpRight", spriteSheet.createAnimation(49, 49, 0.3f));
        animations.put("jumpLeft", spriteSheet.flipAnimation(animations.get("jumpRight"), true, false));
        animations.put("idleRight", spriteSheet.createAnimation(50, 50, 0.3f));
        animations.put("idleLeft", spriteSheet.flipAnimation(animations.get("idleRight"), true, false));
        animations.put("climb", spriteSheet.createAnimation(45, 46, 0.3f));
        animations.put("duckRight", spriteSheet.createAnimation(47, 47, 0.3f));
        animations.put("duckLeft", spriteSheet.flipAnimation(animations.get("duckRight"), true, false));
        animations.put("hurtRight", spriteSheet.createAnimation(48, 48, 0.3f));
        animations.put("hurtLeft", spriteSheet.flipAnimation(animations.get("duckRight"), true, false));
        currentAnimation = "duckLeft";
        stateTime = 0f; //initialize stateTime

        BodyDef bodyDefinition = new BodyDef();
        bodyDefinition.type = BodyDef.BodyType.DynamicBody;
        bodyDefinition.position.set(position);
        Body playerBody = LevelController.gameWorld.createBody(bodyDefinition);//assign the body defs to the player
        playerBody.setUserData(this);//attach this class to the playerBody

        PolygonShape rectangleShape = new PolygonShape();
        rectangleShape.setAsBox(this.width/2f, this.height/2f, new Vector2(this.width/2f, this.height/2f), 0f);//defines rectangle

        FixtureDef fixtureDefinition = new FixtureDef();
        fixtureDefinition.shape = rectangleShape;//makes the shape

        playerBody.createFixture(fixtureDefinition);
        rectangleShape.dispose();//deletes the shape
    }
    //draw character on screen
    public void draw(Batch spriteBatch){
        //draw sprite on screen
        spriteBatch.draw(animations.get(currentAnimation).getKeyFrame(stateTime, true), position.x, position.y, width, height);//animate sprite
    }
    //update characteristics of character
    public void update(float deltaTime){
        stateTime += deltaTime;
    }
}
