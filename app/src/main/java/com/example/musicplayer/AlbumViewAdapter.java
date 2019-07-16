package com.example.musicplayer;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;


public class AlbumViewAdapter extends RecyclerView.Adapter<AlbumViewAdapter.MyViewHolder> {

    // this method is to get data out of the array list and pass into the adapter
    Context mContext;
    List<Album> mData;

    public AlbumViewAdapter(Context mContext, List<Album> mData)
    {
        this.mContext = mContext;
        this.mData = mData;
    }

    // this method is to pass the layout styling for the recycler view into the adapter
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {

        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.album_cardview, viewGroup, false);
        MyViewHolder vHolder = new MyViewHolder(v);

        return vHolder;
    }


    // this method is to pass value into the xml references
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int i)
    {


        holder.tv_album_name.setText(mData.get(i).getAlbumName());
        holder.img_album.setImageResource(mData.get(i).getAlbumPhoto());



    }

    // this method returns the number of item in the data
    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView tv_album_name;
        private ImageView img_album;


        public MyViewHolder(View itemView)
        {
            super(itemView);

            itemView.setOnClickListener(this);

            //References to the XML / Views
            tv_album_name = itemView.findViewById(R.id.album_title_id);
            img_album = itemView.findViewById(R.id.album_img_id);

        }


        @Override
        public void onClick(View v)
        {
            Context mContext = v.getContext();
            Intent intent = new Intent(mContext,SongActivity.class );
            mContext.startActivity(intent);
        }


    }
}
