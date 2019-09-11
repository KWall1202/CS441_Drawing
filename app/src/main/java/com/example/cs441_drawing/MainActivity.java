package com.example.cs441_drawing;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    private Button eraseButton = null;
    private Button drawButton = null;
    private boolean drawing = true;
    private int brushSize = 25;
    private int brushColor = 0;
    private LinearLayout canvasLayout = null;

    DrawSurface drawSurfaceView = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("CS441_Drawing");
        // Actual code down here

        initControls();

        // Hide app title bar (FROM SAMPLE)
        getSupportActionBar().hide();

        // Make app fullscreen (FROM SAMPLE)
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        drawSurfaceView = new DrawSurface(getApplicationContext());

        drawSurfaceView.setOnTouchListener((View.OnTouchListener) this);

        canvasLayout.addView(drawSurfaceView);

        eraseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawing = false;
                drawSurfaceView.setColor(Color.TRANSPARENT);
            }
        });

        drawButton.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              drawing = true;
              drawSurfaceView.setColor(brushColor);
          }
        });
    }

    private void initControls() {
        if(eraseButton == null)
            eraseButton = findViewById(R.id.eraseButton);
        if(drawButton == null)
            drawButton = findViewById(R.id.drawButton);
        if(canvasLayout == null)
            canvasLayout = findViewById(R.id.canvasLayout);
    }
}
