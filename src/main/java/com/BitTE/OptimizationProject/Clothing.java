package main.java.com.BitTE.OptimizationProject;

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
    private final String gender;

    /**
     * Constructs a Clothing object with all attributes specified, marking it as an essential item.
     *
     * @param value  the value associated with the clothing item
     * @param type   the type of the clothing item
     * @param size   the size of the clothing item
     * @param gender the gender specification of the clothing item
     */
    public Clothing(int value, String type, String size, String gender) {
        super(value, size, type);
        this.gender = gender;
    }

    /**
     * Constructs a Clothing object with specific attributes but without a value, marking it as a non-essential item.
     *
     * @param type   the type of the clothing item
     * @param size   the size of the clothing item
     * @param gender the gender specification of the clothing item
     */
    public Clothing(String type, String size, String gender) {
        super(type, size);
        this.gender = gender;
    }

    protected static String[] typesArrayMen = {"T-shirt", "Shirt", "Hoodie", "Jeans", "Sweatpants", "Trousers", "Boxers", "Shorts", "Sneakers", "Sandals", "Boots", "Socks"};
    protected static String[] typesArrayWomen = {"T-shirt", "Shirt", "Hoodie", "Jeans", "Sweatpants", "Trousers", "Skirts", "Panties", "Shorts", "Sneakers", "Sandals", "Boots", "Socks"};

    /**
     * Fetches an attribute from the database based on the clothing's type, size, and gender.
     * 
     * @param attribute the name of the attribute to fetch ("volume" or "weight")
     * @param type      the type of the clothing
     * @param size      the size of the clothing
     * @param gender    the gender of the clothing
     * @return the value of the requested attribute as a double
     * @throws SQLException if there is an error during database access
     */
    private static double fetchAttributeFromDB(String attribute, String type, String size, String gender) throws SQLException {
        validateAttribute(attribute);
        String query = "SELECT " + attribute + " FROM CLOTHING WHERE TYPE = ? AND SIZE = ? AND GENDER = ?";
        return executeQuery(attribute, type, size, gender, query);
    }

    /**
     * Executes a SQL query to retrieve a specified attribute from the database.
     *
     * @param attribute the attribute to retrieve
     * @param type      the type of clothing
     * @param size      the size of clothing
     * @param gender    the gender specification
     * @param query     the SQL query to execute
     * @return the value of the attribute as a double
     * @throws SQLException if no data is found or there is a database access error
     */
    private static double executeQuery(String attribute, String type, char size, char gender, String query) throws SQLException {
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, type);
            stmt.setString(2, size);
            stmt.setString(3, gender);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getDouble(attribute);
                } else {
                    logger.warn("No data found for the given query with type {}, size {} and gender {}", type, size, gender);
                    throw new SQLException("No data found for the given query");
                }
            }
        } catch (SQLException e) {
            logger.error("Failed to fetch attribute from the database", e);
            throw e;
        }
    }

    /**
     * Validates that the requested attribute is valid.
     *
     * @param attribute the attribute to validate ("weight" or "volume")
     * @throws IllegalArgumentException if the attribute is not recognized
     */
    private static void validateAttribute(String attribute) {
        List<String> validAttributes = Arrays.asList("volume", "weight");
        if (!validAttributes.contains(attribute)) {
            logger.error("Invalid Attribute: {}", attribute);
            throw new IllegalArgumentException("Invalid Attribute: " + attribute);
        }
    }

    /**
     * Retrieves the weight of the clothing item from the database.
     *
     * @return the weight of the clothing item as a double, or -1.0 if an error occurs
     */
    @Override
    public double getWeight() {
        try {
            return fetchAttributeFromDB("weight", this.type, this.size, this.gender);
        } catch (SQLException e) {
            return -1.0;
        }
    }

    /**
     * Retrieves the volume of the clothing item from the database.
     *
     * @return the volume of the clothing item as a double, or -1.0 if an error occurs
     */
    @Override
    public double getVolume() {
        try {
            return fetchAttributeFromDB("volume", this.type, this.size, this.gender);
        } catch (SQLException e) {
            return -1.0;
        }
    }

    /**
     * Provides a string representation of the clothing item.
     *
     * @return a string representation of the clothing item including all attributes
     */
    @Override
    public String toString() {
        return "Clothing [value=" + value + ", type=" + type + ", size=" + size + ", gender=" + gender
                + ", Weight=" + getWeight() + ", Volume=" + getVolume() + "]";
    }
}
