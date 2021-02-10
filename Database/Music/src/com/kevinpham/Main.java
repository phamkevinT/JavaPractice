package com.kevinpham;

import com.kevinpham.model.Artist;
import com.kevinpham.model.Datasource;

import java.util.List;

public class Main {

    public static void main(String[] args) {

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


        datasource.close();
    }
}
