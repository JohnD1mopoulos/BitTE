/*
 * Copyright 2025 BitTE Team
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

 package com.BitTE.OptimizationProject;

 import java.sql.Connection;
 import java.sql.PreparedStatement;
 import java.sql.ResultSet;
 import java.sql.SQLException;
 /**
  * Represents specific non-essential or essential extras as a type of packing item
  * with functionality for fetching attributes from a database.
  */
 public class Extras extends PackingItem {
     /**
      * Constructs a new Extras item with specified value, type, size, and gender.
      * Used for Non-Essential items.
      *
      * @param value the item's value
      * @param type the type of the item
      * @param size the size of the item
      * @param gender the gender specification of the item
      */
     public Extras(int value, String type, char size, char gender) {
         super(value, type, size, gender);
     }
     /**
      * Constructs a new Extras item with specified type, size, and gender.
      * Used for Essential items with a default value of 0.
      *
      * @param type the type of the item
      * @param size the size of the item
      * @param gender the gender specification of the item
      */
     public Extras(String type, char size, char gender) {
         super(type, size, gender);
     }
     /**
      * Fetches the specified attribute from the database for this extras item.
      *
      * @param attribute the attribute name to fetch (e.g., weight, volume)
      * @return the value of the attribute
      * @throws SQLException if a database access error occurs
      */
     private double fetchAttributeFromDB(String attribute) throws SQLException {
         validateAttribute(attribute);
         String query = "SELECT " + attribute + " FROM EXTRAS WHERE Type = ? AND Size = ?";
         return executeQuery(query, attribute);
     }
     /**
      * Executes a SQL query to retrieve a specific attribute for this extras item.
      *
      * @param query the SQL query string
      * @param attribute the attribute to be retrieved
      * @return the value of the requested attribute
      * @throws SQLException if a database access error occurs or no data found
      */
     private double executeQuery(String query, String attribute) throws SQLException {
         try (Connection conn = DatabaseConnection.getConnection();
              PreparedStatement stmt = conn.prepareStatement(query)) {
             stmt.setString(1, this.getType());
             stmt.setString(2, String.valueOf(this.getSize()));
             try (ResultSet rs = stmt.executeQuery()) {
                 if (rs.next()) {
                     return rs.getDouble(attribute);
                 } else {
                     throw new SQLException("No data found for the given query: Type = " + this.getType() + ", Size = " + this.getSize());
                 }
             }
         } catch (SQLException e) {
             throw e;
         }
     }
     /**
      * Retrieves the weight of this extras item from the database.
      *
      * @return the weight of this extras item
      * @throws SQLException if there is an error fetching the weight from the database
      */
     @Override
     public double getWeight() throws SQLException {
         return fetchAttributeFromDB("weight");
     }
     /**
      * Retrieves the volume of this extras item from the database.
      *
      * @return the volume of this extras item
      * @throws SQLException if there is an error fetching the volume from the database
      */
     @Override
     public double getVolume() throws SQLException {
         return fetchAttributeFromDB("volume");
     }
     /**
      * Provides a string representation of the Extras item, detailing type, size, gender, value, weight, and volume,
      * with specific details about whether the item is essential or non-essential.
      *
      * @return a string description of this Extras item
      */
     @Override
    public String toString() {
        if (value == 0) {//Essential Extras
            try {
                return String.format("An essential %s item of type = %s, size = %c, value = %d, weight = %.2f, volume = %.2f",
                                    this.getClass().getSimpleName(), this.getType(), this.getSize(), this.getValue(), getWeight(), getVolume());
            } catch (SQLException e) {
                return String.format("An essential %s item of type = %s, size = %c, value = %d, but an error occurred while retrieving weight and volume.",
                                    this.getClass().getSimpleName(), this.getType(), this.getSize(), this.getValue());
            }
        } else { //`Non-Essential Extras
            try {
                return String.format("A non-essential %s item of type = %s, size = %c, value = %d, weight = %.2f, volume = %.2f",
                                    this.getClass().getSimpleName(), this.getType(), this.getSize(), this.getValue(), getWeight(), getVolume());
            } catch (SQLException e) {
                return String.format("A non-essential %s item of type = %s, size = %c, value = %d, but an error occurred while retrieving weight and volume.",
                                    this.getClass().getSimpleName(), this.getType(), this.getSize(), this.getValue());
            }
        }
    }
}
