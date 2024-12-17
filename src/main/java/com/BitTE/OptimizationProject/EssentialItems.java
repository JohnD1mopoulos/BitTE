package main.java.com.BitTE.OptimizationProject;

/**
 * Represents a dynamic knapsack used to store items, both essential and non-essential.
 
 * The knapsack is designed to operate under specific weight and volume constraints. 
 * If these constraints are not met during the addition of items, the operation 
 * may terminate or fail to add the item depending on if the item is or isn't essential.
 
 * This class can dynamically adjust to accommodate different types of items, 
 * ensuring efficient use of available space and weight capacity.
 */

import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

 class Knapsack{
    /**  Static ArrayList shared across all methods in this class representing one
    "Knapsack" for the seential items*/
    protected static final ArrayList<PackingItem> essentialItems = new ArrayList<>();
    //Scanner object for user to input choices
    private static Scanner scanner = new Scanner(System.in);

    /**
     * Prompts the user to pick between adding another essential item to the Knapsack and terminating the 
     * adding procedure
     * 
     * @return a boolean value (true if another item is to be added or false if the procedure is to be terminated)
     */
    private boolean continueAdding() {

    }
 
    /**
     * Provides the user with feedback based on the constraints
     * 
     * @param stateOfConstraints which describes the current state of the constraints
     *                             1 - if both constraints are respected
     *                             2 - if only the weight constraint is respected
     *                             3 - if only the volume constraint is respected
     *                             4 - if no constraints are respected
     */
    private void constraintFeedback() {

    }

    /**
     * Prompts the user between terminating the procedure and deleting as many items as he wishes or are needed
     * to continue the process of adding essential items to the knapsack.
     * 
     * @param 
     */
    private void fixConstraints() {

    }



   
    /**
    * Fills ArrayList essentialItems with the inputs of the user and confirms if the constraints are met with each added item
    *
    * @param s The Weight and Volume of the knapsack
    * @return A boolean variable that confirms the continuation of the operation if the constraints are still met.
    */

    // TODO: Impliment the work of the Data Engineers when they're done with T-SQL
    // TODO: Make it possible for the user to remove items from the knapsack in the begining of the loop
    private static boolean fillEssential(double maxWeight, double maxVolume){
        
        System.out.println("Dear user, please choose the items that are essential to you: ");
        boolean processRunning = true;

        while (processRunning){
            //Display MENU for choosing type of Item
            System.out.println("Press 1 to add Clothing\n"
                              +"Press 2 to add Accessory");
                              //Press 3 to remove item
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
            String itemOfChoice = ParameterControl.setItemChoice(inputType, itemGender, scanner);

            //Choose the item's size
            char itemSize = ParameterControl.setSize(scanner);

            //Input item 
            ParameterControl.inputItem(essentialItems, scanner);

            //Check constraints
            int constraintsMet = ParameterControl.checkConstraints(maxWeight, maxVolume, essentialItems);

            //Provide feedback based on constraints
            switch (constraintsMet){
                case 1: //Constraints respected
                        System.out.println("You still have "+ParameterControl.getRemainingWeight(MaxWeight,essentialItems)+" available kgs"
                        +"and "+ParameterControl.getRemainingVolume(maxVolume,essentialItems)+" available cm3.");
                        break;
                case 2: //Volume constraint not respected
                        System.out.println("You still have "+ParameterControl.getRemainingWeight(maxWeight,essentialItems)+" available kgs"
                        +"and have surpassed the maximum volume by"+(-ParameterControl.getRemainigVolume(maxVolume,essentialItems))+" by cm3.");
                        break;
                case 3: //Weight constraint not respected
                        System.out.println("You have surpassed the maximum weigth by "+(-ParameterControl.getRemainingWeight(maxWeight,essentialItems))
                        +"kgs. But you still have "+ParameterControl.getRemainigVolume(maxVolume,essentialItems)+" available cm3.");   
                        break;
                case 4: //Both constraints not respected
                        System.out.println("You have surpassed the maximum weigth by "+(-ParameterControl.getRemainingWeight(maxWeight,essentialItems))
                        +"kgs. You also have surpassed the maximum volume by"+(-ParameterControl.getRemainingVolume(maxVolume,essentialItems))
                        +" by cm3.");
                        break;   
            }

            //Handle different constraint scenarios
            if (constraintsMet != 1){//Constraints arent met
                System.out.println("Press 1 to terminate process.\n"
                                  +"Press 2 to remove item");
                boolean validChoice;
                while (!validChoice){
                    try {
                        int userChoice = scanner.nextInt();
                        scanner.nextLine();
                        if (userChoice == 1){
                            return false;//Knapsack wasnt filled 
                        } else if (userChoice == 2){
                            ParameterControl.deleteItem(essentialItems, scanner);
                            validChoice = true;//stop loop
                        } else {
                            System.err.println("Invalid choice. Please enter 1 or 2");
                        }
                    } catch (InputMismatchException e){
                         System.err.println("Invalid input. Please enter a valid integer.");
                         scanner.nextLine();
                    }
                }
            } else {//Constraints are met
                
                System.out.println("Press 1 to terminate process.\n"
                                  +"Press 2 to add another item");
                
                 boolean validChoice;
                 while (!validChoice){
                     try {
                         int userChoice = scanner.nextInt();
                         scanner.nextLine();
                         if (userChoice == 1){
                            System.out.println("All esential items have been added!!!");
                             return true;//Knapsack was filled 
                        } else if (userChoice == 2) {
                             validChoice = true;//Continue adding items
                        } else {
                            System.err.println("Invalid choice. Please press 1 or 2.");
                        }
                     } catch (InputMismatchException e){
                             System.err.println("Invalid input. Please enter a valid integer.");
                             scanner.nextLine();
                     }
                 }
            
            }
        } 
        return false;//Unrechable code. Was put according to good practices 
    }
 }