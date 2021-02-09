package com.kevinpham;

import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class Main {

    public static final String DB_NAME = "testjava.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:D:\\github\\JavaMasterClass\\Database\\TestDB\\" + DB_NAME;
    public static final String TABLE_CONTACTS = "contacts";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PHONE = "phone";
    public static final String COLUMN_EMAIL = "email";

    public static void main(String[] args) {

        try {
            // Database connection & creation
            Connection conn = DriverManager.getConnection(CONNECTION_STRING);

            // Query Statement
            Statement statement = conn.createStatement();

            // Drop table if it exists
            statement.execute("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
            // Create the contacts table if it doesn't already exists
            statement.execute(
                    "CREATE TABLE IF NOT EXISTS " + TABLE_CONTACTS + "(" +
                            COLUMN_NAME + " TEXT, " +
                            COLUMN_PHONE + " INTEGER, " +
                            COLUMN_EMAIL + " TEXT)"
            );

            // Inserting data
            insertContacts(statement, "Kevin", 8923637, "kevin@email.com");
            insertContacts(statement, "Joe", 1234567, "joe@email.com");
            insertContacts(statement, "Jane", 5678901, "jane@email.com");
            insertContacts(statement, "Fido", 5462347, "fido@email.com");

            // Updating data
            statement.execute("UPDATE " + TABLE_CONTACTS + " SET " + COLUMN_PHONE + "=5554326789 WHERE " + COLUMN_NAME + "='Jane'");

            // Delete data
            statement.execute("DELETE FROM " + TABLE_CONTACTS + " WHERE " + COLUMN_NAME + "='Tim'");

            // Loop and print record
            ResultSet results = statement.executeQuery("SELECT * FROM " + TABLE_CONTACTS);
            while (results.next()) {
                System.out.println(results.getString(COLUMN_NAME) + " " +
                        results.getString(COLUMN_PHONE) + " " +
                        results.getString(COLUMN_EMAIL));
            }

            // Close resources
            results.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }


    private static void insertContacts(Statement statement, String name, int phone, String email) throws SQLException {

        statement.execute(
                "INSERT INTO " + TABLE_CONTACTS + " (" +
                        COLUMN_NAME + ", " +
                        COLUMN_PHONE + ", " +
                        COLUMN_EMAIL + ")" +
                        "VALUES ('" + name + "', " + phone + ", '" + email + "')"
        );
    }
}
