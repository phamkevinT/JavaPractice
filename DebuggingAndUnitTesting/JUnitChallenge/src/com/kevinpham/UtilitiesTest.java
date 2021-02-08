package com.kevinpham;

import static org.junit.jupiter.api.Assertions.*;

class UtilitiesTest {

    private Utilities util;

    @org.junit.jupiter.api.BeforeEach
    public void setup() {
        util = new Utilities();
    }

    @org.junit.jupiter.api.Test
    void everyNthChar() {
        char[] output = util.everyNthChar(new char[]{'h', 'e', 'l', 'l', 'o'}, 2); // Test basic functionality
        assertArrayEquals(new char[]{'e', 'l'}, output);

        char[] output2 = util.everyNthChar(new char[]{'h', 'e', 'l', 'l', 'o'}, 8); // Test when n > length
        assertArrayEquals(new char[]{'h', 'e', 'l', 'l', 'o'}, output2);
    }

    @org.junit.jupiter.api.Test
    void removePairs() {
        assertEquals("ABCDEF", util.removePairs("AABCDDEFF")); // Pair
        assertEquals("ABCABDEF", util.removePairs("ABCCABDEEF")); // Extra occurrence but not pair
        assertNull(null, util.removePairs(null)); // Null
        assertEquals("A", util.removePairs("A")); // Single char
        assertEquals("", util.removePairs("")); // Empty string
    }

    @org.junit.jupiter.api.Test
    void converter() {
        assertEquals(300, util.converter(10, 5));
    }

    @org.junit.jupiter.api.Test
    void converter_arithmeticException() {
        assertThrows(ArithmeticException.class, () -> util.converter(10, 0));
    }

    @org.junit.jupiter.api.Test
    void nullIfOddLength() {
        assertNull(util.nullIfOddLength("odd")); // Test odd length string -> Null
        assertNotNull(util.nullIfOddLength("even")); // Test even length string -> Not Null
    }
}