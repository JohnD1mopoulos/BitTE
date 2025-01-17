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

/**
 * The {@code MenuHandler} class is responsible for displaying various
 *  menus to the user based on their previous selections, such as gender
 *  and item types. It allows the user to select specific clothing or 
 *  accessory items based on their preferences.
 * 
 * This class provides methods for displaying:
 * - A menu to choose clothing items based on gender.
 * - A menu to choose from additional items like accessories
 *   (e.g., passport, computer, book).
 * - A menu to choose following steps of the essential and nonessential
 *   item input procedure.
 * - A menu showcasing all the items added to a PackingItem Knapsack.
 */
class MenuHandler {

    //Lists containing the available clothing items
    /** Common items for both genders*/
    private static String[] commonClothing = {
        "T-Shirt", "Shirt", "Hoodie", "Jeans", "Sweatpants", "Trousers"
    };

    /**Specific items for males*/
    private static String[] maleClothing = {
        "Boxers", "Shorts", "Sneakers", "Sandals", "Boots", "Socks"
    };

    /**Specific items for females*/
    private static String[] femaleClothing = {
        "Skirt", "Panties", "Shorts", "Sneakers", "Sandals", "Boots", "Socks"
    };

    /**Array containing the extra items*/
    private static String[] extraItems = {"Passport", "Computer", "Book"};

    /**Displays the menu of the valid types of items 1.Clothing, 2.Accessory*/
    protected static void chooseItemType() {
    System.out.println("Press 1 to add Clothing\n"
                                +"Press 2 to add Accessory");
    }



    /**
     * Displays the menu for the user prompting him to make one of four choice:
     * 1. Stop adding nonessential items to the Knapsack.
     * 2. Add a nonessential item to the Knapsack.
     * 3. Delete a nonessential item from the list of nonessentialitems.
     * 4. Exit the programm.
     */
    protected static void showNonEssentialItemsMenu() {
        System.out.println("------------------------------\n"
                        +"Press 1 to stop adding nonessential items.\n"
                        +"Press 2 to add an nonessential item.\n"
                        +"Press 3 to delete a nonessential item(s).\n"
                        +"Press 4 to terminate process.\n"
                        +"--------------------------------");
    }

    /**
     * Displays the Starting Menu for the user prompting him to make one of
     * three choices:
     * 1. Add an essential item to the Knapsack.
     * 2. Delete an essential item from the Knapsack.
     * 3. Stop adding essential items.
     * 4. Exit the programm.
     */
    protected static void showStartingMenu() {
        System.out.println("------------------------------\n"
                        +"Press 1 to add essential items.\n"
                        +"Press 2 to delete an essential item(s).\n"
                        +"Press 3 to stop adding essential items\n"
                        +"Press 4 to abandon process\n"
                        +"--------------------------------");
    }

    /**
    * Displays all items currently in the Knapsack. 
    *
    * @param items a PackingItem ArrayList representing the list of chosen 
    *              items (essential or non essential).
    */
    protected static void showItems(ArrayList<PackingItem> items) {
        if (items == null || items.isEmpty()) {
            System.out.println("The Knapsack is empty. No items to display!");
            return;
        }
        for (int i =0; i < items.size(); i++) {
            //Print a number for each item for an easier read
            System.out.println((i+1) + ") " + items.get(i));
        }
    }

    /** 
     *Displays the appropriate clothing menu based on the user's
     * chosen gender for the item.
     * 
     * @param gender a char representing the user's choice 
     *               ('M' for male, 'F' for female).
    */
    protected static void showClothingMenu(char gender) {
        //Display choices common to men and women
        for (int i = 0; i < commonClothing.length; i++) {
            System.out.println("Press " + (i + 1) + " to add " 
                                + commonClothing[i]);
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
            System.out.println("Press " + (i + 1) + " to add " 
                                + extraItems[i]);
        }
    }
}
