package com.BitTE.OptimizationProject;

import java.util.ArrayList;
import java.util.Scanner;

public class ResultPresenter {
    
    public void showResults(ArrayList<PackingItem> essentialList, ArrayList<PackingItem> selectedItems, Scanner scanner) {
        System.out.println("------ SUITCASE FINAL CONTENTS ------");
        
        // Display essential items
        if (essentialList != null && !essentialList.isEmpty()) {
            System.out.println("--- ESSENTIAL ITEMS PACKED ---");
            for (PackingItem item : essentialList) {
                System.out.println("* " + item);
            }
        } else {
            System.out.println("--- No essential items were packed. ---");
        }

        // Display non-essential items
        if (selectedItems != null && !selectedItems.isEmpty()) {
            System.out.println("--- NON-ESSENTIAL ITEMS PACKED ---");
            for (PackingItem item : selectedItems) {
                System.out.println("* " + item);
            }
        } else {
            System.out.println("--- No non-essential items were packed. ---");
        }

        // Handle case where no items are packed
        if ((essentialList == null || essentialList.isEmpty()) &&
            (selectedItems == null || selectedItems.isEmpty())) {
            System.out.println("You've selected no items whatsoever!");
            System.out.println("Goodbye!!!!!!");
        }
    }
}
