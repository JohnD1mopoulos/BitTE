package com.BitTE.OptimizationProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Represents an item of clothing with extended functionality for packing.
 * This class handles database interactions to fetch attributes like volume and weight based
 * on the type, size, and gender specifications of the clothing item.
 */
public class Clothing extends PackingItem {
    private static final Logger logger = LoggerFactory.getLogger(Clothing.class);
    private final char gender;

    /**
     * Constructs a new {@code Clothing} instance with detailed attributes, marking it as a non-essential item.
     *
     * @param value  the users' value associated with the clothing item
     * @param type   the type of the clothing item
     * @param size   the size of the clothing item
     * @param gender the gender specification of the clothing item
     */
    public Clothing(int value, String type, char size, char gender) {
        super(value, size, type);
        this.gender = gender;
    }

    /**
     * Constructs a new {@code Clothing} instance with basic attributes but without a value, marking it as an essential item.
     *
     * @param type   the type of the clothing item
     * @param size   the size of the clothing item
     * @param gender the gender specification of the clothing item
     */
    public Clothing(String type, char size, char gender) {
        super(type, size);
        this.gender = gender;
    }

    /**
     * Fetches an attribute from the database based on the clothing's type, size, and gender.
     *
     * @param attribute the attribute to fetch, e.g., "volume" or "weight"
     * @param type      the type of the clothing
     * @param size      the size of the clothing
     * @param gender    the gender of the clothing
     * @return the double value of the requested attribute
     * @throws SQLException if there is an error during the database access
     */
    private double fetchAttributeFromDB(String attribute, String type, char size, char gender) throws SQLException {
        validateAttribute(attribute);
        String query = "SELECT " + attribute + " FROM CLOTHING WHERE Type = ? AND Size = ? AND Gender = ?";
        return executeQuery(query, attribute, type, size, gender);
    }

    /**
     * Executes a SQL query to retrieve a specified attribute from the database.
     *
     * @param query     the SQL query to execute
     * @param attribute the attribute to retrieve
     * @param type      the type of clothing
     * @param size      the size of the clothing
     * @param gender    the gender specification of the clothing
     * @return the value of the attribute as a double
     * @throws SQLException if no data is found or there is a database access error
     */
    private double executeQuery(String query, String attribute, String type, String size, String gender) throws SQLException {
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, type);
            stmt.setString(2, size);
            stmt.setString(3, gender);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getDouble(attribute);
                } else {
                    logger.warn("No data found for type: {}, size: {}, and gender: {}", type, size, gender);
                    throw new SQLException("No data found for the given query");
                }
            }
        } catch (SQLException e) {
            logger.error("Failed to fetch attribute from the database", e);
            throw e;
        }
    }

    /**
     * Validates the requested attribute to ensure it is one of the expected types.
     *
     * @param attribute the attribute to validate
     * @throws IllegalArgumentException if the attribute is not valid
     */
    private static void validateAttribute(String attribute) {
        List<String> validAttributes = Arrays.asList("volume", "weight");
        if (!validAttributes.contains(attribute)) {
            logger.error("Invalid Attribute: {}. Allowed attributes are volume and weight", attribute);
            throw new IllegalArgumentException("Invalid attribute: " + attribute);
        }
    }

    /**
     * Retrieves the weight of the clothing item from the database.
     * This method fetches the 'volume' attribute for the item based on its type, size, and gender.
     *
     * @return the weight of the clothing item as a double
     * @throws SQLException if there is an error in the database access
     * @throws DataAccessException if the query fails to fetch the data
     */
    @Override
    public double getWeight() throws SQLException, DataAccessException{
        try {
            return fetchAttributeFromDB("weight", this.getType(), this.getSize(), this.gender);
        } catch (SQLException e) {
            logger.error("Failed to return weight from database", e);
            throw new DataAccessException("Error fetching weight from database");
        }
    }

    /**
     * Retrieves the volume of the clothing item from the database.
     * This method fetches the 'volume' attribute for the item based on its type, size, and gender.
     *
     * @return the volume of the clothing item as a double
     * @throws SQLException if there is an error in the database access
     * @throws DataAccessException if the query fails to fetch the data
     */
    @Override
    public double getVolume() throws SQLException, DataAccessException{
        try {
            return fetchAttributeFromDB("volume", this.getType(), this.getSize(), this.gender);
        } catch (SQLException e) {
            logger.error("Failed to return volume from database", e);
            throw new DataAccessException("Error fetching volume from database");
        }
    }

    @Override
    public String toString() {
        return String.format("Clothing [value=%d, type=%s, size=%s, gender=%s, Weight=%.2f, Volume=%.2f]",
                             getValue(), getType(), getSize(), gender, getWeight(), getVolume());
    }
}
