package com.ngeeann.musicplayer;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {



    private TabLayout tablayout;
    private AppBarLayout appBarLayout;
    private ViewPager viewPager;
    //NowPlayingActivity player;
    MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tablayout = findViewById(R.id.tab_layout_id);
        appBarLayout = findViewById(R.id.appbar_id);
        viewPager = findViewById(R.id.viewpager_id);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        //Adding Fragments
        adapter.AddFragment(new FragmentAlbum(), "Album");
        adapter.AddFragment(new FragmentArtist(), "Artist");
        adapter.AddFragment(new FragmentSong(), "Songs");

        //Adapter Setup
        viewPager.setAdapter(adapter);
        tablayout.setupWithViewPager(viewPager);

        tablayout.getTabAt(0).setIcon(R.drawable.ic_album);
        tablayout.getTabAt(1).setIcon(R.drawable.ic_artist);
        tablayout.getTabAt(2).setIcon(R.drawable.ic_song);

        Button btnNPlaying = findViewById(R.id.btnNPlay);
        btnNPlaying.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NowPlayingActivity.class);
                startActivity(intent);
            }
        });
    }

    /*public void onClick(View v) {

        Intent intent = new Intent(MainActivity.this, NowPlayingActivity.class);
        startActivity(intent);

    }*/
}
