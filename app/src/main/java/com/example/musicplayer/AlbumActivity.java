package com.example.musicplayer;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AlbumActivity extends AppCompatActivity {


    private RecyclerView myrv;
    private List<Album> albumList;
    private Context mContext;
    private RecyclerView.LayoutManager mLayoutManager;
    private AlbumActivityAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);

        albumList = new ArrayList<>();
        albumList.add(new Album("÷(Deluxe)","Ed Sheeran",R.drawable.ed_album1));
        albumList.add(new Album("WHEN WE ALL FALL ASLEEP, WHERE DO WE GO?","Billie Eilish",R.drawable.billie_album1));
        albumList.add(new Album("FIVE STARS","Higher Brothers",R.drawable.higherbrothers_album1));


        myrv = findViewById(R.id.album_list);


        adapter = new AlbumActivityAdapter(this, albumList);
        mLayoutManager = new GridLayoutManager(mContext,2);
        myrv.setLayoutManager(mLayoutManager);
        myrv.setAdapter(adapter );

    }
}
