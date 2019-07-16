package com.example.musicplayer;

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

public class FragmentArtist extends Fragment {
    View view;
    private RecyclerView myrv;
    private List<Artist> artistList;
    private ArtistViewAdapter adapter;

    public FragmentArtist() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.artist_fragment, container, false);


        myrv = view.findViewById(R.id.artist_recyclerview);
        adapter = new ArtistViewAdapter(getContext(), artistList);
        myrv.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrv.setAdapter(adapter);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        artistList = new ArrayList<>();
        artistList.add(new Artist("Billie Eilish", R.drawable.billie_artist1));
        artistList.add(new Artist(" Ed Sheeran", R.drawable.edsheeran_artist2));
        artistList.add(new Artist("Higher Brother", R.drawable.higherbro_artist3));

    }
}
