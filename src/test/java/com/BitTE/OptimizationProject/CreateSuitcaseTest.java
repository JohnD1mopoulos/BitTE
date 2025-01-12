package com.BitTE.OptimizationProject;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Scanner;

class CreateSuitcaseTest {

    private CreateSuitcase suitcase;

    @BeforeEach
    void setUp() {
        // Create a new instance of CreateSuitcase for each test
        Scanner scanner = new Scanner("10000\n50\n40\n30\n"); // Mock input: weight and dimensions
        CreateSuitcase.resetInstance(); // reset Singleton for each test
        suitcase = CreateSuitcase.getInstance(scanner); // Create new instance
    }

    @Test
    void testSingletonInstance() {
        // Test Singleton operation
        Scanner scanner = new Scanner("2000\n10\n10\n10\n");
        CreateSuitcase secondInstance = CreateSuitcase.getInstance(scanner);

        // Use assertSame to check if both instances are the same
        assertSame(suitcase, secondInstance, "The Singleton instances must be the same.");
    }

    @Test
    void testMaxWeight() {
        // Check if maxWeight has the expected value 
        assertEquals(10000, suitcase.getMaxWeight(), "The max weight should be 10000 grams.");
    }

    @Test
    void testMaxVolume() {
        // Calculate expected volume and compare it to the saved value of maxVolume
        double expectedVolume = 50 * 40 * 30; // Length * Width * Height
        assertEquals(expectedVolume, suitcase.getMaxVolume(), "The max volume calculation is incorrect.");
    }

    @Test
    void testInvalidInputHandling() {
        // Check invalid input handling
        Scanner scanner = new Scanner("-100\n-50\nabc\n0\n10\n");
        CreateSuitcase.resetInstance(); // Reset Singleton
        CreateSuitcase invalidSuitcase = CreateSuitcase.getInstance(scanner);

        // If an invalid value is entered, the first valid value for weight is 10 (positive value)
        assertEquals(10, invalidSuitcase.getMaxWeight(), "The suitcase should accept the first valid positive input.");
    }
}
