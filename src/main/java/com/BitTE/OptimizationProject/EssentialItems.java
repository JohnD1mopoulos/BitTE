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
 * The EssentialItems class manages the list of essential items for a knapsack.
 * It provides functionality to add, delete, and manage essential items
 * and ensures that the knapsack constraints (e.g., weight, volume)
 * are respected. The class interacts with the user through menus to guide them
 *  in selecting items and verifying the constraints of the knapsack.
 */
final class EssentialItems {

    /**Static instance variable for the Singleton pattern.*/
    static EssentialItems listOfEssentialItems;

    /**Static ArrayList shared across all methods in this class representing
    the list of chosen essential items.*/
    protected final ArrayList<PackingItem> essentialItems = new ArrayList<>();
    /**User chose to add an item.*/
    private static final int ADD_ITEM = 1;
    /**User chose to delete an item.*/
    private static final int DELETE_ITEM = 2;
    /**User chose to stop adding essential items.*/
    private static final int STOP_ADDING_NON_ESSENTIAL = 3;
    /**User chose to exit the program.*/
    private static final int ABANDON_PROCESS = 4;

    // Private constructor to prevent instantiation
    private EssentialItems() { }

    /**Method to allow access to EssentialItem's singleton instance.
     *
     * @return an instance of class EssentialItems
     */
    public static EssentialItems getInstance() {
        if (listOfEssentialItems == null) {
            //Creation of the instance only once
            listOfEssentialItems = new EssentialItems();
        }
        return listOfEssentialItems;
    }


    /**
     * Handles the user's input on whether to add an item, delete an item
     *  or abandon the process and checks the it's validity.
     * @param scanner representing a scanner object for the user's input
     * @return 1 - If the user wants to add an item.
     *         2 - if the user wants to delete an item(s).
     *         3 - if the user wants to start adding non essential items
     *         4 - if the user wants to abandon the process.
     */
    protected int getUserMenuChoice(final Scanner scanner) {

        while (true) { //Never ending loop to ensure choice being made
            try {
                System.out.println("Enter your choice");
                int userChoice = scanner.nextInt();
                scanner.nextLine();

                if (userChoice > 4 || userChoice <= 0) {
                    System.err.println("Invalid choice."
                                        + " Please enter 1, 2, 3 or 4");
                } else {
                    return userChoice;
                }
            } catch (InputMismatchException e) {
                System.err.println("Invalid input."
                                    + " Please enter a valid integer.");
                scanner.nextLine();
            }
        }
    }

    /**
     * Prompts the user to add a clothing item or an accessory to the list of
     * essential items that he wants to take with him.
     *
     * @param scanner representing a scanner object for the user's input
     */
    private void addItem(Scanner scanner) {
        //Display MENU for choosing type of Item
        MenuHandler.chooseItemType();

        //Make choice
        int inputType = ItemInputHandler.setTypeOfItem(scanner);

        //If Item is a piece of Clothing set the prefered sex for the item
        char itemGender = 'X';
        if (inputType == 1) {
            itemGender = ItemInputHandler.setGender(scanner);
        }

        //Display MENU for the process of choosing an Item
        if (inputType == 1) {
            MenuHandler.showClothingMenu(itemGender);
        } else {
            MenuHandler.showExtrasMenu();
        }

        //Choose Item
        String itemOfChoice = ItemInputHandler.setItemChoice(inputType,
                                                            itemGender,
                                                            scanner);

        //Choose the item's size
        char itemSize = ItemInputHandler.setSize(scanner);

        //Choose how many times the item will be packed
        int numOfInsertions = ItemInputHandler.getNumberOfItems(scanner);

        //Input item
        ItemInputHandler.inputItem(essentialItems, inputType, itemOfChoice,
                                    itemGender, itemSize, numOfInsertions);
    }

    /**
     * Checks if the weight and volume constraints are respected and shows
     * a respective message.
     * If the constraints aren't respected then the user gets prompt
     * between deleting some items and abandoning the whole process.
     *
     * @param maxWeight representing the maximum weight of items that can be
     *                  added to the Knapsack.
     * @param maxVolume representing the maximum weight of items that can be
     *                  added to the Knapsack.
     * @param scanner for user input.
     * @return true if the program is to continue running
     *         (constraints are respected).
     *         false if the program is to stop running
     *         (constraint's aren't respected
     *         and the user wont fix them).
     */
    private boolean manageConstraints(final double maxWeight,
                                    final double maxVolume,
                                    final Scanner scanner) {
        //Check constraints
        int constraintsStatus = EssentialConstraints.
        checkConstraints(essentialItems,
                             maxWeight,
                             maxVolume);

        //Provide feedback based on constraints
        EssentialConstraints.showConstraintFeedback(essentialItems,
                                                    constraintsStatus,
                                                    maxWeight,
                                                    maxVolume);

        //Handle different constraint scenarios
        if (constraintsStatus != 1) { //Constraints arent met

        boolean constraintProblemSolved = EssentialConstraints.
                                        fixConstraints(essentialItems,
                                        scanner,
                                        maxWeight,
                                        maxVolume);

            if (constraintProblemSolved) {
            //The user deleted some items and now constraints are respected
                System.out.println("Well done! The constraints are"
                                    + " now respected.");
                return true;
            } else {
                System.out.println("Terminating process. Goodbye!!!");
                return false; //Knapsack wont be filled
            }

        }  else { //Constraints are respected from the begining
            return true;
        }
    }


    /**
    * Fills ArrayList essentialItems with the inputs of the user and confirms
    * if the constraints are met with each added item.
    *
    * @param maxWeight representing the maximum weight of items that can be
    *                  added to the Knapsack.
    * @param maxVolume representing the maximum volume of items that can be
    *                  added to the Knapsack.
    * @param scanner for user input.
    * @return a boolean variable that confirms the continuation of the item
    *         input operation if the constraints are still met.
    */
    protected boolean fillEssential(final double maxWeight,
                                    final double maxVolume,
                                    final Scanner scanner) {

        boolean processRunning = true;
        System.out.println("INSERTION OF ESSENTIAL ITEMS\n"
                            + "----------------------------");
        while (processRunning) {
            //Display STARTING MENU
            MenuHandler.showStartingMenu();
            int userMenuChoice = getUserMenuChoice(scanner);

            if (userMenuChoice == ADD_ITEM) {
                addItem(scanner);
            } else if (userMenuChoice == DELETE_ITEM) {
                ItemDeletionHandler.deleteItem(essentialItems, scanner);
            } else if (userMenuChoice == STOP_ADDING_NON_ESSENTIAL) {
                //User wants to stop adding essential items
                return true;
            } else if (userMenuChoice == ABANDON_PROCESS) {
                essentialItems.clear(); //Delete any inputed essential items
                return false;
            }

            /*
             * Continue by checking state of constraints and if the user
             * wants to continue the process or not.
             */
            boolean continueAddingItems = manageConstraints(maxWeight,
                                                            maxVolume,
                                                            scanner);
            if (!continueAddingItems) {
                return false;
            }
        }
        return false; //Unrechable code. Was put according to good practices
    }
 }
