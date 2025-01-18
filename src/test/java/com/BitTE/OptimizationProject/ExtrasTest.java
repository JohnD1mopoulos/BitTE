package com.BitTE.OptimizationProject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.beans.Transient;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.xml.crypto.Data;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ExtrasTest {

@Test 
    void testConstructorForNonEssentialItems() {
        Extras extras = new Extras(1, "Passport", 'S', 'X');
        assertEquals(1, extras.getValue(), "The value should be 1.");
        assertEquals("Passport", extras.getType(), "The type should be Passport.");
        assertEquals('S', extras.getSize(), 'S', "The size should be S.");
        assertEquals('X', extras.getGender(), 'X', "The gender should b X");
    }
@Test
    void testConstructorForEssentialItems() {
        Extras extras = new Extras("Passport", 'S', 'X');
        assertEquals(0, extras.getValue(), 0, "The value should be 0.");
        assertEquals("Passport", extras.getType(), "The type should be Passport.");
        assertEquals('S', extras.getSize(), 'S', "The size should be S.");
        assertEquals('X', extras.getGender(), 'X', "The gender should be X");
    }


    @Test
    void testFetchWeightFromDBForPassportSizeS() {
        Extras extras = new Extras("Passport", 'S','X' );
        try {
            assertEquals(45, extras.getWeight(), 45, "The weight should be 45.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testFetchVolumeFromDBForPassportSizeS() {
        Extras extras = new Extras("Passport", 'S','X');
        try {
            assertEquals(35.1, extras.getVolume(), 35.1, "The volume should be 35.1.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testFetchVolumeFromDBForComputerSizeS() {
        Extras extras = new Extras("Computer", 'S','X');
        try {
            assertEquals(1344, extras.getVolume(), 1344, "The volume should be 1344.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test 
    void testFetchWeightFromDBForComputerSizeS() {
        Extras extras = new Extras("Computer", 'S','X');
        try {
            assertEquals(1600, extras.getWeight(), 1600, "The weight should be 1600.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testFetchVolumeFromDBForBookSizeM() {
        Extras extras = new Extras("Book", 'M','X');
        try {
            assertEquals(1500, extras.getVolume(), "The volume should be 1500.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testFetchWeightFromDBForBookSizeM () {
        Extras extras = new Extras("Book", 'M','X');
        try {
            assertEquals(800, extras.getWeight(), "The weight should be 800.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDataIntegrityErrorDuringGetWeight() {
        Extras extras = new Extras("Passport", 'Q', 'X');

        Exception exception = assertThrows(SQLException.class, extras::getWeight);
        assertEquals("No data found for the given query: Type = Passport, Size = Q", exception.getMessage(), "Should throw SQLException on data type mismatch.");
    }


    @Test
    void testFetchVolumeFromDBWithInvalidType() {
        Extras extras = new Extras("InvalidType", 'S','X');
        try {
            extras.getVolume();
        } catch (SQLException e) {
            assertEquals("No data found for the given query: Type = InvalidType, Size = S", e.getMessage(), "The exception message should be 'No data found for the given query'.");
        }
    }
}
