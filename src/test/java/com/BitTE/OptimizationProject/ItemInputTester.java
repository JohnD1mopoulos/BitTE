package com.BitTE.OptimizationProject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

public class ItemInputTester {
        @Test
    void testSetItemChoice_ClothingFemale() {
        // Input 7 for Skirt
        Scanner scanner = new Scanner("7\n");
        String result = ItemInputHandler.setItemChoice(1, 'F', scanner);
        assertEquals("Skirts", result, "Expected item choice for female clothing is 'Skirts'");
    }

    @Test
    void testSetItemChoice_Accessory() {
        //
        Scanner scanner = new Scanner("2\n");
        //X is the default gender dor accessories
        String result = ItemInputHandler.setItemChoice(2, 'X', scanner);
        assertEquals("Laptop", result, "Expected item choice for accessory is 'Laptop'");
    }

    @Test
    void testSetItemChoice_InvalidClothingChoice() {
        //Invalid clothing choice (choices range from 0 to 13)
        Scanner scanner = new Scanner("15\n");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ItemInputHandler.setItemChoice(1, 'M', scanner);
        });
        assertEquals("Invalid clothing choice", exception.getMessage(), "Expected an invalid clothing choice exception");
    }
}
