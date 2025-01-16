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

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.tinylog.Logger;

public class DatabaseTableCreation {
    private String url = "jdbc:sqlite:C:/sqlite/db/mydatabase.db"; // Database connection URL

    public DatabaseTableCreation() {
        Logger.info("Initializing database creation and data insertion process...");
        initializeDatabase();
    }

    private void initializeDatabase() {
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {

            Logger.info("Connected to the database: {}", url);

            // Create tables
            createTables(stmt);

            // Check and insert data if tables are empty
            if(isTableEmpty(conn, "EXTRAS")) {
                insertDataIntoExtras(stmt);
            }
            if(isTableEmpty(conn, "CLOTHING")) {
                insertDataIntoClothing(stmt);
            }

        } catch (SQLException e) {
            Logger.error("Database initialization failed: {}", e.getMessage(), e);
        }
    }

    private void createTables(Statement stmt) throws SQLException {
        String sqlClothing = "CREATE TABLE IF NOT EXISTS Clothing (" +
                             "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                             "type TEXT NOT NULL, " +
                             "gender TEXT NOT NULL CHECK (gender IN ('M', 'F')), " +
                             "size TEXT NOT NULL CHECK (size IN ('S', 'M', 'L')), " +
                             "volume FLOAT NOT NULL, " +
                             "weight FLOAT NOT NULL);";
        stmt.execute(sqlClothing);
        Logger.info("Table 'Clothing' created or already exists.");

        String sqlExtras = "CREATE TABLE IF NOT EXISTS Extras (" +
                           "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                           "type TEXT NOT NULL, " +
                           "size TEXT NOT NULL CHECK (size IN ('S', 'M', 'L')), " +
                           "volume FLOAT NOT NULL, " +
                           "weight FLOAT NOT NULL);";
        stmt.execute(sqlExtras);
        Logger.info("Table 'Extras' created or already exists.");
    }

    private boolean isTableEmpty(Connection conn, String tableName) throws SQLException {
        try (ResultSet rs = conn.createStatement().executeQuery("SELECT EXISTS (SELECT 1 FROM " + tableName + ")")) {
            return !rs.next() || rs.getInt(1) == 0;
        }
    }

    private void insertDataIntoExtras(Statement stmt) throws SQLException {
        // Insert data into Extras
        String insertExtras = "INSERT INTO EXTRAS (type, size, volume, weight) VALUES " +
                              "('Passport', 'S', 35.1, 45), " +
                              "('Passport', 'M', 35.1, 45), " +
                              "('Passport', 'L', 35.1, 45), " +
                              "('Computer', 'S', 1344, 1600), " +
                              "('Computer', 'M', 1680, 2000), " +
                              "('Computer', 'L', 2016, 2400), " +
                              "('Book', 'S', 1200, 640), " +
                              "('Book', 'M', 1500, 800), " +
                              "('Book', 'L', 1800, 960);";
        stmt.execute(insertExtras);
        Logger.info("Data inserted into 'Extras' table.");
    }

