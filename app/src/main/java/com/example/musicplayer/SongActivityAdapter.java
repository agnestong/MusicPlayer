package com.example.musicplayer;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SongActivityAdapter extends ArrayAdapter<Song> {

    Context mContext;
    int layout;
    ArrayList<Song> mData;

    public SongActivityAdapter(Context mContext, int layout, ArrayList<Song> mData) {
        super(mContext, layout, mData);
        this.mContext = mContext;
        this.layout = layout;
        this.mData = mData;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
            convertView = LayoutInflater.from(mContext).inflate(layout,
                    parent, false);


        Song song = mData.get(position);

        TextView SongName = convertView.findViewById(R.id.song_name_listview);
        SongName.setText(song.getSongName());
        ImageView SongPhoto = convertView.findViewById(R.id.song_img_list);
        SongPhoto.setImageResource(song.getSongPhoto());

        return convertView;
    }

}