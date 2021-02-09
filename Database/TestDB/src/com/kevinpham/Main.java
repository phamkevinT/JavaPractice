package com.kevinpham;

import java.sql.*;

public class Main {

    public static void main(String[] args) {

        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:D:\\github\\JavaMasterClass\\Database\\TestDB\\testjava.db");
        } catch (SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }
}
