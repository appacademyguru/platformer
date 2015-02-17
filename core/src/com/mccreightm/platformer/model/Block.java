package com.mccreightm.platformer.model;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.mccreightm.platformer.controller.LevelController;

public class Block extends Sprite{
    public Block(Vector2 position, int width, int height, String sheetPath) {
        super(position, width, height, sheetPath);

        BodyDef bodyDefinition = new BodyDef();
        bodyDefinition.type = BodyDef.BodyType.DynamicBody;
        bodyDefinition.position.set(position);

        physicsBody = LevelController.gameWorld.createBody(bodyDefinition);//assign the body defs to the player
        physicsBody.setUserData(this);//attach this class to the block

        PolygonShape rectangleShape = new PolygonShape();
        rectangleShape.setAsBox(this.width/2f, this.height/2f, new Vector2(this.width/2f, this.height/2f), 0f);//defines rectangle

        FixtureDef fixtureDefinition = new FixtureDef();
        fixtureDefinition.shape = rectangleShape;//makes the shape

        physicsBody.createFixture(fixtureDefinition);
        rectangleShape.dispose();//deletes the shape
        animations.put("idle", spriteSheet.createAnimation(1, 1, 0.25f));
        currentAnimation = "idle";
    }

    @Override
    public void draw(Batch spriteBatch) {
        super.draw(spriteBatch);
    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);
    }
}
