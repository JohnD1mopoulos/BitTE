package main.java.com.BitTE.OptimizationProject;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The {@code MenuHandler} class is responsible for displaying various menus to the user 
 * based on their previous selections, such as gender and item types. It allows the user 
 * to select specific clothing or accessory items based on their preferences.
 * 
 * This class provides methods for displaying:
 * - A menu to choose clothing items based on gender.
 * - A menu to choose from additional items like accessories (e.g., passport, computer, book).
 * - A menu to choose following steps of the essential item input procedure.
 * - A menu showcasing all the items added to a PackingItem Knapsack.
 */
protected class MenuHandler {

    /**
     * Displays the Starting Menu for the user prompting him to make one of three choices:
     * 1. Add an essential item to the Knapsack.
     * 2. Delete an essential item from the Knapsack.
     * 3. Start adding non essential items.
     * 4. Exit the programm.
     */
    protected static void startingMenu() {
        System.out.println("------------------------------\n"
                        +"Press 1 to add essential items.\n"
                        +"Press 2 to delete an essential item(s).\n"
                        +"Press 3 to start adding non essential items"
                        +"Press 4 to abandon process"
                        +"--------------------------------");
    }

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
     *Displays the appropriate clothing menu based on the user's chosen gender for the item.
        * 
        * @param gender a char representing the user's choice ('M' for male, 'F' for female).
        */
    protected static void clothingMenu(char gender) {
        if (gender == 'M') {//If the prefered gender is Male
            System.out.println("Press 1 to add a T-Shirt\n"
                                +"Press 2 to add a Shirt\n"
                                +"Press 3 to add a Hoodie\n"
                                +"Press 4 to add Jeans\n"
                                +"Press 5 to add Sweatpants\n"
                                +"Press 6 to add Trousers\n"
                                +"Press 7 to add Boxers\n"
                                +"Press 8 to add Shorts\n"
                                +"Press 9 to add Sneakers\n"
                                +"Press 10 to add Sandals\n"
                                +"Press 11 to add Boots\n"
                                +"Press 12 to add Socks");
        } else {//If the prefered gender is Female
            System.out.println("Press 1 to add a T-Shirt\n"
                                +"Press 2 to add a Shirt\n"
                                +"Press 3 to add a Hoodie\n"
                                +"Press 4 to add Jeans\n"
                                +"Press 5 to add Sweatpants\n"
                                +"Press 6 to add Trousers\n"
                                +"Press 7 to add Skirts\n"
                                +"Press 8 to add Panties"
                                +"Press 9 to add Shorts\n"
                                +"Press 10 to add Sneakers\n"
                                +"Press 11 to add Sandals\n"
                                +"Press 12 to add Boots"
                                +"Press 13 to add Socks");
        }
    }

        /**
     * Displays the extras menu 
     */
    protected static void extrasMenu() {
        System.out.println("Press 1 to add Passport\n"
                            +"Press 2 to add Computer\n"
                            +"Press 3 to add Book");
        }
}
