package com.example.musicplayer;




public class Album {
    private String AlbumName;
    public String ArtistName;
    private int AlbumPhoto;

    public Album(){}



    public Album(String albumName, String artistName, int albumPhoto) {
        AlbumName = albumName;
        ArtistName = artistName;
        AlbumPhoto = albumPhoto;
    }


    // To display on the album cardview
    public String getAlbumName() {
        return AlbumName;
    }

    public void setAlbumName(String albumName) {
        AlbumName = albumName;
    }

    // when click in from artits list to show albums, have to display artist list
    // IN ALBUMACTIVITY!!!

    public String getArtistName() {
        return ArtistName;
    }

    public void setArtistName(String artistName) {
        ArtistName = artistName;
    }

    // FOR BOTH FRAGMENT ALBUM AND ALBUM ACTIVITY!!
    // Also.....for nowplaying activity and song activity...

    public int getAlbumPhoto() {
        return AlbumPhoto;
    }

    public void setAlbumPhoto(int albumPhoto) {
        AlbumPhoto = albumPhoto;
    }
}