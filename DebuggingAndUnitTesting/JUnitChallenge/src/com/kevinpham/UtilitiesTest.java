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
        assertEquals("ABCDEF", util.removePairs("AABCDDEFF")); // Pair
        assertEquals("ABCABDEF", util.removePairs("ABCCABDEEF")); // Extra occurrence but not pair
        assertNull(null, util.removePairs(null)); // Null
        assertEquals("A", util.removePairs("A")); // Single char
        assertEquals("", util.removePairs("")); // Empty string



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