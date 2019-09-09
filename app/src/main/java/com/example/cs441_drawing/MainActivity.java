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
    private Color brushColor = null;
    private LinearLayout canvasLayout = null;

    DrawSurface drawSurfaceView = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Actual code down here

        initControls();

        // Hide app title bar (FROM SAMPLE)
        getSupportActionBar().hide();

        // Make app fullscreen (FROM SAMPLE)
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        eraseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawing = false;
            }
        });

        drawButton.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              drawing = true;
          }
        });
    }

    private void initControls() {
        if(eraseButton == null)
            eraseButton = (Button)findViewById(R.id.eraseButton);
        if(drawButton == null)
            drawButton = (Button)findViewById(R.id.drawButton);
        if(canvasLayout == null)
            canvasLayout = (LinearLayout)findViewById(R.id.canvasLayout);
    }
}
