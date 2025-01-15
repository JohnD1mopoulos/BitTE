package com.BitTE.OptimizationProject;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.beans.Transient;
import java.sql.SQLException;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class ClothingTest {
    @Test
    void testConstructorForEssentialItems() {
        Clothing clothing = new Clothing("T-Shirt", 'M', 'M');
        assertEquals(0, clothing.getValue(), "The value should be 0.");
        assertEquals("T-Shirt", clothing.getType(), "The type should be T-Shirt.");
        assertEquals('M', clothing.getSize(), "The size should be M.");
        assertEquals('M', clothing.getGender(), "The gender should be M");
    }
    @Test
    void testConstructorForNonEssentialItems() {
        Clothing clothing = new Clothing(1, "T-Shirt", 'M', 'M');
        assertEquals(1, clothing.getValue(), "The value should be 1.");
        assertEquals("T-Shirt", clothing.getType(), "The type should be T-Shirt.");
        assertEquals('M', clothing.getSize(), "The size should be M.");
        assertEquals('M', clothing.getGender(), "The gender should be M");
    }

    @Test
    void testFetchWeightFromDBForTShirtSizeM() {
        Clothing clothing = new Clothing("T-Shirt", 'M', 'M');
        try {
            assertEquals(150, clothing.getWeight(), "The weight should be 150.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @Test
    void testFetchVolumeFromDBForTShirtSizeM() {
        Clothing clothing = new Clothing("T-Shirt", 'M', 'M');
        try {
            assertEquals(1680, clothing.getVolume(), "The volume should be 1680.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testDataIntegrityErrorDuringGetWeight() {
        Clothing clothing = new Clothing("T-Shirt", 'Q', 'M');
        try {
            clothing.getWeight();
        } catch (SQLException e) {
            assertEquals("An error occurred while fetching weight from the database: No data found for the given query: Type = T-Shirt, Size = Q, Gender = M", e.getMessage());
        }
    }

    @Test
    void testToStringReturnsCorrectFormatWhenDataIsAvailableForEssential() {
        Clothing clothing = new Clothing("T-Shirt", 'M', 'M');
        String expected = "An essential Clothing item of type = T-Shirt, size = M, gender = M, value = 0, weight = 150.00, volume = 1680.00";
        assertEquals(expected, clothing.toString(), "The string representation should be correct.");
    }

    @Test
    void testFetchVolumeFromDBWithInvalidType() {
        Clothing clothing = new Clothing("InvalidType", 'S','M');
        try {
            clothing.getVolume();
        } catch (SQLException e) {
            assertEquals("An error occurred while fetching volume from the database: No data found for the given query: Type = InvalidType, Size = S, Gender = M", e.getMessage(), "The exception message should be 'No data found for the given query'.");
        }
    }
}
