package com.BitTE.OptimizationProject;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.beans.Transient;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class ClothingTest {

    @Test
    void testFetchWeightFromDB() {
        Clothing clothing = new Clothing("T-Shirt", 'M', 'M');
        try {
            assertEquals(100, clothing.getWeight(), 130, "The weight should be 130.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testFetchVolumeFromDB() {
        Clothing clothing = new Clothing("T-Shirt", 'M', 'M');
        try {
            assertEquals(1400, clothing.getVolume(), 1400, "The volume should be 1400.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
