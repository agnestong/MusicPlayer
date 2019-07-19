
package com.example.musicplayer;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDBHandler extends SQLiteOpenHelper {

    private static final String TAG = "MyDBHandler";

    public static final int DATABASE_VERSION =1;
    private static final String DATABASE_NAME = "musicDB.db";

    public static final String SONGS = "Songs";
    public static final String COLUMN_SONGID = "SongID";
    public static final String COLUMN_SONG_NAME = "SongName";
    public static final String COLUMN_ALBUMID_FK = "AlbumID";
    public static final String COLUMN_MP3 = "SongAudio";




    public static final String ALBUMS = "Albums";
    public static final String COLUMN_ALBUMID_PK = "AlbumID";
    public static final String COLUMN_ALBUM_NAME = "AlbumName";
    public static final String COLUMN_ARTISTID_FK = "ArtistID";

    public static final String ARTIST = "Artists";
    public static final String COLUMN_ARTISTID_PK = "ArtistID";
    public static final String COLUMN_ARTIST_NAME = "ArtistName";


    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_SONGS_TABLE = "CREATE TABLE " + SONGS + "(" + COLUMN_SONGID + " TEXT," + COLUMN_SONG_NAME + " TEXT," + COLUMN_ALBUMID_FK + " TEXT," +  COLUMN_MP3 + " TEXT" + ")";
        String CREATE_ALBUMS_TABLE = "CREATE TABLE " + ALBUMS + "(" + COLUMN_ALBUMID_PK + " TEXT," + COLUMN_ALBUM_NAME + " TEXT," + COLUMN_ARTISTID_FK + " TEXT" + ")";
        String CREATE_ARTIST_TABLE = "CREATE TABLE " + ARTIST + "(" + COLUMN_ARTISTID_PK + " TEXT," + COLUMN_ALBUM_NAME + " TEXT" +  ")";
        db.execSQL(CREATE_SONGS_TABLE);
        db.execSQL(CREATE_ALBUMS_TABLE);
        db.execSQL(CREATE_ARTIST_TABLE);


        db.execSQL("INSERT INTO " + SONGS+ "(SongID, SongName, AlbumID, MP3 ) VALUES ('S1','Bad Guy','A001',"+R.raw.badguy+")");
        db.execSQL("INSERT INTO " + SONGS+ "(SongID, SongName, AlbumID, MP3 ) VALUES ('S2','South Border','A002',"+R.raw.southborder+")");
        db.execSQL("INSERT INTO " + SONGS+ "(SongID, SongName, AlbumID ) VALUES ('S3','Indigo','A003',"+R.raw.indigo+")");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + SONGS + ALBUMS + ARTIST);
        onCreate(db);

    }

    public void insertSongs(Song song)
    {
        ContentValues value = new ContentValues();
        value.put(COLUMN_SONGID, song.getSongID());
        value.put(COLUMN_SONG_NAME, song.getSongName());
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(SONGS, null, value);
        db.close();
    }
}

