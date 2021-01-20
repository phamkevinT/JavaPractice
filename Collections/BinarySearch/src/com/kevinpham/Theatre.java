package com.kevinpham;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Theatre {

    private final String theatreName;
    private List<Seat> seats = new ArrayList<>();

    public Theatre(String theatreName, int numRows, int seatsPerRow) {
        this.theatreName = theatreName;

        int lastRow = 'A' + (numRows - 1);
        for (char row = 'A'; row <= lastRow; row++) {
            for (int seatNum = 1; seatNum <= seatsPerRow; seatNum++) {
                Seat seat = new Seat(row + String.format("%02d", seatNum));
                seats.add(seat);
            }
        }
    }


    /**
     * Get the theatre's name
     *
     * @return
     */
    public String getTheatreName() {
        return this.theatreName;
    }


    /**
     * Get the seats in the theatre
     */
    public void getSeats() {
        for (Seat seat : seats) {
            System.out.println(seat.getSeatNumber());
        }
    }


    /**
     * Reserve a seat if it is available
     *
     * @param seatNumber the seat to be reserved
     * @return true if successful, otherwise false
     */
    public boolean reserveSeat(String seatNumber) {

        // Create the requestedSeat based on given seat number
        Seat requestedSeat = new Seat(seatNumber);
        // Use built in function to search through list of seats for the requested seat
        int foundSeat = Collections.binarySearch(seats, requestedSeat, null);
        if (foundSeat >= 0) {
            return seats.get(foundSeat).reserve();
        } else {
            System.out.println("There is no seat " + seatNumber);
            return false;
        }


//        ***** Binary Search Code *****
//        ***** Used on ordered list
//        ***** 1. Sets a pivot points in the middle.
//        ***** 2. Compares to see which half the target lies in
//        ***** 3. Repeat Step 1 & 2.
//
//        int low = 0;
//        int high = seats.size() - 1;
//
//        while(low <= high) {
//            int mid = (low + high) / 2;
//            Seat midVal = seats.get(mid);
//            int cmp = midVal.getSeatNumber().compareTo(seatNumber);
//
//            // Comparison returns negative number, target lies in the right half
//            if(cmp < 0) {
//                low = mid + 1;
//            // Comparison returns positive number, target lies in the left half
//            } else if (cmp > 0) {
//                high = mid - 1;
//            // Comparison returns zero, target found
//            } else {
//                return seats.get(mid).reserve();
//            }
//        }
//        System.out.println("There is no seat " + seatNumber);
//        return false;
    }


    /**
     * Inner Class Seat
     */
    private class Seat implements Comparable<Seat> {
        private final String seatNumber;
        private boolean reserved = false;

        public Seat(String seatNumber) {
            this.seatNumber = seatNumber;
        }


        /**
         * Compares two seat numbers
         *
         * @param seat the seat to be compared to
         * @return positive if before, zero if equal, negative is after
         */
        @Override
        public int compareTo(Seat seat) {
            return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
        }


        /**
         * Reserve a seat
         *
         * @return true if successful, otherwise false
         */
        public boolean reserve() {
            if (!this.reserved) {
                this.reserved = true;
                System.out.println("Seat " + seatNumber + " reserved");
                return true;
            } else {
                return false;
            }
        }


        /**
         * Cancel a reserved seat
         *
         * @return true if successful, otherwise false
         */
        public boolean cancel() {
            if (this.reserved) {
                this.reserved = false;
                System.out.println("Reservation of seat " + seatNumber + " cancelled");
                return true;
            } else {
                return false;
            }
        }


        /**
         * Get the seat number
         *
         * @return the seat number
         */
        public String getSeatNumber() {
            return seatNumber;
        }

    }
}
