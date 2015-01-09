package com.mccreightm.platformer.controller;

import com.mccreightm.platformer.model.Player;

public class PlayerController {
    public static Player player;

    public static void initializeController(){
        //create new player object
        player = new Player(70, 100);
    }
    public static void update(float deltaTime){
        player.update(deltaTime);
    }
}
