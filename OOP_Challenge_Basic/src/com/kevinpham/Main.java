package com.kevinpham;

//  The purpose of this application is to help a company called Bill's Burgers manage the process of selling their hamburger.
//
//  For the base Hamburger class, there are four variables to represent the four basic ingredients of the hamburger, (name, meat, price, breadRollType)
//
//  There are 4 separate variables that are additional add-ons to the hamburger.
//
//  Four methods are needed for adding the 4 different add-ons. Each method takes in a 'name' and a 'price'.
//  Another method calculates the hamburger's price including any add-ons.
//
//
//  A second class DeluxeBurger, without any member variables, is needed for another type of burger. This class has a constructor
//  without any parameters. The DeluxeBurger comes with chips and a drink. However, no additional add-ons can be added.class
//
//  A third class HealthyBurger allows for 2 additional healthy add-ons.

public class Main {

    public static void main(String[] args) {

        Hamburger basicHamburger  = new Hamburger("Basic", "Beef", "White", 8.55);
        basicHamburger.addHamburgerAddition1("Tomato", 0.27);
        basicHamburger.addHamburgerAddition2("Lettuce", 0.31);
        basicHamburger.addHamburgerAddition3("Cheese", 1.05);
        System.out.println("Total burger price is " + basicHamburger.calculatePrice());

        System.out.println();

        HealthyBurger healthyBurger = new HealthyBurger("Chicken", 5.67);
        healthyBurger.addHealthyAddOn1("Egg", 2.50);
        healthyBurger.addHealthyAddOn2("Lentils", 1.75);
        System.out.println("Total burger price is " + healthyBurger.calculatePrice());

        System.out.println();


        DeluxeBurger deluxeBurger = new DeluxeBurger();
        deluxeBurger.addHamburgerAddition1("Cannot add additional add-ons", 50.50);
        System.out.println("Total burger price is " + deluxeBurger.calculatePrice());
    }
}
