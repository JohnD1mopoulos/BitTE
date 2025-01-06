package com.BitTE.OptimizationProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Extras extends PackingItem {

    public Extras(int value, String type, char size, char gender) {
        super(value, type, size, gender);
    }

    public Extras(String type, char size, char gender) {
        super(type, size, gender);
    }

    private double fetchAttributeFromDB(String attribute, String type) throws SQLException {
        validateAttribute(attribute);
        String query = "SELECT " + attribute + " FROM EXTRAS WHERE Type = ?";
        return executeQuery(query, attribute, type);
    }

    private double executeQuery(String query, String attribute, String type) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection(); // Use centralized connection class
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, type);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getDouble(attribute);
                } else {
                    logger.warn("No data found for type: {}", type);
                    throw new SQLException("No data found for the given query");
                }
            }
        } catch (SQLException e) {
            logger.error("Failed to fetch attribute from the database", e);
            throw e;
        }
    }

    private static void validateAttribute(String attribute) {
        List<String> validAttributes = Arrays.asList("volume", "weight");
        if (!validAttributes.contains(attribute)) {
            logger.error("Invalid Attribute: {}. Allowed attributes are volume and weight", attribute);
            throw new IllegalArgumentException("Invalid attribute: " + attribute);
        }
    }

    @Override
    public double getWeight() throws SQLException {
        return fetchAttributeFromDB("weight", this.getType());
    }

    @Override
    public double getVolume() throws SQLException {
        return fetchAttributeFromDB("volume", this.getType());
    }
}
