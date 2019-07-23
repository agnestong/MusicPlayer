package com.ngeeann.musicplayer;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class Start extends AppCompatActivity {

    private static int SPLASH_TIME_SCREEN = 1500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        ImageView icon = findViewById(R.id.appIcon);

        icon.setImageResource(R.drawable.logo);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent (Start.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_TIME_SCREEN);
    }
}
