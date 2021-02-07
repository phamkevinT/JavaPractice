package com.kevinpham;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    private BankAccount account;
    private static int count;

    @org.junit.jupiter.api.BeforeAll
    public static void beforeClass() {
        System.out.println("This executes before any test cases. Count = " + count++);
    }


    // 'BeforeEach' runs this every time we run a test
    @org.junit.jupiter.api.BeforeEach
    public void setUp() {
        // Created an account
        account = new BankAccount("Kevin", "Pham", 1000, BankAccount.CHECKING);
        System.out.println("Running a test...");
    }


    @org.junit.jupiter.api.Test
    void deposit() {

        // Deposited 200 to the account
        double balance = account.deposit(200, true);
        // Testing the expected value and whats in the current balance. Delta (3rd param) is the accepted variance
        assertEquals(1200, balance, 0);
    }


    @org.junit.jupiter.api.Test
    void withdraw_branch() {
        double balance = account.withdraw(600, true);
        assertEquals(400, balance, 0);
    }


    @org.junit.jupiter.api.Test
    void withdraw_notBranch() {
        // Will pass the test if IllegalArgumentException is thrown
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(600, false);
        });
    }


    @org.junit.jupiter.api.Test
    void getBalance_deposit() {

        // Deposited 200 to the account
        account.deposit(200, true);
        // Testing the getBalance() to return the correct balance
        assertEquals(1200, account.getBalance(), 0);
    }


    @org.junit.jupiter.api.Test
    void getBalance_withdraw() {

        // Withdraw 200 to the account
        account.withdraw(200, true);
        // Testing the getBalance() to return the correct balance
        assertEquals(800, account.getBalance(), 0);
    }


    @org.junit.jupiter.api.Test
    public void isChecking_true() {

        // Testing if the account is a Checking Account
        assertTrue(account.isChecking(), "The account is NOT a checking account");
    }


    @org.junit.jupiter.api.AfterAll
    public static void afterClass() {
        System.out.println("This executes after any test cases. Count = " + count++);
    }


    @org.junit.jupiter.api.AfterEach
    public void teardown() {
        System.out.println("Count = " + count++);
    }
}

/*

    JUnit Assertion Methods

    1. assertNotEquals() - when we don't want the actual value to equal to a specific value

    2. assertArrayEquals() - verify the value of an array. Cannot use assertEquals() b/c it will only consider
    two arrays equal if they are the same instance. assertArrayEquals() considers two arrays equals when their
    length are the same, and every element in both arrays is the same and in same order

    3. assertNull() and assertNotNull() - check for null (and non-null) values

    4. assertSame() and assertNotSame() - check whether two instances are the same instance. assertEquals() tests
    for equality. assertSame() compares object references

    5. assertThat() - compares actual value against a matcher (not matcher in JDK but in JUnit matcher class)


 */