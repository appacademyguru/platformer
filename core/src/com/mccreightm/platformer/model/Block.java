package com.mccreightm.platformer.model;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.mccreightm.platformer.controller.LevelController;

public class Block extends Sprite{
    public Block() {
        
        animations.put("block", spriteSheet.createAnimation(0, 1, 0.3f));
        currentAnimation = "block";
    }
}
