package com.mccreightm.platformer.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class CameraController {
    public static OrthographicCamera camera;

    public static void initializeController(){
        //get the width and height of the window
        float width = Gdx.graphics.getWidth();
        float height = Gdx.graphics.getHeight();
        //sets camera dimensions to maintain aspect ration
        camera = new OrthographicCamera(14f, 14f * (height / width));
        //sets the camera position to the view width and height divided by two so that the view is aligned to the bottom
        camera.position.set(camera.viewportWidth/2, camera.viewportHeight/2, 0f);
    }
    public static void update(){
        //sets the camera view and updates it constantly
        camera.update();
    }
    public static void resize(int width, int height) {
        //modify window size to maintain aspect ratio
        camera.viewportWidth = 14f;
        camera.viewportHeight = 14f * height/width;
        camera.update();
    }
}
