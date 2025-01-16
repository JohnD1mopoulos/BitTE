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
 * Represents the management of non-essential items within the application.
 * Implements a singleton pattern to ensure a single instance is used throughout the program.
 */
class NonEssentialItems {

    /**
     * The single instance of the class.
     */
    private static NonEssentialItems instance;

    /**
     * A list to store non-essential items, allowing polymorphism with PackingItem.
     */
    protected final ArrayList<PackingItem> nonEssentialItems = new ArrayList<>();
    
    /**
     * Private constructor to enforce the singleton pattern.
     */
    private NonEssentialItems() {
    }
    
    /**
     * Provides access to the single instance of NonEssentialItems.
     * If the instance does not already exist, it is created.
     *
     * @return the single instance of NonEssentialItems.
     */
    public static NonEssentialItems getInstance() {
        if (instance == null) {
            instance = new NonEssentialItems();
        }
        return instance;
    }
    
    /**
     * Handles the process of adding, managing, and deleting non-essential items.
     *
     * @param scanner the Scanner object for reading user input.
     * @param essentialItemsManager the manager for essential items, used only in case of process termination.
     * @return true if non-essential items were successfully added, false otherwise.
     */
    public boolean fillNonEssentialItems(Scanner scanner, EssentialItems essentialItemsManager) {
        System.out.println("----------------------------\n"
        +"INSERTION OF NONESSENTIAL ITEMS\n"
        +"----------------------------");
        boolean processRunning = true;
        while (processRunning) {
            MenuHandler.showNonEssentialItemsMenu();
            try {
                int userChoice = scanner.nextInt();
                if (userChoice == 1){
                    if (nonEssentialItems.isEmpty()) {
                        System.out.println("No nonessential items added.");
                        return false;
                    } else {
                        System.out.println("All nonesential items have been added!!!");
                        return true;
                    } 
                } else if (userChoice == 2) {
                    addNonEssentials(scanner);
                } else if (userChoice == 3) {
                    ItemDeletionHandler.deleteItem(nonEssentialItems, scanner);//Delete item(s)
                } else if (userChoice == 4) {
                    essentialItemsManager.essentialItems.clear();
                    nonEssentialItems.clear();
                    return false;
                } else {
                    System.err.println("Invalid input. Please press 1, 2, 3 or 4.");
                }
                } catch (InputMismatchException e){
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.nextLine();
            }
        }
        return false;//Unrechable code, added for good practices
    }
    
    /**
     * Facilitates the addition of non-essential items by prompting the user for input.
     *
     * @param scanner the Scanner object for reading user input.
     */
    protected void addNonEssentials(Scanner scanner) {
        //Display MENU for choosing type of Item
        MenuHandler.chooseItemType();
        
        // Determine the type of item. 
        int inputType = ItemInputHandler.setTypeOfItem(scanner);

        /**
         * If the item is clothing, prompt the user for the preferred gender
         * and display the appropriate menu.
         */
        char itemGender = 'X';
        if (inputType == 1){
            itemGender = ItemInputHandler.setGender(scanner);
            MenuHandler.showClothingMenu(itemGender);
        } else {
            MenuHandler.showExtrasMenu();
        }

        // Get the specific item choice from the user.
        String itemOfChoice = ItemInputHandler.setItemChoice(inputType, 
                                                                itemGender, scanner);
                                                            
        // Get the item's size from user.
        char itemSize = ItemInputHandler.setSize(scanner);

        //Get the item's value from user.
        int value = setValue(scanner);

        // Add the item to the non-essential items list. 
        ItemInputHandler.inputItem(nonEssentialItems, inputType,
                                        itemOfChoice, itemGender, itemSize, value);
    }

    /**
     * Prompts the user to enter the importance value for an item, ensuring it is between 1 and 10.
     *
     * @param scanner the Scanner object for reading user input.
     * @return the validated importance value.
     */
    protected int setValue(Scanner scanner) {
        System.out.println("Please enter the importance of this item for your"
                +" trip on a scale from 1 to 10:(1 for the least important"
                +" items - 10 for the most important items)");
            while (true) {//Infinite loop until valid input is provided
            try {
                int input = scanner.nextInt();
                if (input < 1 || input > 10) {//If value is not in the accepted range
                    System.out.println("Invalid input. Give me an integer ranging from 1 to 10.");
                } else {//Item is in the accepted range
                    return input;
                }
            } catch (InputMismatchException e) {
                System.err.println("Invalid input. Please select a valid integer");
                scanner.nextLine();
            }
        }
    }
}
