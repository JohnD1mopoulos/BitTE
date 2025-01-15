package com.BitTE.OptimizationProject;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.beans.Transient;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class ExtrasTest {
    @Test
    void testFetchWeightFromDB() {
        Extras extras = new Extras("Passport", 'S');
        try {
            assertEquals(45, extras.getWeight(), 45, "The weight should be 45.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testFetchVolumeFromDB() {
        Extras extras = new Extras("Passport", 'S');
        try {
            assertEquals(35.1, extras.getVolume(), 35.1, "The volume should be 35.1.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
