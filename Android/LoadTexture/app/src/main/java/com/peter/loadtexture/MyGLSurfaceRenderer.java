package com.peter.loadtexture;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;

import com.peter.loadlib.LoadTexture2D;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * Created by peter on 15/12/2016.
 */

public class MyGLSurfaceRenderer implements GLSurfaceView.Renderer{
    Square square;
    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        GLES20.glClearColor(0.0f,0.0f,0.0f,1.0f);
        square = new Square();
        LoadTexture2D imageLoader = new LoadTexture2D();
        imageLoader.loadImageReturnTexturePtr("/storage/sdcard/cursor.png");
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {

    }

    @Override
    public void onDrawFrame(GL10 gl) {

        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT);
        square.draw();
    }
}
