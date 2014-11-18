package com.mccreightm.platformer;

import com.badlogic.gdx.Game;
import com.mccreightm.platformer.view.GameScreen;
//makes errything work
public class Platformer extends Game {
    @Override
    public void create() {
        setScreen(new GameScreen());
    }
}
