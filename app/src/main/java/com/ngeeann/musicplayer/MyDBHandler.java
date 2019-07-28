
package com.ngeeann.musicplayer;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class MyDBHandler extends SQLiteOpenHelper {

    private static final String TAG = "MyDBHandler";

    public static final int DATABASE_VERSION =1;
    private static final String DATABASE_NAME = "musicDB.db";

    public static final String SONGS = "Songs";
    public static final String COLUMN_SONGID = "SongID";
    public static final String COLUMN_SONG_NAME = "SongName";
    public static final String COLUMN_ALBUMID_FK = "AlbumID";
    public static final String COLUMN_MP3 = "MP3";




    public static final String ALBUMS = "Albums";
    public static final String COLUMN_ALBUMID_PK = "AlbumID";
    public static final String COLUMN_ALBUM_NAME = "AlbumName";
    public static final String COLUMN_ARTISTID_FK = "ArtistID";
    public static final String COLUMN_ALBUM_IMG = "AlbumPhoto";

    public static final String ARTIST = "Artists";
    public static final String COLUMN_ARTISTID_PK = "ArtistID";
    public static final String COLUMN_ARTIST_NAME = "ArtistName";
    public static final String COLUMN_ARTIST_IMG = "ArtistPhoto";


    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_SONGS_TABLE = "CREATE TABLE " + SONGS + "(" + COLUMN_SONGID + " TEXT," + COLUMN_SONG_NAME + " TEXT," + COLUMN_ALBUMID_FK + " TEXT," +  COLUMN_MP3 + " TEXT" + ")";
        String CREATE_ALBUMS_TABLE = "CREATE TABLE " + ALBUMS + "(" + COLUMN_ALBUMID_PK + " TEXT," + COLUMN_ALBUM_NAME + " TEXT," + COLUMN_ARTISTID_FK + " TEXT," + COLUMN_ALBUM_IMG + " TEXT" + ")";
        String CREATE_ARTIST_TABLE = "CREATE TABLE " + ARTIST + "(" + COLUMN_ARTISTID_PK + " TEXT," + COLUMN_ARTIST_NAME + " TEXT," + COLUMN_ARTIST_IMG + " TEXT" + ")";
        db.execSQL(CREATE_SONGS_TABLE);
        db.execSQL(CREATE_ALBUMS_TABLE);
        db.execSQL(CREATE_ARTIST_TABLE);


        db.execSQL("INSERT INTO " + SONGS+ "(SongID, SongName, AlbumID, MP3 ) VALUES ('S1','Bad Guy','A001',"+R.raw.somefeeling+")");
        db.execSQL("INSERT INTO " + SONGS+ "(SongID, SongName, AlbumID, MP3 ) VALUES ('S2','South Border','A002',"+R.raw.southborder+")");
        db.execSQL("INSERT INTO " + SONGS+ "(SongID, SongName, AlbumID, MP3 ) VALUES ('S3','Indigo','A003',"+R.raw.indigo+")");


        db.execSQL("INSERT INTO " + ALBUMS+ "(AlbumID, AlbumName, ArtistID, AlbumPhoto ) VALUES ('A001','WHEN WE ALL FALL ASLEEP, WHERE DO WE GO?','A1',"+R.drawable.billie_album1+")");
        db.execSQL("INSERT INTO " + ALBUMS+ "(AlbumID, AlbumName, ArtistID, AlbumPhoto ) VALUES ('A002','÷(Deluxe)','A2',"+R.drawable.ed_album1+")");
        db.execSQL("INSERT INTO " + ALBUMS+ "(AlbumID, AlbumName, ArtistID, AlbumPhoto ) VALUES ('A003','FIVE STARS','A3',"+R.drawable.higherbrothers_album1+")");



        db.execSQL("INSERT INTO " + ARTIST+ "(ArtistID, ArtistName, ArtistPhoto ) VALUES ('A1','Billie Eilish',"+R.drawable.billie_artist1+")");
        db.execSQL("INSERT INTO " + ARTIST+ "(ArtistID, ArtistName, ArtistPhoto ) VALUES ('A2','Ed Sheeran',"+R.drawable.edsheeran_artist2+")");
        db.execSQL("INSERT INTO " + ARTIST+ "(ArtistID, ArtistName, ArtistPhoto ) VALUES ('A3','Higher Brothers',"+R.drawable.higherbro_artist3+")");






    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + SONGS + ALBUMS + ARTIST);
        onCreate(db);

    }


   public List<Album> displayAlbum(){
       String query = "SELECT * FROM " + ALBUMS;
       List<Album> albumList = new ArrayList<>();
       SQLiteDatabase db = this.getReadableDatabase();
       Cursor cursor = db.rawQuery(query,null);


        while (cursor.moveToNext())
        {
            Album albumData = new Album();
            albumData.setAlbumName(cursor.getString(1));
            albumData.setAlbumPhoto(cursor.getInt(3));
            albumList.add(albumData);
       }

       db.close();
       return albumList;


   }

    public List<Artist> displayArtist(){
        String query = "SELECT * FROM " + ARTIST;
        List<Artist> artistList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query,null);



        while (cursor.moveToNext())
        {
            Artist artistData = new Artist();
            artistData.setArtistName(cursor.getString(1));
            artistData.setArtistPhoto(cursor.getInt(2));
            artistList.add(artistData);
        }

        db.close();
        return artistList;

    }

    public List<Song> displaySong(){
        String query = "SELECT * FROM " + SONGS;
        List<Song> songList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query,null);




         while (cursor.moveToNext())
         {
             Song songData = new Song();
             songData.setSongName(cursor.getString(1));
             songData.setAlbumPhoto(cursor.getInt(3)); // Cannot set album photo...do inner join but what column index to indicate?
             songList.add(songData);
        }

        db.close();
        return songList;

    }




}

