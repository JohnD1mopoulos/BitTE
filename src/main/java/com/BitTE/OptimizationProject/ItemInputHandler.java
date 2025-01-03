package com.BitTE.OptimizationProject;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The {@code ItemInputHandler} class provides functionality for handling user input 
 * related to the addition of clothing items or accessories to a packing list. It prompts 
 * the user to choose between different types of items, genders (for clothing), and sizes 
 * and then allows the user to input those items into a list.
 * 
 * This class includes methods for:
 * - Asking the user to select the type of item (clothing or accessory).
 * - Prompts to select specific items, such as clothing based on gender or accessories.
 * - Validating user input to ensure valid choices for item type, item choice, gender, and size.
 * - Collecting all necessary information to create and add an item to the packing list.
 */
class ItemInputHandler {
    /**
    * Prompts the user to choose between inputting a clothing item or an accessory.
    *
    * This method ensures robust handling of user input, allowing only valid integers (1 or 2) as choices.
    * If the input is invalid, the user is repeatedly prompted until a valid input is provided.
    *
    * @param scanner a Scanner instance for capturing the user's input.
    * @return an integer representing the user's choice: 1 for Clothing, or 2 for Accessory.
    */
    protected static int setTypeOfItem(Scanner scanner) {
        int choice;
        while (true) {
            try {
                choice = scanner.nextInt();
                if (choice == 1 || choice == 2) {
                    return choice;
                } else {
                    System.out.println("Invalid input. Please give me 1 to input clothing or 2 to input an accessory.");
                }
            } catch (InputMismatchException e) {
                System.err.println("Invalid Input. Please give me a valid integer.");
                scanner.next();
            }
        }
    }

    /**
    * Prompts the user to pick what item he wants to input depending on if it's a clothing
    * item or an accessory.
    * 
    * @param itemType representing the user's previous choice for the type of item he will be inputting
    *             (1 for clothing, or 2 for an accessory).
    * @param itemGender a char representing the user's choice of gender
    *             ('M' for male, 'F' for female).
    * @param scanner a Scanner instance for capturing the user's input.
    * @return the user's choice as a String
    */
    protected static String setItemChoice(int itemType,char itemGender,Scanner scanner) {

        int choiceOfItem = validateChoiceOfItem(itemType, itemGender, scanner);//Get user choice
                                    
        if (itemType == 1) {//Item is a piece of Clothing
            if (itemGender == 'M') {//Return the appropriate item if the selected gender is Male
                switch (choiceOfItem) {
                        case 1 : return "T-Shirt";
                        case 2 : return "Shirt";
                        case 3 : return "Hoodie";
                        case 4 : return "Jeans";
                        case 5 : return "Sweatpants";
                        case 6 : return "Trousers";
                        case 7 : return "Boxers";
                        case 8 : return "Shorts";
                        case 9 : return "Sneakers";
                        case 10 : return "Sandals";
                        case 11 : return "Boots";
                        case 12 : return "Socks";
                        default: throw new IllegalArgumentException("Invalid clothing choice");
                }
            } else {//Return the appropriate item if the selected gender is 'F'
                switch (choiceOfItem) {
                        case 1 : return "T-Shirt";
                        case 2 : return "Shirt";
                        case 3 : return "Hoodie";
                        case 4 : return "Jeans";
                        case 5 : return "Sweatpants";
                        case 6 : return "Trousers";
                        case 7 : return "Skirts";
                        case 8 : return "Panties";
                        case 9 : return "Shorts";
                        case 10 : return "Sneakers";
                        case 11 : return "Sandals";
                        case 12 : return "Boots";
                        case 13 : return "Socks";
                        default: throw new IllegalArgumentException("Invalid clothing choice");
                }
            }
        } else {//If item is an accessory
            switch(choiceOfItem) {
                case 1 : return "Passport";
                case 2 : return "Laptop";
                case 3 : return "Book";
                default: throw new IllegalArgumentException("Invalid accessory choice");
            }
        }
    }
                            
                    
                    
