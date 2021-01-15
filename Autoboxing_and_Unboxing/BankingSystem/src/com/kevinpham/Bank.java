package com.kevinpham;

import java.util.ArrayList;

public class Bank {

    public String name;
    public ArrayList<Branch> branchList;

    public Bank(String name) {
        this.name = name;
        this.branchList = new ArrayList<Branch>();
    }


    /**
     * Add a new banking branch
     *
     * @param branchName the branch's name
     * @return true if successful, otherwise false
     */
    public boolean addBranch(String branchName) {
        if (findBranch(branchName) == null) { // Null if branch doesn't already exists
            this.branchList.add(new Branch(branchName));
            System.out.println(branchName + " branch has been created.");
            System.out.println();
            return true;
        }

        return false;
    }


    /**
     * Add a new customer to the banking branch
     *
     * @param branchName    the branch's name
     * @param customerName  the new customer's name
     * @param initialAmount the initial deposit amount
     * @return true if successful, otherwise false
     */
    public boolean addCustomerToBranch(String branchName, String customerName, double initialAmount) {
        Branch branch = findBranch(branchName);

        if (branch != null) {
            return branch.addNewCustomer(customerName, initialAmount);
        }

        return false;
    }


    /**
     * Add a transaction to an existing customer from an existing branch
     *
     * @param branchName   the branch's name
     * @param customerName the customer's name
     * @param amount       the amount
     * @return true if successful, otherwise false;
     */
    public boolean addCustomerTransaction(String branchName, String customerName, double amount) {
        Branch branch = findBranch(branchName);

        if (branch != null) {
            return branch.addCustomerTransaction(customerName, amount);
        }

        return false;
    }


    /**
     * Find an existing branch from list
     *
     * @param branchName the branch's name
     * @return the branch
     */
    private Branch findBranch(String branchName) {
        for (int i = 0; i < branchList.size(); i++) {
            Branch checkedBranch = this.branchList.get(i);
            if (checkedBranch.getName().equals(branchName)) {
                return checkedBranch;
            }
        }

        return null;
    }


    /**
     * Display all the customer's and optionally their transaction from a particular branking branch
     *
     * @param branchName       the branch's name
     * @param showTransactions true if wanting to display customer's transaction, otherwise false
     * @return true if successful, otherwise false;
     */
    public boolean listCustomers(String branchName, boolean showTransactions) {
        Branch branch = findBranch(branchName);
        if (branch != null) { // Not null if branch exists
            System.out.println("Customer details for branch " + branch.getName());

            ArrayList<Customer> branchCustomers = branch.getCustomersList();
            for (int i = 0; i < branchCustomers.size(); i++) {
                Customer existingCustomer = branchCustomers.get(i);

                System.out.println("Customer " + (i + 1) + ": " + existingCustomer.getName());

                if (showTransactions) {
                    System.out.println("Transactions");
                    ArrayList<Double> customerTransactions = existingCustomer.getTransactionHistory();
                    for (int j = 0; j < customerTransactions.size(); j++) {
                        System.out.println("[" + (j + 1) + "] Amount " + customerTransactions.get(j));
                    }
                }
                System.out.println();
            }
            return true;
        } else {
            return false;
        }
    }
}
