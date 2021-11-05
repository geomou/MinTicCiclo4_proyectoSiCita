package com.example.sicita;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.WindowManager;

import java.util.Timer;
import java.util.TimerTask;

public class Splash extends AppCompatActivity {
     private  static final long SPLASH_SCREEN_DELAY=3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //bloquear rotacion de pantalla
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        );

        //Ocultar Accion bar
        getSupportActionBar().hide();
        setContentView(R.layout.activity_splash);

        //crear temporizador
        TimerTask timetask= new TimerTask() {
            @Override
            public void run() {
                Intent  newIntent =new Intent(getApplicationContext(),Login.class);
                startActivity(newIntent);
                finish();
            }
        };
        Timer timer=new Timer();
        timer.schedule(timetask, SPLASH_SCREEN_DELAY);
    }
}