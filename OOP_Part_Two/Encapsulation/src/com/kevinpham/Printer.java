package com.kevinpham;

public class Printer {
    private int tonerLevel;
    private int pagesPrinted;
    private boolean duplex;

    public Printer(int tonerLevel, boolean duplex) {
        if (tonerLevel > -1 && tonerLevel <= 100) {
            this.tonerLevel = tonerLevel;
        } else {
            this.tonerLevel = -1;
        }

        this.duplex = duplex;
        this.pagesPrinted = 0;
    }


    /**
     * Add toner to the printer
     * @param tonerAmount the amount of toner to be added
     * @return the toner level
     */
    public int addToner(int tonerAmount) {
        if (tonerAmount > 0 && tonerAmount <= 100) {
            if (this.tonerLevel + tonerAmount > 100) {
                return -1;
            }
            this.tonerLevel += tonerAmount;
            return this.tonerLevel;
        } else {
            return -1;
        }
    }


    /**
     * Print pages based on if printer is duplex or not
     * @param pages amount of pages to be printed
     * @return number of pages to print after considering duplex or not
     */
    public int printPages(int pages) {
        int pagesToPrint = pages;
        if (this.duplex) {
            pagesToPrint = (pages / 2) + (pages % 2);
            System.out.println("Printing in duplex mode");
        }
        this.pagesPrinted += pagesToPrint;
        return pagesToPrint;
    }


    /**
     * The number of pages printed
     * @return number of pages
     */
    public int getPagesPrinted() {
        return pagesPrinted;
    }
}
