package main.java.com.BitTE.OptimizationProject;

/**
* The EssentialItems class represents a dynamic system for managing essential items in a knapsack.
 * It ensures that the weight and volume constraints of the knapsack are respected during the process of 
 * adding items. This class allows users to add and remove essential items and checks if the knapsack 
 * meets the specified weight and volume limits.
 * 
 * Key responsibilities:
 * - Manage essential items by adding them to or removing them from the knapsack.
 * - Enforce the weight and volume constraints by checking if the current items respect the limits.
 * - Provide user interaction through various menus, allowing users to add or remove items.
 * - Give feedback to the user about the current state of constraints and allow corrections to be made if necessary.
 * 
 * Core Features:
 * - Item addition: Users can add items to the knapsack and specify their attributes (type, size, etc.).
 * - Constraint enforcement: After each item is added, the class checks if the knapsack exceeds the weight and volume limits.
 * - Dynamic user interaction: Users can terminate the process, continue adding items, or fix violations by removing items.
 * 
 * Dependencies:
 * - PackingItem: A class that represents individual items in the knapsack.
 * - ParameterControl: A helper class that handles item details, constraint checking, and item deletion.
 * 
 * This class is used in a system where users interactively manage the contents of a knapsack to ensure the
 * items fit within a specified weight and volume limit. The process allows users to modify the knapsack by
 * adding and removing essential items until the constraints are respected.
 */

import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

protected class EssentialItems {
    /**  Static ArrayList shared across all methods in this class representing one
    "Knapsack" for the seential items*/
    protected static final ArrayList<PackingItem> essentialItems = new ArrayList<>();
    //Scanner object for user to input choices
    private static Scanner scanner = new Scanner(System.in);

    /**
     * Displays the Starting Menu for the user prompting him to make one of three choices:
     * 1. Add an essential item to the Knapsack.
     * 2. Delete an essential item from the Knapsack.
     * 3. Start adding non essential items.
     * 4. Exit the programm.
     */
    private static void startingMenu() {
        System.out.println("------------------------------\n"
                        +"Press 1 to add essential items.\n"
                        +"Press 2 to delete an essential item(s).\n"
                        +"Press 3 to start adding non essential items"
                        +"Press 4 to abandon process"
                        +"--------------------------------");
    }

    /**
     * Handles the user's input on whether to add an item, delete an item or abandon the process 
     * and checks the it's validity.
     * 
     * @return 1 - If the user wants to add an item.
     *         2 - if the user wants to delete an item(s).
     *         3 - if the user wants to start adding non essential items
     *         4 - if the user wants to abandon the process.
     */
    private static int getUserMenuChoice() {
        
        while(true) {//Never ending loop to ensure choice being made
            try {
                System.out.println("Enter your choice");
                int userChoice = scanner.nextInt();
                scanner.nextLine();
                
                if (userChoice > 4 || userChoice <= 0) {
                    System.err.println("Invalid choice. Please enter 1, 2, 3 or 4");
                } else {
                    return userChoice;
                }
            } catch (InputMismatchException e) {
                System.err.println("Invalid input. Please enter a valid integer.");
                scanner.nextLine();
            }
        }
        return -1;
    }

    /**
     * Prompts the user to add a clothing item or an accessory to the list of
     * essential items that he wants to take with him.
     */
    private static void addItem() {
        //Display MENU for choosing type of Item
        System.out.println("Press 1 to add Clothing\n"
                            +"Press 2 to add other item");
          
        //Make choice 
        int inputType = ParameterControl.setTypeOfItem(scanner);

        //If Item is a piece of Clothing set the prefered sex for the item
        char itemGender = 'X';
        if (inputType == 1){
            itemGender = ParameterControl.setGender(scanner);
        }

        //Display MENU for the process of choosing an Item
        if (inputType == 1) {
            ParameterControl.clothingMenu(itemGender);
        } else {
            ParameterControl.extrasMenu();
        }

        //Choose Item
        String itemOfChoice = ParameterControl.setItemChoice(inputType,
                                        itemGender,
                                        scanner);

        //Choose the item's size
        char itemSize = ParameterControl.setSize(scanner);

        //Input item 
        ParameterControl.inputItem(essentialItems, scanner);
    }

   
    /**
    * Fills ArrayList essentialItems with the inputs of the user and confirms if the constraints are met with each added item
    *
    * @param s The Weight and Volume of the knapsack
    * @return A boolean variable that confirms the continuation of the operation if the constraints are still met.
    */
    private static boolean fillEssential(double maxWeight, double maxVolume){
        
        boolean processRunning = true;
        System.out.println("INSERTION OF ESSENTIAL ITEMS\n"
                            +"----------------------------");
        while (processRunning){
            //Display STARTING MENU
            startingMenu();
            int userMenuChoice = getUserMenuChoice();

            if (userMenuChoice == 1) {//User wants to add item
                addItem();
            } else if (userMenuChoice == 2) {//User wants to delete item(s)
                ParameterControl.deleteItem(essentialItems, scanner);
            } else if (userMenuChoice == 3) {//User wants to start adding essential items
                return true;
            } else {//User wants to abandon process
                return false;
            }

            /**
             * Continue by checking state of constraints and checking if the user
             * wants to continue the process or not 
             */
            
             //Check constraints
            int constraintsStatus = EssentialConstraints.
                                checkConstraints(essentialItems,
                                                maxWeight,
                                                maxVolume);
        
            //Provide feedback based on constraints
            constraintFeedback(essentialItems, constraintsStatus, maxWeight, maxVolume);
        
            //Handle different constraint scenarios
            if (constraintsStatus != 1) {//Constraints arent met
        
                boolean constraintProblemSolved = EssentialConstraints.
                                                fixConstraints(essentialItems,
                                                            scanner,
                                                            maxWeight,
                                                            maxVolume);
    
                if (constraintProblemSolved) {
                    //The user deleted some items and now constraints are respected
                    System.out.println("Well done! The constraints are now respected.");
                } else {
                    System.out.println("Terminating process. Goodbye!!!");
                    return false;//Knapsack wont be filled
                }
    
             }  
        }
        return false;//Unrechable code. Was put according to good practices 
    }
 }
