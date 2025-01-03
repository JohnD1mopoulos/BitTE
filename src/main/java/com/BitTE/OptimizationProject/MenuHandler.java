package com.BitTE.OptimizationProject;

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
class MenuHandler {

    /*Lists containing the available clothing items*/
    // Common items for both genders
    private static String[] commonClothing = {
        "T-Shirt", "Shirt", "Hoodie", "Jeans", "Sweatpants", "Trousers"
    };

    // Specific items for males
    private static String[] maleClothing = {
        "Boxers", "Shorts", "Sneakers", "Sandals", "Boots", "Socks"
    };

    // Specific items for females
    private static String[] femaleClothing = {
        "Skirts", "Panties", "Shorts", "Sneakers", "Sandals", "Boots", "Socks"
    };

    // Array containing the extra items
    private static String[] extraItems = {"Passport", "Computer", "Book"};

    //Displays the menu of the valid types of items 1. Clothing, 2. Accessory
    protected static void chooseItemType() {
    System.out.println("Press 1 to add Clothing\n"
                                +"Press 2 to add Accessory");
    }

    /**
     * Displays the Starting Menu for the user prompting him to make one of three choices:
     * 1. Add an essential item to the Knapsack.
     * 2. Delete an essential item from the Knapsack.
     * 3. Start adding non essential items.
     * 4. Exit the programm.
     */
    protected static void showStartingMenu() {
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
    protected static void showClothingMenu(char gender) {
        //Display choices common to men and women
        for (int i = 0; i < commonClothing.length; i++) {
            System.out.println("Press " + (i + 1) + " to add " + commonClothing[i]);
        }
        /*Account for the differenecs in options between male and 
        female clothing*/
        if (gender == 'M') {//Male only options
            for (int i = 0; i < maleClothing.length; i++) {
                System.out.println("Press " + (commonClothing.length + i + 1)
                                    + " to add " + maleClothing[i]);
            }
        } else {//Female only options
            for (int i = 0; i < femaleClothing.length; i++) {
                System.out.println("Press " + (commonClothing.length + i + 1) 
                                    + " to add " + femaleClothing[i]);
            }
        }
    }

    /**
     * Displays the extras menu 
     */
    protected static void showExtrasMenu() {
        for (int i = 0; i < extraItems.length; i++) {
            System.out.println("Press " + (i + 1) + " to add " + extraItems[i]);
        }
    }
}
