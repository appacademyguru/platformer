package com.mccreightm.platformer.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class Player {
    public Vector2 position;
    public Texture spriteSheet;
    public TextureRegion[] spriteFrames;

    public Player() {
        //set sprite init position and connect spritesheet
        position = new Vector2(0,0);
        spriteSheet = new Texture(Gdx.files.internal("img/aliens.png"));
        //splits sprite sheet into sprites and stores it in 2d array
        TextureRegion[][] spriteSheetFrames = TextureRegion.split(spriteSheet, 70, 100);
        //counts the amount of aliens in spritesheet
        int counter = 0;
        for(int row = 0; row < spriteSheetFrames.length; row++){
            for(int column = 0; column < spriteSheetFrames[row].length; column++){
                counter++;
            }
        }

        //assigns counter number of spaces to spriteFrames
        spriteFrames = new TextureRegion[counter];
        counter = 0;//reset counter
        for(TextureRegion[] row : spriteSheetFrames){//each row is stored in variable row
            for(TextureRegion sprite : row){//stores the alien in sprite
                spriteFrames[counter++] = sprite;//stores each alien in spriteFrames and assigns it an index
            }

        }

    }
    //draw character on screen
    public void draw(Batch spriteBatch){
        //draw sprite on screen
        spriteBatch.draw(spriteFrames[44], 0, 0, 70, 100);
    }
    //update characteristics of character
    public void update(float deltaTime){

    }
}
