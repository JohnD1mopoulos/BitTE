/*
 * Copyright 2025 BitTE Team
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

 package com.BitTE.OptimizationProject;

 import java.io.File;
 import java.sql.Connection;
 import java.sql.DriverManager;
 import java.sql.SQLException;
 import org.tinylog.Logger;
 /**
  * Provides a centralized way to manage database connections, specifically to an SQLite database located in the specified directory.
  */
 public class DatabaseConnection {
    /**
    * The path to the directory where the SQLite database is stored.
    */
    private static final String DB_PATH = "C:/sqlite/db/";
    /**
    * The file path to the SQLite database within the specified directory.
    */
    private static final String DB_FILE = DB_PATH + "mydatabase.db";
     // Static initializer to ensure the database directory is prepared on class loading.
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
     /**
      * Establishes and returns a connection to the database.
      *
      * @return a Connection object to the SQLite database
      * @throws SQLException if a database access error occurs or the URL is null
      */
     public static Connection getConnection() throws SQLException {
         try {
             Connection connection = DriverManager.getConnection("jdbc:sqlite:" + DB_FILE);
             return connection;
         } catch (SQLException e) {
             Logger.error("Failed to establish database connection: {}", e.getMessage(), e);
             throw e;
         }
     }
 }
