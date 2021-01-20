package com.kevinpham;

public class Main {

    public static void main(String[] args) {
        Theatre theatre = new Theatre("Olympian", 8, 12);

//        theatre.getSeats();

        if (theatre.reserveSeat("B10")) {
            System.out.println("Please pay");
        } else {
            System.out.println("Sorry, seat is taken");
        }

    }
}

