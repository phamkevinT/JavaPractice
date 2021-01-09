package com.kevinpham;

public class Hamburger {

    private String name;
    private String meat;
    private String breadRollType;
    private double price;

    private String addOnName1;
    private double addOnPrice1;

    private String addOnName2;
    private double addOnPrice2;

    private String addOnName3;
    private double addOnPrice3;

    private String addOnName4;
    private double addOnPrice4;

    public Hamburger(String name, String meat, String breadRollType, double price) {
        this.name = name;
        this.meat = meat;
        this.breadRollType = breadRollType;
        this.price = price;
    }


    public void addHamburgerAddition1(String name, double price) {
        this.addOnName1 = name;
        this.addOnPrice1 = price;
    }


    public void addHamburgerAddition2(String name, double price) {
        this.addOnName2 = name;
        this.addOnPrice2 = price;
    }


    public void addHamburgerAddition3(String name, double price) {
        this.addOnName3 = name;
        this.addOnPrice3 = price;
    }


    public void addHamburgerAddition4(String name, double price) {
        this.addOnName4 = name;
        this.addOnPrice4 = price;
    }


    public double calculatePrice() {
        double hamburgerPrice = this.price;

        System.out.println(this.name + " hamburger on a " + this.breadRollType + " roll with " + this.meat + ", price is " + this.price);

        if(addOnName1 != null) {
            hamburgerPrice += addOnPrice1;
            System.out.println("Added " + this.addOnName1 + " for an extra " + this.addOnPrice1);
        }

        if(addOnName2 != null) {
            hamburgerPrice += addOnPrice2;
            System.out.println("Added " + this.addOnName2 + " for an extra " + this.addOnPrice2);
        }

        if(addOnName3 != null) {
            hamburgerPrice += addOnPrice3;
            System.out.println("Added " + this.addOnName3 + " for an extra " + this.addOnPrice3);
        }

        if(addOnName4 != null) {
            hamburgerPrice += addOnPrice4;
            System.out.println("Added " + this.addOnName4 + " for an extra " + this.addOnPrice4);
        }

        return hamburgerPrice;
    }
}
