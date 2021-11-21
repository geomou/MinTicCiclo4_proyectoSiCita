package com.example.sicita.view;

import android.app.Activity;
import android.os.Bundle;
import android.widget.VideoView;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

import com.example.sicita.R;
import com.example.sicita.view.Principal;

public class Splash2 extends Activity implements OnCompletionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash2);
        VideoView video = (VideoView) findViewById(R.id.videoView2);
        video.setVideoPath("android.resource://com.agileone/raw/" + R.raw.splash_sicita);
        video.start();
        video.setOnCompletionListener(this);
    }
    @Override
    public void onCompletion(MediaPlayer mp)
    {
        Intent intent = new Intent(this, Principal.class);
        startActivity(intent);
        finish();
    }
}