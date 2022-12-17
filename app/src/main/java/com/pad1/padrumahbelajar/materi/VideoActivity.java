package com.pad1.padrumahbelajar.materi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.pad1.padrumahbelajar.R;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import org.w3c.dom.Text;

import java.util.Objects;

public class VideoActivity extends AppCompatActivity {

    VideoView simpleVideoView;
    TextView tv1,tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);

        // Local Video
//        simpleVideoView = findViewById(R.id.simpleVideoView);
//        MediaController mediaController = new MediaController(this);
//        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.fishvideo);
//        simpleVideoView.setVideoURI(uri);
//        simpleVideoView.setMediaController(mediaController);
//        simpleVideoView.start();

        // Online Video

        YouTubePlayerView youTubePlayerView = findViewById(R.id.youtube_player_view);
        getLifecycle().addObserver(youTubePlayerView);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MateriActivity.MESSAGE_EXTRA);

        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                if(Objects.equals(message, "sejarah")){
                    String videoId = "vGXU8Fz68Rk";
                    youTubePlayer.loadVideo(videoId, 0);
                } else if (Objects.equals(message, "matematika")){
                    String videoId = "eQv10AP5BG0";
                    youTubePlayer.loadVideo(videoId, 0);
                    tv1.setText("Matematika");
                    tv2.setText(R.string.materi_matematika);
                } else if (Objects.equals(message, "kimia")){
                    String videoId = "WAE3-XPclE4";
                    youTubePlayer.loadVideo(videoId, 0);
                    tv1.setText("Kimia");
                    tv2.setText(R.string.materi_kimia);
                } else if (Objects.equals(message, "fisika")){
                    String videoId = "4HrweW4IqJc";
                    youTubePlayer.loadVideo(videoId, 0);
                    tv1.setText("Fisika");
                    tv2.setText(R.string.materi_fisika);
                } else if (Objects.equals(message, "agama")){
                    String videoId = "SQtOHjc8QdA";
                    youTubePlayer.loadVideo(videoId, 0);
                    tv1.setText("Agama");
                    tv2.setText(R.string.materi_agama);
                }



            }
        });



    }


}