package main.java.com.BitTE.OptimizationProject;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.function.Function;

/**
 * The {@code EssentialConstraints} class contains methods for managing and checking 
 * the constraints of the optimization problem. It provides functionality 
 * for calculating the sum of item attributes (weight and volume), checking if 
 * the knapsack's constraints (weight and volume) are respected, providing feedback 
 * to the user about constraint violations, and handling the process of fixing 
 * constraint violations by allowing the user to delete items or terminate the process.
 */
protected class EssentialConstraints {
    
    /**
   * Calculates the sum of a specified attribute for a list of `PackingItem` objects.
   * This method takes a list of items and a function that extracts a numeric attribute
   * from each `PackingItem` and sums them up.
   * 
   * @param items a list of `PackingItem` objects to calculate the sum of attributes from.
   * @param attributeGetter a function that extracts the numeric attribute from a `PackingItem`.
   *                        The function takes a `PackingItem` and returns a `Double` representing
   *                        the attribute value to be summed.
   * @return the sum of the attribute values extracted from each `PackingItem`.
   */
    private static double calculateSumOfAttributes(ArrayList<PackingItem> items, Function<PackingItem, Double> attributeGetter) {
        double sum = 0;

        for (PackingItem item : items) {
            sum += attributeGetter.apply(item);
        }
        return sum;
    }

    /**
    * Used to return correspoding values depending on the state of the knapsack's weight and volume
    * and their respective constraints.
    *
    * @param items a PackingItem ArrayList to call calculateSumOfAttributes method on.
    * @param maxVolume representing the maximum volume that can be added to the knapsack.
    * @param maxWeight representing the maximum weight that can be added to the knapsack.
    * @return int value representing the current state of the constraints:
    *         1 - both weight and volume constraints are respected,
    *         2 - only weight constraint is respected,
    *         3 - only volume constraint is respected,
    *         4 - neither constraint is respected.
    */
    protected static int checkConstraints(ArrayList<PackingItem> items, 
                                         double maxWeight,
                                         double maxVolume) {
        double totalWeight = calculateSumOfAttributes(items, PackingItem::getWeight);
        double totalVolume = calculateSumOfAttributes(items, PackingItem::getVolume);

        //Return appropriate value for each scenario 
        if (totalWeight <= maxWeight && totalVolume <= maxVolume) {
            return 1;//Both constraints respected
        }else if (totalWeight <= maxWeight) {
            return 2;//Only weight constraint respected
        }else if (totalVolume <= maxVolume) {
            return 3;//Only volume constraint respected
        }else {
            return 4;//No constraint respected
        }

    }

    /**
    * Provides the user with feedback based on the constraints
    * 
    * @param items a PackingItem ArrayList representing the list of chosen essential items.
    * @param stateOfConstraints which describes the current state of the constraints
    *                             1 - if both constraints are respected,
    *                             2 - if only the weight constraint is respected,
    *                             3 - if only the volume constraint is respected,
    *                             4 - if no constraints are respected.
    * @param maxVolume representing the maximum volume that can be added to the knapsack.
    * @param maxWeight representing the maximum weight that can be added to the knapsack.
    */
    private static void constraintFeedback(ArrayList<PackingItem> items,
                                        int stateOfConstraints,
                                        double maxWeight,
                                        double maxVolume ) {
        
        double remainingWeight = maxWeight - calculateSumOfAttributes(items, PackingItem::getWeight);
        double remainingVolume = maxVolume - calculateSumOfAttributes(items, PackingItem::getVolume);

        switch (stateOfConstraints) {
            case 1 -> System.out.printf("You have %.2f kg and %.2f cm³ available.%n",
                                        remainingWeight, remainingVolume);
            case 2 -> System.out.printf("You have %.2f kg left but exceeded "
                                        +"volume by %.2f cm³.%n\n"
                                        +"You have to delete items to continue the process", 
                                         remainingWeight, -remainingVolume);
            case 3 -> System.out.printf("You exceeded weight by %.2f kg"
                                        +" but have %.2f cm³ left.%n\n"
                                        +"You have to delete items to continue the process", 
                                         -remainingWeight, remainingVolume);
            case 4 -> System.out.printf("You exceeded weight by %.2f kg"
                                        +" and volume by %.2f cm³.%n"
                                        +"You have to delete items to continue the process", 
                                         -remainingWeight, -remainingVolume);
        }
    }

    /**
    * Gets called if the constraints are not being respected
    * Prompts the user between terminating the procedure and deleting as many items as he wishes or are needed
    * to continue the process of adding essential items to the knapsack.
    *
    * @param items a PackingItem ArrayList representing the list of chosen essential items.
    * @param scanner a Scanner instance for capturing the user's input.
    * @param maxVolume representing the maximum volume that can be added to the knapsack.
    * @param maxWeight representing the maximum weight that can be added to the knapsack.
    * @return false if the process is terminated, true if items were deleted successfully.
    */
    protected static boolean fixConstraints(ArrayList<PackingItem> items,
                                        Scanner scanner,
                                        double maxWeight,
                                        double maxVolume) {

        System.out.println("Press 1 to terminate process.\n"
                            +"Press 2 to remove item(s)");
    
        boolean validChoice;
        while (!validChoice){
        try {
            System.out.println("Enter your choice:");
            int userChoice = scanner.nextInt();
            scanner.nextLine();
        
            if (userChoice == 1) {
                return false;//Terminate process
            } else if (userChoice == 2) {
                ItemDeletionHandler.deleteItem(items, scanner);

                //Recheck constraints
                int constraintsRespected = checkConstraints(items, maxWeight, maxVolume);
                if (constraintsRespected == 1) {//Constraints are respected
                    validChoice = true;//Exit loop
                } else {//Constraints aren't respected
                    constraintFeedback(items, constraintsRespected, maxWeight, maxVolume);
                }//Restart the loop after the above message

            } else {
                System.err.println("Invalid choice. Please enter 1 or 2");
            }

        } catch (InputMismatchException e){
            System.err.println("Invalid input. Please enter a valid integer.");
            scanner.nextLine();
        }
        }
        return true;//items where deleted successfully
    }       
}
