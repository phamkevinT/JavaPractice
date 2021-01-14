package com.kevinpham;

public class Vehicle {
    private String name;
    private String size;

    private int currentVelocity;
    private int currentDirection;

    public Vehicle(String name, String size) {
        this.name = name;
        this.size = size;

        this.currentVelocity = 0;
        this.currentDirection = 0;
    }


    /**
     * Steers the vehicle in a direction measured in degrees
     *
     * @param direction the degree of steering
     */
    public void steer(int direction) {
        this.currentDirection += direction;
        System.out.println("Vehicle.steer(): Steering at " + currentDirection + " degrees.");
    }


    /**
     * Prints the current velocity and direction that car is moving in
     *
     * @param velocity  the speed
     * @param direction
     */
    public void move(int velocity, int direction) {
        currentVelocity = velocity;
        currentDirection = direction;
        System.out.println("Vehicle.move(): Moving at  " + currentVelocity + " in direction " + currentDirection);

    }


    /**
     * Get the name of vehicle
     *
     * @return the name
     */
    public String getName() {
        return name;
    }


    /**
     * Get the size of the vehicle
     *
     * @return the size
     */
    public String getSize() {
        return size;
    }


    /**
     * Get the current velocity of the vehicle
     *
     * @return the velocity
     */
    public int getCurrentVelocity() {
        return currentVelocity;
    }


    /**
     * Get the current direction of the vehicle
     *
     * @return the direction in degrees
     */
    public int getCurrentDirection() {
        return currentDirection;
    }


    /**
     * Stops the vehicle and set velocity to zero
     */
    public void stop() {
        this.currentVelocity = 0;
    }
}
