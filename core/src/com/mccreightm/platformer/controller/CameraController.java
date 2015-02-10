package com.mccreightm.platformer.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.MathUtils;

public class CameraController {
    public static OrthographicCamera camera;
    public static OrthographicCamera inputCamera;

    public static float widthScale;
    public static float heightScale;


    public static void initializeController(){
        //get the width and height of the window
        float width = Gdx.graphics.getWidth();
        float height = Gdx.graphics.getHeight();
        //sets camera dimensions to maintain aspect ration
        camera = new OrthographicCamera(14f, 14f * (height / width));
        //sets the camera position to the view width and height divided by two so that the view is aligned to the bottom
        camera.position.set(camera.viewportWidth/2, camera.viewportHeight/2, 0f);
        /////////////////////////////////////////////////
        inputCamera = new OrthographicCamera(14f, 14f * (height / width));
        inputCamera.position.set(inputCamera.viewportWidth / 2f, inputCamera.viewportHeight / 2f, 0);
        inputCamera.update();
    }
    public static void update(){
        float positionY = MathUtils.clamp(PlayerController.player.position.y, inputCamera.viewportHeight / 2f, inputCamera.viewportHeight / 2f);
        float positionX = MathUtils.clamp(PlayerController.player.position.x, inputCamera.viewportWidth / 2f, inputCamera.viewportWidth);
        camera.position.set(positionX, positionY, 0);
        //sets the camera view and updates it constantly
        camera.update();
    }
    public static void resize(int width, int height) {
        //modify window size to maintain aspect ratio
        camera.viewportWidth = 14f;
        camera.viewportHeight = 14f * height/width;

        camera.update();

        inputCamera.viewportWidth = 14f;
        inputCamera.viewportHeight = 14f * height/width;
        inputCamera.position.set(inputCamera.viewportWidth / 2f, inputCamera.viewportHeight / 2f, 0);
        inputCamera.update();

        widthScale = width / inputCamera.viewportWidth * LevelController.UNIT_SCALE;
        heightScale = height / inputCamera.viewportHeight * LevelController.UNIT_SCALE;
    }
}
