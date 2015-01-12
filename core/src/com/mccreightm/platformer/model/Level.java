package com.mccreightm.platformer.model;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

public class Level {
    public TiledMap map;

    public Level(String mapPath){
        //loads map
        map = new TmxMapLoader().load(mapPath);
    }
}
