package com.example.musicplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class FragmentSong extends Fragment {

    View view;
    private RecyclerView myrv;
    private List<Song> songList;
    private SongViewAdapter adapter;

    public FragmentSong(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // INFLATE THE FRAGMENT VIEW
        view = inflater.inflate(R.layout.song_fragment, container,false);

        // Set adapter to pass all the workings and data from SongViewAdapter to this Fragment
        // bc the song_recyclerview is inflated in the adapter
        myrv = view.findViewById(R.id.song_recyclerview);
        adapter = new SongViewAdapter(getContext(), songList);


        myrv.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrv.setAdapter(adapter);

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // DATA

        songList = new ArrayList<>();
        songList.add(new Song("","Billie Eilish", R.drawable.billie_artist1));
        songList.add(new Song(""," Ed Sheeran", R.drawable.edsheeran_artist2));
        songList.add(new Song("","Higher Brother", R.drawable.higherbro_artist3));


    }


    }

