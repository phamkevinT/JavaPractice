package com.kevinpham;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {

    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<Song>();
    }


    /**
     * Add a song to the list of songs in album
     *
     * @param title    the title of the song
     * @param duration the length of the song
     * @return true if successful, otherwise false
     */
    public boolean addSong(String title, double duration) {
        if (findSong(title) == null) {   // Song doesn't exist in album
            this.songs.add(new Song(title, duration));
            return true;
        }
        return false;
    }


    /**
     * Find an existing song in album
     *
     * @param title the song to search for
     * @return the song found
     */
    private Song findSong(String title) {
        for (Song checkedSong : this.songs) {
            if (checkedSong.getTitle().equals(title)) {
                return checkedSong;
            }
        }
        return null;
    }


    /**
     * Add a song from album to the playlist given a tracknumber
     *
     * @param trackNumber the tracknumber of the song
     * @param playlist    the playlist to add the song to
     * @return true if successful, otherwise false
     */
    public boolean addToPlayList(int trackNumber, LinkedList<Song> playlist) {
        int index = trackNumber - 1;
        if ((index > 0) && (index <= this.songs.size())) {
            playlist.add(this.songs.get(index));
            return true;
        }
        System.out.println("This album does not have a track " + trackNumber);
        return false;
    }


    /**
     * Add a song from album to playlist given a song title
     *
     * @param title    the title of the song
     * @param playList the playlist to add the song to
     * @return true if successful
     */
    public boolean addToPlayList(String title, LinkedList<Song> playList) {
        Song checkedSong = findSong(title);
        if (checkedSong != null) {
            playList.add(checkedSong);
            return true;
        }
        System.out.println("The song " + title + " is not in this album");
        return false;
    }


}
