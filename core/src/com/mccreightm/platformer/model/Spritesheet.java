package com.mccreightm.platformer.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Spritesheet {//class to handle everything to do with spritesheets
    public Texture spriteSheet;
    public TextureRegion[] spriteFrames;

    public Spritesheet(String pathToFile, int width, int height) {
        spriteSheet = new Texture(Gdx.files.internal(pathToFile));
        //splits sprite sheet into sprites and stores it in 2d array
        TextureRegion[][] spriteSheetFrames = TextureRegion.split(spriteSheet, width, height);
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

    public Animation createAnimation(int startFrame, int lastFrame, float animationSpeed){//function to animate things
        int counter = (lastFrame + 1) - startFrame;
        TextureRegion[] animationFrames = new TextureRegion[2];//create new texture region array to store animation frames

        for(int index = lastFrame; index >= startFrame; index--){
            animationFrames[--counter] = spriteFrames[index];//create the animation frames
        }

        return new Animation(animationSpeed, animationFrames);//create new animation
    }
}
