package com.kevinpham;

import jdk.jshell.execution.Util;

import static org.junit.jupiter.api.Assertions.*;

class UtilitiesTest {

    @org.junit.jupiter.api.Test
    void everyNthChar() {
        Utilities util = new Utilities();
        char[] output = util.everyNthChar(new char[]{'h', 'e', 'l', 'l', 'o'}, 2); // Test basic functionality
        assertArrayEquals(new char[]{'e', 'l'}, output);

        char[] output2 = util.everyNthChar(new char[]{'h', 'e', 'l', 'l', 'o'}, 8); // Test when n > length
        assertArrayEquals(new char[]{'h', 'e', 'l', 'l', 'o'}, output2);
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
        Utilities util = new Utilities();
        assertEquals(300, util.converter(10, 5));
    }

    @org.junit.jupiter.api.Test
    void nullIfOddLength() {
        Utilities util = new Utilities();
        assertNull(util.nullIfOddLength("odd")); // Test odd length string -> Null
        assertNotNull(util.nullIfOddLength("even")); // Test even length string -> Not Null
    }
}