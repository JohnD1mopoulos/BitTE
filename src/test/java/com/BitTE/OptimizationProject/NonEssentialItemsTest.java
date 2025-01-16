package com.BitTE.OptimizationProject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class NonEssentialItemsTest {

    private NonEssentialItems nonEssentialItems;

    @BeforeEach
    void setUp() {
        // Initialize the singleton instance before each test
        nonEssentialItems = NonEssentialItems.getInstance();
        nonEssentialItems.nonEssentialItems.clear(); // Clear the list to avoid interference between tests
    }

    @Test
    void testSingletonInstance() {
        // Ensure the singleton instance is the same across calls
        NonEssentialItems instance1 = NonEssentialItems.getInstance();
        NonEssentialItems instance2 = NonEssentialItems.getInstance();
        assertSame(instance1, instance2, "Singleton instance should be the same");
    }

    @Test
    void testFillNonEssentialsAddsItems() {
        // Simulate user input using a real Scanner
        String input = "2\n1\nM\n1\nS\n5\n1\n"; // Item type, gender, item name, size, value, finish
        Scanner scanner = new Scanner(input);

        nonEssentialItems.fillNonEssentialItems(scanner, null);
        ArrayList<PackingItem> result = nonEssentialItems.nonEssentialItems;

        assertNotNull(result, "The result list should not be null");
        assertEquals(1, result.size(), "The result list should contain one item");

        PackingItem addedItem = result.get(0);
        assertEquals("T-Shirt", addedItem.getType(), "Item name should be 'Shirt'");
        assertEquals('M', addedItem.getGender(), "Item gender should be 'M'");
        assertEquals('S', addedItem.getSize(), "Item size should be 'S'");
        assertEquals(5, addedItem.getValue(), "Item value should be 5");
    }

    @Test
    void testSetValueWithValidInput() {
        // Simulate valid input
        String input = "7\n"; // Valid value
        Scanner scanner = new Scanner(input);

        int value = nonEssentialItems.setValue(scanner);
        assertEquals(7, value, "The value should be 7");
    }

    @Test
    void testSetValueWithInvalidInput() {
        // Simulate invalid input followed by valid input
        String input = "invalid\n11\n0\n5\n"; // Invalid, out-of-range, out-of-range, valid
        Scanner scanner = new Scanner(input);

        int value = nonEssentialItems.setValue(scanner);
        assertEquals(5, value, "The value should be 5 after correcting invalid inputs");
    }

    @Test
    void testFillNonEssentialsHandlesInvalidMenuChoice() {
        // Simulate invalid menu choices
        String input = "5\n2\n5\n1\nM\n1\nS\n5\n1\n"; // Invalid choice, delete, finish
        Scanner scanner = new Scanner(input);

        nonEssentialItems.fillNonEssentialItems(scanner, null);
        ArrayList<PackingItem> result = nonEssentialItems.nonEssentialItems;

        assertNotNull(result, "The result list should not be null");
        assertEquals(1, result.size(), "The result list should contain one item");

        PackingItem addedItem = result.get(0);
        assertEquals("T-Shirt", addedItem.getType(), "Item name should be 'T-Shirt'");
        assertEquals('M', addedItem.getGender(), "Item gender should be 'M'");
        assertEquals('S', addedItem.getSize(), "Item size should be 'S'");
        assertEquals(5, addedItem.getValue(), "Item value should be 5");
    }
}
