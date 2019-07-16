package com.example.musicplayer;

public class Song {

    private String SongID;
    private String SongName;
    private int SongPhoto;

    public Song(String songID, String songName, int songPhoto) {
        SongID = songID;
        SongName = songName;
        SongPhoto = songPhoto;
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

    public int getSongPhoto() {
        return SongPhoto;
    }

    public void setSongPhoto(int songPhoto) {
        SongPhoto = songPhoto;
    }
}
