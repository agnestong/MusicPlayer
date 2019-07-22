package com.example.musicplayer;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class ArtistViewAdapter extends RecyclerView.Adapter<ArtistViewAdapter.ArtistViewHolder> {

    Context mContext;
    List<Artist> mData;

    public ArtistViewAdapter(Context context, List<Artist> data) {
        this.mContext = context;
        this.mData = data;
    }


    @NonNull
    @Override
    public ArtistViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view;
        view = LayoutInflater.from(mContext).inflate(R.layout.artist_recyclerview, viewGroup, false);
        ArtistViewHolder viewHolder = new ArtistViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ArtistViewHolder artistViewHolder, int i) {

        //ERROR
        artistViewHolder.tv_artistName.setText(mData.get(i).getArtistName());
        artistViewHolder.img_artist.setImageResource(mData.get(i).getArtistPhoto());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class ArtistViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{


        private TextView tv_artistName;
        private ImageView img_artist;




        public ArtistViewHolder(View itemView){
            super(itemView);

            itemView.setOnClickListener(this);

            tv_artistName = itemView.findViewById(R.id.artist_name);
            img_artist = itemView.findViewById(R.id.artist_img_id);
        }

        @Override
        public void onClick(View v) {
            Context mContext = v.getContext();
            Intent intent = new Intent(mContext, AlbumActivity.class );
            mContext.startActivity(intent);
        }
    }
}
