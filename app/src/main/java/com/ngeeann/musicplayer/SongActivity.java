package com.ngeeann.musicplayer;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

public class SongActivity extends AppCompatActivity {


    SongActivityAdapter adapter;
    RecyclerView myrv;
    List<Song> songList;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song);

        MyDBHandler dbHandler = new MyDBHandler(this, null, null,1);

        songList = dbHandler.displaySong();




        myrv = findViewById(R.id.song_list);


        adapter = new SongActivityAdapter(this, songList);
        myrv.setLayoutManager(new LinearLayoutManager(this));
        myrv.setAdapter(adapter);

    }

}
