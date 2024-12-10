import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

/**
 * Represents a clothing item as a type of PackingItem.
 */
public class Clothing extends PackingItem {
  private static final String DB_URL = "jdbc:mysql://localhost:3306/Bite_DB";
  private static final String USER = "root";
  private static final String PASS = "Bite2005!";

  private char gender;

  /**
   * Constructs a Clothing item with value, type, size, and gender. Essential Item.
   *
   * @param value the value of the clothing item
   * @param type the type of the clothing item
   * @param size the size of the clothing item
   * @param gender the gender category of the clothing item
   */
  public Clothing(int value, String type, char size, char gender) {
    super(value, type, size);
    this.gender = gender;
  }

  /**
   * Constructs a Clothing item with type, size, and gender. Non-Essential Item.
   *
   * @param type the type of the clothing item
   * @param size the size of the clothing item
   * @param gender the gender category of the clothing item
   */
  public Clothing(String type, char size, char gender) {
    super(type, size);
    this.gender = gender;
  }

  @Override
  public double getWeight() {
    return fetchAttributeFromDB("weight", this.type, this.size, this.gender);
  }

  @Override
  public double getVolume() {
    return fetchAttributeFromDB("volume", this.type, this.size, this.gender);
  }

  @Override
public String toString() {
    return "Clothing [gender=" + gender + ", getValue()=" + getValue() + ", getType()=" + getType() + ", getSize()="
            + getSize() + ", getWeight()=" + getWeight() + ", getVolume()=" + getVolume() + "]";
}

  /**
   * Fetches the specified attribute from the database for a clothing item.
   *
   * @param attribute the attribute to fetch (e.g., "weight", "volume")
   * @param type the type of the clothing item
   * @param size the size of the clothing item
   * @param gender the gender category of the clothing item
   * @return the attribute value as a double
   */
  private static double fetchAttributeFromDB(String attribute, String type, char size, char gender) {
    String query = "SELECT " + attribute + " FROM CLOTHING WHERE TYPE = ? AND SIZE = ? AND GENDER = ?";
    List<String> validAttributes = Arrays.asList("volume", "weight");

    if (!validAttributes.contains(attribute)) {
      throw new IllegalArgumentException("Invalid Attribute");
    }

    try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        PreparedStatement stmt = conn.prepareStatement(query)) {
      // Set parameters
      stmt.setString(1, type);
      stmt.setString(2, size);
      stmt.setString(3, gender);

      // Execute query and fetch result
      try (ResultSet rs = stmt.executeQuery()) {
        if (rs.next()) {
          return rs.getDouble(attribute);
        } else {
          throw new SQLException("No data found for the given query");
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
      throw new RuntimeException("Failed to fetch attribute from the database", e);
    }
  }
}
