package com.mccreightm.platformer.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Spritesheet {//class to handle everything to do with spritesheets
    public Texture spriteSheet;
    public TextureRegion[] spriteFrames;
    public Animation animation; //stores one animation

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

    public Animation createAnimation(){//function to animate things
        TextureRegion[] animationFrames = new TextureRegion[2];//create new texture region array to store animation frames
        animationFrames[0] = spriteFrames[45]; //stores sprite 51 in animationFrames
        animationFrames[1] = spriteFrames[46]; //stores sprite 52 in animationFrames
        animation = new Animation(0.3f, animationFrames);//create new animation
        return animation;
    }
}
