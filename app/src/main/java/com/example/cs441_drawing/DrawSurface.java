package com.example.cs441_drawing;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceView;
import android.view.SurfaceHolder;

public class DrawSurface extends SurfaceView implements SurfaceHolder.Callback {
    public SurfaceHolder surfaceHolder = null;
    private Paint paint = null;
    private float[] b = {0, 0, 0};
    private float[] m = {0, 0, 0};
    private int[] colors = {Color.RED, Color.BLUE, Color.GREEN};
    private float d;

    public DrawSurface(Context context) {
        super(context);
        paint = new Paint();
    }
    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {

    }
    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        paint = null;

    }

    /* This method will be invoked to draw a circle in canvas. */
    public void draw()
    {
        surfaceHolder = getHolder();
        // Get and lock canvas object from surfaceHolder.
        Canvas canvas = surfaceHolder.lockCanvas();
        Paint surfaceBackground = new Paint();
        // Set the surfaceview background color
        surfaceBackground.setColor(Color.BLACK);
        // Draw the surfaceview background color.
        canvas.drawRect(0, 0, this.getWidth(), this.getHeight(), surfaceBackground);
        // Draw the line.
        d = (float)Math.sqrt(Math.pow(this.getHeight()*2, 2) + Math.pow(this.getWidth()*2, 2));
        for(int i=0; i<m.length; i++) {
            paint.setColor(colors[i]);
            float startX = (float) ((this.getWidth() / 2) - d + (d - Math.cos(m[i]) * d));
            float startY = (float) (b[i] - d + (d - Math.sin(m[i]) * d));
            float stopX = (float) ((this.getWidth() / 2) + d - (d - Math.cos(m[i]) * d));
            float stopY = (float) (b[i] + d - (d - Math.sin(m[i]) * d));
            canvas.drawLine(startX, startY, stopX, stopY, paint);
        }
        // Unlock the canvas object and post the new draw.
        surfaceHolder.unlockCanvasAndPost(canvas);
    }


    public void setM(float m, int index) {
        this.m[index] = (float)(Math.PI*m / 100);
    }
    public void setB(float b, int index) {
        this.b[index] = b * this.getHeight() / 100;
    }

    public float getM(int index) {
        return this.m[index];
    }

    public float getB(int index) {
        return this.b[index];
    }
}
