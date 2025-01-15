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
 * Abstract class representing a generic packing item.
 * This class serves as a base for items that can be packed, providing common properties
 * such as type, size, and value, and requires implementation of weight and volume retrieval methods.
 */
public abstract class PackingItem {
    protected int value;
    protected String type;
    protected char size;
    protected final char gender;

    /**
     * Constructs a new PackingItem with specified value, type, size, and gender. Used for Non-Essential items.
     */
    public PackingItem(int value, String type, char size, char gender) {
        this.value = value;
        this.type = type;
        this.size = size;
        this.gender = gender;
    }

    /**
     * Constructs a new PackingItem with specified type and size. Used for Essential items.
     */
    public PackingItem(String type, char size, char gender) {
        this(0, type, size, gender); // Default value is set to 0 for Essential items
    }

    public String getType() {
        return this.type;
    }

    public int getValue() {
        return this.value;
    }

    public char getSize() {
        return this.size;
    }

    public char getGender() {
        return this.gender;
    }

    protected static void validateAttribute(String attribute) {
    List<String> validAttributes = Arrays.asList("volume", "weight");
        if (!validAttributes.contains(attribute)) {
            throw new IllegalArgumentException("Invalid attribute: " + attribute);
        }
    }

    /**
     * Abstract method to return the weight of the packing item.
     */
    public abstract double getWeight() throws SQLException;

    /**
     * Abstract method to return the volume of the packing item.
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
