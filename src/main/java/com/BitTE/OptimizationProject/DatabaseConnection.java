package com.BitTE.OptimizationProject;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String DB_PATH = "C:/sqlite/db/";
    private static final String DB_FILE = DB_PATH + "mydatabase.db";

    static {
        // Ensure the directory exists
        File dbDir = new File(DB_PATH);
        if (!dbDir.exists()) {
            if (dbDir.mkdirs()) {
                System.out.println("Database directory created: " + DB_PATH);
            } else {
                System.err.println("Failed to create database directory: " + DB_PATH);
            }
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:sqlite:" + DB_FILE);
    }
}