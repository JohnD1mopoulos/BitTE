/*
 * Copyright 2025 BitTE Team
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.BitTE.OptimizationProject;

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
    * Deletes a number of items from a PackingItem ArrayList based on the user's input
    *
    * @param items a PackingItem ArrayList representing the list of chosen items
    *              (essential or non essential).
    * @param scanner a Scanner instance for capturing the user's input.
    */
    protected static void deleteItem(ArrayList<PackingItem> items, Scanner scanner) {
        boolean stopProcess = false;
        while (!stopProcess) {
            // Check if there are items to delete
            if (items.isEmpty()) {
                System.err.println("No items available to delete."
                                    +"You haven't chosen any item yet");
                return; // Exit the method
            }
    
            int itemForDeletion = chooseItemForDeletion(items, scanner);

            if (itemForDeletion == 0) {//User want's to cancel the deletion process
                System.out.println("No item was deleted");
                return;
            } else {
                // Delete the chosen item
                System.out.printf("Item no %d" + items.get(itemForDeletion - 1) + ", has been deleted.%n",
                                        itemForDeletion);
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
        System.out.println("You can delete the following items:");
        MenuHandler.showItems(items);
        
        while(true) {
            // Prompt the user to choose an item to delete
            System.out.println("Which one do you want to delete? "
                              +"(Press 0 to cancel deletion of items)");

            try {
                int itemForDeletion = scanner.nextInt();// Variable representing the item to be deleted
                scanner.nextLine(); 
    
                if (itemForDeletion == 0) {
                    System.out.println("Stopping deletion of items.");
                    return itemForDeletion; // User cancelled
                }else if (itemForDeletion >= 1 && itemForDeletion <= items.size()) {
                    //Return the user's choice
                    return itemForDeletion;
                } else {
                    System.err.println("Invalid choice. Please select a valid item number.");
                }
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

        while (true) {
            try {
                int userChoice = scanner.nextInt();//Variable representing choice to continue or stop method
                scanner.nextLine(); 

                if (userChoice == 1) {//Continue deleting items
                    System.out.println("You chose to delete another item!");
                    return true;
                } else if (userChoice == 2) {
                    System.out.println("Stopping deletion process.");
                    return false;//Stop deletion of items
                } else {
                    System.err.println("Invalid choice. Please press 1 to delete another item or 2 to stop.");
                }
            } catch (InputMismatchException e) {
                System.err.println("Invalid input. Please press 1 to delete another item or 2 to stop.");
                scanner.nextLine();
            }
        }
    }
}