    /**
     * Prompts the user to choose an item and validates their input.
     * 
     * @param itemType an integer representing the type of item
     *                 (1 for clothing, 2 for accessory).
     * @param itemGender a char representing the gender for the item
     *                  ('M' for male, 'F' for female).
     * @param scanner a Scanner instance for capturing the user's input.
     * @return the user's validated choice as an integer
     */
    private static int validateChoiceOfItem(int itemType,char itemGender,Scanner scanner) {
        //Set accepted range of int choices depending of if the item is a piece of clothing or an accessory
        int minRange = 1;
        int maxRange;
        if (itemType == 1) {//Item is a piece of clothing
            //Account for the difference in choices depending on the previously selected gender of choice
            if (itemGender == 'M') {
                maxRange = 12;
            } else {
                maxRange = 13;
            }
        } else {//Item is an accessory
            maxRange = 3;
        }
        System.out.println("Enter your choice:");
        while (true) {
            try {
                int choiceOfItem = scanner.nextInt();
                scanner.nextLine();
                if (choiceOfItem < minRange || choiceOfItem > maxRange) {//If item is not in the accepted range  
                    System.out.println("Invalid input. Give me an integer ranging from "+minRange+" to "+maxRange+".");
                } else {//Item is in the accepted range
                    return choiceOfItem;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please give me a valid integer");
                scanner.nextLine();
            }
        }
    }

        /**
        * Prompts the user to choose the gender of the clothing item.
        *
        * @param scanner a Scanner instance for capturing the user's input.
        * @return a char representing the user's choice of gender
        *         ('M' for male, 'F' for female).
        */
    protected static char setGender(Scanner scanner) {
        System.out.println("Please enter your gender: (M for Male, F for Female)");
        char sex;
        while (true) { // Infinite loop until valid input is provided
            String input = scanner.nextLine().trim(); // Read the entire line and trim whitespace
            if (input.isEmpty()) { // Check for empty input
                System.err.println("No input detected. Please enter 'M' for Male or 'F' for Female.");
                continue; // Prompt user again
            }
            if (input.length() == 1) { // Ensure input is a single character
                sex = input.toUpperCase().charAt(0);
                    if (sex == 'M' || sex == 'F') {
                        return sex;
                    }
            }
            System.err.println("Invalid input. Please enter 'M' for Male or 'F' for Female.");
            }
    }

    /**
    * Prompts the user to choose the item's size.
    *
    * @param scanner a Scanner instance for capturing the user's input.
    * @return a char representing the user's choice of size
    *         (S for Small, M for Medium, L for Large).
    */
    protected static char setSize(Scanner scanner) {
        System.out.println("Please enter your desired size: (S for Small, M for Medium, L for Large)");
        while (true) {//Infinite loop until valid input is provided
            String input = scanner.nextLine().trim();//Read the entire line and trim whitespace
            if (input.isEmpty()) {//Check for empty input
                System.err.println("No input detected. Please enter 'S' for Small or 'M' for Medium or 'L' for Large.");
                continue;//Prompt user again
            } else if (input.length() == 1 && (input.charAt(0) == 'S' || input.charAt(0) == 'M' || input.charAt(0) == 'L')) {
                return input.charAt(0);//Return valid size
            } else {
                System.err.println("Invalid input. Please enter 'S' for Small or 'M' for Medium or 'L' for Large.");
            }   
        }   
    }
        
    /**
     * Inputs the user's choice of Item in ArrayList PackingItem according to the user's previous choices of 
     * Item type, choice, sex and size
     * 
     * @param items representing the essential clothing and what not items
     * @param type representing the type of item (example -> jacket)
     * @param choiceOfItem representing if the item is a piece of clothing (1) or an accessory (2)
     * @param sex representing the selected gender if the item is a piece of clothing ("X" if it isn't)
     * @param size representing the selected size (Small||Medium||Large)
     */
    
    protected static void inputItem(ArrayList<PackingItem> items, int type, String choice, char sex, char size) {
        if (type == 1) {
            Clothing pack = new Clothing(choice, size, sex);
            items.add(pack);
        } else {
            Extras pack = new Extras(choice);
            items.add(pack);
        }
    }

    protected static void inputItem(ArrayList<PackingItem> items, int type, String choice, char sex, char size, int value) {
        if (type == 1) {
            Clothing pack = new Clothing(value, choice, size, sex);
            items.add(pack);
        } else {
            Extras pack = new Extras(value, choice);
            items.add(pack);
        }
    }
 
}
