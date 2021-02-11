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
    public static final int INDEX_ALBUM_ID = 1;
    public static final int INDEX_ALBUM_NAME = 2;
    public static final int INDEX_ALBUM_ARTIST = 3;

    // Table: Artists
    public static final String TABLE_ARTISTS = "artists";
    public static final String COLUMN_ARTIST_ID = "_id";
    public static final String COLUMN_ARTIST_NAME = "name";
    public static final int INDEX_ARTIST_ID = 1;
    public static final int INDEX_ARTIST_NAME = 2;

    // Table: Songs
    public static final String TABLE_SONGS = "songs";
    public static final String COLUMN_SONG_ID = "_id";
    public static final String COLUMN_SONG_TRACK = "track";
    public static final String COLUMN_SONG_TITLE = "title";
    public static final String COLUMN_SONG_ALBUM = "album";
    public static final int INDEX_SONG_ID = 1;
    public static final int INDEX_SONG_TRACK = 2;
    public static final int INDEX_SONG_TITLE = 3;
    public static final int INDEX_SONG_ALBUM = 4;

    // Sort Order
    public static final int ORDER_BY_NONE = 1;
    public static final int ORDER_BY_ASC = 2;
    public static final int ORDER_BY_DESC = 3;

    // Query as constant
    //      SELECT albums.name
    //      FROM albums INNER JOIN artists ON albums.artist = artists._id
    //      WHERE artists.name = "XXXX" ORDER BY albums.name COLLATE NOCASE XXXX;
    public static final String QUERY_ALBUM_BY_ARTIST_START =
            "SELECT " + TABLE_ALBUMS + "." + COLUMN_ALBUM_NAME +
                    " FROM " + TABLE_ALBUMS +
                    " INNER JOIN " + TABLE_ARTISTS + " ON " + TABLE_ALBUMS + "." + COLUMN_ALBUM_ARTIST + " = " + TABLE_ARTISTS + "." + COLUMN_ARTIST_ID +
                    " WHERE " + TABLE_ARTISTS + "." + COLUMN_ARTIST_NAME + " = \"";

    public static final String QUERY_ALBUM_BY_ARTIST_SORT =
            " ORDER BY " + TABLE_ALBUMS + "." + COLUMN_ALBUM_NAME + " COLLATE NOCASE ";


    // Query as constant
    //      SELECT artists.name, albums.name, songs.track
    //      FROM songs
    //      INNER JOIN albums ON songs.album = albums._id
    //      INNER JOIN artists ON albums.artist = artists._id
    //      WHERE songs.title = "Go Your Own Way"
    //      ORDER BY artists.name, albums.name COLLATE NOCASE ASC
    public static final String QUERY_ARTIST_FOR_SONGS_START =
            "SELECT " + TABLE_ARTISTS + "." + COLUMN_ARTIST_NAME + ", " + TABLE_ALBUMS + "." + COLUMN_ALBUM_NAME + ", " + TABLE_SONGS + "." + COLUMN_SONG_TRACK +
                    " FROM " + TABLE_SONGS +
                    " INNER JOIN " + TABLE_ALBUMS + " ON " + TABLE_SONGS + "." + COLUMN_SONG_ALBUM + " = " + TABLE_ALBUMS + "." + COLUMN_ALBUMS_ID +
                    " INNER JOIN " + TABLE_ARTISTS + " ON " + TABLE_ALBUMS + "." + COLUMN_ALBUM_ARTIST + " = " + TABLE_ARTISTS + "." + COLUMN_ARTIST_ID +
                    " WHERE " + TABLE_SONGS + "." + COLUMN_SONG_TITLE + " = \"";

    public static final String QUERY_ARTIST_FOR_SONGS_SORT =
            " ORDER BY " + TABLE_ARTISTS + "." + COLUMN_ARTIST_NAME + ", " + TABLE_ALBUMS + "." + COLUMN_ALBUM_NAME + " COLLATE NOCASE ";


    // Creating View
    public static final String TABLE_ARTIST_SONG_VIEW = "artist_list";
    public static final String CREATE_ARTIST_FOR_SONG_VIEW = "CREATE VIEW IF NOT EXISTS " +
            TABLE_ARTIST_SONG_VIEW + " AS SELECT " + TABLE_ARTISTS + "." + COLUMN_ARTIST_NAME + ", " +
            TABLE_ALBUMS + "." + COLUMN_ALBUM_NAME + " AS " + COLUMN_SONG_ALBUM + ", " +
            TABLE_SONGS + "." + COLUMN_SONG_TRACK + ", " + TABLE_SONGS + "." + COLUMN_SONG_TITLE +
            " FROM " + TABLE_SONGS +
            " INNER JOIN " + TABLE_ALBUMS + " ON " + TABLE_SONGS +
            "." + COLUMN_SONG_ALBUM + " = " + TABLE_ALBUMS + "." + COLUMN_ALBUMS_ID +
            " INNER JOIN " + TABLE_ARTISTS + " ON " + TABLE_ALBUMS + "." + COLUMN_ALBUM_ARTIST +
            " = " + TABLE_ARTISTS + "." + COLUMN_ARTIST_ID +
            " ORDER BY " +
            TABLE_ARTISTS + "." + COLUMN_ARTIST_NAME + ", " +
            TABLE_ALBUMS + "." + COLUMN_ALBUM_NAME + ", " +
            TABLE_SONGS + "." + COLUMN_SONG_TRACK;


    // Query View (Subject to SQL Injection)
    public static final String QUERY_VIEW_SONG_INFO = "SELECT " + COLUMN_ARTIST_NAME + ", " +
            COLUMN_SONG_ALBUM + ", " + COLUMN_SONG_TRACK + " FROM " + TABLE_ARTIST_SONG_VIEW +
            " WHERE " + COLUMN_SONG_TITLE + " = \"";


    // Prepared Query (Prevent SQL Injection)
    public static final String QUERY_VIEW_SONG_INFO_PREP = "SELECT " + COLUMN_ARTIST_NAME + ", " +
            COLUMN_SONG_ALBUM + ", " + COLUMN_SONG_TRACK + " FROM " + TABLE_ARTIST_SONG_VIEW +
            " WHERE " + COLUMN_SONG_TITLE + " = ?";

    public static final String INSERT_ARTIST = "INSERT INTO " + TABLE_ARTISTS +
            "(" + COLUMN_ARTIST_NAME + ") VALUES(?)";
    public static final String INSERT_ALBUMS = "INSERT INTO " + TABLE_ALBUMS +
            "(" + COLUMN_ALBUM_NAME + ", " + COLUMN_ALBUM_ARTIST + ") VALUES(?, ?)";
    public static final String INSERT_SONGS = "INSERT INTO " + TABLE_SONGS +
            "(" + COLUMN_SONG_TRACK + ", " + COLUMN_SONG_TITLE + ", " + COLUMN_SONG_ALBUM +
            ") VALUES(?, ?, ?)";

    public static final String QUERY_ARTIST = "SELECT " + COLUMN_ARTIST_ID + " FROM " +
            TABLE_ARTISTS + " WHERE " + COLUMN_ARTIST_NAME + " = ?";
    public static final String QUERY_ALBUM = "SELECT " + COLUMN_ALBUMS_ID + " FROM " +
            TABLE_ALBUMS + " WHERE " + COLUMN_ALBUM_NAME + " = ?";


    private Connection conn;

    private PreparedStatement querySongInfoView;

    // Prepared INSERT
    private PreparedStatement insertIntoArtists;
    private PreparedStatement insertIntoAlbums;
    private PreparedStatement insertIntoSongs;

    private PreparedStatement queryArtist;
    private PreparedStatement queryAlbum;

    // Open a connection to our database
    public boolean open() {
        try {
            conn = DriverManager.getConnection(CONNECTION_STRING);
            // Create PreparedStatement instance
            querySongInfoView = conn.prepareStatement(QUERY_VIEW_SONG_INFO_PREP);
            // RETURN_GENERATED_KEYS gives us 'ID' that we use to pass into another INSERT Statement
            insertIntoArtists = conn.prepareStatement(INSERT_ARTIST, Statement.RETURN_GENERATED_KEYS);
            insertIntoAlbums = conn.prepareStatement(INSERT_ALBUMS, Statement.RETURN_GENERATED_KEYS);
            insertIntoSongs = conn.prepareStatement(INSERT_SONGS);
            // QUERY
            queryArtist = conn.prepareStatement(QUERY_ARTIST);
            queryAlbum = conn.prepareStatement(QUERY_ALBUM);

            return true;
        } catch (SQLException e) {
            System.out.println("Couldn't connect to database " + e.getMessage());
            return false;
        }
    }


    // Close our resources
    public void close() {
        try {
            if (querySongInfoView != null) {
                querySongInfoView.close();
            }
            if (insertIntoArtists != null) {
                insertIntoArtists.close();
            }
            if (insertIntoAlbums != null) {
                insertIntoAlbums.close();
            }
            if (insertIntoSongs != null) {
                insertIntoSongs.close();
            }
            if (queryArtist != null) {
                queryArtist.close();
            }
            if (queryAlbum != null) {
                queryAlbum.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println("Couldn't close connection: " + e.getMessage());
        }
    }


    // Gets all artist and returns a list of artist names
    public List<Artist> queryArtist(int sortOrder) {

        // Builds up the string query based on parameter passed
        StringBuilder sb = new StringBuilder("SELECT * FROM ");
        sb.append(TABLE_ARTISTS);
        if (sortOrder != ORDER_BY_NONE) {
            sb.append(" ORDER BY ");
            sb.append(COLUMN_ARTIST_NAME);
            sb.append(" COLLATE NOCASE ");
            if (sortOrder == ORDER_BY_DESC) {
                sb.append("DESC");
            } else {
                sb.append("ASC");
            }
        }

        try (Statement statement = conn.createStatement();
             // Get all records from the Artist table based on query string built
             ResultSet results = statement.executeQuery(sb.toString())
        ) {
            // Create a list that will hold all the artists
            List<Artist> artists = new ArrayList<>();
            while (results.next()) {
                // Create new artist object
                Artist artist = new Artist();
                // Set the artist object's ID to the one in database
                artist.setId(results.getInt(INDEX_ARTIST_ID));
                // Set the artist object's name to the one in database
                artist.setName(results.getString(INDEX_ARTIST_NAME));
                // Add the artist object to the list of artists
                artists.add(artist);
            }

            return artists;

        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            return null;
        }
    }


    // Gets a list of album based on artist's name
    public List<String> queryAlbumsForArtist(String artistName, int sortOrder) {

        StringBuilder sb = new StringBuilder(QUERY_ALBUM_BY_ARTIST_START);
        sb.append(artistName);
        sb.append("\"");

        if (sortOrder != ORDER_BY_NONE) {
            sb.append(QUERY_ALBUM_BY_ARTIST_SORT);
            if (sortOrder == ORDER_BY_DESC) {
                sb.append("DESC");
            } else {
                sb.append("ASC");
            }
        }

        System.out.println("SQL Statement = " + sb.toString());

        try (Statement statement = conn.createStatement();
             ResultSet results = statement.executeQuery(sb.toString())
        ) {
            List<String> albums = new ArrayList<>();
            while (results.next()) {
                // Note the the first column index of ResultSet is 1 not 0
                albums.add(results.getString(1));
            }
            return albums;
        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            return null;
        }
    }


    // Get artist based on song name
    public List<SongArtist> queryArtistForSong(String songName, int sortOrder) {

        StringBuilder sb = new StringBuilder(QUERY_ARTIST_FOR_SONGS_START);
        sb.append(songName);
        sb.append("\"");

        if (sortOrder != ORDER_BY_NONE) {
            sb.append(QUERY_ALBUM_BY_ARTIST_SORT);
            if (sortOrder == ORDER_BY_DESC) {
                sb.append("DESC");
            } else {
                sb.append("ASC");
            }
        }

        System.out.println("SQL Statement: " + sb.toString());

        try (Statement statement = conn.createStatement();
             ResultSet results = statement.executeQuery(sb.toString())
        ) {
            List<SongArtist> songArtists = new ArrayList<>();
            while (results.next()) {
                // Create SongArtist object
                SongArtist songArtist = new SongArtist();
                // Set object's artist name to that of result's
                songArtist.setArtistName(results.getString(1));
                // Set objects album name to that of result's
                songArtist.setAlbumName(results.getString(2));
                // Set object's track number to that of result's
                songArtist.setTrack(results.getInt(3));
                // Add the object to the list of artists
                songArtists.add(songArtist);
            }
            return songArtists;
        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            return null;
        }

    }


    // Get the meta data (Column names) for Song Table
    public void querySongsMetadata() {
        String sql = "SELECT * FROM " + TABLE_SONGS;

        try (Statement statement = conn.createStatement();
             ResultSet results = statement.executeQuery(sql)) {

            ResultSetMetaData meta = results.getMetaData();
            int numColumns = meta.getColumnCount();
            for (int i = 1; i <= numColumns; i++) {
                System.out.format("Column %d in the songs table is names %s\n", i, meta.getColumnName(i));
            }
        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
        }
    }

    // Functions
    public int getCount(String table) {
        String sql = "SELECT COUNT(*) AS count FROM " + table;
        try (Statement statement = conn.createStatement();
             ResultSet results = statement.executeQuery(sql)
        ) {
            int count = results.getInt("count");

            System.out.format("Count = %d\n", count);
            return count;
        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            return -1;
        }
    }


    // Create View for song artist
    public boolean createViewForSongArtist() {
        try (Statement statement = conn.createStatement()) {
            statement.execute(CREATE_ARTIST_FOR_SONG_VIEW);
            return true;
        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            return false;
        }
    }


    // Query the View
    public List<SongArtist> querySongInfoView(String title) {

        try {
            // Parameter '1' used to replace the 'first' occurrence of '?' in SQL PreparedStatement Query
            querySongInfoView.setString(1, title);
            // Run the PreparedStatement
            ResultSet results = querySongInfoView.executeQuery();

            List<SongArtist> songArtists = new ArrayList<>();
            while (results.next()) {
                SongArtist songArtist = new SongArtist();
                songArtist.setArtistName(results.getString(1));
                songArtist.setAlbumName(results.getString(2));
                songArtist.setTrack(results.getInt(3));
                songArtists.add(songArtist);
            }
            return songArtists;

        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            return null;
        }
    }

    // Insert Artist by Name
    private int insertArtist(String name) throws SQLException {
        queryArtist.setString(1, name);
        ResultSet results = queryArtist.executeQuery();
        if (results.next()) {
            // If we get a number back from query, artist already exists. Return artist ID
            return results.getInt(1);
        } else {
            // Insert the artist
            insertIntoArtists.setString(1, name);
            // executeUpdate() returns the number of rows affected by the INSERT
            int affectedRows = insertIntoArtists.executeUpdate();

            // We only expect one row to be affected
            if (affectedRows != 1) {
                // Throw exception that will be handled in the insertSong()
                throw new SQLException("Couldn't update artist!");
            }

            // Get key(s)
            ResultSet generatedKeys = insertIntoArtists.getGeneratedKeys();
            // Only expect 1 key to be returned from this INSERT statement
            if (generatedKeys.next()) {
                return generatedKeys.getInt(1);
            } else {
                // Throw exception that will be handled in the insertSong()
                throw new SQLException("Couldn't get _id for artist");
            }
        }
    }


    // Insert Album by Name and artistID from insertArtist()
    private int insertAlbum(String name, int artistID) throws SQLException {
        queryAlbum.setString(1, name);
        ResultSet results = queryAlbum.executeQuery();
        if (results.next()) {
            // If we get a number back from query, album already exists. Return album ID
            return results.getInt(1);
        } else {
            // Insert the album
            insertIntoAlbums.setString(1, name);
            insertIntoAlbums.setInt(2, artistID);
            // executeUpdate() returns the number of rows affected by the INSERT
            int affectedRows = insertIntoAlbums.executeUpdate();

            // We only expect one row to be affected
            if (affectedRows != 1) {
                // Throw exception that will be handled in the insertSong()
                throw new SQLException("Couldn't update album!");
            }

            // Get key(s)
            ResultSet generatedKeys = insertIntoAlbums.getGeneratedKeys();
            // Only expect 1 key to be returned from this INSERT statement
            if (generatedKeys.next()) {
                return generatedKeys.getInt(1);
            } else {
                // Throw exception that will be handled in the insertSong()
                throw new SQLException("Couldn't get _id for album");
            }
        }
    }


    // Insert Song by Title, Album, Track
    public void insertSong(String title, String artist, String album, int track) {

        try {
            // Disable autocommit during transaction for ATOMICITY
            // Turn off when running a sequence of SQL statements that should be executed together
            conn.setAutoCommit(false);

            // Insert artist given the artist's name
            int artistID = insertArtist(artist);
            // Insert album based on album's name and artist ID given from insertArtist()
            int albumID = insertAlbum(album, artistID);
            // Set the column entry at index 2 to be title of Song
            insertIntoSongs.setString(2, title);
            // Set the column entry at index 3 to be album id
            insertIntoSongs.setInt(3, albumID);

            // Check how many rows were affected. Only expect one to be affected
            int affectedRows = insertIntoSongs.executeUpdate();

            // We only expect one row to be affected
            if (affectedRows == 1) {
                // Commit the SQL statements
                conn.commit();
            } else {
                throw new SQLException("The song insert failed");
            }
        }
        // Catch all exceptions here b/c rollback needed on any exceptions caught
        catch (Exception e) {
            System.out.println("Insert song exception: " + e.getMessage());
            try {
                System.out.println("Performing rollback");
                conn.rollback();
            } catch (SQLException e2) {
                System.out.println("Oh boy! Things are really bad! " + e2.getMessage());
            }
        } finally {
            try {
                // Transaction ended, turn back on auto-commit
                System.out.println("Setting default commit behavior.");
                conn.setAutoCommit(true);
            } catch (SQLException e3) {
                System.out.println("Couldn't reset auto-commit! " + e3.getMessage());
            }
        }
    }
}