    private void insertDataIntoClothing(Statement stmt) throws SQLException {
        // Insert data into Clothing
        String insertClothing = "INSERT INTO Clothing (type, gender, size, volume, weight) VALUES " +
                         "('T-Shirt', 'M', 'S', 1400, 130), " +
                         "('T-Shirt', 'M', 'M', 1680, 150), " +
                         "('T-Shirt', 'M', 'L', 2475, 180), " +
                         "('Shirt', 'M', 'S', 1750, 140), " +
                         "('Shirt', 'M', 'M', 2520, 160), " +
                         "('Shirt', 'M', 'L', 3465, 190), " +
                         "('Hoodie', 'M', 'S', 4500, 500), " +
                         "('Hoodie', 'M', 'M', 6916, 600), " +
                         "('Hoodie', 'M', 'L', 9225, 700), " +
                         "('Jeans', 'M', 'S', 2475, 700), " +
                         "('Jeans', 'M', 'M', 4032, 800), " +
                         "('Jeans', 'M', 'L', 5130, 900), " +
                         "('Sweatpants', 'M', 'S', 4620, 500), " +
                         "('Sweatpants', 'M', 'M', 7020, 600), " +
                         "('Sweatpants', 'M', 'L', 9405, 700), " +
                         "('Trousers', 'M', 'S', 2062.5, 600), " +
                         "('Trousers', 'M', 'M', 3528.0, 700), " +
                         "('Trousers', 'M', 'L', 5130.0, 800), " +
                         "('Boxers', 'M', 'S', 468, 60), " +
                         "('Boxers', 'M', 'M', 750, 70), " +
                         "('Boxers', 'M', 'L', 1035, 80), " +
                         "('Shorts', 'M', 'S', 828, 200), " +
                         "('Shorts', 'M', 'M', 1250, 250), " +
                         "('Shorts', 'M', 'L', 1092, 300), " +
                         "('Sneakers', 'M', 'S', 6409, 800), " +
                         "('Sneakers', 'M', 'M', 7812, 900), " +
                         "('Sneakers', 'M', 'L', 9120, 1000), " +
                         "('Sandals', 'M', 'S', 4176, 500), " +
                         "('Sandals', 'M', 'M', 5270, 600), " +
                         "('Sandals', 'M', 'L', 6912, 700), " +
                         "('Boots', 'M', 'S', 7395, 1300), " +
                         "('Boots', 'M', 'M', 9486, 1500), " +
                         "('Boots', 'M', 'L', 10944, 1800), " +
                         "('Socks', 'M', 'S', 50, 50), " +
                         "('Socks', 'M', 'M', 90, 60), " +
                         "('Socks', 'M', 'L', 105.625, 70), " +
                         "('T-Shirt', 'F', 'S', 750, 100), " +
                         "('T-Shirt', 'F', 'M', 1288, 120), " +
                         "('T-Shirt', 'F', 'L', 1500, 140), " +
                         "('Shirt', 'F', 'S', 1000, 110), " +
                         "('Shirt', 'F', 'M', 1610, 130), " +
                         "('Shirt', 'F', 'L', 2250, 150), " +
                         "('Hoodie', 'F', 'S', 3795, 450), " +
                         "('Hoodie', 'F', 'M', 5850, 550), " +
                         "('Hoodie', 'F', 'L', 7980, 650), " +
                         "('Jeans', 'F', 'S', 2100, 500), " +
                         "('Jeans', 'F', 'M', 3360, 600), " +
                         "('Jeans', 'F', 'L', 4455, 700), " +
                         "('Sweatpants', 'F', 'S', 3750, 400), " +
                         "('Sweatpants', 'F', 'M', 6006, 500), " +
                         "('Sweatpants', 'F', 'L', 8100, 600), " +
                         "('Trousers', 'F', 'S', 2062.5, 450), " +
                         "('Trousers', 'F', 'M', 3528, 550), " +
                         "('Trousers', 'F', 'L', 5130, 650), " +
                         "('Skirt', 'F', 'S', 1400, 200), " +
                         "('Skirt', 'F', 'M', 2520, 300), " +
                         "('Skirt', 'F', 'L', 3465, 400), " +
                         "('Panties', 'F', 'S', 7.5, 30), " +
                         "('Panties', 'F', 'M', 10.8, 40), " +
                         "('Panties', 'F', 'L', 10.8, 50), " +
                         "('Sneakers', 'F', 'S', 2640, 600), " +
                         "('Sneakers', 'F', 'M', 3519, 700), " +
                         "('Sneakers', 'F', 'L', 4306.25, 800), " +
                         "('Sandals', 'F', 'S', 1150, 300), " +
                         "('Sandals', 'F', 'M', 1716, 400), " +
                         "('Sandals', 'F', 'L', 2295, 500), " +
                         "('Boots', 'F', 'S', 4368, 1200), " +
                         "('Boots', 'F', 'M', 5460, 1400), " +
                         "('Boots', 'F', 'L', 6720, 1600), " +
                         "('Socks', 'F', 'S', 30.375, 30), " +
                         "('Socks', 'F', 'M', 50, 40), " +
                         "('Socks', 'F', 'L', 105.625, 50);";
        stmt.execute(insertClothing);
        Logger.info("Data inserted into 'Clothing' table.");
    }
}