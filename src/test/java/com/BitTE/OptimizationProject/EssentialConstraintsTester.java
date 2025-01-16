package com.BitTE.OptimizationProject;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class EssentialConstraintsTester {

        @Test
    void testCalculateSumOfWeights() {
        ArrayList<PackingItem> items = new ArrayList<>();
        items.add(new Clothing("T-Shirt", 'M', 'M')); 
        items.add(new Clothing("Shirt", 'M', 'F')); 
        items.add(new Clothing("Socks", 'M', 'M')); 

        double totalWeight = EssentialConstraints.calculateSumOfAttributes(items, t -> {
        try {
            return t.getWeight();
        } catch (SQLException e) {
            return 0.0; // Return default weight
        }
        });

        assertEquals(340, totalWeight, 0.001, "The total weight should be 340.");
    }

    @Test
    void testEmptyList() {
        ArrayList<PackingItem> items = new ArrayList<>();

        double totalWeight = EssentialConstraints.calculateSumOfAttributes(items, t -> {
            try {
                return t.getWeight();
            } catch (SQLException e) {
                return 0.0;
            }
        });

        assertEquals(0.0, totalWeight, 0.001, "The total should be 0.0 for an empty list.");
    }

        @Test
    void testBothConstraintsRespected() {
 
        ArrayList<PackingItem> items = new ArrayList<>();
        PackingItem item1 = new Clothing("T-Shirt", 'M', 'M');
        PackingItem item2 = new Clothing("Shirt", 'M', 'F');

        items.add(item1);
        items.add(item2);

        double maxWeight = 0;
        double maxVolume = 100000.0;

        int result = EssentialConstraints.checkConstraints(items, maxWeight, maxVolume);

        assertEquals(3, result, "Both weight and volume constraints should be respected.");
    }

}
