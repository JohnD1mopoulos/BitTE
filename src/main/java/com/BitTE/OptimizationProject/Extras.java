package com.BitTE.OptimizationProject;

import com.BitTE.OptimizationProject.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

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
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, type);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getDouble(attribute);
                } else {
                    throw new SQLException("No data found for the given query");
                }
            }
        } catch (SQLException e) {
            throw e;
        }
    }

    private static void validateAttribute(String attribute) {
        List<String> validAttributes = Arrays.asList("volume", "weight");
        if (!validAttributes.contains(attribute)) {
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

    @Override
    public String toString() {
        try {
            return String.format("An %s item of type = %s, size = %c, gender = %c, value = %d, weight = %.2f, volume = %.2f",
                                this.getClass().getSimpleName(), type, size, gender, value, getWeight(), getVolume());
        } catch (SQLException e) {
            return String.format("An %s item of type = %s, size = %c, value = %d, but an error occurred while retrieving weight and volume.",
                                this.getClass().getSimpleName(), type, size, value);
        }
    }
}

