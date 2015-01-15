package com.mccreightm.platformer.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.mccreightm.platformer.controller.CameraController;
import com.mccreightm.platformer.controller.LevelController;
import com.mccreightm.platformer.controller.PlayerController;

public class GameScreen implements Screen{

//constructor
    public GameScreen() {
        CameraController.initializeController();
        LevelController.initializeController();
        PlayerController.initializeController();
    }
//draws stuff on the screen
    @Override
    public void render(float delta) {
      //background color
        //sets color of the clear
        Gdx.gl.glClearColor(0.56f, 0.66f, 0.66f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
      //background tile layer
        CameraController.update();
        LevelController.update(delta);
      //character layer
        PlayerController.update(delta);
        LevelController.draw();
    }

    @Override
    public void resize(int width, int height) {
        CameraController.resize(width, height);
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
