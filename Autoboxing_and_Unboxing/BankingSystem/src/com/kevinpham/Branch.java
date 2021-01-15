package com.kevinpham;

import java.util.ArrayList;

public class Branch {

    private String name;
    private ArrayList<Customer> customersList;

    public Branch(String name) {
        this.name = name;
        this.customersList = new ArrayList<Customer>();
    }


    /**
     * Get the name of the branch
     *
     * @return the name
     */
    public String getName() {
        return name;
    }


    /**
     * Get the list of customer from this banking branch
     *
     * @return the list of customer
     */
    public ArrayList<Customer> getCustomersList() {
        return customersList;
    }


    /**
     * Add a new customer to the branch if customer's name doesn't already exists
     *
     * @param customerName  the new customer's name
     * @param initialAmount the initial deposit
     * @return true if successful, otherwise false
     */
    public boolean addNewCustomer(String customerName, double initialAmount) {
        if (findCustomer(customerName) == null) { // Null if customer doesn't already exists
            this.customersList.add(new Customer(customerName, initialAmount));
            return true;
        }

        return false;
    }


    /**
     * Add a transaction amount to an existing customer
     *
     * @param customerName the existing customer's name
     * @param amount       the transaction amount to be added
     * @return true if successful, otherwise false
     */
    public boolean addCustomerTransaction(String customerName, double amount) {
        Customer existingCustomer = findCustomer(customerName);

        if (existingCustomer != null) { // Not null if customer does exists
            existingCustomer.addTransaction(amount);
            return true;
        }

        return false;
    }


    /**
     * Find an existing customer from the list
     *
     * @param customerName the name of customer to be found
     * @return the customer
     */
    private Customer findCustomer(String customerName) {
        for (int i = 0; i < customersList.size(); i++) {
            Customer checkedCustomer = this.customersList.get(i);
            if (checkedCustomer.getName().equals(customerName)) {
                return checkedCustomer;
            }
        }

        return null;
    }
}
