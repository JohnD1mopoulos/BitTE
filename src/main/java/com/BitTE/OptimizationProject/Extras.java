package com.BitTE.OptimizationProject;
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
public class Extras extends PackingItem {
  private static final String DB_URL = "jdbc:mysql://localhost:3306/Bite_DB";
  private static final String USER = "root";
  private static final String PASS = "Bite2005!";
  /**
   * Constructs an Extras item with value, type. Essential Item.
   *
   * @param value the value of the extras item
   * @param type the type of the extras item
   */
  public Extras(int value, String type) {
    super(value, type);
  }

  /**
   * Constructs an Extras item with type. Non-Essential Item.
   *
   * @param type the type of the extras item
   */
  public Extras(String type) {
    super(type);
  }

  @Override
  public double getWeight() {
    return fetchAttributeFromDB("weight", this.type);
  }

  @Override
  public double getVolume() {
    return fetchAttributeFromDB("volume", this.type);
  }

  @Override
    public String toString() {
        return "Extras [getValue()=" + getValue() + ", getType()=" + getType() + ", getWeight()=" + getWeight() + ", getVolume()=" + getVolume() + "]";
    }

  /**
   * Fetches the specified attribute from the database for an extras item.
   *
   * @param attribute the attribute to fetch (e.g., "weight", "volume")
   * @param type the type of the extras item
   * @return the attribute value as a double
   */
  private static double fetchAttributeFromDB(String attribute, String type) {
    String query = "SELECT " + attribute + " FROM EXTRAS WHERE TYPE = ?";
    List<String> validAttributes = Arrays.asList("volume", "weight");

    if (!validAttributes.contains(attribute)) {
      throw new IllegalArgumentException("Invalid Attribute");
    }

    try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        PreparedStatement stmt = conn.prepareStatement(query)) {
      // Set parameters
      stmt.setString(1, type);

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
