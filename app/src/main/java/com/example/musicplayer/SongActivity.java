package com.example.musicplayer;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class SongActivity extends AppCompatActivity {


    SongActivityAdapter adapter;
    ArrayList<Song> songList;
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song);

        //DATA
        songList = new ArrayList<>();
        songList.add(new Song("","Billie Eilish", R.drawable.billie_artist1));
        songList.add(new Song(""," Ed Sheeran", R.drawable.edsheeran_artist2));
        songList.add(new Song("","Higher Brother", R.drawable.higherbro_artist3));


        adapter = new SongActivityAdapter(this,R.layout.activity_songlist, songList);
        list = findViewById(R.id.song_list); //id name of the list in xml
        list.setAdapter(adapter);



        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(SongActivity.this, NowPlayingActivity.class);
                intent.putExtra("Song Name", list.getItemAtPosition(position).toString());
                startActivity(intent);
            }
        });



    }

}
