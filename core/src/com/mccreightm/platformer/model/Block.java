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
