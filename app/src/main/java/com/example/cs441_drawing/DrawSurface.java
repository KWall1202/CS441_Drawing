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
    private float m, b, d;

    public DrawSurface(Context context) {
        super(context);
        paint = new Paint();
        paint.setColor(Color.RED);
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
        // Set the surfaceview background color.
        surfaceBackground.setColor(Color.BLACK);
        // Draw the surfaceview background color.
        canvas.drawRect(0, 0, this.getWidth(), this.getHeight(), surfaceBackground);

        // Draw the circle.
        paint.setColor(Color.RED);
        d = (float)Math.sqrt(Math.pow(this.getHeight()*2, 2) + Math.pow(this.getWidth()*2, 2));
        float startX = (float)((this.getWidth() / 2) - d + (d - Math.cos(m)*d));
        float startY = (float)((this.getHeight() / 2) - d + (d - Math.sin(m)*d));
        float stopX = (float)((this.getWidth() / 2) + d - (d - Math.cos(m)*d));
        float stopY = (float)((this.getHeight() / 2) + d - (d - Math.sin(m)*d));
        canvas.drawLine(startX, startY + b, stopX, stopY + b, paint);
        // Unlock the canvas object and post the new draw.
        surfaceHolder.unlockCanvasAndPost(canvas);
    }


    public void setM(float m) {
        this.m = (float)(2*Math.PI*m / 100);
    }
    public void setB(float b) {
        this.b = b * this.getHeight() / 100;
    }

}
