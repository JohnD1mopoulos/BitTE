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
 * Represents a clothing item as a type of PackingItem.
 */
public class Extras extends PackingItem {
    private static final Logger logger = LoggerFactory.getLogger(Extras.class);

    /**
     * Constructs an Extras item with value, type. Essential Item.
     *
     * @param type the type of the extras item
     * @param size the size of the extras item
     * @param gender the gender specification of the extras item
     */
    public Extras(String type, char size, char gender) {
        super(type, size, gender);
    }

    /**
     * Constructs an Extras item with type. Non-Essential Item.
     *
     * @param value the value of the extras item
     * @param type the type of the extras item
     * @param size the size of the extras item
     * @param gender the gender specification of the extras item
     */
    public Extras(int value, String type, char size, char gender) {
        super(value, type, size, gender);
    }

    /**
     * Retrieves the weight of the extras item from the database.
     *
     * @return the weight of the extras item as a double
     */
    @Override
    public double getWeight() {
        try {
            return fetchAttributeFromDB("weight", this.getType());
        } catch (SQLException e) {
            logger.error("Failed to fetch weight from the database for Extras", e);
            return -1.0;
        }
    }

    /**
     * Retrieves the volume of the extras item from the database.
     *
     * @return the volume of the extras item as a double
     */
    @Override
    public double getVolume() {
        try {
            return fetchAttributeFromDB("volume", this.getType());
        } catch (SQLException e) {
            logger.error("Failed to fetch volume from the database for Extras", e);
            return -1.0;
        }
    }

    /**
     * Fetches the specified attribute from the database for an extras item.
     *
     * @param attribute the attribute to fetch (e.g., "weight", "volume")
     * @param type the type of the extras item
     * @return the attribute value as a double
     * @throws SQLException if an error occurs during the database access
     */
    private double fetchAttributeFromDB(String attribute, String type) throws SQLException {
        validateAttribute(attribute);
        String query = "SELECT " + attribute + " FROM EXTRAS WHERE TYPE = ?";
        return executeQuery(query, attribute, type);
    }

    /**
     * Executes a SQL query to retrieve a specified attribute from the database.
     *
     * @param query the SQL query to execute
     * @param attribute the attribute to retrieve
     * @param type the type of extras item
     * @return the value of the attribute as a double
     * @throws SQLException if no data is found or there is a database access error
     */
    private double executeQuery(String query, String attribute, String type) throws SQLException {
        try (Connection conn = ConnectionPool.getConnection();
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

    @Override
    public String toString() {
        try {
            return String.format("Extras [value=%d, type=%s, size=%s, gender=%s, Weight=%.2f, Volume=%.2f]",
                                 getValue(), getType(), getSize(), gender, getWeight(), getVolume());
        } catch (Exception e) {
            logger.error("Error generating string representation of Extras", e);
            return "Extras [Error]";
        }
    }
}
