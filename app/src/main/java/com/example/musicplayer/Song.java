package com.example.musicplayer;

public class Song {

    private String SongID;
    private String SongName;
    private int AlbumPhoto;
    private String AlbumName;
    private long SongAudio;

    public Song(){}

    public Song(String songID, String songName, int albumPhoto, String albumName, long songAudio) {
        SongID = songID;
        SongName = songName;
        AlbumPhoto = albumPhoto;
        AlbumName = albumName;
        SongAudio = songAudio;
    }

    public String getSongID() {
        return SongID;
    }

    public void setSongID(String songID) {
        SongID = songID;
    }

    public String getSongName() {
        return SongName;
    }

    public void setSongName(String songName) {
        SongName = songName;
    }

    public int getAlbumPhoto() {
        return AlbumPhoto;
    }

    public void setAlbumPhoto(int albumPhoto) {
        AlbumPhoto = albumPhoto;
    }

    public String getAlbumName() {
        return AlbumName;
    }

    public void setAlbumName(String albumName) {
        AlbumName = albumName;
    }

    public long getSongAudio() {
        return SongAudio;
    }

    public void setSongAudio(long songAudio) {
        SongAudio = songAudio;
    }
}

