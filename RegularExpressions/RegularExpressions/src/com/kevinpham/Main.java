package com.kevinpham;

public class Main {

    public static void main(String[] args) {
        String string = "I am a string. Yes, I am.";
        System.out.println(string);
        // Replaces 'I' with 'You'
        String yourString = string.replaceAll("I", "You");
        System.out.println(yourString);

        String alphanumeric = "abcDeeeF12Ghhiiiijkl99z";
        String secondString = "abcDeeeF12GhhabcDeeeiiiijkl99z";

        // Replaces all letters and numbers with 'Y'
        System.out.println(alphanumeric.replaceAll(".", "Y"));
        // Replaces first instance of 'abcDee' with 'YYY'
        System.out.println(alphanumeric.replaceAll("^abcDeee", "YYY"));


        // Test the entire string as a whole matches
        System.out.println(alphanumeric.matches("^hello"));
        // Test the entire string as a whole matches
        System.out.println(alphanumeric.matches("^abcDeee"));
        // Test the entire string as a whole matches
        System.out.println(alphanumeric.matches("abcDeeeF12Ghhiiiijkl99z"));


        // Adds 'THE END' to end of regex
        System.out.println(alphanumeric.replaceAll("ijkl99z$", "THE END"));
        // Replaces letters 'a' 'e' 'i' with 'X'
        System.out.println(alphanumeric.replaceAll("[aei]", "X"));
        // Replaces letters 'a' 'e' 'i' with 'I replaced a letter here'
        System.out.println(alphanumeric.replaceAll("[aei]", "I replaced a letter here"));
        // Replaces one of the letters 'a' 'e' 'i' if they are followed by an 'F' or 'j'
        System.out.println(alphanumeric.replaceAll("[aei][Fj]", "X"));

        // Replaces both (upper and lowercase) 'Harry' and 'harry' with 'Harry'
        System.out.println("harry".replaceAll("[Hh]arry", "Harry"));


        String newAlphanumeric = "abcDeeeF12Ghhiiiijkl99z";

        // Replaces everything except 'e' and 'j'
        System.out.println(newAlphanumeric.replaceAll("[^ej]", "X"));
        // Replaces letters and numbers in 'abcdef345678' with X
        System.out.println(newAlphanumeric.replaceAll("[abcdef345678]", "X"));
        // Short hand form of replacing 'abcdef345678' including uppercase
        System.out.println(newAlphanumeric.replaceAll("[a-fA-F3-8]", "X"));
        // Ignore capitalization and replace
        System.out.println(newAlphanumeric.replaceAll("(?i)[a-f3-8]", "X"));
        // Replace numbers
        System.out.println(newAlphanumeric.replaceAll("[0-9]", "X"));
        // Replace only non-alphabetical
        System.out.println(newAlphanumeric.replaceAll("\\d", "X"));
        // Replace only alphabetical
        System.out.println(newAlphanumeric.replaceAll("\\D", "X"));



        String hasWhitespace = "I have blanks and\ta tab, and also a newline\n";
        System.out.println(hasWhitespace);

        // Replace white spaces (lowercase S)
        System.out.println(hasWhitespace.replaceAll("\\s", ""));
        // Replace tabs
        System.out.println(hasWhitespace.replaceAll("\t", "X"));
        // Replace all non-white spaces (uppercase S)
        System.out.println(hasWhitespace.replaceAll("\\S", ""));
        // Replace all white spaces and characters (lowercase w)
        System.out.println(newAlphanumeric.replaceAll("\\w", "X"));
        // Replaces all words non-white spaces with X (uppercase W)
        System.out.println(hasWhitespace.replaceAll("\\w", "X"));
        // Add 'X' before and after every word
        System.out.println(hasWhitespace.replaceAll("\\b", "X"));
    }
}
