package com.kevinpham;

public class DeluxeBurger extends Hamburger{

    public DeluxeBurger() {
        super("Deluxe", "Beef", "white", 12.50);
        super.addHamburgerAddition1("Chips", 2.25);
        super.addHamburgerAddition2("Drink", 1.25);
    }

    @Override
    public void addHamburgerAddition1(String name, double price) {
        System.out.println("Cannot add additional add-ons to the Deluxe Hamburger.");
    }

    @Override
    public void addHamburgerAddition2(String name, double price) {
        System.out.println("Cannot add additional add-ons to the Deluxe Hamburger.");
    }

    @Override
    public void addHamburgerAddition3(String name, double price) {
        System.out.println("Cannot add additional add-ons to the Deluxe Hamburger.");
    }

    @Override
    public void addHamburgerAddition4(String name, double price) {
        System.out.println("Cannot add additional add-ons to the Deluxe Hamburger.");
    }
}
