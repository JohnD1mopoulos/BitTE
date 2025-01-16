package com.BitTE.OptimizationProject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.sql.SQLException;
import java.util.ArrayList;

class SpaceOptimizerTest {

    private SpaceOptimizer optimizer;
    private ArrayList<PackingItem> items;

    @BeforeEach
    void setUp() {
        optimizer = new SpaceOptimizer();

        // Create some test items
        items = new ArrayList<>();
        items.add(new Clothing(10, "T-Shirt", 'M', 'M'));
        items.add(new Clothing(9, "T-Shirt", 'M', 'M'));
        items.add(new Clothing(8, "T-Shirt", 'M', 'M'));
        items.add(new Clothing(7, "T-Shirt", 'M', 'M'));
    }


    @Test
    void testSolveModelWithSolution() throws SQLException {
        // Define weight and volume limits that allow a solution
        double maxWeight = 5000;   // 5kg
        double maxVolume = 3000;  

        // Solve the model
        ArrayList<PackingItem> selectedItems = optimizer.solveModel(items, maxWeight, maxVolume);

        // Verify the solution
        Assertions.assertFalse(selectedItems.isEmpty(), "There should be at least one selected item.");

        // Check that the selected items meet the constraints
        double totalWeight = selectedItems.stream().mapToDouble(value -> {
            try {
                return value.getWeight();
            } catch (SQLException e) {
                e.printStackTrace();
            }
                        return 0;
        }).sum();
        double totalVolume = selectedItems.stream().mapToDouble(value -> {
            try {
                return value.getVolume();
            } catch (SQLException e) {
                e.printStackTrace();
            }
                        return 0;
        }).sum();

        Assertions.assertTrue(totalWeight <= maxWeight, "Total weight exceeds the limit.");
        Assertions.assertTrue(totalVolume <= maxVolume, "Total volume exceeds the limit.");
    }

    @Test
    void testSolveModelWithNoSolution() throws SQLException {
        // Define  volume limit that make a solution impossible
        double maxWeight = 1000;   // 1kg
        double maxVolume = 500;  

        // Solve the model
        ArrayList<PackingItem> selectedItems = optimizer.solveModel(items, maxWeight, maxVolume);

        // Verify that no items are selected
        Assertions.assertTrue(selectedItems.isEmpty(), "No items should be selected.");
    }

    @Test
    void testSolveModelWithEmptyItems() throws SQLException {
        // Test with an empty list of items
        ArrayList<PackingItem> emptyItems = new ArrayList<>();

        // Solve the model
        ArrayList<PackingItem> selectedItems = optimizer.solveModel(emptyItems, 1000, 1000);

        // Verify the result
        Assertions.assertTrue(selectedItems.isEmpty(), "No items should be selected when the list is empty.");
    }
}
