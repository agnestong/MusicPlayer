package com.ngeeann.musicplayer;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class NowPlayingActivity extends AppCompatActivity {

    Button playBtn;
    SeekBar positionBar;
    SeekBar volumeBar;
    TextView elapsedTimeLabel;
    TextView remainingTimeLabel;
    static MediaPlayer player;
    int totalTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);

        playBtn = findViewById(R.id.playBtn);
        elapsedTimeLabel = findViewById(R.id.elapsedTimeLabel);
        remainingTimeLabel = findViewById(R.id.remainingTimeLabel);


        player = MediaPlayer.create(this, R.raw.southborder);
        player.setLooping(true);
        player.seekTo(0);
        player.setVolume(0.5f,0.5f);
        totalTime = player.getDuration();


        //Position Bar
        positionBar = findViewById(R.id.positionBar);
        positionBar.setMax(totalTime);
        positionBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser){
                    player.seekTo(progress);
                    positionBar.setProgress(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //Volume Bar
        volumeBar = findViewById(R.id.volumeBar);
        volumeBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                float volumeNum = progress / 100f;
                player.setVolume(volumeNum, volumeNum);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        // Thread(Update positionBar & timeLabel)
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(player != null){
                    try{
                        Message msg = new Message();
                        msg.what = player.getCurrentPosition();
                        handler.sendMessage(msg);
                        Thread.sleep(1000);
                    }catch (InterruptedException e){}
                }

            }
        }).start();

        player.start();
        playBtn.setBackgroundResource(R.drawable.stop);
    }

    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg){
            int currentPosition = msg.what;

            // Update positionBar
            positionBar.setProgress(currentPosition);

            // Update Labels
            String elapsedTime = createTimeLabel(currentPosition);
            elapsedTimeLabel.setText(elapsedTime);

            String remainingTime = createTimeLabel(totalTime-currentPosition);
            remainingTimeLabel.setText("- " + remainingTime);
        }

    };

    public String createTimeLabel(int time){
        String timeLabel = "";
        int min = time / 1000 / 60;
        int sec = time / 1000 % 60;

        timeLabel = min + ":";
        if (sec < 10) timeLabel += "0";
        timeLabel += sec;

        return timeLabel;
    }

    public void playBtnClick(View view)
    {
        if (!player.isPlaying())
        {
            // Stopping
            player.start();
            playBtn.setBackgroundResource(R.drawable.stop);
        }
        else
        {
            //Playing
            player.pause();
            playBtn.setBackgroundResource(R.drawable.play);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (player == null) {
            player = new MediaPlayer();
        }

        player.start();
    }

    /*@Override
    protected void onRestart() {
        super.onRestart();
        if (player == null) {
            player = new MediaPlayer();
        }
        if (player.isPlaying())
            player.stop();

        player.start();
    }*///
}
