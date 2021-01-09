package com.kevinpham;

public class HealthyBurger extends Hamburger{

    private String healthyAddOnName1;
    private double healthyAddOnPrice1;

    private String healthyAddOnName2;
    private double healthyAddOnPrice2;

    public HealthyBurger(String meat, double price) {
        super("Healthy", meat, "Wheat", price);
    }


    public void addHealthyAddOn1(String name, double price) {
        this.healthyAddOnName1 = name;
        this.healthyAddOnPrice1 = price;
    }


    public void addHealthyAddOn2(String name, double price) {
        this.healthyAddOnName2 = name;
        this.healthyAddOnPrice2 = price;
    }


    @Override
    public double calculatePrice() {
        double hamburgerPrice = super.calculatePrice();

        if(this.healthyAddOnName1 != null) {
            hamburgerPrice += this.healthyAddOnPrice1;
            System.out.println("Added " + this.healthyAddOnName1 + " for an extra " + this.healthyAddOnPrice1);
        }

        if(this.healthyAddOnName2 != null) {
            hamburgerPrice += this.healthyAddOnPrice2;
            System.out.println("Added " + this.healthyAddOnName2 + " for an extra " + this.healthyAddOnPrice2);
        }

        return hamburgerPrice;
    }
}
