package com.BitTE.OptimizationProject;

import org.junit.jupiter.api.Test;
import com.BitTE.OptimizationProject.DatabaseTableCreation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import java.sql.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DatabaseTableCreationTest {
    private Connection connection;

    @BeforeEach
    void setUp() throws Exception {
        new DatabaseTableCreation();
        connection = DriverManager.getConnection("jdbc:sqlite:C:/sqlite/db/mydatabase.db");
    }

    @AfterEach
    void tearDown() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

    @Test
    public void testTableCreation() throws SQLException {
        DatabaseMetaData dbMetaData = connection.getMetaData();
        ResultSet rs = dbMetaData.getTables(null, null, "CLOTHING", null);
        assertTrue(rs.next(), "Clothing table should be created");

        rs = dbMetaData.getTables(null, null, "EXTRAS", null);
        assertTrue(rs.next(), "Extras table should be created");
    }

    @Test
    public void testDataInsertionForExtras() throws SQLException {
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT COUNT(*) AS count FROM EXTRAS");
        if (rs.next()) {
            int count = rs.getInt("count");
            assertEquals(9, count, "Should have 9 rows in the EXTRAS table");
        }
    }

    @Test
    public void testDataInsertionForClothing() throws SQLException {
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT COUNT(*) AS count FROM CLOTHING");
        if (rs.next()) {
            int count = rs.getInt("count");
            assertEquals(72, count, "Should have 72 rows in the CLOTHING table");
        }
    }
}
