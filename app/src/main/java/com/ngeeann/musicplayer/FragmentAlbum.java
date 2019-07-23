package com.ngeeann.musicplayer;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class FragmentAlbum extends Fragment {

    //FOR UI
    View view;


    private RecyclerView myrv; //contains recycler view from xml

    private RecyclerView.LayoutManager mLayoutManager; // responsible for aligning single items in the list


    // a bridge between data(array list) and layout view
    // If the arrayList contains alot of data , trying to load them directly into the recycler view without an adapter will cause bad performance
    private AlbumViewAdapter adapter;

    List<Album> albumList;


    public FragmentAlbum() {

    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.album_fragment, container, false);
        myrv = view.findViewById(R.id.album_recyclerview);


        MyDBHandler dbHandler = new MyDBHandler(getContext(), null, null, 1);

        albumList = dbHandler.displayAlbum();


        adapter = new AlbumViewAdapter(getContext(), albumList);
        mLayoutManager = new GridLayoutManager(getContext(),2);
        myrv.setLayoutManager(mLayoutManager);
        myrv.setAdapter(adapter );


        return view;
    }

}

