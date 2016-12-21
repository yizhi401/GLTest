package com.peter.loadtexture;

import android.content.Context;
import android.opengl.GLSurfaceView;

/**
 * Created by peter on 15/12/2016.
 */

public class MyGLSurfaceView extends GLSurfaceView{

    MyGLSurfaceRenderer renderer;
    public MyGLSurfaceView(Context context) {
        super(context);
        setEGLContextClientVersion(2);
        renderer = new MyGLSurfaceRenderer();
        setRenderer(renderer);

    }
}
