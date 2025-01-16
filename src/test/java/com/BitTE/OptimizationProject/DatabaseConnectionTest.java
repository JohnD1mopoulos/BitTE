package com.BitTE.OptimizationProject;

import org.junit.jupiter.api.Test;
import com.BitTE.OptimizationProject.DatabaseTableCreation;
import org.junit.jupiter.api.BeforeEach;
import java.sql.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class DatabaseConnectionTest {
    @Test
    void testConnection() throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        assertNotNull(connection, "The connection should not be null.");
    }
}
