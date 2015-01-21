package com.mccreightm.platformer.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.mccreightm.platformer.model.Enemy;

public class EnemyController {
        public static Enemy enemy;
        private static final float VELOCITY = 1f;
        private static final float MAX_VELOCITY = 5f;
        public static void initializeController(){
            //create new player object
            enemy = new Enemy(new Vector2(5,4), 51, 58, "img/enemy-barnacle.png");
        }
        public static void update(float deltaTime){
            enemy.update(deltaTime);
        }
    }



