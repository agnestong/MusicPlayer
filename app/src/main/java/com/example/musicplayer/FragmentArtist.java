package com.example.musicplayer;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;


public class FragmentArtist extends Fragment {
    View view;
    RecyclerView myrv;
    ArtistViewAdapter adapter;
    List<Artist> artistList;

    public FragmentArtist() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.artist_fragment, container, false);


        myrv = view.findViewById(R.id.artist_recyclerview);

        MyDBHandler dbHandler = new MyDBHandler(getContext(), null, null, 1);
        artistList = dbHandler.displayArtist();

        adapter = new ArtistViewAdapter(getContext(), artistList);
        myrv.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrv.setAdapter(adapter);

        return view;
    }


}
