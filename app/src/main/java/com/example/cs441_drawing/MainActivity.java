package com.example.cs441_drawing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private SeekBar slopeBar = null;
    private SeekBar interceptBar = null;
    private TextView activeText = null;
    private TextView slopeText = null;
    private TextView bText = null;
    private DrawSurface customGraph = null;
    private int activeLine = 0;
    private int m[] = {0,0,0};
    private int b[] = {0,0,0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout layout = findViewById(R.id.customViewLayout);
        customGraph = new DrawSurface(getApplicationContext());
        layout.addView(customGraph);

        slopeBar = findViewById(R.id.mBar);
        slopeBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser) {
                // TODO Auto-generated method stub
                customGraph.setM(progress, activeLine);
                m[activeLine] = progress;
                slopeText.setText(String.format("Angle:\n%.2f", customGraph.getM(activeLine)));
                customGraph.draw();
            }
        });

        interceptBar = findViewById(R.id.bBar);
        interceptBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser) {
                // TODO Auto-generated method stub
                customGraph.setB(progress, activeLine);
                b[activeLine] = progress;
                bText.setText(String.format("Y-Intercept:\n%.2f", customGraph.getB(activeLine)));
                customGraph.draw();
            }
        });

        activeText = findViewById(R.id.activeText);
        slopeText = findViewById(R.id.slopeText);
        bText = findViewById(R.id.bText);
        Button redButton = findViewById(R.id.redButton);
        redButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               activeLine = 0;
               slopeBar.setProgress(m[activeLine]);
               interceptBar.setProgress(b[activeLine]);
               activeText.setText("Active:\nRed");
               slopeText.setText(String.format("Angle:\n%.2f", customGraph.getM(activeLine)));
               bText.setText(String.format("Y-Intercept:\n%.2f", customGraph.getB(activeLine)));

           }
        });

        Button blueButton = findViewById(R.id.blueButton);
        blueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activeLine = 1;
                slopeBar.setProgress(m[activeLine]);
                interceptBar.setProgress(b[activeLine]);
                activeText.setText("Active:\nBlue");
                slopeText.setText(String.format("Angle:\n%.2f", customGraph.getM(activeLine)));
                bText.setText(String.format("Y-Intercept:\n%.2f", customGraph.getB(activeLine)));

            }
        });

        Button greenButton = findViewById(R.id.greenButton);
        greenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activeLine = 2;
                slopeBar.setProgress(m[activeLine]);
                interceptBar.setProgress(b[activeLine]);
                activeText.setText("Active:\nGreen");
                slopeText.setText(String.format("Angle:\n%.2f", customGraph.getM(activeLine)));
                bText.setText(String.format("Y-Intercept:\n%.2f", customGraph.getB(activeLine)));
            }
        });
    }

}
