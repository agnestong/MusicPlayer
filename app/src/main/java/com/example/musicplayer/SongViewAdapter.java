package com.example.musicplayer;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class SongViewAdapter extends RecyclerView.Adapter<SongViewAdapter.SongViewHolder> {

    Context mContext;
    List<Song> mData;

    public SongViewAdapter(Context mContext, List<Song> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }


    @NonNull
    @Override
    public SongViewAdapter.SongViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view;
        view = LayoutInflater.from(mContext).inflate(R.layout.song_recyclerview, viewGroup, false);
        SongViewHolder viewHolder = new SongViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SongViewAdapter.SongViewHolder songViewHolder, int i) {

        songViewHolder.tv_songName.setText(mData.get(i).getSongName());
        songViewHolder.img_song.setImageResource(mData.get(i).getSongPhoto());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class SongViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        private TextView tv_songName;
        private ImageView img_song;


        public SongViewHolder(View itemView){
            super(itemView);

            tv_songName = itemView.findViewById(R.id.song_name);
            img_song = itemView.findViewById(R.id.song_img_id);


            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v)
        {
            Context mContext = v.getContext();
            Intent intent = new Intent(mContext,NowPlayingActivity.class );
            mContext.startActivity(intent);
        }

    }
}
