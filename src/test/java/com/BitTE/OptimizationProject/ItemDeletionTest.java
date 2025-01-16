package com.BitTE.OptimizationProject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

public class ItemDeletionTest {
    
        @Test
    void testNoItemsToDelete() {

        ArrayList<PackingItem> items = new ArrayList<>();
        /*Initialize scanner despite it not being used cause it's required
        as a parameter*/ 
        Scanner scanner = new Scanner(System.in);

        ItemDeletionHandler.deleteItem(items, scanner);

        assertTrue(items.isEmpty(), "The item list should be empty.");
    }

        @Test
    void testDeleteMultipleItems() {
        ArrayList<PackingItem> items = new ArrayList<>();
        //Add random items to the suitcase
        items.add(new Clothing("T-Shirt", 'M', 'M')); 
        items.add(new Clothing("Shirt", 'M', 'F')); 
        items.add(new Clothing("Socks", 'M', 'M')); 
        /**Simulate the user'choices: delete first item(1),  continue 
         * deleting items(1), delete second item(2) and stop deleting items(2)
        */
        String userChoices = "1\n1\n\n2\n2\n";
        // Set the input stream to simulate user input 
        ByteArrayInputStream in = new ByteArrayInputStream(userChoices.getBytes());

        Scanner scanner = new Scanner(in);

        ItemDeletionHandler.deleteItem(items, scanner);

        //Only one item should remain
        assertEquals(1, items.size(), "Only one item should remain.");
    }
}
