package com.BitTE.OptimizationProject;

import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import main.java.com.BitTE.OptimizationProject.CreateSuitcase;

/**
 * The EssentialItems class manages the list of essential items for a knapsack. 
 * It provides functionality to add, delete, and manage essential items 
 * and ensures that the knapsack constraints (e.g., weight, volume) are respected.
 * The class interacts with the user through menus to guide them in selecting items 
 * and verifying the constraints of the knapsack.
 */
class EssentialItems {

    // Static instance variable for the Singleton pattern
    private static EssentialItems listOfEssentialItems;

    /**Static ArrayList shared across all methods in this class representing
    the list of chosen essential items*/
    protected final ArrayList<PackingItem> essentialItems = new ArrayList<>();
    //Scanner object for user to input choices
    private Scanner scanner = new Scanner(System.in);
    // Constants for user menu choices
    private static final int ADD_ITEM = 1;
    private static final int DELETE_ITEM = 2;
    private static final int START_NON_ESSENTIAL = 3;
    private static final int ABANDON_PROCESS = 4;

    // Private constructor to prevent instantiation
    private EssentialItems() { }

    /**Method to allow access to EssentialItem's singleton instance */
    public static EssentialItems getInstance() {
        if (listOfEssentialItems == null) {
            listOfEssentialItems = new EssentialItems();  // Create the instance only once
        }
        return listOfEssentialItems;
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
    private int getUserMenuChoice() {
        
        while(true) {//Never ending loop to ensure choice being made
            try {
                System.out.println("Enter your choice");
                int userChoice = scanner.nextInt();
                scanner.nextLine();
                
                if (userChoice < ADD_ITEM || userChoice > ABANDON_PROCESS) {
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
    private void addItem() {
        //Display MENU for choosing type of Item
        MenuHandler.chooseItemType();
          
        //Make choice 
        int inputType = ItemInputHandler.setTypeOfItem(scanner);

        //If Item is a piece of Clothing set the prefered sex for the item
        char itemGender = 'X';
        if (inputType == 1){
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
                                                            itemGender, scanner);

        //Choose the item's size
        char itemSize = ItemInputHandler.setSize(scanner);

        //Input item 
        ItemInputHandler.inputItem(essentialItems, inputType, itemOfChoice, itemGender, itemSize);
    }

   
    /**
    * Fills ArrayList essentialItems with the inputs of the user and confirms 
    * if the constraints are met with each added item
    *
    * @param maxWeight representing the maximum weight of items that can be added to the Knapsack.
    * @param maxVolume representing the maximum volume of items that can be added to the Knapsack.
    * @return a boolean variable that confirms the continuation of the item input operation 
    *         if the constraints are still met.
    */
    protected boolean fillEssential(double maxWeight, double maxVolume){
        
        boolean processRunning = true;
        System.out.println("INSERTION OF ESSENTIAL ITEMS\n"
                            +"----------------------------");
        while (processRunning){
            //Display STARTING MENU
            MenuHandler.showStartingMenu();
            int userMenuChoice = getUserMenuChoice();

            if (userMenuChoice == ADD_ITEM) {//User wants to add item
                addItem();
            } else if (userMenuChoice == DELETE_ITEM) {//User wants to delete item(s)
                ItemDeletionHandler.deleteItem(essentialItems, scanner);
            } else if (userMenuChoice == START_NON_ESSENTIAL) {//User wants to start adding essential items
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
            EssentialConstraints.showConstraintFeedback(essentialItems, constraintsStatus, maxWeight, maxVolume);
        
            //Handle different constraint scenarios
            if (constraintsStatus != 1) {//Constraints arent met
        
                boolean constraintProblemSolved = EssentialConstraints.
                                                fixConstraints(essentialItems,
                                                            scanner,
                                                            CreateSuitcase.maxWeight,
                                                            CreateSuitcase.maxVolume);
    
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
