package com.BitTE.OptimizationProject;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class PackingItemTest {
    @Test
    void testConstructorForEssentialItems() {
        PackingItem packingItem = new Clothing("T-Shirt", 'M', 'M');
        assertEquals(0, packingItem.getValue(), "The value should be 0.");
        assertEquals("T-Shirt", packingItem.getType(), "The type should be T-Shirt.");
        assertEquals('M', packingItem.getSize(), "The size should be M.");
        assertEquals('M', packingItem.getGender(), "The gender should be M");
    }

    @Test
    void testConstructorForNonEssentialItems() {
        PackingItem packingItem = new Clothing(1, "T-Shirt", 'M', 'M');
        assertEquals(1, packingItem.getValue(), "The value should be 1.");
        assertEquals("T-Shirt", packingItem.getType(), "The type should be T-Shirt.");
        assertEquals('M', packingItem.getSize(), "The size should be M.");
        assertEquals('M', packingItem.getGender(), "The gender should be M");
    }

    @Test
    void testValidateAttributeWithValidAttribute() {
        PackingItem packingItem = new Clothing("T-Shirt", 'M', 'M');
        assertDoesNotThrow(() -> {
            packingItem.validateAttribute("volume");
            packingItem.validateAttribute("weight");
        });
    }

    @Test
    public void testValidateAttributeWithInvalidAttribute() {
        PackingItem packingItem = new Clothing("T-Shirt", 'M', 'M');
        String invalidAttribute = "height";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            packingItem.validateAttribute(invalidAttribute);
        });
        assertEquals("Invalid attribute: " + invalidAttribute, exception.getMessage());
    }
}