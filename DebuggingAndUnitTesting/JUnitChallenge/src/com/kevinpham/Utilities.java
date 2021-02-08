package com.kevinpham;

public class Utilities {

    // Returns a char array containing every nth char.
    // When sourceArray.length < n, return sourceArray
    public char[] everyNthChar(char[] sourceArray, int n) {

        if (sourceArray == null || sourceArray.length < n) {
            return sourceArray;
        }

        int returnedLength = sourceArray.length / n;
        char[] result = new char[returnedLength];
        int index = 0;

        for (int i = n - 1; i < sourceArray.length; i += n) {
            result[index++] = sourceArray[i];
        }
        return result;
    }


    // Removes pairs of the same character that are next to each other,
    // by removing on e occurences of the character.
    // "ABBCDEEF" -> "ABCDEF"
    // "ABCBDEEF" -> "ABCBDEF" (The two B's aren't next to each other)
    public String removePairs(String source) {

        // If length is less than 2, there won't be any pairs
        if (source.length() < 2) {
            return source;
        }

        StringBuilder sb = new StringBuilder();
        char[] string = source.toCharArray();

        // If current value doesn't equal to next value, add to StringBuilder sb
        for (int i = 0; i < string.length - 1; i++) {
            if (string[i] != string[i + 1]) {
                sb.append(string[i]);
            }
        }

        // Add the last character in the string as it is safe
        sb.append(string[string.length - 1]);
        return sb.toString();
    }


    // Perform a conversion based on internal business rule
    public int converter(int a, int b) {
        return (a / b) + (a * 30) - 2;
    }


    // Return source if even length, if odd return null
    public String nullIfOddLength(String source) {
        // Test if even in length
        if (source.length() % 2 == 0) {
            return source;
        }
        return null;
    }
}
