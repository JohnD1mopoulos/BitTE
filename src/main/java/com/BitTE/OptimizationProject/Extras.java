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

import com.BitTE.OptimizationProject.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class Extras extends PackingItem {

    public Extras(int value, String type, char size, char gender) {
        super(value, type, size, gender);
    }

    public Extras(String type, char size, char gender) {
        super(type, size, gender);
    }

    private double fetchAttributeFromDB(String attribute, String type) throws SQLException {
        validateAttribute(attribute);
        String query = "SELECT " + attribute + " FROM EXTRAS WHERE Type = ? AND Size = ?";
        return executeQuery(query, attribute, type);
    }

    private double executeQuery(String query, String attribute, String type) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, type);
            stmt.setString(2, String.valueOf(this.getSize()));

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getDouble(attribute);
                } else {
                    throw new SQLException("No data found for the given query");
                }
            }
        } catch (SQLException e) {
            throw e;
        }
    }


    @Override
    public double getWeight() throws SQLException {
        return fetchAttributeFromDB("weight", this.getType());
    }

    @Override
    public double getVolume() throws SQLException {
        return fetchAttributeFromDB("volume", this.getType());
    }

    @Override
    public String toString() {
        if (value == 0) {//Essential Extras
            try {
                return String.format("An essential %s item of type = %s, size = %c, value = %d, weight = %.2f, volume = %.2f",
                                    this.getClass().getSimpleName(), type, size, value, getWeight(), getVolume());
            } catch (SQLException e) {
                return String.format("An essential %s item of type = %s, size = %c, value = %d, but an error occurred while retrieving weight and volume.",
                                    this.getClass().getSimpleName(), type, size, value);
            }
        } else {
            try {
                return String.format("A non-essential %s item of type = %s, size = %c, value = %d, weight = %.2f, volume = %.2f",
                                    this.getClass().getSimpleName(), type, size, value, getWeight(), getVolume());
            } catch (SQLException e) {
                return String.format("A non-essential %s item of type = %s, size = %c, value = %d, but an error occurred while retrieving weight and volume.",
                                    this.getClass().getSimpleName(), type, size, value);
            }
        }
    }
}
