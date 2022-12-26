package com.example.examtrial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class splash extends AppCompatActivity {

    private Timer timer;
    private ProgressBar progressBar;
    private int i = 0;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        progressBar = findViewById(R.id.progressBar);
        textView = findViewById(R.id.textView);

        progressBar.setProgress(0);
        textView.setText("");


        timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (i<100){
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            textView.setText(String.valueOf(i)+"%");
                        }
                    });

                    progressBar.setProgress(i);
                    i++;

                }else{
                    timer.cancel();
                    Intent intent = new Intent(splash.this, login.class);
                    startActivity(intent);
                    finish();
                }
            }
        },0,20);
    }
    }
