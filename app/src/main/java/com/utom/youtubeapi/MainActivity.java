package com.utom.youtubeapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class MainActivity extends YouTubeBaseActivity {

    //Inicia variable
    YouTubePlayerView youTubePlayerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Asignar variable
        youTubePlayerView = findViewById(R.id.youtube_player);
        //Inicializar listener
        YouTubePlayer.OnInitializedListener Listener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                //Carga video usando URL
                youTubePlayer.loadVideo("2QQUEHaeDfs");

                //Iniciar video
                youTubePlayer.play();
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Toast.makeText(getApplicationContext(), "FALLO DE INICIO", Toast.LENGTH_SHORT).show();
            }
        };
        //Iniciar reproductor
        youTubePlayerView.initialize("",Listener);
    }
}