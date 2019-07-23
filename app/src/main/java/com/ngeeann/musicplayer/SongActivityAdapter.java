package com.ngeeann.musicplayer;

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

public class SongActivityAdapter extends RecyclerView.Adapter<SongActivityAdapter.SongViewHolder> {

    Context mContext;
    List<Song> songList;
    public SongActivityAdapter(Context context, List<Song> songList) {
        this.mContext = context;
        this.songList = songList;
    }


    @NonNull
    @Override
    public SongActivityAdapter.SongViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view;
        view = LayoutInflater.from(mContext).inflate(R.layout.activity_songlist, viewGroup, false);
        SongViewHolder viewHolder = new SongViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SongActivityAdapter.SongViewHolder songViewHolder, int i) {

        Song song = songList.get(i);
        songViewHolder.tv_songName.setText(song.getSongName());
        songViewHolder.img_song.setImageResource(song.getAlbumPhoto());
    }

    @Override
    public int getItemCount() {
        return songList.size();
    }

    public static class SongViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        private TextView tv_songName;
        private ImageView img_song;


        public SongViewHolder(View itemView){
            super(itemView);

            tv_songName = itemView.findViewById(R.id.song_name_list);
            img_song = itemView.findViewById(R.id.song_img_list);


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
