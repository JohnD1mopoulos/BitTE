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
    // Static ArrayLists shared across all methods in this class
    protected static final ArrayList<PackingItem> essentialItems = new ArrayList<>();//Using PackingItem as data type 
    private static final ArrayList<PackingItem> nonEssentialItems = new ArrayList<>();//allowing polymorphism
    //Scanner object for user to input choices
    private static Scanner scanner = new Scanner(System.in);
    //Static variables represent the allowable weigth in kilos and the volume in cubic meters of the suitcase
    private static double MaxWeight;
    private static double MaxVolume;

    //Method which asks the customer about the dimensions of the suitcase and calculates the volume 
    private static void SuitcaseCharacteristics() {

        System.out.print("Enter the desired weight of the suitcase (in kilograms): ");
            MaxWeight = scanner.nextDouble();
        System.out.print("Enter the length of the suitcase (in meters): ");
            double length = scanner.nextDouble();
        System.out.print("Enter the width of the suitcase (in meters): ");
            double width = scanner.nextDouble();
        System.out.print("Enter the height of the suitcase (in meters): ");
            double height = scanner.nextDouble();
        //Calculating volume
        MaxVolume = length * width * height;
    }

   
    /**
    * Fills ArrayList essentialItems with the inputs of the user and confirms if the constraints are met with each added item
    *
    * @param s The Weight and Volume of the knapsack
    * @return A boolean variable that confirms the continuation of the operation if the constraints are still met.
    */

    // TODO: Impliment the work of the Data Engineers when they're done with T-SQL
    private static boolean fillEssential(double MaxWeight, double MaxVolume){
        
        System.out.println("Dear user, please choose the items that are essential to you: ");
        boolean processRunning = true;

        while (processRunning){
            //Display MENU for choosing type of Item
            System.out.println("Press 1 to add Clothing\n"
                                +"Press 2 to add Accessory");
            //Make choice 
            int inputType = ParameterControl.setTypeOfItem;

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
            int itemOfChoice = ParameterControl.setItemChoice(inputType, itemGender);

            //Choose the item's size
            char itemSize = ParameterControl.setSize(scanner);

            //Input item 
            ParameterControl.inputItem(essentialItems, scanner);

            //Check constraints
            int constraintsMet = ParameterControl.checkConstraints(MaxWeight, MaxVolume, essentialItems);

            //Provide feedback based on constraints
            switch (constraintsMet){
                case 1: //Constraints respected
                        System.out.println("You still have "+ParameterControl.getRemainingWeight(MaxWeight)+" available kgs"
                        +"and "+ParameterControl.getRemainigVolume(MaxVolume)+" available cm3.");
                        break;
                case 2: //Volume constraint not respected
                        System.out.println("You still have "+ParameterControl.getRemainingWeight(MaxWeight)+" available kgs"
                        +"and have surpassed the maximum volume by"+(-ParameterControl.getRemainigVolume(MaxVolume))+" by cm3.");
                        break;
                case 3: //Weight constraint not respected
                        System.out.println("You have surpassed the maximum weigth by "+(-ParameterControl.getRemainingWeight(MaxWeight))
                        +"kgs. But you still have "+ParameterControl.getRemainigVolume(MaxVolume)+" available cm3.");   
                        break;
                case 4: //Both constraints not respected
                        System.out.println("You have surpassed the maximum weigth by "+(-ParameterControl.getRemainingWeight(MaxWeight))
                        +"kgs. You also have surpassed the maximum volume by"+(-ParameterControl.getRemainigVolume(MaxVolume))
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
                            System.out.println("Invalid choice. Please enter 1 or 2");
                        }
                    } catch (InputMismatchException e){
                         System.out.println("Invalid input. Please enter a valid integer.");
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
                            System.err.println("INvalid choice. Please press 1 oe 2.");
                        }
                     } catch (InputMismatchException e){
                             System.out.println("Invalid input. Please enter a valid integer.");
                             scanner.nextLine();
                     }
                 }
            
            }
        } 
        return false;//Unrechable code. Was put according to good practices 
    }
 }