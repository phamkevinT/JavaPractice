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
        List<Artist> artists = datasource.queryArtist();
        if (artists == null) {
            System.out.println("No artists!");
            return;
        }
        for (Artist artist : artists) {
            System.out.println("ID = " + artist.getId() + ", Name = " + artist.getName());
        }


        datasource.close();
    }
}
