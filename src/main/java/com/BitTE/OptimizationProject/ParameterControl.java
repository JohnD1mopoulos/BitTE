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
        * Used to return the weight that has been added to the knapsack
        *
        * @param items ArrayList representing the Knapsack 
        * @return Double variable that represents difference between the maximum weight value and the current weight value
        */
        protected static double checkWeight(ArrayList<PackingItem> items){
           double totalWeight= 0;
           for (int i =0; i < items.size(); i++){
            totalWeight += items.get(i).getWeight();
           }
           return totalWeight;
        }
        
        /**
        * Used to return the volume that has been added to the knapsack
        *
        * @param  items ArrayList representing the Knapsack 
        * @return Double variable that represents difference between the maximum weight value and the current weight value
        */
        protected static double checkVolume(ArrayList<PackingItem> items){
            double totalVolume= 0;
            for (int i =0; i < items.size(); i++){
             totalVolume += items.get(i).getVolume();
            }
            return totalVolume;
        }

        /**
        * Used to return the remaining weight that can be added to the knapsack
        *
        * @param  MaxWeight representing the maximum weigth that can be added to the knapsack
        * @param @param items ArrayList representing the knapsack
        * @return Double value representing difference between the maximum weight value and the current weight value
        */
        protected static double getRemainingWeight(double MaxWeight,ArrayList<PackingItem> items ){
           return  MaxWeight - checkWeight(items);
        }

        /**
        * Used to return the remaining volume that can be added to the knapsack
        *
        * @param  MaxVolume representing the maximum volume that can be added to the knapsack
        * @param items ArrayList representing the knapsack
        * @return Double value representing difference between the maximum volume value and the current volume value
        */
        protected static double getRemainingVolume(double MaxVolume, ArrayList<PackingItem> items){
           return MaxVolume - checkVolume(items);
        }

        /**
        * Used to return correspoding values depending on the state of the knapsack's weight and volume
        *and their respective constraints
        *
        * @param MaxVolume representing the maximum volume that can be added to the knapsack
        * @param MaxWeight representing the maximum weigth that can be added to the knapsack
        * @param items ArrayList representing knapsack so that i can call methods
        * getRemainingWeight and getRemainingVolume
        * @return int value representing the current state of the constraints
        *         1 - both weight and volume constraints are respected,
        *         2 - only weight constraint is respected,
        *         3 - only volume constraint is respected,
        *         4 - neither constraint is respected.
        */
        protected static int checkConstraints(double MaxWeight, double MaxVolume, ArrayList<PackingItem> items) {

            boolean weightConstraintRespected = getRemainingWeight(MaxWeight, items) >= 0;
            boolean volumeConstraintRespected = getRemainingVolume(MaxVolume, items) >= 0;
            
            //Return appropriate value for each scenario 
            if (weightConstraintRespected && volumeConstraintRespected){
                return 1;//Both constraints respected
            }else if (weightConstraintRespected){
                return 2;//Only weight constraint respected
            }else if (volumeConstraintRespected){
                return 3;//Only volume constraint respected
            }else {
                return 4;//No constraint respected
            }
        }

        /**
        * Used to show all items that have already been added to the Knapsack 
        *
        * @param items ArrayList representing the Knapsack 
        */
        protected static void showItems(ArrayList<PackingItem> items){
            if (items == null || items.isEmpty()) {
                System.out.println("The Knapsack is empty. No items to display!");
                return;
            }
            for (int i =0; i < items.size(); i++){
                System.out.println((i+1) + ") " + items.get(i));//Print a number for each item for an easier read
            }
        }

        /**
         * 
         * Used to show the appropriate clothing menu depending on user's gender of choice for the item
         * 
         * @param gender of type char representing said choice
         */
        protected static void clothingdMenu(char gender) {
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
                                    +"Press 11 to add Boots"
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
        private static int setTypeOfItem() {
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
        *          1 for clothing, or 2 for an accessory
        * @return  An integer representing the user's item of choice
        */
        protected static int setItemChoice(int itemType,char itemGender) {
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
                    choiceOfItem = scanner.nextInt();
                    scanner.nextLine();//Clear the newline character
                    if (choiceOfItem < minRange || choiceOfItem > maxRange) {//If item is not in the accepted range
                        System.out.println("Invalid input. Give me an integer ranging from "+minRange+" to "+maxRange+".");
                    } else {//Item is in the accepted range
                        return choiceOfItem;
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
         * @param items
         * @param type
         * @param choice
         * @param sex
         * @param size
         */
        //TODO: Write the appropriate piece of code according to the Data Engineers instructions
        protected static void inputItem(ArrayList<PackingItem> items, int type, int choice, char sex, char size) {

        }

        
        /**
        * Deletes a number of items from ArrayList essentialItems depending on the user's input
        *
        * @param items ArrayList representing the Knapsack 
        */
        protected static void deleteItem(ArrayList<PackingItem> items, Scanner scanner) {
            while (true) {
                // Check if there are items to delete
                if (items.isEmpty()) {
                    System.err.println("No items available to delete.");
                    return; // Exit the method
                }
        
                // Display available items
                System.out.println("You can delete the following items:");
                showItems();
        
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
