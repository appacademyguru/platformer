package com.mccreightm.platformer.controller;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;

public class LevelController {
    public static TiledMap map;
    public static OrthogonalTiledMapRenderer renderer;
    public static Batch spriteBatch;
    public static World gameWorld;
    private static Box2DDebugRenderer debugRenderer;

    public static void initializeController(){
        //loads map
        map = new TmxMapLoader().load("map/level01.tmx");
        //renders map
        renderer = new OrthogonalTiledMapRenderer(map, 1/70f);
        gameWorld = new World(new Vector2(0, -9.8f), true);
        debugRenderer = new Box2DDebugRenderer();

        //create new spritebatch object: groups sprite sheets and textures so they can be drawn efficiently
        spriteBatch = renderer.getSpriteBatch();
    }
    public static void draw(){
        //get ready to begin drawing
        spriteBatch.begin();
        //draw the player on the screen using the spriteBatch object
        PlayerController.player.draw(spriteBatch);
        //stop drawing
        spriteBatch.end();

        debugRenderer.render(gameWorld, CameraController.camera.combined);
    }
    public static void update(){
        renderer.setView(CameraController.camera);
        renderer.render();
    }

}
