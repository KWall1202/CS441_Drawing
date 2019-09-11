package com.example.cs441_drawing;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceView;
import android.view.SurfaceHolder;

import com.example.cs441_drawing.R;

public class DrawSurface extends SurfaceView implements SurfaceHolder.Callback {
    private SurfaceHolder surfaceHolder = null;
    private Paint paint = null;
    private int brushColor = 0;
    private int brushRadius = 0;
    private float circleX = 0;
    private float circleY = 0;

    public DrawSurface(Context context) {
        super(context);
        surfaceHolder = getHolder();

        paint = new Paint();
        paint.setColor(getResources().getColor(R.color.DEFAULT_COLOR));
    }

    public DrawSurface(Context context, int inkColor, int inkRadius) {
        super(context);
        surfaceHolder = getHolder();

        paint = new Paint();
        paint.setColor(getResources().getColor(R.color.DEFAULT_COLOR));
        brushColor = inkColor;
        brushRadius = inkRadius;

    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        drawBall();
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        paint = null;
    }

    public void drawBall() {
        surfaceHolder = getHolder();

        Canvas canvas = surfaceHolder.lockCanvas();

        Paint surfaceBackground = new Paint();

        surfaceBackground.setColor(Color.TRANSPARENT);

        canvas.drawRect(0,0,this.getWidth(), this.getHeight(), surfaceBackground);

        paint.setColor(brushColor);
        canvas.drawCircle(circleX, circleY, brushRadius, paint);

        //Why is this here? see if it can be removed
        canvas.drawCircle(50, 50, 200, paint);

        surfaceHolder.unlockCanvasAndPost(canvas);
    }


    public float getCircleX() {
        return circleX;
    }

    public void setCircleX(float circleX) {
        this.circleX = circleX;
    }

    public float getCircleY() {
        return circleY;
    }

    public void setCircleY(float circleY) {
        this.circleY = circleY;
    }

    public Paint getPaint() {
        return paint;
    }

    public void setPaint(Paint paint) {
        this.paint = paint;
    }

    public int getColor() {
        return brushColor;
    }

    public void setColor(int newColor) {
        brushColor = newColor;
    }

    public int getRadius() {
        return brushRadius;
    }

    public void setRadius(int radius) {
        brushRadius = radius;
    }

}
