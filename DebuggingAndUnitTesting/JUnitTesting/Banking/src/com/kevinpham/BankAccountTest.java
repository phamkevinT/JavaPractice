package com.kevinpham;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @org.junit.jupiter.api.Test
    void deposit() {

        // Created an account
        BankAccount account = new BankAccount("Kevin", "Pham", 1000);
        // Deposited 200 to the account
        double balance = account.deposit(200, true);
        // Testing the expected value and whats in the current balance. Delta (3rd param) is the accepted variance
        assertEquals(1200, balance, 0);
    }

    @org.junit.jupiter.api.Test
    void withdraw() {
        fail("This test has yet to be implemented");
    }

    @org.junit.jupiter.api.Test
    void getBalance_deposit() {

        // Created an account
        BankAccount account = new BankAccount("Kevin", "Pham", 1000);
        // Deposited 200 to the account
        account.deposit(200, true);
        // Testing the getBalance() to return the correct balance
        assertEquals(1200, account.getBalance(), 0);
    }

    @org.junit.jupiter.api.Test
    void getBalance_withdraw() {

        // Created an account
        BankAccount account = new BankAccount("Kevin", "Pham", 1000);
        // Withdraw 200 to the account
        account.withdraw(200, true);
        // Testing the getBalance() to return the correct balance
        assertEquals(800, account.getBalance(), 0);
    }


}