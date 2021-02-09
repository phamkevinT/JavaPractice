package com.kevinpham;

import java.sql.*;

public class Main {

    public static void main(String[] args) {

        try {
            // Database connection & creation
            Connection conn = DriverManager.getConnection("jdbc:sqlite:D:\\github\\JavaMasterClass\\Database\\TestDB\\testjava.db");

            Statement statement = conn.createStatement();

            // Create the contacts table if it doesn't already exists
            statement.execute("CREATE TABLE IF NOT EXISTS contacts (name TEXT, phone INTEGER, email TEXT)");

            // Insert data into contacts table
//            statement.execute("INSERT INTO contacts (name, phone, email) VALUES ('Kevin', 4088923637, 'kevin@email.com')");
//            statement.execute("INSERT INTO contacts (name, phone, email) VALUES ('Joe', 4081234567, 'joe@email.com')");
//            statement.execute("INSERT INTO contacts (name, phone, email) VALUES ('Jane', 4085678901, 'jane@email.com')");
//            statement.execute("INSERT INTO contacts (name, phone, email) VALUES ('Tim', 09876541234, 'Tim@email.com')");

            // Updating data
//            statement.execute("UPDATE contacts SET phone=5554326789 WHERE name='Jane'");

            // Delete data
//            statement.execute("DELETE FROM contacts WHERE name='Tim'");

            // Loop and print record
            statement.execute("SELECT * FROM contacts");
            ResultSet results = statement.getResultSet();
            while (results.next()) {
                System.out.println(results.getString("name") + " " +
                        results.getString("phone") + " " +
                        results.getString("email"));
            }


            // Close resources
            results.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }


    }
}
