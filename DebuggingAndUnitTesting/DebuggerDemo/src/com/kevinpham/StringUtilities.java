package com.kevinpham;

public class StringUtilities {

    private StringBuilder sBuilder = new StringBuilder();
    private int charsAdded = 0;

    public void addChar(StringBuilder sBuilder, char c) {
        // This line is where the error occurs because it is updating the StringUtilties's sBuilder not the one being passed though the method
//        this.sBuilder.append(c);
        sBuilder.append(c);
        charsAdded++;
    }
}
