package com.mccreightm.platformer.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.mccreightm.platformer.model.InputControl;
import com.mccreightm.platformer.model.Spritesheet;

import java.util.ArrayList;

public class InputController {
    private static Spritesheet spriteSheet;
    private static ArrayList<InputControl> inputControls;
    private static InputControl left;
    private static InputControl right;
    private static InputControl jump;


    public static void initializeController(){
        spriteSheet = new Spritesheet("img/touch-controls.png", 80, 80);
        inputControls = new ArrayList<InputControl>();
        left = new InputControl(new Vector2(0,0), spriteSheet.spriteFrames[0], "left");
        right = new InputControl(new Vector2(13,0), spriteSheet.spriteFrames[1], "right");
        jump = new InputControl(new Vector2(13,2), spriteSheet.spriteFrames[12], "jump");
        inputControls.add(left);
        inputControls.add(right);
        inputControls.add(jump);
        Gdx.input.setInputProcessor(createInputAdapter());
    }
    public static void draw(Batch spriteBatch){
        spriteBatch.begin();
        for(InputControl inputControl : inputControls){
            inputControl.draw(spriteBatch);
        }
        spriteBatch.end();
    }
    private static InputAdapter createInputAdapter(){
        return new InputAdapter(){
            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                screenY = Gdx.graphics.getHeight() - screenY;
                for(InputControl inputControl : inputControls) {
                    if (inputControl.getBoundingBox().contains(screenX,screenY)){
                        if(inputControl.action.equalsIgnoreCase("right")) {
                            PlayerController.movementAction = "right";
                        }
                        else if(inputControl.action.equalsIgnoreCase("left")) {
                            PlayerController.movementAction = "left";
                        }
                        else if(inputControl.action.equalsIgnoreCase("jump")) {
                            PlayerController.specialAction = "jump";
                        }
                    }
                }
                return true;
            }

            @Override
            public boolean touchUp(int screenX, int screenY, int pointer, int button) {
                for(InputControl inputControl : inputControls) {
                    if (inputControl.getBoundingBox().contains(screenX,screenY)){
                        if(inputControl.action.equalsIgnoreCase("right")) {
                            PlayerController.movementAction = "";
                        }
                        else if(inputControl.action.equalsIgnoreCase("left")) {
                            PlayerController.movementAction = "";
                        }
                        else if(inputControl.action.equalsIgnoreCase("jump")) {
                            PlayerController.specialAction = "";
                        }
                    }
                }
                return true;
            }

            @Override
            public boolean keyDown(int keycode) {
                if(keycode == Input.Keys.RIGHT){
                    PlayerController.movementAction = "right";
                }
                else if(keycode == Input.Keys.LEFT){
                    PlayerController.movementAction = "left";
                }
                else if(keycode == Input.Keys.SPACE){
                    PlayerController.specialAction = "jump";
                }
                return true;
            }

            @Override
            public boolean keyUp(int keycode) {
                if(keycode == Input.Keys.RIGHT){
                    PlayerController.movementAction = "";
                }
                else if(keycode == Input.Keys.LEFT){
                    PlayerController.movementAction = "";
                }
                else if(keycode == Input.Keys.SPACE){
                    PlayerController.specialAction = "";
                }
                return true;
            }
        };
    }
}
