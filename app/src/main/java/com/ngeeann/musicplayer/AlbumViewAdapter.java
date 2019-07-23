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



public class AlbumViewAdapter extends RecyclerView.Adapter<AlbumViewAdapter.MyViewHolder> {

    Context mContext;
    List<Album> albumList;


    public AlbumViewAdapter(Context context, List<Album> albumList) {
        this.mContext = context;
        this.albumList = albumList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.album_cardview, viewGroup, false);
        MyViewHolder vHolder = new MyViewHolder(v);

        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int i) {

        Album album = albumList.get(i);

        holder.tv_album_name.setText(album.getAlbumName());
        holder.img_album.setImageResource(album.getAlbumPhoto());

    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView tv_album_name;
        private ImageView img_album;



        // Constructor for ViewHolder class

        public MyViewHolder(View itemView){
            super(itemView);

            itemView.setOnClickListener(this);

            tv_album_name = itemView.findViewById(R.id.album_title_id);
            img_album = itemView.findViewById(R.id.album_img_id);


        }
        @Override
        public void onClick(View v) {
            Context mContext = v.getContext();
            Intent intent = new Intent(mContext,SongActivity.class );
            mContext.startActivity(intent);
        }


    }
}

