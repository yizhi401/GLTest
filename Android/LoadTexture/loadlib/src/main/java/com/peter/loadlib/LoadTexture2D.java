package com.peter.loadlib;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.util.Log;

import java.nio.ByteBuffer;

/**
 * Created by peter on 13/12/2016.
 */

public class LoadTexture2D {

    public LoadTexture2D(){}

    public int loadImageReturnTexturePtr(String imagePath){
        String LOGTAG = "mInfo";
        Log.d(LOGTAG, "loading image1: " + imagePath);

        Bitmap bitmap = BitmapFactory.decodeFile(imagePath);
        Log.d(LOGTAG, "Bitmap is: " + bitmap);

//        ByteBuffer buffer = ByteBuffer.allocate(bitmap.getByteCount());
//        bitmap.copyPixelsToBuffer(buffer);
        Log.d(LOGTAG, "read buffer finished");

        int textures[] = new int[1];
        GLES20.glGenTextures(1, textures, 0);
        int textureId = textures[0];
        Log.d(LOGTAG, "texture generated");

        GLES20.glActiveTexture(GLES20.GL_TEXTURE0);
        GLES20.glBindTexture(GLES20.GL_TEXTURE_2D, textureId);
        Log.d(LOGTAG, "texture binded");

//        GLES20.glTexImage2D(GLES20.GL_TEXTURE_2D, 0, GLES20.GL_RGBA, bitmap.getWidth(), bitmap.getHeight(), 0, GLES20.GL_RGBA, GLES20.GL_UNSIGNED_BYTE, buffer);
        Log.d(LOGTAG, "glteximage2d");

        GLES20.glTexParameteri(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_MIN_FILTER, GLES20.GL_LINEAR);
        GLES20.glTexParameteri(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_MAG_FILTER, GLES20.GL_LINEAR);
        GLES20.glTexParameteri(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_WRAP_S,
                GLES20.GL_CLAMP_TO_EDGE);
        GLES20.glTexParameteri(GLES20.GL_TEXTURE_2D, GLES20.GL_TEXTURE_WRAP_T,
                GLES20.GL_CLAMP_TO_EDGE);
//        GLES20.glBindTexture(GLES20.GL_TEXTURE_2D, 0);

        GLUtils.texImage2D(GLES20.GL_TEXTURE_2D, 0, bitmap, 0);

        Log.d(LOGTAG, "texture id returned: " + textureId);

        return textureId;
//        return bitmap;
    }
}
