package com.kevinpham;

import java.util.*;

public class Main {

    private static ArrayList<Album> myAlbums = new ArrayList<>();

    public static void main(String[] args) {

        Album album = new Album("Stormbringer", "Deep Purple");
        album.addSong("Stormbringer", 4.6);
        album.addSong("Love don't mean a thing", 4.22);
        album.addSong("Holy man", 4.3);
        album.addSong("Hold on", 5.6);
        album.addSong("Lady double dealer", 3.21);
        album.addSong("You can't do it right", 6.23);
        album.addSong("High ball shooter", 4.27);
        album.addSong("The gypsy", 4.2);
        album.addSong("Soldier of fortune", 3.13);
        myAlbums.add(album);


        album = new Album("For those about to rock", "AC/DC");
        album.addSong("For those about to rock", 5.44);
        album.addSong("I put the finger on you", 3.25);
        album.addSong("Lets go", 3.45);
        album.addSong("Inject the venom", 3.33);
        album.addSong("Snowballed", 4.51);
        album.addSong("Evil walks", 3.45);
        album.addSong("C.O.D.", 5.25);
        album.addSong("Breaking the rules", 5.32);
        album.addSong("Night of the long knives", 5.12);
        myAlbums.add(album);


        LinkedList<Song> playList = new LinkedList<Song>();

        myAlbums.get(0).addToPlayList("You can't do it right", playList);
        myAlbums.get(0).addToPlayList("Holy man", playList);
        myAlbums.get(0).addToPlayList("Speed king", playList);  // Does not exist
        myAlbums.get(0).addToPlayList(9, playList);
        myAlbums.get(1).addToPlayList(8, playList);
        myAlbums.get(1).addToPlayList(3, playList);
        myAlbums.get(1).addToPlayList(2, playList);
        myAlbums.get(1).addToPlayList(24, playList);  // There is no track 24

        play(playList);
    }


    private static void play(LinkedList<Song> playList) {
        Scanner scanner = new Scanner(System.in);

        boolean quit = false;
        boolean goingForward = true;    // Determine if we are going forward or backward in the playlist

        ListIterator<Song> listIterator = playList.listIterator();

        if (playList.size() == 0) {
            System.out.println("No songs in the playlist.");
            return;
        } else {
            System.out.println("Now playing " + listIterator.next().toString());
            printMenu();
        }

        while (!quit) {
            int options = scanner.nextInt();
            scanner.nextLine();

            switch (options) {
                // Stopping the playlist
                case 0:
                    System.out.println("Playlist complete.");
                    quit = true;
                    break;

                // Skipping to next song
                case 1:
                    // If we are currently going backward, set flag to going forward (true)
                    if (!goingForward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        goingForward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now playing " + listIterator.next().toString());
                    } else {
                        System.out.println("We have reached the end of the playlist");
                        goingForward = false;
                    }
                    break;

                // Going back to previous song
                case 2:
                    // If we are currently going forward, set flag to going backwards (false)
                    if (goingForward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        goingForward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now playing " + listIterator.previous().toString());
                    } else {
                        System.out.println("We are at the start of the playlist");
                        goingForward = true;
                    }
                    break;

                // Replay the current song
                case 3:
                    if (goingForward) {
                        if (listIterator.hasPrevious()) {
                            System.out.println("Now replaying " + listIterator.previous().toString());
                            goingForward = false;
                        } else {
                            System.out.println("We are at the start of the list");
                        }
                    } else {
                        if (listIterator.hasNext()) {
                            System.out.println("Now replaying " + listIterator.next().toString());
                            goingForward = true;
                        } else {
                            System.out.println("We have reached the end of the list");
                        }
                    }
                    break;

                // Print songs in the playlist
                case 4:
                    printList(playList);
                    break;

                // Print menu options
                case 5:
                    printMenu();
                    break;

                // Delete a song from playlist
                case 6:
                    if (playList.size() > 0) {
                        listIterator.remove();
                        if (listIterator.hasNext()) {
                            System.out.println("Now playing " + listIterator.next());
                        } else if (listIterator.hasPrevious()) {
                            System.out.println("Now playing " + listIterator.previous());
                        }
                    }
                    break;
            }
        }
    }


    /**
     * Prints the menu options for user
     */
    private static void printMenu() {
        System.out.println("Available actions:\npress");
        System.out.println("0 - to quit\n" +
                "1 - to play next song\n" +
                "2 - to play previous song\n" +
                "3 - to replay the current song\n" +
                "4 - list songs in the playlist\n" +
                "5 - print available actions.\n" +
                "6 - delete current song from playlist");

    }


    /**
     * Print the list of songs in playlist
     * @param playList the playlist
     */
    private static void printList(LinkedList<Song> playList) {
        Iterator<Song> iterator = playList.iterator();
        System.out.println("================================");
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("================================");
    }
}
