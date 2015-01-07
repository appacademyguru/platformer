package com.mccreightm.platformer.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.mccreightm.platformer.model.Player;

public class GameScreen implements Screen{
    public TiledMap map;
    public OrthogonalTiledMapRenderer renderer;
    public OrthographicCamera camera;

    public Batch spriteBatch;
    public Player player;

    public static World gameWorld;
    private Box2DDebugRenderer debugRenderer;

//constructor
    public GameScreen() {
        //loads map
        map = new TmxMapLoader().load("map/level01.tmx");
        //renders map
        renderer = new OrthogonalTiledMapRenderer(map, 1/70f);
        gameWorld = new World(new Vector2(0, -9.8f), true);
        debugRenderer = new Box2DDebugRenderer();

        //get the width and height of the window
        float width = Gdx.graphics.getWidth();
        float height = Gdx.graphics.getHeight();
        //sets camera dimensions to maintain aspect ration
        camera = new OrthographicCamera(14f, 14f * (height / width));
        //sets the camera position to the view width and height divided by two so that the view is aligned to the bottom
        camera.position.set(camera.viewportWidth/2, camera.viewportHeight/2, 0f);

        //create new spritebatch object: groups sprite sheets and textures so they can be drawn efficiently
        spriteBatch = renderer.getSpriteBatch();
        //create new player object
        player = new Player();
    }
//draws stuff on the screen
    @Override
    public void render(float delta) {
      //background color
        //sets color of the clear
        Gdx.gl.glClearColor(0.56f, 0.66f, 0.66f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
      //background tile layer
        //sets the camera view and updates it constantly
        camera.update();
        renderer.setView(camera);
        renderer.render();
      //character layer
        player.update(delta);
        //get ready to begin drawing
        spriteBatch.begin();
        //draw the player on the screen using the spriteBatch object
        player.draw(spriteBatch);
        //stop drawing
        spriteBatch.end();

        debugRenderer.render(gameWorld, camera.combined);
    }

    @Override
    public void resize(int width, int height) {
        //modify window size to maintain aspect ratio
        camera.viewportWidth = 14f;
        camera.viewportHeight = 14f * height/width;
        camera.update();
        //get ready to begin drawing
    }

    @Override
    public void show() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
