package com.kevinpham;

public class Main {

    public static void main(String[] args) {

        /*
         * New class Account
         * 5 fields: account number, balance, customer name, email, phone number
         * Create getters and setters for each field
         * Create two additional methods
         * 1. To allow customer to deposit funds (increase fund)
         * 2. To allow customer to withdraw funds (deduct fund)
         */
        Account bobsAccount = new Account("12345", 0.00, "Bob Brown", "bob@email.com", "(408) 123-4567");
        System.out.println(bobsAccount.getNumber());
        System.out.println(bobsAccount.getBalance());

        bobsAccount.withdrawal(100.00);

        bobsAccount.deposit(50.0);
        bobsAccount.withdrawal(100.00);

        bobsAccount.deposit(51.0);
        bobsAccount.withdrawal(100.00);


        Account kevinsAccount = new Account("Kevin", "kevin@email.com", "(408) 892-3637");
        System.out.println("Account Number: " + kevinsAccount.getNumber() + " Name: " + kevinsAccount.getCustomerName());
        System.out.println("Current balance is " + kevinsAccount.getBalance());

        kevinsAccount.withdrawal(100.55);

        /*
         * New class VipPerson
         * 3 fields: name, credit limit, email address
         * 3 constructors
         * 1st constructor empty should call the constructor with 3 parameters with default values
         * 2nd constructor should pass on the 2 values it receives and add a default value for the 3rd
         * 3rd constructor should save all fields
         * Create only getters, no setters
         */
        VipPerson person1 = new VipPerson();
        System.out.println(person1.getName());

        VipPerson person2 = new VipPerson("Bob", 25000.00);
        System.out.println(person2.getName());

        VipPerson person3 = new VipPerson("Kevin", 100.00, "kevin@email.com");
        System.out.println(person3.getName());
        System.out.println(person3.getEmailAddress());

    }
}
