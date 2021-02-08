package com.kevinpham;

import static org.junit.jupiter.api.Assertions.*;

class UtilitiesTest {

    @org.junit.jupiter.api.Test
    void everyNthChar() {
        fail("This test has not been implemented.");
    }

    @org.junit.jupiter.api.Test
    void removePairs() {
        Utilities util = new Utilities();
        assertEquals("ABCDEF", util.removePairs("AABCDDEFF"));
        assertEquals("ABCABDEF", util.removePairs("ABCCABDEEF"));
    }

    @org.junit.jupiter.api.Test
    void converter() {
        fail("This test has not been implemented.");
    }

    @org.junit.jupiter.api.Test
    void nullIfOddLength() {
        fail("This test has not been implemented.");
    }
}