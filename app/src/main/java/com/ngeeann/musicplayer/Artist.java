package com.ngeeann.musicplayer;

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

    // To show on the Artist list
    public String getArtistName() {
        return ArtistName;
    }

    // to show on artist list

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
