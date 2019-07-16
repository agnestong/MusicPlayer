package com.example.musicplayer;

import android.media.MediaPlayer;

public class Album {
    private String AlbumName;
    public String ArtistName;
    private int AlbumPhoto;



    public Album(String albumName, String artistName, int albumPhoto) {
        AlbumName = albumName;
        ArtistName = artistName;
        AlbumPhoto = albumPhoto;
    }

    public String getAlbumName() {
        return AlbumName;
    }

    public void setAlbumName(String albumName) {
        AlbumName = albumName;
    }

    public String getArtistName() {
        return ArtistName;
    }

    public void setArtistName(String artistName) {
        ArtistName = artistName;
    }

    public int getAlbumPhoto() {
        return AlbumPhoto;
    }

    public void setAlbumPhoto(int albumPhoto) {
        AlbumPhoto = albumPhoto;
    }
}