package main.java.com.BitTE.OptimizationProject;

/**
 * Created to contain all methods used for constraint control
 
 * This class will be effective in arranging the "workspace" ensuring efficient workflow.
 */

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

 class ParameterControl {

        /**
        * Used to show all items that have already been added to the Knapsack 
        *
        * @param items ArrayList representing the Knapsack 
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
         * 
         * Used to show the appropriate clothing menu depending on user's gender of choice for the item
         * 
         * @param gender of type char representing said choice
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
         * 
         * Used to show the extras menu 
         */
        protected static void extrasMenu() {
            System.out.println("Press 1 to add Passport\n"
                                +"Press 2 to add Computer\n"
                                +"Press 3 to add Book");
        }

        /**
        * Prompts the user to choose between inputting a clothing item or an accessory.
        *
        * This method ensures robust handling of user input, allowing only valid integers (1 or 2) as choices.
        * If the input is invalid, the user is repeatedly prompted until a valid input is provided.
        *
        * @return An integer representing the user's choice:
        *         1 for clothing, or 2 for an accessory.
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
        * Prompts the user to choose pick what item he wants to input depending on if it's a clothing
        * item or an accessory
        * 
        * @param type representing the user's previous choice for the type of item he will be inputting
        *             1 for clothing, or 2 for an accessory
        * @param itemGender representing the user's choice of gender
        *
        * @return  The user's choice as a String
        */
        //TODO: Add the piece of code for if the item is an accessory
        //TODO: Create method for the input validation logic
        protected static String setItemChoice(int itemType,char itemGender,Scanner scanner) {
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
            while (true) {
                try {
                    int choiceOfItem = scanner.nextInt();
                    scanner.nextLine();//Clear the newline character
                    if (choiceOfItem < minRange || choiceOfItem > maxRange) {//If item is not in the accepted range
                        System.out.println("Invalid input. Give me an integer ranging from "+minRange+" to "+maxRange+".");
                    } else {//Item is in the accepted range
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
                                }
                            }
                        } else {//If item is an accessory
                               ///The code
                        }
                    }
                } catch (InputMismatchException e) {
                    System.err.println("Invalid input. Please select a valid integer");
                    scanner.nextLine();
                }
            }
        }

        /**
        * Used to set the user's gender
        *
        * @param scanner for user's input
        * @return Sex variabe of type char representing the user's gender
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
        * Used to set the user's desired size
        *
        * @param scanner for user's input
        * @return Size variabe of type char representing the user's choice of size
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
         * @param choice representing if the item is a piece of clothing (1) or an accessory (2)
         * @param sex representing the selected gender if the item is a piece of clothing ("X" if it isn't)
         * @param size representing the selected size (Small||Medium||Large)
         */
        //TODO: Write the appropriate piece of code according to the Data Engineers instructions
        protected static void inputItem(ArrayList<PackingItem> items, String type, int choice, char sex, char size) {
            if (choice == 1) {
                items.add(new Clothing(type, size , sex));
            }
        }

        
        /**
        * Deletes a number of items from ArrayList essentialItems depending on the user's input
        *
        * @param items ArrayList representing the Knapsack 
        */
        //TODO: Create method for the input of items
        //TODO: Create method continue deleting or stop deleting
        protected static void deleteItem(ArrayList<PackingItem> items, Scanner scanner) {
            while (true) {
                // Check if there are items to delete
                if (items.isEmpty()) {
                    System.err.println("No items available to delete.");
                    return; // Exit the method
                }
        
                // Display available items
                System.out.println("You can delete the following items:");
                showItems(items);
        
                // Prompt the user to choose an item to delete
                System.out.println("Which one do you want to delete? (Press 0 to cancel)");
        
                int choice1 = -1; // Variable representing the item to be deleted
                try {
                    choice1 = scanner.nextInt();
                    scanner.nextLine(); 
        
                    if (choice1 == 0) {
                        System.out.println("Stopping deletion of items.");
                        return; // Exit the method
                    } else if (choice1 < 1 || choice1 > items.size()) {
                        System.err.println("Invalid choice. Please select a valid item number.");
                        continue; // Restart the loop
                    }
        
                    // Delete the chosen item
                    System.out.println("Item no " + choice1 + " (" + items.get(choice1 - 1) + ") has been deleted.");
                    items.remove(choice1 - 1);

                } catch (InputMismatchException e) {
                    System.err.println("Invalid input. Please enter a valid integer.");
                    scanner.nextLine(); 
                    continue;//Restart the loop
                }
        
                // Ask the user if they want to delete another item
                System.out.println("Press 1 to delete another item.\nPress 2 to stop deleting items.");
                int choice2 = -1;//Variable representing choice to continue or stop method
        
                while (true) {
                    try {
                        choice2 = scanner.nextInt();
                        scanner.nextLine(); 
        
                        if (choice2 == 1) {//Continue deleting items
                            break;
                        } else if (choice2 == 2) {
                            System.out.println("Stopping deletion process.");
                            return;//Exit the method
                        } else {
                            System.err.println("Invalid choice. Please press 1 to delete another item or 2 to stop.");
                        }
                    } catch (InputMismatchException e) {
                        System.err.println("Invalid input. Please enter 1 or 2.");
                        scanner.nextLine();
                    }
                }
            }
        }    
}
