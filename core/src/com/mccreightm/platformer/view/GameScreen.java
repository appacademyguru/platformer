package com.mccreightm.platformer.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class GameScreen implements Screen{
    public TiledMap map;
    public OrthogonalTiledMapRenderer renderer;
    public OrthographicCamera camera;
//constructor
    public GameScreen() {
        //loads map
        map = new TmxMapLoader().load("map/level01.tmx");
        //renders map
        renderer = new OrthogonalTiledMapRenderer(map, 1/70f);
        //get the width and height of the window
        float width = Gdx.graphics.getWidth();
        float height = Gdx.graphics.getHeight();
        //sets camera dimensions to maintain aspect ration
        camera = new OrthographicCamera(14f, 14f * (height / width));
        //sets the camera position to the view width and height divided by two so that the view is aligned to the bottom
        camera.position.set(camera.viewportWidth/2, camera.viewportHeight/2, 0f);
    }
//renders the thingy
    @Override
    public void render(float delta) {
        //sets color of the clear
        Gdx.gl.glClearColor(1f, 1f, 1f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        //sets the camera view and updates it constantly
        camera.update();
        renderer.setView(camera);
        renderer.render();
    }

    @Override
    public void resize(int width, int height) {
        //modify window size to maintain aspect ratio
        camera.viewportWidth = 14f;
        camera.viewportHeight = 14f * height/width;
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
