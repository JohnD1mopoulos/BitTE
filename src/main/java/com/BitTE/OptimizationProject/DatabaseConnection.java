package com.BitTE.OptimizationProject;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.tinylog.Logger;

public class DatabaseConnection {
    private static final String DB_PATH = "C:/sqlite/db/";
    private static final String DB_FILE = DB_PATH + "mydatabase.db";

    static {
        Logger.info("Initializing database directory check...");
        // Ensure the directory exists
        File dbDir = new File(DB_PATH);
        if (!dbDir.exists()) {
            if (dbDir.mkdirs()) {
                Logger.info("Database directory created: {}", DB_PATH);
            } else {
                Logger.error("Failed to create database directory: {}", DB_PATH);
            }
        } else {
            Logger.info("Database directory already exists: {}", DB_PATH);
        }
    }

    public static Connection getConnection() throws SQLException {
        Logger.info("Attempting to establish a database connection to: {}", DB_FILE);
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:" + DB_FILE);
            Logger.info("Database connection established successfully to: {}", DB_FILE);
            return connection;
        } catch (SQLException e) {
            Logger.error("Failed to establish database connection: {}", e.getMessage(), e);
            throw e;
        }
    }
}
