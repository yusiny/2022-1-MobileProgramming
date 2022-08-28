package com.example.a2022mobileprogramming.ui.week12;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.example.a2022mobileprogramming.R;

import java.io.IOException;

public class Week12Activity extends AppCompatActivity {
    // Audio Player 관련 리소스들
    String urlAudio = "http://sites.google.com/site/ubiaccessmobile/sample_audio.amr";
    MediaPlayer player;
    int position;

    // Video Player 관련 리소스들
    VideoView videoView;
    String urlVideo = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4";
    // http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4
    // "http://sites.google.com/site/ubiaccessmobile/sample_video.mp4"

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week12);

        audioPlayer();
        videoPlayer();
        myLocation();
    }

    /* Example 1 - audio player */
    private void audioPlayer() {

        // #1. play button
        Button playButton = findViewById(R.id.week12_exam1_play_btn);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playAudio();
            }
        });

        // #2. stop button
        Button stopButton = findViewById(R.id.week12_exam1_stop_btn);
        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopAudio();
            }
        });

        // #3. pause button
        Button pauseButton = findViewById(R.id.week12_exam1_pause_btn);
        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pauseAudio();
            }
        });

        // #4. restart button
        Button restartButton = findViewById(R.id.week12_exam1_restart_btn);
        restartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                restartAudio();
            }
        });
    }

    private void playAudio() {
        showToast("음악 파일 재생 호출됨");

        // 여러 번 시도하거나, 기존에 동작하고 있는 player 있다면 리소스 해제
        killPlayer();

        player = new MediaPlayer();
        try {
            player.setDataSource(urlAudio); // 소스 불러오기
            Log.d("WEEK12", "player data는 받음 ");
            player.prepare();          // 파일이 정상적인지 확인하기
            Log.d("WEEK12", "player prepare");
            player.start();            // 재생하기

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void stopAudio() {
        showToast("음악 파일 재생 중지됨");

        if (player != null) {
            try {
                player.stop();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void pauseAudio() {
        showToast("음악 파일 재생 일시 중지됨");

        if (player != null) {
            try {
                position = player.getCurrentPosition(); // 일시정지 위치 저장
                player.pause();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void restartAudio() {
        showToast("음악 파일 재생이 다시 시작됨");

        if (player != null && !player.isPlaying()) {
            try {
                player.start();
                player.seekTo(position);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* Example 2 - video player */
    private void videoPlayer() {
        videoView = findViewById(R.id.week12_video_view);

        MediaController mc = new MediaController(this);
        videoView.setMediaController(mc);

        Button button = findViewById(R.id.week12_video_play_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playVideo();
            }
        });
    }

    private void playVideo() {
        Uri videoUri= Uri.parse("http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4");
        videoView.setVideoURI(videoUri);

        //Log.d("video", "videoView.setVideoURI(Uri.parse(urlVideo));");
        //videoView.requestFocus();
       // Log.d("video", "equestFocus();");
        //videoView.start();
        //Log.d("video", "();");

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                showToast("비디오가 준비됨 ");
                //비디오 시작
                videoView.start();
            }
        });

        videoView.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer mediaPlayer, int i, int i1) {
                showToast("에러");
                return false;
            }
        });

        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                showToast("에러");
            }
        });
    }

    /* Example 3 - Location Service */
    private void myLocation() {
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);

        Button button = findViewById(R.id.week12_mylocation_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startLocationService();
            }
        });
    }

    private void startLocationService() {
        LocationManager manager = (LocationManager) getSystemService(LOCATION_SERVICE);

        try{
            GPSListener gpsListener = new GPSListener();
            long minTime = 10000;
            float minDistance = 0;

            manager.requestLocationUpdates(LocationManager.GPS_PROVIDER, minTime, minDistance, gpsListener);

            showToast("내 위치 확인 요청");
        }catch (SecurityException e){
            e.printStackTrace();
        }

    }

    class GPSListener implements LocationListener {

        @Override // Provider의 state가 바뀌었을 때
        public void onStatusChanged(String provider, int status, Bundle extras) {
            LocationListener.super.onStatusChanged(provider, status, extras);
        }

        @Override // 위치 정보가 바뀌었을 때 -> 우리는 이거 사용!
        public void onLocationChanged(@NonNull Location location) {
            Double latitude = location.getLatitude();
            Double longitude = location.getLongitude();

            String message = "위치: " + "\n위도: " + latitude + "\n경도: " + longitude;
            TextView textView = findViewById(R.id.week12_mylocation_tv);
            textView.setText(message);
        }

        @Override // Provider를 enable
        public void onProviderEnabled(@NonNull String provider) {
            LocationListener.super.onProviderEnabled(provider);
        }

        @Override // Provider를 disable
        public void onProviderDisabled(@NonNull String provider) {
            LocationListener.super.onProviderDisabled(provider);
        }

    }


    /* Util */
    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        ;
    }

    private void killPlayer() {
        if (player != null) {
            try {
                player.release();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
