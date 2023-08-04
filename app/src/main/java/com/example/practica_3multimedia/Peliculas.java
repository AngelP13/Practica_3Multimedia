package com.example.practica_3multimedia;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class Peliculas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peliculas2);

        VideoView videoView = findViewById(R.id.videoView);


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String selectedMovie = extras.getString("selectedMovie");
            int videoResource = getVideoResource(selectedMovie);
            if (videoResource != 0) {
                Uri videoUri = Uri.parse("android.resource://" + getPackageName() + "/" + videoResource);

                MediaController mediaController = new MediaController(this);
                mediaController.setAnchorView(videoView);

                videoView.setMediaController(mediaController);
                videoView.setVideoURI(videoUri);
                videoView.start();
            }
        }
    }

    private int getVideoResource(String selectedMovie) {
        switch (selectedMovie) {
            case "reyleon":
                return R.raw.reyleon;
            case "spiderman":
                return R.raw.spiderman;
            case "batman":
                return R.raw.batman;
            case "conjuro":
                return R.raw.conjuro;
            case "gear5":
                return R.raw.gear5;
            case "onepiece":
                return R.raw.onepiece;
            default:
                return 0;
        }
    }
}