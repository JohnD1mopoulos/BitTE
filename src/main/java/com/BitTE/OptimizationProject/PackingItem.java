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

 import java.sql.SQLException;
 import java.util.Arrays;
 import java.util.List;
 
 /**
  * Abstract class representing a generic packing item. This class provides a foundation for items that can be packed,
  * defining common properties such as type, size, and value, and requires the implementation of methods to retrieve weight and volume.
  */
 public abstract class PackingItem {
     protected int value;
     protected String type;
     protected char size;
     protected final char gender;
 
     /**
      * Constructs a new PackingItem for Non-Essential items with specified value, type, size, and gender.
      *
      * @param value the item's value
      * @param type the type of the item
      * @param size the size of the item represented as a single character (e.g., 'S', 'M', 'L')
      * @param gender the gender specificity of the item (e.g., 'M' for male, 'F' for female)
      */
     public PackingItem(int value, String type, char size, char gender) {
         this.value = value;
         this.type = type;
         this.size = size;
         this.gender = gender;
     }
 
     /**
      * Constructs a new PackingItem for Essential items with specified type, size, and gender.
      * The value is default set to 0.
      *
      * @param type the type of the item
      * @param size the size of the item represented as a single character (e.g., 'S', 'M', 'L')
      * @param gender the gender specificity of the item (e.g., 'M' for male, 'F' for female)
      */
     public PackingItem(String type, char size, char gender) {
         this(0, type, size, gender); // Default value is set to 0 for Essential items
     }
     
     /**
     * Returns the type of the packing item.
     *
     * @return the type of the item as a string
     */
     public String getType() {
         return this.type;
     }
 
     /**
     * Returns the value of the packing item.
     *
     * @return the value of the item as an integer
     */
     public int getValue() {
         return this.value;
     }
 
     /**
     * Returns the size of the packing item.
     *
     * @return the size of the item as a character
     */
     public char getSize() {
         return this.size;
     }
 
      /**
     * Returns the gender specification of the packing item.
     *
     * @return the gender of the item as a character
     */
     public char getGender() {
         return this.gender;
     }
 
     /**
     * Validates if the given attribute is acceptable (e.g., 'volume' or 'weight').
     *
     * @param attribute the attribute to validate.
     * @throws IllegalArgumentException if the attribute is not valid.
     */
     protected static void validateAttribute(String attribute) {
         List<String> validAttributes = Arrays.asList("volume", "weight");
         if (!validAttributes.contains(attribute)) {
             throw new IllegalArgumentException("Invalid attribute: " + attribute);
         }
     }
 
     /**
      * Abstract method to return the weight of the packing item.
      *
      * @return the weight of the item
      * @throws SQLException if there is an issue retrieving the weight from the database
      */
     public abstract double getWeight() throws SQLException;
 
     /**
      * Abstract method to return the volume of the packing item.
      *
      * @return the volume of the item
      * @throws SQLException if there is an issue retrieving the volume from the database
      */
     public abstract double getVolume() throws SQLException;
 
     @Override
     public String toString() {
         try {
             return String.format("PackingItem [value=%d, type=%s, size=%c, gender=%c, Weight=%.2f, Volume=%.2f]",
                                  value, type, size, gender, getWeight(), getVolume());
         } catch (SQLException e) {
             return "PackingItem [Error retrieving weight/volume]";
         }
     }
 } 
