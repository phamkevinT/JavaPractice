package com.kevinpham.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Datasource {

    // The database name
    public static final String DB_NAME = "music.db";
    // The database location
    public static final String CONNECTION_STRING = "jdbc:sqlite:D:\\github\\JavaMasterClass\\Database\\Music\\" + DB_NAME;

    // Table: Album
    public static final String TABLE_ALBUMS = "albums";
    public static final String COLUMN_ALBUMS_ID = "_id";
    public static final String COLUMN_ALBUM_NAME = "name";
    public static final String COLUMN_ALBUM_ARTIST = "artist";

    // Table: Artists
    public static final String TABLE_ARTISTS = "artists";
    public static final String COLUMN_ARTIST_ID = "_id";
    public static final String COLUMN_ARTIST_NAME = "name";

    // Table: Songs
    public static final String TABLE_SONGS = "songs";
    public static final String COLUMN_SONG_TRACK = "track";
    public static final String COLUMN_SONG_TITLE = "title";
    public static final String COLUMN_SONG_ALBUM = "album";

    private Connection conn;

    // Open a connection to our database
    public boolean open() {
        try {
            conn = DriverManager.getConnection(CONNECTION_STRING);
            return true;
        } catch (SQLException e) {
            System.out.println("Couldn't connect to database " + e.getMessage());
            return false;
        }
    }

    // Close the connection to our database
    public void close() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println("Couldn't close connection: " + e.getMessage());
        }
    }


    public List<Artist> queryArtist() {

        try (Statement statement = conn.createStatement();
             // Get all records from the Artist table
             ResultSet results = statement.executeQuery("SELECT * FROM " + TABLE_ARTISTS)
        ) {
            // Create a list that will hold all the artists
            List<Artist> artists = new ArrayList<>();
            while (results.next()) {
                // Create new artist object
                Artist artist = new Artist();
                // Set the artist object's ID to the one in database
                artist.setId(results.getInt(COLUMN_ARTIST_ID));
                // Set the artist object's name to the one in database
                artist.setName(results.getString(COLUMN_ARTIST_NAME));
                // Add the artist object to the list of artists
                artists.add(artist);
            }

            return artists;

        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            return null;
        }
    }
}


