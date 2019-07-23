package com.ngeeann.musicplayer;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

public class AlbumActivity extends AppCompatActivity {


    private RecyclerView myrv;
    private Context mContext;
    private RecyclerView.LayoutManager mLayoutManager;
    private AlbumActivityAdapter adapter;
    List<Album> albumList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);


        MyDBHandler dbHandler = new MyDBHandler(this, null, null,1);
        albumList = dbHandler.displayAlbum();


        myrv = findViewById(R.id.album_list);


        adapter = new AlbumActivityAdapter(this, albumList);
        mLayoutManager = new GridLayoutManager(mContext,2);
        myrv.setLayoutManager(mLayoutManager);
        myrv.setAdapter(adapter);

    }
}
