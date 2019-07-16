package com.example.musicplayer;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {



    private TabLayout tablayout;
    private AppBarLayout appBarLayout;
    private ViewPager viewPager;

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



    }
}
