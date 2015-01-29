package com.mccreightm.platformer.controller;

import com.badlogic.gdx.math.Vector2;
import com.mccreightm.platformer.model.Player;

public class PlayerController {
    public static Player player;
    public static String movementAction;
    public static String specialAction;
    private static final float VELOCITY = 1f;
    private static final float MAX_VELOCITY = 5f;
    private static final float JUMP_VELOCITY = 1f;

    public static void initializeController(){
        //create new player object
        player = new Player(new Vector2(3,4), 70, 100, "img/aliens.png");
        movementAction = "";
        specialAction = "";
    }
    public static void update(float deltaTime){
        handleInput();
        player.update(deltaTime);
    }
    private static void handleInput(){
        Vector2 velocity = player.physicsBody.getLinearVelocity();
        Vector2 position = player.physicsBody.getPosition();

        if(Math.abs(velocity.x) > MAX_VELOCITY) {
            velocity.x = Math.signum(velocity.x) * MAX_VELOCITY;
            player.physicsBody.setLinearVelocity(velocity.x, velocity.y);
        }

        if(Math.abs(velocity.y) > MAX_VELOCITY) {
            velocity.y = Math.signum(velocity.y) * MAX_VELOCITY;
            player.physicsBody.setLinearVelocity(velocity.x, velocity.y);
        }

        if(movementAction.equalsIgnoreCase("right")){
            player.physicsBody.applyLinearImpulse(VELOCITY, 0f, position.x, position.y, true);
        }
        else if(movementAction.equalsIgnoreCase("left")){
            player.physicsBody.applyLinearImpulse(-VELOCITY, 0f, position.x, position.y, true);
        }

        if(specialAction.equalsIgnoreCase("jump")){
            player.physicsBody.applyLinearImpulse(0, JUMP_VELOCITY, position.x, position.y, true);
        }

//        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
//            player.physicsBody.applyLinearImpulse(VELOCITY, 0, position.x, position.y, true);
//        }
//
//        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
//            player.physicsBody.applyLinearImpulse(-VELOCITY, 0, position.x, position.y, true);
//        }
//
//        if(Gdx.input.isKeyPressed(Input.Keys.UP)){
//            player.physicsBody.applyLinearImpulse(0, VELOCITY, position.x, position.y, true);
//        }
//
//        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
//            player.physicsBody.applyLinearImpulse(0, -VELOCITY, position.x, position.y, true);
//        }
    }
}

