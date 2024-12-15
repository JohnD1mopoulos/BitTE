import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Represents an item of clothing, extending packing item functionalities.
 * This class handles database interactions to fetch specific attributes such as volume and weight
 * based on the type, size, and gender specification of the clothing item.
 */
public class Clothing extends PackingItem {
    private final String gender;

    /**
     * Constructs a Clothing object with specific attributes. Essential item
     *
     * @param value the value associated with the clothing
     * @param type the type of the clothing
     * @param size the size of the clothing
     * @param gender the gender specification of the clothing
     */
    public Clothing(int value, String type, String size, String gender) {
        super(value, size, type);
        this.gender = gender;
    }

    /**
     * Constructs a Clothing object with specific attributes, excluding value. Non-Essential item
     *
     * @param type the type of the clothing
     * @param size the size of the clothing
     * @param gender the gender specification of the clothing
     */
    public Clothing(String type, String size, String gender) {
        super(type, size);
        this.gender = gender;
    }

    /**
     * Fetches an attribute from the database based on type, size, and gender.
     *
     * @param attribute the name of the attribute to fetch ("volume" or "weight")
     * @param type the type of the clothing
     * @param size the size of the clothing
     * @param gender the gender of the clothing
     * @return the value of the requested attribute
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
     * @param type the type of clothing
     * @param size the size of clothing
     * @param gender the gender specification
     * @param query the SQL query to execute
     * @return the value of the attribute
     * @throws SQLException if no data is found or there is a database access error
     */

    private static double executeQuery(String attribute, String type, String size, String gender, String query) throws SQLException {
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, type);
            stmt.setString(2, size);
            stmt.setString(3, gender);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getDouble(attribute);
                } else {
                    logger.error("No data found for the given query");
                    throw new SQLException("No data found for the given query");
                }
            }
        } catch (SQLException e) {
            logger.error("Failed to fetch attribute from the database: {}", e);
            throw e;
        }
    }

    /**
     * Validates that the requested attribute is one of the recognized types.
     *
     * @param attribute the attribute to validate ("weight" or "volume")
     * @throws IllegalArgumentException if the attribute is not recognized
     */
    private static void validateAttribute(String attribute) {
        List<String> validAttributes = Arrays.asList("volume", "weight");
        if (!validAttributes.contains(attribute)) {
            logger.error("Invalid Attribute");
            throw new IllegalArgumentException("Invalid Attribute" + attribute);
        }
    }

    /**
 * Retrieves the weight of the packing item from the database.
 *
 * This method fetches the weight based on the item's type, size, and gender.
 * If the database operation fails due to an SQL error, the method logs the error and returns -1.0.
 *
 * @return the weight of the packing item if successful; -1.0 if unable to fetch the weight.
 */
@Override
public double getWeight() {
    try {
        return fetchAttributeFromDB("weight", this.type, this.size, this.gender);
    } catch (SQLException e) {
        logger.error("Failed to fetch weight for type: {}, size: {}, gender: {}", type, size, gender, e);
        return -1.0;
    }
}

/**
 * Retrieves the volume of the packing item from the database.
 *
 * This method fetches the volume based on the item's type, size, and gender.
 * Similar to getWeight, if there is an SQL error, the error is logged and the method returns -1.0.
 *
 * @return the volume of the packing item if successful; -1.0 if unable to fetch the volume.
 */
@Override
public double getVolume() {
    try {
        return fetchAttributeFromDB("volume", this.type, this.size, this.gender);
    } catch (SQLException e) {
        logger.error("Failed to fetch volume for type: {}, size: {}, gender: {}", type, size, gender, e);
        return -1.0;
    }
}

    /**
     * Provides a string representation of the clothing.
     * Includes value, type, size, weight, and volume in the string.
     *
     * @return a string representation of the clothing
     */
    @Override
    public String toString() {
        return "Clothing [value=" + value + ", type=" + type + ", size=" + size + ", gender=" + gender
                + ", Weight=" + getWeight() + ", Volume=" + getVolume() + "]";
    }
}
