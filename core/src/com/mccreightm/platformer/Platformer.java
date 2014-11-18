package com.mccreightm.platformer;

import com.badlogic.gdx.Game;
import com.mccreightm.platformer.view.GameScreen;

public class Platformer extends Game {
    @Override
    public void create() {
        //creates the game and sets the screen to the rendered map
        setScreen(new GameScreen());
    }
}
