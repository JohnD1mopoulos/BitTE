package com.BitTE.OptimizationProject;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class PackingItemTest {
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

        // Expect IllegalArgumentException for an invalid attribute
        String invalidAttribute = "height";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            packingItem.validateAttribute(invalidAttribute);
        });

        // Verify the exception message
        assertEquals("Invalid attribute: " + invalidAttribute, exception.getMessage());
    }
}