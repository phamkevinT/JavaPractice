package com.kevinpham;

import java.util.ArrayList;

public class Customer {

    private String name;
    private ArrayList<Double> transactionHistory;

    public Customer(String name, double transactionAmount) {
        this.name = name;
        this.transactionHistory = new ArrayList<Double>();
        addTransaction(transactionAmount);
    }


    /**
     * Add a customer's transaction to their transactionHistory
     *
     * @param amount the transaction amount
     */
    public void addTransaction(double amount) {
        this.transactionHistory.add(amount);
    }


    /**
     * Get the customer's name
     *
     * @return the customer's name
     */
    public String getName() {
        return name;
    }


    /**
     * Get the customer's transaction history
     *
     * @return the list of transaction
     */
    public ArrayList<Double> getTransactionHistory() {
        return transactionHistory;
    }
}
