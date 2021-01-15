package com.kevinpham;

public class Main {

    public static void main(String[] args) {

        // Created a Bank
        Bank bank = new Bank("Wells Fargo");

        // Created a branch: San Jose East
        bank.addBranch("San Jose East");

        // Added customers to branch: San Jose East
        bank.addCustomerToBranch("San Jose East", "Kevin", 50.05);
        bank.addCustomerToBranch("San Jose East", "Richard", 175.34);
        bank.addCustomerToBranch("San Jose East", "Josh", 220.12);

        // Added a new branch: San Jose West
        bank.addBranch("San Jose West");

        // Added a customer to branch: San Jose West
        bank.addCustomerToBranch("San Jose West", "Alex", 150.54);

        // Added customer transaction to customers at branch: San Jose East
        bank.addCustomerTransaction("San Jose East", "Kevin", 44.22);
        bank.addCustomerTransaction("San Jose East", "Kevin", 12.44);
        bank.addCustomerTransaction("San Jose East", "Richard", 1.65);

        // Display list of customers at banks
        bank.listCustomers("San Jose East", true);
        bank.listCustomers("San Jose West", true);


        // Test Case: Adding a customer to a branch that does not exist
        if (!bank.addCustomerToBranch("San Jose North", "Andrew", 5.53)) {
            System.out.println("Error! San Jose North branch does not exists.");
            System.out.println();
        }

        // Test Case: Adding an already existing branch
        if (!bank.addBranch("San Jose East")) {
            System.out.println("Error! San Jose East branch already exists");
            System.out.println();
        }

        // Test Case: Adding a transaction to a branch with non-existing customer
        if (!bank.addCustomerTransaction("San Jose East", "Thanh", 442.12)) {
            System.out.println("Error! Customer Thanh does not exist at branch San Jose East");
            System.out.println();
        }

        // Test Case: Adding an already existing customer to branch
        if (!bank.addCustomerToBranch("San Jose East", "Kevin", 12.12)) {
            System.out.println("Error! Customer Kevin already exist at branch San Jose East");
            System.out.println();
        }
    }
}
