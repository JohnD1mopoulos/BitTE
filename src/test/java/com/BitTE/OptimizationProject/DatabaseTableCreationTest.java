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
        // Optionally drop tables or close connection

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
}
