package com.BitTE.OptimizationProject;

import com.BitTE.OptimizationProject.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Clothing extends PackingItem {

    public Clothing(int value, String type, char size, char gender) {
        super(value, type, size, gender);
    }

    public Clothing(String type, char size, char gender) {
        super(type, size, gender);
    }

    private double fetchAttributeFromDB(String attribute, String type, char size, char gender) throws SQLException {
        String query = "SELECT " + attribute + " FROM CLOTHING WHERE Type = ? AND Size = ? AND Gender = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, type);
            stmt.setString(2, String.valueOf(size));
            stmt.setString(3, String.valueOf(gender));

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getDouble(attribute);
                } else {
                    throw new SQLException("No data found for the given query "+ type+" "+ size+" "+ gender);
                }
            }
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public double getWeight() throws SQLException {
        return fetchAttributeFromDB("weight", getType(), getSize(), getGender());
    }

    @Override
    public double getVolume() throws SQLException {
        return fetchAttributeFromDB("volume", getType(), getSize(), getGender());
    }

    @Override
    public String toString() {
<<<<<<< HEAD
        try {
            return String.format("A %s item of type = %s, size = %c, gender = %c, value = %d, weight = %.2f, volume = %.2f",
                                this.getClass().getSimpleName(), type, size, gender, value, getWeight(), getVolume());
        } catch (SQLException e) {
            return String.format("A %s item of type = %s, size = %c, gender = %c, value = %d, but an error occurred while retrieving weight and volume.",
                                this.getClass().getSimpleName(), type, size, gender, value);
=======
        if (value == 0) {//Essential Clothing
            try {
                return String.format("An essential %s item of type = %s, size = %c, gender = %c, value = %d, weight = %.2f, volume = %.2f",
                                    this.getClass().getSimpleName(), type, size, gender, value, getWeight(), getVolume());
            } catch (SQLException e) {
                return String.format("An essential %s item of type = %s, size = %c, gender = %c, value = %d, but an error occurred while retrieving weight and volume.",
                                    this.getClass().getSimpleName(), type, size, gender, value);
            }
        } else {
            try {
                return String.format("A non-essential %s item of type = %s, size = %c, gender = %c, value = %d, weight = %.2f, volume = %.2f",
                                    this.getClass().getSimpleName(), type, size, gender, value, getWeight(), getVolume());
            } catch (SQLException e) {
                return String.format("A non-essential %s item of type = %s, size = %c, gender = %c, value = %d, but an error occurred while retrieving weight and volume.",
                                    this.getClass().getSimpleName(), type, size, gender, value);
            }
>>>>>>> dc272cd7853d94421a1a07971a1d9e910bcbf071
        }
    }
}
