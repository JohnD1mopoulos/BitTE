package main.java.com.BitTE.OptimizationProject;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The {@code ItemDeletionHandler} class provides functionality to handle the deletion of items 
 * from an ArrayList of {@link PackingItem}. It allows the user to choose an item to delete from 
 * a list, confirm the deletion, and optionally continue deleting more items.
 */
public class ItemDeletionHandler {
    /**
    * Displays all items currently in the Knapsack. 
    *
    * @param items a PackingItem ArrayList representing the list of chosen items
    *             (essential or non essential).
    */
    protected static void showItems(ArrayList<PackingItem> items) {
        if (items == null || items.isEmpty()) {
            System.out.println("The Knapsack is empty. No items to display!");
            return;
        }
        for (int i =0; i < items.size(); i++) {
            System.out.println((i+1) + ") " + items.get(i));//Print a number for each item for an easier read
        }
    }
    /**
    * Deletes a number of items from a PackingItem ArrayList based on the user's input
    *
    * @param items a PackingItem ArrayList representing the list of chosen items
    *              (essential or non essential).
    * @param scanner a Scanner instance for capturing the user's input.
    */
    protected static void deleteItem(ArrayList<PackingItem> items, Scanner scanner) {
        boolean stopProcess;
        while (!stopProcess) {
            // Check if there are items to delete
            if (items.isEmpty()) {
                System.err.println("No items available to delete."
                                    +"You haven't chosen any item yet");
                return; // Exit the method
            }
    
            int itemForDeletion = chooseItemForDeletion(scanner);

            if (itemForDeletion == 0) {//User want's to cancel the deletion process
                System.out.println("No item was deleted");
                return;
            } else {
                // Delete the chosen item
                System.out.printf("Item no %d, %f, has been deleted.%n",
                                        itemForDeletion,
                                        items.get(itemForDeletion - 1));
                items.remove(itemForDeletion - 1);
            }

            stopProcess = !continueDeleting(scanner);
        }
    } 
    
    /**
     * Prompts the user to pick an item to delete from the list and validates the choice.
     * 
     * @param items a PackingItem ArrayList representing the list of chosen items
     *              (essential or non essential).
     * @param scanner a Scanner instance for capturing the user's input.
     * @return an integer representing the item set to be deleted or
     *         0 if he changed his mind.
     */
    private static int chooseItemForDeletion(ArrayList<PackingItem> items, Scanner scanner) {
        while(true) {
            // Display items available for deletion
            System.out.println("You can delete the following items:");
            showItems(items);

            // Prompt the user to choose an item to delete
            System.out.println("Which one do you want to delete? (Press 0 to cancel)");

            int itemForDeletion = -1; // Variable representing the item to be deleted
            try {
                itemForDeletion = scanner.nextInt();
                scanner.nextLine(); 
    
                if (itemForDeletion == 0) {
                    System.out.println("Stopping deletion of items.");
                    return 0; // User cancelled
                } else if (itemForDeletion < 1 || itemForDeletion > items.size()) {
                    System.err.println("Invalid choice. Please select a valid item number.");
                }
                //Return the user's choice
                return itemForDeletion;
            } catch (InputMismatchException e) {
                System.err.println("Invalid input. Please enter a valid integer.");
                scanner.nextLine(); 
            }
        }
    }

    /**
     * Prompts the user to choose whether to continue deleting items or stop
     * the deletion process.
     * 
     * @param scanner a Scanner instance for capturing the user's input.
     * @return the user's choice: true if he wants to continue and false if he doesn't.
     */
    private static boolean continueDeleting(Scanner scanner) {
        // Ask the user if they want to delete another item
        System.out.println("Press 1 to delete another item.\nPress 2 to stop deleting items.");
        int userChoice = -1;//Variable representing choice to continue or stop method

        while (true) {
            try {
                userChoice = scanner.nextInt();
                scanner.nextLine(); 

                if (userChoice == 1) {//Continue deleting items
                    return true;
                } else if (userChoice == 2) {
                    System.out.println("Stopping deletion process.");
                    return false;//Stop deletion of items
                } else {
                    System.err.println("Invalid choice. Please press 1 to delete another item or 2 to stop.");
                }
            } catch (InputMismatchException e) {
                System.err.println("Invalid input. Please enter 1 or 2.");
                scanner.nextLine();
            }
        }
    }
}
