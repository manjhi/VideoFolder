package com.example.videofolder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.VideoView;

public class PlayVideo extends AppCompatActivity {

    String videodata;
    VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_video);
        videoView=findViewById(R.id.video);
        videodata=getIntent().getStringExtra("video");
        videoView.setVideoPath(videodata);
        videoView.start();
    }
}
