package com.kevinpham;

import com.kevinpham.model.Artist;
import com.kevinpham.model.Datasource;
import com.kevinpham.model.SongArtist;

import javax.xml.crypto.Data;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // Datasource is the class file that connects to the database and contains query methods
        Datasource datasource = new Datasource();
        if (!datasource.open()) {
            System.out.println("Can't open datasource.");
            return;
        }


        // Get list of Artists
        List<Artist> artists = datasource.queryArtist(Datasource.ORDER_BY_NONE);
        if (artists == null) {
            System.out.println("No artists!");
            return;
        }
        for (Artist artist : artists) {
            System.out.println("ID = " + artist.getId() + ", Name = " + artist.getName());
        }


        // Spacer
        System.out.println("");
        System.out.println("");


        // Get ordered/non-ordered list of albums by an artist
        List<String> albumsForArtist = datasource.queryAlbumsForArtist("Iron Maiden", Datasource.ORDER_BY_ASC);
        if (albumsForArtist == null) {
            System.out.println("No albums");
            return;
        }
        for (String album : albumsForArtist) {
            System.out.println(album);
        }


        // Spacer
        System.out.println("");
        System.out.println("");


        // Get the artist's name, song's album name, and its track number based on the song name
        List<SongArtist> songArtists = datasource.queryArtistForSong("Heartless", Datasource.ORDER_BY_ASC);
        if (songArtists == null) {
            System.out.println("Couldn't find the artist for the song.");
            return;
        }
        for (SongArtist artist : songArtists) {
            System.out.println("\tArtist name = " + artist.getArtistName() +
                    "\n\tAlbum name = " + artist.getAlbumName() +
                    "\n\tTrack = " + artist.getTrack()
            );
        }


        // Spacer
        System.out.println("");
        System.out.println("");


        // Get the Song Table meta data
        datasource.querySongsMetadata();


        // Spacer
        System.out.println("");
        System.out.println("");


        int count = datasource.getCount(Datasource.TABLE_SONGS);
        System.out.println("Number of songs is: " + count);


        // Spacer
        System.out.println("");
        System.out.println("");


        datasource.createViewForSongArtist();

        songArtists = datasource.querySongInfoView("Go Your Own Way");
        if(songArtists.isEmpty()) {
            System.out.println("Couldn't find the artist for the song.");
            return;
        }
        for(SongArtist artist : songArtists) {
            System.out.println("FROM VIEW - Artist Name = " + artist.getArtistName() +
                    " Album Name = " + artist.getAlbumName() +
                    " Track Number = " + artist.getTrack());
        }

        datasource.close();
    }
}
