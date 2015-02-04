package com.mccreightm.platformer.controller;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.mccreightm.platformer.model.Bodies;
import com.mccreightm.platformer.model.CollisionListener;
import com.mccreightm.platformer.model.Level;
import com.mccreightm.platformer.model.Player;
import com.mccreightm.platformer.model.Sprite;

public class LevelController {
    public static final float UNIT_SCALE = 1/70f;

    public static Level level;
    public static OrthogonalTiledMapRenderer renderer;
    public static Batch spriteBatch;
    public static World gameWorld;
    private static Array<Body> worldBodies;
    private static Box2DDebugRenderer debugRenderer;

    public static void initializeController(){
        level = new Level("map/level01.tmx");
        //renders map
        renderer = new OrthogonalTiledMapRenderer(level.map, UNIT_SCALE);
        gameWorld = new World(new Vector2(0, -10f), true);
        gameWorld.setContactListener(new CollisionListener());
        worldBodies = new Array<Body>();
        debugRenderer = new Box2DDebugRenderer();

        //create new spritebatch object: groups sprite sheets and textures so they can be drawn efficiently
        spriteBatch = renderer.getSpriteBatch();
        createLevelBodies();
    }
    public static void draw(){
        spriteBatch.setProjectionMatrix(CameraController.camera.combined);
        //get ready to begin drawing
        spriteBatch.begin();
        //draw the player on the screen using the spriteBatch object
        PlayerController.player.draw(spriteBatch);
        EnemyController.enemy.draw(spriteBatch);
        //stop drawing
        spriteBatch.end();
        spriteBatch.setProjectionMatrix(CameraController.inputCamera.combined);
        InputController.draw(spriteBatch);

        debugRenderer.render(gameWorld, CameraController.camera.combined);
    }
    public static void update(float deltaTime){
        renderer.setView(CameraController.camera);
        renderer.render();
        PlayerController.update(deltaTime);
        updateWorldBodies();
        gameWorld.step(1/60f, 1, 1);
    }

    private static void updateWorldBodies(){
        worldBodies.clear();
        gameWorld.getBodies(worldBodies);

        for(Body body : worldBodies){
            Sprite spriteBody = (Sprite)body.getUserData();

            if(spriteBody != null){
                spriteBody.position = body.getPosition();
            }
        }
    }
    private static void createLevelBodies(){
        MapObjects mapObjects = level.getMapObjects(level.getMapLayer("collision"));
        for(MapObject mapObject : mapObjects){
            Bodies.createBody(mapObject);
        }

        MapObjects blockObjects = level.getMapObjects(level.getMapLayer("blocks"));
        for(MapObject blockObject : blockObjects){
            Bodies.createBody(blockObject);
        }
    }

}
