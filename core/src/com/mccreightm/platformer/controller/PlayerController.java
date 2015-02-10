package com.mccreightm.platformer.controller;

import com.badlogic.gdx.math.Vector2;
import com.mccreightm.platformer.model.Player;

public class PlayerController {
    public static Player player;
    public static String movementAction;
    public static String specialAction;
    public static boolean grounded;

    private enum State {
        Idle, Walk, Run, Swim, Duck, Stand, Jump, Climb, Hurt
    }

    private static State playerState;

    private static final float VELOCITY = 1f;
    private static final float MAX_VELOCITY = 5f;
    private static final float JUMP_VELOCITY = 12f;

    public static void initializeController(){
        //create new player object
        player = new Player(new Vector2(3,4), 70, 100, "img/aliens.png");
        movementAction = "";
        specialAction = "";
        playerState = State.Idle;
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

        if (Math.abs(velocity.y) > 0.05){

            playerState = State.Jump;

        }
        else if (Math.abs(velocity.x)>0){

            playerState = State.Walk;

        }
        else {

            playerState = State.Idle;

        }

        setCurrentAnimation();

        if(movementAction.equalsIgnoreCase("right")){
            player.physicsBody.applyLinearImpulse(VELOCITY, 0f, position.x, position.y, true);
            player.direction = "right";
        }
        else if(movementAction.equalsIgnoreCase("left")){
            player.physicsBody.applyLinearImpulse(-VELOCITY, 0f, position.x, position.y, true);
            player.direction = "left";
        }

        if(specialAction.equalsIgnoreCase("jump") && grounded) {
                player.physicsBody.applyLinearImpulse(0, JUMP_VELOCITY, position.x, position.y, true);
                player.direction = "jump";
                grounded = false;
        }

    }
    public static void setCurrentAnimation(){

        if (player.direction.equals("right")){

            setRightAnimation();

        }
        else if (player.direction.equals("left")){

            setLeftAnimation();

        }

    }

    public static void setRightAnimation(){
        if (playerState == State.Walk){
            player.currentAnimation = "walkRight";
        }
        else if (playerState == State.Jump){
            player.currentAnimation = "jumpRight";
        }
        else if (playerState == State.Duck){
            player.currentAnimation = "duckRight";
        }
        else if (playerState == State.Climb){
            player.currentAnimation = "Climb";
        }
        else if (playerState == State.Idle){
            player.currentAnimation = "idleRight";
        }
    }

    public static void setLeftAnimation(){
        if (playerState == State.Walk){
            player.currentAnimation = "walkLeft";
        }
        else if (playerState == State.Jump){
            player.currentAnimation = "jumpLeft";
        }
        else if (playerState == State.Duck){
            player.currentAnimation = "duckLeft";
        }
        else if (playerState == State.Climb){
            player.currentAnimation = "Climb";
        }
        else if (playerState == State.Idle){
            player.currentAnimation = "idleLeft";
        }
    }
}

