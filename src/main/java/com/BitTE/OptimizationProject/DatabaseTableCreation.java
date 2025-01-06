package com.BitTE.OptimizationProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseTableCreation {
    private String url = "jdbc:sqlite:C:/sqlite/db/mydatabase.db"; // Database connection URL

    public DatabaseTableCreation() {
        initializeDatabase();
    }

    private void initializeDatabase() {
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {

            // Create tables
            String sqlClothing = "CREATE TABLE IF NOT EXISTS Clothing (" +
                                 "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                 "type TEXT NOT NULL, " +
                                 "gender TEXT NOT NULL CHECK (gender IN ('M', 'F')), " +
                                 "size TEXT NOT NULL CHECK (size IN ('S', 'M', 'L')), " +
                                 "volume FLOAT NOT NULL, " +
                                 "weight FLOAT NOT NULL);";

            String sqlExtras = "CREATE TABLE IF NOT EXISTS Extras (" +
                               "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                               "type TEXT NOT NULL, " +
                               "volume FLOAT NOT NULL, " +
                               "weight FLOAT NOT NULL);";

            stmt.execute(sqlClothing);
            stmt.execute(sqlExtras);
            System.out.println("Tables created.");

            // Insert data into Extras
            stmt.execute("INSERT INTO Extras (type, volume, weight) VALUES " +
                         "('Passport', 35.1, 45), ('Laptop', 1680, 2000), ('Book', 1500, 800);");

            // Insert data into Clothing
            stmt.execute("INSERT INTO Clothing (type, gender, size, volume, weight) VALUES " +
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
                         "('Underwear', 'M', 'S', 468, 60), " +
                         "('Underwear', 'M', 'M', 750, 70), " +
                         "('Underwear', 'M', 'L', 1035, 80), " +
                         "('Shorts', 'M', 'S', 828, 200), " +
                         "('Shorts', 'M', 'M', 1250, 250), " +
                         "('Shorts', 'M', 'L', 1092, 300), " +
                         "('Sneaker', 'M', 'S', 6409, 800), " +
                         "('Sneaker', 'M', 'M', 7812, 900), " +
                         "('Sneaker', 'M', 'L', 9120, 1000), " +
                         "('Sandal', 'M', 'S', 4176, 500), " +
                         "('Sandal', 'M', 'M', 5270, 600), " +
                         "('Sandal', 'M', 'L', 6912, 700), " +
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
                         "('Underwear', 'F', 'S', 7.5, 30), " +
                         "('Underwear', 'F', 'M', 10.8, 40), " +
                         "('Underwear', 'F', 'L', 10.8, 50), " +
                         "('Sneaker', 'F', 'S', 2640, 600), " +
                         "('Sneaker', 'F', 'M', 3519, 700), " +
                         "('Sneaker', 'F', 'L', 4306.25, 800), " +
                         "('Sandal', 'F', 'S', 1150, 300), " +
                         "('Sandal', 'F', 'M', 1716, 400), " +
                         "('Sandal', 'F', 'L', 2295, 500), " +
                         "('Boots', 'F', 'S', 4368, 1200), " +
                         "('Boots', 'F', 'M', 5460, 1400), " +
                         "('Boots', 'F', 'L', 6720, 1600), " +
                         "('Socks', 'F', 'S', 30.375, 30), " +
                         "('Socks', 'F', 'M', 50, 40), " +
                         "('Socks', 'F', 'L', 105.625, 50);");
            System.out.println("Data inserted.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
