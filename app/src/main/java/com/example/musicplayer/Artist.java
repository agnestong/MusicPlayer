package com.example.musicplayer;

public class Artist {
    private String ArtistName;
    private int ArtistPhoto;

    public Artist(){

    }

    public Artist(String artistName, int artistPhoto) {
        ArtistName = artistName;
        ArtistPhoto = artistPhoto;
    }


    //Getter
    public String getArtistName() {
        return ArtistName;
    }

    public int getArtistPhoto() {
        return ArtistPhoto;
    }

    //Setter
    public void setArtistName(String artistName) {
        ArtistName = artistName;
    }

    public void setArtistPhoto(int artistPhoto) {
        ArtistPhoto = artistPhoto;
    }
}
