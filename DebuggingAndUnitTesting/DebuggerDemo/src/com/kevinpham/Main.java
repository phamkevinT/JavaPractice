package com.kevinpham;

public class Main {

    public static void main(String[] args) {

        StringUtilities utils = new StringUtilities();
        StringBuilder sb = new StringBuilder();
        // Add a single char 'a' to the string builder until length is 10
        while (sb.length() < 10) {
            utils.addChar(sb, 'a');
        }
        System.out.println(sb);
    }
}
