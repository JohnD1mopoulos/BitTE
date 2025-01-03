package com.BitTE.OptimizationProject;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class NonEssentialItems {
    //instance of the class
    private static NonEssentialItems instance;

    protected final ArrayList<PackingItem> nonEssentialItems = new ArrayList<>();//allowing polymorphism
    
    //private constructor
    private NonEssentialItems() {
    }
    
    //Singleton method allows access to NonEssentialItems' instance
    public static NonEssentialItems getInstance() {
        if (instance == null) {
            instance = new NonEssentialItems();
        }
        return instance;
    }

    protected ArrayList<PackingItem> fillNonessentials() {
        System.out.println("Dear user, please choose the items that you would like to carry in your suitcase: ");
        Scanner scanner = new Scanner(System.in);
        boolean addingItems = true;
        while (addingItems){
            //Display MENU for choosing type of Item
            MenuHandler.chooseItemType();
            
            //Make choice 
            int inputType = ItemInputHandler.setTypeOfItem(scanner);

             /**If Item is a piece of Clothing set the prefered sex for the item, 
             then display MENU for the process of choosing an Item
             */
            char itemGender = 'X';
            if (inputType == 1){
                itemGender = ItemInputHandler.setGender(scanner);
                MenuHandler.showClothingMenu(itemGender);
            } else {
                MenuHandler.showExtrasMenu();
            }

            //Choose Item
            String itemOfChoice = ItemInputHandler.setItemChoice(inputType, 
                                                                    itemGender, scanner);
                                                              
            //Choose the item's size
            char itemSize = ItemInputHandler.setSize(scanner);

            //Choose the item's value
            int value = setValue(scanner);

            //Input item 
            ItemInputHandler.inputItem(nonEssentialItems, inputType,
                                         itemOfChoice, itemGender, itemSize, value);

            System.out.println("Press 1 to terminate process.\n"
                                  +"Press 2 to add another item");
            boolean validChoice = false;
            while (!validChoice) {
                try {
                    int userChoice = scanner.nextInt();
                    scanner.nextLine();
                    if (userChoice == 1){
                        System.out.println("All nonesential items have been added!!!");
                        validChoice = true;
                        return nonEssentialItems; 
                    } else if (userChoice == 2) {
                        validChoice = true;//Continue adding items
                    } else {
                        System.err.println("Invalid input. Please press 1 oe 2.");
                    }
                    } catch (InputMismatchException e){
                    System.out.println("Invalid input. Please enter a valid integer.");
                    scanner.nextLine();
                }
            }
        }
        scanner.close();
        return nonEssentialItems;
    }

 
    protected int setValue(Scanner scanner) {
        System.out.println("Please enter the importance of this item for your trip on a scale from 1 to 10:(1 for the least important items - 10 for the most important items)");
            while (true) {//Infinite loop until valid input is provided
            try {
                int input = scanner.nextInt();
                scanner.nextLine();//Clear the newline character
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
